package com.tencent.mm.plugin.appbrand.report;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class o
  extends d
{
  long iGf;
  public long iGg;
  private final o.c iGh;
  final o.b iGi;
  final o.a iGj;
  private boolean iGk;
  public boolean mStopped;
  
  public o(String paramString)
  {
    super("MicroMsg.StayingRecorder[" + paramString + "]", Looper.getMainLooper());
    AppMethodBeat.i(114405);
    this.iGh = new o.c(this, (byte)0);
    this.iGi = new o.b(this, (byte)0);
    this.iGj = new o.a(this, (byte)0);
    this.mStopped = false;
    this.iGk = false;
    a(this.iGi);
    a(this.iGj);
    a(this.iGh);
    b(this.iGh);
    AppMethodBeat.o(114405);
  }
  
  private void pw(int paramInt)
  {
    AppMethodBeat.i(114409);
    if (duh() == null)
    {
      sendMessage(paramInt);
      AppMethodBeat.o(114409);
      return;
    }
    if (Looper.myLooper() == this.yrd.getLooper())
    {
      this.yrd.handleMessage(Message.obtain(this.yrd, paramInt));
      AppMethodBeat.o(114409);
      return;
    }
    Nh(paramInt);
    AppMethodBeat.o(114409);
  }
  
  public final boolean aLb()
  {
    AppMethodBeat.i(114406);
    if ((dui() == this.iGj) || (this.iGk))
    {
      AppMethodBeat.o(114406);
      return true;
    }
    AppMethodBeat.o(114406);
    return false;
  }
  
  public final void aLc()
  {
    AppMethodBeat.i(114407);
    ab.d(this.mName, "toForeground");
    pw(2);
    AppMethodBeat.o(114407);
  }
  
  public final void aLd()
  {
    AppMethodBeat.i(114408);
    ab.d(this.mName, "toBackground");
    pw(1);
    AppMethodBeat.o(114408);
  }
  
  public final void avu()
  {
    AppMethodBeat.i(114411);
    super.avu();
    this.iGk = true;
    AppMethodBeat.o(114411);
  }
  
  public final void start()
  {
    AppMethodBeat.i(114410);
    if (this.mStopped)
    {
      AppMethodBeat.o(114410);
      return;
    }
    super.start();
    AppMethodBeat.o(114410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.o
 * JD-Core Version:    0.7.0.1
 */