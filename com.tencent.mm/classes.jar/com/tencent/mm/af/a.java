package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ktx/CgiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorType", "", "errorCode", "message", "", "(IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorType", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends Exception
{
  public final int errorCode;
  public final int hDx;
  
  public a(int paramInt1, int paramInt2, String paramString)
  {
    super("CGI returns error: errorType=" + paramInt1 + ", errorCode=" + paramInt2 + ", message=" + paramString);
    AppMethodBeat.i(231711);
    this.hDx = paramInt1;
    this.errorCode = paramInt2;
    AppMethodBeat.o(231711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.af.a
 * JD-Core Version:    0.7.0.1
 */