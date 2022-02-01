package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.g.b.k;
import d.l;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/model/BizPayLogic;", "", "()V", "TAG", "", "isPayReadingOpen", "", "()I", "setPayReadingOpen", "(I)V", "payMMkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPayMMkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setPayMMkv", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V", "appMsgPaySuccess", "", "url", "itemShowType", "getPayIcon", "scene", "isPaid", "", "onPaySuccessNotify", "values", "", "payMmkv", "setPayStatus", "setPayStatusById", "id", "setTitleText", "text", "", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "isPaySubscribe", "item", "Lcom/tencent/mm/message/BizReaderItem;", "plugin-brandservice_release"})
public final class b
{
  private static final String TAG = "MicroMsg.BizPayLogic";
  private static ax mSA;
  private static int mSB;
  public static final b mSC;
  
  static
  {
    AppMethodBeat.i(6497);
    mSC = new b();
    TAG = "MicroMsg.BizPayLogic";
    mSB = -1;
    AppMethodBeat.o(6497);
  }
  
  public static boolean Pi(String paramString)
  {
    AppMethodBeat.i(6490);
    if (paramString == null)
    {
      AppMethodBeat.o(6490);
      return false;
    }
    ax localax = bCb();
    h localh = h.mSY;
    if (localax.decodeInt(h.Pj(paramString), 0) == 1)
    {
      AppMethodBeat.o(6490);
      return true;
    }
    AppMethodBeat.o(6490);
    return false;
  }
  
  public static void R(Map<String, String> paramMap)
  {
    AppMethodBeat.i(6495);
    k.h(paramMap, "values");
    String str = (String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.AppmsgUrl");
    int i = bt.getInt((String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.ItemShowType"), -1);
    ad.i(TAG, "onPaySuccessNotify url=" + str + ", itemShowType=" + i);
    if ((str != null) && (i >= 0)) {
      cl(str, i);
    }
    AppMethodBeat.o(6495);
  }
  
  public static void a(CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(6493);
    k.h(paramCharSequence, "text");
    k.h(paramMMNeat7extView, "titleTv");
    if ((paramBoolean) && (bBS()))
    {
      Object localObject = com.tencent.mm.plugin.bizui.a.a.mLS;
      localObject = paramMMNeat7extView.getContext();
      k.g(localObject, "titleTv.context");
      com.tencent.mm.plugin.bizui.a.a.a((Context)localObject, paramMMNeat7extView, cn(paramString, paramInt), paramCharSequence, paramInt);
      AppMethodBeat.o(6493);
      return;
    }
    paramMMNeat7extView.aq(paramCharSequence);
    AppMethodBeat.o(6493);
  }
  
  public static void a(String paramString, MMNeat7extView paramMMNeat7extView, com.tencent.mm.ai.v paramv, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6492);
    k.h(paramString, "text");
    k.h(paramMMNeat7extView, "titleTv");
    k.h(paramv, "item");
    if ((paramv.type == 0) && (paramv.gGA == 1)) {}
    for (;;)
    {
      a((CharSequence)paramString, paramMMNeat7extView, bool, paramv.url, paramInt);
      AppMethodBeat.o(6492);
      return;
      bool = false;
    }
  }
  
  public static void aA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6489);
    k.h(paramString, "url");
    h localh = h.mSY;
    paramString = h.Pj(paramString);
    if (paramBoolean)
    {
      bCb().encode(paramString, 1);
      AppMethodBeat.o(6489);
      return;
    }
    bCb().remove(paramString);
    AppMethodBeat.o(6489);
  }
  
  public static boolean bBS()
  {
    AppMethodBeat.i(6496);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (bu.eGT()))
    {
      AppMethodBeat.o(6496);
      return true;
    }
    if (mSB != -1)
    {
      if (mSB == 1)
      {
        AppMethodBeat.o(6496);
        return true;
      }
      AppMethodBeat.o(6496);
      return false;
    }
    mSB = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmE, 0);
    ad.i(TAG, "isPayReadingOpen open %d", new Object[] { Integer.valueOf(mSB) });
    if (mSB == 1)
    {
      AppMethodBeat.o(6496);
      return true;
    }
    AppMethodBeat.o(6496);
    return false;
  }
  
  private static ax bCb()
  {
    AppMethodBeat.i(6488);
    Object localObject;
    if (mSA != null)
    {
      localObject = mSA;
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.sdk.platformtools.MultiProcessMMKV");
        AppMethodBeat.o(6488);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(6488);
      return localObject;
    }
    if (aj.cbe()) {
      k.g(g.afz(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.aeL())
    {
      localObject = ax.fF("appMsgPay_".concat(String.valueOf(i)), 2);
      mSA = (ax)localObject;
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
  
  public static void cl(String paramString, int paramInt)
  {
    AppMethodBeat.i(6494);
    k.h(paramString, "url");
    if (Pi(paramString))
    {
      ad.d(TAG, "url pay status: already paid url=" + paramString + ", itemShowType=" + paramInt);
      AppMethodBeat.o(6494);
      return;
    }
    ad.i(TAG, "appMsgPaySuccess url=" + paramString + ", itemShowType=" + paramInt);
    j localj = j.ned;
    j.PC(paramString);
    aA(paramString, true);
    j.a(paramString, paramInt, 90, new Object[0]);
    paramString = new t();
    paramString.dbF.dbG = true;
    com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)paramString, Looper.getMainLooper());
    AppMethodBeat.o(6494);
  }
  
  private static int cn(String paramString, int paramInt)
  {
    AppMethodBeat.i(162409);
    String str = ac.eFu();
    boolean bool1 = ai.Eq();
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.mLS;
    boolean bool2 = com.tencent.mm.plugin.bizui.a.a.xs(paramInt);
    if (Pi(paramString))
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
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.b
 * JD-Core Version:    0.7.0.1
 */