package com.e.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.k.d;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends b
{
  final k.d bYF;
  final com.e.a.d bYS;
  final Map<String, Object> map;
  
  public d(k.d paramd, com.e.a.d paramd1)
  {
    AppMethodBeat.i(153408);
    this.map = new HashMap();
    this.bYF = paramd;
    this.bYS = paramd1;
    AppMethodBeat.o(153408);
  }
  
  protected final g Ay()
  {
    return null;
  }
  
  public final void a(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(153410);
    this.bYF.a(paramString1, paramString2, paramObject);
    AppMethodBeat.o(153410);
  }
  
  public final void ay(Object paramObject)
  {
    AppMethodBeat.i(153411);
    this.bYF.ay(paramObject);
    AppMethodBeat.o(153411);
  }
  
  public final <T> T bK(String paramString)
  {
    AppMethodBeat.i(153409);
    paramString = this.map.get(paramString);
    AppMethodBeat.o(153409);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.e.a.b.d
 * JD-Core Version:    0.7.0.1
 */