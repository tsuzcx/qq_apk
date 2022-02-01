package com.tencent.mm.plugin.flutter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;

final class i
  implements d.a
{
  private boolean done;
  private ArrayList<Object> tjA;
  private d.a tjz;
  
  i()
  {
    AppMethodBeat.i(148927);
    this.tjA = new ArrayList();
    this.done = false;
    AppMethodBeat.o(148927);
  }
  
  private void cQw()
  {
    AppMethodBeat.i(148933);
    if (this.tjz == null)
    {
      AppMethodBeat.o(148933);
      return;
    }
    Iterator localIterator = this.tjA.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof a))
      {
        this.tjz.cQv();
      }
      else if ((localObject instanceof b))
      {
        localObject = (b)localObject;
        this.tjz.f(((b)localObject).code, ((b)localObject).message, ((b)localObject).tjB);
      }
      else
      {
        this.tjz.de(localObject);
      }
    }
    this.tjA.clear();
    AppMethodBeat.o(148933);
  }
  
  private void df(Object paramObject)
  {
    AppMethodBeat.i(148932);
    if (this.done)
    {
      AppMethodBeat.o(148932);
      return;
    }
    this.tjA.add(paramObject);
    AppMethodBeat.o(148932);
  }
  
  public final void b(d.a parama)
  {
    AppMethodBeat.i(148928);
    this.tjz = parama;
    cQw();
    AppMethodBeat.o(148928);
  }
  
  public final void cQv()
  {
    AppMethodBeat.i(148929);
    df(new a((byte)0));
    cQw();
    this.done = true;
    AppMethodBeat.o(148929);
  }
  
  public final void de(Object paramObject)
  {
    AppMethodBeat.i(148931);
    df(paramObject);
    cQw();
    AppMethodBeat.o(148931);
  }
  
  public final void f(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(148930);
    df(new b(paramString1, paramString2, paramObject));
    cQw();
    AppMethodBeat.o(148930);
  }
  
  static final class a {}
  
  static final class b
  {
    String code;
    String message;
    Object tjB;
    
    b(String paramString1, String paramString2, Object paramObject)
    {
      this.code = paramString1;
      this.message = paramString2;
      this.tjB = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.i
 * JD-Core Version:    0.7.0.1
 */