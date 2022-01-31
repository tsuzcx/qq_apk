package android.support.constraint.solver;

public class ArrayRow
  implements LinearSystem.Row
{
  private static final boolean DEBUG = false;
  private static final float epsilon = 0.001F;
  float constantValue = 0.0F;
  boolean isSimpleDefinition = false;
  boolean used = false;
  SolverVariable variable = null;
  public final ArrayLinkedVariables variables;
  
  public ArrayRow(Cache paramCache)
  {
    this.variables = new ArrayLinkedVariables(this, paramCache);
  }
  
  public ArrayRow addError(LinearSystem paramLinearSystem, int paramInt)
  {
    this.variables.put(paramLinearSystem.createErrorVariable(paramInt, "ep"), 1.0F);
    this.variables.put(paramLinearSystem.createErrorVariable(paramInt, "em"), -1.0F);
    return this;
  }
  
  public void addError(SolverVariable paramSolverVariable)
  {
    float f = 1.0F;
    if (paramSolverVariable.strength == 1) {}
    for (;;)
    {
      this.variables.put(paramSolverVariable, f);
      return;
      if (paramSolverVariable.strength == 2) {
        f = 1000.0F;
      } else if (paramSolverVariable.strength == 3) {
        f = 1000000.0F;
      } else if (paramSolverVariable.strength == 4) {
        f = 1.0E+009F;
      } else if (paramSolverVariable.strength == 5) {
        f = 1.0E+012F;
      }
    }
  }
  
  ArrayRow addSingleError(SolverVariable paramSolverVariable, int paramInt)
  {
    this.variables.put(paramSolverVariable, paramInt);
    return this;
  }
  
  boolean chooseSubject(LinearSystem paramLinearSystem)
  {
    boolean bool = false;
    paramLinearSystem = this.variables.chooseSubject(paramLinearSystem);
    if (paramLinearSystem == null) {
      bool = true;
    }
    for (;;)
    {
      if (this.variables.currentSize == 0) {
        this.isSimpleDefinition = true;
      }
      return bool;
      pivot(paramLinearSystem);
    }
  }
  
  public void clear()
  {
    this.variables.clear();
    this.variable = null;
    this.constantValue = 0.0F;
  }
  
  ArrayRow createRowCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2)
  {
    if (paramSolverVariable2 == paramSolverVariable3)
    {
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable4, 1.0F);
      this.variables.put(paramSolverVariable2, -2.0F);
    }
    do
    {
      do
      {
        return this;
        if (paramFloat != 0.5F) {
          break;
        }
        this.variables.put(paramSolverVariable1, 1.0F);
        this.variables.put(paramSolverVariable2, -1.0F);
        this.variables.put(paramSolverVariable3, -1.0F);
        this.variables.put(paramSolverVariable4, 1.0F);
      } while ((paramInt1 <= 0) && (paramInt2 <= 0));
      this.constantValue = (-paramInt1 + paramInt2);
      return this;
      if (paramFloat <= 0.0F)
      {
        this.variables.put(paramSolverVariable1, -1.0F);
        this.variables.put(paramSolverVariable2, 1.0F);
        this.constantValue = paramInt1;
        return this;
      }
      if (paramFloat >= 1.0F)
      {
        this.variables.put(paramSolverVariable3, -1.0F);
        this.variables.put(paramSolverVariable4, 1.0F);
        this.constantValue = paramInt2;
        return this;
      }
      this.variables.put(paramSolverVariable1, (1.0F - paramFloat) * 1.0F);
      this.variables.put(paramSolverVariable2, (1.0F - paramFloat) * -1.0F);
      this.variables.put(paramSolverVariable3, -1.0F * paramFloat);
      this.variables.put(paramSolverVariable4, 1.0F * paramFloat);
    } while ((paramInt1 <= 0) && (paramInt2 <= 0));
    this.constantValue = (-paramInt1 * (1.0F - paramFloat) + paramInt2 * paramFloat);
    return this;
  }
  
  ArrayRow createRowDefinition(SolverVariable paramSolverVariable, int paramInt)
  {
    this.variable = paramSolverVariable;
    paramSolverVariable.computedValue = paramInt;
    this.constantValue = paramInt;
    this.isSimpleDefinition = true;
    return this;
  }
  
  ArrayRow createRowDimensionPercent(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat)
  {
    this.variables.put(paramSolverVariable1, -1.0F);
    this.variables.put(paramSolverVariable2, 1.0F - paramFloat);
    this.variables.put(paramSolverVariable3, paramFloat);
    return this;
  }
  
  public ArrayRow createRowDimensionRatio(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat)
  {
    this.variables.put(paramSolverVariable1, -1.0F);
    this.variables.put(paramSolverVariable2, 1.0F);
    this.variables.put(paramSolverVariable3, paramFloat);
    this.variables.put(paramSolverVariable4, -paramFloat);
    return this;
  }
  
  public ArrayRow createRowEqualDimension(float paramFloat1, float paramFloat2, float paramFloat3, SolverVariable paramSolverVariable1, int paramInt1, SolverVariable paramSolverVariable2, int paramInt2, SolverVariable paramSolverVariable3, int paramInt3, SolverVariable paramSolverVariable4, int paramInt4)
  {
    if ((paramFloat2 == 0.0F) || (paramFloat1 == paramFloat3))
    {
      this.constantValue = (-paramInt1 - paramInt2 + paramInt3 + paramInt4);
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable2, -1.0F);
      this.variables.put(paramSolverVariable4, 1.0F);
      this.variables.put(paramSolverVariable3, -1.0F);
      return this;
    }
    paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
    this.constantValue = (-paramInt1 - paramInt2 + paramInt3 * paramFloat1 + paramInt4 * paramFloat1);
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable4, paramFloat1);
    this.variables.put(paramSolverVariable3, -paramFloat1);
    return this;
  }
  
  public ArrayRow createRowEqualMatchDimensions(float paramFloat1, float paramFloat2, float paramFloat3, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4)
  {
    this.constantValue = 0.0F;
    if ((paramFloat2 == 0.0F) || (paramFloat1 == paramFloat3))
    {
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable2, -1.0F);
      this.variables.put(paramSolverVariable4, 1.0F);
      this.variables.put(paramSolverVariable3, -1.0F);
      return this;
    }
    if (paramFloat1 == 0.0F)
    {
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable2, -1.0F);
      return this;
    }
    if (paramFloat3 == 0.0F)
    {
      this.variables.put(paramSolverVariable3, 1.0F);
      this.variables.put(paramSolverVariable4, -1.0F);
      return this;
    }
    paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable4, paramFloat1);
    this.variables.put(paramSolverVariable3, -paramFloat1);
    return this;
  }
  
  public ArrayRow createRowEquals(SolverVariable paramSolverVariable, int paramInt)
  {
    if (paramInt < 0)
    {
      this.constantValue = (paramInt * -1);
      this.variables.put(paramSolverVariable, 1.0F);
      return this;
    }
    this.constantValue = paramInt;
    this.variables.put(paramSolverVariable, -1.0F);
    return this;
  }
  
  public ArrayRow createRowEquals(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.constantValue = j;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    return this;
  }
  
  public ArrayRow createRowGreaterThan(SolverVariable paramSolverVariable1, int paramInt, SolverVariable paramSolverVariable2)
  {
    this.constantValue = paramInt;
    this.variables.put(paramSolverVariable1, -1.0F);
    return this;
  }
  
  public ArrayRow createRowGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.constantValue = j;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      this.variables.put(paramSolverVariable3, 1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public ArrayRow createRowLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.constantValue = j;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      this.variables.put(paramSolverVariable3, -1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable3, 1.0F);
    return this;
  }
  
  public ArrayRow createRowWithAngle(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat)
  {
    this.variables.put(paramSolverVariable3, 0.5F);
    this.variables.put(paramSolverVariable4, 0.5F);
    this.variables.put(paramSolverVariable1, -0.5F);
    this.variables.put(paramSolverVariable2, -0.5F);
    this.constantValue = (-paramFloat);
    return this;
  }
  
  void ensurePositiveConstant()
  {
    if (this.constantValue < 0.0F)
    {
      this.constantValue *= -1.0F;
      this.variables.invert();
    }
  }
  
  public SolverVariable getKey()
  {
    return this.variable;
  }
  
  public SolverVariable getPivotCandidate(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean)
  {
    return this.variables.getPivotCandidate(paramArrayOfBoolean, null);
  }
  
  boolean hasKeyVariable()
  {
    return (this.variable != null) && ((this.variable.mType == SolverVariable.Type.UNRESTRICTED) || (this.constantValue >= 0.0F));
  }
  
  boolean hasVariable(SolverVariable paramSolverVariable)
  {
    return this.variables.containsKey(paramSolverVariable);
  }
  
  public void initFromRow(LinearSystem.Row paramRow)
  {
    if ((paramRow instanceof ArrayRow))
    {
      paramRow = (ArrayRow)paramRow;
      this.variable = null;
      this.variables.clear();
      int i = 0;
      while (i < paramRow.variables.currentSize)
      {
        SolverVariable localSolverVariable = paramRow.variables.getVariable(i);
        float f = paramRow.variables.getVariableValue(i);
        this.variables.add(localSolverVariable, f, true);
        i += 1;
      }
    }
  }
  
  public boolean isEmpty()
  {
    return (this.variable == null) && (this.constantValue == 0.0F) && (this.variables.currentSize == 0);
  }
  
  SolverVariable pickPivot(SolverVariable paramSolverVariable)
  {
    return this.variables.getPivotCandidate(null, paramSolverVariable);
  }
  
  void pivot(SolverVariable paramSolverVariable)
  {
    if (this.variable != null)
    {
      this.variables.put(this.variable, -1.0F);
      this.variable = null;
    }
    float f = this.variables.remove(paramSolverVariable, true) * -1.0F;
    this.variable = paramSolverVariable;
    if (f == 1.0F) {
      return;
    }
    this.constantValue /= f;
    this.variables.divideByAmount(f);
  }
  
  public void reset()
  {
    this.variable = null;
    this.variables.clear();
    this.constantValue = 0.0F;
    this.isSimpleDefinition = false;
  }
  
  int sizeInBytes()
  {
    int i = 0;
    if (this.variable != null) {
      i = 4;
    }
    return i + 4 + 4 + this.variables.sizeInBytes();
  }
  
  String toReadableString()
  {
    String str;
    if (this.variable == null)
    {
      str = "" + "0";
      str = str + " = ";
      if (this.constantValue == 0.0F) {
        break label375;
      }
      str = str + this.constantValue;
    }
    label97:
    label369:
    label372:
    label375:
    for (int i = 1;; i = 0)
    {
      int k = this.variables.currentSize;
      int j = 0;
      Object localObject;
      float f;
      if (j < k)
      {
        localObject = this.variables.getVariable(j);
        if (localObject == null) {
          break label372;
        }
        f = this.variables.getVariableValue(j);
        if (f == 0.0F) {
          break label372;
        }
        localObject = ((SolverVariable)localObject).toString();
        if (i == 0)
        {
          if (f >= 0.0F) {
            break label369;
          }
          str = str + "- ";
          f *= -1.0F;
          if (f != 1.0F) {
            break label302;
          }
          str = str + (String)localObject;
          i = 1;
        }
      }
      for (;;)
      {
        j += 1;
        break label97;
        str = "" + this.variable;
        break;
        if (f > 0.0F)
        {
          str = str + " + ";
          break label177;
        }
        str = str + " - ";
        f *= -1.0F;
        break label177;
        str = str + f + " " + (String)localObject;
        break label205;
        localObject = str;
        if (i == 0) {
          localObject = str + "0.0";
        }
        return localObject;
        break label177;
      }
    }
  }
  
  public String toString()
  {
    return toReadableString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.ArrayRow
 * JD-Core Version:    0.7.0.1
 */