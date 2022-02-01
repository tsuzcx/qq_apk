package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTagContact;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "getTagScene", "", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetTagScene", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getTagContacts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aq
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneFinderGetTagContact";
  private static final int rJx = 1;
  public static final a rJy;
  private f callback;
  private final int rJw;
  public b rr;
  
  static
  {
    AppMethodBeat.i(201151);
    rJy = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetTagContact";
    rJx = 1;
    AppMethodBeat.o(201151);
  }
  
  public aq(int paramInt)
  {
    AppMethodBeat.i(201150);
    this.rJw = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).oP(getType());
    aol localaol = new aol();
    localaol.scene = this.rJw;
    v localv = v.rIR;
    localaol.Gle = v.cxY();
    ((b.a)localObject).c((a)localaol);
    ((b.a)localObject).d((a)new aom());
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/findergettagcontact");
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((b)localObject);
    ad.i(TAG, "NetSceneFinderGetTagContact");
    AppMethodBeat.o(201150);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201148);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201148);
    return i;
  }
  
  public final int getType()
  {
    return 3528;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201149);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201149);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTagContact$Companion;", "", "()V", "GetTagContactScene_Not_Interesting", "", "getGetTagContactScene_Not_Interesting", "()I", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aq
 * JD-Core Version:    0.7.0.1
 */