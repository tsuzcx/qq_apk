package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.y;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.c.a, com.tencent.mm.plugin.chatroom.a.c
{
  private boolean isDebugMode;
  private y ooh;
  private HashMap<String, Boolean> ooi;
  
  public a()
  {
    AppMethodBeat.i(116862);
    this.ooi = new HashMap();
    AppMethodBeat.o(116862);
  }
  
  public final boolean VR(String paramString)
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
        if (this.ooi.containsKey(paramString))
        {
          bool = ((Boolean)this.ooi.get(paramString)).booleanValue();
          AppMethodBeat.o(116864);
          return bool;
        }
        x localx = this.ooh.xN(paramString);
        if ((localx.field_chatroomStatus & 0x4000) != 0L)
        {
          bool = true;
          int i = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("ChatRoomAdminSwitch", -1);
          int j = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("ChatRoomAdminMinMemberCount", -1);
          ac.i("MicroMsg.ChatroomService", "[isEnableRoomManager] chatroomName:%s isStatusEnable:%s switchFlag:%s minCount:%d memberCount:%d", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localx.aDl().size()) });
          if (i > 0)
          {
            if (bool) {
              break label255;
            }
            if (j <= localx.aDl().size())
            {
              break label255;
              this.ooi.put(paramString, Boolean.valueOf(bool));
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
        ac.printErrStackTrace("MicroMsg.ChatroomService", paramString, "[isEnableRoomManager]", new Object[0]);
        AppMethodBeat.o(116864);
        return false;
      }
    }
  }
  
  public final aj c(h paramh)
  {
    AppMethodBeat.i(116863);
    paramh = new y(paramh);
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
        return y.SQL_CREATE;
      }
    });
    AppMethodBeat.o(116865);
    return localHashMap;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(116866);
    this.ooh = new y(g.agR().ghG);
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