package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gj
  extends IEvent
{
  public a hGv;
  
  public gj()
  {
    this((byte)0);
  }
  
  private gj(byte paramByte)
  {
    AppMethodBeat.i(19803);
    this.hGv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19803);
  }
  
  public static final class a
  {
    public Context context;
    public String hGw;
    public String[] hyR;
    public String[] hyS;
    public int op = 0;
    public int source = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gj
 * JD-Core Version:    0.7.0.1
 */