package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public boolean isStart;
  public c pcA;
  public final Object uXL;
  public int uXM;
  public boolean uXN;
  public com.tencent.mm.plugin.ipcall.model.a.a uXO;
  
  public a(com.tencent.mm.plugin.ipcall.model.a.a parama)
  {
    AppMethodBeat.i(186481);
    this.pcA = null;
    this.uXL = new Object();
    this.isStart = false;
    this.uXM = 0;
    this.uXN = false;
    this.uXO = parama;
    AppMethodBeat.o(186481);
  }
  
  public final void nN(boolean paramBoolean)
  {
    AppMethodBeat.i(25417);
    ae.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(this.uXN), Boolean.valueOf(paramBoolean) });
    this.uXO.io(paramBoolean);
    com.tencent.mm.plugin.ipcall.model.d.a locala = i.dgz();
    if (paramBoolean) {}
    for (int i = locala.uYf.setAppCmd(401);; i = locala.uYf.setAppCmd(402))
    {
      if (i < 0) {
        ae.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[] { Integer.valueOf(i) });
      }
      if (paramBoolean != this.uXN)
      {
        this.uXN = paramBoolean;
        if ((this.pcA != null) && (this.pcA.Cpa)) {
          this.pcA.ti(paramBoolean);
        }
      }
      AppMethodBeat.o(25417);
      return;
    }
  }
  
  public final class a
    implements Runnable
  {
    private c uXQ = null;
    
    public a(c paramc)
    {
      this.uXQ = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25414);
      if (this.uXQ != null)
      {
        this.uXQ.eyA();
        this.uXQ.eyx();
        this.uXQ = null;
        a.this.uXN = false;
      }
      a.this.uXO.bHs();
      AppMethodBeat.o(25414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.a
 * JD-Core Version:    0.7.0.1
 */