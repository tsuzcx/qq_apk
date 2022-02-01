package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class na
  extends b
{
  public a dAV;
  public b dAW;
  
  public na()
  {
    this((byte)0);
  }
  
  private na(byte paramByte)
  {
    AppMethodBeat.i(110275);
    this.dAV = new a();
    this.dAW = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(110275);
  }
  
  public static final class a
  {
    public boolean dAX = false;
    public String key;
    public int type = 0;
    public String username;
  }
  
  public static final class b
  {
    public long dAY;
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.na
 * JD-Core Version:    0.7.0.1
 */