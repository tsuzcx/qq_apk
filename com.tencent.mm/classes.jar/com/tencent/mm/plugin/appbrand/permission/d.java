package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;

public final class d
{
  private static final LinkedList<Runnable> iBq;
  private static final d.a iBr;
  private static boolean iBs;
  private static final Set<String> iBt;
  private final int cvs;
  private final d.c iBn;
  private final com.tencent.mm.plugin.appbrand.jsapi.h iBo;
  private final String iBp;
  private final String mAppId;
  
  static
  {
    AppMethodBeat.i(102272);
    iBq = new LinkedList();
    iBr = new d.a((byte)0);
    iBs = false;
    iBt = new HashSet();
    AppMethodBeat.o(102272);
  }
  
  private d(d.c paramc, final com.tencent.mm.plugin.appbrand.jsapi.h paramh, final String paramString)
  {
    AppMethodBeat.i(102264);
    this.iBn = new d.b(paramc, paramh)
    {
      private String aKw()
      {
        AppMethodBeat.i(156376);
        String str = String.format(Locale.ENGLISH, "component[%s %s], api[%s]", new Object[] { paramh.getAppId(), paramh.getClass().getSimpleName(), paramString });
        AppMethodBeat.o(156376);
        return str;
      }
      
      public final void Ec(String paramAnonymousString)
      {
        AppMethodBeat.i(156374);
        super.Ec(paramAnonymousString);
        ab.i("MicroMsg.AppBrandJsApiUserAuth", "onDeny reason[%s] %s", new Object[] { paramAnonymousString, aKw() });
        AppMethodBeat.o(156374);
      }
      
      public final void aID()
      {
        AppMethodBeat.i(156373);
        super.aID();
        ab.i("MicroMsg.AppBrandJsApiUserAuth", "onConfirm " + aKw());
        AppMethodBeat.o(156373);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(156375);
        super.onCancel();
        ab.i("MicroMsg.AppBrandJsApiUserAuth", "onCancel " + aKw());
        AppMethodBeat.o(156375);
      }
    };
    this.iBo = paramh;
    this.mAppId = paramh.getAppId();
    this.iBp = paramString;
    this.cvs = this.iBo.getRuntime().wY().hiX.gXe;
    AppMethodBeat.o(102264);
  }
  
  public static void Ey(String paramString)
  {
    AppMethodBeat.i(102268);
    d.a locala = iBr;
    if (!bo.isNullOrNil(paramString)) {
      try
      {
        locala.iBI.remove(paramString);
        return;
      }
      finally
      {
        AppMethodBeat.o(102268);
      }
    }
    AppMethodBeat.o(102268);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString, d.c paramc)
  {
    AppMethodBeat.i(102267);
    String str = paramh.getAppId();
    if ((bo.isNullOrNil(str)) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(102267);
      return;
    }
    synchronized (iBt)
    {
      if (iBt.contains(str))
      {
        paramh = new d.8(paramh, paramString, paramc);
        m.aNS().ac(new d.9(paramh, str, paramString));
        AppMethodBeat.o(102267);
        return;
      }
      e.a(str, new d.7(str));
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString)
  {
    AppMethodBeat.i(138531);
    if (paramString.equals("getWifiList"))
    {
      paramh = paramh.getRuntime().wY();
      if (!paramh.hiU) {}
      for (boolean bool = true;; bool = false)
      {
        ab.i("MicroMsg.AppBrandJsApiUserAuth", "getWifiList jump userauth:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramh.hiU) {
          break;
        }
        AppMethodBeat.o(138531);
        return true;
      }
      AppMethodBeat.o(138531);
      return false;
    }
    AppMethodBeat.o(138531);
    return false;
  }
  
  public static boolean cP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102265);
    boolean bool = iBr.cQ(paramString1, paramString2);
    AppMethodBeat.o(102265);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d
 * JD-Core Version:    0.7.0.1
 */