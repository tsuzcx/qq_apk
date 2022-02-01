package com.tencent.mm.flutter.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.EventChannel.EventSink;
import java.util.ArrayList;
import java.util.Iterator;

final class c
  implements EventChannel.EventSink
{
  private boolean done;
  private EventChannel.EventSink mst;
  private ArrayList<Object> msu;
  
  c()
  {
    AppMethodBeat.i(233261);
    this.msu = new ArrayList();
    this.done = false;
    AppMethodBeat.o(233261);
  }
  
  private void aXs()
  {
    AppMethodBeat.i(233269);
    if (this.mst == null)
    {
      AppMethodBeat.o(233269);
      return;
    }
    Iterator localIterator = this.msu.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof c.a))
      {
        this.mst.endOfStream();
      }
      else if ((localObject instanceof b))
      {
        localObject = (b)localObject;
        this.mst.error(((b)localObject).code, ((b)localObject).message, ((b)localObject).details);
      }
      else
      {
        this.mst.success(localObject);
      }
    }
    this.msu.clear();
    AppMethodBeat.o(233269);
  }
  
  private void cw(Object paramObject)
  {
    AppMethodBeat.i(233265);
    if (this.done)
    {
      AppMethodBeat.o(233265);
      return;
    }
    this.msu.add(paramObject);
    AppMethodBeat.o(233265);
  }
  
  public final void a(EventChannel.EventSink paramEventSink)
  {
    AppMethodBeat.i(233273);
    this.mst = paramEventSink;
    aXs();
    AppMethodBeat.o(233273);
  }
  
  public final void endOfStream()
  {
    AppMethodBeat.i(233278);
    cw(new c.a((byte)0));
    aXs();
    this.done = true;
    AppMethodBeat.o(233278);
  }
  
  public final void error(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(233283);
    cw(new b(paramString1, paramString2, paramObject));
    aXs();
    AppMethodBeat.o(233283);
  }
  
  public final void success(Object paramObject)
  {
    AppMethodBeat.i(233289);
    cw(paramObject);
    aXs();
    AppMethodBeat.o(233289);
  }
  
  static final class b
  {
    String code;
    Object details;
    String message;
    
    b(String paramString1, String paramString2, Object paramObject)
    {
      this.code = paramString1;
      this.message = paramString2;
      this.details = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.flutter.b.a.c
 * JD-Core Version:    0.7.0.1
 */