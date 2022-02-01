package com.i.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.MethodChannel.Result;

public final class d
  extends b
{
  private final MethodChannel.Result ecY;
  private final com.i.a.d edm;
  private final Boolean edn;
  
  public d(MethodChannel.Result paramResult, com.i.a.d paramd, Boolean paramBoolean)
  {
    this.ecY = paramResult;
    this.edm = paramd;
    this.edn = paramBoolean;
  }
  
  protected final g alw()
  {
    return null;
  }
  
  public final com.i.a.d alx()
  {
    return this.edm;
  }
  
  public final Boolean aly()
  {
    return this.edn;
  }
  
  public final <T> T er(String paramString)
  {
    AppMethodBeat.i(153409);
    AppMethodBeat.o(153409);
    return null;
  }
  
  public final void error(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(153410);
    this.ecY.error(paramString1, paramString2, paramObject);
    AppMethodBeat.o(153410);
  }
  
  public final void success(Object paramObject)
  {
    AppMethodBeat.i(153411);
    this.ecY.success(paramObject);
    AppMethodBeat.o(153411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.i.a.b.d
 * JD-Core Version:    0.7.0.1
 */