package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

final class b$1
  implements a.b
{
  b$1(b paramb, long paramLong) {}
  
  public final void atL(String paramString)
  {
    AppMethodBeat.i(103870);
    Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(Util.ticksToNow(this.zVa)), paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103870);
      return;
    }
    Intent localIntent = new Intent(MMApplicationContext.getContext(), FaceUploadVideoService.class);
    localIntent.putExtra("key_video_file_name", paramString);
    localIntent.putExtra("k_bio_id", this.zVb.zSK);
    localIntent.putExtra("key_app_id", this.zVb.mAppId);
    c.startService(localIntent);
    AppMethodBeat.o(103870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.b.1
 * JD-Core Version:    0.7.0.1
 */