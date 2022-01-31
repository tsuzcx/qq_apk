package com.tencent.mm.plugin.facedetect.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements a.b
{
  b$1(b paramb, long paramLong) {}
  
  public final void Cr(String paramString)
  {
    y.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(bk.cp(this.jPY)), paramString });
    if (bk.bl(paramString)) {
      return;
    }
    Intent localIntent = new Intent(ae.getContext(), FaceUploadVideoService.class);
    localIntent.putExtra("key_video_file_name", paramString);
    localIntent.putExtra("k_bio_id", this.jPZ.jNI);
    localIntent.putExtra("key_app_id", this.jPZ.mAppId);
    ae.getContext().startService(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.b.1
 * JD-Core Version:    0.7.0.1
 */