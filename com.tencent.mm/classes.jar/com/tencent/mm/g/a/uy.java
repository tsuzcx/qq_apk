package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.b.b;

public final class uy
  extends b
{
  public a dJg;
  public b dJh;
  
  public uy()
  {
    this((byte)0);
  }
  
  private uy(byte paramByte)
  {
    AppMethodBeat.i(148772);
    this.dJg = new a();
    this.dJh = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(148772);
  }
  
  public static final class a
  {
    public String dIO;
    public bxm dJi;
    public Runnable dJj;
    public e dJk;
    public int scene;
  }
  
  public static final class b
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.uy
 * JD-Core Version:    0.7.0.1
 */