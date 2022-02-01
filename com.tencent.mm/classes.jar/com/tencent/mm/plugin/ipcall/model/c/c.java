package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public boolean fMP;
  public boolean isStart;
  com.tencent.mm.audio.b.c.a oWt;
  public com.tencent.mm.audio.b.c uMh;
  public final Object uMi;
  int uMj;
  boolean uMk;
  int uMl;
  boolean uMm;
  
  public c()
  {
    AppMethodBeat.i(25430);
    this.uMh = null;
    this.uMi = new Object();
    this.isStart = false;
    this.fMP = false;
    this.uMj = 92;
    this.uMk = true;
    this.uMl = 0;
    this.uMm = true;
    this.oWt = new com.tencent.mm.audio.b.c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(25427);
        synchronized (c.this.uMi)
        {
          c localc = c.this;
          if (localc.uMj <= 10) {
            localc.uMj = 92;
          }
          a locala = i.ddJ().uMb.uLm;
          if (locala.oVX != null) {}
          for (int i = locala.oVX.euT();; i = 0)
          {
            localc.uMj = ((i + 24 + localc.uMj * 3) / 4);
            if (!localc.uMk) {
              break;
            }
            ad.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
            locala = i.ddJ().uMb.uLm;
            i = j;
            if (locala.oVX != null) {
              i = locala.oVX.euQ();
            }
            localc.uMl = i;
            if (localc.uMl >= localc.uMj) {
              localc.uMl -= localc.uMj;
            }
            localc.uMj = localc.uMl;
            localc.uMk = false;
            if (i.ddK().lpU == 5)
            {
              if (c.this.uMm)
              {
                ad.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                c.this.uMm = false;
              }
              i.ddH().uMs.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, c.this.uMj);
            }
            AppMethodBeat.o(25427);
            return;
          }
          localc.uMj = 0;
        }
      }
    };
    this.isStart = false;
    AppMethodBeat.o(25430);
  }
  
  public final void bjO()
  {
    AppMethodBeat.i(25431);
    if (this.isStart)
    {
      ad.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
      AppMethodBeat.o(25431);
      return;
    }
    ad.i("MicroMsg.IPCallRecorder", "start record");
    this.isStart = true;
    this.uMj = i.ddJ().uMb.uLm.uLZ;
    if (this.uMj <= 10)
    {
      if (this.uMj <= 0)
      {
        ad.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
        i.ddI().def();
      }
      this.uMj = 92;
    }
    synchronized (this.uMi)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25428);
          try
          {
            c localc = c.this;
            localc.uMh = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 6);
            localc.uMh.hO(20);
            localc.uMh.cv(true);
            localc.uMh.PN();
            localc.uMh.dgW = -19;
            localc.uMh.t(1, false);
            localc.uMh.cu(true);
            localc.uMh.dhh = localc.oWt;
            if (!localc.uMh.PP())
            {
              ad.e("MicroMsg.IPCallRecorder", "start record failed");
              if (localc.uMh.dgL != 13)
              {
                i.ddI().def();
                AppMethodBeat.o(25428);
              }
            }
            else
            {
              localc.uMh.cw(localc.fMP);
            }
            AppMethodBeat.o(25428);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[] { localException.getMessage() });
            i.ddI().def();
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
    ad.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.isStart) && (this.uMh != null)) {
      this.uMh.cw(paramBoolean);
    }
    this.fMP = paramBoolean;
    AppMethodBeat.o(25432);
  }
  
  public final class a
    implements Runnable
  {
    private com.tencent.mm.audio.b.c uMo = null;
    
    public a(com.tencent.mm.audio.b.c paramc)
    {
      this.uMo = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25429);
      ad.d("MicroMsg.IPCallRecorder", "do stopRecord");
      if (this.uMo != null)
      {
        this.uMo.PG();
        this.uMo = null;
        c localc = c.this;
        localc.uMj = 92;
        localc.uMk = true;
        localc.uMl = 0;
      }
      AppMethodBeat.o(25429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.c
 * JD-Core Version:    0.7.0.1
 */