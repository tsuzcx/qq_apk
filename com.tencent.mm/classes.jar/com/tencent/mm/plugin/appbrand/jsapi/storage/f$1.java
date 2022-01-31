package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.h;

final class f$1
  implements Runnable
{
  f$1(f paramf, h paramh, int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong) {}
  
  public final void run()
  {
    String str2 = null;
    AppMethodBeat.i(102034);
    Object localObject = ((b)e.q(b.class)).cc(this.hDn.getAppId()).k(this.iaq, this.val$appId, this.val$key);
    m.a locala = (m.a)localObject[0];
    String str1;
    if (locala == m.a.gZV)
    {
      str1 = (String)localObject[1];
      if (locala == m.a.gZV) {
        str2 = (String)localObject[2];
      }
      if (str1 != null) {
        break label139;
      }
    }
    label139:
    for (localObject = "fail:data not found";; localObject = "ok")
    {
      f.a(this.iat, (String)localObject, str1, str2, this.hDn, this.bAX);
      f.a(2, r.bB(this.val$key, str1), this.fET, this.hDn);
      AppMethodBeat.o(102034);
      return;
      str1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.f.1
 * JD-Core Version:    0.7.0.1
 */