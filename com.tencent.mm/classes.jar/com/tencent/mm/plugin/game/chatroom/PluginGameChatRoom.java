package com.tencent.mm.plugin.game.chatroom;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ac;
import com.tencent.mm.app.ac.b;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.bk;
import com.tencent.mm.autogen.a.bm;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storagebase.h.b;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;

public class PluginGameChatRoom
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.game.chatroom.a.a
{
  private static ac.b Iep;
  private static q.a appForegroundListener;
  public String AmC;
  private String Iem;
  private com.tencent.mm.plugin.game.chatroom.f.b Ien;
  private MStorage.IOnStorageChange Ieo;
  private com.tencent.mm.storagebase.h mCN;
  
  static
  {
    AppMethodBeat.i(275642);
    appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(275637);
        Log.i("GameChatRoom.PluginGameChatRoom", "appForegroundListener, onAppBackground(%s)", new Object[] { paramAnonymousString });
        b.IdR = null;
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.kernel.b.aZG();
        }
        AppMethodBeat.o(275637);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(275632);
        Log.i("GameChatRoom.PluginGameChatRoom", "appForegroundListener, onAppForeground(%s)", new Object[] { paramAnonymousString });
        b.IdR = paramAnonymousString;
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.kernel.b.aZG();
        }
        AppMethodBeat.o(275632);
      }
    };
    Iep = new ac.b()
    {
      public final void onProcessBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(275638);
        Log.i("GameChatRoom.PluginGameChatRoom", "procForegroundDelegate, onProcessBackground(%s)", new Object[] { paramAnonymousString });
        AppMethodBeat.o(275638);
      }
      
      public final void onProcessForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(275631);
        Log.i("GameChatRoom.PluginGameChatRoom", "procForegroundDelegate, onProcessForeground(%s)", new Object[] { paramAnonymousString });
        if (b.IdR == null) {
          b.IdR = paramAnonymousString;
        }
        AppMethodBeat.o(275631);
      }
    };
    AppMethodBeat.o(275642);
  }
  
  public PluginGameChatRoom()
  {
    AppMethodBeat.i(275620);
    this.Ieo = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData) {}
    };
    AppMethodBeat.o(275620);
  }
  
  private com.tencent.mm.storagebase.h getDB()
  {
    return this.mCN;
  }
  
  private void initDB()
  {
    AppMethodBeat.i(275627);
    this.Iem = (com.tencent.mm.kernel.h.baE().cachePath + "GameChatRoom.db");
    this.mCN = new com.tencent.mm.storagebase.h();
    if (!this.mCN.a(this.Iem, collectDatabaseFactory(), true))
    {
      Log.i("GameChatRoom.PluginGameChatRoom", "GameChatRoom db init failed");
      AppMethodBeat.o(275627);
      return;
    }
    AppMethodBeat.o(275627);
  }
  
  private void resetDB()
  {
    AppMethodBeat.i(275634);
    if (this.mCN != null)
    {
      this.mCN.closeDB();
      this.mCN = null;
    }
    this.Ien = null;
    AppMethodBeat.o(275634);
  }
  
  public void callAtFunction(final String paramString1, final String paramString2, String paramString3)
  {
    AppMethodBeat.i(275689);
    ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(paramString2, new com.tencent.mm.plugin.game.chatroom.b.b.a()
    {
      public final void onDone(final Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramAnonymousMap)
      {
        AppMethodBeat.i(275624);
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(275658);
            if ((paramAnonymousMap != null) && (paramAnonymousMap.containsKey(PluginGameChatRoom.3.this.lzH)))
            {
              bm localbm = new bm();
              localbm.hBz.channelId = g.a.Ieu;
              localbm.hBz.highlight = false;
              localbm.publish();
              com.tencent.threadpool.h.ahAA.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(275664);
                  com.tencent.mm.plugin.game.chatroom.b.c localc = (com.tencent.mm.plugin.game.chatroom.b.c)PluginGameChatRoom.3.1.this.IdM.get(PluginGameChatRoom.3.this.lzH);
                  boolean bool1 = e.aFq(PluginGameChatRoom.3.this.Ier).IdU;
                  boolean bool2 = e.aFq(PluginGameChatRoom.3.this.Ier).IdV;
                  if ((localc != null) && (!bool1) && (!bool2))
                  {
                    bk localbk = new bk();
                    localbk.hBw.userName = localc.getUserName();
                    localbk.hBw.nickName = localc.getNickName();
                    localbk.publish();
                  }
                  AppMethodBeat.o(275664);
                }
              }, 200L);
            }
            AppMethodBeat.o(275658);
          }
        });
        AppMethodBeat.o(275624);
      }
    });
    AppMethodBeat.o(275689);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(275662);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("GameChatRoomContact".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.game.chatroom.f.b.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("GameSimpleUserInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.game.chatroom.f.e.SQL_CREATE;
      }
    });
    AppMethodBeat.o(275662);
    return localHashMap;
  }
  
  public void enterGameChatRoom(Context paramContext, String paramString1, String paramString2, Lbs paramLbs, boolean paramBoolean1, long paramLong1, long paramLong2, Bundle paramBundle, ActivityOptions paramActivityOptions, boolean paramBoolean2)
  {
    AppMethodBeat.i(275668);
    if (paramBoolean2) {}
    for (b.IdQ = false;; b.IdQ = true)
    {
      GameChatRoomUI.a(paramContext, paramString1, paramString2, paramLbs, paramBoolean1, paramLong1, paramLong2, paramActivityOptions, false, false, 0, paramBundle, -1, -1L);
      AppMethodBeat.o(275668);
      return;
    }
  }
  
  public void enterGameChatRoomFromFind(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(275682);
    b.IdQ = true;
    GameChatRoomUI.a(paramContext, paramString1, paramString2, null, false, paramLong1, paramLong2, null, true, true, 0, null, -1, -1L);
    AppMethodBeat.o(275682);
  }
  
  public boolean enterGameChatRoomFromWeb(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, Bundle paramBundle, int paramInt1, long paramLong3, int paramInt2)
  {
    AppMethodBeat.i(275675);
    b.IdQ = true;
    paramBoolean1 = GameChatRoomUI.a(paramContext, paramString1, paramString2, null, paramBoolean1, paramLong1, paramLong2, null, paramBoolean2, true, paramInt2, paramBundle, paramInt1, paramLong3);
    AppMethodBeat.o(275675);
    return paramBoolean1;
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(275656);
    Log.i("GameChatRoom.PluginGameChatRoom", "PluginGameChatRoom execute");
    if (paramg.bbA()) {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.chatroom.b.b.class, new a());
    }
    AppMethodBeat.o(275656);
  }
  
  public com.tencent.mm.plugin.game.chatroom.f.b getContactStorage()
  {
    AppMethodBeat.i(275693);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.Ien == null) {
      this.Ien = new com.tencent.mm.plugin.game.chatroom.f.b(getDB());
    }
    com.tencent.mm.plugin.game.chatroom.f.b localb = this.Ien;
    AppMethodBeat.o(275693);
    return localb;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(275649);
    Log.i("GameChatRoom.PluginGameChatRoom", "onAccountInitialized");
    this.AmC = (com.tencent.mm.kernel.h.baE().mCJ + "gamechatroom/avatar/");
    initDB();
    paramc = a.b.iKa();
    if ((paramc instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      com.tencent.mm.plugin.game.chatroom.g.d locald = new com.tencent.mm.plugin.game.chatroom.g.d(((com.tencent.mm.pluginsdk.ui.b)paramc).XXP);
      ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@gamelifechatroom", locald);
    }
    ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).m(this.Ieo);
    appForegroundListener.alive();
    ac.aCN().a(Iep);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.chatroom.f.d.class, new com.tencent.mm.plugin.game.chatroom.f.e(this.mCN));
    AppMethodBeat.o(275649);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(275653);
    Log.i("GameChatRoom.PluginGameChatRoom", "onAccountRelease");
    ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).l(this.Ieo);
    resetDB();
    appForegroundListener.dead();
    ac.aCN().b(Iep);
    AppMethodBeat.o(275653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.PluginGameChatRoom
 * JD-Core Version:    0.7.0.1
 */