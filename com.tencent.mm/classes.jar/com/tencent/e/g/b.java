package com.tencent.e.g;

import com.tencent.e.g.a.a;

public abstract class b
  extends a
{
  private final int MrC;
  private final int MrD;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public b(int paramInt1, int paramInt2)
  {
    assert (paramInt1 >= paramInt2);
    this.MrC = paramInt1;
    this.MrD = paramInt2;
  }
  
  public void a(g paramg)
  {
    try
    {
      super.a(paramg);
      if (paramg.hl("LIMIT", 0) <= this.MrD) {
        paramg.hk("LIMIT", this.MrC);
      }
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  /* Error */
  public final boolean c(g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 53	com/tencent/e/g/g:gaj	()I
    //   6: istore_2
    //   7: aload_1
    //   8: ldc 37
    //   10: aload_0
    //   11: getfield 29	com/tencent/e/g/b:MrC	I
    //   14: invokevirtual 43	com/tencent/e/g/g:hl	(Ljava/lang/String;I)I
    //   17: istore_3
    //   18: iload_3
    //   19: iload_2
    //   20: if_icmple +34 -> 54
    //   23: iconst_1
    //   24: istore 4
    //   26: iload 4
    //   28: ifne +21 -> 49
    //   31: iload_3
    //   32: aload_0
    //   33: getfield 29	com/tencent/e/g/b:MrC	I
    //   36: if_icmplt +13 -> 49
    //   39: aload_1
    //   40: ldc 37
    //   42: aload_0
    //   43: getfield 31	com/tencent/e/g/b:MrD	I
    //   46: invokevirtual 47	com/tencent/e/g/g:hk	(Ljava/lang/String;I)V
    //   49: aload_0
    //   50: monitorexit
    //   51: iload 4
    //   53: ireturn
    //   54: iconst_0
    //   55: istore 4
    //   57: goto -31 -> 26
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	b
    //   0	65	1	paramg	g
    //   6	15	2	i	int
    //   17	20	3	j	int
    //   24	32	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	60	finally
    //   31	49	60	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g.b
 * JD-Core Version:    0.7.0.1
 */