package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class m
  implements com.tencent.mm.audio.b.a
{
  private static int idH = 100;
  private int cUP;
  c.a cVR;
  public c cVe;
  private d idI;
  private String mFileName;
  public int mStatus;
  
  public m()
  {
    AppMethodBeat.i(148429);
    this.mFileName = null;
    this.cUP = 0;
    this.mStatus = 0;
    this.cVR = new c.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148428);
        if (m.a(m.this) != null) {
          m.a(m.this).a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt), 0, false);
        }
        m.a(m.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        ac.d("MicroMsg.SpeexRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        sf localsf = new sf();
        localsf.dvj.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        localsf.dvj.len = paramAnonymousInt;
        com.tencent.mm.sdk.b.a.GpY.l(localsf);
        AppMethodBeat.o(148428);
      }
    };
    AppMethodBeat.o(148429);
  }
  
  private void clean()
  {
    AppMethodBeat.i(148432);
    if (this.cVe != null)
    {
      this.cVe.NX();
      this.cVe = null;
    }
    if (this.idI != null)
    {
      this.idI.PM();
      this.idI = null;
    }
    AppMethodBeat.o(148432);
  }
  
  public final boolean NX()
  {
    AppMethodBeat.i(148431);
    this.mFileName = null;
    this.mStatus = 0;
    clean();
    AppMethodBeat.o(148431);
    return true;
  }
  
  public final int NY()
  {
    return this.cVe.cVW;
  }
  
  public final void a(k.a parama) {}
  
  public final boolean fE(String paramString)
  {
    AppMethodBeat.i(148430);
    if (!bs.isNullOrNil(this.mFileName))
    {
      ac.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148430);
      return false;
    }
    ac.i("MicroMsg.SpeexRecorder", "[startRecord] fileName:%s", new Object[] { paramString });
    this.mStatus = 1;
    this.cUP = 0;
    this.cVe = new c(16000, 1, 0);
    this.cVe.cVG = -19;
    if (ae.fJo.fFI > 0) {
      this.cVe.t(ae.fJo.fFI, true);
    }
    for (;;)
    {
      this.cVe.cs(false);
      this.cVe.cVR = this.cVR;
      this.idI = new d();
      if (this.idI.fH(paramString)) {
        break;
      }
      ac.e("MicroMsg.SpeexRecorder", "init speex writer failed");
      clean();
      this.mStatus = -1;
      AppMethodBeat.o(148430);
      return false;
      this.cVe.t(5, false);
    }
    if (!this.cVe.Og())
    {
      ac.e("MicroMsg.SpeexRecorder", "start record failed");
      clean();
      this.mStatus = -1;
      AppMethodBeat.o(148430);
      return false;
    }
    this.mFileName = paramString;
    AppMethodBeat.o(148430);
    return true;
  }
  
  public final int getMaxAmplitude()
  {
    int i = this.cUP;
    this.cUP = 0;
    if (i > idH) {
      idH = i;
    }
    return i * 100 / idH;
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.m
 * JD-Core Version:    0.7.0.1
 */