package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.Map;

public final class b
  implements p
{
  static void a(ab paramab, String paramString1, String paramString2)
  {
    AppMethodBeat.i(213416);
    if (paramab != null) {}
    for (;;)
    {
      ab localab;
      Object localObject2;
      try
      {
        if (bt.isNullOrNil(paramab.field_associateOpenIMRoomName))
        {
          localab = ((c)g.ab(c.class)).azz().AN(paramString2);
          Object localObject1;
          if (paramab == null)
          {
            localObject1 = "null";
            break label302;
            ad.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "associateRoomName %s finish %s, imunionRoomName %s finish %s", new Object[] { paramString1, localObject1, paramString2, localObject2 });
            if ((localab == null) || (localab.fpW())) {
              break label297;
            }
            localab.field_openIMRoomMigrateStatus = 2;
            localab.field_associateOpenIMRoomName = paramString1;
            ((c)g.ab(c.class)).azz().replace(localab);
            i = 1;
            if (i != 0)
            {
              paramab.field_openIMRoomMigrateStatus = 1;
              paramab.field_associateOpenIMRoomName = paramString2;
              ((c)g.ab(c.class)).azz().replace(paramab);
              if (i != 0) {
                ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ac(paramString1, paramString2);
              }
              AppMethodBeat.o(213416);
            }
          }
          else
          {
            localObject1 = Boolean.valueOf(paramab.fpW());
            break label302;
            localObject2 = Boolean.valueOf(localab.fpW());
            continue;
          }
          paramab.field_openIMRoomMigrateStatus = 3;
          continue;
        }
        if (paramab != null) {}
      }
      catch (Exception paramab)
      {
        ad.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo Exception:%s %s", new Object[] { paramab.getClass().getSimpleName(), paramab.getMessage() });
        AppMethodBeat.o(213416);
        return;
      }
      for (paramab = "null";; paramab = bt.bI(paramab.field_associateOpenIMRoomName, ""))
      {
        ad.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "handleInfo member:%s", new Object[] { paramab });
        AppMethodBeat.o(213416);
        return;
      }
      label297:
      int i = 0;
      continue;
      label302:
      if (localab == null) {
        localObject2 = "null";
      }
    }
  }
  
  public final e.b a(final String paramString, final Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(213415);
    if (bt.nullAsNil(paramString).equals("IMUnionRoom2AssociateRoom"))
    {
      ad.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { bt.bI(paramString, "") });
      if (!y.Yd())
      {
        AppMethodBeat.o(213415);
        return null;
      }
      if (paramMap == null) {}
    }
    for (;;)
    {
      try
      {
        paramString = bt.nullAsNil((String)paramMap.get(".sysmsg.associateroomname")).trim();
        paramMap = bt.nullAsNil((String)paramMap.get(".sysmsg.imunionroomname")).trim();
        ad.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml %s %s", new Object[] { bt.bI(paramMap, ""), bt.bI(paramString, "") });
        if ((w.zk(paramString)) && (!bt.isNullOrNil(paramMap)))
        {
          parama = ((c)g.ab(c.class)).azz().AN(paramString);
          if (parama != null) {
            continue;
          }
          as.a.hFO.a(paramString, null, new as.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(213414);
              ad.i("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "getContactCallBack username:%s succ:%s", new Object[] { bt.bI(paramAnonymousString, ""), Boolean.valueOf(paramAnonymousBoolean) });
              if (paramAnonymousBoolean) {
                b.a(((c)g.ab(c.class)).azz().AN(paramString), paramString, paramMap);
              }
              AppMethodBeat.o(213414);
            }
          });
        }
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.IMUnionRoom2AssociateRoomNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
      }
      AppMethodBeat.o(213415);
      return null;
      a(parama, paramString, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.b
 * JD-Core Version:    0.7.0.1
 */