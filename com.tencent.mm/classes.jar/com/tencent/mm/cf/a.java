package com.tencent.mm.cf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class a<T>
  implements b.a<T>
{
  private final String mName;
  private T mValue;
  private HashSet<Object<T>> ywo;
  private final Object ywp;
  
  private a(String paramString)
  {
    AppMethodBeat.i(58946);
    this.ywp = new Object();
    this.mName = paramString;
    this.ywo = new HashSet();
    AppMethodBeat.o(58946);
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
    AppMethodBeat.i(58947);
    Object localObject1 = this.mValue;
    int i;
    if ((??? == localObject1) || ((??? != null) && (???.equals(localObject1)))) {
      i = 1;
    }
    while (i == 0)
    {
      this.mValue = ???;
      synchronized (this.ywp)
      {
        localObject1 = this.ywo.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label87;
        }
        ((Iterator)localObject1).next();
      }
      i = 0;
      continue;
      label87:
      AppMethodBeat.o(58947);
      return;
    }
    AppMethodBeat.o(58947);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58948);
    String str = "Status: " + this.mName;
    AppMethodBeat.o(58948);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.a
 * JD-Core Version:    0.7.0.1
 */