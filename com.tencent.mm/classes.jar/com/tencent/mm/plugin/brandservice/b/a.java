package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.g.a.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/model/BizPayLogic;", "", "()V", "TAG", "", "isPayReadingOpen", "", "()I", "setPayReadingOpen", "(I)V", "payMMkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPayMMkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setPayMMkv", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V", "appMsgPaySuccess", "", "url", "itemShowType", "getPayIcon", "scene", "isPaid", "", "onPaySuccessNotify", "values", "", "payMmkv", "setPayStatus", "setPayStatusById", "id", "setTitleText", "text", "", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "isPaySubscribe", "item", "Lcom/tencent/mm/message/BizReaderItem;", "plugin-brandservice_release"})
public final class a
{
  private static final String TAG = "MicroMsg.BizPayLogic";
  private static MultiProcessMMKV pmR;
  private static int pmS;
  public static final a pmT;
  
  static
  {
    AppMethodBeat.i(6497);
    pmT = new a();
    TAG = "MicroMsg.BizPayLogic";
    pmS = -1;
    AppMethodBeat.o(6497);
  }
  
  public static void aH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6489);
    p.h(paramString, "url");
    g localg = g.pnw;
    paramString = g.ahJ(paramString);
    if (paramBoolean)
    {
      clq().encode(paramString, 1);
      AppMethodBeat.o(6489);
      return;
    }
    clq().remove(paramString);
    AppMethodBeat.o(6489);
  }
  
  public static boolean ahI(String paramString)
  {
    AppMethodBeat.i(6490);
    if (paramString == null)
    {
      AppMethodBeat.o(6490);
      return false;
    }
    MultiProcessMMKV localMultiProcessMMKV = clq();
    g localg = g.pnw;
    if (localMultiProcessMMKV.decodeInt(g.ahJ(paramString), 0) == 1)
    {
      AppMethodBeat.o(6490);
      return true;
    }
    AppMethodBeat.o(6490);
    return false;
  }
  
  private static int cG(String paramString, int paramInt)
  {
    AppMethodBeat.i(162409);
    String str = LocaleUtil.getApplicationLanguage();
    boolean bool1 = ao.isDarkMode();
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.pfC;
    boolean bool2 = com.tencent.mm.plugin.bizui.a.a.CJ(paramInt);
    if (ahI(paramString))
    {
      if (str == null) {}
      while (bool1)
      {
        AppMethodBeat.o(162409);
        return 2131231272;
        switch (str.hashCode())
        {
        default: 
          break;
        case 115861276: 
          if (str.equals("zh_CN")) {
            if (bool1)
            {
              AppMethodBeat.o(162409);
              return 2131231271;
            }
          }
          break;
        case 115861428: 
          if (!str.equals("zh_HK")) {}
          break;
        case 115861812: 
          for (;;)
          {
            if (!bool1) {
              break label168;
            }
            AppMethodBeat.o(162409);
            return 2131231273;
            if (!str.equals("zh_TW")) {
              break;
            }
          }
          if (bool2)
          {
            AppMethodBeat.o(162409);
            return 2131231268;
          }
          AppMethodBeat.o(162409);
          return 2131231274;
          label168:
          if (bool2)
          {
            AppMethodBeat.o(162409);
            return 2131231270;
          }
          AppMethodBeat.o(162409);
          return 2131231276;
        }
      }
      if (bool2)
      {
        AppMethodBeat.o(162409);
        return 2131231269;
      }
      AppMethodBeat.o(162409);
      return 2131231275;
    }
    if (str == null) {}
    while (bool1)
    {
      AppMethodBeat.o(162409);
      return 2131231278;
      switch (str.hashCode())
      {
      default: 
        break;
      case 115861276: 
        if (str.equals("zh_CN")) {
          if (bool1)
          {
            AppMethodBeat.o(162409);
            return 2131231277;
          }
        }
        break;
      case 115861428: 
        if (!str.equals("zh_HK")) {}
        break;
      case 115861812: 
        for (;;)
        {
          if (!bool1) {
            break label332;
          }
          AppMethodBeat.o(162409);
          return 2131231279;
          if (!str.equals("zh_TW")) {
            break;
          }
        }
        AppMethodBeat.o(162409);
        return 2131231280;
        label332:
        AppMethodBeat.o(162409);
        return 2131231282;
      }
    }
    AppMethodBeat.o(162409);
    return 2131231281;
  }
  
  public static boolean cle()
  {
    AppMethodBeat.i(6496);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(6496);
      return true;
    }
    if (pmS != -1)
    {
      if (pmS == 1)
      {
        AppMethodBeat.o(6496);
        return true;
      }
      AppMethodBeat.o(6496);
      return false;
    }
    pmS = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rTR, 0);
    Log.i(TAG, "isPayReadingOpen open %d", new Object[] { Integer.valueOf(pmS) });
    if (pmS == 1)
    {
      AppMethodBeat.o(6496);
      return true;
    }
    AppMethodBeat.o(6496);
    return false;
  }
  
  private static MultiProcessMMKV clq()
  {
    AppMethodBeat.i(6488);
    Object localObject;
    if (pmR != null)
    {
      localObject = pmR;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.sdk.platformtools.MultiProcessMMKV");
        AppMethodBeat.o(6488);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(6488);
      return localObject;
    }
    if (MMApplicationContext.isMainProcess()) {
      p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.azs())
    {
      localObject = MultiProcessMMKV.getMMKV("appMsgPay_".concat(String.valueOf(i)), 2);
      pmR = (MultiProcessMMKV)localObject;
      if (localObject != null) {
        break;
      }
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.sdk.platformtools.MultiProcessMMKV");
      AppMethodBeat.o(6488);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(6488);
    return localObject;
  }
  
  public final void a(CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(6493);
    p.h(paramCharSequence, "text");
    p.h(paramMMNeat7extView, "titleTv");
    if ((paramBoolean) && (cle()))
    {
      Object localObject = com.tencent.mm.plugin.bizui.a.a.pfC;
      localObject = paramMMNeat7extView.getContext();
      p.g(localObject, "titleTv.context");
      com.tencent.mm.plugin.bizui.a.a.a((Context)localObject, paramMMNeat7extView, cG(paramString, paramInt), paramCharSequence, paramInt);
      AppMethodBeat.o(6493);
      return;
    }
    paramMMNeat7extView.aw(paramCharSequence);
    AppMethodBeat.o(6493);
  }
  
  public final void a(String paramString, MMNeat7extView paramMMNeat7extView, v paramv, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6492);
    p.h(paramString, "text");
    p.h(paramMMNeat7extView, "titleTv");
    p.h(paramv, "item");
    if ((paramv.type == 0) && (paramv.iwf == 1)) {}
    for (;;)
    {
      a((CharSequence)paramString, paramMMNeat7extView, bool, paramv.url, paramInt);
      AppMethodBeat.o(6492);
      return;
      bool = false;
    }
  }
  
  public final void ab(Map<String, String> paramMap)
  {
    AppMethodBeat.i(6495);
    p.h(paramMap, "values");
    String str = (String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.AppmsgUrl");
    int i = Util.getInt((String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.ItemShowType"), -1);
    Log.i(TAG, "onPaySuccessNotify url=" + str + ", itemShowType=" + i);
    if ((str != null) && (i >= 0)) {
      cE(str, i);
    }
    AppMethodBeat.o(6495);
  }
  
  public final void cE(String paramString, int paramInt)
  {
    AppMethodBeat.i(6494);
    p.h(paramString, "url");
    if (ahI(paramString))
    {
      Log.d(TAG, "url pay status: already paid url=" + paramString + ", itemShowType=" + paramInt);
      AppMethodBeat.o(6494);
      return;
    }
    Log.i(TAG, "appMsgPaySuccess url=" + paramString + ", itemShowType=" + paramInt);
    m localm = m.pCU;
    m.aii(paramString);
    aH(paramString, true);
    m.a(paramString, paramInt, 90, new Object[0]);
    paramString = new w();
    paramString.dCO.dCP = true;
    EventCenter.instance.asyncPublish((IEvent)paramString, Looper.getMainLooper());
    AppMethodBeat.o(6494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.a
 * JD-Core Version:    0.7.0.1
 */