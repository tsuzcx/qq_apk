package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.sdk.b.b;
import java.util.LinkedList;

public final class mq
  extends b
{
  public a dBC;
  public b dBD;
  
  public mq()
  {
    this((byte)0);
  }
  
  private mq(byte paramByte)
  {
    AppMethodBeat.i(138164);
    this.dBC = new a();
    this.dBD = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(138164);
  }
  
  public static final class a
  {
    public boolean dBb = false;
    public String dzw;
  }
  
  public static final class b
  {
    public int dAb = 0;
    public LinkedList<buk> dBp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.mq
 * JD-Core Version:    0.7.0.1
 */