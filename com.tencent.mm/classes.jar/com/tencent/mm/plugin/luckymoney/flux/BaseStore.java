package com.tencent.mm.plugin.luckymoney.flux;

import com.tencent.mm.app.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.t.a.a.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseStore
  extends IListener<a>
{
  private int crl = b.KqI.cqS.getAndIncrement();
  
  protected BaseStore()
  {
    super(f.hfK);
    this.__eventId = a.class.getName().hashCode();
  }
  
  public static void fWO()
  {
    c localc = c.KqK;
    int i = 0;
    while (i < localc.eNV.size())
    {
      localc.eNV.get(i);
      i += 1;
    }
  }
  
  public abstract boolean fWN();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.flux.BaseStore
 * JD-Core Version:    0.7.0.1
 */