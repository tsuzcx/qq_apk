package com.tencent.mm.plugin.groupsolitaire.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements j
{
  public final void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(110313);
    a(paramString1, paramString2, paramString3, paramLong, cl.aWB());
    AppMethodBeat.o(110313);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194421);
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s ", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    try
    {
      String str = ((com.tencent.mm.plugin.emoji.b.a)g.af(com.tencent.mm.plugin.emoji.b.a.class)).alW(paramString3);
      paramString3 = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramString3 = ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ia(paramString3, paramString1);
          if ((((Integer)paramString3.first).intValue() > 0) && (paramString3.second != null))
          {
            paramString3 = (com.tencent.mm.plugin.groupsolitaire.c.a)paramString3.second;
            b.a(paramString1, paramString2, paramString3, paramLong1, false);
            b.a(paramString3, b.a(paramString3, ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(paramString1, paramString3.field_key, true), paramString2, 1), paramLong1, true, paramString2, false, paramLong2);
            b.a(paramLong1, paramString2, paramString3);
          }
          AppMethodBeat.o(194421);
          return;
        }
        catch (Exception paramString1)
        {
          Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage2() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
          AppMethodBeat.o(194421);
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
    AppMethodBeat.i(194419);
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    if (BuildInfo.DEBUG) {
      String.format("processGroupSolitatireMessage() fromUserName:%s toUserName:%s title:%s xml:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    }
    try
    {
      paramString3 = b.au(paramString1, paramString3, paramString4);
      b.a(paramString1, paramString2, paramString3, paramLong1, true);
      b.a(paramString3, b.a(paramString3, ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(paramString1, paramString3.field_key, true), paramString2, 3), paramLong1, false, paramString2, true, paramLong2);
      b.a(paramLong1, paramString2, paramString3);
      AppMethodBeat.o(194419);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage1() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(194419);
    }
  }
  
  public final boolean aBf(String paramString)
  {
    AppMethodBeat.i(110314);
    if ((ab.Ix(paramString)) && ((PluginGroupSolitaire.isSupportGroupSolitaireAnalyze()) || (PluginGroupSolitaire.isSupportGroupSolitaireShow())))
    {
      AppMethodBeat.o(110314);
      return true;
    }
    AppMethodBeat.o(110314);
    return false;
  }
  
  public final boolean aBg(String paramString)
  {
    AppMethodBeat.i(110315);
    if ((ab.Ix(paramString)) && (PluginGroupSolitaire.isSupportGroupSolitaireShow()))
    {
      AppMethodBeat.o(110315);
      return true;
    }
    AppMethodBeat.o(110315);
    return false;
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194420);
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg() fromUserName:%s toUserName:%s msgId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    if (BuildInfo.DEBUG) {
      String.format("processGroupSolitatireMessageByGetMsg() fromUserName:%s toUserName:%s title:%s xml:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    }
    try
    {
      paramString3 = b.au(paramString1, paramString3, paramString4);
      b.a(paramString1, paramString2, paramString3, paramLong1, true);
      paramString1 = ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(paramString1, paramString3.field_key, true);
      if ((paramString1 != null) && (paramString1.field_lastActiveTime > paramLong2))
      {
        Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "from getRoom % < %s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramString1.field_lastActiveTime) });
        AppMethodBeat.o(194420);
        return;
      }
      b.a(paramString3, b.a(paramString3, paramString1, paramString2, 3), paramLong1, false, paramString2, true, true, paramLong2);
      b.a(paramLong1, paramString2, paramString3);
      AppMethodBeat.o(194420);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(194420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.a.a
 * JD-Core Version:    0.7.0.1
 */