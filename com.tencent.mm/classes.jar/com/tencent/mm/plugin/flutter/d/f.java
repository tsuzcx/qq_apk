package com.tencent.mm.plugin.flutter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;

final class f
  implements d.a
{
  private boolean done;
  private d.a rea;
  private ArrayList<Object> reb;
  
  f()
  {
    AppMethodBeat.i(148927);
    this.reb = new ArrayList();
    this.done = false;
    AppMethodBeat.o(148927);
  }
  
  private void cuV()
  {
    AppMethodBeat.i(148933);
    if (this.rea == null)
    {
      AppMethodBeat.o(148933);
      return;
    }
    Iterator localIterator = this.reb.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof a))
      {
        this.rea.cuU();
      }
      else if ((localObject instanceof b))
      {
        localObject = (b)localObject;
        this.rea.a(((b)localObject).code, ((b)localObject).message, ((b)localObject).rec);
      }
      else
      {
        this.rea.ay(localObject);
      }
    }
    this.reb.clear();
    AppMethodBeat.o(148933);
  }
  
  private void da(Object paramObject)
  {
    AppMethodBeat.i(148932);
    if (this.done)
    {
      AppMethodBeat.o(148932);
      return;
    }
    this.reb.add(paramObject);
    AppMethodBeat.o(148932);
  }
  
  public final void a(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(148930);
    da(new b(paramString1, paramString2, paramObject));
    cuV();
    AppMethodBeat.o(148930);
  }
  
  public final void ay(Object paramObject)
  {
    AppMethodBeat.i(148931);
    da(paramObject);
    cuV();
    AppMethodBeat.o(148931);
  }
  
  public final void b(d.a parama)
  {
    AppMethodBeat.i(148928);
    this.rea = parama;
    cuV();
    AppMethodBeat.o(148928);
  }
  
  public final void cuU()
  {
    AppMethodBeat.i(148929);
    da(new a((byte)0));
    cuV();
    this.done = true;
    AppMethodBeat.o(148929);
  }
  
  static final class a {}
  
  static final class b
  {
    String code;
    String message;
    Object rec;
    
    b(String paramString1, String paramString2, Object paramObject)
    {
      this.code = paramString1;
      this.message = paramString2;
      this.rec = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.f
 * JD-Core Version:    0.7.0.1
 */