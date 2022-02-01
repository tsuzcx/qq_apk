package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;

public class c$a<T extends dyy>
{
  public int errCode;
  public String errMsg;
  public int errType;
  public q fzz;
  public T lBJ;
  public c lBK;
  
  public static <T extends dyy> a<T> a(int paramInt1, int paramInt2, String paramString, T paramT, q paramq, c paramc)
  {
    AppMethodBeat.i(182910);
    a locala = new a();
    locala.errType = paramInt1;
    locala.errCode = paramInt2;
    locala.errMsg = paramString;
    locala.lBJ = paramT;
    locala.fzz = paramq;
    locala.lBK = paramc;
    if (paramc != null) {
      paramc.a(paramInt1, paramInt2, paramString, paramT, paramq);
    }
    AppMethodBeat.o(182910);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.c.a
 * JD-Core Version:    0.7.0.1
 */