package com.tencent.mm.plugin.finder.live.component.statecomponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLivePromoteReportHelper;", "", "()V", "reportAnchorAction", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "result", "", "type", "extra", "", "reportAnchorPushOrCancel", "item", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoAnchor;", "reportVisitorAction", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b CCd;
  
  static
  {
    AppMethodBeat.i(352814);
    CCd = new b();
    AppMethodBeat.o(352814);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(352784);
    s.u(parama, "liveData");
    s.u(paramString, "extra");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("result", paramInt1);
    if (paramInt2 > 0) {
      localJSONObject.put("type", paramInt2);
    }
    if (((CharSequence)paramString).length() > 0) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        localJSONObject.put("extra", paramString);
      }
      if (((e)parama.business(e.class)).EcA) {
        break;
      }
      j.Dob.C(q.a.Drb.mwI, localJSONObject.toString());
      AppMethodBeat.o(352784);
      return;
    }
    j.Dob.a(q.c.DrT, localJSONObject.toString());
    AppMethodBeat.o(352784);
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(352802);
    s.u(parama, "liveData");
    s.u(paramString, "extra");
    parama = new JSONObject();
    parama.put("result", paramInt1);
    if (paramInt2 > 0) {
      parama.put("type", paramInt2);
    }
    if (((CharSequence)paramString).length() > 0) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        parama.put("extra", paramString);
      }
      paramString = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
        break;
      }
      j.Dob.a(q.c.DrT, parama.toString());
      AppMethodBeat.o(352802);
      return;
    }
    paramString = k.Doi;
    parama = parama.toString();
    s.s(parama, "js.toString()");
    s.u(parama, "action");
    k.a(q.bu.DDc, parama, 0L, null, null, null, 60);
    AppMethodBeat.o(352802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.statecomponent.b
 * JD-Core Version:    0.7.0.1
 */