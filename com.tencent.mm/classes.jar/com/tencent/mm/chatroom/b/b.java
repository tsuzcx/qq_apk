package com.tencent.mm.chatroom.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.b.a.hp;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;

public final class b
  implements t
{
  public final void ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182076);
    c localc = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(paramString1, paramString2);
    boolean bool;
    if (localc != null)
    {
      bool = y.c(localc);
      Object localObject1 = localc.gts.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Long)((Iterator)localObject1).next();
        localObject2 = ((l)g.af(l.class)).eiy().aJ(paramString1, ((Long)localObject2).longValue());
        ((ca)localObject2).CK("");
        ((l)g.af(l.class)).eiy().a(((eo)localObject2).field_msgId, (ca)localObject2);
      }
      localObject1 = new nt();
      ((nt)localObject1).dTT.op = 1;
      ((nt)localObject1).dTT.dTU = paramString2;
      ((nt)localObject1).dTT.dOe = paramString1;
      EventCenter.instance.asyncPublish((IEvent)localObject1, Looper.getMainLooper());
    }
    for (;;)
    {
      if (localc == null) {}
      for (paramString1 = "null";; paramString1 = localc.field_todoid)
      {
        Log.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomInfoTodo delete(%s) result:%s", new Object[] { paramString1, Boolean.valueOf(bool) });
        AppMethodBeat.o(182076);
        return;
      }
      bool = false;
    }
  }
  
  public final boolean ama()
  {
    AppMethodBeat.i(182077);
    boolean bool = y.ama();
    AppMethodBeat.o(182077);
    return bool;
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2;
    AppMethodBeat.i(184780);
    Log.d("MicroMsg.roomTodo.RoomTodoService", "shareDialogOperateReport %s %s %s %s %s %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (!y.ama())
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!ab.Ix(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!ab.JN(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (ab.JO(paramString1)) {}
    for (;;)
    {
      hp localhp = new hp();
      localhp.eFc = localhp.x("roomid", paramString1, true);
      localhp.enM = i;
      localhp.enR = localhp.x("appid", paramString2, true);
      localhp.enS = localhp.x("appname", paramString3, true);
      localhp.eMg = paramInt1;
      localhp.eMf = paramInt2;
      localhp.eMc = paramInt3;
      localhp.bfK();
      AppMethodBeat.o(184780);
      return;
      i = 1;
    }
  }
  
  public final void r(String paramString, long paramLong)
  {
    AppMethodBeat.i(194009);
    Object localObject = ((l)g.af(l.class)).eiy().Hb(paramLong);
    boolean bool;
    if (((eo)localObject).field_msgId == paramLong)
    {
      if (!Util.isNullOrNil(((eo)localObject).fRe))
      {
        ((t)g.af(t.class)).ad(paramString, ((eo)localObject).fRe);
        AppMethodBeat.o(194009);
      }
    }
    else
    {
      localObject = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupTodoStorage().DB(paramString);
      if (localObject == null) {
        break label205;
      }
      bool = y.c((c)localObject);
      nt localnt = new nt();
      localnt.dTT.op = 1;
      localnt.dTT.dTU = ((c)localObject).field_todoid;
      localnt.dTT.dOe = paramString;
      EventCenter.instance.asyncPublish(localnt, Looper.getMainLooper());
    }
    for (;;)
    {
      if (localObject == null) {}
      for (localObject = "null";; localObject = ((c)localObject).field_todoid)
      {
        Log.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomAtAllTodo delete(%s) roomname:%s result:%s", new Object[] { localObject, paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(194009);
        return;
      }
      label205:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.b
 * JD-Core Version:    0.7.0.1
 */