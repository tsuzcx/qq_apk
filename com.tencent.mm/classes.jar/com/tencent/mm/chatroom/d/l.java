package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.w;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.ayz;
import com.tencent.mm.protocal.protobuf.cwe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.h;

public final class l
  extends n
  implements k
{
  private f callback;
  public String fKM;
  public int fKN;
  public String fKO;
  public int fKP;
  private String roomId;
  private final com.tencent.mm.al.b rr;
  
  public l(String paramString)
  {
    AppMethodBeat.i(12470);
    this.roomId = "";
    b.a locala = new b.a();
    this.roomId = paramString;
    ayy localayy = new ayy();
    localayy.FuL = paramString;
    locala.hNM = localayy;
    locala.hNN = new ayz();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
    locala.funcId = 223;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ad.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "chatRoomName:%s stack:%s", new Object[] { bt.bI(paramString, ""), bt.flS().toString() });
    AppMethodBeat.o(12470);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(12472);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12472);
    return i;
  }
  
  public final int getType()
  {
    return 223;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12471);
    ad.w("MicroMsg.NetSceneGetChatRoomInfoDetail", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.d("MicroMsg.NetSceneGetChatRoomInfoDetail", "OK");
      paramArrayOfByte = (ayz)this.rr.hNL.hNQ;
      if (paramArrayOfByte.isIncludeUnKnownField())
      {
        paramq = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz();
        localObject1 = paramq.AN(this.roomId);
        boolean bool = false;
        if (localObject1 != null)
        {
          ((ab)localObject1).field_saveByteVersion = i.hgG;
          ((ab)localObject1).field_handleByteVersion = i.hgG;
          ((ab)localObject1).field_roomInfoDetailResByte = paramArrayOfByte.getData();
          bool = paramq.replace((com.tencent.mm.sdk.e.c)localObject1);
        }
        if (localObject1 != null) {
          break label882;
        }
        paramq = "null";
        ad.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "save response byte result:%s, member:%s", new Object[] { Boolean.valueOf(bool), paramq });
      }
      this.fKM = paramArrayOfByte.Gwj;
      this.fKN = paramArrayOfByte.fKN;
      this.fKO = paramArrayOfByte.fKO;
      this.fKP = paramArrayOfByte.fKP;
      localObject1 = paramArrayOfByte.Gwm;
      paramInt1 = paramArrayOfByte.Gwk;
      paramq = this.fKM;
      int i = this.fKN;
      ad.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s chatRoomStatus:%s associateOpenIMRoomName:%s isIncludeUnKnownField:%s", new Object[] { this.roomId, Integer.valueOf(i), Integer.valueOf(this.fKP), Integer.valueOf(paramInt1), bt.bI((String)localObject1, ""), Boolean.valueOf(paramArrayOfByte.isIncludeUnKnownField()) });
      com.tencent.mm.model.q.a(this.roomId, bt.nullAsNil(paramq), this.fKO, this.fKP, i, paramInt1);
      if (w.vF(this.roomId))
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().ci(this.roomId, paramArrayOfByte.ePP);
        aa.a(this.roomId, paramArrayOfByte);
        if (w.Az(this.roomId))
        {
          localObject2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupBindAppStorage();
          localObject3 = this.roomId;
          paramArrayOfByte = paramArrayOfByte.Gwn;
          if (!(((com.tencent.mm.chatroom.storage.b)localObject2).db instanceof h)) {
            break label992;
          }
        }
      }
    }
    label992:
    for (paramq = (h)((com.tencent.mm.chatroom.storage.b)localObject2).db;; paramq = null)
    {
      long l = -1L;
      if (paramq != null) {}
      try
      {
        l = paramq.xO(Thread.currentThread().getId());
        ad.i("MicroMsg.GroupBindAppStorage", "updateChatRoomBindApp, delete: %d", new Object[] { Long.valueOf(((com.tencent.mm.chatroom.storage.b)localObject2).db.delete("GroupBindApp", "chatRoomName=?", new String[] { localObject3 })) });
        if (paramArrayOfByte != null)
        {
          localObject4 = new a();
          ((a)localObject4).field_chatRoomName = ((String)localObject3);
          ((a)localObject4).field_BindAppData = paramArrayOfByte.toByteArray();
          paramArrayOfByte = ((a)localObject4).convertTo();
          ad.i("MicroMsg.GroupBindAppStorage", "updateChatRoomBindApp, insert: %d", new Object[] { Long.valueOf(((com.tencent.mm.chatroom.storage.b)localObject2).db.insert("GroupBindApp", "chatRoomName", paramArrayOfByte)) });
        }
        if ((paramq != null) && (l != -1L)) {
          paramq.sJ(l);
        }
      }
      catch (Exception paramq)
      {
        for (;;)
        {
          Object localObject4;
          ad.i("MicroMsg.GroupBindAppStorage", paramq.getMessage());
          continue;
          paramq = Boolean.valueOf(((ab)localObject2).fpW());
          continue;
          paramArrayOfByte = Boolean.valueOf(((ab)localObject3).fpW());
          continue;
          ((ab)localObject2).field_openIMRoomMigrateStatus = 3;
          continue;
          if (localObject2 == null) {}
          for (paramq = "null";; paramq = bt.bI(((ab)localObject2).field_associateOpenIMRoomName, ""))
          {
            ad.e("MicroMsg.NetSceneGetChatRoomInfoDetail", "handleInfo member:%s", new Object[] { paramq });
            break;
          }
          paramInt1 = 0;
        }
      }
      if ((w.zk(this.roomId)) && (!bt.isNullOrNil((String)localObject1)))
      {
        localObject2 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.roomId);
        if ((localObject2 == null) || (!bt.isNullOrNil(((ab)localObject2).field_associateOpenIMRoomName))) {
          continue;
        }
        localObject3 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN((String)localObject1);
        localObject4 = this.roomId;
        if (localObject2 != null) {
          continue;
        }
        paramq = "null";
        if (localObject3 != null) {
          continue;
        }
        paramArrayOfByte = "null";
        ad.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "roomId %s finish %s, associateOpenIMRoomName %s finish %s", new Object[] { localObject4, paramq, localObject1, paramArrayOfByte });
        if ((localObject3 == null) || (((ab)localObject3).fpW())) {
          continue;
        }
        paramInt1 = 1;
        ((ab)localObject3).field_openIMRoomMigrateStatus = 2;
        ((ab)localObject3).field_associateOpenIMRoomName = this.roomId;
        ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().replace((com.tencent.mm.sdk.e.c)localObject3);
        if (paramInt1 == 0) {
          continue;
        }
        ((ab)localObject2).field_openIMRoomMigrateStatus = 1;
        ((ab)localObject2).field_associateOpenIMRoomName = ((String)localObject1);
        ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().replace((com.tencent.mm.sdk.e.c)localObject2);
        if (paramInt1 != 0) {
          ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ac(this.roomId, (String)localObject1);
        }
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12471);
      return;
      label882:
      paramq = localObject1.toString();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.l
 * JD-Core Version:    0.7.0.1
 */