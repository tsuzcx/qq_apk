package com.tencent.mm.plugin.findersdk.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.in;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.c.a;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/spam/FinderSpamLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "canFeedRetry", "", "errType", "", "errCode", "checkFunctionSpam", "business", "getFunctionSpamAction", "getFunctionSpamTip", "handleFinderBlackList", "", "errMsg", "handleFinderCommonTips", "handleFinderNotRealname", "handleFinderOpLogSpam", "handleFinderSpamErrCode", "handleFinderSpamTips", "handleLiveErrorPageDialog", "errPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "handleLiveErrorPageFullPage", "needDeleteAction", "needOpLogTips", "showSpamDialog", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Hdr;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(273839);
    Hdr = new a();
    TAG = "Finder.FinderSpamLogic";
    AppMethodBeat.o(273839);
  }
  
  public static void A(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(273760);
    if (paramInt1 == 4) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(273760);
      return;
      if (paramString != null) {
        aDg(paramString);
      }
    }
  }
  
  public static void B(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(273773);
    if (paramInt1 == 4) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(273773);
      return;
      if (paramString != null) {
        aDg(paramString);
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1264L, 0L, 1L, false);
      AppMethodBeat.o(273773);
      return;
      if (paramString != null) {
        aDg(paramString);
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1264L, 1L, 1L, false);
      AppMethodBeat.o(273773);
      return;
      if (paramString != null) {
        aDg(paramString);
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1264L, 2L, 1L, false);
      AppMethodBeat.o(273773);
      return;
      if (paramString != null) {
        aDg(paramString);
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1264L, 6L, 1L, false);
      AppMethodBeat.o(273773);
      return;
      paramString = MMApplicationContext.getContext().getString(c.a.finder_draft_max_count);
      s.s(paramString, "getContext().getString(R…g.finder_draft_max_count)");
      aDg(paramString);
    }
  }
  
  public static void C(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(273782);
    if ((paramInt1 == 4) && (paramInt2 == -4010))
    {
      if (paramString != null) {
        aDg(paramString);
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1264L, 4L, 1L, false);
    }
    AppMethodBeat.o(273782);
  }
  
  public static void D(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(273788);
    if ((paramInt1 == 4) && (paramInt2 == -4013) && (paramString != null))
    {
      aDg(paramString);
      in localin = new in();
      localin.hKa.errCode = paramInt2;
      localin.hKa.errMsg = paramString;
      localin.publish();
    }
    AppMethodBeat.o(273788);
  }
  
  public static boolean a(int paramInt1, int paramInt2, bgq parambgq)
  {
    AppMethodBeat.i(273818);
    if (paramInt1 == 4) {
      switch (paramInt2)
      {
      }
    }
    label130:
    for (;;)
    {
      AppMethodBeat.o(273818);
      return false;
      if (parambgq != null)
      {
        if (parambgq.type == 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label127;
          }
        }
        for (;;)
        {
          if (parambgq == null) {
            break label130;
          }
          String str = parambgq.wording;
          parambgq = str;
          if (str == null) {
            parambgq = "";
          }
          aDg(parambgq);
          AppMethodBeat.o(273818);
          return true;
          paramInt1 = 0;
          break;
          label127:
          parambgq = null;
        }
      }
    }
  }
  
  public static void aDg(String paramString)
  {
    AppMethodBeat.i(273740);
    s.u(paramString, "errMsg");
    Object localObject = ((cn)h.az(cn.class)).getFinderContext();
    if (localObject != null)
    {
      localObject = new g.a((Context)localObject);
      ((g.a)localObject).bDE(paramString).aEX(c.a.welcome_i_know);
      ((g.a)localObject).NF(true);
      ((g.a)localObject).b(a..ExternalSyntheticLambda0.INSTANCE);
      ((g.a)localObject).show();
    }
    AppMethodBeat.o(273740);
  }
  
  public static int aDh(String paramString)
  {
    AppMethodBeat.i(273796);
    s.u(paramString, "business");
    String str = com.tencent.mm.k.i.aRC().getValue("FinderSpamObject");
    Log.i(TAG, s.X("getFunctionSpamAction ", str));
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(273796);
      return 0;
    }
    try
    {
      int i = new com.tencent.mm.ad.i(str).Ft(paramString).optInt("action", 0);
      AppMethodBeat.o(273796);
      return i;
    }
    catch (Exception paramString)
    {
      Log.i(TAG, s.X("getFunctionSpamAction spamValue ", str));
      AppMethodBeat.o(273796);
    }
    return 0;
  }
  
  public static String aDi(String paramString)
  {
    AppMethodBeat.i(273802);
    s.u(paramString, "business");
    String str = com.tencent.mm.k.i.aRC().getValue("FinderSpamObject");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(273802);
      return "";
    }
    try
    {
      paramString = new com.tencent.mm.ad.i(str).Ft(paramString).optString("tip", "");
      s.s(paramString, "obj.optJSONObject(business).optString(\"tip\", \"\")");
      AppMethodBeat.o(273802);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.i(TAG, s.X("getFunctionSpamTip spamValue ", str));
      AppMethodBeat.o(273802);
    }
    return "";
  }
  
  public static boolean aDj(String paramString)
  {
    AppMethodBeat.i(273809);
    s.u(paramString, "business");
    if (aDh(paramString) != 0)
    {
      aDg(aDi(paramString));
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1264L, 3L, 1L, false);
      Log.i(TAG, s.X("function spam ", paramString));
      AppMethodBeat.o(273809);
      return true;
    }
    AppMethodBeat.o(273809);
    return false;
  }
  
  private static final void ag(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(273829);
    s.u(paramString, "s");
    AppMethodBeat.o(273829);
  }
  
  public static boolean b(int paramInt1, int paramInt2, bgq parambgq)
  {
    if (paramInt1 == 4) {
      switch (paramInt2)
      {
      }
    }
    do
    {
      return false;
    } while ((parambgq == null) || (parambgq.type != 2));
    return true;
  }
  
  public static boolean bK(int paramInt, String paramString)
  {
    AppMethodBeat.i(273732);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(273732);
      return true;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(273732);
      return true;
    }
    AppMethodBeat.o(273732);
    return false;
  }
  
  public static boolean iN(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean iO(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public static void z(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(273747);
    if ((paramInt1 == 4) && (paramInt2 == -4019))
    {
      if (paramString != null) {
        aDg(paramString);
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1264L, 6L, 1L, false);
    }
    AppMethodBeat.o(273747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a
 * JD-Core Version:    0.7.0.1
 */