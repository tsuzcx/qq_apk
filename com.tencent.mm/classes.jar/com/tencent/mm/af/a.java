package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ktx/CgiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorType", "", "errorCode", "message", "", "(IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorType", "mmkernel_release"})
public final class a
  extends Exception
{
  private final int errorCode;
  private final int fyO;
  
  public a(int paramInt1, int paramInt2, String paramString)
  {
    super("CGI returns error: errorType=" + paramInt1 + ", errorCode=" + paramInt2 + ", message=" + paramString);
    AppMethodBeat.i(193815);
    this.fyO = paramInt1;
    this.errorCode = paramInt2;
    AppMethodBeat.o(193815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.af.a
 * JD-Core Version:    0.7.0.1
 */