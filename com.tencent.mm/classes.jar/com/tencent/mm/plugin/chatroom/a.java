package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.c.a, com.tencent.mm.plugin.chatroom.a.c
{
  private boolean isDebugMode;
  private ac oRC;
  private HashMap<String, Boolean> oRD;
  
  public a()
  {
    AppMethodBeat.i(116862);
    this.oRD = new HashMap();
    AppMethodBeat.o(116862);
  }
  
  public final boolean ZA(String paramString)
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
        if (this.oRD.containsKey(paramString))
        {
          bool = ((Boolean)this.oRD.get(paramString)).booleanValue();
          AppMethodBeat.o(116864);
          return bool;
        }
        ab localab = this.oRC.AN(paramString);
        if ((localab.field_chatroomStatus & 0x4000) != 0L)
        {
          bool = true;
          int i = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("ChatRoomAdminSwitch", -1);
          int j = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("ChatRoomAdminMinMemberCount", -1);
          ad.i("MicroMsg.ChatroomService", "[isEnableRoomManager] chatroomName:%s isStatusEnable:%s switchFlag:%s minCount:%d memberCount:%d", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localab.aGo().size()) });
          if (i > 0)
          {
            if (bool) {
              break label255;
            }
            if (j <= localab.aGo().size())
            {
              break label255;
              this.oRD.put(paramString, Boolean.valueOf(bool));
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
        ad.printErrStackTrace("MicroMsg.ChatroomService", paramString, "[isEnableRoomManager]", new Object[0]);
        AppMethodBeat.o(116864);
        return false;
      }
    }
  }
  
  public final ak b(h paramh)
  {
    AppMethodBeat.i(116863);
    paramh = new ac(paramh);
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
        return ac.SQL_CREATE;
      }
    });
    AppMethodBeat.o(116865);
    return localHashMap;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(116866);
    this.oRC = new ac(g.ajC().gBq);
    AppMethodBeat.o(116866);
  }
  
  public final void onAccountRelease() {}
  
  public final void setDebugMode(boolean paramBoolean)
  {
    this.isDebugMode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a
 * JD-Core Version:    0.7.0.1
 */