package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.g.a.wg.a;
import com.tencent.mm.model.p;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class af
  extends m
  implements k
{
  private f callback;
  public g mud;
  private final com.tencent.mm.ai.b rr;
  
  public af(g paramg)
  {
    AppMethodBeat.i(102716);
    this.callback = null;
    ab.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[] { Long.valueOf(paramg.field_localId) });
    b.a locala = new b.a();
    locala.fsX = new ch();
    locala.fsY = new ci();
    locala.uri = "/cgi-bin/micromsg-bin/addfavitem";
    locala.funcId = 401;
    locala.reqCmdId = 193;
    locala.respCmdId = 1000000193;
    this.rr = locala.ado();
    this.mud = paramg;
    AppMethodBeat.o(102716);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(102717);
    ch localch = (ch)this.rr.fsV.fta;
    localch.pIw = p.t(this.mud.field_xml, System.currentTimeMillis());
    localch.jKs = this.mud.field_type;
    localch.woH = this.mud.field_sourceType;
    this.mud.field_xml = g.s(this.mud);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(this.mud, new String[] { "localId" });
    localch.woJ = this.mud.field_xml;
    localch.woI = this.mud.field_sourceId;
    this.mud.NG("MicroMsg.Fav.NetSceneAddFav");
    this.callback = paramf;
    ab.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[] { this.mud.field_sourceId, Long.valueOf(this.mud.field_localId), Integer.valueOf(this.mud.field_id) });
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(102717);
    return i;
  }
  
  public final int getType()
  {
    return 401;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102718);
    ab.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((paramInt2 == 0) && (paramInt3 == 0)) || (paramInt3 == -400))
    {
      paramq = (ci)((com.tencent.mm.ai.b)paramq).fsW.fta;
      ab.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[] { Integer.valueOf(paramq.woD), Long.valueOf(this.mud.field_localId), Integer.valueOf(this.mud.field_itemStatus), Integer.valueOf(paramq.woG) });
      this.mud.field_id = paramq.woD;
      this.mud.field_localSeq = paramq.woG;
      if (this.mud.field_itemStatus == 12)
      {
        ab.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
        this.mud.field_itemStatus = 13;
      }
      if (this.mud.field_itemStatus == 9)
      {
        ab.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
        this.mud.field_itemStatus = 10;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().jY(this.mud.field_localId);
        com.tencent.mm.plugin.report.service.h.qsU.e(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(this.mud.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.mud)), Long.valueOf(h.jU(this.mud.field_localId)) });
      }
      paramArrayOfByte = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(paramq.woD);
      if (paramArrayOfByte != null)
      {
        this.mud.field_updateSeq = paramArrayOfByte.field_updateSeq;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().z(paramArrayOfByte);
        ab.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[] { Integer.valueOf(paramArrayOfByte.field_id) });
      }
      paramArrayOfByte = v.aae().oP(this.mud.field_sessionId);
      if ((!bo.isNullOrNil(this.mud.field_sessionId)) && (this.mud.field_type == 5) && (paramArrayOfByte != null))
      {
        wg localwg = new wg();
        localwg.cNx.cNy = paramArrayOfByte.getString("prePublishId", "");
        if ((this.mud.field_favProto != null) && (this.mud.field_favProto.wVa != null)) {
          localwg.cNx.url = this.mud.field_favProto.wVa.link;
        }
        if ((bo.isNullOrNil(localwg.cNx.url)) && (this.mud.field_favProto != null) && (this.mud.field_favProto.wUf != null) && (this.mud.field_favProto.wUf.wVF != null)) {
          localwg.cNx.url = this.mud.field_favProto.wUf.wVF;
        }
        if (bo.isNullOrNil(localwg.cNx.url)) {
          localwg.cNx.url = paramArrayOfByte.getString("url", "");
        }
        localwg.cNx.cNA = paramArrayOfByte.getString("preUsername", "");
        localwg.cNx.cNB = paramArrayOfByte.getString("preChatName", "");
        localwg.cNx.cNC = paramArrayOfByte.getInt("preMsgIndex", 0);
        localwg.cNx.cNG = paramArrayOfByte.getInt("sendAppMsgScene", 0);
        localwg.cNx.cNH = paramArrayOfByte.getInt("getA8KeyScene", 0);
        localwg.cNx.cNI = paramArrayOfByte.getString("referUrl", null);
        localwg.cNx.cNJ = paramArrayOfByte.getString("adExtStr", null);
        localwg.cNx.cND = "";
        localwg.cNx.cNE = "";
        localwg.cNx.cNF = 0;
        localwg.cNx.cNz = ("fav_" + r.Zn() + "_" + this.mud.field_id);
        a.ymk.l(localwg);
      }
      this.mud.field_sessionId = null;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(this.mud, new String[] { "localId" });
      b.jK(paramq.woK);
    }
    if ((paramInt2 == 4) && (paramInt3 == -401))
    {
      ab.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
      if (!this.mud.bwr()) {
        break label965;
      }
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(16, this.mud.field_localId);
    }
    for (;;)
    {
      b.d(this.mud);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(102718);
      return;
      label965:
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(6, this.mud.field_localId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.af
 * JD-Core Version:    0.7.0.1
 */