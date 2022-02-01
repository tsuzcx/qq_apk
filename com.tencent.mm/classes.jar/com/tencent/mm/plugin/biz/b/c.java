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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/biz/util/TestBiz;", "", "()V", "TAG", "", "crashMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getCrashMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "crashMMKV$delegate", "Lkotlin/Lazy;", "maxViewItemCrashTimes", "", "mmkv", "getMmkv", "mmkv$delegate", "mpManifestPath", "mpManifestPath$annotations", "getMpManifestPath", "()Ljava/lang/String;", "mpManifestPath$delegate", "needReportIdKey", "", "getNeedReportIdKey", "()Z", "setNeedReportIdKey", "(Z)V", "noOftenReadMode", "noOftenReadMode$annotations", "getNoOftenReadMode", "setNoOftenReadMode", "noVideoChannelMode", "noVideoChannelMode$annotations", "getNoVideoChannelMode", "setNoVideoChannelMode", "open", "getOpen", "open$delegate", "useDebugMpManifestPath", "useDebugMpManifestPath$annotations", "getUseDebugMpManifestPath", "setUseDebugMpManifestPath", "canPreloadNow", "crashTimes", "defaultInterval", "", "preloadLastTimeKey", "reportKey", "postProcessShowView", "", "viewId", "preProcessShowView", "view", "Landroid/view/View;", "plugin-biz_release"})
public final class c
{
  private static final f lrB;
  private static final f shs;
  private static boolean sht;
  private static boolean shu;
  public static final f shv;
  private static boolean shw;
  private static final f shx;
  private static boolean shy;
  public static final c shz;
  
  static
  {
    AppMethodBeat.i(205682);
    shz = new c();
    lrB = g.ar((a)b.shB);
    shs = g.ar((a)a.shA);
    shv = g.ar((a)d.shD);
    shw = true;
    shx = g.ar((a)c.shC);
    AppMethodBeat.o(205682);
  }
  
  public static boolean a(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(205676);
    p.k(paramString, "preloadLastTimeKey");
    Log.d("MicroMsg.TestBiz", "do canPreloadNow %d", new Object[] { Long.valueOf(paramLong1) });
    long l = paramLong1;
    if (paramInt > 0)
    {
      if (shw)
      {
        com.tencent.mm.plugin.webcanvas.l locall = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(paramLong2);
        shw = false;
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
      paramLong2 = cxK().getLong(paramString, 0L);
      paramLong1 = System.currentTimeMillis();
      paramLong2 = Math.abs(paramLong1 - paramLong2);
      if (paramLong2 < l)
      {
        Log.d("MicroMsg.TestBiz", "canPreloadNow delta(" + paramLong2 + ") < interval(" + l + ')');
        AppMethodBeat.o(205676);
        return false;
        if (paramInt == 2)
        {
          paramLong2 = 86400000L;
          break;
        }
        paramLong2 = 604800000L;
        break;
      }
      cxK().encode(paramString, paramLong1);
      AppMethodBeat.o(205676);
      return true;
    }
  }
  
  private static String aoO(String paramString)
  {
    AppMethodBeat.i(205668);
    p.k(paramString, "$this$crashTimes");
    paramString = "ViewItemCrashTimes_".concat(String.valueOf(paramString));
    AppMethodBeat.o(205668);
    return paramString;
  }
  
  public static void aoP(String paramString)
  {
    AppMethodBeat.i(205675);
    p.k(paramString, "viewId");
    cxK().encode(aoO(paramString), 0);
    AppMethodBeat.o(205675);
  }
  
  public static MultiProcessMMKV cxK()
  {
    AppMethodBeat.i(205667);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)shs.getValue();
    AppMethodBeat.o(205667);
    return localMultiProcessMMKV;
  }
  
  public static final boolean cxL()
  {
    return sht;
  }
  
  public static final boolean cxM()
  {
    return shu;
  }
  
  public static final String cxN()
  {
    AppMethodBeat.i(205677);
    String str = (String)shx.getValue();
    AppMethodBeat.o(205677);
    return str;
  }
  
  public static final boolean cxO()
  {
    return shy;
  }
  
  public static final void cxP()
  {
    shy = true;
  }
  
  public static boolean d(String paramString, View paramView)
  {
    AppMethodBeat.i(205674);
    p.k(paramString, "viewId");
    int i = cxK().decodeInt(aoO(paramString));
    if (i > 2)
    {
      Log.e("MicroMsg.TestBiz", "PreProcessShowView " + paramString + " crash too much times(" + i + "), can not show now!!");
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      AppMethodBeat.o(205674);
      return false;
    }
    cxK().encode(aoO(paramString), i + 1);
    AppMethodBeat.o(205674);
    return true;
  }
  
  public static final void ln(boolean paramBoolean)
  {
    sht = paramBoolean;
  }
  
  public static final void lo(boolean paramBoolean)
  {
    shu = paramBoolean;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements a<MultiProcessMMKV>
  {
    public static final a shA;
    
    static
    {
      AppMethodBeat.i(206304);
      shA = new a();
      AppMethodBeat.o(206304);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<MultiProcessMMKV>
  {
    public static final b shB;
    
    static
    {
      AppMethodBeat.i(205397);
      shB = new b();
      AppMethodBeat.o(205397);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<String>
  {
    public static final c shC;
    
    static
    {
      AppMethodBeat.i(207342);
      shC = new c();
      AppMethodBeat.o(207342);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<Boolean>
  {
    public static final d shD;
    
    static
    {
      AppMethodBeat.i(209876);
      shD = new d();
      AppMethodBeat.o(209876);
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