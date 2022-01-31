package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.an;
import com.tencent.mm.plugin.appbrand.launching.aa;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public enum al
{
  public static void m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(129719);
    d.ysm.b(new al.1(paramString1, paramString2, paramInt), "MicroMsg.AppBrand.RemoveUsageTask");
    AppMethodBeat.o(129719);
  }
  
  public static void n(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(129720);
    o(paramString1, paramString2, paramInt);
    AppMethodBeat.o(129720);
  }
  
  private static void o(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(129721);
    ab.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(129721);
      return;
    }
    com.tencent.mm.plugin.appbrand.app.g.auK().aM(paramString1, paramInt);
    com.tencent.mm.plugin.appbrand.app.g.auW().qD(paramString1);
    String str1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str1 = q.Aq(paramString1);
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(129721);
      return;
    }
    az.awh();
    h.bt(str1, paramInt);
    int i = com.tencent.mm.plugin.appbrand.app.g.auM().ay(str1, paramInt);
    paramString2 = new ca();
    paramString2.cZU = 1L;
    paramString2 = paramString2.gZ(str1);
    paramString2.cZW = paramInt;
    paramString2.cZX = i;
    if (com.tencent.mm.plugin.appbrand.appcache.r.avy()) {}
    boolean bool4;
    for (long l = 1L;; l = 0L)
    {
      paramString2.cZS = l;
      paramString2.ake();
      com.tencent.mm.plugin.appbrand.app.g.auT().clear(str1);
      com.tencent.mm.plugin.appbrand.app.g.auU();
      bb.clear(str1);
      if (paramInt == 0) {
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)com.tencent.mm.plugin.appbrand.app.g.w(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).qD(str1);
      }
      boolean bool1 = com.tencent.mm.plugin.appbrand.app.g.auM().at(str1, 0);
      boolean bool2 = com.tencent.mm.plugin.appbrand.app.g.auM().at(str1, 2);
      boolean bool3 = com.tencent.mm.plugin.appbrand.app.g.auM().at(str1, 1);
      bool4 = ((s)com.tencent.mm.plugin.appbrand.app.g.w(s.class)).aG(paramString1, paramInt);
      ab.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", new Object[] { paramString1, str1, Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if ((bool1) || (bool2) || (bool3)) {
        break label450;
      }
      Object localObject = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString1, new String[] { "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL" });
      if (localObject == null) {
        break;
      }
      paramString2 = ((WxaAttributes)localObject).field_smallHeadURL;
      String str2 = ((WxaAttributes)localObject).field_bigHeadURL;
      String str3 = ((WxaAttributes)localObject).field_brandIconURL;
      localObject = ((WxaAttributes)localObject).field_roundedSquareIconURL;
      i = 0;
      while (i < 4)
      {
        String str4 = new String[] { paramString2, str2, str3, localObject }[i];
        com.tencent.mm.modelappbrand.a.b.acD().qA(str4);
        i += 1;
      }
    }
    if (bool4) {
      q.At(paramString1);
    }
    for (;;)
    {
      label450:
      com.tencent.mm.plugin.appbrand.app.g.wf().yR(str1);
      ((com.tencent.luggage.sdk.customize.b)com.tencent.luggage.a.e.q(com.tencent.luggage.sdk.customize.b.class)).cc(str1).yR(str1);
      AppBrandStickyBannerLogic.b.aMO();
      com.tencent.mm.plugin.appbrand.app.g.wg().zY(str1);
      com.tencent.mm.plugin.appbrand.app.g.auG().qD(str1);
      i.zY(str1);
      JsApiOperateWXData.clear(str1);
      paramString1 = p.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).zt(str1));
      try
      {
        an.ch(paramString1, str1).awI();
      }
      catch (Exception paramString2)
      {
        try
        {
          an.ci(paramString1, str1).awI();
        }
        catch (Exception paramString2)
        {
          try
          {
            for (;;)
            {
              an.cj(paramString1, str1).awI();
              if (j.a.kQ(paramInt)) {
                ((m)com.tencent.mm.plugin.appbrand.app.g.w(m.class)).n(str1, paramInt, "{}");
              }
              AppMethodBeat.o(129721);
              return;
              com.tencent.mm.plugin.appbrand.app.g.auF().Aj(paramString1);
              break;
              paramString2 = paramString2;
              ab.e("MicroMsg.AppBrand.RemoveUsageTask", "clean NonFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
              continue;
              paramString2 = paramString2;
              ab.e("MicroMsg.AppBrand.RemoveUsageTask", "clean OpenDataNonFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              ab.e("MicroMsg.AppBrand.RemoveUsageTask", "clean ClientDataFlatten appId=%s e=%s", new Object[] { str1, paramString1 });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.al
 * JD-Core Version:    0.7.0.1
 */