package com.tencent.mm.f.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class je
  extends IEvent
{
  public a fGt;
  public b fGu;
  
  public je()
  {
    this((byte)0);
  }
  
  private je(byte paramByte)
  {
    AppMethodBeat.i(19811);
    this.fGt = new a();
    this.fGu = new b();
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
    public int fBP = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.je
 * JD-Core Version:    0.7.0.1
 */