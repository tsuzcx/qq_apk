package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.chatroom.d.ab;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import java.util.Map;

public final class b
  implements s
{
  static void a(aj paramaj, String paramString1, String paramString2)
  {
    AppMethodBeat.i(241414);
    if (paramaj != null) {}
    for (;;)
    {
      aj localaj;
      Object localObject2;
      try
      {
        if (Util.isNullOrNil(paramaj.field_associateOpenIMRoomName))
        {
          localaj = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString2);
          Object localObject1;
          if (paramaj == null)
          {
            localObject1 = "null";
            break label302;
            Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "associateRoomName %s finish %s, imunionRoomName %s finish %s", new Object[] { paramString1, localObject1, paramString2, localObject2 });
            if ((localaj == null) || (localaj.iZs())) {
              break label297;
            }
            localaj.field_openIMRoomMigrateStatus = 2;
            localaj.field_associateOpenIMRoomName = paramString1;
            ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().replace(localaj);
            i = 1;
            if (i != 0)
            {
              paramaj.field_openIMRoomMigrateStatus = 1;
              paramaj.field_associateOpenIMRoomName = paramString2;
              ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().replace(paramaj);
              if (i != 0) {
                ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getOpenImMigrateService().an(paramString1, paramString2);
              }
              AppMethodBeat.o(241414);
            }
          }
          else
          {
            localObject1 = Boolean.valueOf(paramaj.iZs());
            break label302;
            localObject2 = Boolean.valueOf(localaj.iZs());
            continue;
          }
          paramaj.field_openIMRoomMigrateStatus = 3;
          continue;
        }
        if (paramaj != null) {}
      }
      catch (Exception paramaj)
      {
        Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo Exception:%s %s", new Object[] { paramaj.getClass().getSimpleName(), paramaj.getMessage() });
        AppMethodBeat.o(241414);
        return;
      }
      for (paramaj = "null";; paramaj = Util.nullAs(paramaj.field_associateOpenIMRoomName, ""))
      {
        Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo member:%s", new Object[] { paramaj });
        AppMethodBeat.o(241414);
        return;
      }
      label297:
      int i = 0;
      continue;
      label302:
      if (localaj == null) {
        localObject2 = "null";
      }
    }
  }
  
  public final g.b a(final String paramString, final Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(241417);
    if (Util.nullAsNil(paramString).equals("IMUnionRoom2AssociateRoom"))
    {
      Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { Util.nullAs(paramString, "") });
      if (!ab.aLX())
      {
        AppMethodBeat.o(241417);
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
        if ((au.bwG(paramString)) && (!Util.isNullOrNil(paramMap)))
        {
          parama = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
          if (parama != null) {
            continue;
          }
          az.a.okP.a(paramString, null, new az.b.a()
          {
            public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(241411);
              Log.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "getContactCallBack username:%s succ:%s", new Object[] { Util.nullAs(paramAnonymousString, ""), Boolean.valueOf(paramAnonymousBoolean) });
              if (paramAnonymousBoolean) {
                b.a(((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString), paramString, paramMap);
              }
              AppMethodBeat.o(241411);
            }
          });
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
      }
      AppMethodBeat.o(241417);
      return null;
      a(parama, paramString, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.b
 * JD-Core Version:    0.7.0.1
 */