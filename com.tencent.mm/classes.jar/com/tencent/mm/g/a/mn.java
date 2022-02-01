package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.util.LinkedList;

public final class mn
  extends b
{
  public a dBn;
  public b dBo;
  
  public mn()
  {
    this((byte)0);
  }
  
  private mn(byte paramByte)
  {
    AppMethodBeat.i(116460);
    this.dBn = new a();
    this.dBo = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116460);
  }
  
  public static final class a
  {
    public String chatroomName;
    public boolean dBb = false;
    public LinkedList<String> dBp;
    public int scene = 0;
  }
  
  public static final class b
  {
    public int errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.mn
 * JD-Core Version:    0.7.0.1
 */