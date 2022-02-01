package com.e.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.j;
import io.flutter.a.a.k.d;

public final class e
  extends a
{
  final j bYT;
  final a bYU;
  
  public e(j paramj, k.d paramd)
  {
    AppMethodBeat.i(153414);
    this.bYT = paramj;
    this.bYU = new a(paramd);
    AppMethodBeat.o(153414);
  }
  
  public final g Ay()
  {
    return this.bYU;
  }
  
  public final <T> T bK(String paramString)
  {
    AppMethodBeat.i(153415);
    paramString = this.bYT.qa(paramString);
    AppMethodBeat.o(153415);
    return paramString;
  }
  
  final class a
    implements g
  {
    final k.d bYF;
    
    a(k.d paramd)
    {
      this.bYF = paramd;
    }
    
    public final void a(String paramString1, String paramString2, Object paramObject)
    {
      AppMethodBeat.i(153413);
      this.bYF.a(paramString1, paramString2, paramObject);
      AppMethodBeat.o(153413);
    }
    
    public final void ay(Object paramObject)
    {
      AppMethodBeat.i(153412);
      this.bYF.ay(paramObject);
      AppMethodBeat.o(153412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.e.a.b.e
 * JD-Core Version:    0.7.0.1
 */