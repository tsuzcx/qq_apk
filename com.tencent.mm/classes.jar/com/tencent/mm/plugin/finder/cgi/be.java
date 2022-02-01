package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.f.a.im;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.storage.logic.e.a;
import com.tencent.mm.plugin.finder.storage.logic.f;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "scene", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class be
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final String TAG = "Finder.NetSceneFinderFollowVerify";
  public static final a xcL;
  private i callback;
  private final int opType;
  private d rr;
  private final int scene;
  private final an xcK;
  
  static
  {
    AppMethodBeat.i(257534);
    xcL = new a((byte)0);
    TAG = "Finder.NetSceneFinderFollowVerify";
    AppMethodBeat.o(257534);
  }
  
  public be(an paraman, bid parambid, int paramInt)
  {
    super(parambid);
    AppMethodBeat.i(257533);
    this.xcK = paraman;
    this.opType = 1;
    this.scene = paramInt;
    d.a locala = new d.a();
    locala.vD(getType());
    paraman = new atf();
    paraman.SGj = this.xcK.field_followId;
    paraman.fSo = this.opType;
    ao localao = ao.xcj;
    paraman.SDi = ao.a(parambid);
    locala.c((a)paraman);
    parambid = new atc();
    parambid.setBaseResponse(new jh());
    locala.d((a)parambid);
    locala.TW("/cgi-bin/micromsg-bin/finderfollowverify");
    parambid = locala.bgN();
    p.j(parambid, "builder.buildInstance()");
    this.rr = parambid;
    Log.i(TAG, "init id:" + this.xcK.field_id + ", " + paraman.SGj + " opType " + this.opType);
    AppMethodBeat.o(257533);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(257530);
    Log.i(TAG, "id:" + this.xcK.field_id + ", errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    boolean bool;
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if (paramInt3 == -4042)
      {
        this.xcK.field_followExpireTime = 0L;
        params = e.AnP;
        bool = e.a.a(this.xcK, this.scene);
        Log.i(TAG, "failed expire, id:" + this.xcK.field_id + ", modify extFlag:" + this.xcK.field_extFlag + ", updateDb ret:" + bool);
        params = f.AnR;
        f.MW(this.xcK.field_id);
        params = new im();
        params.fFG.id = this.xcK.field_id;
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
      AppMethodBeat.o(257530);
      return;
      if (paramInt3 != -4043) {
        break;
      }
      this.xcK.field_extFlag |= 0x8;
      params = e.AnP;
      bool = e.a.a(this.xcK, this.scene);
      Log.i(TAG, "failed revoke, id:" + this.xcK.field_id + ", modify extFlag:" + this.xcK.field_extFlag + ", updateDb ret:" + bool);
      break;
      this.xcK.field_extFlag |= 0x4;
      params = e.AnP;
      bool = e.a.a(this.xcK, this.scene);
      Log.i(TAG, "succ, id:" + this.xcK.field_id + ", modify extFlag:" + this.xcK.field_extFlag + ", updateDb ret:" + bool);
    }
    label428:
    AppMethodBeat.o(257530);
  }
  
  public final b dnF()
  {
    return b.BvU;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(257529);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(257529);
    return i;
  }
  
  public final int getType()
  {
    return 6618;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.be
 * JD-Core Version:    0.7.0.1
 */