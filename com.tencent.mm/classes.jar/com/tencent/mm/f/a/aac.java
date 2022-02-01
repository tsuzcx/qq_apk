package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aac
  extends IEvent
{
  public a fZq;
  public b fZr;
  
  public aac()
  {
    this((byte)0);
  }
  
  private aac(byte paramByte)
  {
    AppMethodBeat.i(116056);
    this.fZq = new a();
    this.fZr = new b();
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
    public boolean fZs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.aac
 * JD-Core Version:    0.7.0.1
 */