package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final String mRP = "//biz";
  public static final a mRQ;
  
  static
  {
    AppMethodBeat.i(6447);
    mRQ = new a((byte)0);
    mRP = "//biz";
    AppMethodBeat.o(6447);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(6446);
    if ((paramArrayOfString != null) && (k.g(mRP, paramArrayOfString[0])))
    {
      if ((k.g("openbiztimeline", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ax.aFD("brandService");
        paramContext.encode("BizTimeLineOpenStatus", bt.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("showbottomnav", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        ax.aFC("WebViewUIShowBottom").encode("WebViewUIShowBottomNav", bt.getInt(paramArrayOfString[2], -1));
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("checkWebviewId", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ax.aFC("MicroMsg.BizVideoDetailUI");
        paramContext.encode("CheckWebviewId", bt.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("deleteolddata", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ax.aFD("brandService");
        paramContext.encode("BizTimeLineDeleteOldData", bt.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("addRecCard", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        k.g(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramContext = new String(paramContext, d.n.d.UTF_8);
        paramArrayOfString = ax.aFD("brandService");
        paramString = new StringBuilder("BizLatestRecommendCardInfo");
        k.g(g.afz(), "MMKernel.account()");
        paramString = com.tencent.mm.kernel.a.aeo();
        if (paramArrayOfString == null) {
          k.fvU();
        }
        paramArrayOfString.encode(paramString, paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("paySuccess", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        k.g(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramContext = bw.K(new String(paramContext, d.n.d.UTF_8), "sysmsg");
        paramArrayOfString = com.tencent.mm.plugin.brandservice.b.b.mSC;
        k.g(paramContext, "values");
        com.tencent.mm.plugin.brandservice.b.b.R(paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("profileCrash", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ax.aFD("ProfileCrashCheck");
        paramContext.encode("testCrash", bt.getInt(paramArrayOfString[2], 1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("updateAppInfo", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = paramArrayOfString[2];
        if (bt.isNullOrNil(paramContext))
        {
          AppMethodBeat.o(6446);
          return true;
        }
        com.tencent.e.h.Iye.f((Runnable)new b(paramContext), "GetAppInfoASyncThread");
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("resortbizmsgcheck", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ax.aFD("brandService");
        paramContext.encode("BizTimeLineReSortMsgCheck", bt.getInt(paramArrayOfString[2], 1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("showdigest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ax.aFD("brandService");
        paramContext.encode("BizTimeLineShowDigest", bt.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("sl", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = ax.aFC("bizCommand");
        paramContext.encode("sameLayerOpen", bt.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if (k.g("clearsubscribemsg", paramArrayOfString[1]))
      {
        com.tencent.mm.am.b.b.gZO.awD();
        AppMethodBeat.o(6446);
        return true;
      }
      if (k.g("clearimg", paramArrayOfString[1]))
      {
        com.tencent.e.h.Iye.aP((Runnable)c.mRT);
        AppMethodBeat.o(6446);
        return true;
      }
    }
    AppMethodBeat.o(6446);
    return false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand$Companion;", "", "()V", "COMMAND_BIZ", "", "init", "", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(6443);
      if (com.tencent.mm.pluginsdk.model.app.h.cn(this.mRR, true) != null) {
        aq.f((Runnable)1.mRS);
      }
      AppMethodBeat.o(6443);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c mRT;
    
    static
    {
      AppMethodBeat.i(6445);
      mRT = new c();
      AppMethodBeat.o(6445);
    }
    
    public final void run()
    {
      AppMethodBeat.i(6444);
      com.tencent.mm.vfs.i.deleteDir(com.tencent.mm.plugin.image.d.cGx());
      AppMethodBeat.o(6444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a
 * JD-Core Version:    0.7.0.1
 */