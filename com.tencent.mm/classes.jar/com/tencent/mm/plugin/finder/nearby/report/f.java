package com.tencent.mm.plugin.finder.nearby.report;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.cp;
import com.tencent.mm.autogen.mmdata.rpt.cq;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbySquareEntranceReporterUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "bannerListPos", "", "getBannerListPos", "()I", "setBannerListPos", "(I)V", "commentScene", "", "getCommentScene", "()Ljava/lang/String;", "setCommentScene", "(Ljava/lang/String;)V", "followListPos", "getFollowListPos", "setFollowListPos", "isNeverPageIn", "", "newSquarePageInMs", "", "pageInMs", "recommendTitlePos", "getRecommendTitlePos", "setRecommendTitlePos", "refPageId", "specialColumnListPosMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSpecialColumnListPosMap", "()Ljava/util/HashMap;", "getNewSquarePageOutUdfKv", "getPageInUdfKv", "getPageOutUdfKv", "report21158", "", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorNoticeAction;", "finderUsrName", "notificationId", "chnlExtra", "report23057", "contextId", "eidStr", "eidUdfKv", "report23059", "reportEnterNewSquare", "reportExitNewSquare", "reportSubTabPageIn", "context", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "reportSubTabPageOut", "resetSubTabData", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
{
  public String Dol;
  public String ELv;
  public long ELw;
  public boolean ELx;
  public int ERf;
  public int ERg;
  public int ERh;
  public final HashMap<String, Integer> ERi;
  public long akic;
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(339708);
    this.ERf = -1;
    this.ERg = -1;
    this.ERh = -1;
    this.ERi = new HashMap();
    this.ELv = "";
    this.ELx = true;
    AppMethodBeat.o(339708);
  }
  
  public f(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(339715);
    this.ERf = -1;
    this.ERg = -1;
    this.ERh = -1;
    this.ERi = new HashMap();
    this.ELv = "";
    this.ELx = true;
    AppMethodBeat.o(339715);
  }
  
  public static String eFz()
  {
    AppMethodBeat.i(370407);
    Object localObject = new i();
    ((i)localObject).n("is_new_square", Integer.valueOf(1));
    ((i)localObject).n("enter_type", Integer.valueOf(3));
    localObject = ((i)localObject).toString();
    s.s(localObject, "pgUdfKv.toString()");
    localObject = n.m((String)localObject, ",", ";", false);
    if (localObject == null)
    {
      AppMethodBeat.o(370407);
      return "";
    }
    AppMethodBeat.o(370407);
    return localObject;
  }
  
  public final void aj(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(339739);
    cp localcp = new cp();
    localcp.ixo = Util.nowMilliSecond();
    localcp.lV("");
    localcp.lW("");
    localcp.lX("");
    localcp.lY("");
    String str2 = c.dLD().dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcp.lZ(str1);
    str1 = paramString1;
    if (paramString1 == null) {
      str1 = "";
    }
    localcp.ma(str1);
    str1 = this.Dol;
    paramString1 = str1;
    if (str1 == null) {
      paramString1 = "";
    }
    localcp.mb(paramString1);
    localcp.mc("");
    localcp.md("");
    localcp.me("");
    localcp.mf(paramString2);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    localcp.mg(paramString1);
    localcp.bMH();
    AppMethodBeat.o(339739);
  }
  
  public final void u(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(339728);
    cq localcq = new cq();
    localcq.ixo = Util.nowMilliSecond();
    localcq.mh("");
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localcq.mi(str);
    localcq.mj("");
    localcq.mk("");
    str = c.dLD().dHN();
    paramString1 = str;
    if (str == null) {
      paramString1 = "";
    }
    localcq.ml(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localcq.mm(paramString1);
    paramString2 = this.Dol;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localcq.mn(paramString1);
    localcq.mp("");
    localcq.mq("");
    localcq.mr("");
    localcq.ms(paramString3);
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    localcq.mt(paramString1);
    localcq.bMH();
    AppMethodBeat.o(339728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.f
 * JD-Core Version:    0.7.0.1
 */