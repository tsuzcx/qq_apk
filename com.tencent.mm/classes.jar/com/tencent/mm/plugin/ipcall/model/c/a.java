package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public boolean isStart;
  public c nPx;
  public final Object sBD;
  public int sBE;
  public boolean sBF;
  public com.tencent.mm.plugin.ipcall.model.a.a sBG;
  
  public a(com.tencent.mm.plugin.ipcall.model.a.a parama)
  {
    AppMethodBeat.i(191185);
    this.nPx = null;
    this.sBD = new Object();
    this.isStart = false;
    this.sBE = 0;
    this.sBF = false;
    this.sBG = parama;
    AppMethodBeat.o(191185);
  }
  
  public final void mw(boolean paramBoolean)
  {
    AppMethodBeat.i(25417);
    ad.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(this.sBF), Boolean.valueOf(paramBoolean) });
    this.sBG.hJ(paramBoolean);
    com.tencent.mm.plugin.ipcall.model.d.a locala = i.cHl();
    if (paramBoolean) {}
    for (int i = locala.sBX.setAppCmd(401);; i = locala.sBX.setAppCmd(402))
    {
      if (i < 0) {
        ad.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[] { Integer.valueOf(i) });
      }
      if (paramBoolean != this.sBF)
      {
        this.sBF = paramBoolean;
        if ((this.nPx != null) && (this.nPx.zfx)) {
          this.nPx.rr(paramBoolean);
        }
      }
      AppMethodBeat.o(25417);
      return;
    }
  }
  
  public final class a
    implements Runnable
  {
    private c sBI = null;
    
    public a(c paramc)
    {
      this.sBI = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25414);
      if (this.sBI != null)
      {
        this.sBI.dRW();
        this.sBI.dRT();
        this.sBI = null;
        a.this.sBF = false;
      }
      a.this.sBG.bvv();
      AppMethodBeat.o(25414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.a
 * JD-Core Version:    0.7.0.1
 */