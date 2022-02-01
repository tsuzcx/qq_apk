package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.finder.storage.data.c;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.base.t;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "wxUsername", "", "opType", "", "scene", "(Ljava/lang/String;II)V", "blackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getBlackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "setBlackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTagContact;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "getWxUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class x
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "Finder.NetSceneFinderContactTag";
  private static final int qXQ = 1;
  private static final int qXR = 2;
  public static final a qXS;
  private g callback;
  private final String diA;
  private final int opType;
  public alo qXc;
  private b rr;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(201163);
    qXS = new a((byte)0);
    TAG = "Finder.NetSceneFinderContactTag";
    qXQ = 1;
    qXR = 2;
    AppMethodBeat.o(201163);
  }
  
  public x(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201162);
    this.diA = paramString;
    this.opType = paramInt1;
    this.scene = paramInt2;
    paramString = new b.a();
    paramString.op(getType());
    Object localObject = new ajh();
    ((ajh)localObject).diA = this.diA;
    ((ajh)localObject).EDT = this.opType;
    q localq = q.qXH;
    ((ajh)localObject).EDu = q.csi();
    ((ajh)localObject).EDu.scene = this.scene;
    paramString.c((a)localObject);
    localObject = new aji();
    ((aji)localObject).setBaseResponse(new BaseResponse());
    paramString.d((a)localObject);
    paramString.Am("/cgi-bin/micromsg-bin/findercontacttagoption");
    paramString = paramString.aAz();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ac.i(TAG, "NetSceneFinderContactTag init " + this.diA + " opType " + this.opType + " scene " + this.scene + ' ');
    AppMethodBeat.o(201162);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(201160);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201160);
    return i;
  }
  
  public final int getType()
  {
    return 3638;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201161);
    ac.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if ((h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED)) {
        t.makeText(ai.getContext(), (CharSequence)("is debug info findercontacttagoption: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fOy();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(201161);
      return;
      paramq = c.rEC;
      c.a.cBc().onAlive();
      paramq = c.rEC;
      c.a.cBc();
      c.cBa();
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag$Companion;", "", "()V", "Interesting", "", "getInteresting", "()I", "Not_Interesting", "getNot_Interesting", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.x
 * JD-Core Version:    0.7.0.1
 */