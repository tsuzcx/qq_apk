package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class c
{
  int DQA;
  boolean DQB;
  public com.tencent.mm.audio.b.c DQw;
  public final Object DQx;
  int DQy;
  boolean DQz;
  public boolean iYs;
  public boolean isStart;
  com.tencent.mm.audio.b.c.a tQF;
  
  public c()
  {
    AppMethodBeat.i(25430);
    this.DQw = null;
    this.DQx = new Object();
    this.isStart = false;
    this.iYs = false;
    this.DQy = 92;
    this.DQz = true;
    this.DQA = 0;
    this.DQB = true;
    this.tQF = new com.tencent.mm.audio.b.c.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(25427);
        synchronized (c.this.DQx)
        {
          c localc = c.this;
          if (localc.DQy <= 10) {
            localc.DQy = 92;
          }
          a locala = i.eJt().DQq.DPC;
          if (locala.tQh != null) {}
          for (int i = locala.tQh.gxC();; i = 0)
          {
            localc.DQy = ((i + 24 + localc.DQy * 3) / 4);
            if (!localc.DQz) {
              break;
            }
            Log.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
            locala = i.eJt().DQq.DPC;
            i = j;
            if (locala.tQh != null) {
              i = locala.tQh.gxz();
            }
            localc.DQA = i;
            if (localc.DQA >= localc.DQy) {
              localc.DQA -= localc.DQy;
            }
            localc.DQy = localc.DQA;
            localc.DQz = false;
            if (i.eJu().pzp == 5)
            {
              if (c.this.DQB)
              {
                Log.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                c.this.DQB = false;
              }
              i.eJr().DQH.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, c.this.DQy);
            }
            AppMethodBeat.o(25427);
            return;
          }
          localc.DQy = 0;
        }
      }
    };
    this.isStart = false;
    AppMethodBeat.o(25430);
  }
  
  public final void bRC()
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
    this.DQy = i.eJt().DQq.DPC.DQo;
    if (this.DQy <= 10)
    {
      if (this.DQy <= 0)
      {
        Log.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
        i.eJs().eJP();
      }
      this.DQy = 92;
    }
    synchronized (this.DQx)
    {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25428);
          try
          {
            c localc = c.this;
            localc.DQw = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 6);
            localc.DQw.kD(20);
            localc.DQw.dD(true);
            localc.DQw.aeR();
            localc.DQw.frZ = -19;
            localc.DQw.z(1, false);
            localc.DQw.dC(true);
            localc.DQw.fsk = localc.tQF;
            if (!localc.DQw.aeU())
            {
              Log.e("MicroMsg.IPCallRecorder", "start record failed");
              if (localc.DQw.frO != 13)
              {
                i.eJs().eJP();
                AppMethodBeat.o(25428);
              }
            }
            else
            {
              localc.DQw.dE(localc.iYs);
            }
            AppMethodBeat.o(25428);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[] { localException.getMessage() });
            i.eJs().eJP();
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
    if ((this.isStart) && (this.DQw != null)) {
      this.DQw.dE(paramBoolean);
    }
    this.iYs = paramBoolean;
    AppMethodBeat.o(25432);
  }
  
  public final class a
    implements Runnable
  {
    private com.tencent.mm.audio.b.c DQD = null;
    
    public a(com.tencent.mm.audio.b.c paramc)
    {
      this.DQD = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25429);
      Log.d("MicroMsg.IPCallRecorder", "do stopRecord");
      if (this.DQD != null)
      {
        this.DQD.aeJ();
        this.DQD = null;
        c localc = c.this;
        localc.DQy = 92;
        localc.DQz = true;
        localc.DQA = 0;
      }
      AppMethodBeat.o(25429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.c
 * JD-Core Version:    0.7.0.1
 */