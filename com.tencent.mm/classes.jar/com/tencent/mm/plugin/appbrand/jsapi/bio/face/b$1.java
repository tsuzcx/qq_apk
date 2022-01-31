package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;

final class b$1
  implements MMActivity.a
{
  b$1(b paramb, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.JsApiStartFaceAction", "carson: start mmOnActivityResult（） ");
    int i = paramIntent.getIntExtra("err_code", 0);
    int j = paramIntent.getIntExtra("scene", 0);
    int k = paramIntent.getIntExtra("countFace", 0);
    long l = paramIntent.getLongExtra("totalTime", 0L);
    int m = paramIntent.getIntExtra("err_type", 6);
    y.i("MicroMsg.JsApiStartFaceAction", "errCode： " + i);
    y.i("MicroMsg.JsApiStartFaceAction", "scene： " + j);
    y.i("MicroMsg.JsApiStartFaceAction", "countFace： " + k);
    y.i("MicroMsg.JsApiStartFaceAction", "totalTime： " + l);
    y.i("MicroMsg.JsApiStartFaceAction", "errorType： " + m);
    if (paramInt1 == 63)
    {
      y.i("MicroMsg.JsApiStartFaceAction", "REQUEST_FACE_VERIFY_FOR_PAY resultCode: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt2 != -1) {
        break label303;
      }
      h.nFQ.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(i) });
      localb = this.gll;
      localc = this.ggH;
      paramInt1 = this.dIS;
      if (paramIntent == null) {
        break label298;
      }
      paramIntent = paramIntent.getExtras();
      b.a(localb, localc, paramInt1, paramIntent, "ok");
    }
    label298:
    label303:
    do
    {
      return;
      paramIntent = null;
      break;
      if (paramInt2 == 1)
      {
        h.nFQ.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(3), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(m), Integer.valueOf(i) });
        localb = this.gll;
        localc = this.ggH;
        paramInt1 = this.dIS;
        if (paramIntent != null) {}
        for (paramIntent = paramIntent.getExtras();; paramIntent = null)
        {
          b.a(localb, localc, paramInt1, paramIntent, "fail");
          return;
        }
      }
    } while (paramInt2 != 0);
    h.nFQ.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
    b localb = this.gll;
    c localc = this.ggH;
    paramInt1 = this.dIS;
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getExtras();; paramIntent = null)
    {
      b.a(localb, localc, paramInt1, paramIntent, "cancel");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.1
 * JD-Core Version:    0.7.0.1
 */