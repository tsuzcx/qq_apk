package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;

public final class l
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  public String fsm;
  public int fsn;
  public String fso;
  public int fsp;
  private String roomId;
  private final com.tencent.mm.ak.b rr;
  
  public l(String paramString)
  {
    AppMethodBeat.i(12470);
    this.roomId = "";
    b.a locala = new b.a();
    this.roomId = paramString;
    ava localava = new ava();
    localava.DPx = paramString;
    locala.hvt = localava;
    locala.hvu = new avb();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
    locala.funcId = 223;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "chatRoomName:%s stack:%s", new Object[] { bs.bG(paramString, ""), bs.eWi().toString() });
    AppMethodBeat.o(12470);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(12472);
    this.callback = paramg;
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
    ac.w("MicroMsg.NetSceneGetChatRoomInfoDetail", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    Object localObject;
    x localx1;
    x localx2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.d("MicroMsg.NetSceneGetChatRoomInfoDetail", "OK");
      paramArrayOfByte = (avb)this.rr.hvs.hvw;
      if (paramArrayOfByte.isIncludeUnKnownField())
      {
        paramq = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK();
        localObject = paramq.xN(this.roomId);
        boolean bool = false;
        if (localObject != null)
        {
          ((x)localObject).field_saveByteVersion = h.gMJ;
          ((x)localObject).field_handleByteVersion = h.gMJ;
          ((x)localObject).field_roomInfoDetailResByte = paramArrayOfByte.getData();
          bool = paramq.replace((com.tencent.mm.sdk.e.c)localObject);
        }
        if (localObject != null) {
          break label658;
        }
        paramq = "null";
        ac.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "save response byte result:%s, member:%s", new Object[] { Boolean.valueOf(bool), paramq });
      }
      this.fsm = paramArrayOfByte.ENf;
      this.fsn = paramArrayOfByte.fsn;
      this.fso = paramArrayOfByte.fso;
      this.fsp = paramArrayOfByte.fsp;
      localObject = paramArrayOfByte.ENi;
      paramInt1 = paramArrayOfByte.ENg;
      paramq = this.fsm;
      int i = this.fsn;
      ac.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s chatRoomStatus:%s associateOpenIMRoomName:%s isIncludeUnKnownField:%s", new Object[] { this.roomId, Integer.valueOf(i), Integer.valueOf(this.fsp), Integer.valueOf(paramInt1), bs.bG((String)localObject, ""), Boolean.valueOf(paramArrayOfByte.isIncludeUnKnownField()) });
      com.tencent.mm.model.q.a(this.roomId, bs.nullAsNil(paramq), this.fso, this.fsp, i, paramInt1);
      if (w.sQ(this.roomId))
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().ce(this.roomId, paramArrayOfByte.eyr);
        aa.a(this.roomId, paramArrayOfByte);
      }
      if ((w.wp(this.roomId)) && (!bs.isNullOrNil((String)localObject)))
      {
        localx1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
        if ((localx1 == null) || (!bs.isNullOrNil(localx1.field_associateOpenIMRoomName))) {
          break label703;
        }
        localx2 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN((String)localObject);
        String str = this.roomId;
        if (localx1 != null) {
          break label668;
        }
        paramq = "null";
        label482:
        if (localx2 != null) {
          break label681;
        }
        paramArrayOfByte = "null";
        label491:
        ac.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "roomId %s finish %s, associateOpenIMRoomName %s finish %s", new Object[] { str, paramq, localObject, paramArrayOfByte });
        if ((localx2 == null) || (localx2.eZU())) {
          break label747;
        }
        paramInt1 = 1;
        localx2.field_openIMRoomMigrateStatus = 2;
        localx2.field_associateOpenIMRoomName = this.roomId;
        ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().replace(localx2);
      }
    }
    for (;;)
    {
      if (paramInt1 != 0) {}
      for (localx1.field_openIMRoomMigrateStatus = 1;; localx1.field_openIMRoomMigrateStatus = 3)
      {
        localx1.field_associateOpenIMRoomName = ((String)localObject);
        ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().replace(localx1);
        if (paramInt1 != 0) {
          ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ab(this.roomId, (String)localObject);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(12471);
        return;
        label658:
        paramq = localObject.toString();
        break;
        label668:
        paramq = Boolean.valueOf(localx1.eZU());
        break label482;
        label681:
        paramArrayOfByte = Boolean.valueOf(localx2.eZU());
        break label491;
      }
      label703:
      if (localx1 == null) {}
      for (paramq = "null";; paramq = bs.bG(localx1.field_associateOpenIMRoomName, ""))
      {
        ac.e("MicroMsg.NetSceneGetChatRoomInfoDetail", "handleInfo member:%s", new Object[] { paramq });
        break;
      }
      label747:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.l
 * JD-Core Version:    0.7.0.1
 */