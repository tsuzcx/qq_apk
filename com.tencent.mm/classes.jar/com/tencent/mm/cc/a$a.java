package com.tencent.mm.cc;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class a$a<E>
  extends ArrayList<E>
{
  public final void add(int paramInt, E paramE)
  {
    y.i("InterceptArrayList", "InterceptArrayList.add index object");
  }
  
  public final boolean add(E paramE)
  {
    y.i("InterceptArrayList", "InterceptArrayList.add");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cc.a.a
 * JD-Core Version:    0.7.0.1
 */