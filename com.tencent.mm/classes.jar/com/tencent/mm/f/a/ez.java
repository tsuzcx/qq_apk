package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ez
  extends IEvent
{
  public a fAR;
  
  public ez()
  {
    this((byte)0);
  }
  
  private ez(byte paramByte)
  {
    AppMethodBeat.i(116002);
    this.fAR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116002);
  }
  
  public static final class a
  {
    public Context context;
    public int op = 0;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ez
 * JD-Core Version:    0.7.0.1
 */