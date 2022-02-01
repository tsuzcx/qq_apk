package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.util.LinkedList;

public final class lu
  extends b
{
  public a dqJ;
  public b dqK;
  
  public lu()
  {
    this((byte)0);
  }
  
  private lu(byte paramByte)
  {
    AppMethodBeat.i(116460);
    this.dqJ = new a();
    this.dqK = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(116460);
  }
  
  public static final class a
  {
    public String chatroomName;
    public LinkedList<String> dqL;
    public boolean dqx = false;
    public int scene = 0;
  }
  
  public static final class b
  {
    public int errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.lu
 * JD-Core Version:    0.7.0.1
 */