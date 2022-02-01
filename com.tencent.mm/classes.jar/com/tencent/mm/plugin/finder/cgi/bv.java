package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.protocal.protobuf.aue;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBindPoiStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "friendUsername", "", "bindList", "Ljava/util/LinkedList;", "(Ljava/lang/String;Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getPoiInfoList", "Lcom/tencent/mm/protocal/protobuf/FinderBindPoiInfo;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bv
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final bv.a ABM;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  static
  {
    AppMethodBeat.i(336370);
    ABM = new bv.a((byte)0);
    AppMethodBeat.o(336370);
  }
  
  public bv(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(336365);
    c.a locala = new c.a();
    locala.funcId = getType();
    auf localauf = new auf();
    bi localbi = bi.ABn;
    localauf.YIY = bi.dVu();
    localauf.YIZ = paramString;
    localauf.ZEJ.addAll((Collection)paramLinkedList);
    paramString = k.aeZF;
    paramString = ((b)k.cn(PluginFinder.class).q(b.class)).dUh();
    localauf.longitude = ((Number)paramString.bsC).floatValue();
    localauf.latitude = ((Number)paramString.bsD).floatValue();
    locala.otE = ((a)localauf);
    locala.otF = ((a)new aug());
    locala.uri = "/cgi-bin/micromsg-bin/finderbindpoi";
    paramString = locala.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.rr = paramString;
    AppMethodBeat.o(336365);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336387);
    Log.i("Finder.NetSceneFinderBindPoiStream", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336387);
  }
  
  public final LinkedList<aue> dVE()
  {
    AppMethodBeat.i(336396);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderBindPoiResponse");
      AppMethodBeat.o(336396);
      throw ((Throwable)localObject);
    }
    localObject = ((aug)localObject).ZEK;
    AppMethodBeat.o(336396);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336380);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336380);
    return i;
  }
  
  public final int getType()
  {
    return 4078;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bv
 * JD-Core Version:    0.7.0.1
 */