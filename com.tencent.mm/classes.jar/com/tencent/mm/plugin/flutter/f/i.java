package com.tencent.mm.plugin.flutter.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;

final class i
  implements d.a
{
  private boolean done;
  private d.a hgj;
  private ArrayList<Object> hgk;
  
  i()
  {
    AppMethodBeat.i(148927);
    this.hgk = new ArrayList();
    this.done = false;
    AppMethodBeat.o(148927);
  }
  
  private void awV()
  {
    AppMethodBeat.i(148933);
    if (this.hgj == null)
    {
      AppMethodBeat.o(148933);
      return;
    }
    Iterator localIterator = this.hgk.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof a))
      {
        this.hgj.awU();
      }
      else if ((localObject instanceof b))
      {
        localObject = (b)localObject;
        this.hgj.b(((b)localObject).code, ((b)localObject).message, ((b)localObject).hgl);
      }
      else
      {
        this.hgj.ba(localObject);
      }
    }
    this.hgk.clear();
    AppMethodBeat.o(148933);
  }
  
  private void bb(Object paramObject)
  {
    AppMethodBeat.i(148932);
    if (this.done)
    {
      AppMethodBeat.o(148932);
      return;
    }
    this.hgk.add(paramObject);
    AppMethodBeat.o(148932);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(148928);
    this.hgj = parama;
    awV();
    AppMethodBeat.o(148928);
  }
  
  public final void awU()
  {
    AppMethodBeat.i(148929);
    bb(new a((byte)0));
    awV();
    this.done = true;
    AppMethodBeat.o(148929);
  }
  
  public final void b(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(148930);
    bb(new b(paramString1, paramString2, paramObject));
    awV();
    AppMethodBeat.o(148930);
  }
  
  public final void ba(Object paramObject)
  {
    AppMethodBeat.i(148931);
    bb(paramObject);
    awV();
    AppMethodBeat.o(148931);
  }
  
  static final class a {}
  
  static final class b
  {
    String code;
    Object hgl;
    String message;
    
    b(String paramString1, String paramString2, Object paramObject)
    {
      this.code = paramString1;
      this.message = paramString2;
      this.hgl = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.f.i
 * JD-Core Version:    0.7.0.1
 */