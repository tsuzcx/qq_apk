package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.um;
import com.tencent.mm.h.a.um.a;
import com.tencent.mm.model.o;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bz;
import com.tencent.mm.protocal.c.ca;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class af
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL = null;
  public g jZG;
  
  public af(g paramg)
  {
    y.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[] { Long.valueOf(paramg.field_localId) });
    b.a locala = new b.a();
    locala.ecH = new bz();
    locala.ecI = new ca();
    locala.uri = "/cgi-bin/micromsg-bin/addfavitem";
    locala.ecG = 401;
    locala.ecJ = 193;
    locala.ecK = 1000000193;
    this.dmK = locala.Kt();
    this.jZG = paramg;
  }
  
  public final int a(e parame, f paramf)
  {
    bz localbz = (bz)this.dmK.ecE.ecN;
    localbz.nde = o.l(this.jZG.field_xml, System.currentTimeMillis());
    localbz.hQR = this.jZG.field_type;
    localbz.svA = this.jZG.field_sourceType;
    this.jZG.field_xml = g.s(this.jZG);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(this.jZG, new String[] { "localId" });
    localbz.svC = this.jZG.field_xml;
    localbz.svB = this.jZG.field_sourceId;
    this.jZG.CE("MicroMsg.Fav.NetSceneAddFav");
    this.dmL = paramf;
    y.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[] { this.jZG.field_sourceId, Long.valueOf(this.jZG.field_localId), Integer.valueOf(this.jZG.field_id) });
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((paramInt2 == 0) && (paramInt3 == 0)) || (paramInt3 == -400))
    {
      paramq = (ca)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      y.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[] { Integer.valueOf(paramq.svw), Long.valueOf(this.jZG.field_localId), Integer.valueOf(this.jZG.field_itemStatus), Integer.valueOf(paramq.svz) });
      this.jZG.field_id = paramq.svw;
      this.jZG.field_localSeq = paramq.svz;
      if (this.jZG.field_itemStatus == 12)
      {
        y.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
        this.jZG.field_itemStatus = 13;
      }
      if (this.jZG.field_itemStatus == 9)
      {
        y.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
        this.jZG.field_itemStatus = 10;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().eB(this.jZG.field_localId);
        com.tencent.mm.plugin.report.service.h.nFQ.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(this.jZG.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.jZG)), Long.valueOf(h.ex(this.jZG.field_localId)) });
      }
      paramArrayOfByte = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(paramq.svw);
      if (paramArrayOfByte != null)
      {
        this.jZG.field_updateSeq = paramArrayOfByte.field_updateSeq;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().z(paramArrayOfByte);
        y.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[] { Integer.valueOf(paramArrayOfByte.field_id) });
      }
      paramArrayOfByte = u.Hc().ii(this.jZG.field_sessionId);
      if ((!bk.bl(this.jZG.field_sessionId)) && (this.jZG.field_type == 5) && (paramArrayOfByte != null))
      {
        um localum = new um();
        localum.ceR.ceS = paramArrayOfByte.getString("prePublishId", "");
        if ((this.jZG.field_favProto != null) && (this.jZG.field_favProto.sXa != null)) {
          localum.ceR.url = this.jZG.field_favProto.sXa.eAl;
        }
        if ((bk.bl(localum.ceR.url)) && (this.jZG.field_favProto != null) && (this.jZG.field_favProto.sWh != null) && (this.jZG.field_favProto.sWh.sXG != null)) {
          localum.ceR.url = this.jZG.field_favProto.sWh.sXG;
        }
        if (bk.bl(localum.ceR.url)) {
          localum.ceR.url = paramArrayOfByte.getString("url", "");
        }
        localum.ceR.ceU = paramArrayOfByte.getString("preUsername", "");
        localum.ceR.ceV = paramArrayOfByte.getString("preChatName", "");
        localum.ceR.ceW = paramArrayOfByte.getInt("preMsgIndex", 0);
        localum.ceR.cfa = paramArrayOfByte.getInt("sendAppMsgScene", 0);
        localum.ceR.cfb = paramArrayOfByte.getInt("getA8KeyScene", 0);
        localum.ceR.cfc = paramArrayOfByte.getString("referUrl", null);
        localum.ceR.cfd = paramArrayOfByte.getString("adExtStr", null);
        localum.ceR.ceX = "";
        localum.ceR.ceY = "";
        localum.ceR.ceZ = 0;
        localum.ceR.ceT = ("fav_" + com.tencent.mm.model.q.Gj() + "_" + this.jZG.field_id);
        a.udP.m(localum);
      }
      this.jZG.field_sessionId = null;
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(this.jZG, new String[] { "localId" });
      b.en(paramq.svD);
    }
    if ((paramInt2 == 4) && (paramInt3 == -401))
    {
      y.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
      if (!this.jZG.aQc()) {
        break label955;
      }
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(16, this.jZG.field_localId);
    }
    for (;;)
    {
      b.d(this.jZG);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label955:
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(6, this.jZG.field_localId);
    }
  }
  
  public final int getType()
  {
    return 401;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.af
 * JD-Core Version:    0.7.0.1
 */