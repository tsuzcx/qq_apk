package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.sdk.platformtools.ab;

final class WxaWidgetInitializer$1$1
  implements a.e
{
  WxaWidgetInitializer$1$1(WxaWidgetInitializer.1 param1, d paramd) {}
  
  public final void af(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(10717);
    WxaWidgetInitializer.a locala = null;
    ab.d("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", new Object[] { this.hnN.val$id, Integer.valueOf(this.hnN.gSl), Integer.valueOf(this.hnM.hqQ.wwX), paramString, Boolean.valueOf(paramBoolean) });
    u.i("MicroMsg.WxaWidgetInitializer", "tryToUpdate(id : %s, pkgType : %s, version : %s), callback(%s, %s).", new Object[] { this.hnN.val$id, Integer.valueOf(this.hnN.gSl), Integer.valueOf(this.hnM.hqQ.wwX), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject = locala;
    boolean bool1 = paramBoolean;
    if (paramBoolean)
    {
      localObject = a.b(this.hnN.val$id, paramString, this.hnN.hnK, this.hnN.gSl);
      if (localObject == null) {
        break label262;
      }
      localObject = WxaWidgetInitializer.a(this.hnN.val$id, paramString, (WxaPkgWrappingInfo)localObject, this.hnM);
      bool1 = paramBoolean;
    }
    for (;;)
    {
      if (this.hnN.hnJ != null)
      {
        locala = this.hnN.hnJ;
        String str = this.hnN.val$id;
        paramBoolean = bool2;
        if (bool1)
        {
          paramBoolean = bool2;
          if (localObject != null) {
            paramBoolean = true;
          }
        }
        locala.a(str, paramString, paramBoolean, (WxaWidgetContext)localObject);
      }
      AppMethodBeat.o(10717);
      return;
      label262:
      bool1 = false;
      localObject = locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.1.1
 * JD-Core Version:    0.7.0.1
 */