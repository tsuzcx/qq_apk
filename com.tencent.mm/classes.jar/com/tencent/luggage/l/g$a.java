package com.tencent.luggage.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/util/LuggageMMKVProperty$Companion;", "", "()V", "TAG", "", "allSuperclasses", "", "Ljava/lang/Class;", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g$a
{
  static Collection<Class<?>> af(Class<?> paramClass)
  {
    AppMethodBeat.i(219974);
    paramClass = paramClass.getSuperclass();
    ArrayList localArrayList = new ArrayList();
    while (paramClass != null)
    {
      localArrayList.add(paramClass);
      paramClass = paramClass.getSuperclass();
    }
    paramClass = (Collection)localArrayList;
    AppMethodBeat.o(219974);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.l.g.a
 * JD-Core Version:    0.7.0.1
 */