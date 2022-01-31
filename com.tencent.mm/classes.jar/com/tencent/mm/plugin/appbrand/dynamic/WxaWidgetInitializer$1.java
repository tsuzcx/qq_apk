package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class WxaWidgetInitializer$1
  implements Runnable
{
  WxaWidgetInitializer$1(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, String paramString3, int paramInt5, WxaWidgetInitializer.a parama, String paramString4, String paramString5) {}
  
  public final void run()
  {
    AppMethodBeat.i(10718);
    ab.d("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", new Object[] { this.val$id, Integer.valueOf(this.gSl), Integer.valueOf(this.hnF) });
    u.i("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", new Object[] { this.val$id, Integer.valueOf(this.gSl), Integer.valueOf(this.hnF) });
    long l = System.currentTimeMillis();
    v.kS(1);
    Object localObject1 = a.a(this.val$appId, this.gSl, this.hnF, this.hnG, this.fwD, this.hnH);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[] { this.val$id, Integer.valueOf(this.gSl), Integer.valueOf(this.hnF) });
      v.kS(3);
      localObject1 = new af().fA(this.val$id).fB(u.qn(this.val$id));
      ((af)localObject1).cUl = this.hnI;
      ((af)localObject1).cUh = 2L;
      ((af)localObject1).cUi = System.currentTimeMillis();
      ((af)localObject1).cUj = 2L;
      ((af)localObject1).fC(at.gU(ah.getContext())).ake();
      u.i("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[] { this.val$id, Integer.valueOf(this.gSl), Integer.valueOf(this.hnF) });
      if (this.hnJ != null) {
        this.hnJ.a(this.val$id, this.val$appId, false, null);
      }
      AppMethodBeat.o(10718);
      return;
    }
    u.i("MicroMsg.WxaWidgetInitializer", "get lauch info , replace version %d with %d", new Object[] { Integer.valueOf(this.hnF), Integer.valueOf(((d)localObject1).hqQ.wwX) });
    Object localObject2 = new af().fA(this.val$id).fB(u.qn(this.val$id));
    ((af)localObject2).cUl = this.hnI;
    ((af)localObject2).cUh = 2L;
    ((af)localObject2).cUi = System.currentTimeMillis();
    ((af)localObject2).cUj = 1L;
    ((af)localObject2).fC(at.gU(ah.getContext())).ake();
    v.kS(2);
    localObject2 = a.a(this.val$id, this.val$appId, this.hnK, this.gSl, ((d)localObject1).hqQ.wwX, this.hnL);
    if (localObject2 != null)
    {
      u.i("MicroMsg.WxaWidgetInitializer", "get WxaPkgWrapping info", new Object[0]);
      localObject1 = WxaWidgetInitializer.a(this.val$id, this.val$appId, (WxaPkgWrappingInfo)localObject2, (d)localObject1);
      if (this.hnJ != null)
      {
        localObject2 = this.hnJ;
        str = this.val$id;
        localObject3 = this.val$appId;
        if (localObject1 == null) {
          break label587;
        }
      }
      label587:
      for (boolean bool = true;; bool = false)
      {
        ((WxaWidgetInitializer.a)localObject2).a(str, (String)localObject3, bool, (WxaWidgetContext)localObject1);
        localObject1 = new dc();
        ((dc)localObject1).cOc = 1L;
        localObject1 = ((dc)localObject1).it(this.val$appId);
        ((dc)localObject1).dea = (System.currentTimeMillis() - l);
        ((dc)localObject1).ake();
        AppMethodBeat.o(10718);
        return;
      }
    }
    u.i("MicroMsg.WxaWidgetInitializer", "get widget PkgWrappingInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[] { this.val$id, Integer.valueOf(this.gSl), Integer.valueOf(((d)localObject1).hqQ.wwX) });
    if (this.hnJ != null) {
      this.hnJ.bL(this.val$id, this.val$appId);
    }
    localObject2 = this.val$id;
    String str = this.val$appId;
    Object localObject3 = this.hnK;
    int i = this.gSl;
    localObject1 = new WxaWidgetInitializer.1.1(this, (d)localObject1);
    if ((i != -2147483648) && (a.b((String)localObject2, str, (String)localObject3, i) == null))
    {
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("id", (String)localObject2);
      ((Bundle)localObject3).putString("appId", str);
      ((Bundle)localObject3).putInt("debugType", i);
      f.a("com.tencent.mm", (Parcelable)localObject3, a.d.class, new a.2((a.e)localObject1));
    }
    AppMethodBeat.o(10718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.1
 * JD-Core Version:    0.7.0.1
 */