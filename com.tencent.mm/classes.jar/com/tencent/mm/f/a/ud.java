package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ud
  extends IEvent
{
  public a fTs;
  
  public ud()
  {
    this((byte)0);
  }
  
  private ud(byte paramByte)
  {
    AppMethodBeat.i(19832);
    this.fTs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19832);
  }
  
  public static final class a
  {
    public Context context;
    public boolean fTt = false;
    public String[] fuA;
    public String[] fuz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ud
 * JD-Core Version:    0.7.0.1
 */