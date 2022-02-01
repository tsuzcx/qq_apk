package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "scene", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class af
  extends ac
{
  private static final String TAG = "Finder.NetSceneFinderFollowVerify";
  public static final a rJj;
  private f callback;
  private final int opType;
  private final com.tencent.mm.plugin.finder.storage.ac rJi;
  private com.tencent.mm.al.b rr;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(201111);
    rJj = new a((byte)0);
    TAG = "Finder.NetSceneFinderFollowVerify";
    AppMethodBeat.o(201111);
  }
  
  public af(com.tencent.mm.plugin.finder.storage.ac paramac, aqy paramaqy, int paramInt)
  {
    super(paramaqy);
    AppMethodBeat.i(201110);
    this.rJi = paramac;
    this.opType = 1;
    this.scene = paramInt;
    b.a locala = new b.a();
    locala.oP(getType());
    paramac = new anb();
    paramac.Gmn = this.rJi.field_followId;
    paramac.dFJ = this.opType;
    v localv = v.rIR;
    paramac.Gle = v.a(paramaqy);
    locala.c((com.tencent.mm.bx.a)paramac);
    paramaqy = new ana();
    paramaqy.setBaseResponse(new BaseResponse());
    locala.d((com.tencent.mm.bx.a)paramaqy);
    locala.Dl("/cgi-bin/micromsg-bin/finderfollowverify");
    paramaqy = locala.aDC();
    p.g(paramaqy, "builder.buildInstance()");
    this.rr = paramaqy;
    ad.i(TAG, "init id:" + this.rJi.field_id + ", " + paramac.Gmn + " opType " + this.opType);
    AppMethodBeat.o(201110);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(201108);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201108);
    return i;
  }
  
  public final int getType()
  {
    return 6618;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201109);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(TAG, "id:" + this.rJi.field_id + ", errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    boolean bool;
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if (paramInt3 == -4042)
      {
        this.rJi.field_followExpireTime = 0L;
        paramq = d.sAw;
        bool = d.a.a(this.rJi, this.scene);
        ad.i(TAG, "failed expire, id:" + this.rJi.field_id + ", modify extFlag:" + this.rJi.field_extFlag + ", updateDb ret:" + bool);
        paramq = com.tencent.mm.plugin.finder.storage.logic.e.sAy;
        com.tencent.mm.plugin.finder.storage.logic.e.xi(this.rJi.field_id);
        paramq = new hm();
        paramq.dtX.id = this.rJi.field_id;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)paramq);
      }
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        break label441;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201109);
      return;
      if (paramInt3 != -4043) {
        break;
      }
      this.rJi.field_extFlag |= 0x8;
      paramq = d.sAw;
      bool = d.a.a(this.rJi, this.scene);
      ad.i(TAG, "failed revoke, id:" + this.rJi.field_id + ", modify extFlag:" + this.rJi.field_extFlag + ", updateDb ret:" + bool);
      break;
      this.rJi.field_extFlag |= 0x4;
      paramq = d.sAw;
      bool = d.a.a(this.rJi, this.scene);
      ad.i(TAG, "succ, id:" + this.rJi.field_id + ", modify extFlag:" + this.rJi.field_extFlag + ", updateDb ret:" + bool);
    }
    label441:
    AppMethodBeat.o(201109);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.af
 * JD-Core Version:    0.7.0.1
 */