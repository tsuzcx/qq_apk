package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/NetSceneFinderGetUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "urlList", "", "", "(Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "finder-sdk_release"})
public final class am
  extends q
  implements m
{
  private final String TAG;
  private i callback;
  private d tvD;
  
  public am(List<String> paramList)
  {
    AppMethodBeat.i(168877);
    this.TAG = "Finder.NetSceneFinderGetUser";
    d.a locala = new d.a();
    atw localatw = new atw();
    localatw.LEJ.addAll((Collection)paramList);
    paramList = new atx();
    locala.c((a)localatw);
    locala.d((a)paramList);
    locala.sG(getType());
    locala.MB("/cgi-bin/micromsg-bin/findergetuser");
    this.tvD = locala.aXF();
    AppMethodBeat.o(168877);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(168875);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.tvD, (m)this);
    AppMethodBeat.o(168875);
    return i;
  }
  
  public final int getType()
  {
    return 3512;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(168876);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(168876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.am
 * JD-Core Version:    0.7.0.1
 */