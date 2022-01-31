package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayy;

public final class h$a
{
  ayy fLS;
  private int key;
  private String value;
  
  public h$a()
  {
    AppMethodBeat.i(59995);
    this.key = 0;
    this.value = "";
    this.fLS = new ayy();
    this.fLS.qsk = 0;
    this.fLS.qsu = "";
    AppMethodBeat.o(59995);
  }
  
  public h$a(int paramInt, String paramString)
  {
    AppMethodBeat.i(59996);
    this.key = paramInt;
    this.value = paramString;
    this.fLS = new ayy();
    this.fLS.qsk = paramInt;
    this.fLS.qsu = paramString;
    AppMethodBeat.o(59996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.h.a
 * JD-Core Version:    0.7.0.1
 */