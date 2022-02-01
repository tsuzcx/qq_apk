package com.tencent.mm.plugin.biz.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/biz/util/TestBiz;", "", "()V", "TAG", "", "crashMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getCrashMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "crashMMKV$delegate", "Lkotlin/Lazy;", "maxViewItemCrashTimes", "", "mmkv", "getMmkv", "mmkv$delegate", "mpManifestPath", "mpManifestPath$annotations", "getMpManifestPath", "()Ljava/lang/String;", "mpManifestPath$delegate", "needReportIdKey", "", "getNeedReportIdKey", "()Z", "setNeedReportIdKey", "(Z)V", "noOftenReadMode", "noOftenReadMode$annotations", "getNoOftenReadMode", "setNoOftenReadMode", "noVideoChannelMode", "noVideoChannelMode$annotations", "getNoVideoChannelMode", "setNoVideoChannelMode", "open", "getOpen", "open$delegate", "useDebugMpManifestPath", "useDebugMpManifestPath$annotations", "getUseDebugMpManifestPath", "setUseDebugMpManifestPath", "canPreloadNow", "crashTimes", "defaultInterval", "", "preloadLastTimeKey", "reportKey", "postProcessShowView", "", "viewId", "preProcessShowView", "view", "Landroid/view/View;", "plugin-biz_release"})
public final class c
{
  private static final f iBW;
  private static final f pfo;
  private static boolean pfp;
  private static boolean pfq;
  public static final f pfr;
  private static boolean pfs;
  private static final f pft;
  private static boolean pfu;
  public static final c pfv;
  
  static
  {
    AppMethodBeat.i(212470);
    pfv = new c();
    iBW = g.ah((a)b.pfx);
    pfo = g.ah((a)a.pfw);
    pfr = g.ah((a)d.pfz);
    pfs = true;
    pft = g.ah((a)c.pfy);
    AppMethodBeat.o(212470);
  }
  
  public static boolean a(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(212468);
    p.h(paramString, "preloadLastTimeKey");
    Log.d("MicroMsg.TestBiz", "do canPreloadNow %d", new Object[] { Long.valueOf(paramLong1) });
    long l = paramLong1;
    if (paramInt > 0)
    {
      if (pfs)
      {
        com.tencent.mm.plugin.webcanvas.l locall = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(paramLong2);
        pfs = false;
      }
      Log.e("MicroMsg.TestBiz", "canPreloadNow hasCrashFlag last time crashTimes=" + paramInt + ", defaultInterval=" + paramLong1);
      if (paramInt != 1) {
        break label180;
      }
      paramLong2 = 10800000L;
      if (!BuildInfo.DEBUG) {
        break label217;
      }
    }
    label180:
    label217:
    for (l = paramLong1;; l = paramLong2)
    {
      paramLong2 = cks().getLong(paramString, 0L);
      paramLong1 = System.currentTimeMillis();
      paramLong2 = Math.abs(paramLong1 - paramLong2);
      if (paramLong2 < l)
      {
        Log.d("MicroMsg.TestBiz", "canPreloadNow delta(" + paramLong2 + ") < interval(" + l + ')');
        AppMethodBeat.o(212468);
        return false;
        if (paramInt == 2)
        {
          paramLong2 = 86400000L;
          break;
        }
        paramLong2 = 604800000L;
        break;
      }
      cks().encode(paramString, paramLong1);
      AppMethodBeat.o(212468);
      return true;
    }
  }
  
  private static String ahi(String paramString)
  {
    AppMethodBeat.i(212465);
    p.h(paramString, "$this$crashTimes");
    paramString = "ViewItemCrashTimes_".concat(String.valueOf(paramString));
    AppMethodBeat.o(212465);
    return paramString;
  }
  
  public static void ahj(String paramString)
  {
    AppMethodBeat.i(212467);
    p.h(paramString, "viewId");
    cks().encode(ahi(paramString), 0);
    AppMethodBeat.o(212467);
  }
  
  public static MultiProcessMMKV cks()
  {
    AppMethodBeat.i(212464);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)pfo.getValue();
    AppMethodBeat.o(212464);
    return localMultiProcessMMKV;
  }
  
  public static final boolean ckt()
  {
    return pfp;
  }
  
  public static final boolean cku()
  {
    return pfq;
  }
  
  public static final String ckv()
  {
    AppMethodBeat.i(212469);
    String str = (String)pft.getValue();
    AppMethodBeat.o(212469);
    return str;
  }
  
  public static final boolean ckw()
  {
    return pfu;
  }
  
  public static final void ckx()
  {
    pfu = true;
  }
  
  public static boolean d(String paramString, View paramView)
  {
    AppMethodBeat.i(212466);
    p.h(paramString, "viewId");
    int i = cks().decodeInt(ahi(paramString));
    if (i > 2)
    {
      Log.e("MicroMsg.TestBiz", "PreProcessShowView " + paramString + " crash too much times(" + i + "), can not show now!!");
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      AppMethodBeat.o(212466);
      return false;
    }
    cks().encode(ahi(paramString), i + 1);
    AppMethodBeat.o(212466);
    return true;
  }
  
  public static final void kc(boolean paramBoolean)
  {
    pfp = paramBoolean;
  }
  
  public static final void kd(boolean paramBoolean)
  {
    pfq = paramBoolean;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements a<MultiProcessMMKV>
  {
    public static final a pfw;
    
    static
    {
      AppMethodBeat.i(212457);
      pfw = new a();
      AppMethodBeat.o(212457);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<MultiProcessMMKV>
  {
    public static final b pfx;
    
    static
    {
      AppMethodBeat.i(212459);
      pfx = new b();
      AppMethodBeat.o(212459);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<String>
  {
    public static final c pfy;
    
    static
    {
      AppMethodBeat.i(212461);
      pfy = new c();
      AppMethodBeat.o(212461);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<Boolean>
  {
    public static final d pfz;
    
    static
    {
      AppMethodBeat.i(212463);
      pfz = new d();
      AppMethodBeat.o(212463);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.b.c
 * JD-Core Version:    0.7.0.1
 */