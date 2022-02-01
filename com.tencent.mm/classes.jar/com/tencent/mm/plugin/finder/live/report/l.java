package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.widget.bf;
import com.tencent.mm.plugin.finder.live.widget.bf.a;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.gfi;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"chnlExtraForWAGame", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;", "plugin-finder-live_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final String a(bhf parambhf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(351780);
    s.u(parambhf, "<this>");
    Object localObject1 = bf.Evf;
    if (!bf.a.g(parambhf))
    {
      AppMethodBeat.o(351780);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localObject1 = parambhf.ZQG;
    if (localObject1 == null)
    {
      localObject1 = null;
      localJSONObject.put("teamid", localObject1);
      localObject1 = parambhf.ZQP;
      if (localObject1 != null) {
        break label187;
      }
      localObject1 = null;
      label69:
      localJSONObject.put("appid", localObject1);
      localObject1 = parambhf.ZQP;
      if (localObject1 != null) {
        break label195;
      }
    }
    label187:
    label195:
    for (localObject1 = localObject2;; localObject1 = Integer.valueOf(((gfi)localObject1).version))
    {
      localJSONObject.put("version_type", localObject1);
      localJSONObject.put("gametype", 1);
      localJSONObject.put("custom", parambhf.title + '/' + parambhf.ZOJ + '/' + parambhf.ZQD);
      parambhf = localJSONObject.toString();
      s.s(parambhf, "result.toString()");
      parambhf = n.bV(parambhf, ",", ";");
      AppMethodBeat.o(351780);
      return parambhf;
      localObject1 = ((cbo)localObject1).ZUh;
      break;
      localObject1 = ((gfi)localObject1).appid;
      break label69;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.l
 * JD-Core Version:    0.7.0.1
 */