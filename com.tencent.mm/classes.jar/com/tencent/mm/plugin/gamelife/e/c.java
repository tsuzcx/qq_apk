package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeConversationService;", "()V", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "deleteConversationBySessionId", "", "getGameLifeConversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "getLatestConversationMsgId", "", "getLatestConversationTalker", "getTotalUnreadCount", "", "getUnreadCount", "removeOnStorageChange", "Companion", "plugin-gamelife_release"})
public final class c
  implements com.tencent.mm.plugin.gamelife.a.c
{
  public static final a uyg;
  
  static
  {
    AppMethodBeat.i(211348);
    uyg = new a((byte)0);
    AppMethodBeat.o(211348);
  }
  
  public final void aie(String paramString)
  {
    AppMethodBeat.i(211339);
    Object localObject = b.uwo;
    if (!b.a.amz(paramString))
    {
      AppMethodBeat.o(211339);
      return;
    }
    localObject = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.gfZ();
    }
    ((d)localObject).ais(paramString);
    AppMethodBeat.o(211339);
  }
  
  public final int aif(String paramString)
  {
    AppMethodBeat.i(211341);
    Object localObject = b.uwo;
    if (!b.a.amz(paramString))
    {
      AppMethodBeat.o(211341);
      return 0;
    }
    localObject = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.gfZ();
    }
    int i = ((d)localObject).aif(paramString);
    AppMethodBeat.o(211341);
    return i;
  }
  
  public final boolean amB(String paramString)
  {
    AppMethodBeat.i(211345);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(211345);
      return false;
    }
    localObject = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage();
    paramString = ((d)localObject).amG(paramString);
    boolean bool = ((d)localObject).deleteNotify(paramString.systemRowid, false);
    ((d)localObject).doNotify("single", 3, paramString);
    AppMethodBeat.o(211345);
    return bool;
  }
  
  public final int daD()
  {
    AppMethodBeat.i(211340);
    int i = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().daD();
    AppMethodBeat.o(211340);
    return i;
  }
  
  public final String daE()
  {
    AppMethodBeat.i(211344);
    Object localObject = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().daJ();
    int i;
    if (localObject != null)
    {
      CharSequence localCharSequence = (CharSequence)((a)localObject).field_talker;
      if ((localCharSequence == null) || (localCharSequence.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label80;
        }
        localObject = "@gamelifehistory";
      }
    }
    for (;;)
    {
      ad.i("GameLife.ConversationService", "getLatestConversationTalker: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(211344);
      return localObject;
      i = 0;
      break;
      label80:
      localObject = ((a)localObject).field_talker;
      continue;
      localObject = null;
    }
  }
  
  public final long daF()
  {
    AppMethodBeat.i(211347);
    a locala = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().daJ();
    if (locala != null) {}
    for (long l = locala.field_lastMsgID;; l = 0L)
    {
      ad.i("GameLife.ConversationService", "getLatestConversationMsgId: ".concat(String.valueOf(l)));
      AppMethodBeat.o(211347);
      return l;
    }
  }
  
  public final d daG()
  {
    AppMethodBeat.i(211346);
    d locald = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage();
    AppMethodBeat.o(211346);
    return locald;
  }
  
  public final void l(k.a parama)
  {
    AppMethodBeat.i(211342);
    p.h(parama, "storageChange");
    ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().remove(parama);
    AppMethodBeat.o(211342);
  }
  
  public final void m(k.a parama)
  {
    AppMethodBeat.i(211343);
    p.h(parama, "storageChange");
    ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().add(parama);
    AppMethodBeat.o(211343);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationService$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.c
 * JD-Core Version:    0.7.0.1
 */