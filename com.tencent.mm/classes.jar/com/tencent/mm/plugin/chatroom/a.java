package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, c, b
{
  private boolean isDebugMode;
  private ak wPh;
  private HashMap<String, Boolean> wPi;
  private HashMap<String, Boolean> wPj;
  
  public a()
  {
    AppMethodBeat.i(116862);
    this.wPi = new HashMap();
    this.wPj = new HashMap();
    AppMethodBeat.o(116862);
  }
  
  public final boolean alP(String paramString)
  {
    AppMethodBeat.i(116864);
    if (this.isDebugMode)
    {
      AppMethodBeat.o(116864);
      return false;
    }
    label255:
    for (;;)
    {
      try
      {
        if (this.wPi.containsKey(paramString))
        {
          bool = ((Boolean)this.wPi.get(paramString)).booleanValue();
          AppMethodBeat.o(116864);
          return bool;
        }
        aj localaj = this.wPh.Ju(paramString);
        if ((localaj.field_chatroomStatus & 0x4000) != 0L)
        {
          bool = true;
          int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("ChatRoomAdminSwitch", -1);
          int j = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("ChatRoomAdminMinMemberCount", -1);
          Log.i("MicroMsg.ChatroomService", "[isEnableRoomManager] chatroomName:%s isStatusEnable:%s switchFlag:%s minCount:%d memberCount:%d", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localaj.bHw().size()) });
          if (i > 0)
          {
            if (bool) {
              break label255;
            }
            if (j <= localaj.bHw().size())
            {
              break label255;
              this.wPi.put(paramString, Boolean.valueOf(bool));
              AppMethodBeat.o(116864);
              return bool;
            }
          }
        }
        else
        {
          bool = false;
          continue;
        }
        boolean bool = false;
        continue;
        bool = true;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.ChatroomService", paramString, "[isEnableRoomManager]", new Object[0]);
        AppMethodBeat.o(116864);
        return false;
      }
    }
  }
  
  public final boolean alQ(String paramString)
  {
    AppMethodBeat.i(260942);
    try
    {
      if (this.wPj.containsKey(paramString))
      {
        bool = ((Boolean)this.wPj.get(paramString)).booleanValue();
        AppMethodBeat.o(260942);
        return bool;
      }
      if ((this.wPh.Ju(paramString).field_chatroomStatus & 0x2) == 2L) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.wPj.put(paramString, Boolean.TRUE);
        }
        AppMethodBeat.o(260942);
        return bool;
      }
      return false;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ChatroomService", paramString, "[isEnableRoomManager]", new Object[0]);
      AppMethodBeat.o(260942);
    }
  }
  
  public final ar c(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(116863);
    paramh = new ak(paramh);
    AppMethodBeat.o(116863);
    return paramh;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(116865);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ak.SQL_CREATE;
      }
    });
    AppMethodBeat.o(116865);
    return localHashMap;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(116866);
    this.wPh = new ak(com.tencent.mm.kernel.h.baE().mCN);
    AppMethodBeat.o(116866);
  }
  
  public final void onAccountRelease() {}
  
  public final void setDebugMode(boolean paramBoolean)
  {
    this.isDebugMode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a
 * JD-Core Version:    0.7.0.1
 */