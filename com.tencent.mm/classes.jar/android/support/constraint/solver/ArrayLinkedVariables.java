package android.support.constraint.solver;

import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables
{
  private static final boolean DEBUG = false;
  private static final boolean FULL_NEW_CHECK = false;
  private static final int NONE = -1;
  private int ROW_SIZE = 8;
  private SolverVariable candidate = null;
  int currentSize = 0;
  private int[] mArrayIndices = new int[this.ROW_SIZE];
  private int[] mArrayNextIndices = new int[this.ROW_SIZE];
  private float[] mArrayValues = new float[this.ROW_SIZE];
  private final Cache mCache;
  private boolean mDidFillOnce = false;
  private int mHead = -1;
  private int mLast = -1;
  private final ArrayRow mRow;
  
  ArrayLinkedVariables(ArrayRow paramArrayRow, Cache paramCache)
  {
    this.mRow = paramArrayRow;
    this.mCache = paramCache;
  }
  
  private boolean isNew(SolverVariable paramSolverVariable, LinearSystem paramLinearSystem)
  {
    return paramSolverVariable.usageInRowCount <= 1;
  }
  
  final void add(SolverVariable paramSolverVariable, float paramFloat, boolean paramBoolean)
  {
    if (paramFloat == 0.0F) {}
    do
    {
      do
      {
        return;
        if (this.mHead != -1) {
          break;
        }
        this.mHead = 0;
        this.mArrayValues[this.mHead] = paramFloat;
        this.mArrayIndices[this.mHead] = paramSolverVariable.id;
        this.mArrayNextIndices[this.mHead] = -1;
        paramSolverVariable.usageInRowCount += 1;
        paramSolverVariable.addToRow(this.mRow);
        this.currentSize += 1;
      } while (this.mDidFillOnce);
      this.mLast += 1;
    } while (this.mLast < this.mArrayIndices.length);
    this.mDidFillOnce = true;
    this.mLast = (this.mArrayIndices.length - 1);
    return;
    int i = this.mHead;
    int j = 0;
    int m = -1;
    Object localObject;
    for (;;)
    {
      if ((i == -1) || (j >= this.currentSize)) {
        break label319;
      }
      if (this.mArrayIndices[i] == paramSolverVariable.id)
      {
        localObject = this.mArrayValues;
        localObject[i] += paramFloat;
        if (this.mArrayValues[i] != 0.0F) {
          break;
        }
        if (i == this.mHead) {
          this.mHead = this.mArrayNextIndices[i];
        }
        for (;;)
        {
          if (paramBoolean) {
            paramSolverVariable.removeFromRow(this.mRow);
          }
          if (this.mDidFillOnce) {
            this.mLast = i;
          }
          paramSolverVariable.usageInRowCount -= 1;
          this.currentSize -= 1;
          return;
          localObject = this.mArrayNextIndices;
          localObject[m] = localObject[i];
        }
      }
      if (this.mArrayIndices[i] < paramSolverVariable.id) {
        m = i;
      }
      i = this.mArrayNextIndices[i];
      j += 1;
    }
    label319:
    i = this.mLast + 1;
    label353:
    int k;
    if (this.mDidFillOnce)
    {
      if (this.mArrayIndices[this.mLast] == -1) {
        i = this.mLast;
      }
    }
    else
    {
      j = i;
      if (i >= this.mArrayIndices.length)
      {
        j = i;
        if (this.currentSize < this.mArrayIndices.length)
        {
          k = 0;
          label386:
          j = i;
          if (k < this.mArrayIndices.length)
          {
            if (this.mArrayIndices[k] != -1) {
              break label638;
            }
            j = k;
          }
        }
      }
      i = j;
      if (j >= this.mArrayIndices.length)
      {
        i = this.mArrayIndices.length;
        this.ROW_SIZE *= 2;
        this.mDidFillOnce = false;
        this.mLast = (i - 1);
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
      }
      this.mArrayIndices[i] = paramSolverVariable.id;
      this.mArrayValues[i] = paramFloat;
      if (m == -1) {
        break label647;
      }
      localObject = this.mArrayNextIndices;
      localObject[i] = localObject[m];
      this.mArrayNextIndices[m] = i;
    }
    for (;;)
    {
      paramSolverVariable.usageInRowCount += 1;
      paramSolverVariable.addToRow(this.mRow);
      this.currentSize += 1;
      if (!this.mDidFillOnce) {
        this.mLast += 1;
      }
      if (this.mLast < this.mArrayIndices.length) {
        break;
      }
      this.mDidFillOnce = true;
      this.mLast = (this.mArrayIndices.length - 1);
      return;
      i = this.mArrayIndices.length;
      break label353;
      label638:
      k += 1;
      break label386;
      label647:
      this.mArrayNextIndices[i] = this.mHead;
      this.mHead = i;
    }
  }
  
  SolverVariable chooseSubject(LinearSystem paramLinearSystem)
  {
    int j = this.mHead;
    int i = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    float f5 = 0.0F;
    float f4 = 0.0F;
    Object localObject4 = null;
    Object localObject3 = null;
    if ((j != -1) && (i < this.currentSize))
    {
      float f2 = this.mArrayValues[j];
      SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      float f1;
      label101:
      boolean bool1;
      boolean bool2;
      float f3;
      Object localObject1;
      Object localObject2;
      if (f2 < 0.0F)
      {
        f1 = f2;
        if (f2 > -0.001F)
        {
          this.mArrayValues[j] = 0.0F;
          localSolverVariable.removeFromRow(this.mRow);
          f1 = 0.0F;
        }
        bool1 = bool4;
        bool2 = bool3;
        f2 = f5;
        f3 = f4;
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (f1 != 0.0F)
        {
          if (localSolverVariable.mType != SolverVariable.Type.UNRESTRICTED) {
            break label367;
          }
          if (localObject4 != null) {
            break label245;
          }
          bool2 = isNew(localSolverVariable, paramLinearSystem);
          localObject2 = localObject3;
          localObject1 = localSolverVariable;
          f3 = f1;
          f2 = f5;
          bool1 = bool4;
        }
      }
      label367:
      for (;;)
      {
        j = this.mArrayNextIndices[j];
        i += 1;
        bool4 = bool1;
        bool3 = bool2;
        f5 = f2;
        f4 = f3;
        localObject4 = localObject1;
        localObject3 = localObject2;
        break;
        f1 = f2;
        if (f2 >= 0.001F) {
          break label101;
        }
        this.mArrayValues[j] = 0.0F;
        localSolverVariable.removeFromRow(this.mRow);
        f1 = 0.0F;
        break label101;
        label245:
        if (f4 > f1)
        {
          bool2 = isNew(localSolverVariable, paramLinearSystem);
          bool1 = bool4;
          f2 = f5;
          f3 = f1;
          localObject1 = localSolverVariable;
          localObject2 = localObject3;
        }
        else
        {
          bool1 = bool4;
          bool2 = bool3;
          f2 = f5;
          f3 = f4;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (!bool3)
          {
            bool1 = bool4;
            bool2 = bool3;
            f2 = f5;
            f3 = f4;
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (isNew(localSolverVariable, paramLinearSystem))
            {
              bool2 = true;
              bool1 = bool4;
              f2 = f5;
              f3 = f1;
              localObject1 = localSolverVariable;
              localObject2 = localObject3;
              continue;
              bool1 = bool4;
              bool2 = bool3;
              f2 = f5;
              f3 = f4;
              localObject1 = localObject4;
              localObject2 = localObject3;
              if (localObject4 == null)
              {
                bool1 = bool4;
                bool2 = bool3;
                f2 = f5;
                f3 = f4;
                localObject1 = localObject4;
                localObject2 = localObject3;
                if (f1 < 0.0F) {
                  if (localObject3 == null)
                  {
                    bool1 = isNew(localSolverVariable, paramLinearSystem);
                    bool2 = bool3;
                    f2 = f1;
                    f3 = f4;
                    localObject1 = localObject4;
                    localObject2 = localSolverVariable;
                  }
                  else if (f5 > f1)
                  {
                    bool1 = isNew(localSolverVariable, paramLinearSystem);
                    bool2 = bool3;
                    f2 = f1;
                    f3 = f4;
                    localObject1 = localObject4;
                    localObject2 = localSolverVariable;
                  }
                  else
                  {
                    bool1 = bool4;
                    bool2 = bool3;
                    f2 = f5;
                    f3 = f4;
                    localObject1 = localObject4;
                    localObject2 = localObject3;
                    if (!bool4)
                    {
                      bool1 = bool4;
                      bool2 = bool3;
                      f2 = f5;
                      f3 = f4;
                      localObject1 = localObject4;
                      localObject2 = localObject3;
                      if (isNew(localSolverVariable, paramLinearSystem))
                      {
                        bool1 = true;
                        bool2 = bool3;
                        f2 = f1;
                        f3 = f4;
                        localObject1 = localObject4;
                        localObject2 = localSolverVariable;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (localObject4 != null) {
      return localObject4;
    }
    return localObject3;
  }
  
  public final void clear()
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      if (localSolverVariable != null) {
        localSolverVariable.removeFromRow(this.mRow);
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    this.mHead = -1;
    this.mLast = -1;
    this.mDidFillOnce = false;
    this.currentSize = 0;
  }
  
  final boolean containsKey(SolverVariable paramSolverVariable)
  {
    if (this.mHead == -1) {}
    for (;;)
    {
      return false;
      int j = this.mHead;
      int i = 0;
      while ((j != -1) && (i < this.currentSize))
      {
        if (this.mArrayIndices[j] == paramSolverVariable.id) {
          return true;
        }
        j = this.mArrayNextIndices[j];
        i += 1;
      }
    }
  }
  
  public void display()
  {
    int j = this.currentSize;
    System.out.print("{ ");
    int i = 0;
    while (i < j)
    {
      SolverVariable localSolverVariable = getVariable(i);
      if (localSolverVariable != null) {
        System.out.print(localSolverVariable + " = " + getVariableValue(i) + " ");
      }
      i += 1;
    }
    System.out.println(" }");
  }
  
  void divideByAmount(float paramFloat)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      float[] arrayOfFloat = this.mArrayValues;
      arrayOfFloat[j] /= paramFloat;
      j = this.mArrayNextIndices[j];
      i += 1;
    }
  }
  
  public final float get(SolverVariable paramSolverVariable)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (this.mArrayIndices[j] == paramSolverVariable.id) {
        return this.mArrayValues[j];
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return 0.0F;
  }
  
  SolverVariable getPivotCandidate()
  {
    if (this.candidate == null)
    {
      int j = this.mHead;
      Object localObject1 = null;
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (j == -1) {
          break;
        }
        localObject2 = localObject1;
        if (i >= this.currentSize) {
          break;
        }
        localObject2 = localObject1;
        if (this.mArrayValues[j] < 0.0F)
        {
          SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (localObject1.strength >= localSolverVariable.strength) {}
          }
          else
          {
            localObject2 = localSolverVariable;
          }
        }
        j = this.mArrayNextIndices[j];
        i += 1;
        localObject1 = localObject2;
      }
    }
    Object localObject2 = this.candidate;
    return localObject2;
  }
  
  SolverVariable getPivotCandidate(boolean[] paramArrayOfBoolean, SolverVariable paramSolverVariable)
  {
    int j = this.mHead;
    Object localObject1 = null;
    float f1 = 0.0F;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      float f2 = f1;
      Object localObject2 = localObject1;
      if (this.mArrayValues[j] < 0.0F)
      {
        SolverVariable localSolverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
        if (paramArrayOfBoolean != null)
        {
          f2 = f1;
          localObject2 = localObject1;
          if (paramArrayOfBoolean[localSolverVariable.id] != 0) {}
        }
        else
        {
          f2 = f1;
          localObject2 = localObject1;
          if (localSolverVariable != paramSolverVariable) {
            if (localSolverVariable.mType != SolverVariable.Type.SLACK)
            {
              f2 = f1;
              localObject2 = localObject1;
              if (localSolverVariable.mType != SolverVariable.Type.ERROR) {}
            }
            else
            {
              float f3 = this.mArrayValues[j];
              f2 = f1;
              localObject2 = localObject1;
              if (f3 < f1)
              {
                f2 = f3;
                localObject2 = localSolverVariable;
              }
            }
          }
        }
      }
      j = this.mArrayNextIndices[j];
      i += 1;
      f1 = f2;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  final SolverVariable getVariable(int paramInt)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (i == paramInt) {
        return this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return null;
  }
  
  final float getVariableValue(int paramInt)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      if (i == paramInt) {
        return this.mArrayValues[j];
      }
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return 0.0F;
  }
  
  boolean hasAtLeastOnePositiveVariable()
  {
    boolean bool2 = false;
    int j = this.mHead;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j != -1)
      {
        bool1 = bool2;
        if (i < this.currentSize)
        {
          if (this.mArrayValues[j] <= 0.0F) {
            break label44;
          }
          bool1 = true;
        }
      }
      return bool1;
      label44:
      j = this.mArrayNextIndices[j];
      i += 1;
    }
  }
  
  void invert()
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      float[] arrayOfFloat = this.mArrayValues;
      arrayOfFloat[j] *= -1.0F;
      j = this.mArrayNextIndices[j];
      i += 1;
    }
  }
  
  public final void put(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F) {
      remove(paramSolverVariable, true);
    }
    do
    {
      do
      {
        return;
        if (this.mHead != -1) {
          break;
        }
        this.mHead = 0;
        this.mArrayValues[this.mHead] = paramFloat;
        this.mArrayIndices[this.mHead] = paramSolverVariable.id;
        this.mArrayNextIndices[this.mHead] = -1;
        paramSolverVariable.usageInRowCount += 1;
        paramSolverVariable.addToRow(this.mRow);
        this.currentSize += 1;
      } while (this.mDidFillOnce);
      this.mLast += 1;
    } while (this.mLast < this.mArrayIndices.length);
    this.mDidFillOnce = true;
    this.mLast = (this.mArrayIndices.length - 1);
    return;
    int i = this.mHead;
    int j = 0;
    int m = -1;
    while ((i != -1) && (j < this.currentSize))
    {
      if (this.mArrayIndices[i] == paramSolverVariable.id)
      {
        this.mArrayValues[i] = paramFloat;
        return;
      }
      if (this.mArrayIndices[i] < paramSolverVariable.id) {
        m = i;
      }
      i = this.mArrayNextIndices[i];
      j += 1;
    }
    i = this.mLast + 1;
    label244:
    int k;
    if (this.mDidFillOnce)
    {
      if (this.mArrayIndices[this.mLast] == -1) {
        i = this.mLast;
      }
    }
    else
    {
      j = i;
      if (i >= this.mArrayIndices.length)
      {
        j = i;
        if (this.currentSize < this.mArrayIndices.length)
        {
          k = 0;
          label274:
          j = i;
          if (k < this.mArrayIndices.length)
          {
            if (this.mArrayIndices[k] != -1) {
              break label534;
            }
            j = k;
          }
        }
      }
      i = j;
      if (j >= this.mArrayIndices.length)
      {
        i = this.mArrayIndices.length;
        this.ROW_SIZE *= 2;
        this.mDidFillOnce = false;
        this.mLast = (i - 1);
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
      }
      this.mArrayIndices[i] = paramSolverVariable.id;
      this.mArrayValues[i] = paramFloat;
      if (m == -1) {
        break label543;
      }
      int[] arrayOfInt = this.mArrayNextIndices;
      arrayOfInt[i] = arrayOfInt[m];
      this.mArrayNextIndices[m] = i;
    }
    for (;;)
    {
      paramSolverVariable.usageInRowCount += 1;
      paramSolverVariable.addToRow(this.mRow);
      this.currentSize += 1;
      if (!this.mDidFillOnce) {
        this.mLast += 1;
      }
      if (this.currentSize >= this.mArrayIndices.length) {
        this.mDidFillOnce = true;
      }
      if (this.mLast < this.mArrayIndices.length) {
        break;
      }
      this.mDidFillOnce = true;
      this.mLast = (this.mArrayIndices.length - 1);
      return;
      i = this.mArrayIndices.length;
      break label244;
      label534:
      k += 1;
      break label274;
      label543:
      this.mArrayNextIndices[i] = this.mHead;
      this.mHead = i;
    }
  }
  
  public final float remove(SolverVariable paramSolverVariable, boolean paramBoolean)
  {
    if (this.candidate == paramSolverVariable) {
      this.candidate = null;
    }
    if (this.mHead == -1) {}
    for (;;)
    {
      return 0.0F;
      int i = this.mHead;
      int j = 0;
      int k = -1;
      while ((i != -1) && (j < this.currentSize))
      {
        if (this.mArrayIndices[i] == paramSolverVariable.id)
        {
          if (i == this.mHead) {
            this.mHead = this.mArrayNextIndices[i];
          }
          for (;;)
          {
            if (paramBoolean) {
              paramSolverVariable.removeFromRow(this.mRow);
            }
            paramSolverVariable.usageInRowCount -= 1;
            this.currentSize -= 1;
            this.mArrayIndices[i] = -1;
            if (this.mDidFillOnce) {
              this.mLast = i;
            }
            return this.mArrayValues[i];
            int[] arrayOfInt = this.mArrayNextIndices;
            arrayOfInt[k] = arrayOfInt[i];
          }
        }
        int m = this.mArrayNextIndices[i];
        j += 1;
        k = i;
        i = m;
      }
    }
  }
  
  int sizeInBytes()
  {
    return this.mArrayIndices.length * 4 * 3 + 0 + 36;
  }
  
  public String toString()
  {
    String str = "";
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      str = str + " -> ";
      str = str + this.mArrayValues[j] + " : ";
      str = str + this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      j = this.mArrayNextIndices[j];
      i += 1;
    }
    return str;
  }
  
  final void updateFromRow(ArrayRow paramArrayRow1, ArrayRow paramArrayRow2, boolean paramBoolean)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize)) {
      if (this.mArrayIndices[j] == paramArrayRow2.variable.id)
      {
        float f = this.mArrayValues[j];
        remove(paramArrayRow2.variable, paramBoolean);
        ArrayLinkedVariables localArrayLinkedVariables = (ArrayLinkedVariables)paramArrayRow2.variables;
        j = localArrayLinkedVariables.mHead;
        i = 0;
        while ((j != -1) && (i < localArrayLinkedVariables.currentSize))
        {
          add(this.mCache.mIndexedVariables[localArrayLinkedVariables.mArrayIndices[j]], localArrayLinkedVariables.mArrayValues[j] * f, paramBoolean);
          j = localArrayLinkedVariables.mArrayNextIndices[j];
          i += 1;
        }
        paramArrayRow1.constantValue += paramArrayRow2.constantValue * f;
        if (paramBoolean) {
          paramArrayRow2.variable.removeFromRow(paramArrayRow1);
        }
        j = this.mHead;
        i = 0;
      }
      else
      {
        j = this.mArrayNextIndices[j];
        i += 1;
      }
    }
  }
  
  void updateFromSystem(ArrayRow paramArrayRow, ArrayRow[] paramArrayOfArrayRow)
  {
    int j = this.mHead;
    int i = 0;
    while ((j != -1) && (i < this.currentSize))
    {
      Object localObject = this.mCache.mIndexedVariables[this.mArrayIndices[j]];
      if (((SolverVariable)localObject).definitionId != -1)
      {
        float f = this.mArrayValues[j];
        remove((SolverVariable)localObject, true);
        localObject = paramArrayOfArrayRow[localObject.definitionId];
        if (!((ArrayRow)localObject).isSimpleDefinition)
        {
          ArrayLinkedVariables localArrayLinkedVariables = (ArrayLinkedVariables)((ArrayRow)localObject).variables;
          j = localArrayLinkedVariables.mHead;
          i = 0;
          while ((j != -1) && (i < localArrayLinkedVariables.currentSize))
          {
            add(this.mCache.mIndexedVariables[localArrayLinkedVariables.mArrayIndices[j]], localArrayLinkedVariables.mArrayValues[j] * f, true);
            j = localArrayLinkedVariables.mArrayNextIndices[j];
            i += 1;
          }
        }
        paramArrayRow.constantValue += ((ArrayRow)localObject).constantValue * f;
        ((ArrayRow)localObject).variable.removeFromRow(paramArrayRow);
        j = this.mHead;
        i = 0;
      }
      else
      {
        j = this.mArrayNextIndices[j];
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.ArrayLinkedVariables
 * JD-Core Version:    0.7.0.1
 */