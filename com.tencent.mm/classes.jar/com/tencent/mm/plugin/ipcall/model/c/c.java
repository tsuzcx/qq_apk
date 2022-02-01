package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
{
  public boolean fOX;
  public boolean isStart;
  com.tencent.mm.audio.b.c.a pcW;
  public com.tencent.mm.audio.b.c uXU;
  public final Object uXV;
  int uXW;
  boolean uXX;
  int uXY;
  boolean uXZ;
  
  public c()
  {
    AppMethodBeat.i(25430);
    this.uXU = null;
    this.uXV = new Object();
    this.isStart = false;
    this.fOX = false;
    this.uXW = 92;
    this.uXX = true;
    this.uXY = 0;
    this.uXZ = true;
    this.pcW = new com.tencent.mm.audio.b.c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(25427);
        synchronized (c.this.uXV)
        {
          c localc = c.this;
          if (localc.uXW <= 10) {
            localc.uXW = 92;
          }
          a locala = i.dgB().uXO.uWZ;
          if (locala.pcA != null) {}
          for (int i = locala.pcA.eyz();; i = 0)
          {
            localc.uXW = ((i + 24 + localc.uXW * 3) / 4);
            if (!localc.uXX) {
              break;
            }
            ae.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
            locala = i.dgB().uXO.uWZ;
            i = j;
            if (locala.pcA != null) {
              i = locala.pcA.eyw();
            }
            localc.uXY = i;
            if (localc.uXY >= localc.uXW) {
              localc.uXY -= localc.uXW;
            }
            localc.uXW = localc.uXY;
            localc.uXX = false;
            if (i.dgC().lur == 5)
            {
              if (c.this.uXZ)
              {
                ae.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                c.this.uXZ = false;
              }
              i.dgz().uYf.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, c.this.uXW);
            }
            AppMethodBeat.o(25427);
            return;
          }
          localc.uXW = 0;
        }
      }
    };
    this.isStart = false;
    AppMethodBeat.o(25430);
  }
  
  public final void bkx()
  {
    AppMethodBeat.i(25431);
    if (this.isStart)
    {
      ae.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
      AppMethodBeat.o(25431);
      return;
    }
    ae.i("MicroMsg.IPCallRecorder", "start record");
    this.isStart = true;
    this.uXW = i.dgB().uXO.uWZ.uXM;
    if (this.uXW <= 10)
    {
      if (this.uXW <= 0)
      {
        ae.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
        i.dgA().dgX();
      }
      this.uXW = 92;
    }
    synchronized (this.uXV)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25428);
          try
          {
            c localc = c.this;
            localc.uXU = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 6);
            localc.uXU.hQ(20);
            localc.uXU.cv(true);
            localc.uXU.PM();
            localc.uXU.dhY = -19;
            localc.uXU.t(1, false);
            localc.uXU.cu(true);
            localc.uXU.dij = localc.pcW;
            if (!localc.uXU.PO())
            {
              ae.e("MicroMsg.IPCallRecorder", "start record failed");
              if (localc.uXU.dhN != 13)
              {
                i.dgA().dgX();
                AppMethodBeat.o(25428);
              }
            }
            else
            {
              localc.uXU.cw(localc.fOX);
            }
            AppMethodBeat.o(25428);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[] { localException.getMessage() });
            i.dgA().dgX();
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
    ae.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.isStart) && (this.uXU != null)) {
      this.uXU.cw(paramBoolean);
    }
    this.fOX = paramBoolean;
    AppMethodBeat.o(25432);
  }
  
  public final class a
    implements Runnable
  {
    private com.tencent.mm.audio.b.c uYb = null;
    
    public a(com.tencent.mm.audio.b.c paramc)
    {
      this.uYb = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25429);
      ae.d("MicroMsg.IPCallRecorder", "do stopRecord");
      if (this.uYb != null)
      {
        this.uYb.PF();
        this.uYb = null;
        c localc = c.this;
        localc.uXW = 92;
        localc.uXX = true;
        localc.uXY = 0;
      }
      AppMethodBeat.o(25429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.c
 * JD-Core Version:    0.7.0.1
 */