package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kq
  extends IEvent
{
  public a fIg;
  public b fIh;
  
  public kq()
  {
    this((byte)0);
  }
  
  private kq(byte paramByte)
  {
    AppMethodBeat.i(155370);
    this.fIg = new a();
    this.fIh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155370);
  }
  
  public static final class a
  {
    public Context context;
  }
  
  public static final class b
  {
    public String fIi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.kq
 * JD-Core Version:    0.7.0.1
 */