package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public final Object DQn;
  public int DQo;
  public boolean DQp;
  public com.tencent.mm.plugin.ipcall.model.a.a DQq;
  public boolean isStart;
  public c tQh;
  
  public a(com.tencent.mm.plugin.ipcall.model.a.a parama)
  {
    AppMethodBeat.i(285682);
    this.tQh = null;
    this.DQn = new Object();
    this.isStart = false;
    this.DQo = 0;
    this.DQp = false;
    this.DQq = parama;
    AppMethodBeat.o(285682);
  }
  
  public final void ty(boolean paramBoolean)
  {
    AppMethodBeat.i(25417);
    Log.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(this.DQp), Boolean.valueOf(paramBoolean) });
    this.DQq.kA(paramBoolean);
    com.tencent.mm.plugin.ipcall.model.d.a locala = i.eJr();
    if (paramBoolean) {}
    for (int i = locala.DQH.setAppCmd(401);; i = locala.DQH.setAppCmd(402))
    {
      if (i < 0) {
        Log.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[] { Integer.valueOf(i) });
      }
      if (paramBoolean != this.DQp)
      {
        this.DQp = paramBoolean;
        if ((this.tQh != null) && (this.tQh.NJh)) {
          this.tQh.AK(paramBoolean);
        }
      }
      AppMethodBeat.o(25417);
      return;
    }
  }
  
  public final class a
    implements Runnable
  {
    private c DQs = null;
    
    public a(c paramc)
    {
      this.DQs = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25414);
      if (this.DQs != null)
      {
        this.DQs.gxD();
        this.DQs.gxA();
        this.DQs = null;
        a.this.DQp = false;
      }
      a.this.DQq.crg();
      AppMethodBeat.o(25414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.a
 * JD-Core Version:    0.7.0.1
 */