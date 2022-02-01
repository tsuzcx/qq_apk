package com.tencent.mm.plugin.finder.service;

import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/service/FinderConversationService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderConversationService;", "()V", "notifySerial", "Lcom/tencent/threadpool/serial/Serial;", "kotlin.jvm.PlatformType", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "getEditing", "getUnreadCount", "", "isTopPlace", "", "removeOnStorageChange", "setEditing", "content", "setTopPlace", "plugin-finder_release"})
public final class b
  implements com.tencent.mm.plugin.i.a.g
{
  private final a sEq;
  
  public b()
  {
    AppMethodBeat.i(204071);
    this.sEq = a.bbi("FinderConversationNotify");
    AppMethodBeat.o(204071);
  }
  
  public final void ajb(String paramString)
  {
    AppMethodBeat.i(204063);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204063);
      return;
    }
    if (!an.aji(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(204063);
      throw paramString;
    }
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().ajp(paramString);
    AppMethodBeat.o(204063);
  }
  
  public final int ajc(String paramString)
  {
    AppMethodBeat.i(204064);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204064);
      return 0;
    }
    if (!an.aji(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(204064);
      throw paramString;
    }
    i = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().ajc(paramString);
    AppMethodBeat.o(204064);
    return i;
  }
  
  public final boolean ajd(String paramString)
  {
    AppMethodBeat.i(204065);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204065);
      return false;
    }
    if (!an.aji(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(204065);
      throw paramString;
    }
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().ajn(paramString).cAw();
    AppMethodBeat.o(204065);
    return bool;
  }
  
  public final String aje(String paramString)
  {
    AppMethodBeat.i(204066);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204066);
      return "";
    }
    if (!an.aji(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(204066);
      throw paramString;
    }
    localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().ajn(paramString).field_editingMsg;
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    AppMethodBeat.o(204066);
    return paramString;
  }
  
  public final boolean bh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(204068);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204068);
      return false;
    }
    if (!an.aji(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(204068);
      throw paramString;
    }
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().bh(paramString, paramBoolean);
    AppMethodBeat.o(204068);
    return false;
  }
  
  public final boolean gt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204067);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204067);
      return false;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(204067);
      return false;
    }
    if (!an.aji(paramString1))
    {
      paramString1 = (Throwable)new RuntimeException("sessionId[" + paramString1 + "] is not session");
      AppMethodBeat.o(204067);
      throw paramString1;
    }
    localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage();
    p.h(paramString1, "sessionId");
    p.h(paramString2, "editing");
    com.tencent.mm.plugin.finder.conv.c localc = ((d)localObject).ajn(paramString1);
    localc.field_editingMsg = paramString2;
    boolean bool = ((d)localObject).update(localc.systemRowid, (com.tencent.mm.sdk.e.c)localc, false);
    ((d)localObject).doNotify(localc.field_sessionId, 7, localc);
    ae.i("Finder.ConversationStorage", "[setTopPlace] ret=" + bool + " editing=" + paramString2 + " sessionId=" + paramString1);
    AppMethodBeat.o(204067);
    return bool;
  }
  
  public final void l(k.a parama)
  {
    AppMethodBeat.i(204070);
    if (parama != null)
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().remove(parama);
      AppMethodBeat.o(204070);
      return;
    }
    AppMethodBeat.o(204070);
  }
  
  public final void m(k.a parama)
  {
    AppMethodBeat.i(204069);
    if (parama != null)
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().add(this.sEq, parama);
      AppMethodBeat.o(204069);
      return;
    }
    AppMethodBeat.o(204069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.b
 * JD-Core Version:    0.7.0.1
 */