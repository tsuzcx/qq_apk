package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvk;

public class a$a<T extends bvk>
{
  public m cqE;
  public int errCode;
  public String errMsg;
  public int errType;
  public T fsN;
  public a fsO;
  
  public static <T extends bvk> a<T> a(int paramInt1, int paramInt2, String paramString, T paramT, m paramm, a parama)
  {
    AppMethodBeat.i(58149);
    a locala = new a();
    locala.errType = paramInt1;
    locala.errCode = paramInt2;
    locala.errMsg = paramString;
    locala.fsN = paramT;
    locala.cqE = paramm;
    locala.fsO = parama;
    if (parama != null) {
      parama.a(paramInt1, paramInt2, paramString, paramT, paramm);
    }
    AppMethodBeat.o(58149);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ai.a.a
 * JD-Core Version:    0.7.0.1
 */