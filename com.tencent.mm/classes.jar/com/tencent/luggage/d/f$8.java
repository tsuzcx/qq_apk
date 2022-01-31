package com.tencent.luggage.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class f$8
  extends g
{
  f$8(f paramf) {}
  
  final Context getContext()
  {
    return this.byY.mContext;
  }
  
  public final k ui()
  {
    AppMethodBeat.i(90783);
    k localk = f.a(this.byY);
    AppMethodBeat.o(90783);
    return localk;
  }
  
  final Class<? extends com.tencent.luggage.webview.a> uj()
  {
    AppMethodBeat.i(90781);
    Class localClass = this.byY.uj();
    AppMethodBeat.o(90781);
    return localClass;
  }
  
  public final LinkedList<e> um()
  {
    return this.byY.byP;
  }
  
  public final h un()
  {
    return this.byY;
  }
  
  public final LinkedList<Class<? extends a>> uo()
  {
    AppMethodBeat.i(90782);
    LinkedList localLinkedList = (LinkedList)this.byY.byQ.byH.clone();
    AppMethodBeat.o(90782);
    return localLinkedList;
  }
  
  public final com.tencent.luggage.g.e up()
  {
    return this.byY.byR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.d.f.8
 * JD-Core Version:    0.7.0.1
 */