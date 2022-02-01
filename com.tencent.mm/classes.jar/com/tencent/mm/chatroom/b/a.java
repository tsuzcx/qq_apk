package com.tencent.mm.chatroom.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.List;

public final class a
  implements r
{
  public final boolean VM()
  {
    AppMethodBeat.i(182077);
    boolean bool = y.VM();
    AppMethodBeat.o(182077);
    return bool;
  }
  
  public final void aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182076);
    com.tencent.mm.chatroom.storage.a locala = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().af(paramString1, paramString2);
    boolean bool;
    if (locala != null)
    {
      bool = y.c(locala);
      Object localObject1 = locala.ftm.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Long)((Iterator)localObject1).next();
        localObject2 = ((k)g.ab(k.class)).dcr().aF(paramString1, ((Long)localObject2).longValue());
        ((bo)localObject2).rn("");
        ((k)g.ab(k.class)).dcr().a(((dy)localObject2).field_msgId, (bo)localObject2);
      }
      localObject1 = new mt();
      ((mt)localObject1).dpm.op = 1;
      ((mt)localObject1).dpm.dpn = paramString2;
      ((mt)localObject1).dpm.djF = paramString1;
      com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
    }
    for (;;)
    {
      if (locala == null) {}
      for (paramString1 = "null";; paramString1 = locala.field_todoid)
      {
        ac.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomInfoTodo delete(%s) result:%s", new Object[] { paramString1, Boolean.valueOf(bool) });
        AppMethodBeat.o(182076);
        return;
      }
      bool = false;
    }
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2;
    AppMethodBeat.i(184780);
    ac.d("MicroMsg.roomTodo.RoomTodoService", "shareDialogOperateReport %s %s %s %s %s %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (!y.VM())
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!w.wp(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!w.xA(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (w.xB(paramString1)) {}
    for (;;)
    {
      dn localdn = new dn();
      localdn.dNK = localdn.t("roomid", paramString1, true);
      localdn.dFt = i;
      localdn.dFy = localdn.t("appid", paramString2, true);
      localdn.dFz = localdn.t("appname", paramString3, true);
      localdn.dSi = paramInt1;
      localdn.dSh = paramInt2;
      localdn.dSe = paramInt3;
      localdn.aHZ();
      AppMethodBeat.o(184780);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.a
 * JD-Core Version:    0.7.0.1
 */