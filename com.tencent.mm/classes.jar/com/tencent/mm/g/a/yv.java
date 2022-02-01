package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yv
  extends IEvent
{
  public a efb;
  public b efc;
  
  public yv()
  {
    this((byte)0);
  }
  
  private yv(byte paramByte)
  {
    AppMethodBeat.i(116056);
    this.efb = new a();
    this.efc = new b();
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
    public boolean efd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.yv
 * JD-Core Version:    0.7.0.1
 */