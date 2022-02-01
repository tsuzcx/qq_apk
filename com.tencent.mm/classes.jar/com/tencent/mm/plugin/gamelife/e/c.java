package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeConversationService;", "()V", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "deleteConversationBySessionId", "", "getEditing", "getGameLifeConversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "getLatestConversationMsgId", "", "getLatestConversationTalker", "getTotalUnreadCount", "", "getUnreadCount", "removeOnStorageChange", "setEditing", "content", "Companion", "plugin-gamelife_release"})
public final class c
  implements com.tencent.mm.plugin.gamelife.a.c
{
  public static final a uJJ;
  
  static
  {
    AppMethodBeat.i(212119);
    uJJ = new a((byte)0);
    AppMethodBeat.o(212119);
  }
  
  public final void ajb(String paramString)
  {
    AppMethodBeat.i(212108);
    Object localObject = b.uHN;
    if (!b.a.anx(paramString))
    {
      AppMethodBeat.o(212108);
      return;
    }
    localObject = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.gkB();
    }
    ((d)localObject).ajp(paramString);
    AppMethodBeat.o(212108);
  }
  
  public final int ajc(String paramString)
  {
    AppMethodBeat.i(212110);
    Object localObject = b.uHN;
    if (!b.a.anx(paramString))
    {
      AppMethodBeat.o(212110);
      return 0;
    }
    localObject = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.gkB();
    }
    int i = ((d)localObject).ajc(paramString);
    AppMethodBeat.o(212110);
    return i;
  }
  
  public final String aje(String paramString)
  {
    AppMethodBeat.i(212111);
    Object localObject = b.uHN;
    if (!b.a.anx(paramString))
    {
      AppMethodBeat.o(212111);
      return "";
    }
    localObject = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.gkB();
    }
    localObject = ((d)localObject).anH(paramString).field_editingMsg;
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    AppMethodBeat.o(212111);
    return paramString;
  }
  
  public final boolean anA(String paramString)
  {
    AppMethodBeat.i(212116);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(212116);
      return false;
    }
    localObject = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage();
    paramString = ((d)localObject).anH(paramString);
    boolean bool = ((d)localObject).deleteNotify(paramString.systemRowid, false);
    ((d)localObject).doNotify("single", 3, paramString);
    AppMethodBeat.o(212116);
    return bool;
  }
  
  public final int ddp()
  {
    AppMethodBeat.i(212109);
    int i = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().ddp();
    AppMethodBeat.o(212109);
    return i;
  }
  
  public final String ddq()
  {
    AppMethodBeat.i(212115);
    Object localObject = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().ddz();
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
      ae.i("GameLife.ConversationService", "getLatestConversationTalker: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(212115);
      return localObject;
      i = 0;
      break;
      label80:
      localObject = ((a)localObject).field_talker;
      continue;
      localObject = null;
    }
  }
  
  public final long ddr()
  {
    AppMethodBeat.i(212118);
    a locala = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().ddz();
    if (locala != null) {}
    for (long l = locala.field_lastMsgID;; l = 0L)
    {
      ae.i("GameLife.ConversationService", "getLatestConversationMsgId: ".concat(String.valueOf(l)));
      AppMethodBeat.o(212118);
      return l;
    }
  }
  
  public final d dds()
  {
    AppMethodBeat.i(212117);
    d locald = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage();
    AppMethodBeat.o(212117);
    return locald;
  }
  
  public final boolean gt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212112);
    Object localObject = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage();
    if (paramString1 == null) {
      p.gkB();
    }
    localObject = ((d)localObject).anH(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((a)localObject).field_editingMsg = paramString1;
    boolean bool = ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().updateNotify((com.tencent.mm.sdk.e.c)localObject, false, new String[0]);
    AppMethodBeat.o(212112);
    return bool;
  }
  
  public final void l(k.a parama)
  {
    AppMethodBeat.i(212113);
    p.h(parama, "storageChange");
    ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().remove(parama);
    AppMethodBeat.o(212113);
  }
  
  public final void m(k.a parama)
  {
    AppMethodBeat.i(212114);
    p.h(parama, "storageChange");
    ((PluginGameLife)g.ad(PluginGameLife.class)).getConversationStorage().add(parama);
    AppMethodBeat.o(212114);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationService$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.c
 * JD-Core Version:    0.7.0.1
 */