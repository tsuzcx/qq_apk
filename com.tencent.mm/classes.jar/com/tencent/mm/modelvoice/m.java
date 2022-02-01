package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.l.a;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.autogen.a.wi;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class m
  implements a
{
  private static int pex = 100;
  public c hvI;
  private int hvr;
  c.a hwy;
  private String mFileName;
  public int mStatus;
  private d pey;
  
  public m()
  {
    AppMethodBeat.i(148429);
    this.mFileName = null;
    this.hvr = 0;
    this.mStatus = 0;
    this.hwy = new c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148428);
        if (m.a(m.this) != null) {
          m.a(m.this).a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt), 0, false);
        }
        m.a(m.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        Log.d("MicroMsg.SpeexRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        wi localwi = new wi();
        localwi.hZW.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        localwi.hZW.len = paramAnonymousInt;
        localwi.publish();
        AppMethodBeat.o(148428);
      }
    };
    AppMethodBeat.o(148429);
  }
  
  private void clean()
  {
    AppMethodBeat.i(148432);
    if (this.hvI != null)
    {
      this.hvI.aGH();
      this.hvI = null;
    }
    if (this.pey != null)
    {
      this.pey.aIz();
      this.pey = null;
    }
    AppMethodBeat.o(148432);
  }
  
  public final void a(l.a parama) {}
  
  public final boolean aGH()
  {
    AppMethodBeat.i(148431);
    this.mFileName = null;
    this.mStatus = 0;
    clean();
    AppMethodBeat.o(148431);
    return true;
  }
  
  public final int aGI()
  {
    int i = this.hvr;
    this.hvr = 0;
    if (i > pex) {
      pex = i;
    }
    return i * 100 / pex;
  }
  
  public final int aGJ()
  {
    return this.hvI.hwE;
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
  
  public final boolean jL(String paramString)
  {
    AppMethodBeat.i(148430);
    if (!Util.isNullOrNil(this.mFileName))
    {
      Log.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      AppMethodBeat.o(148430);
      return false;
    }
    Log.i("MicroMsg.SpeexRecorder", "[startRecord] fileName:%s", new Object[] { paramString });
    this.mStatus = 1;
    this.hvr = 0;
    this.hvI = new c(16000, 1, 0);
    this.hvI.hwn = -19;
    if (af.lYj.lUg > 0) {
      this.hvI.O(af.lYj.lUg, true);
    }
    for (;;)
    {
      this.hvI.eo(false);
      this.hvI.hwy = this.hwy;
      this.pey = new d();
      if (this.pey.jO(paramString)) {
        break;
      }
      Log.e("MicroMsg.SpeexRecorder", "init speex writer failed");
      clean();
      this.mStatus = -1;
      AppMethodBeat.o(148430);
      return false;
      this.hvI.O(5, false);
    }
    if (!this.hvI.aGR())
    {
      Log.e("MicroMsg.SpeexRecorder", "start record failed");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelvoice.m
 * JD-Core Version:    0.7.0.1
 */