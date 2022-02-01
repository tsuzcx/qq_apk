package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "wxUsername", "", "opType", "", "scene", "(Ljava/lang/String;II)V", "blackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getBlackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "setBlackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTagContact;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "getWxUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ba
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final String TAG = "Finder.NetSceneFinderContactTag";
  private static final int xcA = 1;
  private static final int xcB = 2;
  public static final a xcC;
  private i callback;
  private final String fGe;
  private final int opType;
  private com.tencent.mm.an.d rr;
  private final int scene;
  public awr xbh;
  
  static
  {
    AppMethodBeat.i(282356);
    xcC = new a((byte)0);
    TAG = "Finder.NetSceneFinderContactTag";
    xcA = 1;
    xcB = 2;
    AppMethodBeat.o(282356);
  }
  
  public ba(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(282355);
    this.fGe = paramString;
    this.opType = paramInt1;
    this.scene = paramInt2;
    com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
    locala.vD(getType());
    arj localarj = new arj();
    String str = this.fGe;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    localarj.fGe = paramString;
    localarj.SEp = this.opType;
    paramString = ao.xcj;
    localarj.SDi = ao.dnO();
    paramString = localarj.SDi;
    if (paramString != null) {
      paramString.scene = this.scene;
    }
    locala.c((a)localarj);
    paramString = new ark();
    paramString.setBaseResponse(new jh());
    locala.d((a)paramString);
    locala.TW("/cgi-bin/micromsg-bin/findercontacttagoption");
    paramString = locala.bgN();
    p.j(paramString, "builder.buildInstance()");
    this.rr = paramString;
    Log.i(TAG, "NetSceneFinderContactTag init " + this.fGe + " opType " + this.opType + " scene " + this.scene + ' ');
    AppMethodBeat.o(282355);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(282354);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        w.makeText(MMApplicationContext.getContext(), (CharSequence)("is debug info findercontacttagoption: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.iCn();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(282354);
      return;
    }
    params = h.ae(n.class);
    p.j(params, "MMKernel.service(IMessengerStorage::class.java)");
    params = ((n)params).bbL().RG(this.fGe);
    if (this.opType == xcA) {
      params.axJ();
    }
    for (;;)
    {
      Object localObject = h.ae(n.class);
      p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((n)localObject).bbL();
      p.j(params, "contact");
      ((bv)localObject).c(params.getUsername(), params);
      params = com.tencent.mm.plugin.finder.storage.data.d.AmR;
      com.tencent.mm.plugin.finder.storage.data.d.a.dZo().onAlive();
      params = com.tencent.mm.plugin.finder.storage.data.d.AmR;
      com.tencent.mm.plugin.finder.storage.data.d.a.dZo();
      com.tencent.mm.plugin.finder.storage.data.d.dZm();
      break;
      params.axK();
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(282353);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(282353);
    return i;
  }
  
  public final int getType()
  {
    return 3638;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag$Companion;", "", "()V", "Interesting", "", "getInteresting", "()I", "Not_Interesting", "getNot_Interesting", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ba
 * JD-Core Version:    0.7.0.1
 */