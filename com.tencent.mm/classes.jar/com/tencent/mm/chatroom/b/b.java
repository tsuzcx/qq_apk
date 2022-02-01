package com.tencent.mm.chatroom.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.List;

public final class b
  implements t
{
  public final boolean Yn()
  {
    AppMethodBeat.i(182077);
    boolean bool = y.Yn();
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
      Object localObject1 = localc.fOh.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Long)((Iterator)localObject1).next();
        localObject2 = ((l)g.ab(l.class)).doJ().aJ(paramString1, ((Long)localObject2).longValue());
        ((bv)localObject2).uu("");
        ((l)g.ab(l.class)).doJ().a(((ei)localObject2).field_msgId, (bv)localObject2);
      }
      localObject1 = new nc();
      ((nc)localObject1).dCe.op = 1;
      ((nc)localObject1).dCe.dCf = paramString2;
      ((nc)localObject1).dCe.dwx = paramString1;
      a.IvT.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
    }
    for (;;)
    {
      if (localc == null) {}
      for (paramString1 = "null";; paramString1 = localc.field_todoid)
      {
        ae.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomInfoTodo delete(%s) result:%s", new Object[] { paramString1, Boolean.valueOf(bool) });
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
    ae.d("MicroMsg.roomTodo.RoomTodoService", "shareDialogOperateReport %s %s %s %s %s %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (!y.Yn())
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!x.zU(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!x.Bi(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (x.Bj(paramString1)) {}
    for (;;)
    {
      ej localej = new ej();
      localej.eeu = localej.t("roomid", paramString1, true);
      localej.dTO = i;
      localej.dTT = localej.t("appid", paramString2, true);
      localej.dTU = localej.t("appname", paramString3, true);
      localej.ejx = paramInt1;
      localej.ejw = paramInt2;
      localej.ejt = paramInt3;
      localej.aLH();
      AppMethodBeat.o(184780);
      return;
      i = 1;
    }
  }
  
  public final void q(String paramString, long paramLong)
  {
    AppMethodBeat.i(217095);
    Object localObject = ((l)g.ab(l.class)).doJ().ys(paramLong);
    boolean bool;
    if (((ei)localObject).field_msgId == paramLong)
    {
      if (!bu.isNullOrNil(((ei)localObject).fmA))
      {
        ((t)g.ab(t.class)).ab(paramString, ((ei)localObject).fmA);
        AppMethodBeat.o(217095);
      }
    }
    else
    {
      localObject = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().vk(paramString);
      if (localObject == null) {
        break label205;
      }
      bool = y.c((c)localObject);
      nc localnc = new nc();
      localnc.dCe.op = 1;
      localnc.dCe.dCf = ((c)localObject).field_todoid;
      localnc.dCe.dwx = paramString;
      a.IvT.a(localnc, Looper.getMainLooper());
    }
    for (;;)
    {
      if (localObject == null) {}
      for (localObject = "null";; localObject = ((c)localObject).field_todoid)
      {
        ae.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomAtAllTodo delete(%s) roomname:%s result:%s", new Object[] { localObject, paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(217095);
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