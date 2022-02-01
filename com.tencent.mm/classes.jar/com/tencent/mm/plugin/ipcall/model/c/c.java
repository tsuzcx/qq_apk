package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
{
  public boolean ftN;
  public boolean isStart;
  com.tencent.mm.audio.b.c.a osX;
  public com.tencent.mm.audio.b.c tJu;
  public final Object tJv;
  int tJw;
  boolean tJx;
  int tJy;
  boolean tJz;
  
  public c()
  {
    AppMethodBeat.i(25430);
    this.tJu = null;
    this.tJv = new Object();
    this.isStart = false;
    this.ftN = false;
    this.tJw = 92;
    this.tJx = true;
    this.tJy = 0;
    this.tJz = true;
    this.osX = new com.tencent.mm.audio.b.c.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(25427);
        synchronized (c.this.tJv)
        {
          c localc = c.this;
          if (localc.tJw <= 10) {
            localc.tJw = 92;
          }
          a locala = i.cUy().tJo.tIz;
          if (locala.osB != null) {}
          for (int i = locala.osB.ehh();; i = 0)
          {
            localc.tJw = ((i + 24 + localc.tJw * 3) / 4);
            if (!localc.tJx) {
              break;
            }
            ac.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
            locala = i.cUy().tJo.tIz;
            i = j;
            if (locala.osB != null) {
              i = locala.osB.ehe();
            }
            localc.tJy = i;
            if (localc.tJy >= localc.tJw) {
              localc.tJy -= localc.tJw;
            }
            localc.tJw = localc.tJy;
            localc.tJx = false;
            if (i.cUz().kTr == 5)
            {
              if (c.this.tJz)
              {
                ac.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                c.this.tJz = false;
              }
              i.cUw().tJF.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, c.this.tJw);
            }
            AppMethodBeat.o(25427);
            return;
          }
          localc.tJw = 0;
        }
      }
    };
    this.isStart = false;
    AppMethodBeat.o(25430);
  }
  
  public final void bgk()
  {
    AppMethodBeat.i(25431);
    if (this.isStart)
    {
      ac.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
      AppMethodBeat.o(25431);
      return;
    }
    ac.i("MicroMsg.IPCallRecorder", "start record");
    this.isStart = true;
    this.tJw = i.cUy().tJo.tIz.tJm;
    if (this.tJw <= 10)
    {
      if (this.tJw <= 0)
      {
        ac.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
        i.cUx().cUU();
      }
      this.tJw = 92;
    }
    synchronized (this.tJv)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25428);
          try
          {
            c localc = c.this;
            localc.tJu = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 6);
            localc.tJu.hH(20);
            localc.tJu.ct(true);
            localc.tJu.Oe();
            localc.tJu.cVG = -19;
            localc.tJu.t(1, false);
            localc.tJu.cs(true);
            localc.tJu.cVR = localc.osX;
            if (!localc.tJu.Og())
            {
              ac.e("MicroMsg.IPCallRecorder", "start record failed");
              if (localc.tJu.cVv != 13)
              {
                i.cUx().cUU();
                AppMethodBeat.o(25428);
              }
            }
            else
            {
              localc.tJu.cu(localc.ftN);
            }
            AppMethodBeat.o(25428);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[] { localException.getMessage() });
            i.cUx().cUU();
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
    ac.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.isStart) && (this.tJu != null)) {
      this.tJu.cu(paramBoolean);
    }
    this.ftN = paramBoolean;
    AppMethodBeat.o(25432);
  }
  
  public final class a
    implements Runnable
  {
    private com.tencent.mm.audio.b.c tJB = null;
    
    public a(com.tencent.mm.audio.b.c paramc)
    {
      this.tJB = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25429);
      ac.d("MicroMsg.IPCallRecorder", "do stopRecord");
      if (this.tJB != null)
      {
        this.tJB.NX();
        this.tJB = null;
        c localc = c.this;
        localc.tJw = 92;
        localc.tJx = true;
        localc.tJy = 0;
      }
      AppMethodBeat.o(25429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.c
 * JD-Core Version:    0.7.0.1
 */