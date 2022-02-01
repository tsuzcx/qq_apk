package com.tencent.mm.autogen.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zv
  extends IEvent
{
  public a idq;
  public b idr;
  
  public zv()
  {
    this((byte)0);
  }
  
  private zv(byte paramByte)
  {
    AppMethodBeat.i(153018);
    this.idq = new a();
    this.idr = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153018);
  }
  
  public static final class a
  {
    public Activity hHU;
    public int hPm;
    public Intent ids;
  }
  
  public static final class b
  {
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.zv
 * JD-Core Version:    0.7.0.1
 */