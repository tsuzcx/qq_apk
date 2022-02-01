package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public com.tencent.mm.audio.b.c JHH;
  public int JHI;
  boolean JHJ;
  int JHK;
  boolean JHL;
  public final Object hvC;
  public boolean isStart;
  public boolean lAj;
  com.tencent.mm.audio.b.c.a wTV;
  
  public c()
  {
    AppMethodBeat.i(25430);
    this.JHH = null;
    this.hvC = new Object();
    this.isStart = false;
    this.lAj = false;
    this.JHI = 92;
    this.JHJ = true;
    this.JHK = 0;
    this.JHL = true;
    this.wTV = new com.tencent.mm.audio.b.c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(25427);
        synchronized (c.this.hvC)
        {
          c localc = c.this;
          if (localc.JHI <= 10) {
            localc.JHI = 92;
          }
          a locala = h.fRt().JHB.JGP;
          if (locala.wTy != null) {}
          for (int i = locala.wTy.hVE();; i = 0)
          {
            localc.JHI = ((i + 24 + localc.JHI * 3) / 4);
            if (!localc.JHJ) {
              break;
            }
            Log.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
            locala = h.fRt().JHB.JGP;
            i = j;
            if (locala.wTy != null) {
              i = locala.wTy.hVB();
            }
            localc.JHK = i;
            if (localc.JHK >= localc.JHI) {
              localc.JHK -= localc.JHI;
            }
            localc.JHI = localc.JHK;
            localc.JHJ = false;
            if (h.fRu().sEu == 5)
            {
              if (c.this.JHL)
              {
                Log.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                c.this.JHL = false;
              }
              h.fRr().JHR.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, c.this.JHI);
            }
            AppMethodBeat.o(25427);
            return;
          }
          localc.JHI = 0;
        }
      }
    };
    this.isStart = false;
    AppMethodBeat.o(25430);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(25432);
    Log.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.isStart) && (this.JHH != null)) {
      this.JHH.eq(paramBoolean);
    }
    this.lAj = paramBoolean;
    AppMethodBeat.o(25432);
  }
  
  public final class a
    implements Runnable
  {
    private com.tencent.mm.audio.b.c JHN = null;
    
    public a(com.tencent.mm.audio.b.c paramc)
    {
      this.JHN = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25429);
      Log.d("MicroMsg.IPCallRecorder", "do stopRecord");
      if (this.JHN != null)
      {
        this.JHN.aGH();
        this.JHN = null;
        c localc = c.this;
        localc.JHI = 92;
        localc.JHJ = true;
        localc.JHK = 0;
      }
      AppMethodBeat.o(25429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.c
 * JD-Core Version:    0.7.0.1
 */