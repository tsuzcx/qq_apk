package com.tencent.mm.plugin.finder.spam;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.he;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/spam/FinderSpamLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "canFeedRetry", "", "errType", "", "errCode", "checkFunctionSpam", "business", "getFunctionSpamAction", "getFunctionSpamTip", "handleFinderBlackList", "", "errMsg", "handleFinderNotRealname", "handleFinderOpLogSpam", "handleFinderSpamErrCode", "handleFinderSpamTips", "needDeleteAction", "needOpLogTips", "showSpamDialog", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "Finder.FinderSpamLogic";
  public static final a rBD;
  
  static
  {
    AppMethodBeat.i(166880);
    rBD = new a();
    TAG = "Finder.FinderSpamLogic";
    AppMethodBeat.o(166880);
  }
  
  public static boolean aV(int paramInt, String paramString)
  {
    AppMethodBeat.i(202896);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(202896);
      return true;
    }
    if ((paramInt == -4007) || (paramInt == -4006) || (paramInt == -4005))
    {
      AppMethodBeat.o(202896);
      return false;
    }
    AppMethodBeat.o(202896);
    return true;
  }
  
  public static void aW(int paramInt, String paramString)
  {
    AppMethodBeat.i(166873);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4006)
    {
      if (paramString != null) {
        aea(paramString);
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 0L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4007)
    {
      if (paramString != null) {
        aea(paramString);
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 1L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4017)
    {
      if (paramString != null) {
        aea(paramString);
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 2L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4005)
    {
      if (paramString != null) {
        aea(paramString);
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 5L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4019)
    {
      if (paramString != null) {
        aea(paramString);
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 6L, 1L, false);
    }
    AppMethodBeat.o(166873);
  }
  
  public static void aea(String paramString)
  {
    AppMethodBeat.i(166871);
    k.h(paramString, "errMsg");
    f.a locala = new f.a(ai.getContext());
    locala.aRQ(paramString).acQ(2131766205);
    locala.yi(true);
    locala.b((f.c)a.a.rBE);
    locala.show();
    AppMethodBeat.o(166871);
  }
  
  public static int aeb(String paramString)
  {
    AppMethodBeat.i(166877);
    k.h(paramString, "business");
    String str = g.ZY().getValue("FinderSpamObject");
    ac.i(TAG, "getFunctionSpamAction ".concat(String.valueOf(str)));
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(166877);
      return 0;
    }
    try
    {
      int i = new i(str).tZ(paramString).optInt("action", 0);
      AppMethodBeat.o(166877);
      return i;
    }
    catch (Exception paramString)
    {
      ac.i(TAG, "getFunctionSpamAction spamValue ".concat(String.valueOf(str)));
      AppMethodBeat.o(166877);
    }
    return 0;
  }
  
  public static String aec(String paramString)
  {
    AppMethodBeat.i(166878);
    k.h(paramString, "business");
    String str = g.ZY().getValue("FinderSpamObject");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(166878);
      return "";
    }
    try
    {
      paramString = new i(str).tZ(paramString).optString("tip", "");
      k.g(paramString, "obj.optJSONObject(business).optString(\"tip\", \"\")");
      AppMethodBeat.o(166878);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.i(TAG, "getFunctionSpamTip spamValue ".concat(String.valueOf(str)));
      AppMethodBeat.o(166878);
    }
    return "";
  }
  
  public static boolean aed(String paramString)
  {
    AppMethodBeat.i(166879);
    k.h(paramString, "business");
    if (aeb(paramString) != 0)
    {
      aea(aec(paramString));
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 3L, 1L, false);
      ac.i(TAG, "function spam ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(166879);
      return true;
    }
    AppMethodBeat.o(166879);
    return false;
  }
  
  public static boolean fB(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && ((paramInt2 == -4007) || (paramInt2 == -4006));
  }
  
  public static boolean fC(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 4) || ((paramInt2 != -4007) && (paramInt2 != -4006) && (paramInt2 != -4005));
  }
  
  public static void w(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(202897);
    if ((paramInt1 == 4) && (paramInt2 == -4019))
    {
      if (paramString != null) {
        aea(paramString);
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 6L, 1L, false);
    }
    AppMethodBeat.o(202897);
  }
  
  public static void x(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166874);
    if (paramInt1 == 4)
    {
      if (paramInt2 == -4006)
      {
        if (paramString != null) {
          aea(paramString);
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 0L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4007)
      {
        if (paramString != null) {
          aea(paramString);
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 1L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4017)
      {
        if (paramString != null) {
          aea(paramString);
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 2L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4019)
      {
        if (paramString != null) {
          aea(paramString);
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 6L, 1L, false);
      }
    }
    AppMethodBeat.o(166874);
  }
  
  public static void y(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166875);
    if ((paramInt1 == 4) && (paramInt2 == -4010))
    {
      if (paramString != null) {
        aea(paramString);
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1264L, 4L, 1L, false);
    }
    AppMethodBeat.o(166875);
  }
  
  public static void z(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166876);
    if ((paramInt1 == 4) && (paramInt2 == -4013) && (paramString != null))
    {
      aea(paramString);
      he localhe = new he();
      localhe.dij.errCode = paramInt2;
      localhe.dij.errMsg = paramString;
      com.tencent.mm.sdk.b.a.GpY.l((b)localhe);
      AppMethodBeat.o(166876);
      return;
    }
    AppMethodBeat.o(166876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.spam.a
 * JD-Core Version:    0.7.0.1
 */