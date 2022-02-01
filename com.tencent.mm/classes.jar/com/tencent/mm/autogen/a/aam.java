package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aam
  extends IEvent
{
  public a idU;
  public b idV;
  
  public aam()
  {
    this((byte)0);
  }
  
  private aam(byte paramByte)
  {
    AppMethodBeat.i(116051);
    this.idU = new a();
    this.idV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116051);
  }
  
  public static final class a
  {
    public Context context;
    public String idW;
    public int opType = 0;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
    public String hVC;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aam
 * JD-Core Version:    0.7.0.1
 */