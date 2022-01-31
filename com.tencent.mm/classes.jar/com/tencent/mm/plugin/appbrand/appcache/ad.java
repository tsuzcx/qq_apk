package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.protocal.c.clw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public enum ad
{
  public static void a(int paramInt, bgl parambgl)
  {
    clw localclw;
    if (parambgl != null)
    {
      localclw = new clw();
      localclw.url = parambgl.url;
      localclw.bIW = parambgl.bIW;
      localclw.version = parambgl.version;
      localclw.tBf = parambgl.tBf;
      if (!parambgl.tBe) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      localclw.tYQ = i;
      localclw.bQC = parambgl.bQC;
      a(paramInt, localclw, ad.a.fDi);
      return;
    }
  }
  
  private static void a(int paramInt, clw paramclw, ad.a parama)
  {
    if (com.tencent.mm.plugin.appbrand.app.e.abb() != null)
    {
      PInt localPInt = new PInt();
      com.tencent.mm.plugin.appbrand.app.e.abb().a(paramclw, localPInt);
      boolean bool;
      if (com.tencent.mm.plugin.appbrand.app.e.abb().ak("@LibraryAppId", 0) == paramclw.version) {
        if (am.o(true, true).first == am.a.fEg)
        {
          bool = true;
          y.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(paramclw.version), Integer.valueOf(paramclw.tBf), paramclw.bIW, paramclw.url });
          if (bool)
          {
            if ((paramInt <= 0) || (bk.bl(paramclw.bQC))) {
              break label266;
            }
            n.fCD.y(paramInt, paramclw.bQC);
          }
        }
      }
      for (;;)
      {
        n.fCD.cF(true);
        u localu = new u();
        localu.field_key = "@LibraryAppId";
        localu.field_version = paramclw.version;
        if (!com.tencent.mm.plugin.appbrand.app.e.abg().b(localu, new String[] { "key", "version" }))
        {
          localu.field_updateTime = bk.UX();
          localu.field_scene = (parama.ordinal() + 1);
          com.tencent.mm.plugin.appbrand.app.e.abg().b(localu);
        }
        if ((paramclw.tBf > 0) && (localPInt.value > 0))
        {
          paramInt = paramclw.version;
          g.mo(2);
        }
        return;
        bool = false;
        break;
        bool = false;
        break;
        label266:
        n.fCD.y(-1, null);
      }
    }
    y.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
  }
  
  public static void a(clw paramclw)
  {
    a(-1, paramclw, ad.a.fDh);
  }
  
  public static void cI(boolean paramBoolean)
  {
    com.tencent.mm.sdk.f.e.post(new ad.1(paramBoolean), "WxaCommLibVersionChecker");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad
 * JD-Core Version:    0.7.0.1
 */