package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.v;
import java.util.HashMap;
import java.util.List;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.c.a, com.tencent.mm.plugin.chatroom.a.c
{
  private v kEi;
  private boolean kEj;
  private HashMap<String, Boolean> kEk;
  
  public a()
  {
    AppMethodBeat.i(1011);
    this.kEk = new HashMap();
    AppMethodBeat.o(1011);
  }
  
  public final boolean IV(String paramString)
  {
    AppMethodBeat.i(1013);
    if (this.kEj)
    {
      AppMethodBeat.o(1013);
      return false;
    }
    label260:
    for (;;)
    {
      try
      {
        if (this.kEk.containsKey(paramString))
        {
          bool = ((Boolean)this.kEk.get(paramString)).booleanValue();
          AppMethodBeat.o(1013);
          return bool;
        }
        u localu = this.kEi.oU(paramString);
        if ((localu.field_chatroomStatus & 0x4000) != 0L)
        {
          bool = true;
          int i = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("ChatRoomAdminSwitch", -1);
          int j = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("ChatRoomAdminMinMemberCount", -1);
          ab.i("MicroMsg.ChatroomService", "[isEnableRoomManager] chatroomName:%s isStatusEnable:%s switchFlag:%s minCount:%d memberCount:%d", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localu.afx().size()) });
          if (i > 0)
          {
            if (bool) {
              break label260;
            }
            if (j <= localu.afx().size())
            {
              break label260;
              this.kEk.put(paramString, Boolean.valueOf(bool));
              AppMethodBeat.o(1013);
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
        ab.printErrStackTrace("MicroMsg.ChatroomService", paramString, "[isEnableRoomManager]", new Object[0]);
        AppMethodBeat.o(1013);
        return false;
      }
    }
  }
  
  public final ag c(h paramh)
  {
    AppMethodBeat.i(1012);
    paramh = new v(paramh);
    AppMethodBeat.o(1012);
    return paramh;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(1014);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new a.1(this));
    AppMethodBeat.o(1014);
    return localHashMap;
  }
  
  public final void ge(boolean paramBoolean)
  {
    this.kEj = paramBoolean;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(1015);
    this.kEi = new v(g.RL().eHS);
    AppMethodBeat.o(1015);
  }
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a
 * JD-Core Version:    0.7.0.1
 */