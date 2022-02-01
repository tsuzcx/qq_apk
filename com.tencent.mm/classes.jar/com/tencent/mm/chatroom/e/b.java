package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.x;
import java.util.Map;

public final class b
  implements o
{
  static void a(x paramx, String paramString1, String paramString2)
  {
    AppMethodBeat.i(197044);
    if (paramx != null) {}
    for (;;)
    {
      x localx;
      Object localObject2;
      try
      {
        if (bs.isNullOrNil(paramx.field_associateOpenIMRoomName))
        {
          localx = ((c)g.ab(c.class)).awK().xN(paramString2);
          Object localObject1;
          if (paramx == null)
          {
            localObject1 = "null";
            break label302;
            ac.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "associateRoomName %s finish %s, imunionRoomName %s finish %s", new Object[] { paramString1, localObject1, paramString2, localObject2 });
            if ((localx == null) || (localx.eZU())) {
              break label297;
            }
            localx.field_openIMRoomMigrateStatus = 2;
            localx.field_associateOpenIMRoomName = paramString1;
            ((c)g.ab(c.class)).awK().replace(localx);
            i = 1;
            if (i != 0)
            {
              paramx.field_openIMRoomMigrateStatus = 1;
              paramx.field_associateOpenIMRoomName = paramString2;
              ((c)g.ab(c.class)).awK().replace(paramx);
              if (i != 0) {
                ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ab(paramString1, paramString2);
              }
              AppMethodBeat.o(197044);
            }
          }
          else
          {
            localObject1 = Boolean.valueOf(paramx.eZU());
            break label302;
            localObject2 = Boolean.valueOf(localx.eZU());
            continue;
          }
          paramx.field_openIMRoomMigrateStatus = 3;
          continue;
        }
        if (paramx != null) {}
      }
      catch (Exception paramx)
      {
        ac.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo Exception:%s %s", new Object[] { paramx.getClass().getSimpleName(), paramx.getMessage() });
        AppMethodBeat.o(197044);
        return;
      }
      for (paramx = "null";; paramx = bs.bG(paramx.field_associateOpenIMRoomName, ""))
      {
        ac.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo member:%s", new Object[] { paramx });
        AppMethodBeat.o(197044);
        return;
      }
      label297:
      int i = 0;
      continue;
      label302:
      if (localx == null) {
        localObject2 = "null";
      }
    }
  }
  
  public final f.b a(final String paramString, final Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(197043);
    if (bs.nullAsNil(paramString).equals("IMUnionRoom2AssociateRoom"))
    {
      ac.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { bs.bG(paramString, "") });
      if (!y.VM())
      {
        AppMethodBeat.o(197043);
        return null;
      }
      if (paramMap == null) {}
    }
    for (;;)
    {
      try
      {
        paramString = bs.nullAsNil((String)paramMap.get(".sysmsg.associateroomname")).trim();
        paramMap = bs.nullAsNil((String)paramMap.get(".sysmsg.imunionroomname")).trim();
        ac.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml %s %s", new Object[] { bs.bG(paramMap, ""), bs.bG(paramString, "") });
        if ((w.wp(paramString)) && (!bs.isNullOrNil(paramMap)))
        {
          parama = ((c)g.ab(c.class)).awK().xN(paramString);
          if (parama != null) {
            continue;
          }
          ar.a.hnw.a(paramString, null, new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(197042);
              ac.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "getContactCallBack username:%s succ:%s", new Object[] { bs.bG(paramAnonymousString, ""), Boolean.valueOf(paramAnonymousBoolean) });
              if (paramAnonymousBoolean) {
                b.a(((c)g.ab(c.class)).awK().xN(paramString), paramString, paramMap);
              }
              AppMethodBeat.o(197042);
            }
          });
        }
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
      }
      AppMethodBeat.o(197043);
      return null;
      a(parama, paramString, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.b
 * JD-Core Version:    0.7.0.1
 */