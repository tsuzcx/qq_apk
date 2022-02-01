package com.tencent.mm.plugin.flutter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;

final class i
  implements d.a
{
  private boolean done;
  private d.a smV;
  private ArrayList<Object> smW;
  
  i()
  {
    AppMethodBeat.i(148927);
    this.smW = new ArrayList();
    this.done = false;
    AppMethodBeat.o(148927);
  }
  
  private void cIh()
  {
    AppMethodBeat.i(148933);
    if (this.smV == null)
    {
      AppMethodBeat.o(148933);
      return;
    }
    Iterator localIterator = this.smW.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof a))
      {
        this.smV.cIg();
      }
      else if ((localObject instanceof b))
      {
        localObject = (b)localObject;
        this.smV.e(((b)localObject).code, ((b)localObject).message, ((b)localObject).smX);
      }
      else
      {
        this.smV.db(localObject);
      }
    }
    this.smW.clear();
    AppMethodBeat.o(148933);
  }
  
  private void dc(Object paramObject)
  {
    AppMethodBeat.i(148932);
    if (this.done)
    {
      AppMethodBeat.o(148932);
      return;
    }
    this.smW.add(paramObject);
    AppMethodBeat.o(148932);
  }
  
  public final void b(d.a parama)
  {
    AppMethodBeat.i(148928);
    this.smV = parama;
    cIh();
    AppMethodBeat.o(148928);
  }
  
  public final void cIg()
  {
    AppMethodBeat.i(148929);
    dc(new a((byte)0));
    cIh();
    this.done = true;
    AppMethodBeat.o(148929);
  }
  
  public final void db(Object paramObject)
  {
    AppMethodBeat.i(148931);
    dc(paramObject);
    cIh();
    AppMethodBeat.o(148931);
  }
  
  public final void e(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(148930);
    dc(new b(paramString1, paramString2, paramObject));
    cIh();
    AppMethodBeat.o(148930);
  }
  
  static final class a {}
  
  static final class b
  {
    String code;
    String message;
    Object smX;
    
    b(String paramString1, String paramString2, Object paramObject)
    {
      this.code = paramString1;
      this.message = paramString2;
      this.smX = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.i
 * JD-Core Version:    0.7.0.1
 */