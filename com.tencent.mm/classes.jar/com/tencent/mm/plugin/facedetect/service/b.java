package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends a
{
  String mAppId = "";
  long zSK = -1L;
  
  public final void an(Intent paramIntent)
  {
    AppMethodBeat.i(103871);
    this.zSK = paramIntent.getLongExtra("k_bio_id", -1L);
    this.mAppId = paramIntent.getStringExtra("key_app_id");
    Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", new Object[] { Long.valueOf(this.zSK), this.mAppId });
    Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
    if ((com.tencent.mm.plugin.facedetect.e.a.dPv().zWF) && ((com.tencent.mm.plugin.facedetect.e.a.dPv().dPy() == a.a.zXj) || (com.tencent.mm.plugin.facedetect.e.a.dPv().dPy() == a.a.zXk) || (com.tencent.mm.plugin.facedetect.e.a.dPv().dPy() == a.a.zXl)))
    {
      long l = Util.currentTicks();
      com.tencent.mm.plugin.facedetect.e.a.dPv().a(new b.1(this, l));
      AppMethodBeat.o(103871);
      return;
    }
    Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
    AppMethodBeat.o(103871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.b
 * JD-Core Version:    0.7.0.1
 */