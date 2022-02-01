package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.storage.logic.e.a;
import com.tencent.mm.plugin.finder.storage.logic.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "scene", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bc
  extends ax
{
  private static final String TAG = "Finder.NetSceneFinderFollowVerify";
  public static final a tvg;
  private i callback;
  private final int opType;
  private d rr;
  private final int scene;
  private final ao tvf;
  
  static
  {
    AppMethodBeat.i(242377);
    tvg = new a((byte)0);
    TAG = "Finder.NetSceneFinderFollowVerify";
    AppMethodBeat.o(242377);
  }
  
  public bc(ao paramao, bbn parambbn, int paramInt)
  {
    super(parambbn);
    AppMethodBeat.i(242376);
    this.tvf = paramao;
    this.opType = 1;
    this.scene = paramInt;
    d.a locala = new d.a();
    locala.sG(getType());
    paramao = new arj();
    paramao.LCX = this.tvf.field_followId;
    paramao.dYx = this.opType;
    am localam = am.tuw;
    paramao.LAI = am.a(parambbn);
    locala.c((a)paramao);
    parambbn = new arg();
    parambbn.setBaseResponse(new BaseResponse());
    locala.d((a)parambbn);
    locala.MB("/cgi-bin/micromsg-bin/finderfollowverify");
    parambbn = locala.aXF();
    p.g(parambbn, "builder.buildInstance()");
    this.rr = parambbn;
    Log.i(TAG, "init id:" + this.tvf.field_id + ", " + paramao.LCX + " opType " + this.opType);
    AppMethodBeat.o(242376);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242375);
    Log.i(TAG, "id:" + this.tvf.field_id + ", errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    boolean bool;
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if (paramInt3 == -4042)
      {
        this.tvf.field_followExpireTime = 0L;
        params = e.vGT;
        bool = e.a.a(this.tvf, this.scene);
        Log.i(TAG, "failed expire, id:" + this.tvf.field_id + ", modify extFlag:" + this.tvf.field_extFlag + ", updateDb ret:" + bool);
        params = f.vGV;
        f.FW(this.tvf.field_id);
        params = new hz();
        params.dMB.id = this.tvf.field_id;
        EventCenter.instance.publish((IEvent)params);
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        break label428;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242375);
      return;
      if (paramInt3 != -4043) {
        break;
      }
      this.tvf.field_extFlag |= 0x8;
      params = e.vGT;
      bool = e.a.a(this.tvf, this.scene);
      Log.i(TAG, "failed revoke, id:" + this.tvf.field_id + ", modify extFlag:" + this.tvf.field_extFlag + ", updateDb ret:" + bool);
      break;
      this.tvf.field_extFlag |= 0x4;
      params = e.vGT;
      bool = e.a.a(this.tvf, this.scene);
      Log.i(TAG, "succ, id:" + this.tvf.field_id + ", modify extFlag:" + this.tvf.field_extFlag + ", updateDb ret:" + bool);
    }
    label428:
    AppMethodBeat.o(242375);
  }
  
  public final b cXS()
  {
    return b.tye;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242374);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242374);
    return i;
  }
  
  public final int getType()
  {
    return 6618;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bc
 * JD-Core Version:    0.7.0.1
 */