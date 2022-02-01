package com.tencent.mm.plugin.findersdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.f.a.ic;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.findersdk.c.a;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/spam/FinderSpamLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "canFeedRetry", "", "errType", "", "errCode", "checkFunctionSpam", "business", "getFunctionSpamAction", "getFunctionSpamTip", "handleFinderBlackList", "", "errMsg", "handleFinderCommonTips", "handleFinderNotRealname", "handleFinderOpLogSpam", "handleFinderSpamErrCode", "handleFinderSpamTips", "handleLiveErrorPageDialog", "errPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "handleLiveErrorPageFullPage", "needDeleteAction", "needOpLogTips", "showSpamDialog", "finder-sdk_release"})
public final class a
{
  public static final a Bwg;
  private static final String TAG = "Finder.FinderSpamLogic";
  
  static
  {
    AppMethodBeat.i(208519);
    Bwg = new a();
    TAG = "Finder.FinderSpamLogic";
    AppMethodBeat.o(208519);
  }
  
  public static boolean a(int paramInt1, int paramInt2, aze paramaze)
  {
    AppMethodBeat.i(208518);
    if ((paramInt1 == 4) && ((paramInt2 == -200011) || (paramInt2 == -200012) || (paramInt2 == -200008) || (paramInt2 == -200009) || (paramInt2 == -200010) || (paramInt2 == -200046)) && (paramaze != null))
    {
      if (paramaze.type == 1)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label98;
        }
      }
      for (;;)
      {
        if (paramaze == null) {
          break label103;
        }
        String str = paramaze.wording;
        paramaze = str;
        if (str == null) {
          paramaze = "";
        }
        aGP(paramaze);
        AppMethodBeat.o(208518);
        return true;
        paramInt1 = 0;
        break;
        label98:
        paramaze = null;
      }
    }
    label103:
    AppMethodBeat.o(208518);
    return false;
  }
  
  public static void aGP(String paramString)
  {
    AppMethodBeat.i(208507);
    p.k(paramString, "errMsg");
    f.a locala = new f.a(MMApplicationContext.getContext());
    locala.bBl(paramString).ayp(c.a.welcome_i_know);
    locala.HL(true);
    locala.b((f.c)a.Bwh);
    locala.show();
    AppMethodBeat.o(208507);
  }
  
  public static int aGQ(String paramString)
  {
    AppMethodBeat.i(208514);
    p.k(paramString, "business");
    String str = h.axc().getValue("FinderSpamObject");
    Log.i(TAG, "getFunctionSpamAction ".concat(String.valueOf(str)));
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(208514);
      return 0;
    }
    try
    {
      int i = new i(str).MK(paramString).optInt("action", 0);
      AppMethodBeat.o(208514);
      return i;
    }
    catch (Exception paramString)
    {
      Log.i(TAG, "getFunctionSpamAction spamValue ".concat(String.valueOf(str)));
      AppMethodBeat.o(208514);
    }
    return 0;
  }
  
  public static String aGR(String paramString)
  {
    AppMethodBeat.i(208516);
    p.k(paramString, "business");
    String str = h.axc().getValue("FinderSpamObject");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(208516);
      return "";
    }
    try
    {
      paramString = new i(str).MK(paramString).optString("tip", "");
      p.j(paramString, "obj.optJSONObject(business).optString(\"tip\", \"\")");
      AppMethodBeat.o(208516);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.i(TAG, "getFunctionSpamTip spamValue ".concat(String.valueOf(str)));
      AppMethodBeat.o(208516);
    }
    return "";
  }
  
  public static boolean aGS(String paramString)
  {
    AppMethodBeat.i(208517);
    p.k(paramString, "business");
    if (aGQ(paramString) != 0)
    {
      aGP(aGR(paramString));
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1264L, 3L, 1L, false);
      Log.i(TAG, "function spam ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(208517);
      return true;
    }
    AppMethodBeat.o(208517);
    return false;
  }
  
  public static boolean b(int paramInt1, int paramInt2, aze paramaze)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 4) {
      if ((paramInt2 != -200011) && (paramInt2 != -200012))
      {
        bool1 = bool2;
        if (paramInt2 != -200046) {}
      }
      else
      {
        bool1 = bool2;
        if (paramaze != null)
        {
          bool1 = bool2;
          if (paramaze.type == 2) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean bg(int paramInt, String paramString)
  {
    AppMethodBeat.i(208505);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(208505);
      return true;
    }
    if ((paramInt == -4007) || (paramInt == -4006) || (paramInt == -4005))
    {
      AppMethodBeat.o(208505);
      return false;
    }
    AppMethodBeat.o(208505);
    return true;
  }
  
  public static boolean hs(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && ((paramInt2 == -4007) || (paramInt2 == -4006));
  }
  
  public static boolean ht(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 4) || ((paramInt2 != -4007) && (paramInt2 != -4006) && (paramInt2 != -4005) && (paramInt2 != -4059) && (paramInt2 != -4065));
  }
  
  public static void v(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(208508);
    if ((paramInt1 == 4) && (paramInt2 == -4019))
    {
      if (paramString != null) {
        aGP(paramString);
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1264L, 6L, 1L, false);
    }
    AppMethodBeat.o(208508);
  }
  
  public static void w(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(208509);
    if ((paramInt1 == 4) && ((paramInt2 == -5000) || (paramInt2 == -5300)) && (paramString != null))
    {
      aGP(paramString);
      AppMethodBeat.o(208509);
      return;
    }
    AppMethodBeat.o(208509);
  }
  
  public static void x(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(208511);
    if (paramInt1 == 4)
    {
      if (paramInt2 == -4006)
      {
        if (paramString != null) {
          aGP(paramString);
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1264L, 0L, 1L, false);
        AppMethodBeat.o(208511);
        return;
      }
      if (paramInt2 == -4007)
      {
        if (paramString != null) {
          aGP(paramString);
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1264L, 1L, 1L, false);
        AppMethodBeat.o(208511);
        return;
      }
      if (paramInt2 == -4017)
      {
        if (paramString != null) {
          aGP(paramString);
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1264L, 2L, 1L, false);
        AppMethodBeat.o(208511);
        return;
      }
      if (paramInt2 == -4019)
      {
        if (paramString != null) {
          aGP(paramString);
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1264L, 6L, 1L, false);
      }
    }
    AppMethodBeat.o(208511);
  }
  
  public static void y(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(208512);
    if ((paramInt1 == 4) && (paramInt2 == -4010))
    {
      if (paramString != null) {
        aGP(paramString);
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1264L, 4L, 1L, false);
    }
    AppMethodBeat.o(208512);
  }
  
  public static void z(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(208513);
    if ((paramInt1 == 4) && (paramInt2 == -4013) && (paramString != null))
    {
      aGP(paramString);
      ic localic = new ic();
      localic.fFi.errCode = paramInt2;
      localic.fFi.errMsg = paramString;
      EventCenter.instance.publish((IEvent)localic);
      AppMethodBeat.o(208513);
      return;
    }
    AppMethodBeat.o(208513);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "b", "", "s", "", "onDialogClick"})
  static final class a
    implements f.c
  {
    public static final a Bwh;
    
    static
    {
      AppMethodBeat.i(208321);
      Bwh = new a();
      AppMethodBeat.o(208321);
    }
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(208320);
      p.k(paramString, "s");
      AppMethodBeat.o(208320);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.c.a
 * JD-Core Version:    0.7.0.1
 */