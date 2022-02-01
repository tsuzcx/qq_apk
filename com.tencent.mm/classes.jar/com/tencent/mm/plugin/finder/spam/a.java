package com.tencent.mm.plugin.finder.spam;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/spam/FinderSpamLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "canFeedRetry", "", "errType", "", "errCode", "checkFunctionSpam", "business", "getFunctionSpamAction", "getFunctionSpamTip", "handleFinderBlackList", "", "errMsg", "handleFinderCommonTips", "handleFinderNotRealname", "handleFinderOpLogSpam", "handleFinderSpamErrCode", "handleFinderSpamTips", "needDeleteAction", "needOpLogTips", "showSpamDialog", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "Finder.FinderSpamLogic";
  public static final a suA;
  
  static
  {
    AppMethodBeat.i(166880);
    suA = new a();
    TAG = "Finder.FinderSpamLogic";
    AppMethodBeat.o(166880);
  }
  
  public static void A(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166876);
    if ((paramInt1 == 4) && (paramInt2 == -4013) && (paramString != null))
    {
      aim(paramString);
      hj localhj = new hj();
      localhj.dtP.errCode = paramInt2;
      localhj.dtP.errMsg = paramString;
      com.tencent.mm.sdk.b.a.IbL.l((b)localhj);
      AppMethodBeat.o(166876);
      return;
    }
    AppMethodBeat.o(166876);
  }
  
  public static boolean aY(int paramInt, String paramString)
  {
    AppMethodBeat.i(203551);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203551);
      return true;
    }
    if ((paramInt == -4007) || (paramInt == -4006) || (paramInt == -4005))
    {
      AppMethodBeat.o(203551);
      return false;
    }
    AppMethodBeat.o(203551);
    return true;
  }
  
  public static void aZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(166873);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4006)
    {
      if (paramString != null) {
        aim(paramString);
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 0L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4007)
    {
      if (paramString != null) {
        aim(paramString);
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 1L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4017)
    {
      if (paramString != null) {
        aim(paramString);
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 2L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4005)
    {
      if (paramString != null) {
        aim(paramString);
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 5L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4019)
    {
      if (paramString != null) {
        aim(paramString);
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 6L, 1L, false);
    }
    AppMethodBeat.o(166873);
  }
  
  public static void aim(String paramString)
  {
    AppMethodBeat.i(166871);
    p.h(paramString, "errMsg");
    f.a locala = new f.a(aj.getContext());
    locala.aXO(paramString).afp(2131766205);
    locala.yU(true);
    locala.b((f.c)a.suB);
    locala.show();
    AppMethodBeat.o(166871);
  }
  
  public static int ain(String paramString)
  {
    AppMethodBeat.i(166877);
    p.h(paramString, "business");
    String str = g.acA().getValue("FinderSpamObject");
    ad.i(TAG, "getFunctionSpamAction ".concat(String.valueOf(str)));
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(166877);
      return 0;
    }
    try
    {
      int i = new i(str).wP(paramString).optInt("action", 0);
      AppMethodBeat.o(166877);
      return i;
    }
    catch (Exception paramString)
    {
      ad.i(TAG, "getFunctionSpamAction spamValue ".concat(String.valueOf(str)));
      AppMethodBeat.o(166877);
    }
    return 0;
  }
  
  public static String aio(String paramString)
  {
    AppMethodBeat.i(166878);
    p.h(paramString, "business");
    String str = g.acA().getValue("FinderSpamObject");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(166878);
      return "";
    }
    try
    {
      paramString = new i(str).wP(paramString).optString("tip", "");
      p.g(paramString, "obj.optJSONObject(business).optString(\"tip\", \"\")");
      AppMethodBeat.o(166878);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.i(TAG, "getFunctionSpamTip spamValue ".concat(String.valueOf(str)));
      AppMethodBeat.o(166878);
    }
    return "";
  }
  
  public static boolean aip(String paramString)
  {
    AppMethodBeat.i(166879);
    p.h(paramString, "business");
    if (ain(paramString) != 0)
    {
      aim(aio(paramString));
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 3L, 1L, false);
      ad.i(TAG, "function spam ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(166879);
      return true;
    }
    AppMethodBeat.o(166879);
    return false;
  }
  
  public static boolean fO(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && ((paramInt2 == -4007) || (paramInt2 == -4006));
  }
  
  public static boolean fP(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 4) || ((paramInt2 != -4007) && (paramInt2 != -4006) && (paramInt2 != -4005));
  }
  
  public static void w(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(203552);
    if ((paramInt1 == 4) && (paramInt2 == -4019))
    {
      if (paramString != null) {
        aim(paramString);
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 6L, 1L, false);
    }
    AppMethodBeat.o(203552);
  }
  
  public static void x(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(203553);
    if ((paramInt1 == 4) && (paramInt2 == -5000) && (paramString != null))
    {
      aim(paramString);
      AppMethodBeat.o(203553);
      return;
    }
    AppMethodBeat.o(203553);
  }
  
  public static void y(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166874);
    if (paramInt1 == 4)
    {
      if (paramInt2 == -4006)
      {
        if (paramString != null) {
          aim(paramString);
        }
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 0L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4007)
      {
        if (paramString != null) {
          aim(paramString);
        }
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 1L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4017)
      {
        if (paramString != null) {
          aim(paramString);
        }
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 2L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4019)
      {
        if (paramString != null) {
          aim(paramString);
        }
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 6L, 1L, false);
      }
    }
    AppMethodBeat.o(166874);
  }
  
  public static void z(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166875);
    if ((paramInt1 == 4) && (paramInt2 == -4010))
    {
      if (paramString != null) {
        aim(paramString);
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1264L, 4L, 1L, false);
    }
    AppMethodBeat.o(166875);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "b", "", "s", "", "onDialogClick"})
  static final class a
    implements f.c
  {
    public static final a suB;
    
    static
    {
      AppMethodBeat.i(166870);
      suB = new a();
      AppMethodBeat.o(166870);
    }
    
    public final void d(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(166869);
      p.h(paramString, "s");
      AppMethodBeat.o(166869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.spam.a
 * JD-Core Version:    0.7.0.1
 */