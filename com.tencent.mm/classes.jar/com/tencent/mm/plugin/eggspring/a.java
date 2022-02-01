package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/CgiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorType", "", "errorCode", "message", "", "(IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorType", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends Exception
{
  public final int errorCode;
  private final int hDx;
  
  public a(int paramInt1, int paramInt2, String paramString)
  {
    super("Cgi exception: errorType=" + paramInt1 + ", errorCode=" + paramInt2 + ", message=" + paramString);
    AppMethodBeat.i(266512);
    this.hDx = paramInt1;
    this.errorCode = paramInt2;
    AppMethodBeat.o(266512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.a
 * JD-Core Version:    0.7.0.1
 */