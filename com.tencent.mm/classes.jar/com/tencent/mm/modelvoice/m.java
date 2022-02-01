package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.k.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class m
  implements com.tencent.mm.audio.b.a
{
  private static int hDf = 100;
  public c cXI;
  private int cXt;
  c.a cYv;
  private d hDg;
  private String mFileName;
  public int mStatus;
  
  public m()
  {
    AppMethodBeat.i(148429);
    this.mFileName = null;
    this.cXt = 0;
    this.mStatus = 0;
    this.cYv = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148428);
        if (m.a(m.this) != null) {
          m.a(m.this).a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt), 0, false);
        }
        m.a(m.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        ad.d("MicroMsg.SpeexRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        rw localrw = new rw();
        localrw.dxw.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        localrw.dxw.len = paramAnonymousInt;
        com.tencent.mm.sdk.b.a.ESL.l(localrw);
        AppMethodBeat.o(148428);
      }
    };
    AppMethodBeat.o(148429);
  }
  
  private void clean()
  {
    AppMethodBeat.i(148432);
    if (this.cXI != null)
    {
      this.cXI.Ob();
      this.cXI = null;
    }
    if (this.hDg != null)
    {
      this.hDg.PQ();
      this.hDg = null;
    }
    AppMethodBeat.o(148432);
  }
  
  public final boolean Ob()
  {
    AppMethodBeat.i(148431);
    this.mFileName = null;
    this.mStatus = 0;
    clean();
    AppMethodBeat.o(148431);
    return true;
  }
  
  public final int Oc()
  {
    return this.cXI.cYA;
  }
  
  public final void a(k.a parama) {}
  
  public final boolean fO(String paramString)
  {
    AppMethodBeat.i(148430);
    if (!bt.isNullOrNil(this.mFileName))
    {
      ad.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148430);
      return false;
    }
    ad.i("MicroMsg.SpeexRecorder", "[startRecord] fileName:%s", new Object[] { paramString });
    this.mStatus = 1;
    this.cXt = 0;
    this.cXI = new c(16000, 1, 0);
    this.cXI.cYk = -19;
    if (ae.fFH.fCb > 0) {
      this.cXI.t(ae.fFH.fCb, true);
    }
    for (;;)
    {
      this.cXI.cr(false);
      this.cXI.cYv = this.cYv;
      this.hDg = new d();
      if (this.hDg.fR(paramString)) {
        break;
      }
      ad.e("MicroMsg.SpeexRecorder", "init speex writer failed");
      clean();
      this.mStatus = -1;
      AppMethodBeat.o(148430);
      return false;
      this.cXI.t(5, false);
    }
    if (!this.cXI.Ok())
    {
      ad.e("MicroMsg.SpeexRecorder", "start record failed");
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
    int i = this.cXt;
    this.cXt = 0;
    if (i > hDf) {
      hDf = i;
    }
    return i * 100 / hDf;
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.m
 * JD-Core Version:    0.7.0.1
 */