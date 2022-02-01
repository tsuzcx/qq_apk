package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/CgiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorType", "", "errorCode", "message", "", "(IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorType", "plugin-eggspring_release"})
public final class a
  extends Exception
{
  private final int dGe;
  public final int errorCode;
  
  public a(int paramInt1, int paramInt2, String paramString)
  {
    super("Cgi exception: errorType=" + paramInt1 + ", errorCode=" + paramInt2 + ", message=" + paramString);
    AppMethodBeat.i(194551);
    this.dGe = paramInt1;
    this.errorCode = paramInt2;
    AppMethodBeat.o(194551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.a
 * JD-Core Version:    0.7.0.1
 */