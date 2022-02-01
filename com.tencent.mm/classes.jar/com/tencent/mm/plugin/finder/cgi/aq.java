package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.data.h.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.t;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "wxUsername", "", "opType", "", "scene", "(Ljava/lang/String;II)V", "blackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getBlackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "setBlackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTagContact;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "getWxUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aq
  extends n
  implements com.tencent.mm.network.k
{
  private static final int KJA = 1;
  private static final int KJB = 2;
  public static final a KJC;
  private static final String TAG = "Finder.NetSceneFinderContactTag";
  public dzd KJs;
  private g callback;
  private final String hKD;
  private final int opType;
  private b rr;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(197286);
    KJC = new a((byte)0);
    TAG = "Finder.NetSceneFinderContactTag";
    KJA = 1;
    KJB = 2;
    AppMethodBeat.o(197286);
  }
  
  public aq(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197285);
    this.hKD = paramString;
    this.opType = paramInt1;
    this.scene = paramInt2;
    paramString = new b.a();
    paramString.nB(getType());
    Object localObject = new dyk();
    ((dyk)localObject).hKD = this.hKD;
    ((dyk)localObject).Lxo = this.opType;
    am localam = am.KJy;
    ((dyk)localObject).DlF = am.fRS();
    ((dyk)localObject).DlF.scene = this.scene;
    paramString.c((a)localObject);
    localObject = new dyl();
    ((dyl)localObject).setBaseResponse(new BaseResponse());
    paramString.d((a)localObject);
    paramString.wg("/cgi-bin/micromsg-bin/findercontacttagoption");
    paramString = paramString.atI();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ad.i(TAG, "NetSceneFinderContactTag init " + this.hKD + " opType " + this.opType + " scene " + this.scene + ' ');
    AppMethodBeat.o(197285);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(197283);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(197283);
    return i;
  }
  
  public final int getType()
  {
    return 3638;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197284);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
        t.makeText(aj.getContext(), (CharSequence)("is debug info findercontacttagoption: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fvU();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(197284);
      return;
      paramq = com.tencent.mm.plugin.finder.storage.data.h.KXp;
      h.a.fVe().onAlive();
      paramq = com.tencent.mm.plugin.finder.storage.data.h.KXp;
      h.a.fVe();
      com.tencent.mm.plugin.finder.storage.data.h.fVc();
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag$Companion;", "", "()V", "Interesting", "", "getInteresting", "()I", "Not_Interesting", "getNot_Interesting", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aq
 * JD-Core Version:    0.7.0.1
 */