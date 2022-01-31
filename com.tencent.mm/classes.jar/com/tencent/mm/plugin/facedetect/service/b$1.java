package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class b$1
  implements a.b
{
  b$1(b paramb, long paramLong) {}
  
  public final void Ns(String paramString)
  {
    AppMethodBeat.i(351);
    ab.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(bo.av(this.mko)), paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(351);
      return;
    }
    Intent localIntent = new Intent(ah.getContext(), FaceUploadVideoService.class);
    localIntent.putExtra("key_video_file_name", paramString);
    localIntent.putExtra("k_bio_id", this.mkp.mhU);
    localIntent.putExtra("key_app_id", this.mkp.mAppId);
    d.aG(localIntent);
    AppMethodBeat.o(351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.b.1
 * JD-Core Version:    0.7.0.1
 */