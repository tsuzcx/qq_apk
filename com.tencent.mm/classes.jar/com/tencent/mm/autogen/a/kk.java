package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kk
  extends IEvent
{
  public a hMa;
  public b hMb;
  
  public kk()
  {
    this((byte)0);
  }
  
  private kk(byte paramByte)
  {
    AppMethodBeat.i(89640);
    this.hMa = new a();
    this.hMb = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89640);
  }
  
  public static final class a
  {
    public int bUl = 0;
    public Context context;
    public String param;
  }
  
  public static final class b
  {
    public String result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.kk
 * JD-Core Version:    0.7.0.1
 */