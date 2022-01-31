package com.tencent.mm.plugin.appbrand.m;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  private volatile int count = 2;
  private final LinkedList<Runnable> gQf = new LinkedList();
  
  public final void C(Runnable paramRunnable)
  {
    Object localObject = null;
    if (paramRunnable != null) {}
    try
    {
      this.gQf.addLast(paramRunnable);
      int i = this.count - 1;
      this.count = i;
      paramRunnable = localObject;
      if (i <= 0)
      {
        paramRunnable = localObject;
        if (this.gQf.size() > 0)
        {
          paramRunnable = new LinkedList();
          paramRunnable.addAll(this.gQf);
          this.gQf.clear();
        }
      }
      if (paramRunnable != null)
      {
        paramRunnable = paramRunnable.iterator();
        while (paramRunnable.hasNext()) {
          ((Runnable)paramRunnable.next()).run();
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.c
 * JD-Core Version:    0.7.0.1
 */