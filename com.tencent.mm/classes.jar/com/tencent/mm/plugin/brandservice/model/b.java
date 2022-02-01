package com.tencent.mm.plugin.brandservice.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aa;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.bizui.a.a;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/model/BizPayLogic;", "", "()V", "TAG", "", "isPayReadingOpen", "", "()I", "setPayReadingOpen", "(I)V", "payMMkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPayMMkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setPayMMkv", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V", "appMsgPaySuccess", "", "url", "itemShowType", "getPayIcon", "scene", "isPaid", "", "onPaySuccessNotify", "values", "", "payMmkv", "setPayStatus", "setPayStatusById", "id", "setTitleText", "text", "", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "isPaySubscribe", "item", "Lcom/tencent/mm/message/BizReaderItem;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b vBC;
  private static MultiProcessMMKV vBD;
  private static int vBE;
  
  static
  {
    AppMethodBeat.i(6497);
    vBC = new b();
    TAG = "MicroMsg.BizPayLogic";
    vBE = -1;
    AppMethodBeat.o(6497);
  }
  
  public static void aV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6489);
    s.u(paramString, "url");
    h localh = h.vCa;
    paramString = h.aiQ(paramString);
    if (paramBoolean)
    {
      dbR().encode(paramString, 1);
      AppMethodBeat.o(6489);
      return;
    }
    dbR().remove(paramString);
    AppMethodBeat.o(6489);
  }
  
  public static boolean aiP(String paramString)
  {
    AppMethodBeat.i(6490);
    if (paramString == null)
    {
      AppMethodBeat.o(6490);
      return false;
    }
    MultiProcessMMKV localMultiProcessMMKV = dbR();
    h localh = h.vCa;
    if (localMultiProcessMMKV.decodeInt(h.aiQ(paramString), 0) == 1)
    {
      AppMethodBeat.o(6490);
      return true;
    }
    AppMethodBeat.o(6490);
    return false;
  }
  
  private static int dD(String paramString, int paramInt)
  {
    AppMethodBeat.i(162409);
    String str = LocaleUtil.getApplicationLanguage();
    boolean bool1 = aw.isDarkMode();
    a locala = a.vtB;
    boolean bool2 = a.GN(paramInt);
    if (aiP(paramString))
    {
      if (str != null) {
        switch (str.hashCode())
        {
        }
      }
      while (bool1)
      {
        paramInt = d.d.biz_paid_dm_icon_en;
        AppMethodBeat.o(162409);
        return paramInt;
        if (str.equals("zh_HK"))
        {
          for (;;)
          {
            if (bool1)
            {
              paramInt = d.d.biz_paid_dm_icon_hk;
              AppMethodBeat.o(162409);
              return paramInt;
              if (!str.equals("zh_TW"))
              {
                if ((goto 76) || (!str.equals("zh_CN"))) {
                  break;
                }
                if (bool1)
                {
                  paramInt = d.d.biz_paid_dm_icon;
                  AppMethodBeat.o(162409);
                  return paramInt;
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
              }
            }
          }
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
    if (str != null) {
      switch (str.hashCode())
      {
      }
    }
    while (bool1)
    {
      paramInt = d.d.biz_pay_dm_icon_en;
      AppMethodBeat.o(162409);
      return paramInt;
      if (str.equals("zh_HK"))
      {
        for (;;)
        {
          if (bool1)
          {
            paramInt = d.d.biz_pay_dm_icon_hk;
            AppMethodBeat.o(162409);
            return paramInt;
            if (!str.equals("zh_TW"))
            {
              if ((goto 276) || (!str.equals("zh_CN"))) {
                break;
              }
              if (bool1)
              {
                paramInt = d.d.biz_pay_dm_icon;
                AppMethodBeat.o(162409);
                return paramInt;
              }
              paramInt = d.d.biz_pay_icon;
              AppMethodBeat.o(162409);
              return paramInt;
            }
          }
        }
        paramInt = d.d.biz_pay_icon_hk;
        AppMethodBeat.o(162409);
        return paramInt;
      }
    }
    paramInt = d.d.biz_pay_icon_en;
    AppMethodBeat.o(162409);
    return paramInt;
  }
  
  private static MultiProcessMMKV dbR()
  {
    AppMethodBeat.i(6488);
    Object localObject;
    if (vBD != null)
    {
      localObject = vBD;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.sdk.platformtools.MultiProcessMMKV");
        AppMethodBeat.o(6488);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(6488);
      return localObject;
    }
    if (MMApplicationContext.isMainProcess()) {
      com.tencent.mm.kernel.h.baC();
    }
    for (int i = com.tencent.mm.kernel.b.getUin();; i = com.tencent.mm.kernel.b.aZP())
    {
      localObject = MultiProcessMMKV.getMMKV(s.X("appMsgPay_", Integer.valueOf(i)), 2);
      vBD = (MultiProcessMMKV)localObject;
      if (localObject != null) {
        break;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.sdk.platformtools.MultiProcessMMKV");
      AppMethodBeat.o(6488);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(6488);
    return localObject;
  }
  
  public static boolean dbx()
  {
    AppMethodBeat.i(6496);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(6496);
      return true;
    }
    if (vBE != -1)
    {
      if (vBE == 1)
      {
        AppMethodBeat.o(6496);
        return true;
      }
      AppMethodBeat.o(6496);
      return false;
    }
    vBE = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yOn, 1);
    Log.i(TAG, "isPayReadingOpen open %d", new Object[] { Integer.valueOf(vBE) });
    if (vBE == 1)
    {
      AppMethodBeat.o(6496);
      return true;
    }
    AppMethodBeat.o(6496);
    return false;
  }
  
  public final void a(CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(6493);
    s.u(paramCharSequence, "text");
    s.u(paramMMNeat7extView, "titleTv");
    if ((paramBoolean) && (dbx()))
    {
      Object localObject = a.vtB;
      localObject = paramMMNeat7extView.getContext();
      s.s(localObject, "titleTv.context");
      a.a((Context)localObject, paramMMNeat7extView, dD(paramString, paramInt), paramCharSequence, paramInt);
      AppMethodBeat.o(6493);
      return;
    }
    paramMMNeat7extView.aZ(paramCharSequence);
    AppMethodBeat.o(6493);
  }
  
  public final void a(String paramString, MMNeat7extView paramMMNeat7extView, v paramv, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6492);
    s.u(paramString, "text");
    s.u(paramMMNeat7extView, "titleTv");
    s.u(paramv, "item");
    if ((paramv.type == 0) && (paramv.nQp == 1)) {}
    for (;;)
    {
      a((CharSequence)paramString, paramMMNeat7extView, bool, paramv.url, paramInt);
      paramMMNeat7extView.setTag(d.e.biz_pay, Boolean.valueOf(bool));
      AppMethodBeat.o(6492);
      return;
      bool = false;
    }
  }
  
  public final void ab(Map<String, String> paramMap)
  {
    AppMethodBeat.i(6495);
    s.u(paramMap, "values");
    String str = (String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.AppmsgUrl");
    int i = Util.getInt((String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.ItemShowType"), -1);
    Log.i(TAG, "onPaySuccessNotify url=" + str + ", itemShowType=" + i);
    if ((str != null) && (i >= 0)) {
      dB(str, i);
    }
    AppMethodBeat.o(6495);
  }
  
  public final void dB(String paramString, int paramInt)
  {
    AppMethodBeat.i(6494);
    s.u(paramString, "url");
    if (aiP(paramString))
    {
      Log.d(TAG, "url pay status: already paid url=" + paramString + ", itemShowType=" + paramInt);
      AppMethodBeat.o(6494);
      return;
    }
    Log.i(TAG, "appMsgPaySuccess url=" + paramString + ", itemShowType=" + paramInt);
    m localm = m.vSK;
    m.ajv(paramString);
    aV(paramString, true);
    m.a(paramString, paramInt, 90, new Object[0]);
    paramString = new aa();
    paramString.hzQ.hzR = true;
    paramString.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(6494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.b
 * JD-Core Version:    0.7.0.1
 */