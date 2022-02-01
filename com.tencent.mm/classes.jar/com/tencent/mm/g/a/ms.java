package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ms
  extends b
{
  public a dBG;
  public b dBH;
  
  public ms()
  {
    this((byte)0);
  }
  
  private ms(byte paramByte)
  {
    AppMethodBeat.i(116462);
    this.dBG = new a();
    this.dBH = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116462);
  }
  
  public static final class a
  {
    public String chatroomName;
    public String dBI;
    public boolean dBb = false;
  }
  
  public static final class b
  {
    public int errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ms
 * JD-Core Version:    0.7.0.1
 */