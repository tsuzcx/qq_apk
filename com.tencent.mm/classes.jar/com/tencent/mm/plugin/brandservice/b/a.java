package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.l;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/model/BizPayLogic;", "", "()V", "TAG", "", "isPayReadingOpen", "", "()I", "setPayReadingOpen", "(I)V", "payMMkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPayMMkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setPayMMkv", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V", "appMsgPaySuccess", "", "url", "itemShowType", "getPayIcon", "scene", "isPaid", "", "onPaySuccessNotify", "values", "", "payMmkv", "setPayStatus", "setPayStatusById", "id", "setTitleText", "text", "", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "isPaySubscribe", "item", "Lcom/tencent/mm/message/BizReaderItem;", "plugin-brandservice_release"})
public final class a
{
  private static final String TAG = "MicroMsg.BizPayLogic";
  private static aw nuN;
  private static int nuO;
  public static final a nuP;
  
  static
  {
    AppMethodBeat.i(6497);
    nuP = new a();
    TAG = "MicroMsg.BizPayLogic";
    nuO = -1;
    AppMethodBeat.o(6497);
  }
  
  public static void R(Map<String, String> paramMap)
  {
    AppMethodBeat.i(6495);
    d.g.b.k.h(paramMap, "values");
    String str = (String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.AppmsgUrl");
    int i = bs.getInt((String)paramMap.get(".sysmsg.MMBizPaySubscribePayNotify.ItemShowType"), -1);
    ac.i(TAG, "onPaySuccessNotify url=" + str + ", itemShowType=" + i);
    if ((str != null) && (i >= 0)) {
      cq(str, i);
    }
    AppMethodBeat.o(6495);
  }
  
  public static boolean Ts(String paramString)
  {
    AppMethodBeat.i(6490);
    if (paramString == null)
    {
      AppMethodBeat.o(6490);
      return false;
    }
    aw localaw = bIZ();
    g localg = g.nvq;
    if (localaw.decodeInt(g.Tt(paramString), 0) == 1)
    {
      AppMethodBeat.o(6490);
      return true;
    }
    AppMethodBeat.o(6490);
    return false;
  }
  
  public static void a(CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(6493);
    d.g.b.k.h(paramCharSequence, "text");
    d.g.b.k.h(paramMMNeat7extView, "titleTv");
    if ((paramBoolean) && (bIQ()))
    {
      Object localObject = com.tencent.mm.plugin.bizui.a.a.noe;
      localObject = paramMMNeat7extView.getContext();
      d.g.b.k.g(localObject, "titleTv.context");
      com.tencent.mm.plugin.bizui.a.a.a((Context)localObject, paramMMNeat7extView, cs(paramString, paramInt), paramCharSequence, paramInt);
      AppMethodBeat.o(6493);
      return;
    }
    paramMMNeat7extView.ar(paramCharSequence);
    AppMethodBeat.o(6493);
  }
  
  public static void a(String paramString, MMNeat7extView paramMMNeat7extView, com.tencent.mm.ah.v paramv, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6492);
    d.g.b.k.h(paramString, "text");
    d.g.b.k.h(paramMMNeat7extView, "titleTv");
    d.g.b.k.h(paramv, "item");
    if ((paramv.type == 0) && (paramv.hhb == 1)) {}
    for (;;)
    {
      a((CharSequence)paramString, paramMMNeat7extView, bool, paramv.url, paramInt);
      AppMethodBeat.o(6492);
      return;
      bool = false;
    }
  }
  
  public static void aB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6489);
    d.g.b.k.h(paramString, "url");
    g localg = g.nvq;
    paramString = g.Tt(paramString);
    if (paramBoolean)
    {
      bIZ().encode(paramString, 1);
      AppMethodBeat.o(6489);
      return;
    }
    bIZ().remove(paramString);
    AppMethodBeat.o(6489);
  }
  
  public static boolean bIQ()
  {
    AppMethodBeat.i(6496);
    if ((h.IS_FLAVOR_RED) || (h.DEBUG) || (bt.eWo()))
    {
      AppMethodBeat.o(6496);
      return true;
    }
    if (nuO != -1)
    {
      if (nuO == 1)
      {
        AppMethodBeat.o(6496);
        return true;
      }
      AppMethodBeat.o(6496);
      return false;
    }
    nuO = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQe, 0);
    ac.i(TAG, "isPayReadingOpen open %d", new Object[] { Integer.valueOf(nuO) });
    if (nuO == 1)
    {
      AppMethodBeat.o(6496);
      return true;
    }
    AppMethodBeat.o(6496);
    return false;
  }
  
  private static aw bIZ()
  {
    AppMethodBeat.i(6488);
    Object localObject;
    if (nuN != null)
    {
      localObject = nuN;
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.sdk.platformtools.MultiProcessMMKV");
        AppMethodBeat.o(6488);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(6488);
      return localObject;
    }
    if (ai.cin()) {
      d.g.b.k.g(com.tencent.mm.kernel.g.agP(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.agb())
    {
      localObject = aw.fK("appMsgPay_".concat(String.valueOf(i)), 2);
      nuN = (aw)localObject;
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
  
  public static void cq(String paramString, int paramInt)
  {
    AppMethodBeat.i(6494);
    d.g.b.k.h(paramString, "url");
    if (Ts(paramString))
    {
      ac.d(TAG, "url pay status: already paid url=" + paramString + ", itemShowType=" + paramInt);
      AppMethodBeat.o(6494);
      return;
    }
    ac.i(TAG, "appMsgPaySuccess url=" + paramString + ", itemShowType=" + paramInt);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.k localk = com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.nGP;
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.TN(paramString);
    aB(paramString, true);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.a(paramString, paramInt, 90, new Object[0]);
    paramString = new u();
    paramString.cZe.cZf = true;
    com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)paramString, Looper.getMainLooper());
    AppMethodBeat.o(6494);
  }
  
  private static int cs(String paramString, int paramInt)
  {
    AppMethodBeat.i(162409);
    String str = ab.eUO();
    boolean bool1 = aj.DT();
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.noe;
    boolean bool2 = com.tencent.mm.plugin.bizui.a.a.yk(paramInt);
    if (Ts(paramString))
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