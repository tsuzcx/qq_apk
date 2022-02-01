package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDelMessage;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "userName", "", "mentionId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "objectId", "refCommentId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "mentionType", "", "(Ljava/lang/String;JLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JJLcom/tencent/mm/protobuf/ByteString;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getMentionId", "()J", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bb
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xcF;
  private i callback;
  private d lKU;
  private final b lastBuffer;
  private final String userName;
  private final long xbT;
  private final long xbk;
  public final long xcD;
  private final int xcE;
  
  static
  {
    AppMethodBeat.i(276937);
    xcF = new a((byte)0);
    AppMethodBeat.o(276937);
  }
  
  public bb(String paramString, long paramLong1, long paramLong2, long paramLong3, b paramb, int paramInt)
  {
    super(null);
    AppMethodBeat.i(276936);
    this.userName = paramString;
    this.xcD = paramLong1;
    this.xbk = paramLong2;
    this.xbT = paramLong3;
    this.lastBuffer = paramb;
    this.xcE = paramInt;
    paramString = new d.a();
    paramString.vD(getType());
    paramString.TW("/cgi-bin/micromsg-bin/finderdelmention");
    paramb = new arz();
    paramb.username = this.userName;
    paramb.xcD = this.xcD;
    paramb.SFq = this.lastBuffer;
    paramb.refObjectId = this.xbk;
    paramb.xbT = this.xbT;
    paramb.xcE = this.xcE;
    ao localao = ao.xcj;
    paramb.yjp = ao.a(null);
    paramString.c((a)paramb);
    paramString.d((a)new asa());
    paramString = paramString.bgN();
    p.j(paramString, "builder.buildInstance()");
    this.lKU = paramString;
    Log.i("Finder.NetSceneFinderDelMessage", "NetSceneFinderDelMessage init  userName: " + this.userName + " mentionId:" + this.xcD);
    AppMethodBeat.o(276936);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(276934);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(276934);
    return i;
  }
  
  public final int getType()
  {
    return 6690;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(276935);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("Finder.NetSceneFinderDelMessage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(276935);
      return;
    }
    AppMethodBeat.o(276935);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDelMessage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bb
 * JD-Core Version:    0.7.0.1
 */