package com.tencent.mm.plugin.flutter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.EventChannel.EventSink;
import java.util.ArrayList;
import java.util.Iterator;

final class i
  implements EventChannel.EventSink
{
  private boolean done;
  private EventChannel.EventSink mst;
  private ArrayList<Object> msu;
  
  i()
  {
    AppMethodBeat.i(148927);
    this.msu = new ArrayList();
    this.done = false;
    AppMethodBeat.o(148927);
  }
  
  private void aXs()
  {
    AppMethodBeat.i(148933);
    if (this.mst == null)
    {
      AppMethodBeat.o(148933);
      return;
    }
    Iterator localIterator = this.msu.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof i.a))
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
    AppMethodBeat.o(148933);
  }
  
  private void cw(Object paramObject)
  {
    AppMethodBeat.i(148932);
    if (this.done)
    {
      AppMethodBeat.o(148932);
      return;
    }
    this.msu.add(paramObject);
    AppMethodBeat.o(148932);
  }
  
  public final void a(EventChannel.EventSink paramEventSink)
  {
    AppMethodBeat.i(148928);
    this.mst = paramEventSink;
    aXs();
    AppMethodBeat.o(148928);
  }
  
  public final void endOfStream()
  {
    AppMethodBeat.i(148929);
    cw(new i.a((byte)0));
    aXs();
    this.done = true;
    AppMethodBeat.o(148929);
  }
  
  public final void error(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(148930);
    cw(new b(paramString1, paramString2, paramObject));
    aXs();
    AppMethodBeat.o(148930);
  }
  
  public final void success(Object paramObject)
  {
    AppMethodBeat.i(148931);
    cw(paramObject);
    aXs();
    AppMethodBeat.o(148931);
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
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.i
 * JD-Core Version:    0.7.0.1
 */