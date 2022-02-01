package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class fc
  extends IEvent
{
  public a fAW;
  public b fAX;
  
  public fc()
  {
    this((byte)0);
  }
  
  private fc(byte paramByte)
  {
    AppMethodBeat.i(116005);
    this.fAW = new a();
    this.fAX = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116005);
  }
  
  public static final class a
  {
    public List fAj;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.fc
 * JD-Core Version:    0.7.0.1
 */