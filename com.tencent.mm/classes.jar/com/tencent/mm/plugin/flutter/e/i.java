package com.tencent.mm.plugin.flutter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;

final class i
  implements d.a
{
  private boolean done;
  private d.a tur;
  private ArrayList<Object> tus;
  
  i()
  {
    AppMethodBeat.i(148927);
    this.tus = new ArrayList();
    this.done = false;
    AppMethodBeat.o(148927);
  }
  
  private void cTb()
  {
    AppMethodBeat.i(148933);
    if (this.tur == null)
    {
      AppMethodBeat.o(148933);
      return;
    }
    Iterator localIterator = this.tus.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof i.a))
      {
        this.tur.cTa();
      }
      else if ((localObject instanceof b))
      {
        localObject = (b)localObject;
        this.tur.f(((b)localObject).code, ((b)localObject).message, ((b)localObject).tut);
      }
      else
      {
        this.tur.df(localObject);
      }
    }
    this.tus.clear();
    AppMethodBeat.o(148933);
  }
  
  private void dg(Object paramObject)
  {
    AppMethodBeat.i(148932);
    if (this.done)
    {
      AppMethodBeat.o(148932);
      return;
    }
    this.tus.add(paramObject);
    AppMethodBeat.o(148932);
  }
  
  public final void b(d.a parama)
  {
    AppMethodBeat.i(148928);
    this.tur = parama;
    cTb();
    AppMethodBeat.o(148928);
  }
  
  public final void cTa()
  {
    AppMethodBeat.i(148929);
    dg(new i.a((byte)0));
    cTb();
    this.done = true;
    AppMethodBeat.o(148929);
  }
  
  public final void df(Object paramObject)
  {
    AppMethodBeat.i(148931);
    dg(paramObject);
    cTb();
    AppMethodBeat.o(148931);
  }
  
  public final void f(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(148930);
    dg(new b(paramString1, paramString2, paramObject));
    cTb();
    AppMethodBeat.o(148930);
  }
  
  static final class b
  {
    String code;
    String message;
    Object tut;
    
    b(String paramString1, String paramString2, Object paramObject)
    {
      this.code = paramString1;
      this.message = paramString2;
      this.tut = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.i
 * JD-Core Version:    0.7.0.1
 */