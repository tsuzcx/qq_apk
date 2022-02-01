package android.arch.b;

import java.util.Collections;
import java.util.List;

final class g<T>
{
  private static final g ez = new g(Collections.EMPTY_LIST);
  public final List<T> eA;
  public final int eB;
  public final int eC;
  public final int eD;
  
  private g(List<T> paramList)
  {
    this.eA = paramList;
    this.eB = 0;
    this.eC = 0;
    this.eD = 0;
  }
  
  public final String toString()
  {
    return "Result " + this.eB + ", " + this.eA + ", " + this.eC + ", offset " + this.eD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.b.g
 * JD-Core Version:    0.7.0.1
 */