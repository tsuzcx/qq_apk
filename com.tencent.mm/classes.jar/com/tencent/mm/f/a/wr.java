package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wr
  extends IEvent
{
  public a fVL;
  
  public wr()
  {
    this((byte)0);
  }
  
  private wr(byte paramByte)
  {
    AppMethodBeat.i(125636);
    this.fVL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125636);
  }
  
  public static final class a
  {
    public Context context;
    public String fCM;
    public int fDn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wr
 * JD-Core Version:    0.7.0.1
 */