package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.data.c;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.amc;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "wxUsername", "", "opType", "", "scene", "(Ljava/lang/String;II)V", "blackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getBlackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "setBlackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTagContact;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "getWxUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ad
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneFinderContactTag";
  private static final int rJa = 1;
  private static final int rJb = 2;
  public static final a rJc;
  private f callback;
  private final String dul;
  private final int opType;
  public aot rId;
  private b rr;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(201106);
    rJc = new a((byte)0);
    TAG = "Finder.NetSceneFinderContactTag";
    rJa = 1;
    rJb = 2;
    AppMethodBeat.o(201106);
  }
  
  public ad(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201105);
    this.dul = paramString;
    this.opType = paramInt1;
    this.scene = paramInt2;
    paramString = new b.a();
    paramString.oP(getType());
    Object localObject = new amc();
    ((amc)localObject).dul = this.dul;
    ((amc)localObject).GlI = this.opType;
    v localv = v.rIR;
    ((amc)localObject).Gle = v.cxY();
    ((amc)localObject).Gle.scene = this.scene;
    paramString.c((a)localObject);
    localObject = new amd();
    ((amd)localObject).setBaseResponse(new BaseResponse());
    paramString.d((a)localObject);
    paramString.Dl("/cgi-bin/micromsg-bin/findercontacttagoption");
    paramString = paramString.aDC();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "NetSceneFinderContactTag init " + this.dul + " opType " + this.opType + " scene " + this.scene + ' ');
    AppMethodBeat.o(201105);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201103);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201103);
    return i;
  }
  
  public final int getType()
  {
    return 3638;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201104);
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if ((i.IS_FLAVOR_PURPLE) || (i.IS_FLAVOR_RED)) {
        t.makeText(aj.getContext(), (CharSequence)("is debug info findercontacttagoption: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gfZ();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(201104);
      return;
      paramq = c.szF;
      c.a.cJc().onAlive();
      paramq = c.szF;
      c.a.cJc();
      c.cJa();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag$Companion;", "", "()V", "Interesting", "", "getInteresting", "()I", "Not_Interesting", "getNot_Interesting", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ad
 * JD-Core Version:    0.7.0.1
 */