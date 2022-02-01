package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/NetSceneFinderGetUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "urlList", "", "", "(Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getPromoterToken", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cs
  extends p
  implements m
{
  private c ACJ;
  public List<String> HcC;
  private final String TAG;
  private h callback;
  
  public cs(List<String> paramList)
  {
    AppMethodBeat.i(168877);
    this.TAG = "Finder.NetSceneFinderGetUser";
    c.a locala = new c.a();
    bbh localbbh = new bbh();
    localbbh.ABk.addAll((Collection)paramList);
    bbi localbbi = new bbi();
    locala.otE = ((a)localbbh);
    locala.otF = ((a)localbbi);
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/findergetuser";
    this.ACJ = locala.bEF();
    this.HcC = paramList;
    AppMethodBeat.o(168877);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(168875);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.ACJ, (m)this);
    AppMethodBeat.o(168875);
    return i;
  }
  
  public final int getType()
  {
    return 3512;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(168876);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(168876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.cs
 * JD-Core Version:    0.7.0.1
 */