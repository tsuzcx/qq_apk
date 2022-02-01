package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.aec;
import com.tencent.mm.autogen.a.aec.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ai
  extends p
  implements m
{
  public g Ady;
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public ai(g paramg)
  {
    AppMethodBeat.i(103456);
    this.callback = null;
    Log.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[] { Long.valueOf(paramg.field_localId) });
    c.a locala = new c.a();
    locala.otE = new dg();
    locala.otF = new dh();
    locala.uri = "/cgi-bin/micromsg-bin/addfavitem";
    locala.funcId = 401;
    locala.otG = 193;
    locala.respCmdId = 1000000193;
    this.rr = locala.bEF();
    this.Ady = paramg;
    AppMethodBeat.o(103456);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(103457);
    dg localdg = (dg)c.b.b(this.rr.otB);
    localdg.nUv = x.z(this.Ady.field_xml, System.currentTimeMillis());
    localdg.vhJ = this.Ady.field_type;
    localdg.YFx = this.Ady.field_sourceType;
    this.Ady.field_xml = g.t(this.Ady);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(this.Ady, new String[] { "localId" });
    localdg.YFz = this.Ady.field_xml;
    localdg.YFy = this.Ady.field_sourceId;
    this.Ady.atY("MicroMsg.Fav.NetSceneAddFav");
    this.callback = paramh;
    Log.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[] { this.Ady.field_sourceId, Long.valueOf(this.Ady.field_localId), Integer.valueOf(this.Ady.field_id) });
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
      params = (dh)c.c.b(((c)params).otC);
      Log.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[] { Integer.valueOf(params.YFt), Long.valueOf(this.Ady.field_localId), Integer.valueOf(this.Ady.field_itemStatus), Integer.valueOf(params.YFw) });
      this.Ady.field_id = params.YFt;
      this.Ady.field_localSeq = params.YFw;
      if (this.Ady.field_itemStatus == 12)
      {
        Log.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
        this.Ady.field_itemStatus = 13;
      }
      if (this.Ady.field_itemStatus == 9)
      {
        Log.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
        this.Ady.field_itemStatus = 10;
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().mH(this.Ady.field_localId);
        com.tencent.mm.plugin.report.service.h.OAn.b(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(this.Ady.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.Ady)), Long.valueOf(h.mD(this.Ady.field_localId)) });
      }
      paramArrayOfByte = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mL(params.YFt);
      if (paramArrayOfByte != null)
      {
        this.Ady.field_updateSeq = paramArrayOfByte.field_updateSeq;
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().A(paramArrayOfByte);
        Log.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[] { Integer.valueOf(paramArrayOfByte.field_id) });
      }
      paramArrayOfByte = ad.bCb().Jn(this.Ady.field_sessionId);
      if ((!Util.isNullOrNil(this.Ady.field_sessionId)) && (this.Ady.field_type == 5) && (paramArrayOfByte != null))
      {
        aec localaec = new aec();
        localaec.iiq.iir = paramArrayOfByte.getString("prePublishId", "");
        if ((this.Ady.field_favProto != null) && (this.Ady.field_favProto.ZBt != null)) {
          localaec.iiq.url = this.Ady.field_favProto.ZBt.link;
        }
        if ((Util.isNullOrNil(localaec.iiq.url)) && (this.Ady.field_favProto != null) && (this.Ady.field_favProto.ZAj != null) && (this.Ady.field_favProto.ZAj.ZBV != null)) {
          localaec.iiq.url = this.Ady.field_favProto.ZAj.ZBV;
        }
        if (Util.isNullOrNil(localaec.iiq.url)) {
          localaec.iiq.url = paramArrayOfByte.getString("url", "");
        }
        localaec.iiq.iit = paramArrayOfByte.getString("preUsername", "");
        localaec.iiq.iiu = paramArrayOfByte.getString("preChatName", "");
        localaec.iiq.iiv = paramArrayOfByte.getInt("preMsgIndex", 0);
        localaec.iiq.iiz = paramArrayOfByte.getInt("sendAppMsgScene", 0);
        localaec.iiq.iiA = paramArrayOfByte.getInt("getA8KeyScene", 0);
        localaec.iiq.iiB = paramArrayOfByte.getString("referUrl", null);
        localaec.iiq.iiC = paramArrayOfByte.getString("adExtStr", null);
        localaec.iiq.iiw = "";
        localaec.iiq.iix = "";
        localaec.iiq.iiy = 0;
        localaec.iiq.iis = ("fav_" + z.bAM() + "_" + this.Ady.field_id);
        localaec.publish();
      }
      this.Ady.field_sessionId = null;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(this.Ady, new String[] { "localId" });
      b.mt(params.YFA);
    }
    if ((paramInt2 == 4) && (paramInt3 == -401))
    {
      Log.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
      if (!this.Ady.dQr()) {
        break label962;
      }
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(16, this.Ady.field_localId);
    }
    for (;;)
    {
      b.d(this.Ady);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103458);
      return;
      label962:
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(6, this.Ady.field_localId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ai
 * JD-Core Version:    0.7.0.1
 */