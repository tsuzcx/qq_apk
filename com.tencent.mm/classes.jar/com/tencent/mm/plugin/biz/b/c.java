package com.tencent.mm.plugin.biz.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/biz/util/TestBiz;", "", "()V", "TAG", "", "crashMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getCrashMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "crashMMKV$delegate", "Lkotlin/Lazy;", "maxViewItemCrashTimes", "", "mmkv", "getMmkv", "mmkv$delegate", "mpManifestPath", "getMpManifestPath$annotations", "getMpManifestPath", "()Ljava/lang/String;", "mpManifestPath$delegate", "needReportIdKey", "", "getNeedReportIdKey", "()Z", "setNeedReportIdKey", "(Z)V", "noOftenReadMode", "getNoOftenReadMode$annotations", "getNoOftenReadMode", "setNoOftenReadMode", "noVideoChannelMode", "getNoVideoChannelMode$annotations", "getNoVideoChannelMode", "setNoVideoChannelMode", "open", "getOpen", "open$delegate", "useDebugMpManifestPath", "getUseDebugMpManifestPath$annotations", "getUseDebugMpManifestPath", "setUseDebugMpManifestPath", "canPreloadNow", "crashTimes", "defaultInterval", "", "preloadLastTimeKey", "reportKey", "forbidDeleteCanvasFromJS", "postProcessShowView", "", "viewId", "preProcessShowView", "view", "Landroid/view/View;", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final kotlin.j exj;
  public static final c vtp;
  private static final kotlin.j vtq;
  private static boolean vtr;
  private static boolean vts;
  private static final kotlin.j vtt;
  private static boolean vtu;
  private static final kotlin.j vtv;
  private static boolean vtw;
  
  static
  {
    AppMethodBeat.i(260730);
    vtp = new c();
    exj = k.cm((a)b.vty);
    vtq = k.cm((a)a.vtx);
    vtt = k.cm((a)d.vtA);
    vtu = true;
    vtv = k.cm((a)c.vtz);
    AppMethodBeat.o(260730);
  }
  
  private static String aik(String paramString)
  {
    AppMethodBeat.i(260669);
    s.u(paramString, "<this>");
    paramString = s.X("ViewItemCrashTimes_", paramString);
    AppMethodBeat.o(260669);
    return paramString;
  }
  
  public static void ail(String paramString)
  {
    AppMethodBeat.i(260695);
    s.u(paramString, "viewId");
    daA().encode(aik(paramString), 0);
    AppMethodBeat.o(260695);
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(260660);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(260660);
    return localMultiProcessMMKV;
  }
  
  public static boolean b(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(260707);
    s.u(paramString, "preloadLastTimeKey");
    Log.d("MicroMsg.TestBiz", "do canPreloadNow %d", new Object[] { Long.valueOf(paramLong1) });
    long l = paramLong1;
    if (paramInt > 0)
    {
      if (vtu)
      {
        com.tencent.mm.plugin.webcanvas.j localj = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(paramLong2);
        vtu = false;
      }
      Log.e("MicroMsg.TestBiz", "canPreloadNow hasCrashFlag last time crashTimes=" + paramInt + ", defaultInterval=" + paramLong1);
      switch (paramInt)
      {
      default: 
        paramLong2 = 604800000L;
        if (!BuildInfo.DEBUG) {
          break;
        }
      }
    }
    for (l = paramLong1;; l = paramLong2)
    {
      paramLong2 = daA().getLong(paramString, 0L);
      paramLong1 = System.currentTimeMillis();
      paramLong2 = Math.abs(paramLong1 - paramLong2);
      if (paramLong2 < l)
      {
        Log.d("MicroMsg.TestBiz", "canPreloadNow delta(" + paramLong2 + ") < interval(" + l + ')');
        AppMethodBeat.o(260707);
        return false;
        paramLong2 = 10800000L;
        break;
        paramLong2 = 86400000L;
        break;
      }
      daA().encode(paramString, paramLong1);
      AppMethodBeat.o(260707);
      return true;
    }
  }
  
  public static MultiProcessMMKV daA()
  {
    AppMethodBeat.i(260666);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)vtq.getValue();
    AppMethodBeat.o(260666);
    return localMultiProcessMMKV;
  }
  
  public static final boolean daB()
  {
    return vtr;
  }
  
  public static final boolean daC()
  {
    return vts;
  }
  
  public static boolean daD()
  {
    AppMethodBeat.i(260678);
    boolean bool = ((Boolean)vtt.getValue()).booleanValue();
    AppMethodBeat.o(260678);
    return bool;
  }
  
  public static final String daE()
  {
    AppMethodBeat.i(260711);
    String str = (String)vtv.getValue();
    AppMethodBeat.o(260711);
    return str;
  }
  
  public static final boolean daF()
  {
    return vtw;
  }
  
  public static final void daG()
  {
    vtw = true;
  }
  
  public static boolean e(String paramString, View paramView)
  {
    AppMethodBeat.i(260688);
    s.u(paramString, "viewId");
    int i = daA().decodeInt(aik(paramString));
    if (i > 2)
    {
      Log.e("MicroMsg.TestBiz", "PreProcessShowView " + paramString + " crash too much times(" + i + "), can not show now!!");
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      AppMethodBeat.o(260688);
      return false;
    }
    daA().encode(aik(paramString), i + 1);
    AppMethodBeat.o(260688);
    return true;
  }
  
  public static final void mF(boolean paramBoolean)
  {
    vtr = paramBoolean;
  }
  
  public static final void mG(boolean paramBoolean)
  {
    vts = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<MultiProcessMMKV>
  {
    public static final a vtx;
    
    static
    {
      AppMethodBeat.i(260650);
      vtx = new a();
      AppMethodBeat.o(260650);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<MultiProcessMMKV>
  {
    public static final b vty;
    
    static
    {
      AppMethodBeat.i(260652);
      vty = new b();
      AppMethodBeat.o(260652);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<String>
  {
    public static final c vtz;
    
    static
    {
      AppMethodBeat.i(260654);
      vtz = new c();
      AppMethodBeat.o(260654);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<Boolean>
  {
    public static final d vtA;
    
    static
    {
      AppMethodBeat.i(260658);
      vtA = new d();
      AppMethodBeat.o(260658);
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