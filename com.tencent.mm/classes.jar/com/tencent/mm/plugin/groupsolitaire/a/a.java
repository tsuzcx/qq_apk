package com.tencent.mm.plugin.groupsolitaire.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;

public final class a
  implements l
{
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(262642);
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage()1 fromUserName:%s toUserName:%s msgId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    if (BuildInfo.DEBUG) {
      Log.d("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() fromUserName:%s toUserName:%s title:%s xml:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    }
    try
    {
      paramString3 = b.ay(paramString1, paramString3, paramString4);
      b.a(paramString1, paramString2, paramString3, paramLong1, true);
      b.a(paramString3, b.a(paramString3, ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().A(paramString1, paramString3.field_key, true), paramString2, 3), paramLong1, false, paramString2, true, paramLong2);
      b.a(paramLong1, paramString2, paramString3);
      AppMethodBeat.o(262642);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage1() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(262642);
    }
  }
  
  public final boolean aHK(String paramString)
  {
    AppMethodBeat.i(110314);
    if ((au.bwG(paramString)) && ((PluginGroupSolitaire.isSupportGroupSolitaireAnalyze()) || (PluginGroupSolitaire.isSupportGroupSolitaireShow())))
    {
      AppMethodBeat.o(110314);
      return true;
    }
    AppMethodBeat.o(110314);
    return false;
  }
  
  public final boolean aHL(String paramString)
  {
    AppMethodBeat.i(110315);
    if ((au.bwG(paramString)) && (PluginGroupSolitaire.isSupportGroupSolitaireShow()))
    {
      AppMethodBeat.o(110315);
      return true;
    }
    AppMethodBeat.o(110315);
    return false;
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(110313);
    b(paramString1, paramString2, paramString3, paramLong, cn.getSyncServerTimeSecond());
    AppMethodBeat.o(110313);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(262646);
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage()3 fromUserName:%s toUserName:%s msgId:%s ", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    try
    {
      String str = ((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).anH(paramString3);
      paramString3 = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramString3 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().jq(paramString3, paramString1);
          if ((((Integer)paramString3.first).intValue() > 0) && (paramString3.second != null))
          {
            paramString3 = (com.tencent.mm.plugin.groupsolitaire.c.a)paramString3.second;
            b.a(paramString1, paramString2, paramString3, paramLong1, false);
            b.a(paramString3, b.a(paramString3, ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().A(paramString1, paramString3.field_key, true), paramString2, 1), paramLong1, true, paramString2, false, paramLong2);
            b.a(paramLong1, paramString2, paramString3);
          }
          AppMethodBeat.o(262646);
          return;
        }
        catch (Exception paramString1)
        {
          Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage2() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
          AppMethodBeat.o(262646);
        }
        localException = localException;
        Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    if (BuildInfo.DEBUG) {
      Log.d("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s content:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1), paramString3 });
    }
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(262644);
    Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg()2 fromUserName:%s toUserName:%s msgId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    if (BuildInfo.DEBUG) {
      Log.d("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg() fromUserName:%s toUserName:%s title:%s xml:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    }
    try
    {
      paramString3 = b.ay(paramString1, paramString3, paramString4);
      b.a(paramString1, paramString2, paramString3, paramLong1, true);
      paramString1 = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().A(paramString1, paramString3.field_key, true);
      if ((paramString1 != null) && (paramString1.field_lastActiveTime > paramLong2))
      {
        Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "from getRoom % < %s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramString1.field_lastActiveTime) });
        AppMethodBeat.o(262644);
        return;
      }
      b.a(paramString3, b.a(paramString3, paramString1, paramString2, 3), paramLong1, false, paramString2, true, true, paramLong2);
      b.a(paramLong1, paramString2, paramString3);
      AppMethodBeat.o(262644);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(262644);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.a.a
 * JD-Core Version:    0.7.0.1
 */