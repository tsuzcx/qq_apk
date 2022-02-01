package com.i.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.Result;

public final class e
  extends a
{
  final MethodCall edo;
  final a edp;
  
  public e(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(153414);
    this.edo = paramMethodCall;
    this.edp = new a(paramResult);
    AppMethodBeat.o(153414);
  }
  
  public final g alw()
  {
    return this.edp;
  }
  
  public final <T> T er(String paramString)
  {
    AppMethodBeat.i(153415);
    paramString = this.edo.argument(paramString);
    AppMethodBeat.o(153415);
    return paramString;
  }
  
  final class a
    implements g
  {
    final MethodChannel.Result ecY;
    
    a(MethodChannel.Result paramResult)
    {
      this.ecY = paramResult;
    }
    
    public final void error(String paramString1, String paramString2, Object paramObject)
    {
      AppMethodBeat.i(153413);
      this.ecY.error(paramString1, paramString2, paramObject);
      AppMethodBeat.o(153413);
    }
    
    public final void success(Object paramObject)
    {
      AppMethodBeat.i(153412);
      this.ecY.success(paramObject);
      AppMethodBeat.o(153412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.i.a.b.e
 * JD-Core Version:    0.7.0.1
 */