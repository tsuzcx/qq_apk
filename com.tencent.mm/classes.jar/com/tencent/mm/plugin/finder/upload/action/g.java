package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;", "", "()V", "recordList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "recordSet", "", "getRecordSet", "()Ljava/util/Set;", "clear", "", "contains", "", "finderUserName", "isEmpty", "isNotEmpty", "record", "isClean", "toString", "plugin-finder_release"})
public final class g
{
  public final Set<String> ABW;
  
  public g()
  {
    AppMethodBeat.i(272470);
    Set localSet = Collections.synchronizedSet((Set)new HashSet());
    p.j(localSet, "Collections.synchronizedSet(HashSet<String>())");
    this.ABW = localSet;
    AppMethodBeat.o(272470);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(272463);
    this.ABW.clear();
    AppMethodBeat.o(272463);
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(272464);
    p.k(paramString, "finderUserName");
    boolean bool = this.ABW.contains(paramString);
    AppMethodBeat.o(272464);
    return bool;
  }
  
  public final boolean ecD()
  {
    AppMethodBeat.i(272467);
    if (!((Collection)this.ABW).isEmpty())
    {
      AppMethodBeat.o(272467);
      return true;
    }
    AppMethodBeat.o(272467);
    return false;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(272466);
    boolean bool = this.ABW.isEmpty();
    AppMethodBeat.o(272466);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(272469);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.ABW.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((StringBuilder)localObject).append(str + ';');
    }
    localObject = ((StringBuilder)localObject).toString();
    p.j(localObject, "content.toString()");
    AppMethodBeat.o(272469);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.g
 * JD-Core Version:    0.7.0.1
 */