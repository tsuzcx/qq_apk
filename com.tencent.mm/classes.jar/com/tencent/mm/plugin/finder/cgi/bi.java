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
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "friendUsername", "", "feedId", "", "nonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFriendUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFoldedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bi
  extends ax
{
  private final String TAG;
  private i callback;
  private final long feedId;
  public int pullType;
  public d rr;
  private final String tvk;
  
  public bi(String paramString1, long paramLong, String paramString2, b paramb, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242409);
    this.tvk = paramString1;
    this.feedId = paramLong;
    this.TAG = "Finder.NetSceneFinderGetFoldedList";
    paramString1 = new d.a();
    paramString1.sG(getType());
    asd localasd = new asd();
    localasd.tvk = this.tvk;
    localasd.hFK = this.feedId;
    localasd.lastBuffer = paramb;
    localasd.objectNonceId = paramString2;
    paramb = am.tuw;
    localasd.LAI = am.a(parambbn);
    paramString1.c((a)localasd);
    paramString1.d((a)new ase());
    paramString1.MB("/cgi-bin/micromsg-bin/findergetfoldedlist");
    paramString1 = paramString1.aXF();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    Log.i(this.TAG, "NetSceneFinderGetFoldedList friendUsername:" + this.tvk + " feedId:" + this.feedId + " nonceId:" + paramString2);
    AppMethodBeat.o(242409);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242407);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      e.Cxv.idkeyStat(1279L, 9L, 1L, false);
      params = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("friendUsername ").append(this.tvk).append("  feedId:").append(this.feedId).append(' ');
      al localal = al.tuv;
      Log.i(params, al.dQ((List)cYs()));
      params = cYs();
      if (params != null) {
        params = ((Iterable)params).iterator();
      }
    }
    else
    {
      while (params.hasNext())
      {
        d((FinderObject)params.next());
        continue;
        e.Cxv.idkeyStat(1279L, 10L, 1L, false);
      }
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242407);
      return;
    }
    AppMethodBeat.o(242407);
  }
  
  public final boolean cXQ()
  {
    return true;
  }
  
  public final LinkedList<FinderObject> cYs()
  {
    AppMethodBeat.i(242408);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
      AppMethodBeat.o(242408);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((ase)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(242408);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242406);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242406);
    return i;
  }
  
  public final int getType()
  {
    return 3904;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bi
 * JD-Core Version:    0.7.0.1
 */