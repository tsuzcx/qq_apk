package android.support.constraint.solver;

public class GoalRow
  extends ArrayRow
{
  public GoalRow(Cache paramCache)
  {
    super(paramCache);
  }
  
  public void addError(SolverVariable paramSolverVariable)
  {
    super.addError(paramSolverVariable);
    paramSolverVariable.usageInRowCount -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.GoalRow
 * JD-Core Version:    0.7.0.1
 */