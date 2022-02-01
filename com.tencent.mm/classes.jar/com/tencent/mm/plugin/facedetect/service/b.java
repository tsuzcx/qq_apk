package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  extends a
{
  String mAppId = "";
  long rpk = -1L;
  
  public final void aj(Intent paramIntent)
  {
    AppMethodBeat.i(103871);
    this.rpk = paramIntent.getLongExtra("k_bio_id", -1L);
    this.mAppId = paramIntent.getStringExtra("key_app_id");
    ae.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", new Object[] { Long.valueOf(this.rpk), this.mAppId });
    ae.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
    if ((com.tencent.mm.plugin.facedetect.e.a.cvw().ruA) && ((com.tencent.mm.plugin.facedetect.e.a.cvw().cvz() == a.a.rve) || (com.tencent.mm.plugin.facedetect.e.a.cvw().cvz() == a.a.rvf) || (com.tencent.mm.plugin.facedetect.e.a.cvw().cvz() == a.a.rvg)))
    {
      final long l = bu.HQ();
      com.tencent.mm.plugin.facedetect.e.a.cvw().a(new a.b()
      {
        public final void agU(String paramAnonymousString)
        {
          AppMethodBeat.i(103870);
          ae.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(bu.aO(l)), paramAnonymousString });
          if (bu.isNullOrNil(paramAnonymousString))
          {
            AppMethodBeat.o(103870);
            return;
          }
          Intent localIntent = new Intent(ak.getContext(), FaceUploadVideoService.class);
          localIntent.putExtra("key_video_file_name", paramAnonymousString);
          localIntent.putExtra("k_bio_id", b.this.rpk);
          localIntent.putExtra("key_app_id", b.this.mAppId);
          d.bf(localIntent);
          AppMethodBeat.o(103870);
        }
      });
      AppMethodBeat.o(103871);
      return;
    }
    ae.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
    AppMethodBeat.o(103871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.b
 * JD-Core Version:    0.7.0.1
 */