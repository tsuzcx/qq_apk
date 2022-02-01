package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;", "", "()V", "recordList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "recordSet", "", "getRecordSet", "()Ljava/util/Set;", "clear", "", "contains", "", "finderUserName", "isEmpty", "isNotEmpty", "record", "isClean", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public final Set<String> Gda;
  
  public g()
  {
    AppMethodBeat.i(343336);
    Set localSet = Collections.synchronizedSet((Set)new HashSet());
    s.s(localSet, "synchronizedSet(HashSet<String>())");
    this.Gda = localSet;
    AppMethodBeat.o(343336);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(343342);
    this.Gda.clear();
    AppMethodBeat.o(343342);
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(343352);
    s.u(paramString, "finderUserName");
    boolean bool = this.Gda.contains(paramString);
    AppMethodBeat.o(343352);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(343360);
    boolean bool = this.Gda.isEmpty();
    AppMethodBeat.o(343360);
    return bool;
  }
  
  public final boolean qn()
  {
    AppMethodBeat.i(343372);
    if (!((Collection)this.Gda).isEmpty())
    {
      AppMethodBeat.o(343372);
      return true;
    }
    AppMethodBeat.o(343372);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(343381);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.Gda.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append(s.X((String)localIterator.next(), ";"));
    }
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "content.toString()");
    AppMethodBeat.o(343381);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.g
 * JD-Core Version:    0.7.0.1
 */