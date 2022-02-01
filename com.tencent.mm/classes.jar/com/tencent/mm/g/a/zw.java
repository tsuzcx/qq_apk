package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zw
  extends IEvent
{
  public b egA;
  public a egz;
  
  public zw()
  {
    this((byte)0);
  }
  
  private zw(byte paramByte)
  {
    AppMethodBeat.i(153020);
    this.egz = new a();
    this.egA = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153020);
  }
  
  public static final class a
  {
    public Activity activity;
    public int egB;
  }
  
  public static final class b
  {
    public Object data;
    
    public b()
    {
      AppMethodBeat.i(153019);
      this.data = Integer.valueOf(0);
      AppMethodBeat.o(153019);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.zw
 * JD-Core Version:    0.7.0.1
 */