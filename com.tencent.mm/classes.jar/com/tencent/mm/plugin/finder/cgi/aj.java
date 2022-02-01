package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.alg;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTagContact;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "getTagScene", "", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetTagScene", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getTagContacts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aj
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "Finder.NetSceneFinderGetTagContact";
  private static final int qYl = 1;
  public static final a qYm;
  private g callback;
  private final int qYk;
  public b rr;
  
  static
  {
    AppMethodBeat.i(201203);
    qYm = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetTagContact";
    qYl = 1;
    AppMethodBeat.o(201203);
  }
  
  public aj(int paramInt)
  {
    AppMethodBeat.i(201202);
    this.qYk = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).op(getType());
    alg localalg = new alg();
    localalg.scene = this.qYk;
    q localq = q.qXH;
    localalg.EDu = q.csi();
    ((b.a)localObject).c((a)localalg);
    ((b.a)localObject).d((a)new alh());
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/findergettagcontact");
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    ac.i(TAG, "NetSceneFinderGetTagContact");
    AppMethodBeat.o(201202);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(201200);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201200);
    return i;
  }
  
  public final int getType()
  {
    return 3528;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201201);
    ac.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201201);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTagContact$Companion;", "", "()V", "GetTagContactScene_Not_Interesting", "", "getGetTagContactScene_Not_Interesting", "()I", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aj
 * JD-Core Version:    0.7.0.1
 */