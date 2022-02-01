package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.data.c;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "wxUsername", "", "opType", "", "scene", "(Ljava/lang/String;II)V", "blackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getBlackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "setBlackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTagContact;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "getWxUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ae
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneFinderContactTag";
  private static final int rRo = 1;
  private static final int rRp = 2;
  public static final a rRq;
  private f callback;
  private final String dvq;
  private final int opType;
  public apg rQo;
  private b rr;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(201528);
    rRq = new a((byte)0);
    TAG = "Finder.NetSceneFinderContactTag";
    rRo = 1;
    rRp = 2;
    AppMethodBeat.o(201528);
  }
  
  public ae(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201527);
    this.dvq = paramString;
    this.opType = paramInt1;
    this.scene = paramInt2;
    b.a locala = new b.a();
    locala.oS(getType());
    amo localamo = new amo();
    String str = this.dvq;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    localamo.dvq = paramString;
    localamo.GEK = this.opType;
    paramString = v.rRb;
    localamo.GEg = v.czz();
    paramString = localamo.GEg;
    if (paramString != null) {
      paramString.scene = this.scene;
    }
    locala.c((a)localamo);
    paramString = new amp();
    paramString.setBaseResponse(new BaseResponse());
    locala.d((a)paramString);
    locala.DN("/cgi-bin/micromsg-bin/findercontacttagoption");
    paramString = locala.aDS();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "NetSceneFinderContactTag init " + this.dvq + " opType " + this.opType + " scene " + this.scene + ' ');
    AppMethodBeat.o(201527);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201525);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201525);
    return i;
  }
  
  public final int getType()
  {
    return 3638;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201526);
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if ((j.IS_FLAVOR_PURPLE) || (j.IS_FLAVOR_RED)) {
        t.makeText(ak.getContext(), (CharSequence)("is debug info findercontacttagoption: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gkB();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(201526);
      return;
      paramq = c.sKz;
      c.a.cLE().onAlive();
      paramq = c.sKz;
      c.a.cLE();
      c.cLC();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag$Companion;", "", "()V", "Interesting", "", "getInteresting", "()I", "Not_Interesting", "getNot_Interesting", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ae
 * JD-Core Version:    0.7.0.1
 */