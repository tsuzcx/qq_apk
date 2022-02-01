package com.tencent.mm.flutter.plugins.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;

final class c
  implements d.a
{
  private boolean done;
  private d.a jSb;
  private ArrayList<Object> jSc;
  
  c()
  {
    AppMethodBeat.i(207299);
    this.jSc = new ArrayList();
    this.done = false;
    AppMethodBeat.o(207299);
  }
  
  private void aEo()
  {
    AppMethodBeat.i(207305);
    if (this.jSb == null)
    {
      AppMethodBeat.o(207305);
      return;
    }
    Iterator localIterator = this.jSc.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof c.a))
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
    AppMethodBeat.o(207305);
  }
  
  private void bc(Object paramObject)
  {
    AppMethodBeat.i(207304);
    if (this.done)
    {
      AppMethodBeat.o(207304);
      return;
    }
    this.jSc.add(paramObject);
    AppMethodBeat.o(207304);
  }
  
  public final void aEn()
  {
    AppMethodBeat.i(207301);
    bc(new c.a((byte)0));
    aEo();
    this.done = true;
    AppMethodBeat.o(207301);
  }
  
  public final void b(d.a parama)
  {
    AppMethodBeat.i(207300);
    this.jSb = parama;
    aEo();
    AppMethodBeat.o(207300);
  }
  
  public final void b(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(207302);
    bc(new b(paramString1, paramString2, paramObject));
    aEo();
    AppMethodBeat.o(207302);
  }
  
  public final void bb(Object paramObject)
  {
    AppMethodBeat.i(207303);
    bc(paramObject);
    aEo();
    AppMethodBeat.o(207303);
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
 * Qualified Name:     com.tencent.mm.flutter.plugins.a.c
 * JD-Core Version:    0.7.0.1
 */