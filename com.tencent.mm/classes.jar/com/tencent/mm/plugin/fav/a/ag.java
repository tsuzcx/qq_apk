package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.yf;
import com.tencent.mm.g.a.yf.a;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.cn;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class ag
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public g qaL;
  private final com.tencent.mm.al.b rr;
  
  public ag(g paramg)
  {
    AppMethodBeat.i(103456);
    this.callback = null;
    ad.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[] { Long.valueOf(paramg.field_localId) });
    b.a locala = new b.a();
    locala.gUU = new cn();
    locala.gUV = new co();
    locala.uri = "/cgi-bin/micromsg-bin/addfavitem";
    locala.funcId = 401;
    locala.reqCmdId = 193;
    locala.respCmdId = 1000000193;
    this.rr = locala.atI();
    this.qaL = paramg;
    AppMethodBeat.o(103456);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(103457);
    cn localcn = (cn)this.rr.gUS.gUX;
    localcn.gKn = s.t(this.qaL.field_xml, System.currentTimeMillis());
    localcn.mBH = this.qaL.field_type;
    localcn.Cxp = this.qaL.field_sourceType;
    this.qaL.field_xml = g.t(this.qaL);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qaL, new String[] { "localId" });
    localcn.Cxr = this.qaL.field_xml;
    localcn.Cxq = this.qaL.field_sourceId;
    this.qaL.Yb("MicroMsg.Fav.NetSceneAddFav");
    this.callback = paramg;
    ad.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[] { this.qaL.field_sourceId, Long.valueOf(this.qaL.field_localId), Integer.valueOf(this.qaL.field_id) });
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103457);
    return i;
  }
  
  public final int getType()
  {
    return 401;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103458);
    ad.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((paramInt2 == 0) && (paramInt3 == 0)) || (paramInt3 == -400))
    {
      paramq = (co)((com.tencent.mm.al.b)paramq).gUT.gUX;
      ad.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[] { Integer.valueOf(paramq.Cxl), Long.valueOf(this.qaL.field_localId), Integer.valueOf(this.qaL.field_itemStatus), Integer.valueOf(paramq.Cxo) });
      this.qaL.field_id = paramq.Cxl;
      this.qaL.field_localSeq = paramq.Cxo;
      if (this.qaL.field_itemStatus == 12)
      {
        ad.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
        this.qaL.field_itemStatus = 13;
      }
      if (this.qaL.field_itemStatus == 9)
      {
        ad.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
        this.qaL.field_itemStatus = 10;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().pP(this.qaL.field_localId);
        com.tencent.mm.plugin.report.service.h.vKh.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(this.qaL.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.qaL)), Long.valueOf(h.pL(this.qaL.field_localId)) });
      }
      paramArrayOfByte = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(paramq.Cxl);
      if (paramArrayOfByte != null)
      {
        this.qaL.field_updateSeq = paramArrayOfByte.field_updateSeq;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(paramArrayOfByte);
        ad.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[] { Integer.valueOf(paramArrayOfByte.field_id) });
      }
      paramArrayOfByte = y.arz().tC(this.qaL.field_sessionId);
      if ((!bt.isNullOrNil(this.qaL.field_sessionId)) && (this.qaL.field_type == 5) && (paramArrayOfByte != null))
      {
        yf localyf = new yf();
        localyf.dEv.dEw = paramArrayOfByte.getString("prePublishId", "");
        if ((this.qaL.field_favProto != null) && (this.qaL.field_favProto.DiD != null)) {
          localyf.dEv.url = this.qaL.field_favProto.DiD.link;
        }
        if ((bt.isNullOrNil(localyf.dEv.url)) && (this.qaL.field_favProto != null) && (this.qaL.field_favProto.DhE != null) && (this.qaL.field_favProto.DhE.Djf != null)) {
          localyf.dEv.url = this.qaL.field_favProto.DhE.Djf;
        }
        if (bt.isNullOrNil(localyf.dEv.url)) {
          localyf.dEv.url = paramArrayOfByte.getString("url", "");
        }
        localyf.dEv.dEy = paramArrayOfByte.getString("preUsername", "");
        localyf.dEv.dEz = paramArrayOfByte.getString("preChatName", "");
        localyf.dEv.dEA = paramArrayOfByte.getInt("preMsgIndex", 0);
        localyf.dEv.dEE = paramArrayOfByte.getInt("sendAppMsgScene", 0);
        localyf.dEv.dEF = paramArrayOfByte.getInt("getA8KeyScene", 0);
        localyf.dEv.dEG = paramArrayOfByte.getString("referUrl", null);
        localyf.dEv.dEH = paramArrayOfByte.getString("adExtStr", null);
        localyf.dEv.dEB = "";
        localyf.dEv.dEC = "";
        localyf.dEv.dED = 0;
        localyf.dEv.dEx = ("fav_" + u.aqG() + "_" + this.qaL.field_id);
        a.ESL.l(localyf);
      }
      this.qaL.field_sessionId = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qaL, new String[] { "localId" });
      b.pB(paramq.Cxs);
    }
    if ((paramInt2 == 4) && (paramInt3 == -401))
    {
      ad.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
      if (!this.qaL.chJ()) {
        break label965;
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(16, this.qaL.field_localId);
    }
    for (;;)
    {
      b.d(this.qaL);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103458);
      return;
      label965:
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(6, this.qaL.field_localId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ag
 * JD-Core Version:    0.7.0.1
 */