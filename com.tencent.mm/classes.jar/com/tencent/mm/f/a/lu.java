package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lu
  extends IEvent
{
  public a fJF;
  
  public lu()
  {
    this((byte)0);
  }
  
  private lu(byte paramByte)
  {
    AppMethodBeat.i(63289);
    this.fJF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63289);
  }
  
  public static final class a
  {
    public Context context;
    public String fJG;
    public Long fJH;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.lu
 * JD-Core Version:    0.7.0.1
 */