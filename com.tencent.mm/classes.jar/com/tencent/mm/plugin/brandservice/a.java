package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.s;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final String nuf = "//biz";
  public static final a nug;
  
  static
  {
    AppMethodBeat.i(6447);
    nug = new a((byte)0);
    nuf = "//biz";
    AppMethodBeat.o(6447);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(6446);
    if ((paramArrayOfString != null) && (k.g(nuf, paramArrayOfString[0])))
    {
      if ((k.g("openbiztimeline", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = aw.aKU("brandService");
        paramContext.encode("BizTimeLineOpenStatus", bs.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("showbottomnav", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        aw.aKT("WebViewUIShowBottom").encode("WebViewUIShowBottomNav", bs.getInt(paramArrayOfString[2], -1));
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("checkWebviewId", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = aw.aKT("MicroMsg.BizVideoDetailUI");
        paramContext.encode("CheckWebviewId", bs.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("deleteolddata", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = aw.aKU("brandService");
        paramContext.encode("BizTimeLineDeleteOldData", bs.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("addRecCard", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        k.g(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramContext = new String(paramContext, d.n.d.UTF_8);
        paramArrayOfString = aw.aKU("brandService");
        paramString = new StringBuilder("BizLatestRecommendCardInfo");
        k.g(g.agP(), "MMKernel.account()");
        paramString = com.tencent.mm.kernel.a.afE();
        if (paramArrayOfString == null) {
          k.fOy();
        }
        paramArrayOfString.encode(paramString, paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("paySuccess", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = Base64.decode(paramArrayOfString[2], 2);
        k.g(paramContext, "Base64.decode(args[2], Base64.NO_WRAP)");
        paramContext = bv.L(new String(paramContext, d.n.d.UTF_8), "sysmsg");
        paramArrayOfString = com.tencent.mm.plugin.brandservice.b.a.nuP;
        k.g(paramContext, "values");
        com.tencent.mm.plugin.brandservice.b.a.R(paramContext);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("profileCrash", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = aw.aKU("ProfileCrashCheck");
        paramContext.encode("testCrash", bs.getInt(paramArrayOfString[2], 1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("updateAppInfo", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = paramArrayOfString[2];
        if (bs.isNullOrNil(paramContext))
        {
          AppMethodBeat.o(6446);
          return true;
        }
        com.tencent.e.h.JZN.f((Runnable)new b(paramContext), "GetAppInfoASyncThread");
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("resortbizmsgcheck", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = aw.aKU("brandService");
        paramContext.encode("BizTimeLineReSortMsgCheck", bs.getInt(paramArrayOfString[2], 1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("showdigest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = aw.aKU("brandService");
        paramContext.encode("BizTimeLineShowDigest", bs.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("oftenread", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        if (bs.getInt(paramArrayOfString[2], -1) == 0) {
          bool1 = true;
        }
        com.tencent.mm.plugin.biz.b.a.iV(bool1);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("videochannel", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        bool1 = bool2;
        if (bs.getInt(paramArrayOfString[2], -1) == 0) {
          bool1 = true;
        }
        com.tencent.mm.plugin.biz.b.a.iW(bool1);
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("sl", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = aw.aKT("bizCommand");
        paramContext.encode("sameLayerOpen", bs.getInt(paramArrayOfString[2], -1));
        paramContext.apply();
        AppMethodBeat.o(6446);
        return true;
      }
      if ((k.g("resortbizmsgtest", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
      {
        paramContext = s.GBY;
        s.Yy(bs.getInt(paramArrayOfString[2], -1));
        AppMethodBeat.o(6446);
        return true;
      }
      if (k.g("clearsubscribemsg", paramArrayOfString[1]))
      {
        b.hAn.aDv();
        AppMethodBeat.o(6446);
        return true;
      }
      if (k.g("clearimg", paramArrayOfString[1]))
      {
        com.tencent.e.h.JZN.aS((Runnable)c.nuj);
        AppMethodBeat.o(6446);
        return true;
      }
    }
    AppMethodBeat.o(6446);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand$Companion;", "", "()V", "COMMAND_BIZ", "", "init", "", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(6443);
      if (com.tencent.mm.pluginsdk.model.app.h.ct(this.nuh, true) != null) {
        ap.f((Runnable)1.nui);
      }
      AppMethodBeat.o(6443);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c nuj;
    
    static
    {
      AppMethodBeat.i(6445);
      nuj = new c();
      AppMethodBeat.o(6445);
    }
    
    public final void run()
    {
      AppMethodBeat.i(6444);
      com.tencent.mm.vfs.i.deleteDir(com.tencent.mm.plugin.image.d.cTH());
      AppMethodBeat.o(6444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a
 * JD-Core Version:    0.7.0.1
 */