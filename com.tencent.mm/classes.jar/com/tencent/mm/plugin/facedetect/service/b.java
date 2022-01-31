package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends a
{
  long jNI = -1L;
  String mAppId = "";
  
  public final void y(Intent paramIntent)
  {
    this.jNI = paramIntent.getLongExtra("k_bio_id", -1L);
    this.mAppId = paramIntent.getStringExtra("key_app_id");
    y.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", new Object[] { Long.valueOf(this.jNI), this.mAppId });
    y.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
    if ((com.tencent.mm.plugin.facedetect.e.a.aPj().jST) && ((com.tencent.mm.plugin.facedetect.e.a.aPj().aPm() == a.a.jTA) || (com.tencent.mm.plugin.facedetect.e.a.aPj().aPm() == a.a.jTB) || (com.tencent.mm.plugin.facedetect.e.a.aPj().aPm() == a.a.jTC)))
    {
      long l = bk.UZ();
      com.tencent.mm.plugin.facedetect.e.a.aPj().a(new b.1(this, l));
      return;
    }
    y.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.b
 * JD-Core Version:    0.7.0.1
 */