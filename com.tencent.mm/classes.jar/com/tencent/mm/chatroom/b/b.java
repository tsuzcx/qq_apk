package com.tencent.mm.chatroom.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.f.a.oq;
import com.tencent.mm.f.b.a.jv;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;

public final class b
  implements w
{
  public final void ah(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182076);
    c localc = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().am(paramString1, paramString2);
    boolean bool;
    if (localc != null)
    {
      bool = y.c(localc);
      Object localObject1 = localc.iXE.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Long)((Iterator)localObject1).next();
        localObject2 = ((n)h.ae(n.class)).eSe().aL(paramString1, ((Long)localObject2).longValue());
        ((ca)localObject2).Jy("");
        ((n)h.ae(n.class)).eSe().a(((et)localObject2).field_msgId, (ca)localObject2);
      }
      localObject1 = new oq();
      ((oq)localObject1).fNv.op = 1;
      ((oq)localObject1).fNv.fNw = paramString2;
      ((oq)localObject1).fNv.fHp = paramString1;
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
  
  public final boolean asb()
  {
    AppMethodBeat.i(182077);
    boolean bool = y.asb();
    AppMethodBeat.o(182077);
    return bool;
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2;
    AppMethodBeat.i(184780);
    Log.d("MicroMsg.roomTodo.RoomTodoService", "shareDialogOperateReport %s %s %s %s %s %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (!y.asb())
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!ab.PP(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!ab.Rg(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (ab.Rh(paramString1)) {}
    for (;;)
    {
      jv localjv = new jv();
      localjv.gDw = localjv.z("roomid", paramString1, true);
      localjv.giO = i;
      localjv.giT = localjv.z("appid", paramString2, true);
      localjv.giU = localjv.z("appname", paramString3, true);
      localjv.gLV = paramInt1;
      localjv.gLU = paramInt2;
      localjv.gLR = paramInt3;
      localjv.bpa();
      AppMethodBeat.o(184780);
      return;
      i = 1;
    }
  }
  
  public final void o(String paramString, long paramLong)
  {
    AppMethodBeat.i(187296);
    Object localObject = ((n)h.ae(n.class)).eSe().Oq(paramLong);
    boolean bool;
    if (((et)localObject).field_msgId == paramLong)
    {
      if (!Util.isNullOrNil(((et)localObject).ilu))
      {
        ((w)h.ae(w.class)).ah(paramString, ((et)localObject).ilu);
        AppMethodBeat.o(187296);
      }
    }
    else
    {
      localObject = ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupTodoStorage().Ks(paramString);
      if (localObject == null) {
        break label205;
      }
      bool = y.c((c)localObject);
      oq localoq = new oq();
      localoq.fNv.op = 1;
      localoq.fNv.fNw = ((c)localObject).field_todoid;
      localoq.fNv.fHp = paramString;
      EventCenter.instance.asyncPublish(localoq, Looper.getMainLooper());
    }
    for (;;)
    {
      if (localObject == null) {}
      for (localObject = "null";; localObject = ((c)localObject).field_todoid)
      {
        Log.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomAtAllTodo delete(%s) roomname:%s result:%s", new Object[] { localObject, paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(187296);
        return;
      }
      label205:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.b
 * JD-Core Version:    0.7.0.1
 */