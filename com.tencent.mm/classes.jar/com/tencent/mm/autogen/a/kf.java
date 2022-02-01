package com.tencent.mm.autogen.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kf
  extends IEvent
{
  public a hLP;
  public b hLQ;
  
  public kf()
  {
    this((byte)0);
  }
  
  private kf(byte paramByte)
  {
    AppMethodBeat.i(19811);
    this.hLP = new a();
    this.hLQ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19811);
  }
  
  public static final class a
  {
    public Intent intent;
  }
  
  public static final class b
  {
    public int hGE = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.kf
 * JD-Core Version:    0.7.0.1
 */