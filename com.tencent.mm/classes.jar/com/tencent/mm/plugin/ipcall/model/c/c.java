package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class c
{
  public boolean guh;
  public boolean isStart;
  com.tencent.mm.audio.b.c.a qrW;
  public com.tencent.mm.audio.b.c yqu;
  public final Object yqv;
  int yqw;
  boolean yqx;
  int yqy;
  boolean yqz;
  
  public c()
  {
    AppMethodBeat.i(25430);
    this.yqu = null;
    this.yqv = new Object();
    this.isStart = false;
    this.guh = false;
    this.yqw = 92;
    this.yqx = true;
    this.yqy = 0;
    this.yqz = true;
    this.qrW = new com.tencent.mm.audio.b.c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(25427);
        synchronized (c.this.yqv)
        {
          c localc = c.this;
          if (localc.yqw <= 10) {
            localc.yqw = 92;
          }
          a locala = i.eav().yqo.ypA;
          if (locala.qrz != null) {}
          for (int i = locala.qrz.fFq();; i = 0)
          {
            localc.yqw = ((i + 24 + localc.yqw * 3) / 4);
            if (!localc.yqx) {
              break;
            }
            Log.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
            locala = i.eav().yqo.ypA;
            i = j;
            if (locala.qrz != null) {
              i = locala.qrz.fFn();
            }
            localc.yqy = i;
            if (localc.yqy >= localc.yqw) {
              localc.yqy -= localc.yqw;
            }
            localc.yqw = localc.yqy;
            localc.yqx = false;
            if (i.eaw().mAT == 5)
            {
              if (c.this.yqz)
              {
                Log.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                c.this.yqz = false;
              }
              i.eat().yqF.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, c.this.yqw);
            }
            AppMethodBeat.o(25427);
            return;
          }
          localc.yqw = 0;
        }
      }
    };
    this.isStart = false;
    AppMethodBeat.o(25430);
  }
  
  public final void bFT()
  {
    AppMethodBeat.i(25431);
    if (this.isStart)
    {
      Log.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
      AppMethodBeat.o(25431);
      return;
    }
    Log.i("MicroMsg.IPCallRecorder", "start record");
    this.isStart = true;
    this.yqw = i.eav().yqo.ypA.yqm;
    if (this.yqw <= 10)
    {
      if (this.yqw <= 0)
      {
        Log.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
        i.eau().eaR();
      }
      this.yqw = 92;
    }
    synchronized (this.yqv)
    {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25428);
          try
          {
            c localc = c.this;
            localc.yqu = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 6);
            localc.yqu.jk(20);
            localc.yqu.dd(true);
            localc.yqu.aag();
            localc.yqu.dzk = -19;
            localc.yqu.x(1, false);
            localc.yqu.dc(true);
            localc.yqu.dzv = localc.qrW;
            if (!localc.yqu.aai())
            {
              Log.e("MicroMsg.IPCallRecorder", "start record failed");
              if (localc.yqu.dyZ != 13)
              {
                i.eau().eaR();
                AppMethodBeat.o(25428);
              }
            }
            else
            {
              localc.yqu.de(localc.guh);
            }
            AppMethodBeat.o(25428);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[] { localException.getMessage() });
            i.eau().eaR();
            AppMethodBeat.o(25428);
          }
        }
      }, "IPCallRecorder_startRecord");
      AppMethodBeat.o(25431);
      return;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(25432);
    Log.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.isStart) && (this.yqu != null)) {
      this.yqu.de(paramBoolean);
    }
    this.guh = paramBoolean;
    AppMethodBeat.o(25432);
  }
  
  public final class a
    implements Runnable
  {
    private com.tencent.mm.audio.b.c yqB = null;
    
    public a(com.tencent.mm.audio.b.c paramc)
    {
      this.yqB = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25429);
      Log.d("MicroMsg.IPCallRecorder", "do stopRecord");
      if (this.yqB != null)
      {
        this.yqB.ZZ();
        this.yqB = null;
        c localc = c.this;
        localc.yqw = 92;
        localc.yqx = true;
        localc.yqy = 0;
      }
      AppMethodBeat.o(25429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.c
 * JD-Core Version:    0.7.0.1
 */