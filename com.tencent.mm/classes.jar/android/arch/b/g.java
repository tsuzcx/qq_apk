package android.arch.b;

import java.util.Collections;
import java.util.List;

final class g<T>
{
  private static final g eA = new g(Collections.EMPTY_LIST);
  public final List<T> eB;
  public final int eC;
  public final int eD;
  public final int eE;
  
  private g(List<T> paramList)
  {
    this.eB = paramList;
    this.eC = 0;
    this.eD = 0;
    this.eE = 0;
  }
  
  public final String toString()
  {
    return "Result " + this.eC + ", " + this.eB + ", " + this.eD + ", offset " + this.eE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.b.g
 * JD-Core Version:    0.7.0.1
 */