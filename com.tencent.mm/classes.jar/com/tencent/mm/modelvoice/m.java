package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.j.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class m
  implements com.tencent.mm.audio.b.a
{
  private static int ixc = 100;
  private int dgf;
  public c dgu;
  c.a dhh;
  private d ixd;
  private String mFileName;
  public int mStatus;
  
  public m()
  {
    AppMethodBeat.i(148429);
    this.mFileName = null;
    this.dgf = 0;
    this.mStatus = 0;
    this.dhh = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148428);
        if (m.a(m.this) != null) {
          m.a(m.this).a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt), 0, false);
        }
        m.a(m.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        ad.d("MicroMsg.SpeexRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        sr localsr = new sr();
        localsr.dHk.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        localsr.dHk.len = paramAnonymousInt;
        com.tencent.mm.sdk.b.a.IbL.l(localsr);
        AppMethodBeat.o(148428);
      }
    };
    AppMethodBeat.o(148429);
  }
  
  private void clean()
  {
    AppMethodBeat.i(148432);
    if (this.dgu != null)
    {
      this.dgu.PG();
      this.dgu = null;
    }
    if (this.ixd != null)
    {
      this.ixd.Ry();
      this.ixd = null;
    }
    AppMethodBeat.o(148432);
  }
  
  public final boolean PG()
  {
    AppMethodBeat.i(148431);
    this.mFileName = null;
    this.mStatus = 0;
    clean();
    AppMethodBeat.o(148431);
    return true;
  }
  
  public final int PH()
  {
    return this.dgu.dhm;
  }
  
  public final void a(j.a parama) {}
  
  public final int getMaxAmplitude()
  {
    int i = this.dgf;
    this.dgf = 0;
    if (i > ixc) {
      ixc = i;
    }
    return i * 100 / ixc;
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
  
  public final boolean gz(String paramString)
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
    this.dgf = 0;
    this.dgu = new c(16000, 1, 0);
    this.dgu.dgW = -19;
    if (ae.gcP.fZh > 0) {
      this.dgu.t(ae.gcP.fZh, true);
    }
    for (;;)
    {
      this.dgu.cu(false);
      this.dgu.dhh = this.dhh;
      this.ixd = new d();
      if (this.ixd.gC(paramString)) {
        break;
      }
      ad.e("MicroMsg.SpeexRecorder", "init speex writer failed");
      clean();
      this.mStatus = -1;
      AppMethodBeat.o(148430);
      return false;
      this.dgu.t(5, false);
    }
    if (!this.dgu.PP())
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.m
 * JD-Core Version:    0.7.0.1
 */