package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sk
  extends IEvent
{
  public b hVA;
  public a hVz;
  
  public sk()
  {
    this((byte)0);
  }
  
  private sk(byte paramByte)
  {
    AppMethodBeat.i(117551);
    this.hVz = new a();
    this.hVA = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117551);
  }
  
  public static final class a
  {
    public Context context;
    public String hVB;
    public int opType = 0;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
    public String hVC;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.sk
 * JD-Core Version:    0.7.0.1
 */