package com.tencent.mm.plugin.finder.spam;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/spam/FinderSpamLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "canFeedRetry", "", "errType", "", "errCode", "checkFunctionSpam", "business", "getFunctionSpamAction", "getFunctionSpamTip", "handleFinderBlackList", "", "errMsg", "handleFinderCommonTips", "handleFinderNotRealname", "handleFinderOpLogSpam", "handleFinderSpamErrCode", "handleFinderSpamTips", "handleLiveErrorPageDialog", "errPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "handleLiveErrorPageFullPage", "needDeleteAction", "needOpLogTips", "showSpamDialog", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "Finder.FinderSpamLogic";
  public static final a vwk;
  
  static
  {
    AppMethodBeat.i(166880);
    vwk = new a();
    TAG = "Finder.FinderSpamLogic";
    AppMethodBeat.o(166880);
  }
  
  public static boolean a(int paramInt1, int paramInt2, avr paramavr)
  {
    AppMethodBeat.i(251500);
    if ((paramInt1 == 4) && ((paramInt2 == -200011) || (paramInt2 == -200012) || (paramInt2 == -200008) || (paramInt2 == -200009) || (paramInt2 == -200010) || (paramInt2 == -200046)) && (paramavr != null))
    {
      if (paramavr.type == 1)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label98;
        }
      }
      for (;;)
      {
        if (paramavr == null) {
          break label103;
        }
        String str = paramavr.dQx;
        paramavr = str;
        if (str == null) {
          paramavr = "";
        }
        avm(paramavr);
        AppMethodBeat.o(251500);
        return true;
        paramInt1 = 0;
        break;
        label98:
        paramavr = null;
      }
    }
    label103:
    AppMethodBeat.o(251500);
    return false;
  }
  
  public static void avm(String paramString)
  {
    AppMethodBeat.i(166871);
    p.h(paramString, "errMsg");
    f.a locala = new f.a(MMApplicationContext.getContext());
    locala.bow(paramString).apa(2131768713);
    locala.Dq(true);
    locala.b((f.c)a.vwl);
    locala.show();
    AppMethodBeat.o(166871);
  }
  
  public static int avn(String paramString)
  {
    AppMethodBeat.i(166877);
    p.h(paramString, "business");
    String str = h.aqJ().getValue("FinderSpamObject");
    Log.i(TAG, "getFunctionSpamAction ".concat(String.valueOf(str)));
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(166877);
      return 0;
    }
    try
    {
      int i = new i(str).FK(paramString).optInt("action", 0);
      AppMethodBeat.o(166877);
      return i;
    }
    catch (Exception paramString)
    {
      Log.i(TAG, "getFunctionSpamAction spamValue ".concat(String.valueOf(str)));
      AppMethodBeat.o(166877);
    }
    return 0;
  }
  
  public static String avo(String paramString)
  {
    AppMethodBeat.i(166878);
    p.h(paramString, "business");
    String str = h.aqJ().getValue("FinderSpamObject");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(166878);
      return "";
    }
    try
    {
      paramString = new i(str).FK(paramString).optString("tip", "");
      p.g(paramString, "obj.optJSONObject(business).optString(\"tip\", \"\")");
      AppMethodBeat.o(166878);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.i(TAG, "getFunctionSpamTip spamValue ".concat(String.valueOf(str)));
      AppMethodBeat.o(166878);
    }
    return "";
  }
  
  public static boolean avp(String paramString)
  {
    AppMethodBeat.i(166879);
    p.h(paramString, "business");
    if (avn(paramString) != 0)
    {
      avm(avo(paramString));
      e.Cxv.idkeyStat(1264L, 3L, 1L, false);
      Log.i(TAG, "function spam ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(166879);
      return true;
    }
    AppMethodBeat.o(166879);
    return false;
  }
  
  public static boolean b(int paramInt1, int paramInt2, avr paramavr)
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
        if (paramavr != null)
        {
          bool1 = bool2;
          if (paramavr.type == 2) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean ba(int paramInt, String paramString)
  {
    AppMethodBeat.i(251497);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(251497);
      return true;
    }
    if ((paramInt == -4007) || (paramInt == -4006) || (paramInt == -4005))
    {
      AppMethodBeat.o(251497);
      return false;
    }
    AppMethodBeat.o(251497);
    return true;
  }
  
  public static boolean gi(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && ((paramInt2 == -4007) || (paramInt2 == -4006));
  }
  
  public static boolean gj(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 4) || ((paramInt2 != -4007) && (paramInt2 != -4006) && (paramInt2 != -4005) && (paramInt2 != -4059));
  }
  
  public static void t(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(251498);
    if ((paramInt1 == 4) && (paramInt2 == -4019))
    {
      if (paramString != null) {
        avm(paramString);
      }
      e.Cxv.idkeyStat(1264L, 6L, 1L, false);
    }
    AppMethodBeat.o(251498);
  }
  
  public static void u(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(251499);
    if ((paramInt1 == 4) && ((paramInt2 == -5000) || (paramInt2 == -5300)) && (paramString != null))
    {
      avm(paramString);
      AppMethodBeat.o(251499);
      return;
    }
    AppMethodBeat.o(251499);
  }
  
  public static void v(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166874);
    if (paramInt1 == 4)
    {
      if (paramInt2 == -4006)
      {
        if (paramString != null) {
          avm(paramString);
        }
        e.Cxv.idkeyStat(1264L, 0L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4007)
      {
        if (paramString != null) {
          avm(paramString);
        }
        e.Cxv.idkeyStat(1264L, 1L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4017)
      {
        if (paramString != null) {
          avm(paramString);
        }
        e.Cxv.idkeyStat(1264L, 2L, 1L, false);
        AppMethodBeat.o(166874);
        return;
      }
      if (paramInt2 == -4019)
      {
        if (paramString != null) {
          avm(paramString);
        }
        e.Cxv.idkeyStat(1264L, 6L, 1L, false);
      }
    }
    AppMethodBeat.o(166874);
  }
  
  public static void w(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166875);
    if ((paramInt1 == 4) && (paramInt2 == -4010))
    {
      if (paramString != null) {
        avm(paramString);
      }
      e.Cxv.idkeyStat(1264L, 4L, 1L, false);
    }
    AppMethodBeat.o(166875);
  }
  
  public static void x(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(166876);
    if ((paramInt1 == 4) && (paramInt2 == -4013) && (paramString != null))
    {
      avm(paramString);
      ht localht = new ht();
      localht.dMp.errCode = paramInt2;
      localht.dMp.errMsg = paramString;
      EventCenter.instance.publish((IEvent)localht);
      AppMethodBeat.o(166876);
      return;
    }
    AppMethodBeat.o(166876);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "b", "", "s", "", "onDialogClick"})
  static final class a
    implements f.c
  {
    public static final a vwl;
    
    static
    {
      AppMethodBeat.i(166870);
      vwl = new a();
      AppMethodBeat.o(166870);
    }
    
    public final void e(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(166869);
      p.h(paramString, "s");
      AppMethodBeat.o(166869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.spam.a
 * JD-Core Version:    0.7.0.1
 */