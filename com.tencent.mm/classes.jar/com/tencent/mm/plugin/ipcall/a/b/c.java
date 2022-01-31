package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
{
  public boolean efg;
  public boolean isStart;
  c.a kJP;
  public com.tencent.mm.audio.b.c nNR;
  public final Object nNS;
  int nNT;
  boolean nNU;
  int nNV;
  boolean nNW;
  
  public c()
  {
    AppMethodBeat.i(21815);
    this.nNR = null;
    this.nNS = new Object();
    this.isStart = false;
    this.efg = false;
    this.nNT = 92;
    this.nNU = true;
    this.nNV = 0;
    this.nNW = true;
    this.kJP = new c.1(this);
    this.isStart = false;
    AppMethodBeat.o(21815);
  }
  
  public final void aCJ()
  {
    AppMethodBeat.i(21816);
    if (this.isStart)
    {
      ab.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
      AppMethodBeat.o(21816);
      return;
    }
    ab.i("MicroMsg.IPCallRecorder", "start record");
    this.isStart = true;
    this.nNT = i.bJq().nNK.nNG;
    if (this.nNT <= 10)
    {
      if (this.nNT <= 0)
      {
        ab.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
        i.bJp().bJM();
      }
      this.nNT = 92;
    }
    synchronized (this.nNS)
    {
      d.post(new c.2(this), "IPCallRecorder_startRecord");
      AppMethodBeat.o(21816);
      return;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(21817);
    ab.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.isStart) && (this.nNR != null)) {
      this.nNR.bB(paramBoolean);
    }
    this.efg = paramBoolean;
    AppMethodBeat.o(21817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.c
 * JD-Core Version:    0.7.0.1
 */