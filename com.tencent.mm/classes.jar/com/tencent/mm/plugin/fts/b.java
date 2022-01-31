package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class b
  extends a
  implements Runnable
{
  private int errorCode;
  private i mPi;
  private WeakReference<l> mPj;
  
  public b(int paramInt, i parami)
  {
    AppMethodBeat.i(136518);
    this.errorCode = paramInt;
    this.mPi = parami;
    this.mPj = new WeakReference(parami.mSU);
    this.mPi.mSU = null;
    AppMethodBeat.o(136518);
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136519);
    j localj;
    if ((this.errorCode == -2) || (this.errorCode == -3))
    {
      localj = new j(this.mPi);
      localj.mSV = this;
      localj.bpE = this.errorCode;
      localj.mSW = new LinkedList();
      localj.mRX = g.aU(this.mPi.query, false);
      if (this.mPi.handler != null) {
        break label113;
      }
      l locall = (l)this.mPj.get();
      if (locall != null) {
        locall.b(localj);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(136519);
      return true;
      label113:
      this.mPi.handler.post(new b.1(this, localj));
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
    AppMethodBeat.i(136520);
    try
    {
      execute();
      AppMethodBeat.o(136520);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(136520);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b
 * JD-Core Version:    0.7.0.1
 */