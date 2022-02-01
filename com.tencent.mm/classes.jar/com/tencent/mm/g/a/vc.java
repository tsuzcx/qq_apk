package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.b.b;

public final class vc
  extends b
{
  public a dKu;
  public b dKv;
  
  public vc()
  {
    this((byte)0);
  }
  
  private vc(byte paramByte)
  {
    AppMethodBeat.i(148772);
    this.dKu = new a();
    this.dKv = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(148772);
  }
  
  public static final class a
  {
    public String dKc;
    public byg dKw;
    public Runnable dKx;
    public e dKy;
    public int scene;
  }
  
  public static final class b
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.vc
 * JD-Core Version:    0.7.0.1
 */