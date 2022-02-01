package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.g.a.zk.a;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.cq;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class ag
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  public g rts;
  
  public ag(g paramg)
  {
    AppMethodBeat.i(103456);
    this.callback = null;
    ad.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[] { Long.valueOf(paramg.field_localId) });
    b.a locala = new b.a();
    locala.hNM = new cq();
    locala.hNN = new cr();
    locala.uri = "/cgi-bin/micromsg-bin/addfavitem";
    locala.funcId = 401;
    locala.hNO = 193;
    locala.respCmdId = 1000000193;
    this.rr = locala.aDC();
    this.rts = paramg;
    AppMethodBeat.o(103456);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103457);
    cq localcq = (cq)this.rr.hNK.hNQ;
    localcq.hCW = s.w(this.rts.field_xml, System.currentTimeMillis());
    localcq.nEf = this.rts.field_type;
    localcq.Fva = this.rts.field_sourceType;
    this.rts.field_xml = g.t(this.rts);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rts, new String[] { "localId" });
    localcq.Fvc = this.rts.field_xml;
    localcq.Fvb = this.rts.field_sourceId;
    this.rts.agm("MicroMsg.Fav.NetSceneAddFav");
    this.callback = paramf;
    ad.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[] { this.rts.field_sourceId, Long.valueOf(this.rts.field_localId), Integer.valueOf(this.rts.field_id) });
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
      paramq = (cr)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      ad.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[] { Integer.valueOf(paramq.FuW), Long.valueOf(this.rts.field_localId), Integer.valueOf(this.rts.field_itemStatus), Integer.valueOf(paramq.FuZ) });
      this.rts.field_id = paramq.FuW;
      this.rts.field_localSeq = paramq.FuZ;
      if (this.rts.field_itemStatus == 12)
      {
        ad.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
        this.rts.field_itemStatus = 13;
      }
      if (this.rts.field_itemStatus == 9)
      {
        ad.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
        this.rts.field_itemStatus = 10;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vB(this.rts.field_localId);
        com.tencent.mm.plugin.report.service.g.yhR.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(this.rts.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.rts)), Long.valueOf(h.vx(this.rts.field_localId)) });
      }
      paramArrayOfByte = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vF(paramq.FuW);
      if (paramArrayOfByte != null)
      {
        this.rts.field_updateSeq = paramArrayOfByte.field_updateSeq;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(paramArrayOfByte);
        ad.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[] { Integer.valueOf(paramArrayOfByte.field_id) });
      }
      paramArrayOfByte = y.aBq().AG(this.rts.field_sessionId);
      if ((!bt.isNullOrNil(this.rts.field_sessionId)) && (this.rts.field_type == 5) && (paramArrayOfByte != null))
      {
        zk localzk = new zk();
        localzk.dOu.dOv = paramArrayOfByte.getString("prePublishId", "");
        if ((this.rts.field_favProto != null) && (this.rts.field_favProto.Gjv != null)) {
          localzk.dOu.url = this.rts.field_favProto.Gjv.link;
        }
        if ((bt.isNullOrNil(localzk.dOu.url)) && (this.rts.field_favProto != null) && (this.rts.field_favProto.Giw != null) && (this.rts.field_favProto.Giw.GjX != null)) {
          localzk.dOu.url = this.rts.field_favProto.Giw.GjX;
        }
        if (bt.isNullOrNil(localzk.dOu.url)) {
          localzk.dOu.url = paramArrayOfByte.getString("url", "");
        }
        localzk.dOu.dOx = paramArrayOfByte.getString("preUsername", "");
        localzk.dOu.dOy = paramArrayOfByte.getString("preChatName", "");
        localzk.dOu.dOz = paramArrayOfByte.getInt("preMsgIndex", 0);
        localzk.dOu.dOD = paramArrayOfByte.getInt("sendAppMsgScene", 0);
        localzk.dOu.dOE = paramArrayOfByte.getInt("getA8KeyScene", 0);
        localzk.dOu.dOF = paramArrayOfByte.getString("referUrl", null);
        localzk.dOu.dOG = paramArrayOfByte.getString("adExtStr", null);
        localzk.dOu.dOA = "";
        localzk.dOu.dOB = "";
        localzk.dOu.dOC = 0;
        localzk.dOu.dOw = ("fav_" + u.aAm() + "_" + this.rts.field_id);
        a.IbL.l(localzk);
      }
      this.rts.field_sessionId = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rts, new String[] { "localId" });
      b.vn(paramq.Fvd);
    }
    if ((paramInt2 == 4) && (paramInt3 == -401))
    {
      ad.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
      if (!this.rts.cuV()) {
        break label965;
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(16, this.rts.field_localId);
    }
    for (;;)
    {
      b.d(this.rts);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103458);
      return;
      label965:
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(6, this.rts.field_localId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ag
 * JD-Core Version:    0.7.0.1
 */