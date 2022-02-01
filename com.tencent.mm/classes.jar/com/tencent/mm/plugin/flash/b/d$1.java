package com.tencent.mm.plugin.flash.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.facedetect.service.FaceUploadVideoService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

final class d$1
  implements a.b
{
  d$1(d paramd, long paramLong) {}
  
  public final void atL(String paramString)
  {
    AppMethodBeat.i(264792);
    Log.i("MicroMsg.FaceFlashManagerRecorder", "hy: video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(Util.ticksToNow(this.Hjr.startTimeMs)), paramString });
    if ((Util.isNullOrNil(paramString)) && (y.ZC(paramString)))
    {
      AppMethodBeat.o(264792);
      return;
    }
    this.Hjr.Hjn = new Intent(MMApplicationContext.getContext(), FaceUploadVideoService.class);
    this.Hjr.Hjn.putExtra("key_video_file_name", paramString);
    this.Hjr.Hjn.putExtra("k_bio_id", this.Hjq);
    this.Hjr.Hjn.putExtra("key_face_type", this.Hjr.type);
    this.Hjr.Hjn.putExtra("key_app_id", this.Hjr.mAppId);
    AppMethodBeat.o(264792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b.d.1
 * JD-Core Version:    0.7.0.1
 */