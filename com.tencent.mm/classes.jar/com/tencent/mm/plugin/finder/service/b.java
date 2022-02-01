package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.au;
import com.tencent.threadpool.j.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderConversationService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderConversationService;", "()V", "notifySerial", "Lcom/tencent/threadpool/serial/Serial;", "kotlin.jvm.PlatformType", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "getEditing", "getUnreadCount", "", "isTopPlace", "", "removeOnStorageChange", "setEditing", "content", "setTopPlace", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements z
{
  private final a FyV;
  
  public b()
  {
    AppMethodBeat.i(330054);
    this.FyV = a.bFV("FinderConversationNotify");
    AppMethodBeat.o(330054);
  }
  
  public final void aAr(String paramString)
  {
    AppMethodBeat.i(330068);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(330068);
      return;
    }
    if (!au.aAy(paramString))
    {
      paramString = new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(330068);
      throw paramString;
    }
    ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage().aAB(paramString);
    AppMethodBeat.o(330068);
  }
  
  public final int aAs(String paramString)
  {
    AppMethodBeat.i(330077);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(330077);
      return 0;
    }
    if (!au.aAy(paramString))
    {
      paramString = new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(330077);
      throw paramString;
    }
    i = ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage().aAs(paramString);
    AppMethodBeat.o(330077);
    return i;
  }
  
  public final boolean aAt(String paramString)
  {
    AppMethodBeat.i(330088);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(330088);
      return false;
    }
    if (!au.aAy(paramString))
    {
      paramString = new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(330088);
      throw paramString;
    }
    boolean bool = ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage().aAz(paramString).dWN();
    AppMethodBeat.o(330088);
    return bool;
  }
  
  public final String aAu(String paramString)
  {
    AppMethodBeat.i(330101);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(330101);
      return "";
    }
    if (!au.aAy(paramString))
    {
      paramString = new RuntimeException("sessionId[" + paramString + "] is not session");
      AppMethodBeat.o(330101);
      throw paramString;
    }
    paramString = ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage().aAz(paramString).field_editingMsg;
    if (paramString == null)
    {
      AppMethodBeat.o(330101);
      return "";
    }
    AppMethodBeat.o(330101);
    return paramString;
  }
  
  public final boolean ie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(330153);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(330153);
      return false;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(330153);
      return false;
    }
    if (!au.aAy(paramString1))
    {
      paramString1 = new RuntimeException("sessionId[" + paramString1 + "] is not session");
      AppMethodBeat.o(330153);
      throw paramString1;
    }
    localObject = ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage();
    s.u(paramString1, "sessionId");
    s.u(paramString2, "editing");
    com.tencent.mm.plugin.finder.conv.b localb = ((g)localObject).aAz(paramString1);
    localb.field_editingMsg = paramString2;
    boolean bool = ((g)localObject).update(localb.systemRowid, (IAutoDBItem)localb, false);
    ((g)localObject).doNotify(localb.field_sessionId, 7, localb);
    Log.i("Finder.ConversationStorage", "[setTopPlace] ret=" + bool + " editing=" + paramString2 + " sessionId=" + paramString1);
    AppMethodBeat.o(330153);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.b
 * JD-Core Version:    0.7.0.1
 */