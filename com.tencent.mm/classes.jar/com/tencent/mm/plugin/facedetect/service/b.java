package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends a
{
  String mAppId = "";
  long mhU = -1L;
  
  public final void R(Intent paramIntent)
  {
    AppMethodBeat.i(352);
    this.mhU = paramIntent.getLongExtra("k_bio_id", -1L);
    this.mAppId = paramIntent.getStringExtra("key_app_id");
    ab.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", new Object[] { Long.valueOf(this.mhU), this.mAppId });
    ab.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
    if ((com.tencent.mm.plugin.facedetect.e.a.bvo().mnp) && ((com.tencent.mm.plugin.facedetect.e.a.bvo().bvr() == a.a.mnU) || (com.tencent.mm.plugin.facedetect.e.a.bvo().bvr() == a.a.mnV) || (com.tencent.mm.plugin.facedetect.e.a.bvo().bvr() == a.a.mnW)))
    {
      long l = bo.yB();
      com.tencent.mm.plugin.facedetect.e.a.bvo().a(new b.1(this, l));
      AppMethodBeat.o(352);
      return;
    }
    ab.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
    AppMethodBeat.o(352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.b
 * JD-Core Version:    0.7.0.1
 */