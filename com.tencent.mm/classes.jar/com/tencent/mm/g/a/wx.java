package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wx
  extends IEvent
{
  public a edn;
  
  public wx()
  {
    this((byte)0);
  }
  
  private wx(byte paramByte)
  {
    AppMethodBeat.i(19838);
    this.edn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19838);
  }
  
  public static final class a
  {
    public Context context;
    public String edo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.wx
 * JD-Core Version:    0.7.0.1
 */