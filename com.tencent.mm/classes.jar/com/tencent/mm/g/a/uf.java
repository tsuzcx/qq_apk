package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.b.b;

public final class uf
  extends b
{
  public a dwU;
  public b dwV;
  
  public uf()
  {
    this((byte)0);
  }
  
  private uf(byte paramByte)
  {
    AppMethodBeat.i(148772);
    this.dwU = new a();
    this.dwV = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(148772);
  }
  
  public static final class a
  {
    public String dwC;
    public bsz dwW;
    public Runnable dwX;
    public e dwY;
    public int scene;
  }
  
  public static final class b
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.uf
 * JD-Core Version:    0.7.0.1
 */