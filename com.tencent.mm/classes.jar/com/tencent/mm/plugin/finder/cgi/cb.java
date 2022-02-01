package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.jd;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.plugin.finder.storage.logic.f;
import com.tencent.mm.plugin.finder.storage.logic.f.a;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "scene", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cb
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ACa;
  private static final String TAG;
  private final av ACb;
  private com.tencent.mm.am.h callback;
  private final int opType;
  private c rr;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(336324);
    ACa = new a((byte)0);
    TAG = "Finder.NetSceneFinderFollowVerify";
    AppMethodBeat.o(336324);
  }
  
  public cb(av paramav, bui parambui, int paramInt)
  {
    super(parambui);
    AppMethodBeat.i(336318);
    this.ACb = paramav;
    this.opType = 1;
    this.scene = paramInt;
    c.a locala = new c.a();
    locala.funcId = getType();
    paramav = new axt();
    paramav.ZIT = this.ACb.field_followId;
    paramav.hYl = this.opType;
    bi localbi = bi.ABn;
    paramav.ZEc = bi.a(parambui);
    locala.otE = ((a)paramav);
    parambui = new axq();
    parambui.setBaseResponse(new kd());
    locala.otF = ((a)parambui);
    locala.uri = "/cgi-bin/micromsg-bin/finderfollowverify";
    parambui = locala.bEF();
    kotlin.g.b.s.s(parambui, "builder.buildInstance()");
    this.rr = parambui;
    Log.i(TAG, "init id:" + this.ACb.field_id + ", " + paramav.ZIT + " opType " + this.opType);
    AppMethodBeat.o(336318);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336350);
    Log.i(TAG, "id:" + this.ACb.field_id + ", errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      switch (paramInt3)
      {
      default: 
        params = com.tencent.mm.plugin.finder.storage.logic.g.FNK;
        com.tencent.mm.plugin.finder.storage.logic.g.qv(this.ACb.field_id);
        params = new jd();
        params.hKL.id = this.ACb.field_id;
        params.publish();
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(336350);
      return;
      this.ACb.field_followExpireTime = 0L;
      params = f.FNJ;
      boolean bool = f.a.a(this.ACb, this.scene);
      Log.i(TAG, "failed expire, id:" + this.ACb.field_id + ", modify extFlag:" + this.ACb.field_extFlag + ", updateDb ret:" + bool);
      break;
      this.ACb.field_extFlag |= 0x8;
      params = f.FNJ;
      bool = f.a.a(this.ACb, this.scene);
      Log.i(TAG, "failed revoke, id:" + this.ACb.field_id + ", modify extFlag:" + this.ACb.field_extFlag + ", updateDb ret:" + bool);
      break;
      this.ACb.field_extFlag |= 0x4;
      params = f.FNJ;
      bool = f.a.a(this.ACb, this.scene);
      Log.i(TAG, "succ, id:" + this.ACb.field_id + ", modify extFlag:" + this.ACb.field_extFlag + ", updateDb ret:" + bool);
    }
  }
  
  public final b dVi()
  {
    return b.Hde;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336339);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336339);
    return i;
  }
  
  public final int getType()
  {
    return 6618;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cb
 * JD-Core Version:    0.7.0.1
 */