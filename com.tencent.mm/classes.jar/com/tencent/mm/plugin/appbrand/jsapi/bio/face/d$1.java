package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

final class d$1
  implements MMActivity.a
{
  d$1(d paramd, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(3202);
    ab.i("MicroMsg.JsApiStartFaceAction", "carson: start mmOnActivityResult（） ");
    if (paramIntent == null)
    {
      ab.e("MicroMsg.JsApiStartFaceAction", "mmOnActivityResult NULL data, appId[%s], callbackId[%d]", new Object[] { this.hxW.getAppId(), Integer.valueOf(this.bAX) });
      d.a(this.hFb, this.hxW, this.bAX, null, "fail:internal error");
      AppMethodBeat.o(3202);
      return;
    }
    int i = paramIntent.getIntExtra("err_code", 0);
    int j = paramIntent.getIntExtra("scene", 0);
    int k = paramIntent.getIntExtra("countFace", 0);
    long l = paramIntent.getLongExtra("totalTime", 0L);
    int m = paramIntent.getIntExtra("err_type", 6);
    ab.i("MicroMsg.JsApiStartFaceAction", "errCode： ".concat(String.valueOf(i)));
    ab.i("MicroMsg.JsApiStartFaceAction", "scene： ".concat(String.valueOf(j)));
    ab.i("MicroMsg.JsApiStartFaceAction", "countFace： ".concat(String.valueOf(k)));
    ab.i("MicroMsg.JsApiStartFaceAction", "totalTime： ".concat(String.valueOf(l)));
    ab.i("MicroMsg.JsApiStartFaceAction", "errorType： ".concat(String.valueOf(m)));
    d locald;
    c localc;
    if (paramInt1 == 63)
    {
      ab.i("MicroMsg.JsApiStartFaceAction", "REQUEST_FACE_VERIFY_FOR_PAY resultCode: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt2 == -1)
      {
        h.qsU.e(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(i) });
        locald = this.hFb;
        localc = this.hxW;
        paramInt1 = this.bAX;
        if (paramIntent != null) {}
        for (paramIntent = paramIntent.getExtras();; paramIntent = null)
        {
          d.a(locald, localc, paramInt1, paramIntent, "ok");
          AppMethodBeat.o(3202);
          return;
        }
      }
      if (paramInt2 == 1)
      {
        h.qsU.e(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(3), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(m), Integer.valueOf(i) });
        locald = this.hFb;
        localc = this.hxW;
        paramInt1 = this.bAX;
        if (paramIntent != null) {}
        for (paramIntent = paramIntent.getExtras();; paramIntent = null)
        {
          d.a(locald, localc, paramInt1, paramIntent, "fail");
          AppMethodBeat.o(3202);
          return;
        }
      }
      if (paramInt2 == 0)
      {
        h.qsU.e(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
        locald = this.hFb;
        localc = this.hxW;
        paramInt1 = this.bAX;
        if (paramIntent == null) {
          break label581;
        }
      }
    }
    label581:
    for (paramIntent = paramIntent.getExtras();; paramIntent = null)
    {
      d.a(locald, localc, paramInt1, paramIntent, "cancel");
      AppMethodBeat.o(3202);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.1
 * JD-Core Version:    0.7.0.1
 */