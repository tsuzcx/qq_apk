package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends a
{
  String mAppId = "";
  long rhg = -1L;
  
  public final void ai(Intent paramIntent)
  {
    AppMethodBeat.i(103871);
    this.rhg = paramIntent.getLongExtra("k_bio_id", -1L);
    this.mAppId = paramIntent.getStringExtra("key_app_id");
    ad.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", new Object[] { Long.valueOf(this.rhg), this.mAppId });
    ad.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
    if ((com.tencent.mm.plugin.facedetect.e.a.ctV().rmv) && ((com.tencent.mm.plugin.facedetect.e.a.ctV().ctY() == a.a.rmZ) || (com.tencent.mm.plugin.facedetect.e.a.ctV().ctY() == a.a.rna) || (com.tencent.mm.plugin.facedetect.e.a.ctV().ctY() == a.a.rnb)))
    {
      final long l = bt.HI();
      com.tencent.mm.plugin.facedetect.e.a.ctV().a(new a.b()
      {
        public final void afY(String paramAnonymousString)
        {
          AppMethodBeat.i(103870);
          ad.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", new Object[] { Long.valueOf(bt.aO(l)), paramAnonymousString });
          if (bt.isNullOrNil(paramAnonymousString))
          {
            AppMethodBeat.o(103870);
            return;
          }
          Intent localIntent = new Intent(aj.getContext(), FaceUploadVideoService.class);
          localIntent.putExtra("key_video_file_name", paramAnonymousString);
          localIntent.putExtra("k_bio_id", b.this.rhg);
          localIntent.putExtra("key_app_id", b.this.mAppId);
          d.be(localIntent);
          AppMethodBeat.o(103870);
        }
      });
      AppMethodBeat.o(103871);
      return;
    }
    ad.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
    AppMethodBeat.o(103871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.b
 * JD-Core Version:    0.7.0.1
 */