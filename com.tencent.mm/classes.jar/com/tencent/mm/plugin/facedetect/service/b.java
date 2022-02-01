package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  extends a
{
  String mAppId = "";
  long qxq = -1L;
  
  public final void ag(Intent paramIntent)
  {
    AppMethodBeat.i(103871);
    this.qxq = paramIntent.getLongExtra("k_bio_id", -1L);
    this.mAppId = paramIntent.getStringExtra("key_app_id");
    ac.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", new Object[] { Long.valueOf(this.qxq), this.mAppId });
    ac.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
    if ((com.tencent.mm.plugin.facedetect.e.a.coq().qCF) && ((com.tencent.mm.plugin.facedetect.e.a.coq().cot() == a.a.qDj) || (com.tencent.mm.plugin.facedetect.e.a.coq().cot() == a.a.qDk) || (com.tencent.mm.plugin.facedetect.e.a.coq().cot() == a.a.qDl)))
    {
      final long l = bs.Gn();
      com.tencent.mm.plugin.facedetect.e.a.coq().a(new a.b()
      {
        public final void acj(String paramAnonymousString)
        {
          AppMethodBeat.i(103870);
          ac.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(bs.aO(l)), paramAnonymousString });
          if (bs.isNullOrNil(paramAnonymousString))
          {
            AppMethodBeat.o(103870);
            return;
          }
          Intent localIntent = new Intent(ai.getContext(), FaceUploadVideoService.class);
          localIntent.putExtra("key_video_file_name", paramAnonymousString);
          localIntent.putExtra("k_bio_id", b.this.qxq);
          localIntent.putExtra("key_app_id", b.this.mAppId);
          d.aZ(localIntent);
          AppMethodBeat.o(103870);
        }
      });
      AppMethodBeat.o(103871);
      return;
    }
    ac.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
    AppMethodBeat.o(103871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.b
 * JD-Core Version:    0.7.0.1
 */