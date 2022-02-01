package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.sdk.b.b;
import java.util.List;

public final class mp
  extends b
{
  public a dBs;
  public b dBt;
  
  public mp()
  {
    this((byte)0);
  }
  
  private mp(byte paramByte)
  {
    AppMethodBeat.i(89749);
    this.dBs = new a();
    this.dBt = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(89749);
  }
  
  public static final class a
  {
    public boolean dBb = false;
    public float dBu = 0.0F;
    public int dBv = 0;
    public int dBw = 0;
    public String dBx;
    public String dBy;
    public int dsO = 0;
    public float dzE = 0.0F;
  }
  
  public static final class b
  {
    public List<bue> dBA;
    public int dBB = -1;
    public boolean dBz = false;
    public int dsO = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.mp
 * JD-Core Version:    0.7.0.1
 */