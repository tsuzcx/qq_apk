package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.f.a.x;
import com.tencent.mm.plugin.bizui.a.a;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/model/BizPayLogic;", "", "()V", "TAG", "", "isPayReadingOpen", "", "()I", "setPayReadingOpen", "(I)V", "payMMkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPayMMkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setPayMMkv", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V", "appMsgPaySuccess", "", "url", "itemShowType", "getPayIcon", "scene", "isPaid", "", "onPaySuccessNotify", "values", "", "payMmkv", "setPayStatus", "setPayStatusById", "id", "setTitleText", "text", "", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "isPaySubscribe", "item", "Lcom/tencent/mm/message/BizReaderItem;", "plugin-brandservice_release"})
public final class b
{
  private static final String TAG = "MicroMsg.BizPayLogic";
  private static MultiProcessMMKV svP;
  private static int svQ;
  public static final b svR;
  
  static
  {
    AppMethodBeat.i(6497);
    svR = new b();
    TAG = "MicroMsg.BizPayLogic";
    svQ = -1;
    AppMethodBeat.o(6497);
  }
  
  public static void aJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6489);
    p.k(paramString, "url");
    h localh = h.swx;
    paramString = h.apv(paramString);
    if (paramBoolean)
    {
      cyU().encode(paramString, 1);
      AppMethodBeat.o(6489);
      return;
    }
    cyU().remove(paramString);
    AppMethodBeat.o(6489);
  }
  
  public static boolean apu(String paramString)
  {
    AppMethodBeat.i(6490);
    if (paramString == null)
    {
      AppMethodBeat.o(6490);
      return false;
    }
    MultiProcessMMKV localMultiProcessMMKV = cyU();
    h localh = h.swx;
    if (localMultiProcessMMKV.decodeInt(h.apv(paramString), 0) == 1)
    {
      AppMethodBeat.o(6490);
      return true;
    }
    AppMethodBeat.o(6490);
    return false;
  }
  
  public static boolean cyB()
  {
    AppMethodBeat.i(6496);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(6496);
      return true;
    }
    if (svQ != -1)
    {
      if (svQ == 1)
      {
        AppMethodBeat.o(6496);
        return true;
      }
      AppMethodBeat.o(6496);
      return false;
    }
    svQ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAx, 1);
    Log.i(TAG, "isPayReadingOpen open %d", new Object[] { Integer.valueOf(svQ) });
    if (svQ == 1)
    {
      AppMethodBeat.o(6496);
      return true;
    }
    AppMethodBeat.o(6496);
    return false;
  }
  
  private static MultiProcessMMKV cyU()
  {
    AppMethodBeat.i(6488);
    Object localObject;
    if (svP != null)
    {
      localObject = svP;
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
      p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.b.getUin();; i = com.tencent.mm.kernel.b.aGP())
    {
      localObject = MultiProcessMMKV.getMMKV("appMsgPay_".concat(String.valueOf(i)), 2);
      svP = (MultiProcessMMKV)localObject;
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
  
  private static int db(String paramString, int paramInt)
  {
    AppMethodBeat.i(162409);
    String str = LocaleUtil.getApplicationLanguage();
    boolean bool1 = ar.isDarkMode();
    a locala = a.shG;
    boolean bool2 = a.Go(paramInt);
    if (apu(paramString))
    {
      if (str == null) {}
      while (bool1)
      {
        paramInt = d.d.biz_paid_dm_icon_en;
        AppMethodBeat.o(162409);
        return paramInt;
        switch (str.hashCode())
        {
        default: 
          break;
        case 115861276: 
          if (str.equals("zh_CN")) {
            if (bool1)
            {
              paramInt = d.d.biz_paid_dm_icon;
              AppMethodBeat.o(162409);
              return paramInt;
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
              break label184;
            }
            paramInt = d.d.biz_paid_dm_icon_hk;
            AppMethodBeat.o(162409);
            return paramInt;
            if (!str.equals("zh_TW")) {
              break;
            }
          }
          if (bool2)
          {
            paramInt = d.d.biz_paid_cover_icon;
            AppMethodBeat.o(162409);
            return paramInt;
          }
          paramInt = d.d.biz_paid_icon;
          AppMethodBeat.o(162409);
          return paramInt;
          label184:
          if (bool2)
          {
            paramInt = d.d.biz_paid_cover_icon_hk;
            AppMethodBeat.o(162409);
            return paramInt;
          }
          paramInt = d.d.biz_paid_icon_hk;
          AppMethodBeat.o(162409);
          return paramInt;
        }
      }
      if (bool2)
      {
        paramInt = d.d.biz_paid_cover_icon_en;
        AppMethodBeat.o(162409);
        return paramInt;
      }
      paramInt = d.d.biz_paid_icon_en;
      AppMethodBeat.o(162409);
      return paramInt;
    }
    if (str == null) {}
    while (bool1)
    {
      paramInt = d.d.biz_pay_dm_icon_en;
      AppMethodBeat.o(162409);
      return paramInt;
      switch (str.hashCode())
      {
      default: 
        break;
      case 115861276: 
        if (str.equals("zh_CN")) {
          if (bool1)
          {
            paramInt = d.d.biz_pay_dm_icon;
            AppMethodBeat.o(162409);
            return paramInt;
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
            break label373;
          }
          paramInt = d.d.biz_pay_dm_icon_hk;
          AppMethodBeat.o(162409);
          return paramInt;
          if (!str.equals("zh_TW")) {
            break;
          }
        }
        paramInt = d.d.biz_pay_icon;
        AppMethodBeat.o(162409);
        return paramInt;
        label373:
        paramInt = d.d.biz_pay_icon_hk;
        AppMethodBeat.o(162409);
        return paramInt;
      }
    }
    paramInt = d.d.biz_pay_icon_en;
    AppMethodBeat.o(162409);
    return paramInt;
  }
  
  public final void U(Map<String, String> paramMap)
  {
    AppMethodBeat.i(6495);
    p.k(paramMap, "values");
    String str = (String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.AppmsgUrl");
    int i = Util.getInt((String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.ItemShowType"), -1);
    Log.i(TAG, "onPaySuccessNotify url=" + str + ", itemShowType=" + i);
    if ((str != null) && (i >= 0)) {
      cZ(str, i);
    }
    AppMethodBeat.o(6495);
  }
  
  public final void a(CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(6493);
    p.k(paramCharSequence, "text");
    p.k(paramMMNeat7extView, "titleTv");
    if ((paramBoolean) && (cyB()))
    {
      Object localObject = a.shG;
      localObject = paramMMNeat7extView.getContext();
      p.j(localObject, "titleTv.context");
      a.a((Context)localObject, paramMMNeat7extView, db(paramString, paramInt), paramCharSequence, paramInt);
      AppMethodBeat.o(6493);
      return;
    }
    paramMMNeat7extView.aL(paramCharSequence);
    AppMethodBeat.o(6493);
  }
  
  public final void a(String paramString, MMNeat7extView paramMMNeat7extView, v paramv, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6492);
    p.k(paramString, "text");
    p.k(paramMMNeat7extView, "titleTv");
    p.k(paramv, "item");
    if ((paramv.type == 0) && (paramv.lls == 1)) {}
    for (;;)
    {
      a((CharSequence)paramString, paramMMNeat7extView, bool, paramv.url, paramInt);
      AppMethodBeat.o(6492);
      return;
      bool = false;
    }
  }
  
  public final void cZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(6494);
    p.k(paramString, "url");
    if (apu(paramString))
    {
      Log.d(TAG, "url pay status: already paid url=" + paramString + ", itemShowType=" + paramInt);
      AppMethodBeat.o(6494);
      return;
    }
    Log.i(TAG, "appMsgPaySuccess url=" + paramString + ", itemShowType=" + paramInt);
    m localm = m.sNg;
    m.apU(paramString);
    aJ(paramString, true);
    m.a(paramString, paramInt, 90, new Object[0]);
    paramString = new x();
    paramString.fvv.fvw = true;
    EventCenter.instance.asyncPublish((IEvent)paramString, Looper.getMainLooper());
    AppMethodBeat.o(6494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.b
 * JD-Core Version:    0.7.0.1
 */