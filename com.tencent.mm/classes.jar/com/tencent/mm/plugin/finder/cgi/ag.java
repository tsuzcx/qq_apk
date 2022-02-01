package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "scene", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ag
  extends ad
{
  private static final String TAG = "Finder.NetSceneFinderFollowVerify";
  public static final a rRx;
  private f callback;
  private final int opType;
  private final ac rRw;
  private com.tencent.mm.ak.b rr;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(201533);
    rRx = new a((byte)0);
    TAG = "Finder.NetSceneFinderFollowVerify";
    AppMethodBeat.o(201533);
  }
  
  public ag(ac paramac, arn paramarn, int paramInt)
  {
    super(paramarn);
    AppMethodBeat.i(201532);
    this.rRw = paramac;
    this.opType = 1;
    this.scene = paramInt;
    b.a locala = new b.a();
    locala.oS(getType());
    paramac = new ano();
    paramac.GFv = this.rRw.field_followId;
    paramac.dGO = this.opType;
    v localv = v.rRb;
    paramac.GEg = v.a(paramarn);
    locala.c((com.tencent.mm.bw.a)paramac);
    paramarn = new ann();
    paramarn.setBaseResponse(new BaseResponse());
    locala.d((com.tencent.mm.bw.a)paramarn);
    locala.DN("/cgi-bin/micromsg-bin/finderfollowverify");
    paramarn = locala.aDS();
    p.g(paramarn, "builder.buildInstance()");
    this.rr = paramarn;
    ae.i(TAG, "init id:" + this.rRw.field_id + ", " + paramac.GFv + " opType " + this.opType);
    AppMethodBeat.o(201532);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(201530);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201530);
    return i;
  }
  
  public final int getType()
  {
    return 6618;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201531);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ae.i(TAG, "id:" + this.rRw.field_id + ", errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    boolean bool;
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if (paramInt3 == -4042)
      {
        this.rRw.field_followExpireTime = 0L;
        paramq = d.sLu;
        bool = d.a.a(this.rRw, this.scene);
        ae.i(TAG, "failed expire, id:" + this.rRw.field_id + ", modify extFlag:" + this.rRw.field_extFlag + ", updateDb ret:" + bool);
        paramq = com.tencent.mm.plugin.finder.storage.logic.e.sLw;
        com.tencent.mm.plugin.finder.storage.logic.e.xz(this.rRw.field_id);
        paramq = new hn();
        paramq.dvc.id = this.rRw.field_id;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)paramq);
      }
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        break label441;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201531);
      return;
      if (paramInt3 != -4043) {
        break;
      }
      this.rRw.field_extFlag |= 0x8;
      paramq = d.sLu;
      bool = d.a.a(this.rRw, this.scene);
      ae.i(TAG, "failed revoke, id:" + this.rRw.field_id + ", modify extFlag:" + this.rRw.field_extFlag + ", updateDb ret:" + bool);
      break;
      this.rRw.field_extFlag |= 0x4;
      paramq = d.sLu;
      bool = d.a.a(this.rRw, this.scene);
      ae.i(TAG, "succ, id:" + this.rRw.field_id + ", modify extFlag:" + this.rRw.field_extFlag + ", updateDb ret:" + bool);
    }
    label441:
    AppMethodBeat.o(201531);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ag
 * JD-Core Version:    0.7.0.1
 */