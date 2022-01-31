package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
  extends m
  implements k
{
  private f callback;
  public String eeq;
  public int eer;
  public String ees;
  public int eet;
  private String eeu;
  private final b rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(103925);
    this.eeu = "";
    b.a locala = new b.a();
    this.eeu = paramString;
    aip localaip = new aip();
    localaip.wot = paramString;
    locala.fsX = localaip;
    locala.fsY = new aiq();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
    locala.funcId = 223;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(103925);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103927);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103927);
    return i;
  }
  
  public final int getType()
  {
    return 223;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103926);
    ab.w("MicroMsg.NetSceneGetChatRoomInfoDetail", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.d("MicroMsg.NetSceneGetChatRoomInfoDetail", "OK");
      this.eeq = ((aiq)this.rr.fsW.fta).xan;
      this.eer = ((aiq)this.rr.fsW.fta).eer;
      this.ees = ((aiq)this.rr.fsW.fta).ees;
      this.eet = ((aiq)this.rr.fsW.fta).eet;
      paramInt1 = ((aiq)this.rr.fsW.fta).xao;
      paramq = this.eeq;
      int i = this.eer;
      ab.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s chatRoomStatus:%s", new Object[] { this.eeu, Integer.valueOf(i), Integer.valueOf(this.eet), Integer.valueOf(paramInt1) });
      n.a(this.eeu, bo.nullAsNil(paramq), this.ees, this.eet, i, paramInt1);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.i
 * JD-Core Version:    0.7.0.1
 */