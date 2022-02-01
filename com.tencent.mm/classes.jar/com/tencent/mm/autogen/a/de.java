package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class de
  extends IEvent
{
  public a hCZ;
  
  public de()
  {
    this((byte)0);
  }
  
  private de(byte paramByte)
  {
    AppMethodBeat.i(19794);
    this.hCZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19794);
  }
  
  public static final class a
  {
    public int action = 0;
    public Context context;
    public String[] hyR;
    public String[] hyS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.de
 * JD-Core Version:    0.7.0.1
 */