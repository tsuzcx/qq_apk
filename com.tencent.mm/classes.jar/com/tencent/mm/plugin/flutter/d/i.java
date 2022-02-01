package com.tencent.mm.plugin.flutter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;

final class i
  implements d.a
{
  private boolean done;
  private d.a jSb;
  private ArrayList<Object> jSc;
  
  i()
  {
    AppMethodBeat.i(148927);
    this.jSc = new ArrayList();
    this.done = false;
    AppMethodBeat.o(148927);
  }
  
  private void aEo()
  {
    AppMethodBeat.i(148933);
    if (this.jSb == null)
    {
      AppMethodBeat.o(148933);
      return;
    }
    Iterator localIterator = this.jSc.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof i.a))
      {
        this.jSb.aEn();
      }
      else if ((localObject instanceof b))
      {
        localObject = (b)localObject;
        this.jSb.b(((b)localObject).code, ((b)localObject).message, ((b)localObject).jSd);
      }
      else
      {
        this.jSb.bb(localObject);
      }
    }
    this.jSc.clear();
    AppMethodBeat.o(148933);
  }
  
  private void bc(Object paramObject)
  {
    AppMethodBeat.i(148932);
    if (this.done)
    {
      AppMethodBeat.o(148932);
      return;
    }
    this.jSc.add(paramObject);
    AppMethodBeat.o(148932);
  }
  
  public final void aEn()
  {
    AppMethodBeat.i(148929);
    bc(new i.a((byte)0));
    aEo();
    this.done = true;
    AppMethodBeat.o(148929);
  }
  
  public final void b(d.a parama)
  {
    AppMethodBeat.i(148928);
    this.jSb = parama;
    aEo();
    AppMethodBeat.o(148928);
  }
  
  public final void b(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(148930);
    bc(new b(paramString1, paramString2, paramObject));
    aEo();
    AppMethodBeat.o(148930);
  }
  
  public final void bb(Object paramObject)
  {
    AppMethodBeat.i(148931);
    bc(paramObject);
    aEo();
    AppMethodBeat.o(148931);
  }
  
  static final class b
  {
    String code;
    Object jSd;
    String message;
    
    b(String paramString1, String paramString2, Object paramObject)
    {
      this.code = paramString1;
      this.message = paramString2;
      this.jSd = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.i
 * JD-Core Version:    0.7.0.1
 */