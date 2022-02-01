package com.tencent.mm.plugin.finder.service;

import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/service/FinderConversationService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderConversationService;", "()V", "notifySerial", "Lcom/tencent/threadpool/serial/Serial;", "kotlin.jvm.PlatformType", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "getEditing", "getUnreadCount", "", "isTopPlace", "", "removeOnStorageChange", "setEditing", "content", "setTopPlace", "plugin-finder_release"})
public final class b
  implements com.tencent.mm.plugin.i.a.g
{
  private final a suf;
  
  public b()
  {
    AppMethodBeat.i(203511);
    this.suf = a.aZF("FinderConversationNotify");
    AppMethodBeat.o(203511);
  }
  
  public final void aie(String paramString)
  {
    AppMethodBeat.i(203503);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203503);
      return;
    }
    if (!am.ail(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(203503);
      throw paramString;
    }
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().ais(paramString);
    AppMethodBeat.o(203503);
  }
  
  public final int aif(String paramString)
  {
    AppMethodBeat.i(203504);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203504);
      return 0;
    }
    if (!am.ail(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(203504);
      throw paramString;
    }
    i = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().aif(paramString);
    AppMethodBeat.o(203504);
    return i;
  }
  
  public final boolean aig(String paramString)
  {
    AppMethodBeat.i(203505);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203505);
      return false;
    }
    if (!am.ail(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(203505);
      throw paramString;
    }
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().aiq(paramString).cyS();
    AppMethodBeat.o(203505);
    return bool;
  }
  
  public final String aih(String paramString)
  {
    AppMethodBeat.i(203506);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203506);
      return "";
    }
    if (!am.ail(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(203506);
      throw paramString;
    }
    localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().aiq(paramString).field_editingMsg;
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    AppMethodBeat.o(203506);
    return paramString;
  }
  
  public final boolean be(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203508);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203508);
      return false;
    }
    if (!am.ail(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(203508);
      throw paramString;
    }
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().be(paramString, paramBoolean);
    AppMethodBeat.o(203508);
    return false;
  }
  
  public final boolean go(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203507);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203507);
      return false;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(203507);
      return false;
    }
    if (!am.ail(paramString1))
    {
      paramString1 = (Throwable)new RuntimeException("sessionId[" + paramString1 + "] is not session");
      AppMethodBeat.o(203507);
      throw paramString1;
    }
    localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage();
    p.h(paramString1, "sessionId");
    p.h(paramString2, "editing");
    com.tencent.mm.plugin.finder.conv.c localc = ((d)localObject).aiq(paramString1);
    localc.field_editingMsg = paramString2;
    boolean bool = ((d)localObject).update(localc.systemRowid, (com.tencent.mm.sdk.e.c)localc, false);
    ((d)localObject).doNotify(localc.field_sessionId, 7, localc);
    ad.i("Finder.ConversationStorage", "[setTopPlace] ret=" + bool + " editing=" + paramString2 + " sessionId=" + paramString1);
    AppMethodBeat.o(203507);
    return bool;
  }
  
  public final void l(k.a parama)
  {
    AppMethodBeat.i(203510);
    if (parama != null)
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().remove(parama);
      AppMethodBeat.o(203510);
      return;
    }
    AppMethodBeat.o(203510);
  }
  
  public final void m(k.a parama)
  {
    AppMethodBeat.i(203509);
    if (parama != null)
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().add(this.suf, parama);
      AppMethodBeat.o(203509);
      return;
    }
    AppMethodBeat.o(203509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.b
 * JD-Core Version:    0.7.0.1
 */