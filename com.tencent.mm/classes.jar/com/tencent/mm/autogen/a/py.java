package com.tencent.mm.autogen.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class py
  extends IEvent
{
  public a hTd;
  
  public py()
  {
    this((byte)0);
  }
  
  private py(byte paramByte)
  {
    AppMethodBeat.i(89647);
    this.hTd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89647);
  }
  
  public static final class a
  {
    public Context context;
    public String group;
    public Intent intent;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.py
 * JD-Core Version:    0.7.0.1
 */