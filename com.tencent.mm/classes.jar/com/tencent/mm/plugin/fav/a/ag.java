package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.g.a.yq.a;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.cq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class ag
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public g qJr;
  private final com.tencent.mm.ak.b rr;
  
  public ag(g paramg)
  {
    AppMethodBeat.i(103456);
    this.callback = null;
    ac.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[] { Long.valueOf(paramg.field_localId) });
    b.a locala = new b.a();
    locala.hvt = new cp();
    locala.hvu = new cq();
    locala.uri = "/cgi-bin/micromsg-bin/addfavitem";
    locala.funcId = 401;
    locala.reqCmdId = 193;
    locala.respCmdId = 1000000193;
    this.rr = locala.aAz();
    this.qJr = paramg;
    AppMethodBeat.o(103456);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(103457);
    cp localcp = (cp)this.rr.hvr.hvw;
    localcp.hkN = s.u(this.qJr.field_xml, System.currentTimeMillis());
    localcp.ndI = this.qJr.field_type;
    localcp.DPL = this.qJr.field_sourceType;
    this.qJr.field_xml = g.t(this.qJr);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qJr, new String[] { "localId" });
    localcp.DPN = this.qJr.field_xml;
    localcp.DPM = this.qJr.field_sourceId;
    this.qJr.acx("MicroMsg.Fav.NetSceneAddFav");
    this.callback = paramg;
    ac.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[] { this.qJr.field_sourceId, Long.valueOf(this.qJr.field_localId), Integer.valueOf(this.qJr.field_id) });
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
    ac.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((paramInt2 == 0) && (paramInt3 == 0)) || (paramInt3 == -400))
    {
      paramq = (cq)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      ac.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[] { Integer.valueOf(paramq.DPH), Long.valueOf(this.qJr.field_localId), Integer.valueOf(this.qJr.field_itemStatus), Integer.valueOf(paramq.DPK) });
      this.qJr.field_id = paramq.DPH;
      this.qJr.field_localSeq = paramq.DPK;
      if (this.qJr.field_itemStatus == 12)
      {
        ac.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
        this.qJr.field_itemStatus = 13;
      }
      if (this.qJr.field_itemStatus == 9)
      {
        ac.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
        this.qJr.field_itemStatus = 10;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().tE(this.qJr.field_localId);
        com.tencent.mm.plugin.report.service.h.wUl.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(this.qJr.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.qJr)), Long.valueOf(h.tA(this.qJr.field_localId)) });
      }
      paramArrayOfByte = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(paramq.DPH);
      if (paramArrayOfByte != null)
      {
        this.qJr.field_updateSeq = paramArrayOfByte.field_updateSeq;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(paramArrayOfByte);
        ac.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[] { Integer.valueOf(paramArrayOfByte.field_id) });
      }
      paramArrayOfByte = y.ayq().xI(this.qJr.field_sessionId);
      if ((!bs.isNullOrNil(this.qJr.field_sessionId)) && (this.qJr.field_type == 5) && (paramArrayOfByte != null))
      {
        yq localyq = new yq();
        localyq.dCh.dCi = paramArrayOfByte.getString("prePublishId", "");
        if ((this.qJr.field_favProto != null) && (this.qJr.field_favProto.EBJ != null)) {
          localyq.dCh.url = this.qJr.field_favProto.EBJ.link;
        }
        if ((bs.isNullOrNil(localyq.dCh.url)) && (this.qJr.field_favProto != null) && (this.qJr.field_favProto.EAK != null) && (this.qJr.field_favProto.EAK.ECl != null)) {
          localyq.dCh.url = this.qJr.field_favProto.EAK.ECl;
        }
        if (bs.isNullOrNil(localyq.dCh.url)) {
          localyq.dCh.url = paramArrayOfByte.getString("url", "");
        }
        localyq.dCh.dCk = paramArrayOfByte.getString("preUsername", "");
        localyq.dCh.dCl = paramArrayOfByte.getString("preChatName", "");
        localyq.dCh.dCm = paramArrayOfByte.getInt("preMsgIndex", 0);
        localyq.dCh.dCq = paramArrayOfByte.getInt("sendAppMsgScene", 0);
        localyq.dCh.dCr = paramArrayOfByte.getInt("getA8KeyScene", 0);
        localyq.dCh.dCs = paramArrayOfByte.getString("referUrl", null);
        localyq.dCh.dCt = paramArrayOfByte.getString("adExtStr", null);
        localyq.dCh.dCn = "";
        localyq.dCh.dCo = "";
        localyq.dCh.dCp = 0;
        localyq.dCh.dCj = ("fav_" + u.axw() + "_" + this.qJr.field_id);
        a.GpY.l(localyq);
      }
      this.qJr.field_sessionId = null;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qJr, new String[] { "localId" });
      b.tq(paramq.DPO);
    }
    if ((paramInt2 == 4) && (paramInt3 == -401))
    {
      ac.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
      if (!this.qJr.cpq()) {
        break label965;
      }
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(16, this.qJr.field_localId);
    }
    for (;;)
    {
      b.d(this.qJr);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103458);
      return;
      label965:
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(6, this.qJr.field_localId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ag
 * JD-Core Version:    0.7.0.1
 */