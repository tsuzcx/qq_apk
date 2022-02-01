package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
final class b$e
  implements b.c
{
  b$e(List paramList, b.c paramc) {}
  
  public final void ac(Map<String, a> paramMap)
  {
    AppMethodBeat.i(204116);
    StringBuilder localStringBuilder1 = new StringBuilder("[getContact] usernameList=").append(this.nJx).append(" result=");
    p.j(paramMap, "result");
    Collection localCollection = (Collection)new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder2 = new StringBuilder().append((String)((Map.Entry)localObject).getKey()).append('=');
      localObject = ((Map.Entry)localObject).getValue();
      p.j(localObject, "it.value");
      localCollection.add(((a)localObject).getNickname());
    }
    Log.i("GameLife.ContactService", (List)localCollection);
    this.Dhs.ac(paramMap);
    AppMethodBeat.o(204116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.b.e
 * JD-Core Version:    0.7.0.1
 */