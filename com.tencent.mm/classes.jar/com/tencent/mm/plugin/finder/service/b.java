package com.tencent.mm.plugin.finder.service;

import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/service/FinderConversationService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderConversationService;", "()V", "notifySerial", "Lcom/tencent/threadpool/serial/Serial;", "kotlin.jvm.PlatformType", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "getEditing", "getUnreadCount", "", "isTopPlace", "", "removeOnStorageChange", "setEditing", "content", "setTopPlace", "plugin-finder_release"})
public final class b
  implements n
{
  private final a vvN;
  
  public b()
  {
    AppMethodBeat.i(251450);
    this.vvN = a.bqt("FinderConversationNotify");
    AppMethodBeat.o(251450);
  }
  
  public final void ave(String paramString)
  {
    AppMethodBeat.i(251442);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(251442);
      return;
    }
    if (!as.avl(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(251442);
      throw paramString;
    }
    ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().avs(paramString);
    AppMethodBeat.o(251442);
  }
  
  public final int avf(String paramString)
  {
    AppMethodBeat.i(251443);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(251443);
      return 0;
    }
    if (!as.avl(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(251443);
      throw paramString;
    }
    i = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().avf(paramString);
    AppMethodBeat.o(251443);
    return i;
  }
  
  public final boolean avg(String paramString)
  {
    AppMethodBeat.i(251444);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(251444);
      return false;
    }
    if (!as.avl(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(251444);
      throw paramString;
    }
    boolean bool = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().avq(paramString).cZv();
    AppMethodBeat.o(251444);
    return bool;
  }
  
  public final String avh(String paramString)
  {
    AppMethodBeat.i(251445);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(251445);
      return "";
    }
    if (!as.avl(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(251445);
      throw paramString;
    }
    localObject = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().avq(paramString).field_editingMsg;
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    AppMethodBeat.o(251445);
    return paramString;
  }
  
  public final boolean bt(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(251447);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(251447);
      return false;
    }
    if (!as.avl(paramString))
    {
      paramString = (Throwable)new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(251447);
      throw paramString;
    }
    ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().bt(paramString, paramBoolean);
    AppMethodBeat.o(251447);
    return false;
  }
  
  public final boolean gT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(251446);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(251446);
      return false;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(251446);
      return false;
    }
    if (!as.avl(paramString1))
    {
      paramString1 = (Throwable)new RuntimeException("sessionId[" + paramString1 + "] is not session");
      AppMethodBeat.o(251446);
      throw paramString1;
    }
    localObject = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage();
    p.h(paramString1, "sessionId");
    p.h(paramString2, "editing");
    c localc = ((e)localObject).avq(paramString1);
    localc.field_editingMsg = paramString2;
    boolean bool = ((e)localObject).update(localc.systemRowid, (IAutoDBItem)localc, false);
    ((e)localObject).doNotify(localc.field_sessionId, 7, localc);
    Log.i("Finder.ConversationStorage", "[setTopPlace] ret=" + bool + " editing=" + paramString2 + " sessionId=" + paramString1);
    AppMethodBeat.o(251446);
    return bool;
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(251449);
    if (paramIOnStorageChange != null)
    {
      ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().remove(paramIOnStorageChange);
      AppMethodBeat.o(251449);
      return;
    }
    AppMethodBeat.o(251449);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(251448);
    if (paramIOnStorageChange != null)
    {
      ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().add(this.vvN, paramIOnStorageChange);
      AppMethodBeat.o(251448);
      return;
    }
    AppMethodBeat.o(251448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.b
 * JD-Core Version:    0.7.0.1
 */