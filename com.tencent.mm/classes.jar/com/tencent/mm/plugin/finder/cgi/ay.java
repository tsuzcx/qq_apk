package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "wxUsername", "", "opType", "", "scene", "(Ljava/lang/String;II)V", "blackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getBlackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "setBlackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTagContact;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "getWxUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ay
  extends ax
  implements m
{
  private static final String TAG = "Finder.NetSceneFinderContactTag";
  private static final int tuU = 1;
  private static final int tuV = 2;
  public static final a tuW;
  private i callback;
  private final String dMW;
  private final int opType;
  private com.tencent.mm.ak.d rr;
  private final int scene;
  public aul ttq;
  
  static
  {
    AppMethodBeat.i(242363);
    tuW = new a((byte)0);
    TAG = "Finder.NetSceneFinderContactTag";
    tuU = 1;
    tuV = 2;
    AppMethodBeat.o(242363);
  }
  
  public ay(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242362);
    this.dMW = paramString;
    this.opType = paramInt1;
    this.scene = paramInt2;
    com.tencent.mm.ak.d.a locala = new com.tencent.mm.ak.d.a();
    locala.sG(getType());
    apv localapv = new apv();
    String str = this.dMW;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    localapv.dMW = paramString;
    localapv.LBE = this.opType;
    paramString = am.tuw;
    localapv.LAI = am.cXY();
    paramString = localapv.LAI;
    if (paramString != null) {
      paramString.scene = this.scene;
    }
    locala.c((a)localapv);
    paramString = new apw();
    paramString.setBaseResponse(new BaseResponse());
    locala.d((a)paramString);
    locala.MB("/cgi-bin/micromsg-bin/findercontacttagoption");
    paramString = locala.aXF();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    Log.i(TAG, "NetSceneFinderContactTag init " + this.dMW + " opType " + this.opType + " scene " + this.scene + ' ');
    AppMethodBeat.o(242362);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242361);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        u.makeText(MMApplicationContext.getContext(), (CharSequence)("is debug info findercontacttagoption: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242361);
      return;
    }
    params = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(params, "MMKernel.service(IMessengerStorage::class.java)");
    params = ((com.tencent.mm.plugin.messenger.foundation.a.l)params).aSN().Kn(this.dMW);
    if (this.opType == tuU) {
      params.arj();
    }
    for (;;)
    {
      Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN();
      p.g(params, "contact");
      ((bv)localObject).c(params.getUsername(), params);
      params = com.tencent.mm.plugin.finder.storage.data.d.vFS;
      com.tencent.mm.plugin.finder.storage.data.d.a.dyw().onAlive();
      params = com.tencent.mm.plugin.finder.storage.data.d.vFS;
      com.tencent.mm.plugin.finder.storage.data.d.a.dyw();
      com.tencent.mm.plugin.finder.storage.data.d.dyu();
      break;
      params.ark();
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(242360);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242360);
    return i;
  }
  
  public final int getType()
  {
    return 3638;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag$Companion;", "", "()V", "Interesting", "", "getInteresting", "()I", "Not_Interesting", "getNot_Interesting", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ay
 * JD-Core Version:    0.7.0.1
 */