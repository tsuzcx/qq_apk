package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fy
  extends IEvent
{
  public a fBG;
  
  public fy()
  {
    this((byte)0);
  }
  
  private fy(byte paramByte)
  {
    AppMethodBeat.i(19803);
    this.fBG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19803);
  }
  
  public static final class a
  {
    public Context context;
    public String fBH;
    public String[] fuA;
    public String[] fuz;
    public int op = 0;
    public int source = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.fy
 * JD-Core Version:    0.7.0.1
 */