package com.tencent.matrix.iocanary.core;

import com.tencent.matrix.c.c.a;
import java.util.List;

public class a
  implements c.a, b
{
  public boolean bnh;
  public final com.tencent.matrix.iocanary.a.a bog;
  private final com.tencent.matrix.iocanary.a bor;
  public com.tencent.matrix.iocanary.b.a bos;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public a(com.tencent.matrix.iocanary.a parama)
  {
    this.bog = parama.bog;
    this.bor = parama;
  }
  
  public final void a(com.tencent.matrix.c.b paramb)
  {
    this.bor.a(paramb);
  }
  
  public final void z(List<IOIssue> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        this.bor.a(com.tencent.matrix.iocanary.c.a.a((IOIssue)paramList.get(i)));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.iocanary.core.a
 * JD-Core Version:    0.7.0.1
 */