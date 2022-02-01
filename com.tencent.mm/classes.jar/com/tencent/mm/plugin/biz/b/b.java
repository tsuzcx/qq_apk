package com.tencent.mm.plugin.biz.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/biz/util/TestBiz;", "", "()V", "TAG", "", "crashMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getCrashMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "crashMMKV$delegate", "Lkotlin/Lazy;", "maxViewItemCrashTimes", "", "mmkv", "getMmkv", "mmkv$delegate", "needReportIdKey", "", "getNeedReportIdKey", "()Z", "setNeedReportIdKey", "(Z)V", "noOftenReadMode", "noOftenReadMode$annotations", "getNoOftenReadMode", "setNoOftenReadMode", "noVideoChannelMode", "noVideoChannelMode$annotations", "getNoVideoChannelMode", "setNoVideoChannelMode", "open", "getOpen", "open$delegate", "canPreloadNow", "crashTimes", "defaultInterval", "", "preloadLastTimeKey", "reportKey", "postProcessShowView", "", "viewId", "preProcessShowView", "view", "Landroid/view/View;", "plugin-biz_release"})
public final class b
{
  private static final d.f nOP;
  private static final d.f nOQ;
  private static boolean nOR;
  private static boolean nOS;
  public static final d.f nOT;
  private static boolean nOU;
  public static final b nOV;
  
  static
  {
    AppMethodBeat.i(207307);
    nOV = new b();
    nOP = g.O((a)b.nOX);
    nOQ = g.O((a)a.nOW);
    nOT = g.O((a)c.nOY);
    nOU = true;
    AppMethodBeat.o(207307);
  }
  
  private static String WA(String paramString)
  {
    AppMethodBeat.i(207303);
    p.h(paramString, "$this$crashTimes");
    paramString = "ViewItemCrashTimes_".concat(String.valueOf(paramString));
    AppMethodBeat.o(207303);
    return paramString;
  }
  
  public static void WB(String paramString)
  {
    AppMethodBeat.i(207305);
    p.h(paramString, "viewId");
    bMy().encode(WA(paramString), 0);
    AppMethodBeat.o(207305);
  }
  
  public static boolean a(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(207306);
    p.h(paramString, "preloadLastTimeKey");
    ad.d("MicroMsg.TestBiz", "do canPreloadNow %d", new Object[] { Long.valueOf(paramLong1) });
    if (paramInt > 0)
    {
      if (nOU)
      {
        com.tencent.mm.plugin.webcanvas.f localf = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.Cj(paramLong2);
        nOU = false;
      }
      ad.e("MicroMsg.TestBiz", "canPreloadNow hasCrashFlag last time crashTimes=" + paramInt + ", defaultInterval=" + paramLong1);
      if (paramInt == 1) {
        paramLong1 = 21600000L;
      }
    }
    for (;;)
    {
      long l = bMy().getLong(paramString, 0L);
      paramLong2 = System.currentTimeMillis();
      l = Math.abs(paramLong2 - l);
      if (l < paramLong1)
      {
        ad.d("MicroMsg.TestBiz", "canPreloadNow delta(" + l + ") < interval(" + paramLong1 + ')');
        AppMethodBeat.o(207306);
        return false;
        if (paramInt == 2) {
          paramLong1 = 86400000L;
        } else {
          paramLong1 = 604800000L;
        }
      }
      else
      {
        bMy().encode(paramString, paramLong2);
        AppMethodBeat.o(207306);
        return true;
      }
    }
  }
  
  public static final boolean bMA()
  {
    return nOS;
  }
  
  public static ax bMy()
  {
    AppMethodBeat.i(207302);
    ax localax = (ax)nOQ.getValue();
    AppMethodBeat.o(207302);
    return localax;
  }
  
  public static final boolean bMz()
  {
    return nOR;
  }
  
  public static boolean d(String paramString, View paramView)
  {
    AppMethodBeat.i(207304);
    p.h(paramString, "viewId");
    p.h(paramView, "view");
    int i = bMy().decodeInt(WA(paramString));
    if (i > 2)
    {
      ad.e("MicroMsg.TestBiz", "PreProcessShowView " + paramString + " crash too much times(" + i + "), can not show now!!");
      paramView.setVisibility(8);
      AppMethodBeat.o(207304);
      return false;
    }
    bMy().encode(WA(paramString), i + 1);
    AppMethodBeat.o(207304);
    return true;
  }
  
  public static final void jf(boolean paramBoolean)
  {
    nOR = paramBoolean;
  }
  
  public static final void jg(boolean paramBoolean)
  {
    nOS = paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements a<ax>
  {
    public static final a nOW;
    
    static
    {
      AppMethodBeat.i(207297);
      nOW = new a();
      AppMethodBeat.o(207297);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<ax>
  {
    public static final b nOX;
    
    static
    {
      AppMethodBeat.i(207299);
      nOX = new b();
      AppMethodBeat.o(207299);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Boolean>
  {
    public static final c nOY;
    
    static
    {
      AppMethodBeat.i(207301);
      nOY = new c();
      AppMethodBeat.o(207301);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.b.b
 * JD-Core Version:    0.7.0.1
 */