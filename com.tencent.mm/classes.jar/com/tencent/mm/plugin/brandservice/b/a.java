package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.u;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.k;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/model/BizPayLogic;", "", "()V", "TAG", "", "isPayReadingOpen", "", "()I", "setPayReadingOpen", "(I)V", "payMMkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPayMMkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setPayMMkv", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V", "appMsgPaySuccess", "", "url", "itemShowType", "getPayIcon", "scene", "isPaid", "", "onPaySuccessNotify", "values", "", "payMmkv", "setPayStatus", "setPayStatusById", "id", "setTitleText", "text", "", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "isPaySubscribe", "item", "Lcom/tencent/mm/message/BizReaderItem;", "plugin-brandservice_release"})
public final class a
{
  private static final String TAG = "MicroMsg.BizPayLogic";
  private static ay obU;
  private static int obV;
  public static final a obW;
  
  static
  {
    AppMethodBeat.i(6497);
    obW = new a();
    TAG = "MicroMsg.BizPayLogic";
    obV = -1;
    AppMethodBeat.o(6497);
  }
  
  public static boolean XL(String paramString)
  {
    AppMethodBeat.i(6490);
    if (paramString == null)
    {
      AppMethodBeat.o(6490);
      return false;
    }
    ay localay = bOq();
    g localg = g.ocx;
    if (localay.decodeInt(g.XM(paramString), 0) == 1)
    {
      AppMethodBeat.o(6490);
      return true;
    }
    AppMethodBeat.o(6490);
    return false;
  }
  
  public static void Y(Map<String, String> paramMap)
  {
    AppMethodBeat.i(6495);
    p.h(paramMap, "values");
    String str = (String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.AppmsgUrl");
    int i = bu.getInt((String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.ItemShowType"), -1);
    ae.i(TAG, "onPaySuccessNotify url=" + str + ", itemShowType=" + i);
    if ((str != null) && (i >= 0)) {
      cx(str, i);
    }
    AppMethodBeat.o(6495);
  }
  
  public static void a(CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(6493);
    p.h(paramCharSequence, "text");
    p.h(paramMMNeat7extView, "titleTv");
    if ((paramBoolean) && (bOf()))
    {
      Object localObject = com.tencent.mm.plugin.bizui.a.a.nUG;
      localObject = paramMMNeat7extView.getContext();
      p.g(localObject, "titleTv.context");
      com.tencent.mm.plugin.bizui.a.a.a((Context)localObject, paramMMNeat7extView, cz(paramString, paramInt), paramCharSequence, paramInt);
      AppMethodBeat.o(6493);
      return;
    }
    paramMMNeat7extView.aq(paramCharSequence);
    AppMethodBeat.o(6493);
  }
  
  public static void a(String paramString, MMNeat7extView paramMMNeat7extView, com.tencent.mm.ah.v paramv, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6492);
    p.h(paramString, "text");
    p.h(paramMMNeat7extView, "titleTv");
    p.h(paramv, "item");
    if ((paramv.type == 0) && (paramv.hBY == 1)) {}
    for (;;)
    {
      a((CharSequence)paramString, paramMMNeat7extView, bool, paramv.url, paramInt);
      AppMethodBeat.o(6492);
      return;
      bool = false;
    }
  }
  
  public static void aF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6489);
    p.h(paramString, "url");
    g localg = g.ocx;
    paramString = g.XM(paramString);
    if (paramBoolean)
    {
      bOq().encode(paramString, 1);
      AppMethodBeat.o(6489);
      return;
    }
    bOq().remove(paramString);
    AppMethodBeat.o(6489);
  }
  
