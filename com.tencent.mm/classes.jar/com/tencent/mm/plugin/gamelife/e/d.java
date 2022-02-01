package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeConversationService;", "()V", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "deleteConversationBySessionId", "", "getEditing", "getGameLifeConversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "getLatestUnReadConversationInfo", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationInfo;", "getTotalUnreadCount", "", "getUnreadCount", "removeOnStorageChange", "setEditing", "content", "Companion", "plugin-gamelife_release"})
public final class d
  implements c
{
  public static final d.a yca;
  
  static
  {
    AppMethodBeat.i(241362);
    yca = new d.a((byte)0);
    AppMethodBeat.o(241362);
  }
  
  public final boolean aAT(String paramString)
  {
    AppMethodBeat.i(241359);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(241359);
      return false;
    }
    localObject = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage();
    paramString = ((e)localObject).aBa(paramString);
    boolean bool = ((e)localObject).deleteNotify(paramString.systemRowid, false);
    ((e)localObject).doNotify("single", 3, paramString);
    AppMethodBeat.o(241359);
    return bool;
  }
  
  public final void ave(String paramString)
  {
    AppMethodBeat.i(241352);
    Object localObject = com.tencent.mm.plugin.gamelife.b.xZZ;
    if (!b.a.aAQ(paramString))
    {
      AppMethodBeat.o(241352);
      return;
    }
    localObject = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.hyc();
    }
    ((e)localObject).avs(paramString);
    AppMethodBeat.o(241352);
  }
  
  public final int avf(String paramString)
  {
    AppMethodBeat.i(241354);
    Object localObject = com.tencent.mm.plugin.gamelife.b.xZZ;
    if (!b.a.aAQ(paramString))
    {
      AppMethodBeat.o(241354);
      return 0;
    }
    localObject = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.hyc();
    }
    int i = ((e)localObject).avf(paramString);
    AppMethodBeat.o(241354);
    return i;
  }
  
  public final String avh(String paramString)
  {
    AppMethodBeat.i(241355);
    Object localObject = com.tencent.mm.plugin.gamelife.b.xZZ;
    if (!b.a.aAQ(paramString))
    {
      AppMethodBeat.o(241355);
      return "";
    }
    localObject = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.hyc();
    }
    localObject = ((e)localObject).aBa(paramString).field_editingMsg;
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    AppMethodBeat.o(241355);
    return paramString;
  }
  
  public final int dWZ()
  {
    AppMethodBeat.i(241353);
    int i = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage().dWZ();
    AppMethodBeat.o(241353);
    return i;
  }
  
  public final b dXa()
  {
    AppMethodBeat.i(241361);
    Object localObject1 = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage().dXk();
    long l;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      l = ((a)localObject1).field_lastMsgID;
      if (localObject1 == null) {
        break label178;
      }
      localObject2 = (CharSequence)((a)localObject1).field_talker;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label163;
      }
      i = 1;
      label64:
      if (i == 0) {
        break label168;
      }
      localObject1 = "@gamelifehistory";
    }
    for (;;)
    {
      localObject2 = g.aAh();
      p.g(localObject2, "MMKernel.storage()");
      i = ((com.tencent.mm.kernel.e)localObject2).azQ().getInt(ar.a.Odg, 0);
      localObject2 = g.aAh();
      p.g(localObject2, "MMKernel.storage()");
      localObject1 = new b((String)localObject1, l, ((com.tencent.mm.kernel.e)localObject2).azQ().a(ar.a.Odh, ""), i);
      Log.i("GameLife.ConversationService", "getLatestConversationInfo: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(241361);
      return localObject1;
      l = 0L;
      break;
      label163:
      i = 0;
      break label64;
      label168:
      localObject1 = ((a)localObject1).field_talker;
      continue;
      label178:
      localObject1 = null;
    }
  }
  
  public final e dXb()
  {
    AppMethodBeat.i(241360);
    e locale = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage();
    AppMethodBeat.o(241360);
    return locale;
  }
  
  public final boolean gT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241356);
    Object localObject = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage();
    if (paramString1 == null) {
      p.hyc();
    }
    localObject = ((e)localObject).aBa(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((a)localObject).field_editingMsg = paramString1;
    boolean bool = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage().updateNotify((IAutoDBItem)localObject, false, new String[0]);
    AppMethodBeat.o(241356);
    return bool;
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(241357);
    p.h(paramIOnStorageChange, "storageChange");
    ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage().remove(paramIOnStorageChange);
    AppMethodBeat.o(241357);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(241358);
    p.h(paramIOnStorageChange, "storageChange");
    ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage().add(paramIOnStorageChange);
    AppMethodBeat.o(241358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.d
 * JD-Core Version:    0.7.0.1
 */