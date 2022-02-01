package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class iv
  extends iu
{
  private ArrayList<iu> a;
  
  private iv(ArrayList<iu> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public final boolean a(ix paramix)
  {
    AppMethodBeat.i(223056);
    if (this.a.isEmpty())
    {
      AppMethodBeat.o(223056);
      return true;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((iu)localIterator.next()).a(paramix);
    }
    AppMethodBeat.o(223056);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.iv
 * JD-Core Version:    0.7.0.1
 */