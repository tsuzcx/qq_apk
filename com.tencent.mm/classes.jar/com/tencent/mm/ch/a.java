package com.tencent.mm.ch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class a<T>
  implements b.a<T>
{
  private final Object GzG;
  private HashSet<Object<T>> jys;
  private final String mName;
  private T mValue;
  
  private a(String paramString)
  {
    AppMethodBeat.i(133213);
    this.GzG = new Object();
    this.mName = paramString;
    this.jys = new HashSet();
    AppMethodBeat.o(133213);
  }
  
  a(String paramString, T paramT)
  {
    this(paramString);
    this.mValue = paramT;
  }
  
  public final T get()
  {
    return this.mValue;
  }
  
  public final String name()
  {
    return this.mName;
  }
  
  final void set(T arg1)
  {
    AppMethodBeat.i(133214);
    Object localObject1 = this.mValue;
    int i;
    if ((??? == localObject1) || ((??? != null) && (???.equals(localObject1)))) {
      i = 1;
    }
    while (i == 0)
    {
      this.mValue = ???;
      synchronized (this.GzG)
      {
        localObject1 = this.jys.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label87;
        }
        ((Iterator)localObject1).next();
      }
      i = 0;
      continue;
      label87:
      AppMethodBeat.o(133214);
      return;
    }
    AppMethodBeat.o(133214);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(133215);
    String str = "Status: " + this.mName;
    AppMethodBeat.o(133215);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ch.a
 * JD-Core Version:    0.7.0.1
 */