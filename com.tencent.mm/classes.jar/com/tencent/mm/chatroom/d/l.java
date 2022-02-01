package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h;

public final class l
  extends n
  implements k
{
  private f callback;
  public String fMP;
  public int fMQ;
  public String fMR;
  public int fMS;
  private String roomId;
  private final com.tencent.mm.ak.b rr;
  
  public l(String paramString)
  {
    AppMethodBeat.i(12470);
    this.roomId = "";
    b.a locala = new b.a();
    this.roomId = paramString;
    azo localazo = new azo();
    localazo.FNj = paramString;
    locala.hQF = localazo;
    locala.hQG = new azp();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
    locala.funcId = 223;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ae.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "chatRoomName:%s stack:%s", new Object[] { bu.bI(paramString, ""), bu.fpN().toString() });
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12471);
    ae.w("MicroMsg.NetSceneGetChatRoomInfoDetail", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.d("MicroMsg.NetSceneGetChatRoomInfoDetail", "OK");
      paramArrayOfByte = (azp)this.rr.hQE.hQJ;
      if (paramArrayOfByte.isIncludeUnKnownField())
      {
        paramq = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
        localObject1 = paramq.Bx(this.roomId);
        boolean bool = false;
        if (localObject1 != null)
        {
          ((ac)localObject1).field_saveByteVersion = j.hju;
          ((ac)localObject1).field_handleByteVersion = j.hju;
          ((ac)localObject1).field_roomInfoDetailResByte = paramArrayOfByte.getData();
          bool = paramq.replace((com.tencent.mm.sdk.e.c)localObject1);
        }
        if (localObject1 != null) {
          break label882;
        }
        paramq = "null";
        ae.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "save response byte result:%s, member:%s", new Object[] { Boolean.valueOf(bool), paramq });
      }
      this.fMP = paramArrayOfByte.GPI;
      this.fMQ = paramArrayOfByte.fMQ;
      this.fMR = paramArrayOfByte.fMR;
      this.fMS = paramArrayOfByte.fMS;
      localObject1 = paramArrayOfByte.GPL;
      paramInt1 = paramArrayOfByte.GPJ;
      paramq = this.fMP;
      int i = this.fMQ;
      ae.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s chatRoomStatus:%s associateOpenIMRoomName:%s isIncludeUnKnownField:%s", new Object[] { this.roomId, Integer.valueOf(i), Integer.valueOf(this.fMS), Integer.valueOf(paramInt1), bu.bI((String)localObject1, ""), Boolean.valueOf(paramArrayOfByte.isIncludeUnKnownField()) });
      r.a(this.roomId, bu.nullAsNil(paramq), this.fMR, this.fMS, i, paramInt1);
      if (x.wb(this.roomId))
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().cj(this.roomId, paramArrayOfByte.eRA);
        aa.a(this.roomId, paramArrayOfByte);
        if (x.Bj(this.roomId))
        {
          localObject2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupBindAppStorage();
          localObject3 = this.roomId;
          paramArrayOfByte = paramArrayOfByte.GPM;
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
        l = paramq.yi(Thread.currentThread().getId());
        ae.i("MicroMsg.GroupBindAppStorage", "updateChatRoomBindApp, delete: %d", new Object[] { Long.valueOf(((com.tencent.mm.chatroom.storage.b)localObject2).db.delete("GroupBindApp", "chatRoomName=?", new String[] { localObject3 })) });
        if (paramArrayOfByte != null)
        {
          localObject4 = new a();
          ((a)localObject4).field_chatRoomName = ((String)localObject3);
          ((a)localObject4).field_BindAppData = paramArrayOfByte.toByteArray();
          paramArrayOfByte = ((a)localObject4).convertTo();
          ae.i("MicroMsg.GroupBindAppStorage", "updateChatRoomBindApp, insert: %d", new Object[] { Long.valueOf(((com.tencent.mm.chatroom.storage.b)localObject2).db.insert("GroupBindApp", "chatRoomName", paramArrayOfByte)) });
        }
        if ((paramq != null) && (l != -1L)) {
          paramq.sW(l);
        }
      }
      catch (Exception paramq)
      {
        for (;;)
        {
          Object localObject4;
          ae.i("MicroMsg.GroupBindAppStorage", paramq.getMessage());
          continue;
          paramq = Boolean.valueOf(((ac)localObject2).ftW());
          continue;
          paramArrayOfByte = Boolean.valueOf(((ac)localObject3).ftW());
          continue;
          ((ac)localObject2).field_openIMRoomMigrateStatus = 3;
          continue;
          if (localObject2 == null) {}
          for (paramq = "null";; paramq = bu.bI(((ac)localObject2).field_associateOpenIMRoomName, ""))
          {
            ae.e("MicroMsg.NetSceneGetChatRoomInfoDetail", "handleInfo member:%s", new Object[] { paramq });
            break;
          }
          paramInt1 = 0;
        }
      }
      if ((x.zU(this.roomId)) && (!bu.isNullOrNil((String)localObject1)))
      {
        localObject2 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
        if ((localObject2 == null) || (!bu.isNullOrNil(((ac)localObject2).field_associateOpenIMRoomName))) {
          continue;
        }
        localObject3 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx((String)localObject1);
        localObject4 = this.roomId;
        if (localObject2 != null) {
          continue;
        }
        paramq = "null";
        if (localObject3 != null) {
          continue;
        }
        paramArrayOfByte = "null";
        ae.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "roomId %s finish %s, associateOpenIMRoomName %s finish %s", new Object[] { localObject4, paramq, localObject1, paramArrayOfByte });
        if ((localObject3 == null) || (((ac)localObject3).ftW())) {
          continue;
        }
        paramInt1 = 1;
        ((ac)localObject3).field_openIMRoomMigrateStatus = 2;
        ((ac)localObject3).field_associateOpenIMRoomName = this.roomId;
        ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().replace((com.tencent.mm.sdk.e.c)localObject3);
        if (paramInt1 == 0) {
          continue;
        }
        ((ac)localObject2).field_openIMRoomMigrateStatus = 1;
        ((ac)localObject2).field_associateOpenIMRoomName = ((String)localObject1);
        ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().replace((com.tencent.mm.sdk.e.c)localObject2);
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