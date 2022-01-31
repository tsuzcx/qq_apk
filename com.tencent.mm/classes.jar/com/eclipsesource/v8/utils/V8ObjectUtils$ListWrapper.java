package com.eclipsesource.v8.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

class V8ObjectUtils$ListWrapper
{
  private List<? extends Object> list;
  
  public V8ObjectUtils$ListWrapper(List<? extends Object> paramList)
  {
    this.list = paramList;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof ListWrapper))
    {
      bool1 = bool2;
      if (((ListWrapper)paramObject).list == this.list) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(75105);
    int i = System.identityHashCode(this.list);
    AppMethodBeat.o(75105);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.utils.V8ObjectUtils.ListWrapper
 * JD-Core Version:    0.7.0.1
 */