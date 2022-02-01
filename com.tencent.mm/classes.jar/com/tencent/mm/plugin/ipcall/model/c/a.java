package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public boolean isStart;
  public c osB;
  public final Object tJl;
  public int tJm;
  public boolean tJn;
  public com.tencent.mm.plugin.ipcall.model.a.a tJo;
  
  public a(com.tencent.mm.plugin.ipcall.model.a.a parama)
  {
    AppMethodBeat.i(196001);
    this.osB = null;
    this.tJl = new Object();
    this.isStart = false;
    this.tJm = 0;
    this.tJn = false;
    this.tJo = parama;
    AppMethodBeat.o(196001);
  }
  
  public final void np(boolean paramBoolean)
  {
    AppMethodBeat.i(25417);
    ac.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(this.tJn), Boolean.valueOf(paramBoolean) });
    this.tJo.ih(paramBoolean);
    com.tencent.mm.plugin.ipcall.model.d.a locala = i.cUw();
    if (paramBoolean) {}
    for (int i = locala.tJF.setAppCmd(401);; i = locala.tJF.setAppCmd(402))
    {
      if (i < 0) {
        ac.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[] { Integer.valueOf(i) });
      }
      if (paramBoolean != this.tJn)
      {
        this.tJn = paramBoolean;
        if ((this.osB != null) && (this.osB.Aye)) {
          this.osB.ss(paramBoolean);
        }
      }
      AppMethodBeat.o(25417);
      return;
    }
  }
  
  public final class a
    implements Runnable
  {
    private c tJq = null;
    
    public a(c paramc)
    {
      this.tJq = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25414);
      if (this.tJq != null)
      {
        this.tJq.ehi();
        this.tJq.ehf();
        this.tJq = null;
        a.this.tJn = false;
      }
      a.this.tJo.bCr();
      AppMethodBeat.o(25414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.a
 * JD-Core Version:    0.7.0.1
 */