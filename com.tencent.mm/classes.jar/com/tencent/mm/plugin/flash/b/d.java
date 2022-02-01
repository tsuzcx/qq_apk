package com.tencent.mm.plugin.flash.b;

import android.content.Intent;
import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  protected boolean Hja = false;
  Intent Hjn;
  private boolean Hjo = false;
  private Camera.Parameters Hjp;
  protected String mAppId;
  long startTimeMs = 0L;
  int type = -1;
  
  public final void btV()
  {
    AppMethodBeat.i(264828);
    if ((this.Hja) && (this.Hjp != null))
    {
      Log.i("MicroMsg.FaceFlashManagerRecorder", "resetRecord");
      if ((this.Hja) && (a.dPv().isStarted()))
      {
        Log.i("MicroMsg.FaceFlashManagerRecorder", "releaseRecord");
        a.dPv().dPx();
      }
      g(this.Hjp);
    }
    AppMethodBeat.o(264828);
  }
  
  public final void dpe()
  {
    AppMethodBeat.i(264810);
    if ((this.Hja) && (!a.dPv().isStarted()))
    {
      Log.i("MicroMsg.FaceFlashManagerRecorder", "releaseRecord");
      a.dPv().aGR();
      this.startTimeMs = Util.currentTicks();
    }
    AppMethodBeat.o(264810);
  }
  
  public final void e(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(264783);
    this.Hja = paramIntent.getBooleanExtra("needVideo", false);
    a.dPv().zWF = this.Hja;
    this.mAppId = paramIntent.getStringExtra("appId");
    this.type = paramInt;
    if (paramInt == 0) {
      this.Hjo = true;
    }
    Log.i("MicroMsg.FaceFlashManagerRecorder", "needVideo %s,mAppId %s acceptVoiceFromOutSide:%s", new Object[] { Boolean.valueOf(this.Hja), this.mAppId, Boolean.valueOf(this.Hjo) });
    AppMethodBeat.o(264783);
  }
  
  public final boolean fuJ()
  {
    return this.Hja;
  }
  
  public final void fuK()
  {
    AppMethodBeat.i(264837);
    if (this.Hjn != null)
    {
      Log.i("MicroMsg.FaceFlashManagerRecorder", "sendRequestUploadVideo");
      c.startService(this.Hjn);
      this.Hjn = null;
    }
    AppMethodBeat.o(264837);
  }
  
  public final void g(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(264791);
    if (this.Hja) {
      try
      {
        this.Hjp = paramParameters;
        int i = paramParameters.getInt("rotation");
        paramParameters = paramParameters.get("preview-size").split("x");
        a.dPv().a(i, Integer.parseInt(paramParameters[0]), Integer.parseInt(paramParameters[1]), Integer.parseInt(paramParameters[0]), Integer.parseInt(paramParameters[1]), this.Hjo);
        AppMethodBeat.o(264791);
        return;
      }
      catch (Exception paramParameters) {}
    }
    AppMethodBeat.o(264791);
  }
  
  public final void rn(long paramLong)
  {
    AppMethodBeat.i(264815);
    if ((this.Hja) && (a.dPv().isStarted())) {
      a.dPv().a(new d.1(this, paramLong));
    }
    AppMethodBeat.o(264815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b.d
 * JD-Core Version:    0.7.0.1
 */