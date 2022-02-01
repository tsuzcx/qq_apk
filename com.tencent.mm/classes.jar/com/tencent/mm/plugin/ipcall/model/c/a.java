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
  public c oVX;
  public final Object uLY;
  public int uLZ;
  public boolean uMa;
  public com.tencent.mm.plugin.ipcall.model.a.a uMb;
  
  public a(com.tencent.mm.plugin.ipcall.model.a.a parama)
  {
    AppMethodBeat.i(193221);
    this.oVX = null;
    this.uLY = new Object();
    this.isStart = false;
    this.uLZ = 0;
    this.uMa = false;
    this.uMb = parama;
    AppMethodBeat.o(193221);
  }
  
  public final void nJ(boolean paramBoolean)
  {
    AppMethodBeat.i(25417);
    ad.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(this.uMa), Boolean.valueOf(paramBoolean) });
    this.uMb.iq(paramBoolean);
    com.tencent.mm.plugin.ipcall.model.d.a locala = i.ddH();
    if (paramBoolean) {}
    for (int i = locala.uMs.setAppCmd(401);; i = locala.uMs.setAppCmd(402))
    {
      if (i < 0) {
        ad.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[] { Integer.valueOf(i) });
      }
      if (paramBoolean != this.uMa)
      {
        this.uMa = paramBoolean;
        if ((this.oVX != null) && (this.oVX.BXz)) {
          this.oVX.tb(paramBoolean);
        }
      }
      AppMethodBeat.o(25417);
      return;
    }
  }
  
  public final class a
    implements Runnable
  {
    private c uMd = null;
    
    public a(c paramc)
    {
      this.uMd = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25414);
      if (this.uMd != null)
      {
        this.uMd.euU();
        this.uMd.euR();
        this.uMd = null;
        a.this.uMa = false;
      }
      a.this.uMb.bGw();
      AppMethodBeat.o(25414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.a
 * JD-Core Version:    0.7.0.1
 */