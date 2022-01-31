package android.support.constraint.solver;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem
{
  private static final boolean DEBUG = false;
  public static final boolean FULL_DEBUG = false;
  private static int POOL_SIZE = 1000;
  public static Metrics sMetrics;
  private int TABLE_SIZE = 32;
  public boolean graphOptimizer = false;
  private boolean[] mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
  final Cache mCache;
  private Row mGoal;
  private int mMaxColumns = this.TABLE_SIZE;
  private int mMaxRows = this.TABLE_SIZE;
  int mNumColumns = 1;
  int mNumRows = 0;
  private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
  private int mPoolVariablesCount = 0;
  ArrayRow[] mRows = null;
  private final Row mTempGoal;
  private HashMap<String, SolverVariable> mVariables = null;
  int mVariablesID = 0;
  private ArrayRow[] tempClientsCopy = new ArrayRow[this.TABLE_SIZE];
  
  public LinearSystem()
  {
    releaseRows();
    this.mCache = new Cache();
    this.mGoal = new GoalRow(this.mCache);
    this.mTempGoal = new ArrayRow(this.mCache);
  }
  
  private SolverVariable acquireSolverVariable(SolverVariable.Type paramType, String paramString)
  {
    SolverVariable localSolverVariable = (SolverVariable)this.mCache.solverVariablePool.acquire();
    if (localSolverVariable == null)
    {
      localSolverVariable = new SolverVariable(paramType, paramString);
      localSolverVariable.setType(paramType, paramString);
    }
    for (paramType = localSolverVariable;; paramType = localSolverVariable)
    {
      if (this.mPoolVariablesCount >= POOL_SIZE)
      {
        POOL_SIZE *= 2;
        this.mPoolVariables = ((SolverVariable[])Arrays.copyOf(this.mPoolVariables, POOL_SIZE));
      }
      paramString = this.mPoolVariables;
      int i = this.mPoolVariablesCount;
      this.mPoolVariablesCount = (i + 1);
      paramString[i] = paramType;
      return paramType;
      localSolverVariable.reset();
      localSolverVariable.setType(paramType, paramString);
    }
  }
  
  private void addError(ArrayRow paramArrayRow)
  {
    paramArrayRow.addError(this, 0);
  }
  
  private final void addRow(ArrayRow paramArrayRow)
  {
    if (this.mRows[this.mNumRows] != null) {
      this.mCache.arrayRowPool.release(this.mRows[this.mNumRows]);
    }
    this.mRows[this.mNumRows] = paramArrayRow;
    paramArrayRow.variable.definitionId = this.mNumRows;
    this.mNumRows += 1;
    paramArrayRow.variable.updateReferencesWithNewDefinition(paramArrayRow);
  }
  
  private void addSingleError(ArrayRow paramArrayRow, int paramInt)
  {
    addSingleError(paramArrayRow, paramInt, 0);
  }
  
  private void computeValues()
  {
    int i = 0;
    while (i < this.mNumRows)
    {
      ArrayRow localArrayRow = this.mRows[i];
      localArrayRow.variable.computedValue = localArrayRow.constantValue;
      i += 1;
    }
  }
  
  public static ArrayRow createRowCentering(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramBoolean) {
      localArrayRow.addError(paramLinearSystem, 4);
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowDimensionPercent(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    if (paramBoolean) {
      paramLinearSystem.addError(localArrayRow);
    }
    return localArrayRow.createRowDimensionPercent(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramFloat);
  }
  
  public static ArrayRow createRowEquals(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, 1);
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowGreaterThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F));
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowLowerThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F));
    }
    return localArrayRow;
  }
  
  private SolverVariable createVariable(String paramString, SolverVariable.Type paramType)
  {
    if (sMetrics != null)
    {
      Metrics localMetrics = sMetrics;
      localMetrics.variables += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    paramType = acquireSolverVariable(paramType, null);
    paramType.setName(paramString);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    paramType.id = this.mVariablesID;
    if (this.mVariables == null) {
      this.mVariables = new HashMap();
    }
    this.mVariables.put(paramString, paramType);
    this.mCache.mIndexedVariables[this.mVariablesID] = paramType;
    return paramType;
  }
  
  private void displayRows()
  {
    displaySolverVariables();
    String str = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      str = str + this.mRows[i];
      str = str + "\n";
      i += 1;
    }
    str = str + this.mGoal + "\n";
    System.out.println(str);
  }
  
  private void displaySolverVariables()
  {
    String str = "Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n";
    System.out.println(str);
  }
  
  private int enforceBFS(Row paramRow)
  {
    int j = 0;
    int i = 0;
    if (i < this.mNumRows) {
      if ((this.mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED) || (this.mRows[i].constantValue >= 0.0F)) {}
    }
    for (i = 1;; i = 0)
    {
      int m;
      int i4;
      float f1;
      int k;
      int n;
      label114:
      int i3;
      int i2;
      int i1;
      float f2;
      label205:
      Object localObject;
      if (i != 0)
      {
        m = 0;
        i = 0;
        j = i;
        if (m == 0)
        {
          if (sMetrics != null)
          {
            paramRow = sMetrics;
            paramRow.bfs += 1L;
          }
          i4 = i + 1;
          f1 = 3.4028235E+38F;
          i = 0;
          j = -1;
          k = -1;
          n = 0;
          if (n < this.mNumRows)
          {
            paramRow = this.mRows[n];
            i3 = k;
            i2 = j;
            i1 = i;
            f2 = f1;
            if (paramRow.variable.mType != SolverVariable.Type.UNRESTRICTED)
            {
              i3 = k;
              i2 = j;
              i1 = i;
              f2 = f1;
              if (!paramRow.isSimpleDefinition)
              {
                i3 = k;
                i2 = j;
                i1 = i;
                f2 = f1;
                if (paramRow.constantValue < 0.0F)
                {
                  i1 = 1;
                  if (i1 < this.mNumColumns)
                  {
                    localObject = this.mCache.mIndexedVariables[i1];
                    float f3 = paramRow.variables.get((SolverVariable)localObject);
                    if (f3 <= 0.0F) {
                      break label521;
                    }
                    int i5 = 0;
                    i2 = k;
                    i3 = j;
                    j = i5;
                    k = i;
                    i = i3;
                    for (;;)
                    {
                      if (j < 7)
                      {
                        f2 = localObject.strengthVector[j] / f3;
                        if (((f2 >= f1) || (j != k)) && (j <= k)) {
                          break label518;
                        }
                        i2 = i1;
                        i = n;
                        k = j;
                        f1 = f2;
                        label320:
                        j += 1;
                        continue;
                        i += 1;
                        break;
                      }
                    }
                    j = i2;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        i1 += 1;
        i2 = k;
        k = j;
        j = i;
        i = i2;
        break label205;
        f2 = f1;
        i1 = i;
        i2 = j;
        i3 = k;
        n += 1;
        k = i3;
        j = i2;
        i = i1;
        f1 = f2;
        break label114;
        if (j != -1)
        {
          paramRow = this.mRows[j];
          paramRow.variable.definitionId = -1;
          if (sMetrics != null)
          {
            localObject = sMetrics;
            ((Metrics)localObject).pivots += 1L;
          }
          paramRow.pivot(this.mCache.mIndexedVariables[k]);
          paramRow.variable.definitionId = j;
          paramRow.variable.updateReferencesWithNewDefinition(paramRow);
        }
        for (i = m;; i = 1)
        {
          if (i4 > this.mNumColumns / 2) {
            i = 1;
          }
          m = i;
          i = i4;
          break;
        }
        return j;
        label518:
        break label320;
        label521:
        i2 = j;
        i3 = i;
        j = k;
        i = i2;
        k = i3;
      }
    }
  }
  
  private String getDisplaySize(int paramInt)
  {
    int i = paramInt * 4 / 1024 / 1024;
    if (i > 0) {
      return i + " Mb";
    }
    i = paramInt * 4 / 1024;
    if (i > 0) {
      return i + " Kb";
    }
    return paramInt * 4 + " bytes";
  }
  
  private String getDisplayStrength(int paramInt)
  {
    if (paramInt == 1) {
      return "LOW";
    }
    if (paramInt == 2) {
      return "MEDIUM";
    }
    if (paramInt == 3) {
      return "HIGH";
    }
    if (paramInt == 4) {
      return "HIGHEST";
    }
    if (paramInt == 5) {
      return "EQUALITY";
    }
    if (paramInt == 6) {
      return "FIXED";
    }
    return "NONE";
  }
  
  public static Metrics getMetrics()
  {
    return sMetrics;
  }
  
  private void increaseTableSize()
  {
    this.TABLE_SIZE *= 2;
    this.mRows = ((ArrayRow[])Arrays.copyOf(this.mRows, this.TABLE_SIZE));
    this.mCache.mIndexedVariables = ((SolverVariable[])Arrays.copyOf(this.mCache.mIndexedVariables, this.TABLE_SIZE));
    this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
    this.mMaxColumns = this.TABLE_SIZE;
    this.mMaxRows = this.TABLE_SIZE;
    if (sMetrics != null)
    {
      Metrics localMetrics = sMetrics;
      localMetrics.tableSizeIncrease += 1L;
      localMetrics = sMetrics;
      localMetrics.maxTableSize = Math.max(localMetrics.maxTableSize, this.TABLE_SIZE);
      localMetrics = sMetrics;
      localMetrics.lastTableSize = localMetrics.maxTableSize;
    }
  }
  
  private final int optimize(Row paramRow, boolean paramBoolean)
  {
    Object localObject;
    if (sMetrics != null)
    {
      localObject = sMetrics;
      ((Metrics)localObject).optimize += 1L;
    }
    int i = 0;
    int m;
    ArrayRow localArrayRow;
    for (;;)
    {
      if (i < this.mNumColumns)
      {
        this.mAlreadyTestedCandidates[i] = false;
        i += 1;
        continue;
        if (m >= 0)
        {
          localArrayRow = this.mRows[m];
          localArrayRow.variable.definitionId = -1;
          if (sMetrics != null)
          {
            Metrics localMetrics = sMetrics;
            localMetrics.pivots += 1L;
          }
          localArrayRow.pivot((SolverVariable)localObject);
          localArrayRow.variable.definitionId = m;
          localArrayRow.variable.updateReferencesWithNewDefinition(localArrayRow);
        }
      }
    }
    for (;;)
    {
      int k = i;
      if (j == 0)
      {
        if (sMetrics != null)
        {
          localObject = sMetrics;
          ((Metrics)localObject).iterations += 1L;
        }
        i += 1;
        if (i >= this.mNumColumns * 2) {
          k = i;
        }
      }
      else
      {
        return k;
      }
      if (paramRow.getKey() != null) {
        this.mAlreadyTestedCandidates[paramRow.getKey().id] = true;
      }
      localObject = paramRow.getPivotCandidate(this, this.mAlreadyTestedCandidates);
      if (localObject != null)
      {
        if (this.mAlreadyTestedCandidates[localObject.id] != 0) {
          return i;
        }
        this.mAlreadyTestedCandidates[localObject.id] = true;
      }
      if (localObject != null)
      {
        float f1 = 3.4028235E+38F;
        m = -1;
        k = 0;
        while (k < this.mNumRows)
        {
          localArrayRow = this.mRows[k];
          int n = m;
          float f2 = f1;
          if (localArrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED)
          {
            n = m;
            f2 = f1;
            if (!localArrayRow.isSimpleDefinition)
            {
              n = m;
              f2 = f1;
              if (localArrayRow.hasVariable((SolverVariable)localObject))
              {
                float f3 = localArrayRow.variables.get((SolverVariable)localObject);
                n = m;
                f2 = f1;
                if (f3 < 0.0F)
                {
                  f3 = -localArrayRow.constantValue / f3;
                  n = m;
                  f2 = f1;
                  if (f3 < f1)
                  {
                    n = k;
                    f2 = f3;
                  }
                }
              }
            }
          }
          k += 1;
          m = n;
          f1 = f2;
        }
        break;
        j = 1;
        continue;
      }
      int j = 1;
      continue;
      i = 0;
      j = 0;
    }
  }
  
  private void releaseRows()
  {
    int i = 0;
    while (i < this.mRows.length)
    {
      ArrayRow localArrayRow = this.mRows[i];
      if (localArrayRow != null) {
        this.mCache.arrayRowPool.release(localArrayRow);
      }
      this.mRows[i] = null;
      i += 1;
    }
  }
  
  private final void updateRowFromVariables(ArrayRow paramArrayRow)
  {
    if (this.mNumRows > 0)
    {
      paramArrayRow.variables.updateFromSystem(paramArrayRow, this.mRows);
      if (paramArrayRow.variables.currentSize == 0) {
        paramArrayRow.isSimpleDefinition = true;
      }
    }
  }
  
  public void addCenterPoint(ConstraintWidget paramConstraintWidget1, ConstraintWidget paramConstraintWidget2, float paramFloat, int paramInt)
  {
    SolverVariable localSolverVariable1 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT));
    SolverVariable localSolverVariable3 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.TOP));
    SolverVariable localSolverVariable2 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT));
    SolverVariable localSolverVariable5 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM));
    paramConstraintWidget1 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
    SolverVariable localSolverVariable6 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
    SolverVariable localSolverVariable4 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
    paramConstraintWidget2 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowWithAngle(localSolverVariable3, localSolverVariable5, localSolverVariable6, paramConstraintWidget2, (float)(Math.sin(paramFloat) * paramInt));
    addConstraint(localArrayRow);
    paramConstraintWidget2 = createRow();
    paramConstraintWidget2.createRowWithAngle(localSolverVariable1, localSolverVariable2, paramConstraintWidget1, localSolverVariable4, (float)(Math.cos(paramFloat) * paramInt));
    addConstraint(paramConstraintWidget2);
  }
  
  public void addCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, int paramInt3)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramInt3 != 6) {
      localArrayRow.addError(this, paramInt3);
    }
    addConstraint(localArrayRow);
  }
  
  public void addConstraint(ArrayRow paramArrayRow)
  {
    int j = 1;
    if (paramArrayRow == null) {}
    label261:
    label266:
    for (;;)
    {
      return;
      Object localObject;
      if (sMetrics != null)
      {
        localObject = sMetrics;
        ((Metrics)localObject).constraints += 1L;
        if (paramArrayRow.isSimpleDefinition)
        {
          localObject = sMetrics;
          ((Metrics)localObject).simpleconstraints += 1L;
        }
      }
      if ((this.mNumRows + 1 >= this.mMaxRows) || (this.mNumColumns + 1 >= this.mMaxColumns)) {
        increaseTableSize();
      }
      int i;
      if (!paramArrayRow.isSimpleDefinition)
      {
        updateRowFromVariables(paramArrayRow);
        if (paramArrayRow.isEmpty()) {
          continue;
        }
        paramArrayRow.ensurePositiveConstant();
        if (paramArrayRow.chooseSubject(this))
        {
          localObject = createExtraVariable();
          paramArrayRow.variable = ((SolverVariable)localObject);
          addRow(paramArrayRow);
          this.mTempGoal.initFromRow(paramArrayRow);
          optimize(this.mTempGoal, true);
          i = j;
          if (((SolverVariable)localObject).definitionId == -1)
          {
            if (paramArrayRow.variable == localObject)
            {
              localObject = paramArrayRow.pickPivot((SolverVariable)localObject);
              if (localObject != null)
              {
                if (sMetrics != null)
                {
                  Metrics localMetrics = sMetrics;
                  localMetrics.pivots += 1L;
                }
                paramArrayRow.pivot((SolverVariable)localObject);
              }
            }
            if (!paramArrayRow.isSimpleDefinition) {
              paramArrayRow.variable.updateReferencesWithNewDefinition(paramArrayRow);
            }
            this.mNumRows -= 1;
            i = j;
          }
          label241:
          if (!paramArrayRow.hasKeyVariable()) {
            break label261;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label266;
        }
        addRow(paramArrayRow);
        return;
        i = 0;
        break label241;
        break;
        i = 0;
      }
    }
  }
  
  public ArrayRow addEquality(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt1);
    if (paramInt2 != 6) {
      localArrayRow.addError(this, paramInt2);
    }
    addConstraint(localArrayRow);
    return localArrayRow;
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt)
  {
    int i = paramSolverVariable.definitionId;
    if (paramSolverVariable.definitionId != -1)
    {
      localArrayRow = this.mRows[i];
      if (localArrayRow.isSimpleDefinition)
      {
        localArrayRow.constantValue = paramInt;
        return;
      }
      if (localArrayRow.variables.currentSize == 0)
      {
        localArrayRow.isSimpleDefinition = true;
        localArrayRow.constantValue = paramInt;
        return;
      }
      localArrayRow = createRow();
      localArrayRow.createRowEquals(paramSolverVariable, paramInt);
      addConstraint(localArrayRow);
      return;
    }
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowDefinition(paramSolverVariable, paramInt);
    addConstraint(localArrayRow);
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt1, int paramInt2)
  {
    int i = paramSolverVariable.definitionId;
    if (paramSolverVariable.definitionId != -1)
    {
      localArrayRow = this.mRows[i];
      if (localArrayRow.isSimpleDefinition)
      {
        localArrayRow.constantValue = paramInt1;
        return;
      }
      localArrayRow = createRow();
      localArrayRow.createRowEquals(paramSolverVariable, paramInt1);
      localArrayRow.addError(this, paramInt2);
      addConstraint(localArrayRow);
      return;
    }
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowDefinition(paramSolverVariable, paramInt1);
    localArrayRow.addError(this, paramInt2);
    addConstraint(localArrayRow);
  }
  
  public void addGreaterBarrier(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, 0);
    if (paramBoolean) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), 1);
    }
    addConstraint(localArrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable, int paramInt)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowGreaterThan(paramSolverVariable, paramInt, localSolverVariable);
    addConstraint(localArrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    if (paramInt2 != 6) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), paramInt2);
    }
    addConstraint(localArrayRow);
  }
  
  public void addLowerBarrier(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, 0);
    if (paramBoolean) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), 1);
    }
    addConstraint(localArrayRow);
  }
  
  public void addLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    if (paramInt2 != 6) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), paramInt2);
    }
    addConstraint(localArrayRow);
  }
  
  public void addRatio(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat, int paramInt)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowDimensionRatio(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramSolverVariable4, paramFloat);
    if (paramInt != 6) {
      localArrayRow.addError(this, paramInt);
    }
    addConstraint(localArrayRow);
  }
  
  void addSingleError(ArrayRow paramArrayRow, int paramInt1, int paramInt2)
  {
    paramArrayRow.addSingleError(createErrorVariable(paramInt2, null), paramInt1);
  }
  
  public SolverVariable createErrorVariable(int paramInt, String paramString)
  {
    if (sMetrics != null)
    {
      Metrics localMetrics = sMetrics;
      localMetrics.errors += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    paramString = acquireSolverVariable(SolverVariable.Type.ERROR, paramString);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    paramString.id = this.mVariablesID;
    paramString.strength = paramInt;
    this.mCache.mIndexedVariables[this.mVariablesID] = paramString;
    this.mGoal.addError(paramString);
    return paramString;
  }
  
  public SolverVariable createExtraVariable()
  {
    if (sMetrics != null)
    {
      localObject = sMetrics;
      ((Metrics)localObject).extravariables += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    Object localObject = acquireSolverVariable(SolverVariable.Type.SLACK, null);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    ((SolverVariable)localObject).id = this.mVariablesID;
    this.mCache.mIndexedVariables[this.mVariablesID] = localObject;
    return localObject;
  }
  
  public SolverVariable createObjectVariable(Object paramObject)
  {
    Object localObject2 = null;
    if (paramObject == null) {}
    Object localObject1;
    do
    {
      do
      {
        return localObject2;
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
          increaseTableSize();
        }
      } while (!(paramObject instanceof ConstraintAnchor));
      localObject2 = ((ConstraintAnchor)paramObject).getSolverVariable();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        ((ConstraintAnchor)paramObject).resetSolverVariable(this.mCache);
        localObject1 = ((ConstraintAnchor)paramObject).getSolverVariable();
      }
      if ((((SolverVariable)localObject1).id == -1) || (((SolverVariable)localObject1).id > this.mVariablesID)) {
        break;
      }
      localObject2 = localObject1;
    } while (this.mCache.mIndexedVariables[localObject1.id] != null);
    if (((SolverVariable)localObject1).id != -1) {
      ((SolverVariable)localObject1).reset();
    }
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    ((SolverVariable)localObject1).id = this.mVariablesID;
    ((SolverVariable)localObject1).mType = SolverVariable.Type.UNRESTRICTED;
    this.mCache.mIndexedVariables[this.mVariablesID] = localObject1;
    return localObject1;
  }
  
  public ArrayRow createRow()
  {
    ArrayRow localArrayRow = (ArrayRow)this.mCache.arrayRowPool.acquire();
    if (localArrayRow == null) {
      localArrayRow = new ArrayRow(this.mCache);
    }
    for (;;)
    {
      SolverVariable.increaseErrorId();
      return localArrayRow;
      localArrayRow.reset();
    }
  }
  
  public SolverVariable createSlackVariable()
  {
    if (sMetrics != null)
    {
      localObject = sMetrics;
      ((Metrics)localObject).slackvariables += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    Object localObject = acquireSolverVariable(SolverVariable.Type.SLACK, null);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    ((SolverVariable)localObject).id = this.mVariablesID;
    this.mCache.mIndexedVariables[this.mVariablesID] = localObject;
    return localObject;
  }
  
  void displayReadableRows()
  {
    displaySolverVariables();
    String str1 = " #  ";
    int i = 0;
    while (i < this.mNumRows)
    {
      str1 = str1 + this.mRows[i].toReadableString();
      str1 = str1 + "\n #  ";
      i += 1;
    }
    String str2 = str1;
    if (this.mGoal != null) {
      str2 = str1 + this.mGoal + "\n";
    }
    System.out.println(str2);
  }
  
  void displaySystemInformations()
  {
    int j = 0;
    for (int i = 0; j < this.TABLE_SIZE; i = k)
    {
      k = i;
      if (this.mRows[j] != null) {
        k = i + this.mRows[j].sizeInBytes();
      }
      j += 1;
    }
    j = 0;
    int m;
    for (int k = 0; j < this.mNumRows; k = m)
    {
      m = k;
      if (this.mRows[j] != null) {
        m = k + this.mRows[j].sizeInBytes();
      }
      j += 1;
    }
    System.out.println("Linear System -> Table size: " + this.TABLE_SIZE + " (" + getDisplaySize(this.TABLE_SIZE * this.TABLE_SIZE) + ") -- row sizes: " + getDisplaySize(i) + ", actual size: " + getDisplaySize(k) + " rows: " + this.mNumRows + "/" + this.mMaxRows + " cols: " + this.mNumColumns + "/" + this.mMaxColumns + " 0 occupied cells, " + getDisplaySize(0));
  }
  
  public void displayVariablesReadableRows()
  {
    displaySolverVariables();
    Object localObject1 = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      Object localObject2 = localObject1;
      if (this.mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED)
      {
        localObject1 = (String)localObject1 + this.mRows[i].toReadableString();
        localObject2 = (String)localObject1 + "\n";
      }
      i += 1;
      localObject1 = localObject2;
    }
    localObject1 = (String)localObject1 + this.mGoal + "\n";
    System.out.println((String)localObject1);
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    sMetrics = paramMetrics;
  }
  
  public Cache getCache()
  {
    return this.mCache;
  }
  
  Row getGoal()
  {
    return this.mGoal;
  }
  
  public int getMemoryUsed()
  {
    int j = 0;
    int i = 0;
    if (j < this.mNumRows)
    {
      if (this.mRows[j] == null) {
        break label42;
      }
      i = this.mRows[j].sizeInBytes() + i;
    }
    label42:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  public int getNumEquations()
  {
    return this.mNumRows;
  }
  
  public int getNumVariables()
  {
    return this.mVariablesID;
  }
  
  public int getObjectVariableValue(Object paramObject)
  {
    paramObject = ((ConstraintAnchor)paramObject).getSolverVariable();
    if (paramObject != null) {
      return (int)(paramObject.computedValue + 0.5F);
    }
    return 0;
  }
  
  ArrayRow getRow(int paramInt)
  {
    return this.mRows[paramInt];
  }
  
  float getValueFor(String paramString)
  {
    paramString = getVariable(paramString, SolverVariable.Type.UNRESTRICTED);
    if (paramString == null) {
      return 0.0F;
    }
    return paramString.computedValue;
  }
  
  SolverVariable getVariable(String paramString, SolverVariable.Type paramType)
  {
    if (this.mVariables == null) {
      this.mVariables = new HashMap();
    }
    SolverVariable localSolverVariable2 = (SolverVariable)this.mVariables.get(paramString);
    SolverVariable localSolverVariable1 = localSolverVariable2;
    if (localSolverVariable2 == null) {
      localSolverVariable1 = createVariable(paramString, paramType);
    }
    return localSolverVariable1;
  }
  
  public void minimize()
  {
    int j = 0;
    Metrics localMetrics;
    if (sMetrics != null)
    {
      localMetrics = sMetrics;
      localMetrics.minimize += 1L;
    }
    if (this.graphOptimizer)
    {
      if (sMetrics != null)
      {
        localMetrics = sMetrics;
        localMetrics.graphOptimizer += 1L;
      }
      i = 0;
      if (i >= this.mNumRows) {
        break label118;
      }
      if (this.mRows[i].isSimpleDefinition) {}
    }
    label118:
    for (int i = j;; i = 1)
    {
      if (i != 0)
      {
        if (sMetrics != null)
        {
          localMetrics = sMetrics;
          localMetrics.fullySolved += 1L;
        }
        computeValues();
        return;
        i += 1;
        break;
      }
      minimizeGoal(this.mGoal);
      return;
    }
  }
  
  void minimizeGoal(Row paramRow)
  {
    if (sMetrics != null)
    {
      Metrics localMetrics = sMetrics;
      localMetrics.minimizeGoal += 1L;
      localMetrics = sMetrics;
      localMetrics.maxVariables = Math.max(localMetrics.maxVariables, this.mNumColumns);
      localMetrics = sMetrics;
      localMetrics.maxRows = Math.max(localMetrics.maxRows, this.mNumRows);
    }
    updateRowFromVariables((ArrayRow)paramRow);
    enforceBFS(paramRow);
    optimize(paramRow, false);
    computeValues();
  }
  
  public void reset()
  {
    int i = 0;
    while (i < this.mCache.mIndexedVariables.length)
    {
      SolverVariable localSolverVariable = this.mCache.mIndexedVariables[i];
      if (localSolverVariable != null) {
        localSolverVariable.reset();
      }
      i += 1;
    }
    this.mCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
    this.mPoolVariablesCount = 0;
    Arrays.fill(this.mCache.mIndexedVariables, null);
    if (this.mVariables != null) {
      this.mVariables.clear();
    }
    this.mVariablesID = 0;
    this.mGoal.clear();
    this.mNumColumns = 1;
    i = 0;
    while (i < this.mNumRows)
    {
      this.mRows[i].used = false;
      i += 1;
    }
    releaseRows();
    this.mNumRows = 0;
  }
  
  static abstract interface Row
  {
    public abstract void addError(SolverVariable paramSolverVariable);
    
    public abstract void clear();
    
    public abstract SolverVariable getKey();
    
    public abstract SolverVariable getPivotCandidate(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean);
    
    public abstract void initFromRow(Row paramRow);
    
    public abstract boolean isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.LinearSystem
 * JD-Core Version:    0.7.0.1
 */