package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.g.a.zq.a;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.cq;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class ag
  extends n
  implements k
{
  private f callback;
  public g rBF;
  private final com.tencent.mm.ak.b rr;
  
  public ag(g paramg)
  {
    AppMethodBeat.i(103456);
    this.callback = null;
    ae.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[] { Long.valueOf(paramg.field_localId) });
    b.a locala = new b.a();
    locala.hQF = new cq();
    locala.hQG = new cr();
    locala.uri = "/cgi-bin/micromsg-bin/addfavitem";
    locala.funcId = 401;
    locala.hQH = 193;
    locala.respCmdId = 1000000193;
    this.rr = locala.aDS();
    this.rBF = paramg;
    AppMethodBeat.o(103456);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103457);
    cq localcq = (cq)this.rr.hQD.hQJ;
    localcq.hFO = t.w(this.rBF.field_xml, System.currentTimeMillis());
    localcq.nJA = this.rBF.field_type;
    localcq.FNy = this.rBF.field_sourceType;
    this.rBF.field_xml = g.t(this.rBF);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rBF, new String[] { "localId" });
    localcq.FNA = this.rBF.field_xml;
    localcq.FNz = this.rBF.field_sourceId;
    this.rBF.ahj("MicroMsg.Fav.NetSceneAddFav");
    this.callback = paramf;
    ae.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[] { this.rBF.field_sourceId, Long.valueOf(this.rBF.field_localId), Integer.valueOf(this.rBF.field_id) });
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
    ae.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((paramInt2 == 0) && (paramInt3 == 0)) || (paramInt3 == -400))
    {
      paramq = (cr)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      ae.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[] { Integer.valueOf(paramq.FNu), Long.valueOf(this.rBF.field_localId), Integer.valueOf(this.rBF.field_itemStatus), Integer.valueOf(paramq.FNx) });
      this.rBF.field_id = paramq.FNu;
      this.rBF.field_localSeq = paramq.FNx;
      if (this.rBF.field_itemStatus == 12)
      {
        ae.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
        this.rBF.field_itemStatus = 13;
      }
      if (this.rBF.field_itemStatus == 9)
      {
        ae.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
        this.rBF.field_itemStatus = 10;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vR(this.rBF.field_localId);
        com.tencent.mm.plugin.report.service.g.yxI.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(this.rBF.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.rBF)), Long.valueOf(h.vN(this.rBF.field_localId)) });
      }
      paramArrayOfByte = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vV(paramq.FNu);
      if (paramArrayOfByte != null)
      {
        this.rBF.field_updateSeq = paramArrayOfByte.field_updateSeq;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(paramArrayOfByte);
        ae.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[] { Integer.valueOf(paramArrayOfByte.field_id) });
      }
      paramArrayOfByte = z.aBG().Bq(this.rBF.field_sessionId);
      if ((!bu.isNullOrNil(this.rBF.field_sessionId)) && (this.rBF.field_type == 5) && (paramArrayOfByte != null))
      {
        zq localzq = new zq();
        localzq.dPK.dPL = paramArrayOfByte.getString("prePublishId", "");
        if ((this.rBF.field_favProto != null) && (this.rBF.field_favProto.GCe != null)) {
          localzq.dPK.url = this.rBF.field_favProto.GCe.link;
        }
        if ((bu.isNullOrNil(localzq.dPK.url)) && (this.rBF.field_favProto != null) && (this.rBF.field_favProto.GBf != null) && (this.rBF.field_favProto.GBf.GCG != null)) {
          localzq.dPK.url = this.rBF.field_favProto.GBf.GCG;
        }
        if (bu.isNullOrNil(localzq.dPK.url)) {
          localzq.dPK.url = paramArrayOfByte.getString("url", "");
        }
        localzq.dPK.dPN = paramArrayOfByte.getString("preUsername", "");
        localzq.dPK.dPO = paramArrayOfByte.getString("preChatName", "");
        localzq.dPK.dPP = paramArrayOfByte.getInt("preMsgIndex", 0);
        localzq.dPK.dPT = paramArrayOfByte.getInt("sendAppMsgScene", 0);
        localzq.dPK.dPU = paramArrayOfByte.getInt("getA8KeyScene", 0);
        localzq.dPK.dPV = paramArrayOfByte.getString("referUrl", null);
        localzq.dPK.dPW = paramArrayOfByte.getString("adExtStr", null);
        localzq.dPK.dPQ = "";
        localzq.dPK.dPR = "";
        localzq.dPK.dPS = 0;
        localzq.dPK.dPM = ("fav_" + v.aAC() + "_" + this.rBF.field_id);
        a.IvT.l(localzq);
      }
      this.rBF.field_sessionId = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rBF, new String[] { "localId" });
      b.vD(paramq.FNB);
    }
    if ((paramInt2 == 4) && (paramInt3 == -401))
    {
      ae.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
      if (!this.rBF.cww()) {
        break label965;
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(16, this.rBF.field_localId);
    }
    for (;;)
    {
      b.d(this.rBF);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103458);
      return;
      label965:
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(6, this.rBF.field_localId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ag
 * JD-Core Version:    0.7.0.1
 */