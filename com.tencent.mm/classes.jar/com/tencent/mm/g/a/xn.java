package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xn
  extends IEvent
{
  public a edL;
  public b edM;
  
  public xn()
  {
    this((byte)0);
  }
  
  private xn(byte paramByte)
  {
    AppMethodBeat.i(116051);
    this.edL = new a();
    this.edM = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116051);
  }
  
  public static final class a
  {
    public Context context;
    public String edN;
    public int opType = 0;
  }
  
  public static final class b
  {
    public boolean dFE = false;
    public String dWc;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.xn
 * JD-Core Version:    0.7.0.1
 */