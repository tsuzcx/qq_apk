package com.tencent.mm.plugin.groupsolitaire.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;

public final class a
  implements i
{
  public final void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(110313);
    a(paramString1, paramString2, paramString3, paramLong, ce.azK());
    AppMethodBeat.o(110313);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192987);
    ac.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s ", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    try
    {
      String str = ((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Xw(paramString3);
      paramString3 = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramString3 = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().ha(paramString3, paramString1);
          if ((((Integer)paramString3.first).intValue() > 0) && (paramString3.second != null))
          {
            paramString3 = (com.tencent.mm.plugin.groupsolitaire.c.a)paramString3.second;
            b.a(paramString1, paramString2, paramString3, paramLong1, false);
            b.a(paramString3, b.a(paramString3, ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(paramString1, paramString3.field_key, true), paramString2, 1), paramLong1, true, paramString2, false, paramLong2);
            b.a(paramLong1, paramString2, paramString3);
          }
          AppMethodBeat.o(192987);
          return;
        }
        catch (Exception paramString1)
        {
          ac.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage2() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
          AppMethodBeat.o(192987);
        }
        localException = localException;
        ac.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    if (h.DEBUG) {
      String.format("processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s content:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1), paramString3 });
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192985);
    ac.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    if (h.DEBUG) {
      String.format("processGroupSolitatireMessage() fromUserName:%s toUserName:%s title:%s xml:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    }
    try
    {
      paramString3 = b.af(paramString1, paramString3, paramString4);
      b.a(paramString1, paramString2, paramString3, paramLong1, true);
      b.a(paramString3, b.a(paramString3, ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(paramString1, paramString3.field_key, true), paramString2, 3), paramLong1, false, paramString2, true, paramLong2);
      b.a(paramLong1, paramString2, paramString3);
      AppMethodBeat.o(192985);
      return;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage1() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(192985);
    }
  }
  
  public final boolean ahY(String paramString)
  {
    AppMethodBeat.i(110314);
    if ((w.wp(paramString)) && ((PluginGroupSolitaire.isSupportGroupSolitaireAnalyze()) || (PluginGroupSolitaire.isSupportGroupSolitaireShow())))
    {
      AppMethodBeat.o(110314);
      return true;
    }
    AppMethodBeat.o(110314);
    return false;
  }
  
  public final boolean ahZ(String paramString)
  {
    AppMethodBeat.i(110315);
    if ((w.wp(paramString)) && (PluginGroupSolitaire.isSupportGroupSolitaireShow()))
    {
      AppMethodBeat.o(110315);
      return true;
    }
    AppMethodBeat.o(110315);
    return false;
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192986);
    ac.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg() fromUserName:%s toUserName:%s msgId:%s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong1) });
    if (h.DEBUG) {
      String.format("processGroupSolitatireMessageByGetMsg() fromUserName:%s toUserName:%s title:%s xml:%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    }
    try
    {
      paramString3 = b.af(paramString1, paramString3, paramString4);
      b.a(paramString1, paramString2, paramString3, paramLong1, true);
      paramString1 = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(paramString1, paramString3.field_key, true);
      if ((paramString1 != null) && (paramString1.field_lastActiveTime > paramLong2))
      {
        ac.i("MicroMsg.groupsolitaire.GroupSolitaireService", "from getRoom % < %s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramString1.field_lastActiveTime) });
        AppMethodBeat.o(192986);
        return;
      }
      b.a(paramString3, b.a(paramString3, paramString1, paramString2, 3), paramLong1, false, paramString2, true, true, paramLong2);
      b.a(paramLong1, paramString2, paramString3);
      AppMethodBeat.o(192986);
      return;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg() Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(192986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.a.a
 * JD-Core Version:    0.7.0.1
 */