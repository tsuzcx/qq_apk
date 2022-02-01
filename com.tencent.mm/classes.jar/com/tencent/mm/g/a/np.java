package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class np
  extends IEvent
{
  public a dTL;
  
  public np()
  {
    this((byte)0);
  }
  
  private np(byte paramByte)
  {
    AppMethodBeat.i(116036);
    this.dTL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116036);
  }
  
  public static final class a
  {
    public Activity activity;
    public String dDX;
    public int dTJ = 0;
    public Bundle dTM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.np
 * JD-Core Version:    0.7.0.1
 */