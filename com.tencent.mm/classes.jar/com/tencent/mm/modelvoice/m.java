package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m.a;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class m
  implements a
{
  private static int jvj = 100;
  public c dyI;
  private int dyt;
  c.a dzv;
  private d jvk;
  private String mFileName;
  public int mStatus;
  
  public m()
  {
    AppMethodBeat.i(148429);
    this.mFileName = null;
    this.dyt = 0;
    this.mStatus = 0;
    this.dzv = new c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148428);
        if (m.a(m.this) != null) {
          m.a(m.this).a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt), 0, false);
        }
        m.a(m.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        Log.d("MicroMsg.SpeexRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        tq localtq = new tq();
        localtq.ead.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        localtq.ead.len = paramAnonymousInt;
        EventCenter.instance.publish(localtq);
        AppMethodBeat.o(148428);
      }
    };
    AppMethodBeat.o(148429);
  }
  
  private void clean()
  {
    AppMethodBeat.i(148432);
    if (this.dyI != null)
    {
      this.dyI.ZZ();
      this.dyI = null;
    }
    if (this.jvk != null)
    {
      this.jvk.abP();
      this.jvk = null;
    }
    AppMethodBeat.o(148432);
  }
  
  public final boolean ZZ()
  {
    AppMethodBeat.i(148431);
    this.mFileName = null;
    this.mStatus = 0;
    clean();
    AppMethodBeat.o(148431);
    return true;
  }
  
  public final void a(m.a parama) {}
  
  public final int aaa()
  {
    return this.dyI.dzA;
  }
  
  public final int getMaxAmplitude()
  {
    int i = this.dyt;
    this.dyt = 0;
    if (i > jvj) {
      jvj = i;
    }
    return i * 100 / jvj;
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
  
  public final boolean hw(String paramString)
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
    this.dyt = 0;
    this.dyI = new c(16000, 1, 0);
    this.dyI.dzk = -19;
    if (ae.gKE.gGG > 0) {
      this.dyI.x(ae.gKE.gGG, true);
    }
    for (;;)
    {
      this.dyI.dc(false);
      this.dyI.dzv = this.dzv;
      this.jvk = new d();
      if (this.jvk.hz(paramString)) {
        break;
      }
      Log.e("MicroMsg.SpeexRecorder", "init speex writer failed");
      clean();
      this.mStatus = -1;
      AppMethodBeat.o(148430);
      return false;
      this.dyI.x(5, false);
    }
    if (!this.dyI.aai())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.m
 * JD-Core Version:    0.7.0.1
 */