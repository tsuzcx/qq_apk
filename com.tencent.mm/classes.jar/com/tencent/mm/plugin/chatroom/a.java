package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.af;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.v;
import java.util.HashMap;
import java.util.List;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.c.a, com.tencent.mm.plugin.chatroom.a.c
{
  private v iBa;
  private boolean iBb;
  private HashMap<String, Boolean> iBc = new HashMap();
  
  public final af c(h paramh)
  {
    return new v(paramh);
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new a.1(this));
    return localHashMap;
  }
  
  public final void eF(boolean paramBoolean)
  {
    this.iBb = paramBoolean;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    this.iBa = new v(com.tencent.mm.kernel.g.DP().dKu);
  }
  
  public final void onAccountRelease() {}
  
  public final boolean zl(String paramString)
  {
    boolean bool3 = true;
    if (this.iBb) {
      return false;
    }
    for (;;)
    {
      try
      {
        if (this.iBc.containsKey(paramString)) {
          return ((Boolean)this.iBc.get(paramString)).booleanValue();
        }
        u localu = this.iBa.in(paramString);
        if ((localu.field_chatroomStatus & 0x4000) != 0L)
        {
          bool1 = true;
          int i = com.tencent.mm.m.g.AA().getInt("ChatRoomAdminSwitch", -1);
          int j = com.tencent.mm.m.g.AA().getInt("ChatRoomAdminMinMemberCount", -1);
          y.i("MicroMsg.ChatroomService", "[isEnableRoomManager] chatroomName:%s isStatusEnable:%s switchFlag:%s minCount:%d memberCount:%d", new Object[] { paramString, Boolean.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localu.MN().size()) });
          if (i <= 0) {
            break label208;
          }
          bool2 = bool3;
          if (!bool1)
          {
            if (j > localu.MN().size()) {
              break label208;
            }
            bool2 = bool3;
          }
          this.iBc.put(paramString, Boolean.valueOf(bool2));
          return bool2;
        }
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.ChatroomService", paramString, "[isEnableRoomManager]", new Object[0]);
        return false;
      }
      boolean bool1 = false;
      continue;
      label208:
      boolean bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a
 * JD-Core Version:    0.7.0.1
 */