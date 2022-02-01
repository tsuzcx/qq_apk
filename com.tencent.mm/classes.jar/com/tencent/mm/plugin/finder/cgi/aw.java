package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dzb;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTagContact;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "getTagScene", "", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetTagScene", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getTagContacts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aw
  extends n
  implements com.tencent.mm.network.k
{
  private static final int KJL = 1;
  public static final a KJM;
  private static final String TAG = "Finder.NetSceneFinderGetTagContact";
  private final int KJK;
  private g callback;
  public b rr;
  
  static
  {
    AppMethodBeat.i(197325);
    KJM = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetTagContact";
    KJL = 1;
    AppMethodBeat.o(197325);
  }
  
  public aw(int paramInt)
  {
    AppMethodBeat.i(197324);
    this.KJK = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).nB(getType());
    dzb localdzb = new dzb();
    localdzb.scene = this.KJK;
    am localam = am.KJy;
    localdzb.DlF = am.fRS();
    ((b.a)localObject).c((a)localdzb);
    ((b.a)localObject).d((a)new dzc());
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/findergettagcontact");
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    ad.i(TAG, "NetSceneFinderGetTagContact");
    AppMethodBeat.o(197324);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(197322);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(197322);
    return i;
  }
  
  public final int getType()
  {
    return 3528;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197323);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(197323);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTagContact$Companion;", "", "()V", "GetTagContactScene_Not_Interesting", "", "getGetTagContactScene_Not_Interesting", "()I", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aw
 * JD-Core Version:    0.7.0.1
 */