package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fm
  extends IEvent
{
  public a hFG;
  public b hFH;
  
  public fm()
  {
    this((byte)0);
  }
  
  private fm(byte paramByte)
  {
    AppMethodBeat.i(116004);
    this.hFG = new a();
    this.hFH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116004);
  }
  
  public static final class a
  {
    public String hEy;
    public boolean hEz = false;
    public int hFI = -1;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fm
 * JD-Core Version:    0.7.0.1
 */