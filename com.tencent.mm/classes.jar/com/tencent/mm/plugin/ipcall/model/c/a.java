package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public boolean isStart;
  public c qrz;
  public final Object yql;
  public int yqm;
  public boolean yqn;
  public com.tencent.mm.plugin.ipcall.model.a.a yqo;
  
  public a(com.tencent.mm.plugin.ipcall.model.a.a parama)
  {
    AppMethodBeat.i(231722);
    this.qrz = null;
    this.yql = new Object();
    this.isStart = false;
    this.yqm = 0;
    this.yqn = false;
    this.yqo = parama;
    AppMethodBeat.o(231722);
  }
  
  public final void qw(boolean paramBoolean)
  {
    AppMethodBeat.i(25417);
    Log.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(this.yqn), Boolean.valueOf(paramBoolean) });
    this.yqo.jp(paramBoolean);
    com.tencent.mm.plugin.ipcall.model.d.a locala = i.eat();
    if (paramBoolean) {}
    for (int i = locala.yqF.setAppCmd(401);; i = locala.yqF.setAppCmd(402))
    {
      if (i < 0) {
        Log.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[] { Integer.valueOf(i) });
      }
      if (paramBoolean != this.yqn)
      {
        this.yqn = paramBoolean;
        if ((this.qrz != null) && (this.qrz.GSW)) {
          this.qrz.wS(paramBoolean);
        }
      }
      AppMethodBeat.o(25417);
      return;
    }
  }
  
  public final class a
    implements Runnable
  {
    private c yqq = null;
    
    public a(c paramc)
    {
      this.yqq = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25414);
      if (this.yqq != null)
      {
        this.yqq.fFr();
        this.yqq.fFo();
        this.yqq = null;
        a.this.yqn = false;
      }
      a.this.yqo.cdV();
      AppMethodBeat.o(25414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.a
 * JD-Core Version:    0.7.0.1
 */