package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.aax;
import com.tencent.mm.g.a.aax.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.da;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  private final d rr;
  public g tbk;
  
  public ag(g paramg)
  {
    AppMethodBeat.i(103456);
    this.callback = null;
    Log.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[] { Long.valueOf(paramg.field_localId) });
    d.a locala = new d.a();
    locala.iLN = new cz();
    locala.iLO = new da();
    locala.uri = "/cgi-bin/micromsg-bin/addfavitem";
    locala.funcId = 401;
    locala.iLP = 193;
    locala.respCmdId = 1000000193;
    this.rr = locala.aXF();
    this.tbk = paramg;
    AppMethodBeat.o(103456);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(103457);
    cz localcz = (cz)this.rr.iLK.iLR;
    localcz.izX = com.tencent.mm.model.x.x(this.tbk.field_xml, System.currentTimeMillis());
    localcz.oUv = this.tbk.field_type;
    localcz.KHd = this.tbk.field_sourceType;
    this.tbk.field_xml = g.t(this.tbk);
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbk, new String[] { "localId" });
    localcz.KHf = this.tbk.field_xml;
    localcz.KHe = this.tbk.field_sourceId;
    this.tbk.arR("MicroMsg.Fav.NetSceneAddFav");
    this.callback = parami;
    Log.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[] { this.tbk.field_sourceId, Long.valueOf(this.tbk.field_localId), Integer.valueOf(this.tbk.field_id) });
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
      params = (da)((d)params).iLL.iLR;
      Log.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[] { Integer.valueOf(params.KGZ), Long.valueOf(this.tbk.field_localId), Integer.valueOf(this.tbk.field_itemStatus), Integer.valueOf(params.KHc) });
      this.tbk.field_id = params.KGZ;
      this.tbk.field_localSeq = params.KHc;
      if (this.tbk.field_itemStatus == 12)
      {
        Log.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
        this.tbk.field_itemStatus = 13;
      }
      if (this.tbk.field_itemStatus == 9)
      {
        Log.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
        this.tbk.field_itemStatus = 10;
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DV(this.tbk.field_localId);
        com.tencent.mm.plugin.report.service.h.CyF.a(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(this.tbk.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.tbk)), Long.valueOf(h.DR(this.tbk.field_localId)) });
      }
      paramArrayOfByte = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(params.KGZ);
      if (paramArrayOfByte != null)
      {
        this.tbk.field_updateSeq = paramArrayOfByte.field_updateSeq;
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().A(paramArrayOfByte);
        Log.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[] { Integer.valueOf(paramArrayOfByte.field_id) });
      }
      paramArrayOfByte = ad.aVe().JW(this.tbk.field_sessionId);
      if ((!Util.isNullOrNil(this.tbk.field_sessionId)) && (this.tbk.field_type == 5) && (paramArrayOfByte != null))
      {
        aax localaax = new aax();
        localaax.ehN.ehO = paramArrayOfByte.getString("prePublishId", "");
        if ((this.tbk.field_favProto != null) && (this.tbk.field_favProto.Lya != null)) {
          localaax.ehN.url = this.tbk.field_favProto.Lya.link;
        }
        if ((Util.isNullOrNil(localaax.ehN.url)) && (this.tbk.field_favProto != null) && (this.tbk.field_favProto.LwS != null) && (this.tbk.field_favProto.LwS.LyC != null)) {
          localaax.ehN.url = this.tbk.field_favProto.LwS.LyC;
        }
        if (Util.isNullOrNil(localaax.ehN.url)) {
          localaax.ehN.url = paramArrayOfByte.getString("url", "");
        }
        localaax.ehN.ehQ = paramArrayOfByte.getString("preUsername", "");
        localaax.ehN.ehR = paramArrayOfByte.getString("preChatName", "");
        localaax.ehN.ehS = paramArrayOfByte.getInt("preMsgIndex", 0);
        localaax.ehN.ehW = paramArrayOfByte.getInt("sendAppMsgScene", 0);
        localaax.ehN.ehX = paramArrayOfByte.getInt("getA8KeyScene", 0);
        localaax.ehN.ehY = paramArrayOfByte.getString("referUrl", null);
        localaax.ehN.ehZ = paramArrayOfByte.getString("adExtStr", null);
        localaax.ehN.ehT = "";
        localaax.ehN.ehU = "";
        localaax.ehN.ehV = 0;
        localaax.ehN.ehP = ("fav_" + z.aTY() + "_" + this.tbk.field_id);
        EventCenter.instance.publish(localaax);
      }
      this.tbk.field_sessionId = null;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbk, new String[] { "localId" });
      b.DH(params.KHg);
    }
    if ((paramInt2 == 4) && (paramInt3 == -401))
    {
      Log.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
      if (!this.tbk.cUA()) {
        break label965;
      }
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(16, this.tbk.field_localId);
    }
    for (;;)
    {
      b.d(this.tbk);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103458);
      return;
      label965:
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(6, this.tbk.field_localId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ag
 * JD-Core Version:    0.7.0.1
 */