package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.avt;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "wxUsername", "", "opType", "", "scene", "(Ljava/lang/String;II)V", "blackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getBlackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "setBlackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTagContact;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "getWxUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bw
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ABN;
  private static final int ABO;
  private static final int ABP;
  private static final String TAG;
  public bco AzK;
  private com.tencent.mm.am.h callback;
  private final String hLv;
  private final int opType;
  private c rr;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(336384);
    ABN = new a((byte)0);
    TAG = "Finder.NetSceneFinderContactTag";
    ABO = 1;
    ABP = 2;
    AppMethodBeat.o(336384);
  }
  
  public bw(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(336368);
    this.hLv = paramString;
    this.opType = paramInt1;
    this.scene = paramInt2;
    c.a locala = new c.a();
    locala.funcId = getType();
    avs localavs = new avs();
    String str = this.hLv;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    localavs.hLv = paramString;
    localavs.ZFP = this.opType;
    paramString = bi.ABn;
    localavs.ZEc = bi.dVu();
    paramString = localavs.ZEc;
    if (paramString != null) {
      paramString.scene = this.scene;
    }
    locala.otE = ((a)localavs);
    paramString = new avt();
    paramString.setBaseResponse(new kd());
    locala.otF = ((a)paramString);
    locala.uri = "/cgi-bin/micromsg-bin/findercontacttagoption";
    paramString = locala.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.rr = paramString;
    Log.i(TAG, "NetSceneFinderContactTag init " + this.hLv + " opType " + this.opType + " scene " + this.scene + ' ');
    AppMethodBeat.o(336368);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336410);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        aa.makeText(MMApplicationContext.getContext(), (CharSequence)("is debug info findercontacttagoption: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(336410);
      return;
    }
    params = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.hLv);
    if (this.opType == ABO) {
      params.aSl();
    }
    for (;;)
    {
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(params.field_username, params);
      params = d.FML;
      d.a.eZX().onAlive();
      params = d.FML;
      d.a.eZX();
      d.eZV();
      break;
      params.aSm();
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336399);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336399);
    return i;
  }
  
  public final int getType()
  {
    return 3638;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderContactTag$Companion;", "", "()V", "Interesting", "", "getInteresting", "()I", "Not_Interesting", "getNot_Interesting", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bw
 * JD-Core Version:    0.7.0.1
 */