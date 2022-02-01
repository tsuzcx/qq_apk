package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.fq;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.e;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.g;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bwf;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/FinderTabPreloadReporter;", "", "()V", "report24123", "", "opType", "Lcom/tencent/mm/plugin/finder/preload/FinderTabPreloadReporter$Type;", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "tabType", "", "extInfo", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$ExtInfo;", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "toJson", "Lorg/json/JSONObject;", "Type", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d EUv;
  
  static
  {
    AppMethodBeat.i(346317);
    EUv = new d();
    AppMethodBeat.o(346317);
  }
  
  public static void a(a parama, g.g paramg, int paramInt, g.e parame, bwf parambwf)
  {
    AppMethodBeat.i(346310);
    s.u(parama, "opType");
    s.u(parame, "extInfo");
    s.u(parambwf, "serverConfig");
    fq localfq = new fq();
    localfq.iJb = localfq.F("opType", parama.name(), true);
    if (paramg == null) {
      parama = "";
    }
    for (;;)
    {
      localfq.iJc = localfq.F("PreloadSource", parama, true);
      localfq.iJd = paramInt;
      localfq.iJe = parame.pullType;
      localfq.iJf = localfq.F("entranceRedDotObjectId", com.tencent.mm.ae.d.hF(parame.EWw), true);
      localfq.iJg = parame.EWx;
      localfq.iJh = parame.EWy;
      s.u(parambwf, "<this>");
      parama = new JSONObject();
      parama.put("new_follow_reddot_prefetch_interval", parambwf.aaeD);
      parama.put("new_friend_reddot_prefetch_interval", parambwf.aaeE);
      parama.put("new_hot_reddot_prefetch_interval", parambwf.aaeF);
      parama.put("follow_outter_prefetch_valid_time", parambwf.aaeH);
      parama.put("friend_outter_prefetch_valid_time", parambwf.aaeI);
      parama.put("hot_outter_prefetch_valid_time", parambwf.aaeJ);
      parama.put("follow_no_reddot_prefetch_outter_interval", parambwf.aaen);
      parama.put("friend_no_reddot_prefetch_outter_interval", parambwf.aaeo);
      parama.put("hot_no_reddot_prefetch_outter_interval", parambwf.aaep);
      parama.put("follow_reddot_prefetch_inner_interval", parambwf.aaer);
      parama.put("friend_reddot_prefetch_inner_interval", parambwf.aaes);
      parama.put("hot_reddot_prefetch_inner_interval", parambwf.aaet);
      parama.put("follow_no_reddot_prefetch_inner_interval", parambwf.aaev);
      parama.put("friend_no_reddot_prefetch_inner_interval", parambwf.aaew);
      parama.put("hot_no_reddot_prefetch_inner_interval", parambwf.aaex);
      parama = parama.toString();
      s.s(parama, "serverConfig.toJson().toString()");
      localfq.iJi = localfq.F("serverConfig", n.bV(parama, ",", ";"), true);
      localfq.bMH();
      parama = z.FrZ;
      z.a((a)localfq);
      AppMethodBeat.o(346310);
      return;
      paramg = paramg.name();
      parama = paramg;
      if (paramg == null) {
        parama = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/FinderTabPreloadReporter$Type;", "", "(Ljava/lang/String;I)V", "NormalEnter", "Preload", "UseCache", "RecycleCache", "CancelTask", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(346242);
      EUw = new a("NormalEnter", 0);
      EUx = new a("Preload", 1);
      EUy = new a("UseCache", 2);
      EUz = new a("RecycleCache", 3);
      EUA = new a("CancelTask", 4);
      EUB = new a[] { EUw, EUx, EUy, EUz, EUA };
      AppMethodBeat.o(346242);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.d
 * JD-Core Version:    0.7.0.1
 */