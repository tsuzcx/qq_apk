package com.tencent.mm.plugin.flash.b;

import android.content.Intent;
import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.facedetect.service.FaceUploadVideoService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class d
{
  Intent BBG;
  private boolean BBH = false;
  private Camera.Parameters BBI;
  protected boolean BBu = false;
  protected String mAppId;
  long startTimeMs = 0L;
  int type = -1;
  
  public final void ND(final long paramLong)
  {
    AppMethodBeat.i(193677);
    if ((this.BBu) && (a.diK().isStarted())) {
      a.diK().a(new a.b()
      {
        public final void azE(String paramAnonymousString)
        {
          AppMethodBeat.i(194776);
          Log.i("MicroMsg.FaceFlashManagerRecorder", "hy: video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(Util.ticksToNow(d.this.startTimeMs)), paramAnonymousString });
          if ((Util.isNullOrNil(paramAnonymousString)) && (u.agG(paramAnonymousString)))
          {
            AppMethodBeat.o(194776);
            return;
          }
          d.this.BBG = new Intent(MMApplicationContext.getContext(), FaceUploadVideoService.class);
          d.this.BBG.putExtra("key_video_file_name", paramAnonymousString);
          d.this.BBG.putExtra("k_bio_id", paramLong);
          d.this.BBG.putExtra("key_face_type", d.this.type);
          d.this.BBG.putExtra("key_app_id", d.this.mAppId);
          AppMethodBeat.o(194776);
        }
      });
    }
    AppMethodBeat.o(193677);
  }
  
  public final void aYW()
  {
    AppMethodBeat.i(193678);
    if ((this.BBu) && (this.BBI != null))
    {
      Log.i("MicroMsg.FaceFlashManagerRecorder", "resetRecord");
      if ((this.BBu) && (a.diK().isStarted()))
      {
        Log.i("MicroMsg.FaceFlashManagerRecorder", "releaseRecord");
        a.diK().diM();
      }
      e(this.BBI);
    }
    AppMethodBeat.o(193678);
  }
  
  public final void bRC()
  {
    AppMethodBeat.i(193676);
    if ((this.BBu) && (!a.diK().isStarted()))
    {
      Log.i("MicroMsg.FaceFlashManagerRecorder", "releaseRecord");
      a.diK().aeU();
      this.startTimeMs = Util.currentTicks();
    }
    AppMethodBeat.o(193676);
  }
  
  public final void e(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(193673);
    if (this.BBu) {
      try
      {
        this.BBI = paramParameters;
        int i = paramParameters.getInt("rotation");
        paramParameters = paramParameters.get("preview-size").split("x");
        a.diK().a(i, Integer.parseInt(paramParameters[0]), Integer.parseInt(paramParameters[1]), Integer.parseInt(paramParameters[0]), Integer.parseInt(paramParameters[1]), this.BBH);
        AppMethodBeat.o(193673);
        return;
      }
      catch (Exception paramParameters) {}
    }
    AppMethodBeat.o(193673);
  }
  
  public final boolean epH()
  {
    return this.BBu;
  }
  
  public final void epI()
  {
    AppMethodBeat.i(193681);
    if (this.BBG != null)
    {
      Log.i("MicroMsg.FaceFlashManagerRecorder", "sendRequestUploadVideo");
      c.startService(this.BBG);
      this.BBG = null;
    }
    AppMethodBeat.o(193681);
  }
  
  public final void f(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(193667);
    this.BBu = paramIntent.getBooleanExtra("needVideo", false);
    a.diK().wAu = this.BBu;
    this.mAppId = paramIntent.getStringExtra("appId");
    this.type = paramInt;
    if (paramInt == 0) {
      this.BBH = true;
    }
    Log.i("MicroMsg.FaceFlashManagerRecorder", "needVideo %s,mAppId %s acceptVoiceFromOutSide:%s", new Object[] { Boolean.valueOf(this.BBu), this.mAppId, Boolean.valueOf(this.BBH) });
    AppMethodBeat.o(193667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b.d
 * JD-Core Version:    0.7.0.1
 */