package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class m
  implements com.tencent.mm.audio.b.a
{
  private static int gat = 100;
  private int ciC;
  public c ciR;
  c.a cjD;
  private d gau;
  private String mFileName;
  public int mStatus;
  
  public m()
  {
    AppMethodBeat.i(116590);
    this.mFileName = null;
    this.ciC = 0;
    this.mStatus = 0;
    this.cjD = new c.a()
    {
      public final void bS(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void s(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(116589);
        if (m.a(m.this) != null) {
          m.a(m.this).a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt), 0, false);
        }
        m.a(m.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        ab.d("MicroMsg.SpeexRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        qe localqe = new qe();
        localqe.cGK.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        localqe.cGK.len = paramAnonymousInt;
        com.tencent.mm.sdk.b.a.ymk.l(localqe);
        AppMethodBeat.o(116589);
      }
    };
    AppMethodBeat.o(116590);
  }
  
  private void clean()
  {
    AppMethodBeat.i(116593);
    if (this.ciR != null)
    {
      this.ciR.Et();
      this.ciR = null;
    }
    if (this.gau != null)
    {
      this.gau.Fb();
      this.gau = null;
    }
    AppMethodBeat.o(116593);
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(116592);
    this.mFileName = null;
    this.mStatus = 0;
    clean();
    AppMethodBeat.o(116592);
    return true;
  }
  
  public final int Eu()
  {
    return this.ciR.cjI;
  }
  
  public final void a(j.a parama) {}
  
  public final boolean eH(String paramString)
  {
    AppMethodBeat.i(116591);
    if (!bo.isNullOrNil(this.mFileName))
    {
      ab.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(116591);
      return false;
    }
    ab.i("MicroMsg.SpeexRecorder", "[startRecord] fileName:%s", new Object[] { paramString });
    this.mStatus = 1;
    this.ciC = 0;
    this.ciR = new c(16000, 1, 0);
    this.ciR.cjs = -19;
    if (ac.erF.eoW > 0) {
      this.ciR.t(ac.erF.eoW, true);
    }
    for (;;)
    {
      this.ciR.bz(false);
      this.ciR.cjD = this.cjD;
      this.gau = new d();
      if (this.gau.eN(paramString)) {
        break;
      }
      ab.e("MicroMsg.SpeexRecorder", "init speex writer failed");
      clean();
      this.mStatus = -1;
      AppMethodBeat.o(116591);
      return false;
      this.ciR.t(5, false);
    }
    if (!this.ciR.EC())
    {
      ab.e("MicroMsg.SpeexRecorder", "start record failed");
      clean();
      this.mStatus = -1;
      AppMethodBeat.o(116591);
      return false;
    }
    this.mFileName = paramString;
    AppMethodBeat.o(116591);
    return true;
  }
  
  public final int getMaxAmplitude()
  {
    int i = this.ciC;
    this.ciC = 0;
    if (i > gat) {
      gat = i;
    }
    return i * 100 / gat;
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.m
 * JD-Core Version:    0.7.0.1
 */