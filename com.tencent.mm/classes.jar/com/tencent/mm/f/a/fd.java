package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fd
  extends IEvent
{
  public a fAY;
  public b fAZ;
  
  public fd()
  {
    this((byte)0);
  }
  
  private fd(byte paramByte)
  {
    AppMethodBeat.i(116006);
    this.fAY = new a();
    this.fAZ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116006);
  }
  
  public static final class a
  {
    public byte[] data;
    public String fzB;
    public String fzM;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.fd
 * JD-Core Version:    0.7.0.1
 */