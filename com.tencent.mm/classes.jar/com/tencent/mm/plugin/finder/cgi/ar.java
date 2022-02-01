package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTagContact;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "getTagScene", "", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetTagScene", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getTagContacts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ar
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneFinderGetTagContact";
  private static final int rRL = 1;
  public static final a rRM;
  private f callback;
  private final int rRK;
  public b rr;
  
  static
  {
    AppMethodBeat.i(201573);
    rRM = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetTagContact";
    rRL = 1;
    AppMethodBeat.o(201573);
  }
  
  public ar(int paramInt)
  {
    AppMethodBeat.i(201572);
    this.rRK = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).oS(getType());
    aoy localaoy = new aoy();
    localaoy.scene = this.rRK;
    v localv = v.rRb;
    localaoy.GEg = v.czz();
    ((b.a)localObject).c((a)localaoy);
    ((b.a)localObject).d((a)new aoz());
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/findergettagcontact");
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    ae.i(TAG, "NetSceneFinderGetTagContact");
    AppMethodBeat.o(201572);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201570);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201570);
    return i;
  }
  
  public final int getType()
  {
    return 3528;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201571);
    ae.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201571);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTagContact$Companion;", "", "()V", "GetTagContactScene_Not_Interesting", "", "getGetTagContactScene_Not_Interesting", "()I", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ar
 * JD-Core Version:    0.7.0.1
 */