package com.tencent.mm.plugin.g;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class c
  extends a
{
  public final void execute(g paramg)
  {
    k.b("tencentloc", getClass().getClassLoader());
  }
  
  public final String name()
  {
    return "boot-load-tencentloc-library";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.g.c
 * JD-Core Version:    0.7.0.1
 */