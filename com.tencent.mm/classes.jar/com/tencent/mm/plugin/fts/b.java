package com.tencent.mm.plugin.fts;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class b
  extends a
  implements Runnable
{
  private int errorCode;
  private i ktu;
  private WeakReference<l> ktv;
  
  public b(int paramInt, i parami)
  {
    this.errorCode = paramInt;
    this.ktu = parami;
    this.ktv = new WeakReference(parami.kxf);
    this.ktu.kxf = null;
  }
  
  public final boolean execute()
  {
    j localj;
    if ((this.errorCode == -2) || (this.errorCode == -3))
    {
      localj = new j(this.ktu);
      localj.kxg = this;
      localj.aYY = this.errorCode;
      localj.kxh = new LinkedList();
      localj.kwi = g.aF(this.ktu.bVk, false);
      if (this.ktu.handler != null) {
        break label103;
      }
      l locall = (l)this.ktv.get();
      if (locall != null) {
        locall.b(localj);
      }
    }
    for (;;)
    {
      return true;
      label103:
      this.ktu.handler.post(new b.1(this, localj));
    }
  }
  
  public final int getId()
  {
    return -1;
  }
  
  public final int getPriority()
  {
    return 0;
  }
  
  public final boolean isCancelled()
  {
    return false;
  }
  
  public final void run()
  {
    try
    {
      execute();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b
 * JD-Core Version:    0.7.0.1
 */