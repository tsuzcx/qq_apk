package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.esu;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class o
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public String lyp;
  public int lyq;
  public String lyr;
  public int lys;
  private String roomId;
  private final c rr;
  
  public o(String paramString)
  {
    AppMethodBeat.i(12470);
    this.roomId = "";
    c.a locala = new c.a();
    this.roomId = paramString;
    cha localcha = new cha();
    localcha.YFk = paramString;
    locala.otE = localcha;
    locala.otF = new chb();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
    locala.funcId = 223;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    Log.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "chatRoomName:%s stack:%s", new Object[] { Util.nullAs(paramString, ""), Util.getStack().toString() });
    AppMethodBeat.o(12470);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(12472);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12472);
    return i;
  }
  
  public final int getType()
  {
    return 223;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12471);
    Log.w("MicroMsg.NetSceneGetChatRoomInfoDetail", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneGetChatRoomInfoDetail", "OK");
      paramArrayOfByte = (chb)c.c.b(this.rr.otC);
      if (paramArrayOfByte.isIncludeUnKnownField())
      {
        params = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
        localObject1 = params.Ju(this.roomId);
        boolean bool = false;
        if (localObject1 != null)
        {
          ((aj)localObject1).field_saveByteVersion = BuildInfo.CLIENT_VERSION;
          ((aj)localObject1).field_handleByteVersion = BuildInfo.CLIENT_VERSION;
          ((aj)localObject1).field_roomInfoDetailResByte = paramArrayOfByte.getData();
          bool = params.replace((IAutoDBItem)localObject1);
        }
        if (localObject1 != null) {
          break label882;
        }
        params = "null";
        Log.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "save response byte result:%s, member:%s", new Object[] { Boolean.valueOf(bool), params });
      }
      this.lyp = paramArrayOfByte.aapN;
      this.lyq = paramArrayOfByte.lyq;
      this.lyr = paramArrayOfByte.lyr;
      this.lys = paramArrayOfByte.lys;
      localObject1 = paramArrayOfByte.aapQ;
      paramInt1 = paramArrayOfByte.aapO;
      params = this.lyp;
      int i = this.lyq;
      Log.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s chatRoomStatus:%s associateOpenIMRoomName:%s isIncludeUnKnownField:%s", new Object[] { this.roomId, Integer.valueOf(i), Integer.valueOf(this.lys), Integer.valueOf(paramInt1), Util.nullAs((String)localObject1, ""), Boolean.valueOf(paramArrayOfByte.isIncludeUnKnownField()) });
      v.a(this.roomId, Util.nullAsNil(params), this.lyr, this.lys, i, paramInt1);
      if (au.bwE(this.roomId))
      {
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().cx(this.roomId, paramArrayOfByte.kax);
        ad.a(this.roomId, paramArrayOfByte);
        if (ab.Jf(this.roomId))
        {
          localObject2 = ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getGroupBindAppStorage();
          localObject3 = this.roomId;
          paramArrayOfByte = paramArrayOfByte.aapR;
          if (!(((com.tencent.mm.chatroom.storage.b)localObject2).db instanceof com.tencent.mm.storagebase.h)) {
            break label992;
          }
        }
      }
    }
    label992:
    for (params = (com.tencent.mm.storagebase.h)((com.tencent.mm.chatroom.storage.b)localObject2).db;; params = null)
    {
      long l = -1L;
      if (params != null) {}
      try
      {
        l = params.beginTransaction(Thread.currentThread().getId());
        Log.i("MicroMsg.GroupBindAppStorage", "updateChatRoomBindApp, delete: %d", new Object[] { Long.valueOf(((com.tencent.mm.chatroom.storage.b)localObject2).db.delete("GroupBindApp", "chatRoomName=?", new String[] { localObject3 })) });
        if (paramArrayOfByte != null)
        {
          localObject4 = new a();
          ((a)localObject4).field_chatRoomName = ((String)localObject3);
          ((a)localObject4).field_BindAppData = paramArrayOfByte.toByteArray();
          paramArrayOfByte = ((a)localObject4).convertTo();
          Log.i("MicroMsg.GroupBindAppStorage", "updateChatRoomBindApp, insert: %d", new Object[] { Long.valueOf(((com.tencent.mm.chatroom.storage.b)localObject2).db.insert("GroupBindApp", "chatRoomName", paramArrayOfByte)) });
        }
        if ((params != null) && (l != -1L)) {
          params.endTransaction(l);
        }
      }
      catch (Exception params)
      {
        for (;;)
        {
          Object localObject4;
          Log.i("MicroMsg.GroupBindAppStorage", params.getMessage());
          continue;
          params = Boolean.valueOf(((aj)localObject2).iZs());
          continue;
          paramArrayOfByte = Boolean.valueOf(((aj)localObject3).iZs());
          continue;
          ((aj)localObject2).field_openIMRoomMigrateStatus = 3;
          continue;
          if (localObject2 == null) {}
          for (params = "null";; params = Util.nullAs(((aj)localObject2).field_associateOpenIMRoomName, ""))
          {
            Log.e("MicroMsg.NetSceneGetChatRoomInfoDetail", "handleInfo member:%s", new Object[] { params });
            break;
          }
          paramInt1 = 0;
        }
      }
      if ((au.bwG(this.roomId)) && (!Util.isNullOrNil((String)localObject1)))
      {
        localObject2 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.roomId);
        if ((localObject2 == null) || (!Util.isNullOrNil(((aj)localObject2).field_associateOpenIMRoomName))) {
          continue;
        }
        localObject3 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju((String)localObject1);
        localObject4 = this.roomId;
        if (localObject2 != null) {
          continue;
        }
        params = "null";
        if (localObject3 != null) {
          continue;
        }
        paramArrayOfByte = "null";
        Log.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "roomId %s finish %s, associateOpenIMRoomName %s finish %s", new Object[] { localObject4, params, localObject1, paramArrayOfByte });
        if ((localObject3 == null) || (((aj)localObject3).iZs())) {
          continue;
        }
        paramInt1 = 1;
        ((aj)localObject3).field_openIMRoomMigrateStatus = 2;
        ((aj)localObject3).field_associateOpenIMRoomName = this.roomId;
        ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().replace((IAutoDBItem)localObject3);
        if (paramInt1 == 0) {
          continue;
        }
        ((aj)localObject2).field_openIMRoomMigrateStatus = 1;
        ((aj)localObject2).field_associateOpenIMRoomName = ((String)localObject1);
        ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().replace((IAutoDBItem)localObject2);
        if (paramInt1 != 0) {
          ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getOpenImMigrateService().an(this.roomId, (String)localObject1);
        }
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12471);
      return;
      label882:
      params = localObject1.toString();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.o
 * JD-Core Version:    0.7.0.1
 */