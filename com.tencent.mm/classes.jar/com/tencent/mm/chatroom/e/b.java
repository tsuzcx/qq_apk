package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import java.util.Map;

public final class b
  implements s
{
  static void a(ah paramah, String paramString1, String paramString2)
  {
    AppMethodBeat.i(194642);
    if (paramah != null) {}
    for (;;)
    {
      ah localah;
      Object localObject2;
      try
      {
        if (Util.isNullOrNil(paramah.field_associateOpenIMRoomName))
        {
          localah = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString2);
          Object localObject1;
          if (paramah == null)
          {
            localObject1 = "null";
            break label302;
            Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "associateRoomName %s finish %s, imunionRoomName %s finish %s", new Object[] { paramString1, localObject1, paramString2, localObject2 });
            if ((localah == null) || (localah.hxN())) {
              break label297;
            }
            localah.field_openIMRoomMigrateStatus = 2;
            localah.field_associateOpenIMRoomName = paramString1;
            ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().replace(localah);
            i = 1;
            if (i != 0)
            {
              paramah.field_openIMRoomMigrateStatus = 1;
              paramah.field_associateOpenIMRoomName = paramString2;
              ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().replace(paramah);
              if (i != 0) {
                ((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getOpenImMigrateService().ai(paramString1, paramString2);
              }
              AppMethodBeat.o(194642);
            }
          }
          else
          {
            localObject1 = Boolean.valueOf(paramah.hxN());
            break label302;
            localObject2 = Boolean.valueOf(localah.hxN());
            continue;
          }
          paramah.field_openIMRoomMigrateStatus = 3;
          continue;
        }
        if (paramah != null) {}
      }
      catch (Exception paramah)
      {
        Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo Exception:%s %s", new Object[] { paramah.getClass().getSimpleName(), paramah.getMessage() });
        AppMethodBeat.o(194642);
        return;
      }
      for (paramah = "null";; paramah = Util.nullAs(paramah.field_associateOpenIMRoomName, ""))
      {
        Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo member:%s", new Object[] { paramah });
        AppMethodBeat.o(194642);
        return;
      }
      label297:
      int i = 0;
      continue;
      label302:
      if (localah == null) {
        localObject2 = "null";
      }
    }
  }
  
  public final h.b a(final String paramString, final Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(194636);
    if (Util.nullAsNil(paramString).equals("IMUnionRoom2AssociateRoom"))
    {
      Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { Util.nullAs(paramString, "") });
      if (!y.asb())
      {
        AppMethodBeat.o(194636);
        return null;
      }
      if (paramMap == null) {}
    }
    for (;;)
    {
      try
      {
        paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.associateroomname")).trim();
        paramMap = Util.nullAsNil((String)paramMap.get(".sysmsg.imunionroomname")).trim();
        Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml %s %s", new Object[] { Util.nullAs(paramMap, ""), Util.nullAs(paramString, "") });
        if ((ab.PP(paramString)) && (!Util.isNullOrNil(paramMap)))
        {
          parama = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
          if (parama != null) {
            continue;
          }
          az.a.ltq.a(paramString, null, new az.b.a()
          {
            public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(191406);
              Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "getContactCallBack username:%s succ:%s", new Object[] { Util.nullAs(paramAnonymousString, ""), Boolean.valueOf(paramAnonymousBoolean) });
              if (paramAnonymousBoolean) {
                b.a(((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString), paramString, paramMap);
              }
              AppMethodBeat.o(191406);
            }
          });
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
      }
      AppMethodBeat.o(194636);
      return null;
      a(parama, paramString, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.b
 * JD-Core Version:    0.7.0.1
 */