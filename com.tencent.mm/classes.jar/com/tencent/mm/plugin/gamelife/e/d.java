package com.tencent.mm.plugin.gamelife.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeConversationService;", "()V", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "deleteConversationBySessionId", "", "getConversations", "offset", "", "nextCount", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeConversationService$ConversationCallback;", "getEditing", "getGameLifeConversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "getLatestUnReadConversationInfo", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationInfo;", "getTotalUnreadCount", "getUnreadCount", "removeOnStorageChange", "setEditing", "content", "startChatting", "context", "Landroid/content/Context;", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "Companion", "plugin-gamelife_release"})
public final class d
  implements com.tencent.mm.plugin.gamelife.a.c
{
  public static final d.a DhF;
  
  static
  {
    AppMethodBeat.i(204536);
    DhF = new d.a((byte)0);
    AppMethodBeat.o(204536);
  }
  
  public final void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(204534);
    p.k(paramContext, "context");
    p.k(parama, "conversation");
    ((com.tencent.mm.plugin.gamelife.a.d)h.ae(com.tencent.mm.plugin.gamelife.a.d.class)).eAl();
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_Self", parama.field_selfUserName);
    localIntent.putExtra("Chat_User", parama.field_sessionId);
    localIntent.putExtra("finish_direct", true);
    com.tencent.mm.by.c.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKF(parama.field_talker);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKF(parama.field_selfUserName);
    AppMethodBeat.o(204534);
  }
  
  public final void a(com.tencent.mm.plugin.gamelife.a.c.a parama)
  {
    AppMethodBeat.i(204532);
    c.a locala = c.DhC;
    c.a.a(0, 15, (m)new d.b(parama));
    AppMethodBeat.o(204532);
  }
  
  public final String aEB(String paramString)
  {
    AppMethodBeat.i(204517);
    Object localObject = com.tencent.mm.plugin.gamelife.b.DeG;
    if (!b.a.aKC(paramString))
    {
      AppMethodBeat.o(204517);
      return "";
    }
    localObject = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.iCn();
    }
    localObject = ((e)localObject).aKN(paramString).field_editingMsg;
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    AppMethodBeat.o(204517);
    return paramString;
  }
  
  public final void aEy(String paramString)
  {
    AppMethodBeat.i(204512);
    Object localObject = com.tencent.mm.plugin.gamelife.b.DeG;
    if (!b.a.aKC(paramString))
    {
      AppMethodBeat.o(204512);
      return;
    }
    localObject = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.iCn();
    }
    ((e)localObject).aEI(paramString);
    AppMethodBeat.o(204512);
  }
  
  public final int aEz(String paramString)
  {
    AppMethodBeat.i(204515);
    Object localObject = com.tencent.mm.plugin.gamelife.b.DeG;
    if (!b.a.aKC(paramString))
    {
      AppMethodBeat.o(204515);
      return 0;
    }
    localObject = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
    if (paramString == null) {
      p.iCn();
    }
    int i = ((e)localObject).aEz(paramString);
    AppMethodBeat.o(204515);
    return i;
  }
  
  public final boolean aKG(String paramString)
  {
    AppMethodBeat.i(204524);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204524);
      return false;
    }
    localObject = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
    paramString = ((e)localObject).aKN(paramString);
    boolean bool = ((e)localObject).deleteNotify(paramString.systemRowid, false);
    ((e)localObject).doNotify("single", 3, paramString);
    AppMethodBeat.o(204524);
    return bool;
  }
  
  public final int eAi()
  {
    AppMethodBeat.i(204513);
    int i = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage().eAi();
    AppMethodBeat.o(204513);
    return i;
  }
  
  public final b eAj()
  {
    AppMethodBeat.i(204530);
    Object localObject1 = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage().eAt();
    long l;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      l = ((a)localObject1).field_lastMsgID;
      if (localObject1 == null) {
        break label180;
      }
      localObject2 = (CharSequence)((a)localObject1).field_talker;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label165;
      }
      i = 1;
      label64:
      if (i == 0) {
        break label170;
      }
      localObject1 = "@gamelifehistory";
    }
    for (;;)
    {
      localObject2 = h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      i = ((f)localObject2).aHp().getInt(ar.a.Vrn, 0);
      localObject2 = h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      localObject1 = new b((String)localObject1, l, ((f)localObject2).aHp().a(ar.a.Vro, ""), i);
      Log.i("GameLife.ConversationService", "getLatestConversationInfo: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(204530);
      return localObject1;
      l = 0L;
      break;
      label165:
      i = 0;
      break label64;
      label170:
      localObject1 = ((a)localObject1).field_talker;
      continue;
      label180:
      localObject1 = null;
    }
  }
  
  public final e eAk()
  {
    AppMethodBeat.i(204526);
    e locale = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
    AppMethodBeat.o(204526);
    return locale;
  }
  
  public final boolean hk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204520);
    Object localObject = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
    if (paramString1 == null) {
      p.iCn();
    }
    localObject = ((e)localObject).aKN(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((a)localObject).field_editingMsg = paramString1;
    boolean bool = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage().updateNotify((IAutoDBItem)localObject, false, new String[0]);
    AppMethodBeat.o(204520);
    return bool;
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(204521);
    p.k(paramIOnStorageChange, "storageChange");
    ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage().remove(paramIOnStorageChange);
    AppMethodBeat.o(204521);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(204522);
    p.k(paramIOnStorageChange, "storageChange");
    ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage().add(paramIOnStorageChange);
    AppMethodBeat.o(204522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.d
 * JD-Core Version:    0.7.0.1
 */