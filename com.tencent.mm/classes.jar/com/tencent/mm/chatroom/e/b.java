package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import java.util.Map;

public final class b
  implements p
{
  static void a(ac paramac, String paramString1, String paramString2)
  {
    AppMethodBeat.i(217129);
    if (paramac != null) {}
    for (;;)
    {
      ac localac;
      Object localObject2;
      try
      {
        if (bu.isNullOrNil(paramac.field_associateOpenIMRoomName))
        {
          localac = ((c)g.ab(c.class)).azP().Bx(paramString2);
          Object localObject1;
          if (paramac == null)
          {
            localObject1 = "null";
            break label302;
            ae.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "associateRoomName %s finish %s, imunionRoomName %s finish %s", new Object[] { paramString1, localObject1, paramString2, localObject2 });
            if ((localac == null) || (localac.ftW())) {
              break label297;
            }
            localac.field_openIMRoomMigrateStatus = 2;
            localac.field_associateOpenIMRoomName = paramString1;
            ((c)g.ab(c.class)).azP().replace(localac);
            i = 1;
            if (i != 0)
            {
              paramac.field_openIMRoomMigrateStatus = 1;
              paramac.field_associateOpenIMRoomName = paramString2;
              ((c)g.ab(c.class)).azP().replace(paramac);
              if (i != 0) {
                ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ac(paramString1, paramString2);
              }
              AppMethodBeat.o(217129);
            }
          }
          else
          {
            localObject1 = Boolean.valueOf(paramac.ftW());
            break label302;
            localObject2 = Boolean.valueOf(localac.ftW());
            continue;
          }
          paramac.field_openIMRoomMigrateStatus = 3;
          continue;
        }
        if (paramac != null) {}
      }
      catch (Exception paramac)
      {
        ae.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo Exception:%s %s", new Object[] { paramac.getClass().getSimpleName(), paramac.getMessage() });
        AppMethodBeat.o(217129);
        return;
      }
      for (paramac = "null";; paramac = bu.bI(paramac.field_associateOpenIMRoomName, ""))
      {
        ae.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo member:%s", new Object[] { paramac });
        AppMethodBeat.o(217129);
        return;
      }
      label297:
      int i = 0;
      continue;
      label302:
      if (localac == null) {
        localObject2 = "null";
      }
    }
  }
  
  public final e.b a(final String paramString, final Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(217128);
    if (bu.nullAsNil(paramString).equals("IMUnionRoom2AssociateRoom"))
    {
      ae.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { bu.bI(paramString, "") });
      if (!y.Yn())
      {
        AppMethodBeat.o(217128);
        return null;
      }
      if (paramMap == null) {}
    }
    for (;;)
    {
      try
      {
        paramString = bu.nullAsNil((String)paramMap.get(".sysmsg.associateroomname")).trim();
        paramMap = bu.nullAsNil((String)paramMap.get(".sysmsg.imunionroomname")).trim();
        ae.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml %s %s", new Object[] { bu.bI(paramMap, ""), bu.bI(paramString, "") });
        if ((x.zU(paramString)) && (!bu.isNullOrNil(paramMap)))
        {
          parama = ((c)g.ab(c.class)).azP().Bx(paramString);
          if (parama != null) {
            continue;
          }
          au.a.hIG.a(paramString, null, new au.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(217127);
              ae.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "getContactCallBack username:%s succ:%s", new Object[] { bu.bI(paramAnonymousString, ""), Boolean.valueOf(paramAnonymousBoolean) });
              if (paramAnonymousBoolean) {
                b.a(((c)g.ab(c.class)).azP().Bx(paramString), paramString, paramMap);
              }
              AppMethodBeat.o(217127);
            }
          });
        }
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
      }
      AppMethodBeat.o(217128);
      return null;
      a(parama, paramString, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.b
 * JD-Core Version:    0.7.0.1
 */