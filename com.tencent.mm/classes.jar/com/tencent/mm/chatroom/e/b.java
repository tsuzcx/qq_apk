package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import java.util.Map;

public final class b
  implements p
{
  static void a(ah paramah, String paramString1, String paramString2)
  {
    AppMethodBeat.i(194043);
    if (paramah != null) {}
    for (;;)
    {
      ah localah;
      Object localObject2;
      try
      {
        if (Util.isNullOrNil(paramah.field_associateOpenIMRoomName))
        {
          localah = ((c)g.af(c.class)).aSX().Kd(paramString2);
          Object localObject1;
          if (paramah == null)
          {
            localObject1 = "null";
            break label302;
            Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "associateRoomName %s finish %s, imunionRoomName %s finish %s", new Object[] { paramString1, localObject1, paramString2, localObject2 });
            if ((localah == null) || (localah.gBC())) {
              break label297;
            }
            localah.field_openIMRoomMigrateStatus = 2;
            localah.field_associateOpenIMRoomName = paramString1;
            ((c)g.af(c.class)).aSX().replace(localah);
            i = 1;
            if (i != 0)
            {
              paramah.field_openIMRoomMigrateStatus = 1;
              paramah.field_associateOpenIMRoomName = paramString2;
              ((c)g.af(c.class)).aSX().replace(paramah);
              if (i != 0) {
                ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getOpenImMigrateService().ae(paramString1, paramString2);
              }
              AppMethodBeat.o(194043);
            }
          }
          else
          {
            localObject1 = Boolean.valueOf(paramah.gBC());
            break label302;
            localObject2 = Boolean.valueOf(localah.gBC());
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
        AppMethodBeat.o(194043);
        return;
      }
      for (paramah = "null";; paramah = Util.nullAs(paramah.field_associateOpenIMRoomName, ""))
      {
        Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo member:%s", new Object[] { paramah });
        AppMethodBeat.o(194043);
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
    AppMethodBeat.i(194042);
    if (Util.nullAsNil(paramString).equals("IMUnionRoom2AssociateRoom"))
    {
      Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { Util.nullAs(paramString, "") });
      if (!y.ama())
      {
        AppMethodBeat.o(194042);
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
        if ((ab.Ix(paramString)) && (!Util.isNullOrNil(paramMap)))
        {
          parama = ((c)g.af(c.class)).aSX().Kd(paramString);
          if (parama != null) {
            continue;
          }
          ay.a.iDq.a(paramString, null, new ay.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(194041);
              Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "getContactCallBack username:%s succ:%s", new Object[] { Util.nullAs(paramAnonymousString, ""), Boolean.valueOf(paramAnonymousBoolean) });
              if (paramAnonymousBoolean) {
                b.a(((c)g.af(c.class)).aSX().Kd(paramString), paramString, paramMap);
              }
              AppMethodBeat.o(194041);
            }
          });
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
      }
      AppMethodBeat.o(194042);
      return null;
      a(parama, paramString, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.b
 * JD-Core Version:    0.7.0.1
 */