package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aby
  extends IEvent
{
  public a ifv;
  public b ifw;
  
  public aby()
  {
    this((byte)0);
  }
  
  private aby(byte paramByte)
  {
    AppMethodBeat.i(116056);
    this.ifv = new a();
    this.ifw = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116056);
  }
  
  public static final class a
  {
    public Context context;
    public int type;
  }
  
  public static final class b
  {
    public boolean ifx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aby
 * JD-Core Version:    0.7.0.1
 */