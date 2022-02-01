package com.tencent.mm.f.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class oo
  extends IEvent
{
  public a fNq;
  
  public oo()
  {
    this((byte)0);
  }
  
  private oo(byte paramByte)
  {
    AppMethodBeat.i(89647);
    this.fNq = new a();
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
 * Qualified Name:     com.tencent.mm.f.a.oo
 * JD-Core Version:    0.7.0.1
 */