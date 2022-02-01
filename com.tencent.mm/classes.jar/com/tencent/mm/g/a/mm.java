package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.util.LinkedList;

public final class mm
  extends b
{
  public a dAi;
  public b dAj;
  
  public mm()
  {
    this((byte)0);
  }
  
  private mm(byte paramByte)
  {
    AppMethodBeat.i(116460);
    this.dAi = new a();
    this.dAj = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(116460);
  }
  
  public static final class a
  {
    public String chatroomName;
    public LinkedList<String> dAk;
    public boolean dzW = false;
    public int scene = 0;
  }
  
  public static final class b
  {
    public int errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.mm
 * JD-Core Version:    0.7.0.1
 */