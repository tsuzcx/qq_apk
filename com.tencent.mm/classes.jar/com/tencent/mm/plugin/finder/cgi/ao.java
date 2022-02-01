package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.b;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/FinderBaseRequestFactory;", "", "()V", "TAG", "", "create", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fillFinderObjectBaseInfo", "", "finderBaseRequest", "list", "", "Lkotlin/Pair;", "", "", "generateClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderClientStatus;", "plugin-finder-base_release"})
public final class ao
{
  public static final ao xcj;
  
  static
  {
    AppMethodBeat.i(258152);
    xcj = new ao();
    AppMethodBeat.o(258152);
  }
  
  public static aqe a(bid parambid)
  {
    AppMethodBeat.i(258149);
    aqe localaqe = new aqe();
    Object localObject = j.AkL;
    j.a(localaqe);
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localaqe.SDr = ((f)localObject).aHp().getInt(ar.a.VAG, 0);
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localaqe.SDv = ((f)localObject).aHp().getInt(ar.a.VyS, 4);
    localaqe.SDu = new aax();
    if (parambid != null)
    {
      localaqe.scene = parambid.xkX;
      localObject = localaqe.SDu;
      if (localObject != null) {
        ((aax)localObject).wmL = parambid.wmL;
      }
      localObject = localaqe.SDu;
      if (localObject != null) {
        ((aax)localObject).wmz = parambid.wmz;
      }
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("sessionId", parambid.sessionId);
      if (!Util.isNullOrNil(parambid.extraInfo)) {
        ((JSONObject)localObject).put("extraInfo", parambid.extraInfo);
      }
      if (!Util.isNullOrNil(parambid.wmC)) {
        ((JSONObject)localObject).put("enterSourceInfo", parambid.wmC);
      }
    }
    catch (Exception parambid)
    {
      label189:
      break label189;
    }
    parambid = localaqe.SDu;
    if (parambid != null) {
      parambid.Snk = ((JSONObject)localObject).toString();
    }
    localaqe.yjR = cm.bfD();
    AppMethodBeat.o(258149);
    return localaqe;
  }
  
  public static void a(aqe paramaqe, List<o<Integer, Long>> paramList)
  {
    AppMethodBeat.i(258150);
    p.k(paramList, "list");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (o)paramList.next();
      com.tencent.mm.plugin.finder.report.ao localao = ((b)h.ae(b.class)).h(((Number)((o)localObject).My).longValue(), ((Number)((o)localObject).Mx).intValue());
      if (localao != null)
      {
        if (paramaqe != null)
        {
          localObject = paramaqe.SDw;
          if (localObject != null) {
            ((LinkedList)localObject).add(localao.zZQ);
          }
        }
        Log.i("Finder.BaseRequestFactory", "fillFinderObjectBaseInfo: feedId = " + com.tencent.mm.ae.d.Fw(localao.zZQ.id) + ", exposeCnt = " + localao.zZQ.SQy + ", exposeTime = " + localao.zZQ.SQx + ", receiveTime = " + localao.zZQ.SQw);
      }
      else
      {
        Log.e("Finder.BaseRequestFactory", "[fillFinderObjectBaseInfo] feed=" + com.tencent.mm.ae.d.Fw(((Number)((o)localObject).My).longValue()) + " commentScene=" + ((Number)((o)localObject).Mx).intValue() + ' ' + Util.getStack());
      }
    }
    AppMethodBeat.o(258150);
  }
  
  public static aqe dnO()
  {
    AppMethodBeat.i(258148);
    aqe localaqe = new aqe();
    Object localObject = j.AkL;
    j.a(localaqe);
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localaqe.SDr = ((f)localObject).aHp().getInt(ar.a.VAG, 0);
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localaqe.SDv = ((f)localObject).aHp().getInt(ar.a.VyS, 4);
    localaqe.yjR = cm.bfD();
    AppMethodBeat.o(258148);
    return localaqe;
  }
  
  public static aqo dnP()
  {
    AppMethodBeat.i(258151);
    aqo localaqo = new aqo();
    localaqo.osName = com.tencent.mm.protocal.d.RAz;
    localaqo.osVersion = com.tencent.mm.protocal.d.RAA;
    localaqo.deviceBrand = com.tencent.mm.protocal.d.RAw;
    localaqo.deviceModel = com.tencent.mm.protocal.d.RAx;
    localaqo.SDN = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    localaqo.netType = ((b)h.ae(b.class)).bvR();
    localaqo.SDO = CdnLogic.getRecentAverageSpeed(2);
    localaqo.SDP = ((b)h.ae(b.class)).bvN();
    localaqo.SDQ.add("h264");
    if (e.vW(4)) {
      localaqo.SDQ.add("h265");
    }
    AppMethodBeat.o(258151);
    return localaqo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ao
 * JD-Core Version:    0.7.0.1
 */