package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public boolean fqj;
  public boolean isStart;
  com.tencent.mm.audio.b.c.a nPS;
  public com.tencent.mm.audio.b.c sBM;
  public final Object sBN;
  int sBO;
  boolean sBP;
  int sBQ;
  boolean sBR;
  
  public c()
  {
    AppMethodBeat.i(25430);
    this.sBM = null;
    this.sBN = new Object();
    this.isStart = false;
    this.fqj = false;
    this.sBO = 92;
    this.sBP = true;
    this.sBQ = 0;
    this.sBR = true;
    this.nPS = new com.tencent.mm.audio.b.c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(25427);
        synchronized (c.this.sBN)
        {
          c localc = c.this;
          if (localc.sBO <= 10) {
            localc.sBO = 92;
          }
          a locala = i.cHn().sBG.sAQ;
          if (locala.nPx != null) {}
          for (int i = locala.nPx.dRV();; i = 0)
          {
            localc.sBO = ((i + 24 + localc.sBO * 3) / 4);
            if (!localc.sBP) {
              break;
            }
            ad.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
            locala = i.cHn().sBG.sAQ;
            i = j;
            if (locala.nPx != null) {
              i = locala.nPx.dRS();
            }
            localc.sBQ = i;
            if (localc.sBQ >= localc.sBO) {
              localc.sBQ -= localc.sBO;
            }
            localc.sBO = localc.sBQ;
            localc.sBP = false;
            if (i.cHo().ksb == 5)
            {
              if (c.this.sBR)
              {
                ad.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                c.this.sBR = false;
              }
              i.cHl().sBX.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, c.this.sBO);
            }
            AppMethodBeat.o(25427);
            return;
          }
          localc.sBO = 0;
        }
      }
    };
    this.isStart = false;
    AppMethodBeat.o(25430);
  }
  
  public final void aZs()
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
    this.sBO = i.cHn().sBG.sAQ.sBE;
    if (this.sBO <= 10)
    {
      if (this.sBO <= 0)
      {
        ad.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
        i.cHm().cHJ();
      }
      this.sBO = 92;
    }
    synchronized (this.sBN)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25428);
          try
          {
            c localc = c.this;
            localc.sBM = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 6);
            localc.sBM.hX(20);
            localc.sBM.cs(true);
            localc.sBM.Oi();
            localc.sBM.cYk = -19;
            localc.sBM.t(1, false);
            localc.sBM.cr(true);
            localc.sBM.cYv = localc.nPS;
            if (!localc.sBM.Ok())
            {
              ad.e("MicroMsg.IPCallRecorder", "start record failed");
              if (localc.sBM.cXZ != 13)
              {
                i.cHm().cHJ();
                AppMethodBeat.o(25428);
              }
            }
            else
            {
              localc.sBM.ct(localc.fqj);
            }
            AppMethodBeat.o(25428);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[] { localException.getMessage() });
            i.cHm().cHJ();
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
    if ((this.isStart) && (this.sBM != null)) {
      this.sBM.ct(paramBoolean);
    }
    this.fqj = paramBoolean;
    AppMethodBeat.o(25432);
  }
  
  public final class a
    implements Runnable
  {
    private com.tencent.mm.audio.b.c sBT = null;
    
    public a(com.tencent.mm.audio.b.c paramc)
    {
      this.sBT = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25429);
      ad.d("MicroMsg.IPCallRecorder", "do stopRecord");
      if (this.sBT != null)
      {
        this.sBT.Ob();
        this.sBT = null;
        c localc = c.this;
        localc.sBO = 92;
        localc.sBP = true;
        localc.sBQ = 0;
      }
      AppMethodBeat.o(25429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.c
 * JD-Core Version:    0.7.0.1
 */