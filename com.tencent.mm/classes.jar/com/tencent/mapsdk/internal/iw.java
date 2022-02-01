package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class iw
  extends iu
{
  private ArrayList<iu> a;
  
  private iw(ArrayList<iu> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public final boolean a(ix paramix)
  {
    AppMethodBeat.i(223053);
    if (this.a.isEmpty())
    {
      AppMethodBeat.o(223053);
      return true;
    }
    iu localiu = (iu)this.a.get(0);
    if (localiu.a(paramix)) {
      this.a.remove(localiu);
    }
    boolean bool = this.a.isEmpty();
    AppMethodBeat.o(223053);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.iw
 * JD-Core Version:    0.7.0.1
 */