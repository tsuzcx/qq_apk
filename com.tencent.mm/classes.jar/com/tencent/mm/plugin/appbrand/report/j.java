package com.tencent.mm.plugin.appbrand.report;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends d
{
  long gXM;
  public long gXN;
  private final j.c gXO = new j.c(this, (byte)0);
  final j.b gXP = new j.b(this, (byte)0);
  final j.a gXQ = new j.a(this, (byte)0);
  private boolean gXR = false;
  public boolean mStopped = false;
  
  public j(String paramString)
  {
    super("MicroMsg.StayingRecorder[" + paramString + "]", Looper.getMainLooper());
    a(this.gXP);
    a(this.gXQ);
    a(this.gXO);
    b(this.gXO);
    start();
  }
  
  private void ku(int paramInt)
  {
    if (csk() == null)
    {
      Ff(paramInt);
      return;
    }
    if (Looper.myLooper() == this.ujd.getLooper())
    {
      this.ujd.handleMessage(Message.obtain(this.ujd, paramInt));
      return;
    }
    Fg(paramInt);
  }
  
  protected final void abD()
  {
    super.abD();
    this.gXR = true;
  }
  
  public final boolean aod()
  {
    return (csl() == this.gXQ) || (this.gXR);
  }
  
  public final void aoe()
  {
    y.d(this.mName, "toForeground");
    ku(2);
  }
  
  public final void aof()
  {
    y.d(this.mName, "toBackground");
    ku(1);
  }
  
  public final void start()
  {
    if (this.mStopped) {
      return;
    }
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.j
 * JD-Core Version:    0.7.0.1
 */