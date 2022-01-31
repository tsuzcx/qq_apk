package android.support.constraint.solver;

public class Cache
{
  Pools.Pool<ArrayRow> arrayRowPool = new Pools.SimplePool(256);
  SolverVariable[] mIndexedVariables = new SolverVariable[32];
  Pools.Pool<SolverVariable> solverVariablePool = new Pools.SimplePool(256);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.Cache
 * JD-Core Version:    0.7.0.1
 */