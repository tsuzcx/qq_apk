package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.ew;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderGameLiveReportUtil;", "", "()V", "TAG", "", "lastActionType", "", "getLastActionType", "()J", "setLastActionType", "(J)V", "initCommField", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveStreamStruct;", "report21017", "actionJson", "", "params", "report21017ForLiveTaskBanner", "type", "activityId", "appId", "report21017ForMiniGame", "result", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s GgL;
  private static long GgM;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333744);
    GgL = new s();
    TAG = "Finder.FinderGameLiveReportUtil";
    GgM = 18L;
    AppMethodBeat.o(333744);
  }
  
  public static void H(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(333728);
    ew localew = new ew();
    a(localew);
    localew.ioV = q.a.DqT.mwI;
    i locali = new i();
    locali.au("type", paramInt);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    locali.m("activityid", str);
    paramString1 = ah.aiuX;
    paramString1 = locali.toString();
    kotlin.g.b.s.s(paramString1, "JSONObject().apply {\n   … \"\")\n        }.toString()");
    localew.pu(n.m(paramString1, ",", ";", false));
    localew.pv("{\"gameappid\":\"" + paramString2 + "\"}");
    localew.bMH();
    Log.i(TAG, "report21017, " + localew.aIF() + ' ');
    AppMethodBeat.o(333728);
  }
  
  public static void TU(int paramInt)
  {
    AppMethodBeat.i(333685);
    ew localew = new ew();
    a(localew);
    localew.ioV = GgM;
    Object localObject = new i();
    ((i)localObject).au("type", paramInt);
    ah localah = ah.aiuX;
    localObject = ((i)localObject).toString();
    kotlin.g.b.s.s(localObject, "JSONObject().apply {\n   …son)\n        }.toString()");
    localew.pu(n.m((String)localObject, ",", ";", false));
    localew.bMH();
    Log.i(TAG, "report21017, " + localew.aIF() + ' ');
    AppMethodBeat.o(333685);
  }
  
  private static void a(ew paramew)
  {
    AppMethodBeat.i(333735);
    paramew.pq(z.bAW());
    Object localObject = aw.Gjk;
    if (aw.eKm()) {}
    for (int i = 1;; i = 0)
    {
      paramew.izI = i;
      String str = c.dLD().dHN();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramew.pt((String)localObject);
      paramew.eT(System.currentTimeMillis());
      AppMethodBeat.o(333735);
      return;
    }
  }
  
  public static void aBx(String paramString)
  {
    AppMethodBeat.i(333701);
    kotlin.g.b.s.u(paramString, "actionJson");
    ew localew = new ew();
    a(localew);
    localew.ioV = GgM;
    localew.pu(n.m(paramString, ",", ";", false));
    localew.bMH();
    Log.i(TAG, "report21017, " + localew.aIF() + ' ');
    AppMethodBeat.o(333701);
  }
  
  public static void bF(int paramInt, String paramString)
  {
    AppMethodBeat.i(333693);
    kotlin.g.b.s.u(paramString, "params");
    ew localew = new ew();
    a(localew);
    localew.ioV = GgM;
    Object localObject = new i();
    ((i)localObject).au("type", paramInt);
    ah localah = ah.aiuX;
    localObject = ((i)localObject).toString();
    kotlin.g.b.s.s(localObject, "JSONObject().apply {\n   …son)\n        }.toString()");
    localew.pu(n.m((String)localObject, ",", ";", false));
    localew.pv(paramString);
    localew.bMH();
    Log.i(TAG, "report21017, " + localew.aIF() + ' ');
    AppMethodBeat.o(333693);
  }
  
  public static void bG(int paramInt, String paramString)
  {
    AppMethodBeat.i(333714);
    ew localew = new ew();
    a(localew);
    localew.ioV = q.a.DqY.mwI;
    i locali = new i();
    locali.au("type", paramInt);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    locali.m("result", str);
    paramString = ah.aiuX;
    paramString = locali.toString();
    kotlin.g.b.s.s(paramString, "JSONObject().apply {\n   … \"\")\n        }.toString()");
    localew.pu(n.m(paramString, ",", ";", false));
    localew.bMH();
    Log.i(TAG, "report21017, " + localew.aIF() + ' ');
    AppMethodBeat.o(333714);
  }
  
  public static long feR()
  {
    return GgM;
  }
  
  public static void qF(long paramLong)
  {
    GgM = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.s
 * JD-Core Version:    0.7.0.1
 */