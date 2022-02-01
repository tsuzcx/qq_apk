package com.tencent.mm.plugin.groupsolitaire.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements l
{
  public final void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(110313);
    a(paramString1, paramString2, paramString3, paramLong, cm.bfF());
    AppMethodBeat.o(110313);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(246662);
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s ", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    try
    {
      String str = ((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).atQ(paramString3);
      paramString3 = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramString3 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().ij(paramString3, paramString1);
          if ((((Integer)paramString3.first).intValue() > 0) && (paramString3.second != null))
          {
            paramString3 = (com.tencent.mm.plugin.groupsolitaire.c.a)paramString3.second;
            b.a(paramString1, paramString2, paramString3, paramLong1, false);
            b.a(paramString3, b.a(paramString3, ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().t(paramString1, paramString3.field_key, true), paramString2, 1), paramLong1, true, paramString2, false, paramLong2);
            b.a(paramLong1, paramString2, paramString3);
          }
          AppMethodBeat.o(246662);
          return;
        }
        catch (Exception paramString1)
        {
          Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage2() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
          AppMethodBeat.o(246662);
        }
        localException = localException;
        Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    if (BuildInfo.DEBUG) {
      String.format("processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s content:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1), paramString3 });
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(246660);
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    if (BuildInfo.DEBUG) {
      String.format("processGroupSolitatireMessage() fromUserName:%s toUserName:%s title:%s xml:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    }
    try
    {
      paramString3 = b.ao(paramString1, paramString3, paramString4);
      b.a(paramString1, paramString2, paramString3, paramLong1, true);
      b.a(paramString3, b.a(paramString3, ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().t(paramString1, paramString3.field_key, true), paramString2, 3), paramLong1, false, paramString2, true, paramLong2);
      b.a(paramLong1, paramString2, paramString3);
      AppMethodBeat.o(246660);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage1() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(246660);
    }
  }
  
  public final boolean aKT(String paramString)
  {
    AppMethodBeat.i(110314);
    if ((ab.PP(paramString)) && ((PluginGroupSolitaire.isSupportGroupSolitaireAnalyze()) || (PluginGroupSolitaire.isSupportGroupSolitaireShow())))
    {
      AppMethodBeat.o(110314);
      return true;
    }
    AppMethodBeat.o(110314);
    return false;
  }
  
  public final boolean aKU(String paramString)
  {
    AppMethodBeat.i(110315);
    if ((ab.PP(paramString)) && (PluginGroupSolitaire.isSupportGroupSolitaireShow()))
    {
      AppMethodBeat.o(110315);
      return true;
    }
    AppMethodBeat.o(110315);
    return false;
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(246661);
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg() fromUserName:%s toUserName:%s msgId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    if (BuildInfo.DEBUG) {
      String.format("processGroupSolitatireMessageByGetMsg() fromUserName:%s toUserName:%s title:%s xml:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    }
    try
    {
      paramString3 = b.ao(paramString1, paramString3, paramString4);
      b.a(paramString1, paramString2, paramString3, paramLong1, true);
      paramString1 = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().t(paramString1, paramString3.field_key, true);
      if ((paramString1 != null) && (paramString1.field_lastActiveTime > paramLong2))
      {
        Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "from getRoom % < %s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramString1.field_lastActiveTime) });
        AppMethodBeat.o(246661);
        return;
      }
      b.a(paramString3, b.a(paramString3, paramString1, paramString2, 3), paramLong1, false, paramString2, true, true, paramLong2);
      b.a(paramLong1, paramString2, paramString3);
      AppMethodBeat.o(246661);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(246661);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.a.a
 * JD-Core Version:    0.7.0.1
 */