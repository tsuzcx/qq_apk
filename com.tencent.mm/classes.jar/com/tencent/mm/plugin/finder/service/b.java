package com.tencent.mm.plugin.finder.service;

import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.storage.f;
import com.tencent.mm.plugin.findersdk.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderConversationService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderConversationService;", "()V", "notifySerial", "Lcom/tencent/threadpool/serial/Serial;", "kotlin.jvm.PlatformType", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "getEditing", "getUnreadCount", "", "isTopPlace", "", "removeOnStorageChange", "setEditing", "content", "setTopPlace", "plugin-finder_release"})
public final class b
  implements n
{
  private final a Adl;
  
  public b()
  {
    AppMethodBeat.i(273497);
    this.Adl = a.bDn("FinderConversationNotify");
    AppMethodBeat.o(273497);
  }
  
  public final boolean aEA(String paramString)
  {
    AppMethodBeat.i(273490);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(273490);
      return false;
    }
    if (!as.aEF(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(273490);
      throw paramString;
    }
    boolean bool = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().aEG(paramString).dpl();
    AppMethodBeat.o(273490);
    return bool;
  }
  
  public final String aEB(String paramString)
  {
    AppMethodBeat.i(273492);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(273492);
      return "";
    }
    if (!as.aEF(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(273492);
      throw paramString;
    }
    localObject = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().aEG(paramString).field_editingMsg;
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    AppMethodBeat.o(273492);
    return paramString;
  }
  
  public final void aEy(String paramString)
  {
    AppMethodBeat.i(273488);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(273488);
      return;
    }
    if (!as.aEF(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(273488);
      throw paramString;
    }
    ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().aEI(paramString);
    AppMethodBeat.o(273488);
  }
  
  public final int aEz(String paramString)
  {
    AppMethodBeat.i(273489);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(273489);
      return 0;
    }
    if (!as.aEF(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(273489);
      throw paramString;
    }
    i = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().aEz(paramString);
    AppMethodBeat.o(273489);
    return i;
  }
  
  public final boolean by(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(273494);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(273494);
      return false;
    }
    if (!as.aEF(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(273494);
      throw paramString;
    }
    ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().by(paramString, paramBoolean);
    AppMethodBeat.o(273494);
    return false;
  }
  
  public final boolean hk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(273493);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(273493);
      return false;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(273493);
      return false;
    }
    if (!as.aEF(paramString1))
    {
      paramString1 = (Throwable)new RuntimeException("sessionId[" + paramString1 + "] is not session");
      AppMethodBeat.o(273493);
      throw paramString1;
    }
    localObject = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage();
    p.k(paramString1, "sessionId");
    p.k(paramString2, "editing");
    d locald = ((f)localObject).aEG(paramString1);
    locald.field_editingMsg = paramString2;
    boolean bool = ((f)localObject).update(locald.systemRowid, (IAutoDBItem)locald, false);
    ((f)localObject).doNotify(locald.field_sessionId, 7, locald);
    Log.i("Finder.ConversationStorage", "[setTopPlace] ret=" + bool + " editing=" + paramString2 + " sessionId=" + paramString1);
    AppMethodBeat.o(273493);
    return bool;
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(273496);
    if (paramIOnStorageChange != null)
    {
      ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().remove(paramIOnStorageChange);
      AppMethodBeat.o(273496);
      return;
    }
    AppMethodBeat.o(273496);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(273495);
    if (paramIOnStorageChange != null)
    {
      ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().add(this.Adl, paramIOnStorageChange);
      AppMethodBeat.o(273495);
      return;
    }
    AppMethodBeat.o(273495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.b
 * JD-Core Version:    0.7.0.1
 */