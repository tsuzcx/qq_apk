package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.m.a;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.f.a.us;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class m
  implements a
{
  private static int mkM = 100;
  private int fri;
  public c frx;
  c.a fsk;
  private String mFileName;
  public int mStatus;
  private d mkN;
  
  public m()
  {
    AppMethodBeat.i(148429);
    this.mFileName = null;
    this.fri = 0;
    this.mStatus = 0;
    this.fsk = new c.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148428);
        if (m.a(m.this) != null) {
          m.a(m.this).a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt), 0, false);
        }
        m.a(m.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        Log.d("MicroMsg.SpeexRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        us localus = new us();
        localus.fTY.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        localus.fTY.fTZ = paramAnonymousInt;
        EventCenter.instance.publish(localus);
        AppMethodBeat.o(148428);
      }
    };
    AppMethodBeat.o(148429);
  }
  
  private void clean()
  {
    AppMethodBeat.i(148432);
    if (this.frx != null)
    {
      this.frx.aeJ();
      this.frx = null;
    }
    if (this.mkN != null)
    {
      this.mkN.agC();
      this.mkN = null;
    }
    AppMethodBeat.o(148432);
  }
  
  public final void a(m.a parama) {}
  
  public final boolean aeJ()
  {
    AppMethodBeat.i(148431);
    this.mFileName = null;
    this.mStatus = 0;
    clean();
    AppMethodBeat.o(148431);
    return true;
  }
  
  public final int aeK()
  {
    int i = this.fri;
    this.fri = 0;
    if (i > mkM) {
      mkM = i;
    }
    return i * 100 / mkM;
  }
  
  public final int aeL()
  {
    return this.frx.fsp;
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
  
  public final boolean ik(String paramString)
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
    this.fri = 0;
    this.frx = new c(16000, 1, 0);
    this.frx.frZ = -19;
    if (af.juS.jqS > 0) {
      this.frx.z(af.juS.jqS, true);
    }
    for (;;)
    {
      this.frx.dC(false);
      this.frx.fsk = this.fsk;
      this.mkN = new d();
      if (this.mkN.in(paramString)) {
        break;
      }
      Log.e("MicroMsg.SpeexRecorder", "init speex writer failed");
      clean();
      this.mStatus = -1;
      AppMethodBeat.o(148430);
      return false;
      this.frx.z(5, false);
    }
    if (!this.frx.aeU())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoice.m
 * JD-Core Version:    0.7.0.1
 */