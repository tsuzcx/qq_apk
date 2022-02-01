package com.tencent.mm.plugin.biz.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.j;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/biz/util/TestBiz;", "", "()V", "TAG", "", "crashMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getCrashMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "crashMMKV$delegate", "Lkotlin/Lazy;", "maxViewItemCrashTimes", "", "mmkv", "getMmkv", "mmkv$delegate", "needReportIdKey", "", "getNeedReportIdKey", "()Z", "setNeedReportIdKey", "(Z)V", "noOftenReadMode", "noOftenReadMode$annotations", "getNoOftenReadMode", "setNoOftenReadMode", "noVideoChannelMode", "noVideoChannelMode$annotations", "getNoVideoChannelMode", "setNoVideoChannelMode", "open", "getOpen", "open$delegate", "canPreloadNow", "crashTimes", "defaultInterval", "", "preloadLastTimeKey", "reportKey", "postProcessShowView", "", "viewId", "preProcessShowView", "view", "Landroid/view/View;", "plugin-biz_release"})
public final class b
{
  private static boolean nUA;
  public static final b nUB;
  private static final f nUv;
  private static final f nUw;
  private static boolean nUx;
  private static boolean nUy;
  public static final f nUz;
  
  static
  {
    AppMethodBeat.i(188769);
    nUB = new b();
    nUv = d.g.O((a)b.nUD);
    nUw = d.g.O((a)a.nUC);
    nUz = d.g.O((a)c.nUE);
    nUA = true;
    AppMethodBeat.o(188769);
  }
  
  private static String Xm(String paramString)
  {
    AppMethodBeat.i(188765);
    p.h(paramString, "$this$crashTimes");
    paramString = "ViewItemCrashTimes_".concat(String.valueOf(paramString));
    AppMethodBeat.o(188765);
    return paramString;
  }
  
  public static void Xn(String paramString)
  {
    AppMethodBeat.i(188767);
    p.h(paramString, "viewId");
    bNw().encode(Xm(paramString), 0);
    AppMethodBeat.o(188767);
  }
  
  public static boolean a(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(188768);
    p.h(paramString, "preloadLastTimeKey");
    ae.d("MicroMsg.TestBiz", "do canPreloadNow %d", new Object[] { Long.valueOf(paramLong1) });
    long l = paramLong1;
    if (paramInt > 0)
    {
      if (nUA)
      {
        com.tencent.mm.plugin.webcanvas.g localg = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.CH(paramLong2);
        nUA = false;
      }
      ae.e("MicroMsg.TestBiz", "canPreloadNow hasCrashFlag last time crashTimes=" + paramInt + ", defaultInterval=" + paramLong1);
      if (paramInt != 1) {
        break label180;
      }
      paramLong2 = 21600000L;
      if (!j.DEBUG) {
        break label217;
      }
    }
    label180:
    label217:
    for (l = paramLong1;; l = paramLong2)
    {
      paramLong2 = bNw().getLong(paramString, 0L);
      paramLong1 = System.currentTimeMillis();
      paramLong2 = Math.abs(paramLong1 - paramLong2);
      if (paramLong2 < l)
      {
        ae.d("MicroMsg.TestBiz", "canPreloadNow delta(" + paramLong2 + ") < interval(" + l + ')');
        AppMethodBeat.o(188768);
        return false;
        if (paramInt == 2)
        {
          paramLong2 = 86400000L;
          break;
        }
        paramLong2 = 604800000L;
        break;
      }
      bNw().encode(paramString, paramLong1);
      AppMethodBeat.o(188768);
      return true;
    }
  }
  
  public static ay bNw()
  {
    AppMethodBeat.i(188764);
    ay localay = (ay)nUw.getValue();
    AppMethodBeat.o(188764);
    return localay;
  }
  
  public static final boolean bNx()
  {
    return nUx;
  }
  
  public static final boolean bNy()
  {
    return nUy;
  }
  
  public static boolean d(String paramString, View paramView)
  {
    AppMethodBeat.i(188766);
    p.h(paramString, "viewId");
    int i = bNw().decodeInt(Xm(paramString));
    if (i > 2)
    {
      ae.e("MicroMsg.TestBiz", "PreProcessShowView " + paramString + " crash too much times(" + i + "), can not show now!!");
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      AppMethodBeat.o(188766);
      return false;
    }
    bNw().encode(Xm(paramString), i + 1);
    AppMethodBeat.o(188766);
    return true;
  }
  
  public static final void jd(boolean paramBoolean)
  {
    nUx = paramBoolean;
  }
  
  public static final void je(boolean paramBoolean)
  {
    nUy = paramBoolean;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements a<ay>
  {
    public static final a nUC;
    
    static
    {
      AppMethodBeat.i(188759);
      nUC = new a();
      AppMethodBeat.o(188759);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<ay>
  {
    public static final b nUD;
    
    static
    {
      AppMethodBeat.i(188761);
      nUD = new b();
      AppMethodBeat.o(188761);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Boolean>
  {
    public static final c nUE;
    
    static
    {
      AppMethodBeat.i(188763);
      nUE = new c();
      AppMethodBeat.o(188763);
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