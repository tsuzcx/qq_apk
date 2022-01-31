package a.e;

import a.a.n;
import java.util.NoSuchElementException;

public final class c
  extends n
{
  private final int ghE;
  private final int xoB;
  private boolean xoC;
  private int xoD;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.ghE = paramInt3;
    this.xoB = paramInt2;
    if (this.ghE > 0) {
      if (paramInt1 <= paramInt2)
      {
        this.xoC = bool;
        if (!this.xoC) {
          break label65;
        }
      }
    }
    for (;;)
    {
      this.xoD = paramInt1;
      return;
      bool = false;
      break;
      if (paramInt1 >= paramInt2) {
        break;
      }
      bool = false;
      break;
      label65:
      paramInt1 = this.xoB;
    }
  }
  
  public final boolean hasNext()
  {
    return this.xoC;
  }
  
  public final int nextInt()
  {
    int i = this.xoD;
    if (i == this.xoB)
    {
      if (!this.xoC) {
        throw ((Throwable)new NoSuchElementException());
      }
      this.xoC = false;
      return i;
    }
    this.xoD += this.ghE;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.e.c
 * JD-Core Version:    0.7.0.1
 */