package com.tencent.mm.f.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yc
  extends IEvent
{
  public a fXq;
  public b fXr;
  
  public yc()
  {
    this((byte)0);
  }
  
  private yc(byte paramByte)
  {
    AppMethodBeat.i(153018);
    this.fXq = new a();
    this.fXr = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153018);
  }
  
  public static final class a
  {
    public Activity fDf;
    public Intent fXs;
    public int requestCode;
  }
  
  public static final class b
  {
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.yc
 * JD-Core Version:    0.7.0.1
 */