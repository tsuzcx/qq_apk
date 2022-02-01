package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class m
  implements com.tencent.mm.audio.b.a
{
  private static int izV = 100;
  private int dhh;
  public c dhw;
  c.a dij;
  private d izW;
  private String mFileName;
  public int mStatus;
  
  public m()
  {
    AppMethodBeat.i(148429);
    this.mFileName = null;
    this.dhh = 0;
    this.mStatus = 0;
    this.dij = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148428);
        if (m.a(m.this) != null) {
          m.a(m.this).a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt), 0, false);
        }
        m.a(m.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SpeexRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        ss localss = new ss();
        localss.dIq.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        localss.dIq.len = paramAnonymousInt;
        com.tencent.mm.sdk.b.a.IvT.l(localss);
        AppMethodBeat.o(148428);
      }
    };
    AppMethodBeat.o(148429);
  }
  
  private void clean()
  {
    AppMethodBeat.i(148432);
    if (this.dhw != null)
    {
      this.dhw.PF();
      this.dhw = null;
    }
    if (this.izW != null)
    {
      this.izW.Rx();
      this.izW = null;
    }
    AppMethodBeat.o(148432);
  }
  
  public final boolean PF()
  {
    AppMethodBeat.i(148431);
    this.mFileName = null;
    this.mStatus = 0;
    clean();
    AppMethodBeat.o(148431);
    return true;
  }
  
  public final int PG()
  {
    return this.dhw.dio;
  }
  
  public final void a(j.a parama) {}
  
  public final boolean gF(String paramString)
  {
    AppMethodBeat.i(148430);
    if (!bu.isNullOrNil(this.mFileName))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148430);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SpeexRecorder", "[startRecord] fileName:%s", new Object[] { paramString });
    this.mStatus = 1;
    this.dhh = 0;
    this.dhw = new c(16000, 1, 0);
    this.dhw.dhY = -19;
    if (com.tencent.mm.compatible.deviceinfo.ae.geX.gbo > 0) {
      this.dhw.t(com.tencent.mm.compatible.deviceinfo.ae.geX.gbo, true);
    }
    for (;;)
    {
      this.dhw.cu(false);
      this.dhw.dij = this.dij;
      this.izW = new d();
      if (this.izW.gI(paramString)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SpeexRecorder", "init speex writer failed");
      clean();
      this.mStatus = -1;
      AppMethodBeat.o(148430);
      return false;
      this.dhw.t(5, false);
    }
    if (!this.dhw.PO())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SpeexRecorder", "start record failed");
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
    int i = this.dhh;
    this.dhh = 0;
    if (i > izV) {
      izV = i;
    }
    return i * 100 / izV;
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