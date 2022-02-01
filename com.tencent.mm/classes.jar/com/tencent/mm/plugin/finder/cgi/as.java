package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUserPage;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPageResponse;", "username", "", "maxId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "topicId", "biz_username", "clickFeedId", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JLjava/lang/String;J)V", "enterType", "(Ljava/lang/String;I)V", "TAG", "isLoadMore", "", "()Z", "refLiveObjectOd", "Ljava/lang/Long;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUserPageRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "tabType", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
  extends com.tencent.mm.plugin.findersdk.b.c<FinderUserPageResponse>
{
  private byn AAB;
  private final Long AAD;
  private final Integer AAE;
  private final String TAG;
  private final int hJx;
  private int pullType;
  private com.tencent.mm.am.c rr;
  
  public as(String paramString)
  {
    super(null);
    AppMethodBeat.i(336215);
    this.TAG = "Finder.CgiFinderUserPage";
    this.AAB = new byn();
    this.AAD = Long.valueOf(0L);
    this.AAE = Integer.valueOf(0);
    this.AAB.username = paramString;
    this.AAB.ACR = 17;
    this.AAB.firstPageMD5 = "";
    this.AAB.YIZ = z.bAW();
    Object localObject1 = this.AAB;
    Object localObject2 = bi.ABn;
    ((byn)localObject1).CJv = bi.a(null);
    localObject1 = this.AAB.CJv;
    if (localObject1 != null) {
      ((atz)localObject1).scene = 0;
    }
    localObject1 = this.AAB;
    localObject2 = bi.ABn;
    ((byn)localObject1).ZDQ = bi.bTZ();
    localObject1 = new c.a();
    ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)this.AAB);
    localObject2 = new FinderUserPageResponse();
    ((FinderUserPageResponse)localObject2).setBaseResponse(new kd());
    ((FinderUserPageResponse)localObject2).getBaseResponse().akjO = new etl();
    ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)localObject2);
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderuserpage";
    ((c.a)localObject1).funcId = 3736;
    localObject1 = ((c.a)localObject1).bEF();
    s.s(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.am.c)localObject1);
    c(this.rr);
    Log.i(this.TAG, "init username:" + paramString + ", enterType:17");
    AppMethodBeat.o(336215);
  }
  
  public as(String paramString1, long paramLong1, com.tencent.mm.bx.b paramb, int paramInt, bui parambui, long paramLong2, String paramString2, long paramLong3)
  {
    super(null);
    AppMethodBeat.i(336197);
    this.TAG = "Finder.CgiFinderUserPage";
    this.AAB = new byn();
    this.AAD = Long.valueOf(0L);
    this.AAE = Integer.valueOf(0);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject1 = d.a.auT(paramString1);
    c.a locala;
    byn localbyn;
    label187:
    label234:
    long l;
    if (localObject1 == null)
    {
      localObject1 = "";
      locala = new c.a();
      locala.uri = "/cgi-bin/micromsg-bin/finderuserpage";
      locala.funcId = 3736;
      localbyn = new byn();
      localbyn.username = paramString1;
      localbyn.maxId = paramLong1;
      localbyn.firstPageMD5 = ((String)localObject1);
      localbyn.YIZ = z.bAW();
      localbyn.hJx = this.hJx;
      localbyn.ADo = paramLong2;
      Object localObject2 = bi.ABn;
      localbyn.CJv = bi.a(parambui);
      localObject2 = localbyn.CJv;
      if (localObject2 != null)
      {
        if (parambui != null) {
          break label611;
        }
        i = 0;
        ((atz)localObject2).scene = i;
      }
      if (!n.T(localbyn.username, localbyn.YIZ, false))
      {
        parambui = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.eWc().bmg()).booleanValue()) {
          break label621;
        }
      }
      i = 1;
      localbyn.ZDP = i;
      localbyn.lastBuffer = paramb;
      paramb = bi.ABn;
      localbyn.ZDQ = bi.bTZ();
      paramb = k.aeZF;
      paramb = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
      localbyn.longitude = ((Number)paramb.bsC).floatValue();
      localbyn.latitude = ((Number)paramb.bsD).floatValue();
      paramb = this.AAE;
      if (paramb != null) {
        break label627;
      }
      i = 0;
      label332:
      localbyn.scene = i;
      paramb = this.AAD;
      if (paramb != null) {
        break label637;
      }
      l = 0L;
      label353:
      localbyn.aahl = l;
      localbyn.object_id = paramLong3;
      if (((CharSequence)paramString2).length() <= 0) {
        break label647;
      }
      i = 1;
      label383:
      if (i != 0)
      {
        if (paramLong3 == 0L) {
          break label653;
        }
        i = 23;
        localbyn.ACR = i;
        localbyn.ADE = paramString2;
      }
      label399:
      paramb = bi.ABn;
      paramb = localbyn.CJv;
      parambui = localbyn.CJv;
      if (parambui != null) {
        break label660;
      }
    }
    label647:
    label653:
    label660:
    for (int i = 0;; i = parambui.scene)
    {
      bi.a(paramb, p.listOf(new r(Integer.valueOf(i), Long.valueOf(paramLong2))));
      paramb = new FinderUserPageResponse();
      locala.otE = ((com.tencent.mm.bx.a)localbyn);
      locala.otF = ((com.tencent.mm.bx.a)paramb);
      paramb = locala.bEF();
      s.s(paramb, "builder.buildInstance()");
      this.rr = paramb;
      c(this.rr);
      this.pullType = paramInt;
      Log.i("Finder.NetSceneFinderUserPage", "NetSceneFinderUserPage init maxId " + paramLong1 + " username " + paramString1 + " pullType " + paramInt + " fpMD5 " + (String)localObject1);
      AppMethodBeat.o(336197);
      return;
      localObject1 = ((m)localObject1).field_firstPageMD5;
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      break;
      label611:
      i = parambui.hLK;
      break label187;
      label621:
      i = 0;
      break label234;
      label627:
      i = paramb.intValue();
      break label332;
      label637:
      l = paramb.longValue();
      break label353;
      i = 0;
      break label383;
      i = 24;
      break label399;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.as
 * JD-Core Version:    0.7.0.1
 */