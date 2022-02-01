package com.tencent.mm.chatroom.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.b.a.bz;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.List;

public final class a
  implements r
{
  public final boolean UQ()
  {
    AppMethodBeat.i(182077);
    boolean bool = y.UQ();
    AppMethodBeat.o(182077);
    return bool;
  }
  
  public final void Z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182076);
    com.tencent.mm.chatroom.storage.a locala = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ac(paramString1, paramString2);
    boolean bool;
    if (locala != null)
    {
      bool = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().h(locala);
      Object localObject1 = locala.fpJ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Long)((Iterator)localObject1).next();
        localObject2 = ((k)g.ab(k.class)).cOI().aD(paramString1, ((Long)localObject2).longValue());
        ((bl)localObject2).oh("");
        ((k)g.ab(k.class)).cOI().a(((du)localObject2).field_msgId, (bl)localObject2);
      }
      localObject1 = new mk();
      ((mk)localObject1).drB.op = 1;
      ((mk)localObject1).drB.drC = paramString2;
      ((mk)localObject1).drB.dlX = paramString1;
      com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
    }
    for (;;)
    {
      if (locala == null) {}
      for (paramString1 = "null";; paramString1 = locala.field_todoid)
      {
        ad.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomInfoTodo delete(%s) result:%s", new Object[] { paramString1, Boolean.valueOf(bool) });
        AppMethodBeat.o(182076);
        return;
      }
      bool = false;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2;
    AppMethodBeat.i(184780);
    ad.d("MicroMsg.roomTodo.RoomTodoService", "shareDialogOperateReport %s %s %s %s %s %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (!y.UQ())
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!w.sm(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!w.tx(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (w.ty(paramString1)) {}
    for (;;)
    {
      bz localbz = new bz();
      localbz.dQr = localbz.t("roomid", paramString1, true);
      localbz.dHG = i;
      localbz.dHL = localbz.t("appid", paramString2, true);
      localbz.dHM = localbz.t("appname", paramString3, true);
      localbz.dQt = paramInt1;
      localbz.dQs = paramInt2;
      localbz.dQo = paramInt3;
      localbz.aBj();
      AppMethodBeat.o(184780);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.a
 * JD-Core Version:    0.7.0.1
 */