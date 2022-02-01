package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDelMessage;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "userName", "", "mentionId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "objectId", "refCommentId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "mentionType", "", "(Ljava/lang/String;JLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JJLcom/tencent/mm/protobuf/ByteString;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getMentionId", "()J", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bx
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ABQ;
  private final long AAW;
  public final long ABR;
  private final int ABS;
  private com.tencent.mm.am.h callback;
  private final long hKN;
  private final b lastBuffer;
  private c oDw;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(336376);
    ABQ = new a((byte)0);
    AppMethodBeat.o(336376);
  }
  
  public bx(String paramString, long paramLong1, long paramLong2, long paramLong3, b paramb, int paramInt)
  {
    super(null);
    AppMethodBeat.i(336371);
    this.userName = paramString;
    this.ABR = paramLong1;
    this.hKN = paramLong2;
    this.AAW = paramLong3;
    this.lastBuffer = paramb;
    this.ABS = paramInt;
    paramString = new c.a();
    paramString.funcId = getType();
    paramString.uri = "/cgi-bin/micromsg-bin/finderdelmention";
    paramb = new awk();
    paramb.username = this.userName;
    paramb.ABR = this.ABR;
    paramb.ZHg = this.lastBuffer;
    paramb.refObjectId = this.hKN;
    paramb.AAW = this.AAW;
    paramb.ABS = this.ABS;
    bi localbi = bi.ABn;
    paramb.CJv = bi.a(null);
    paramString.otE = ((a)paramb);
    paramString.otF = ((a)new awl());
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.oDw = paramString;
    Log.i("Finder.NetSceneFinderDelMessage", "NetSceneFinderDelMessage init  userName: " + this.userName + " mentionId:" + this.ABR);
    AppMethodBeat.o(336371);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336392);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(336392);
    return i;
  }
  
  public final int getType()
  {
    return 6690;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(336401);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("Finder.NetSceneFinderDelMessage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336401);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDelMessage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bx
 * JD-Core Version:    0.7.0.1
 */