  public static boolean bOf()
  {
    AppMethodBeat.i(6496);
    if ((j.IS_FLAVOR_RED) || (j.DEBUG) || (bv.fpT()))
    {
      AppMethodBeat.o(6496);
      return true;
    }
    if (obV != -1)
    {
      if (obV == 1)
      {
        AppMethodBeat.o(6496);
        return true;
      }
      AppMethodBeat.o(6496);
      return false;
    }
    obV = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBi, 0);
    ae.i(TAG, "isPayReadingOpen open %d", new Object[] { Integer.valueOf(obV) });
    if (obV == 1)
    {
      AppMethodBeat.o(6496);
      return true;
    }
    AppMethodBeat.o(6496);
    return false;
  }
  
  private static ay bOq()
  {
    AppMethodBeat.i(6488);
    Object localObject;
    if (obU != null)
    {
      localObject = obU;
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.sdk.platformtools.MultiProcessMMKV");
        AppMethodBeat.o(6488);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(6488);
      return localObject;
    }
    if (ak.coh()) {
      p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.ajc())
    {
      localObject = ay.gq("appMsgPay_".concat(String.valueOf(i)), 2);
      obU = (ay)localObject;
      if (localObject != null) {
        break;
      }
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.sdk.platformtools.MultiProcessMMKV");
      AppMethodBeat.o(6488);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(6488);
    return localObject;
  }
  
  public static void cx(String paramString, int paramInt)
  {
    AppMethodBeat.i(6494);
    p.h(paramString, "url");
    if (XL(paramString))
    {
      ae.d(TAG, "url pay status: already paid url=" + paramString + ", itemShowType=" + paramInt);
      AppMethodBeat.o(6494);
      return;
    }
    ae.i(TAG, "appMsgPaySuccess url=" + paramString + ", itemShowType=" + paramInt);
    k localk = k.ops;
    k.Yi(paramString);
    aF(paramString, true);
    k.a(paramString, paramInt, 90, new Object[0]);
    paramString = new u();
    paramString.dly.dlz = true;
    com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)paramString, Looper.getMainLooper());
    AppMethodBeat.o(6494);
  }
  
  private static int cz(String paramString, int paramInt)
  {
    AppMethodBeat.i(162409);
    String str = ad.fom();
    boolean bool1 = al.isDarkMode();
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.nUG;
    boolean bool2 = com.tencent.mm.plugin.bizui.a.a.zd(paramInt);
    if (XL(paramString))
    {
      if (str == null) {}
      while (bool1)
      {
        AppMethodBeat.o(162409);
        return 2131231215;
        switch (str.hashCode())
        {
        default: 
          break;
        case 115861276: 
          if (str.equals("zh_CN")) {
            if (bool1)
            {
              AppMethodBeat.o(162409);
              return 2131231214;
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
              break label183;
            }
            AppMethodBeat.o(162409);
            return 2131231216;
            if (!str.equals("zh_TW")) {
              break;
            }
          }
          if (bool2)
          {
            AppMethodBeat.o(162409);
            return 2131231211;
          }
          AppMethodBeat.o(162409);
          return 2131231217;
          label183:
          if (bool2)
          {
            AppMethodBeat.o(162409);
            return 2131231213;
          }
          AppMethodBeat.o(162409);
          return 2131231219;
        }
      }
      if (bool2)
      {
        AppMethodBeat.o(162409);
        return 2131231212;
      }
      AppMethodBeat.o(162409);
      return 2131231218;
    }
    if (str == null) {}
    while (bool1)
    {
      AppMethodBeat.o(162409);
      return 2131231221;
      switch (str.hashCode())
      {
      default: 
        break;
      case 115861276: 
        if (str.equals("zh_CN")) {
          if (bool1)
          {
            AppMethodBeat.o(162409);
            return 2131231220;
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
            break label365;
          }
          AppMethodBeat.o(162409);
          return 2131231222;
          if (!str.equals("zh_TW")) {
            break;
          }
        }
        AppMethodBeat.o(162409);
        return 2131231223;
        label365:
        AppMethodBeat.o(162409);
        return 2131231225;
      }
    }
    AppMethodBeat.o(162409);
    return 2131231224;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.a
 * JD-Core Version:    0.7.0.1
 */