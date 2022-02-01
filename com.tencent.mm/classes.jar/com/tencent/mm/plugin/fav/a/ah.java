package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.acf;
import com.tencent.mm.f.a.acf.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ah
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public g wHp;
  
  public ah(g paramg)
  {
    AppMethodBeat.i(103456);
    this.callback = null;
    Log.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[] { Long.valueOf(paramg.field_localId) });
    d.a locala = new d.a();
    locala.lBU = new cw();
    locala.lBV = new cx();
    locala.uri = "/cgi-bin/micromsg-bin/addfavitem";
    locala.funcId = 401;
    locala.lBW = 193;
    locala.respCmdId = 1000000193;
    this.rr = locala.bgN();
    this.wHp = paramg;
    AppMethodBeat.o(103456);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(103457);
    cw localcw = (cw)d.b.b(this.rr.lBR);
    localcw.lps = x.u(this.wHp.field_xml, System.currentTimeMillis());
    localcw.rWu = this.wHp.field_type;
    localcw.RIv = this.wHp.field_sourceType;
    this.wHp.field_xml = g.t(this.wHp);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(this.wHp, new String[] { "localId" });
    localcw.RIx = this.wHp.field_xml;
    localcw.RIw = this.wHp.field_sourceId;
    this.wHp.azS("MicroMsg.Fav.NetSceneAddFav");
    this.callback = parami;
    Log.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[] { this.wHp.field_sourceId, Long.valueOf(this.wHp.field_localId), Integer.valueOf(this.wHp.field_id) });
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103457);
    return i;
  }
  
  public final int getType()
  {
    return 401;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103458);
    Log.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((paramInt2 == 0) && (paramInt3 == 0)) || (paramInt3 == -400))
    {
      params = (cx)d.c.b(((d)params).lBS);
      Log.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[] { Integer.valueOf(params.RIr), Long.valueOf(this.wHp.field_localId), Integer.valueOf(this.wHp.field_itemStatus), Integer.valueOf(params.RIu) });
      this.wHp.field_id = params.RIr;
      this.wHp.field_localSeq = params.RIu;
      if (this.wHp.field_itemStatus == 12)
      {
        Log.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
        this.wHp.field_itemStatus = 13;
      }
      if (this.wHp.field_itemStatus == 9)
      {
        Log.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
        this.wHp.field_itemStatus = 10;
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().Kj(this.wHp.field_localId);
        com.tencent.mm.plugin.report.service.h.IzE.a(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(this.wHp.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.wHp)), Long.valueOf(h.Kf(this.wHp.field_localId)) });
      }
      paramArrayOfByte = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Kn(params.RIr);
      if (paramArrayOfByte != null)
      {
        this.wHp.field_updateSeq = paramArrayOfByte.field_updateSeq;
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().A(paramArrayOfByte);
        Log.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[] { Integer.valueOf(paramArrayOfByte.field_id) });
      }
      paramArrayOfByte = ad.beh().Ro(this.wHp.field_sessionId);
      if ((!Util.isNullOrNil(this.wHp.field_sessionId)) && (this.wHp.field_type == 5) && (paramArrayOfByte != null))
      {
        acf localacf = new acf();
        localacf.gce.gcf = paramArrayOfByte.getString("prePublishId", "");
        if ((this.wHp.field_favProto != null) && (this.wHp.field_favProto.SAB != null)) {
          localacf.gce.url = this.wHp.field_favProto.SAB.link;
        }
        if ((Util.isNullOrNil(localacf.gce.url)) && (this.wHp.field_favProto != null) && (this.wHp.field_favProto.Szr != null) && (this.wHp.field_favProto.Szr.SBc != null)) {
          localacf.gce.url = this.wHp.field_favProto.Szr.SBc;
        }
        if (Util.isNullOrNil(localacf.gce.url)) {
          localacf.gce.url = paramArrayOfByte.getString("url", "");
        }
        localacf.gce.gch = paramArrayOfByte.getString("preUsername", "");
        localacf.gce.gci = paramArrayOfByte.getString("preChatName", "");
        localacf.gce.gcj = paramArrayOfByte.getInt("preMsgIndex", 0);
        localacf.gce.gcn = paramArrayOfByte.getInt("sendAppMsgScene", 0);
        localacf.gce.gco = paramArrayOfByte.getInt("getA8KeyScene", 0);
        localacf.gce.gcp = paramArrayOfByte.getString("referUrl", null);
        localacf.gce.gcq = paramArrayOfByte.getString("adExtStr", null);
        localacf.gce.gck = "";
        localacf.gce.gcl = "";
        localacf.gce.gcm = 0;
        localacf.gce.gcg = ("fav_" + z.bcZ() + "_" + this.wHp.field_id);
        EventCenter.instance.publish(localacf);
      }
      this.wHp.field_sessionId = null;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(this.wHp, new String[] { "localId" });
      b.JV(params.RIy);
    }
    if ((paramInt2 == 4) && (paramInt3 == -401))
    {
      Log.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
      if (!this.wHp.djG()) {
        break label965;
      }
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(16, this.wHp.field_localId);
    }
    for (;;)
    {
      b.d(this.wHp);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103458);
      return;
      label965:
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().ag(6, this.wHp.field_localId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ah
 * JD-Core Version:    0.7.0.1
 */