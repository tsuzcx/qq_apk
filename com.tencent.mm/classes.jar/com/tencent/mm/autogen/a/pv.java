package com.tencent.mm.autogen.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pv
  extends IEvent
{
  public a hSZ;
  
  public pv()
  {
    this((byte)0);
  }
  
  private pv(byte paramByte)
  {
    AppMethodBeat.i(116036);
    this.hSZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116036);
  }
  
  public static final class a
  {
    public Activity activity;
    public String hBi;
    public int hSW = 0;
    public Bundle hTa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pv
 * JD-Core Version:    0.7.0.1
 */