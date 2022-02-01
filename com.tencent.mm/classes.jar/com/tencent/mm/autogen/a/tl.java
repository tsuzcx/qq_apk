package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.event.IEvent;

public final class tl
  extends IEvent
{
  public a hWX;
  public b hWY;
  
  public tl()
  {
    this((byte)0);
  }
  
  private tl(byte paramByte)
  {
    AppMethodBeat.i(125624);
    this.hWX = new a();
    this.hWY = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125624);
  }
  
  public static final class a
  {
    public String username;
  }
  
  public static final class b
  {
    public dmz hWZ;
    public dmz hXa;
    public dmz hXb;
    public dmz hXc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.a.tl
 * JD-Core Version:    0.7.0.1
 */