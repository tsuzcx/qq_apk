package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderMusicUserPage;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "enterType", "", "userName", "", "finderSelfUserName", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getEnterType", "()I", "getFinderSelfUserName", "()Ljava/lang/String;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "setPullType", "(I)V", "getUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFinderItems", "getLastBuffer", "getType", "hasMore", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cy
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ACQ;
  private final String ACN;
  private final int ACR;
  private List<? extends FinderItem> ACl;
  private com.tencent.mm.am.h callback;
  public c oDw;
  public int pullType;
  public final String userName;
  
  static
  {
    AppMethodBeat.i(336597);
    ACQ = new a((byte)0);
    AppMethodBeat.o(336597);
  }
  
  public cy(int paramInt1, String paramString1, String paramString2, b paramb, int paramInt2, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336590);
    this.ACR = paramInt1;
    this.userName = paramString1;
    this.ACN = paramString2;
    c.a locala = new c.a();
    bql localbql = new bql();
    locala.otE = ((a)localbql);
    localbql.username = this.userName;
    paramString2 = this.ACN;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = z.bAW();
    }
    localbql.finderUsername = paramString1;
    localbql.ACR = this.ACR;
    localbql.lastBuffer = paramb;
    this.pullType = paramInt2;
    paramString1 = bi.ABn;
    localbql.YIY = bi.a(parambui);
    locala.otF = ((a)new bqm());
    locala.uri = "/cgi-bin/micromsg-bin/findermusicuserpage";
    locala.funcId = getType();
    paramString1 = locala.bEF();
    kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
    this.oDw = paramString1;
    Log.i("Finder.CgiFinderModMentioned", "NetSceneFinderMVUserPage init finderUserName " + this.userName + " finderSelfUserName: " + this.ACN);
    AppMethodBeat.o(336590);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336612);
    Log.i("Finder.CgiFinderModMentioned", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMusicUserPageResponse");
        AppMethodBeat.o(336612);
        throw paramString;
      }
      params = (bqm)params;
      d.a locala = d.FND;
      params = params.object;
      kotlin.g.b.s.s(params, "resp.`object`");
      this.ACl = d.a.a((List)params, 196608, getContextObj());
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336612);
  }
  
  public final List<FinderItem> dWn()
  {
    List localList2 = this.ACl;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = (List)ab.aivy;
    }
    return localList1;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336603);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(336603);
    return i;
  }
  
  public final int getType()
  {
    return 5999;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderMusicUserPage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cy
 * JD-Core Version:    0.7.0.1
 */