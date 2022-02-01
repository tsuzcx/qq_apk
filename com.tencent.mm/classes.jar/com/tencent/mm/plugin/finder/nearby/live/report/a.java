package com.tencent.mm.plugin.finder.nearby.live.report;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.cr;
import com.tencent.mm.autogen.mmdata.rpt.cs;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.localcity.NearbyLiveLocalCityFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/report/FinderLiveSquareTabLifeCycleReport;", "", "()V", "TAG", "", "byPass", "clickTabContextId", "clickTabId", "contextId", "enterType", "", "getEnterType", "()I", "setEnterType", "(I)V", "isInOnPauseState", "", "isNeverPageIn", "isNewSquare", "pageInMs", "", "refPageId", "enterLiveRoom", "", "enterLiveSquare", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "enterProfile", "getPageInUdfKv", "getPageOutUdfKv", "getTabContextId", "liveTabPageIn", "commentscene", "pagId", "tabId", "subTabId", "subTabContextID", "liveTabPageOut", "onPause", "onResume", "parseByPassToJson", "jsonObject", "Lcom/tencent/mm/json/JSONObject;", "reset", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static int ACR;
  private static String EHz;
  private static boolean ELA;
  public static final a ELu;
  private static String ELv;
  private static long ELw;
  private static boolean ELx;
  private static String ELy;
  private static int ELz;
  private static String zIB;
  private static String zIO;
  
  static
  {
    AppMethodBeat.i(340696);
    ELu = new a();
    zIO = "";
    EHz = "";
    zIB = "";
    ELv = "";
    ELx = true;
    ELy = "";
    ELz = -1;
    ACR = -1;
    AppMethodBeat.o(340696);
  }
  
  public static void QK(int paramInt)
  {
    ACR = paramInt;
  }
  
  public static void a(String paramString1, AbsNearByFragment paramAbsNearByFragment, String paramString2, String paramString3)
  {
    AppMethodBeat.i(340634);
    s.u(paramString1, "contextId");
    s.u(paramAbsNearByFragment, "fragment");
    s.u(paramString2, "clickTabContextId");
    s.u(paramString3, "byPass");
    Log.i("FinderLiveSquareTabLifeCycleReport", "enterLiveSquare contextId:" + paramString1 + " clickTabContextId:" + paramString2 + " byPass:" + paramString3);
    zIO = paramString1;
    EHz = paramAbsNearByFragment.eEt();
    ELw = 0L;
    zIB = paramString2;
    ELy = paramString3;
    if ((paramAbsNearByFragment instanceof NearbyLiveSquareFragment))
    {
      paramString1 = com.tencent.d.a.a.a.a.a.ahiX;
      ELz = ((Number)com.tencent.d.a.a.a.a.a.jUc().bmg()).intValue();
    }
    AppMethodBeat.o(340634);
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(340691);
    s.u(parami, "jsonObject");
    if (TextUtils.isEmpty((CharSequence)ELy))
    {
      Log.i("FinderLiveSquareTabLifeCycleReport", "parseByPassToJson byPass is empty.");
      AppMethodBeat.o(340691);
      return;
    }
    try
    {
      Object localObject = new i(ELy);
      String str = ((i)localObject).optString("appId");
      localObject = ((i)localObject).optString("versionType");
      if (!TextUtils.isEmpty((CharSequence)str)) {
        parami.m("appid", str);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        parami.m("versiontype", localObject);
        AppMethodBeat.o(340691);
        return;
      }
    }
    finally
    {
      Log.i("FinderLiveSquareTabLifeCycleReport", "parseByPassToJson error.");
      AppMethodBeat.o(340691);
    }
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(340664);
    cr localcr = new cr();
    localcr.ixo = cn.bDw();
    localcr.mu(paramString2);
    localcr.mv(paramString3);
    localcr.mw(paramString4);
    paramString3 = ((d)h.ax(d.class)).dHN();
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    localcr.mx(paramString2);
    localcr.my(zIO);
    localcr.mz(zIB);
    localcr.mA(paramString5);
    localcr.mB("");
    localcr.mC(paramString6);
    localcr.mD(paramString1);
    localcr.mB(eFz());
    localcr.bMH();
    Log.i("FinderLiveSquareTabLifeCycleReport", s.X("liveTabPageIn ", localcr.aIF()));
    AppMethodBeat.o(340664);
  }
  
  public static String eFv()
  {
    return zIB;
  }
  
  public static void eFw()
  {
    AppMethodBeat.i(340647);
    Log.i("FinderLiveSquareTabLifeCycleReport", "enterLiveRoom");
    ELv = "page_live_flow";
    AppMethodBeat.o(340647);
  }
  
  public static void eFx()
  {
    AppMethodBeat.i(340653);
    Log.i("FinderLiveSquareTabLifeCycleReport", "enterProfile");
    ELv = "page_profile";
    AppMethodBeat.o(340653);
  }
  
  private static String eFy()
  {
    AppMethodBeat.i(340676);
    if (ELw <= 0L)
    {
      AppMethodBeat.o(340676);
      return "";
    }
    long l1 = cn.bDw();
    long l2 = ELw;
    Object localObject = new i();
    ((i)localObject).t("staytime", l1 - l2);
    if (ELz != -1)
    {
      ((i)localObject).n("is_new_square", Integer.valueOf(ELz));
      ((i)localObject).n("enter_type", Integer.valueOf(ACR));
    }
    b((i)localObject);
    localObject = ((i)localObject).toString();
    s.s(localObject, "pgUdfKv.toString()");
    localObject = n.m((String)localObject, ",", ";", false);
    if (localObject == null)
    {
      AppMethodBeat.o(340676);
      return "";
    }
    AppMethodBeat.o(340676);
    return localObject;
  }
  
  private static String eFz()
  {
    AppMethodBeat.i(340684);
    Object localObject = new i();
    if (ELz != -1)
    {
      ((i)localObject).n("is_new_square", Integer.valueOf(ELz));
      ((i)localObject).n("enter_type", Integer.valueOf(ACR));
    }
    b((i)localObject);
    localObject = ((i)localObject).toString();
    s.s(localObject, "pgUdfKv.toString()");
    localObject = n.m((String)localObject, ",", ";", false);
    if (localObject == null)
    {
      AppMethodBeat.o(340684);
      return "";
    }
    AppMethodBeat.o(340684);
    return localObject;
  }
  
  private static void g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(340669);
    cs localcs = new cs();
    localcs.ixo = cn.bDw();
    localcs.mE(paramString2);
    localcs.mF(paramString3);
    localcs.mG(paramString4);
    paramString3 = ((d)h.ax(d.class)).dHN();
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    localcs.mH(paramString2);
    localcs.mI(zIO);
    localcs.mJ(zIB);
    localcs.mK(paramString5);
    localcs.mL(eFy());
    localcs.mM(paramString1);
    localcs.bMH();
    Log.i("FinderLiveSquareTabLifeCycleReport", s.X("liveTabPageOut ", localcs.aIF()));
    AppMethodBeat.o(340669);
  }
  
  public static void onPause()
  {
    ELA = true;
  }
  
  public static void onResume()
  {
    ELA = false;
  }
  
  public static void reset()
  {
    zIO = "";
    EHz = "";
    ELv = "";
    ELw = 0L;
    zIB = "";
    ELx = true;
    ELA = false;
    ELy = "";
    ELz = -1;
    ACR = -1;
  }
  
  public final void b(AbsNearByFragment paramAbsNearByFragment)
  {
    AppMethodBeat.i(340706);
    if (ELA)
    {
      Log.w("FinderLiveSquareTabLifeCycleReport", "liveTabPageIn return for isInOnPauseState");
      AppMethodBeat.o(340706);
      return;
    }
    if ((!(paramAbsNearByFragment instanceof NearbyLiveSquareTabFragment)) && (!(paramAbsNearByFragment instanceof NearbyLiveLocalCityFragment)))
    {
      AppMethodBeat.o(340706);
      return;
    }
    String str2 = paramAbsNearByFragment.eEt();
    String str3 = paramAbsNearByFragment.eEu();
    Object localObject;
    label82:
    int j;
    String str1;
    String str4;
    int i;
    if ((paramAbsNearByFragment instanceof NearbyLiveSquareTabFragment))
    {
      localObject = (NearbyLiveSquareTabFragment)paramAbsNearByFragment;
      if (localObject != null) {
        break label242;
      }
      localObject = "";
      j = paramAbsNearByFragment.getCommentScene();
      str1 = "page_tab_" + str2 + '_' + str3;
      str4 = paramAbsNearByFragment.eEv();
      if (((CharSequence)localObject).length() != 0) {
        break label290;
      }
      i = 1;
      label138:
      if (i != 0) {
        break label295;
      }
    }
    label290:
    label295:
    for (paramAbsNearByFragment = str1 + '_' + (String)localObject;; paramAbsNearByFragment = str1)
    {
      if (TextUtils.isEmpty((CharSequence)ELv))
      {
        localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
        if (com.tencent.mm.plugin.finder.nearby.live.square.page.b.isFinderLiveSquareMoreCommentScene(j)) {
          ELv = "page_live_flow";
        }
      }
      b(String.valueOf(j), paramAbsNearByFragment, str2, str3, str4, ELv);
      ELv = paramAbsNearByFragment;
      ELw = cn.bDw();
      ELx = false;
      AppMethodBeat.o(340706);
      return;
      localObject = null;
      break;
      label242:
      localObject = ((NearbyLiveSquareTabFragment)localObject).ELV;
      if (localObject == null)
      {
        localObject = "";
        break label82;
      }
      str1 = Integer.valueOf(((bnn)localObject).ZVZ).toString();
      localObject = str1;
      if (str1 != null) {
        break label82;
      }
      localObject = "";
      break label82;
      i = 0;
      break label138;
    }
  }
  
  public final void c(AbsNearByFragment paramAbsNearByFragment)
  {
    AppMethodBeat.i(340716);
    if (ELx)
    {
      Log.w("FinderLiveSquareTabLifeCycleReport", "liveTabPageOut return for isNeverPageIn");
      AppMethodBeat.o(340716);
      return;
    }
    if ((!(paramAbsNearByFragment instanceof NearbyLiveSquareTabFragment)) && (!(paramAbsNearByFragment instanceof NearbyLiveLocalCityFragment)))
    {
      AppMethodBeat.o(340716);
      return;
    }
    String str2 = paramAbsNearByFragment.eEt();
    String str3 = paramAbsNearByFragment.eEu();
    label82:
    int j;
    String str1;
    String str4;
    int i;
    if ((paramAbsNearByFragment instanceof NearbyLiveSquareTabFragment))
    {
      localObject = (NearbyLiveSquareTabFragment)paramAbsNearByFragment;
      if (localObject != null) {
        break label203;
      }
      localObject = "";
      j = paramAbsNearByFragment.getCommentScene();
      str1 = "page_tab_" + str2 + '_' + str3;
      str4 = paramAbsNearByFragment.eEv();
      if (((CharSequence)localObject).length() != 0) {
        break label251;
      }
      i = 1;
      label138:
      if (i != 0) {
        break label256;
      }
    }
    label256:
    for (Object localObject = str1 + '_' + (String)localObject;; localObject = str1)
    {
      paramAbsNearByFragment.ayX("");
      g(String.valueOf(j), (String)localObject, str2, str3, str4);
      AppMethodBeat.o(340716);
      return;
      localObject = null;
      break;
      label203:
      localObject = ((NearbyLiveSquareTabFragment)localObject).ELV;
      if (localObject == null)
      {
        localObject = "";
        break label82;
      }
      str1 = Integer.valueOf(((bnn)localObject).ZVZ).toString();
      localObject = str1;
      if (str1 != null) {
        break label82;
      }
      localObject = "";
      break label82;
      label251:
      i = 0;
      break label138;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.report.a
 * JD-Core Version:    0.7.0.1
 */