package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends a
{
  String mAppId = "";
  long wwE = -1L;
  
  public final void ag(Intent paramIntent)
  {
    AppMethodBeat.i(103871);
    this.wwE = paramIntent.getLongExtra("k_bio_id", -1L);
    this.mAppId = paramIntent.getStringExtra("key_app_id");
    Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", new Object[] { Long.valueOf(this.wwE), this.mAppId });
    Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
    if ((com.tencent.mm.plugin.facedetect.e.a.diK().wAu) && ((com.tencent.mm.plugin.facedetect.e.a.diK().diN() == a.a.wAY) || (com.tencent.mm.plugin.facedetect.e.a.diK().diN() == a.a.wAZ) || (com.tencent.mm.plugin.facedetect.e.a.diK().diN() == a.a.wBa)))
    {
      final long l = Util.currentTicks();
      com.tencent.mm.plugin.facedetect.e.a.diK().a(new a.b()
      {
        public final void azE(String paramAnonymousString)
        {
          AppMethodBeat.i(103870);
          Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), paramAnonymousString });
          if (Util.isNullOrNil(paramAnonymousString))
          {
            AppMethodBeat.o(103870);
            return;
          }
          Intent localIntent = new Intent(MMApplicationContext.getContext(), FaceUploadVideoService.class);
          localIntent.putExtra("key_video_file_name", paramAnonymousString);
          localIntent.putExtra("k_bio_id", b.this.wwE);
          localIntent.putExtra("key_app_id", b.this.mAppId);
          c.startService(localIntent);
          AppMethodBeat.o(103870);
        }
      });
      AppMethodBeat.o(103871);
      return;
    }
    Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
    AppMethodBeat.o(103871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.b
 * JD-Core Version:    0.7.0.1
 */