package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class nn
  extends IEvent
{
  public a hPT;
  public b hPU;
  
  public nn()
  {
    this((byte)0);
  }
  
  private nn(byte paramByte)
  {
    AppMethodBeat.i(63290);
    this.hPT = new a();
    this.hPU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63290);
  }
  
  public static final class a
  {
    public Context context;
    public ArrayList hPV;
    public String hPW;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.nn
 * JD-Core Version:    0.7.0.1
 */