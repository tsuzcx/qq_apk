package com.tencent.mm.plugin.finder.spam;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/spam/FinderSpamLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "canFeedRetry", "", "errType", "", "errCode", "checkFunctionSpam", "business", "getFunctionSpamAction", "getFunctionSpamTip", "handleFinderBlackList", "", "errMsg", "handleFinderCommonTips", "handleFinderNotRealname", "handleFinderOpLogSpam", "handleFinderSpamErrCode", "handleFinderSpamTips", "needDeleteAction", "needOpLogTips", "showSpamDialog", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "Finder.FinderSpamLogic";
  public static final a sEK;
  
  static
  {
    AppMethodBeat.i(166880);
    sEK = new a();
    TAG = "Finder.FinderSpamLogic";
    AppMethodBeat.o(166880);
  }
  
  public static void A(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166876);
    if ((paramInt1 == 4) && (paramInt2 == -4013) && (paramString != null))
    {
      ajj(paramString);
      hk localhk = new hk();
      localhk.duU.errCode = paramInt2;
      localhk.duU.errMsg = paramString;
      com.tencent.mm.sdk.b.a.IvT.l((b)localhk);
      AppMethodBeat.o(166876);
      return;
    }
    AppMethodBeat.o(166876);
  }
  
  public static boolean aX(int paramInt, String paramString)
  {
    AppMethodBeat.i(204111);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(204111);
      return true;
    }
    if ((paramInt == -4007) || (paramInt == -4006) || (paramInt == -4005))
    {
      AppMethodBeat.o(204111);
      return false;
    }
    AppMethodBeat.o(204111);
    return true;
  }
  
  public static void aY(int paramInt, String paramString)
  {
    AppMethodBeat.i(166873);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4006)
    {
      if (paramString != null) {
        ajj(paramString);
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 0L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4007)
    {
      if (paramString != null) {
        ajj(paramString);
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 1L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4017)
    {
      if (paramString != null) {
        ajj(paramString);
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 2L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4005)
    {
      if (paramString != null) {
        ajj(paramString);
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 5L, 1L, false);
      AppMethodBeat.o(166873);
      return;
    }
    if (paramInt == -4019)
    {
      if (paramString != null) {
        ajj(paramString);
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 6L, 1L, false);
    }
    AppMethodBeat.o(166873);
  }
  
  public static void ajj(String paramString)
  {
    AppMethodBeat.i(166871);
    p.h(paramString, "errMsg");
    f.a locala = new f.a(ak.getContext());
    locala.aZq(paramString).afY(2131766205);
    locala.zi(true);
    locala.b((f.c)a.sEL);
    locala.show();
    AppMethodBeat.o(166871);
  }
  
  public static int ajk(String paramString)
  {
    AppMethodBeat.i(166877);
    p.h(paramString, "business");
    String str = g.acL().getValue("FinderSpamObject");
    ae.i(TAG, "getFunctionSpamAction ".concat(String.valueOf(str)));
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(166877);
      return 0;
    }
    try
    {
      int i = new i(str).xy(paramString).optInt("action", 0);
      AppMethodBeat.o(166877);
      return i;
    }
    catch (Exception paramString)
    {
      ae.i(TAG, "getFunctionSpamAction spamValue ".concat(String.valueOf(str)));
      AppMethodBeat.o(166877);
    }
    return 0;
  }
  
  public static String ajl(String paramString)
  {
    AppMethodBeat.i(166878);
    p.h(paramString, "business");
    String str = g.acL().getValue("FinderSpamObject");
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(166878);
      return "";
    }
    try
    {
      paramString = new i(str).xy(paramString).optString("tip", "");
      p.g(paramString, "obj.optJSONObject(business).optString(\"tip\", \"\")");
      AppMethodBeat.o(166878);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.i(TAG, "getFunctionSpamTip spamValue ".concat(String.valueOf(str)));
      AppMethodBeat.o(166878);
    }
    return "";
  }
  
  public static boolean ajm(String paramString)
  {
    AppMethodBeat.i(166879);
    p.h(paramString, "business");
    if (ajk(paramString) != 0)
    {
      ajj(ajl(paramString));
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 3L, 1L, false);
      ae.i(TAG, "function spam ".concat(String.valueOf(paramString)));
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
    AppMethodBeat.i(204112);
    if ((paramInt1 == 4) && (paramInt2 == -4019))
    {
      if (paramString != null) {
        ajj(paramString);
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 6L, 1L, false);
    }
    AppMethodBeat.o(204112);
  }
  
  public static void x(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(204113);
    if ((paramInt1 == 4) && (paramInt2 == -5000) && (paramString != null))
    {
      ajj(paramString);
      AppMethodBeat.o(204113);
      return;
    }
    AppMethodBeat.o(204113);
  }
  
  public static void y(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166874);
    if (paramInt1 == 4)
    {
      if (paramInt2 == -4006)
      {
        if (paramString != null) {
          ajj(paramString);
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 0L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4007)
      {
        if (paramString != null) {
          ajj(paramString);
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 1L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4017)
      {
        if (paramString != null) {
          ajj(paramString);
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 2L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4019)
      {
        if (paramString != null) {
          ajj(paramString);
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 6L, 1L, false);
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
        ajj(paramString);
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1264L, 4L, 1L, false);
    }
    AppMethodBeat.o(166875);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "b", "", "s", "", "onDialogClick"})
  static final class a
    implements f.c
  {
    public static final a sEL;
    
    static
    {
      AppMethodBeat.i(166870);
      sEL = new a();
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