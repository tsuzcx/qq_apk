package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvp;

public class a$a<T extends cvp>
{
  public n dor;
  public int errCode;
  public String errMsg;
  public int errType;
  public T hNC;
  public a hND;
  
  public static <T extends cvp> a<T> a(int paramInt1, int paramInt2, String paramString, T paramT, n paramn, a parama)
  {
    AppMethodBeat.i(182910);
    a locala = new a();
    locala.errType = paramInt1;
    locala.errCode = paramInt2;
    locala.errMsg = paramString;
    locala.hNC = paramT;
    locala.dor = paramn;
    locala.hND = parama;
    if (parama != null) {
      parama.a(paramInt1, paramInt2, paramString, paramT, paramn);
    }
    AppMethodBeat.o(182910);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.a
 * JD-Core Version:    0.7.0.1
 */