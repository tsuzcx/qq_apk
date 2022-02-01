package com.tencent.mm.chatroom.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qa;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.mm;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.List;

public final class b
  implements w
{
  public final boolean aLX()
  {
    AppMethodBeat.i(182077);
    boolean bool = com.tencent.mm.chatroom.d.ab.aLX();
    AppMethodBeat.o(182077);
    return bool;
  }
  
  public final void am(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182076);
    c localc = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().ar(paramString1, paramString2);
    boolean bool;
    if (localc != null)
    {
      bool = com.tencent.mm.chatroom.d.ab.c(localc);
      Object localObject1 = localc.lzA.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Long)((Iterator)localObject1).next();
        localObject2 = ((n)h.ax(n.class)).gaZ().aU(paramString1, ((Long)localObject2).longValue());
        ((cc)localObject2).Ce("");
        ((n)h.ax(n.class)).gaZ().a(((fi)localObject2).field_msgId, (cc)localObject2);
      }
      localObject1 = new qa();
      ((qa)localObject1).hTi.op = 1;
      ((qa)localObject1).hTi.hTj = paramString2;
      ((qa)localObject1).hTi.hMM = paramString1;
      ((qa)localObject1).asyncPublish(Looper.getMainLooper());
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
  
  public final void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2;
    AppMethodBeat.i(184780);
    Log.d("MicroMsg.roomTodo.RoomTodoService", "shareDialogOperateReport %s %s %s %s %s %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (!com.tencent.mm.chatroom.d.ab.aLX())
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!au.bwG(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (!com.tencent.mm.model.ab.Je(paramString1))
    {
      AppMethodBeat.o(184780);
      return;
    }
    if (com.tencent.mm.model.ab.Jf(paramString1)) {}
    for (;;)
    {
      mm localmm = new mm();
      localmm.iNB = localmm.F("roomid", paramString1, true);
      localmm.ips = i;
      localmm.ipx = localmm.F("appid", paramString2, true);
      localmm.ipy = localmm.F("appname", paramString3, true);
      localmm.jbH = paramInt1;
      localmm.jbG = paramInt2;
      localmm.jbD = paramInt3;
      localmm.bMH();
      AppMethodBeat.o(184780);
      return;
      i = 1;
    }
  }
  
  public final void p(String paramString, long paramLong)
  {
    AppMethodBeat.i(241323);
    Object localObject = ((n)h.ax(n.class)).gaZ().sl(paramLong);
    boolean bool;
    if ((localObject != null) && (((fi)localObject).field_msgId == paramLong))
    {
      if (!Util.isNullOrNil(((fi)localObject).kLt))
      {
        ((w)h.ax(w.class)).am(paramString, ((fi)localObject).kLt);
        AppMethodBeat.o(241323);
      }
    }
    else
    {
      localObject = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupTodoStorage().CY(paramString);
      if (localObject == null) {
        break label207;
      }
      bool = com.tencent.mm.chatroom.d.ab.c((c)localObject);
      qa localqa = new qa();
      localqa.hTi.op = 1;
      localqa.hTi.hTj = ((c)localObject).field_todoid;
      localqa.hTi.hMM = paramString;
      localqa.asyncPublish(Looper.getMainLooper());
    }
    for (;;)
    {
      if (localObject == null) {}
      for (localObject = "null";; localObject = ((c)localObject).field_todoid)
      {
        Log.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomAtAllTodo delete(%s) roomname:%s result:%s", new Object[] { localObject, paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(241323);
        return;
      }
      label207:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.b
 * JD-Core Version:    0.7.0.1
 */