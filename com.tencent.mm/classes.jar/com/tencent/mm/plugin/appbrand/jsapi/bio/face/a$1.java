package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

final class a$1
  implements MMActivity.a
{
  a$1(a parama, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a locala = null;
    Object localObject2 = null;
    c localc = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    AppMethodBeat.i(3201);
    if (paramIntent != null) {
      paramInt2 = paramIntent.getIntExtra("err_code", 90199);
    }
    while (paramInt1 == 1000)
    {
      ab.i("MicroMsg.JsApiFaceAsyncBase", "alvinluo: requestWxFacePictureVerify errCode: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt2 == 0)
      {
        locala = this.hFa;
        localObject2 = this.hxW;
        paramInt1 = this.bAX;
        if (paramIntent != null) {
          localObject1 = paramIntent.getExtras();
        }
        a.a(locala, (c)localObject2, paramInt1, (Bundle)localObject1, "ok");
        AppMethodBeat.o(3201);
        return;
        paramInt2 = 90199;
      }
      else
      {
        if (paramInt2 == 90100)
        {
          localObject2 = this.hFa;
          localc = this.hxW;
          paramInt1 = this.bAX;
          localObject1 = locala;
          if (paramIntent != null) {
            localObject1 = paramIntent.getExtras();
          }
          a.a((a)localObject2, localc, paramInt1, (Bundle)localObject1, "cancel");
          AppMethodBeat.o(3201);
          return;
        }
        locala = this.hFa;
        localc = this.hxW;
        paramInt1 = this.bAX;
        localObject1 = localObject2;
        if (paramIntent != null) {
          localObject1 = paramIntent.getExtras();
        }
        a.a(locala, localc, paramInt1, (Bundle)localObject1, "fail");
        AppMethodBeat.o(3201);
        return;
      }
    }
    if (paramInt1 == 1001)
    {
      ab.i("MicroMsg.JsApiFaceAsyncBase", "hy: REQUEST_FACE_DETECT_WITH_VIDEO errCode: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt2 == 0)
      {
        locala = this.hFa;
        localObject2 = this.hxW;
        paramInt1 = this.bAX;
        localObject1 = localc;
        if (paramIntent != null) {
          localObject1 = paramIntent.getExtras();
        }
        a.a(locala, (c)localObject2, paramInt1, (Bundle)localObject1, "ok");
        AppMethodBeat.o(3201);
        return;
      }
      if (paramInt2 == 90100)
      {
        locala = this.hFa;
        localObject2 = this.hxW;
        paramInt1 = this.bAX;
        localObject1 = localObject3;
        if (paramIntent != null) {
          localObject1 = paramIntent.getExtras();
        }
        a.a(locala, (c)localObject2, paramInt1, (Bundle)localObject1, "cancel");
        AppMethodBeat.o(3201);
        return;
      }
      locala = this.hFa;
      localObject2 = this.hxW;
      paramInt1 = this.bAX;
      localObject1 = localObject4;
      if (paramIntent != null) {
        localObject1 = paramIntent.getExtras();
      }
      a.a(locala, (c)localObject2, paramInt1, (Bundle)localObject1, "fail");
    }
    AppMethodBeat.o(3201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.face.a.1
 * JD-Core Version:    0.7.0.1
 */