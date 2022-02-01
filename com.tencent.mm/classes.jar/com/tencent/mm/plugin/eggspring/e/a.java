package com.tencent.mm.plugin.eggspring.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/utils/EasterEggBlockList;", "", "()V", "blockList", "Ljava/util/LinkedList;", "", "blockAppId", "", "appId", "filterOutInvalidAppId", "eggList", "Lcom/tencent/mm/modelpackage/EggList;", "isBlocked", "", "saveConfig", "unblockAppId", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final LinkedList<String> lPT;
  public static final a xFF;
  
  static
  {
    AppMethodBeat.i(266510);
    xFF = new a();
    lPT = new LinkedList();
    ??? = h.baE().ban().get(at.a.acYR, null);
    if ((??? instanceof String)) {
      ??? = (String)???;
    }
    for (;;)
    {
      Object localObject2;
      if (??? != null)
      {
        localObject2 = n.b((CharSequence)???, new String[] { "#" });
        if (localObject2 == null) {}
      }
      synchronized (lPT)
      {
        ((LinkedList)???).addAll((Collection)localObject2);
        localObject2 = ah.aiuX;
        AppMethodBeat.o(266510);
        return;
        ??? = null;
      }
    }
  }
  
  public static void anF(String paramString)
  {
    AppMethodBeat.i(266497);
    if (paramString == null)
    {
      AppMethodBeat.o(266497);
      return;
    }
    synchronized (lPT)
    {
      ???.remove(paramString);
      paramString = ah.aiuX;
      dxK();
      AppMethodBeat.o(266497);
      return;
    }
  }
  
  public static boolean anG(String paramString)
  {
    AppMethodBeat.i(266501);
    if (paramString == null)
    {
      AppMethodBeat.o(266501);
      return false;
    }
    boolean bool = lPT.contains(paramString);
    AppMethodBeat.o(266501);
    return bool;
  }
  
  public static void dxK()
  {
    AppMethodBeat.i(266506);
    h.baE().ban().set(at.a.acYR, p.a((Iterable)lPT, (CharSequence)"#", null, null, 0, null, null, 62));
    AppMethodBeat.o(266506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.e.a
 * JD-Core Version:    0.7.0.1
 */