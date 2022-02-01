package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.findersdk.a.bi.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPoiStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "fromScene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/SnsLocation;Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/Integer;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getFriendLikeCount", "getNoticeWording", "", "getOnlyShowPoiName", "getPoiDetail", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "getPoiPrepare", "Lcom/tencent/mm/protocal/protobuf/PoiPrepare;", "getRespLastBuffer", "getType", "getVideoCount", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class df
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ACZ;
  private com.tencent.mm.am.h callback;
  public int pullType;
  public c rr;
  
  static
  {
    AppMethodBeat.i(336563);
    ACZ = new a((byte)0);
    AppMethodBeat.o(336563);
  }
  
  private df(fei paramfei, bi.a parama, b paramb, Integer paramInteger)
  {
    super(null);
    AppMethodBeat.i(336555);
    c.a locala = new c.a();
    locala.funcId = getType();
    bsj localbsj = new bsj();
    bi localbi = bi.ABn;
    localbsj.YIY = bi.a(null);
    localbsj.hQv = paramfei.ZWG;
    localbsj.longitude = paramfei.ZaG;
    localbsj.latitude = paramfei.ZaH;
    localbsj.aaah = parama.ordinal();
    localbsj.ZEQ = paramb;
    paramfei = bi.ABn;
    localbsj.ZDQ = bi.bTZ();
    if (paramInteger != null) {
      localbsj.aaah = ((Number)paramInteger).intValue();
    }
    locala.otE = ((a)localbsj);
    locala.funcId = getType();
    locala.otF = ((a)new bsk());
    locala.uri = "/cgi-bin/micromsg-bin/finderpoistream";
    paramfei = locala.bEF();
    kotlin.g.b.s.s(paramfei, "builder.buildInstance()");
    this.rr = paramfei;
    AppMethodBeat.o(336555);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336578);
    Log.i("Finder.NetSceneFinderPoiStream", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = c.c.b(this.rr.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
      AppMethodBeat.o(336578);
      throw paramString;
    }
    Log.i("Finder.NetSceneFinderPoiStream", kotlin.g.b.s.X("server increatment size:", Integer.valueOf(((bsk)params).object.size())));
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (c.c.b(this.rr.otC) == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
        AppMethodBeat.o(336578);
        throw paramString;
      }
      params = ((Iterable)dWd()).iterator();
      while (params.hasNext())
      {
        FinderObject localFinderObject = (FinderObject)params.next();
        z localz = z.FrZ;
        z.a(localFinderObject, getContextObj());
      }
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336578);
  }
  
  public final b dVY()
  {
    AppMethodBeat.i(336593);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
      AppMethodBeat.o(336593);
      throw ((Throwable)localObject);
    }
    localObject = ((bsk)localObject).ZEQ;
    AppMethodBeat.o(336593);
    return localObject;
  }
  
  public final int dVZ()
  {
    AppMethodBeat.i(336601);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
      AppMethodBeat.o(336601);
      throw ((Throwable)localObject);
    }
    int i = ((bsk)localObject).BeA;
    AppMethodBeat.o(336601);
    return i;
  }
  
  public final List<FinderObject> dWd()
  {
    AppMethodBeat.i(336588);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
      AppMethodBeat.o(336588);
      throw ((Throwable)localObject);
    }
    localObject = ((bsk)localObject).object;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…iStreamResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(336588);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336568);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336568);
    return i;
  }
  
  public final int getType()
  {
    return 5225;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPoiStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.df
 * JD-Core Version:    0.7.0.1
 */