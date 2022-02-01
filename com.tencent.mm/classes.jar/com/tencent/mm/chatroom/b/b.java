package com.tencent.mm.chatroom.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.b.a.eh;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.List;

public final class b
  implements s
{
  public final boolean Yd()
  {
    AppMethodBeat.i(182077);
    boolean bool = y.Yd();
    AppMethodBeat.o(182077);
    return bool;
  }
  
  public final void ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182076);
    c localc = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(paramString1, paramString2);
    boolean bool;
    if (localc != null)
    {
      bool = y.c(localc);
      Object localObject1 = localc.fMd.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Long)((Iterator)localObject1).next();
        localObject2 = ((l)g.ab(l.class)).dlK().aI(paramString1, ((Long)localObject2).longValue());
        ((bu)localObject2).tZ("");
        ((l)g.ab(l.class)).dlK().a(((ei)localObject2).field_msgId, (bu)localObject2);
      }
      localObject1 = new nb();
      ((nb)localObject1).dAZ.op = 1;
      ((nb)localObject1).dAZ.dBa = paramString2;
      ((nb)localObject1).dAZ.dvs = paramString1;
      a.IbL.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
    }
    for (;;)
    {
      if (localc == null) {}
      for (paramString1 = "null";; paramString1 = localc.field_todoid)
      {
        ad.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomInfoTodo delete(%s) result:%s", new Object[] { paramString1, Boolean.valueOf(bool) });
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
    ad.d("MicroMsg.roomTodo.RoomTodoService", "shareDialogOperateReport %s %s %s %s %s %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (!y.Yd())
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!w.zk(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!w.Ay(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (w.Az(paramString1)) {}
    for (;;)
    {
      eh localeh = new eh();
      localeh.ecZ = localeh.t("roomid", paramString1, true);
      localeh.dSy = i;
      localeh.dSD = localeh.t("appid", paramString2, true);
      localeh.dSE = localeh.t("appname", paramString3, true);
      localeh.ehN = paramInt1;
      localeh.ehM = paramInt2;
      localeh.ehJ = paramInt3;
      localeh.aLk();
      AppMethodBeat.o(184780);
      return;
      i = 1;
    }
  }
  
  public final void q(String paramString, long paramLong)
  {
    AppMethodBeat.i(213383);
    Object localObject = ((l)g.ab(l.class)).dlK().xY(paramLong);
    boolean bool;
    if (((ei)localObject).field_msgId == paramLong)
    {
      if (!bt.isNullOrNil(((ei)localObject).fkD))
      {
        ((s)g.ab(s.class)).ab(paramString, ((ei)localObject).fkD);
        AppMethodBeat.o(213383);
      }
    }
    else
    {
      localObject = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().uP(paramString);
      if (localObject == null) {
        break label205;
      }
      bool = y.c((c)localObject);
      nb localnb = new nb();
      localnb.dAZ.op = 1;
      localnb.dAZ.dBa = ((c)localObject).field_todoid;
      localnb.dAZ.dvs = paramString;
      a.IbL.a(localnb, Looper.getMainLooper());
    }
    for (;;)
    {
      if (localObject == null) {}
      for (localObject = "null";; localObject = ((c)localObject).field_todoid)
      {
        ad.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomAtAllTodo delete(%s) roomname:%s result:%s", new Object[] { localObject, paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(213383);
        return;
      }
      label205:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.b
 * JD-Core Version:    0.7.0.1
 */