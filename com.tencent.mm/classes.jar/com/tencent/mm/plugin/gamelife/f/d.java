package com.tencent.mm.plugin.gamelife.f;

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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeConversationService;", "()V", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "deleteConversationBySessionId", "", "getConversations", "offset", "", "nextCount", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeConversationService$ConversationCallback;", "getEditing", "getGameLifeConversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "getLatestUnReadConversationInfo", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationInfo;", "getTotalUnreadCount", "getUnreadCount", "removeOnStorageChange", "setEditing", "content", "startChatting", "context", "Landroid/content/Context;", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.plugin.gamelife.a.c
{
  public static final d.a Jbu;
  
  static
  {
    AppMethodBeat.i(268131);
    Jbu = new d.a((byte)0);
    AppMethodBeat.o(268131);
  }
  
  public final void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(268243);
    s.u(paramContext, "context");
    s.u(parama, "conversation");
    ((com.tencent.mm.plugin.gamelife.a.d)h.ax(com.tencent.mm.plugin.gamelife.a.d.class)).fIl();
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_Self", parama.field_selfUserName);
    localIntent.putExtra("Chat_User", parama.field_sessionId);
    localIntent.putExtra("finish_direct", true);
    com.tencent.mm.br.c.g(paramContext, ".ui.chatting.ChattingUI", localIntent);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHv(parama.field_talker);
    ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHv(parama.field_selfUserName);
    AppMethodBeat.o(268243);
  }
  
  public final void a(com.tencent.mm.plugin.gamelife.a.c.a parama)
  {
    AppMethodBeat.i(268239);
    c.a locala = c.Jbt;
    c.a.a(0, 15, (m)new d.b(parama));
    AppMethodBeat.o(268239);
  }
  
  public final void aAr(String paramString)
  {
    AppMethodBeat.i(268137);
    Object localObject = com.tencent.mm.plugin.gamelife.b.IYX;
    if (!b.a.aHt(paramString))
    {
      AppMethodBeat.o(268137);
      return;
    }
    localObject = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
    s.checkNotNull(paramString);
    ((e)localObject).aAB(paramString);
    AppMethodBeat.o(268137);
  }
  
  public final int aAs(String paramString)
  {
    AppMethodBeat.i(268156);
    Object localObject = com.tencent.mm.plugin.gamelife.b.IYX;
    if (!b.a.aHt(paramString))
    {
      AppMethodBeat.o(268156);
      return 0;
    }
    localObject = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
    s.checkNotNull(paramString);
    int i = ((e)localObject).aAs(paramString);
    AppMethodBeat.o(268156);
    return i;
  }
  
  public final String aAu(String paramString)
  {
    AppMethodBeat.i(268167);
    Object localObject = com.tencent.mm.plugin.gamelife.b.IYX;
    if (!b.a.aHt(paramString))
    {
      AppMethodBeat.o(268167);
      return "";
    }
    localObject = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
    s.checkNotNull(paramString);
    paramString = ((e)localObject).aHD(paramString).field_editingMsg;
    if (paramString == null)
    {
      AppMethodBeat.o(268167);
      return "";
    }
    AppMethodBeat.o(268167);
    return paramString;
  }
  
  public final boolean aHw(String paramString)
  {
    AppMethodBeat.i(268212);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(268212);
      return false;
    }
    localObject = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
    paramString = ((e)localObject).aHD(paramString);
    boolean bool = ((e)localObject).deleteNotify(paramString.systemRowid, false);
    ((e)localObject).doNotify("single", 3, paramString);
    AppMethodBeat.o(268212);
    return bool;
  }
  
  public final int fIi()
  {
    AppMethodBeat.i(268145);
    int i = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage().fIi();
    AppMethodBeat.o(268145);
    return i;
  }
  
  public final b fIj()
  {
    AppMethodBeat.i(268234);
    Object localObject = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage().fIt();
    long l;
    if (localObject == null)
    {
      l = 0L;
      if (localObject != null) {
        break label108;
      }
      localObject = null;
    }
    for (;;)
    {
      int i = h.baE().ban().getInt(at.a.acSP, 0);
      localObject = new b((String)localObject, l, h.baE().ban().b(at.a.acSQ, ""), i);
      Log.i("GameLife.ConversationService", s.X("getLatestConversationInfo: ", localObject));
      AppMethodBeat.o(268234);
      return localObject;
      l = ((a)localObject).field_lastMsgID;
      break;
      label108:
      CharSequence localCharSequence = (CharSequence)((a)localObject).field_talker;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label152;
        }
        localObject = "@gamelifehistory";
        break;
      }
      label152:
      localObject = ((a)localObject).field_talker;
    }
  }
  
  public final e fIk()
  {
    AppMethodBeat.i(268222);
    e locale = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
    AppMethodBeat.o(268222);
    return locale;
  }
  
  public final boolean ie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(268180);
    Object localObject = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
    s.checkNotNull(paramString1);
    localObject = ((e)localObject).aHD(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((a)localObject).field_editingMsg = paramString1;
    boolean bool = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage().updateNotify((IAutoDBItem)localObject, false, new String[0]);
    AppMethodBeat.o(268180);
    return bool;
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(268188);
    s.u(paramIOnStorageChange, "storageChange");
    ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage().remove(paramIOnStorageChange);
    AppMethodBeat.o(268188);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(268198);
    s.u(paramIOnStorageChange, "storageChange");
    ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage().add(paramIOnStorageChange);
    AppMethodBeat.o(268198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.d
 * JD-Core Version:    0.7.0.1
 */