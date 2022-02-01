package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowTopicList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "userName", "", "(Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestBuffer", "getResponseBuffer", "getTopicCount", "getTopicList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getType", "hasContine", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bk
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  public d rr;
  
  public bk(b paramb, String paramString)
  {
    AppMethodBeat.i(242417);
    this.TAG = "Finder.NetSceneFinderGetFollowTopicList";
    d.a locala = new d.a();
    locala.sG(getType());
    ash localash = new ash();
    localash.LDs = paramb;
    paramb = am.tuw;
    localash.LCA = am.cXY();
    localash.LAt = paramString;
    locala.c((a)localash);
    locala.d((a)new asi());
    locala.MB("/cgi-bin/micromsg-bin/findergetfollowtopiclist");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetFollowList init ");
    AppMethodBeat.o(242417);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242414);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      e.Cxv.idkeyStat(1279L, 7L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242414);
      return;
      e.Cxv.idkeyStat(1279L, 8L, 1L, false);
    }
  }
  
  public final LinkedList<bds> cYu()
  {
    AppMethodBeat.i(242415);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowTopicListResponse");
      AppMethodBeat.o(242415);
      throw ((Throwable)localObject);
    }
    localObject = ((asi)localObject).Gbc;
    p.g(localObject, "(rr.responseProtoBuf as …TopicListResponse).topics");
    AppMethodBeat.o(242415);
    return localObject;
  }
  
  public final int cYv()
  {
    AppMethodBeat.i(242416);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowTopicListResponse");
      AppMethodBeat.o(242416);
      throw ((Throwable)localObject);
    }
    int i = ((asi)localObject).LDt;
    AppMethodBeat.o(242416);
    return i;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242413);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242413);
    return i;
  }
  
  public final int getType()
  {
    return 712;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bk
 * JD-Core Version:    0.7.0.1
 */