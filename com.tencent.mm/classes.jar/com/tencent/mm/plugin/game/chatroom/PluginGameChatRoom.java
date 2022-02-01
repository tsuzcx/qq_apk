package com.tencent.mm.plugin.game.chatroom;

import android.app.ActivityOptions;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.chatroom.f.d;
import com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginGameChatRoom
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, c, com.tencent.mm.plugin.game.chatroom.a.a
{
  private String CrS;
  private com.tencent.mm.plugin.game.chatroom.e.b CrT;
  private MStorage.IOnStorageChange CrU;
  private com.tencent.mm.storagebase.h kcF;
  public String wQa;
  
  public PluginGameChatRoom()
  {
    AppMethodBeat.i(212505);
    this.CrU = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData) {}
    };
    AppMethodBeat.o(212505);
  }
  
  private com.tencent.mm.storagebase.h getDB()
  {
    return this.kcF;
  }
  
  private void initDB()
  {
    AppMethodBeat.i(212529);
    this.CrS = (com.tencent.mm.kernel.h.aHG().cachePath + "GameChatRoom.db");
    this.kcF = new com.tencent.mm.storagebase.h();
    if (!this.kcF.a(this.CrS, collectDatabaseFactory(), true))
    {
      Log.i("GameChatRoom.PluginGameChatRoom", "GameChatRoom db init failed");
      AppMethodBeat.o(212529);
      return;
    }
    AppMethodBeat.o(212529);
  }
  
  private void resetDB()
  {
    AppMethodBeat.i(212532);
    if (this.kcF != null)
    {
      this.kcF.closeDB();
      this.kcF = null;
    }
    this.CrT = null;
    AppMethodBeat.o(212532);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(212516);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("GameChatRoomContact".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.game.chatroom.e.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(212516);
    return localHashMap;
  }
  
  public void enterGameChatRoom(Context paramContext, String paramString1, String paramString2, Lbs paramLbs, boolean paramBoolean, long paramLong1, long paramLong2, ActivityOptions paramActivityOptions)
  {
    AppMethodBeat.i(212521);
    GameChatRoomUI.a(paramContext, paramString1, paramString2, paramLbs, paramBoolean, paramLong1, paramLong2, paramActivityOptions, false, false, 0);
    AppMethodBeat.o(212521);
  }
  
  public void enterGameChatRoomFromWeb(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(212524);
    GameChatRoomUI.a(paramContext, paramString1, paramString2, null, paramBoolean1, paramLong1, paramLong2, null, paramBoolean2, true, paramInt);
    AppMethodBeat.o(212524);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(212514);
    Log.i("GameChatRoom.PluginGameChatRoom", "PluginGameChatRoom execute");
    if (paramg.aIE()) {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.chatroom.b.b.class, new a());
    }
    AppMethodBeat.o(212514);
  }
  
  public com.tencent.mm.plugin.game.chatroom.e.b getContactStorage()
  {
    AppMethodBeat.i(212527);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.CrT == null) {
      this.CrT = new com.tencent.mm.plugin.game.chatroom.e.b(getDB());
    }
    com.tencent.mm.plugin.game.chatroom.e.b localb = this.CrT;
    AppMethodBeat.o(212527);
    return localb;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(212508);
    Log.i("GameChatRoom.PluginGameChatRoom", "onAccountInitialized");
    this.wQa = (com.tencent.mm.kernel.h.aHG().kcB + "gamechatroom/avatar/");
    initDB();
    paramc = a.b.hjf();
    if ((paramc instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      d locald = new d(((com.tencent.mm.pluginsdk.ui.b)paramc).RbJ);
      ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@gamelifechatroom", locald);
    }
    ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.chatroom.b.b.class)).m(this.CrU);
    AppMethodBeat.o(212508);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(212511);
    Log.i("GameChatRoom.PluginGameChatRoom", "onAccountRelease");
    ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.chatroom.b.b.class)).l(this.CrU);
    resetDB();
    AppMethodBeat.o(212511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.PluginGameChatRoom
 * JD-Core Version:    0.7.0.1
 */