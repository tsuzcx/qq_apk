package com.tencent.mm.autogen.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ade
  extends IEvent
{
  public a ihj;
  
  public ade()
  {
    this((byte)0);
  }
  
  private ade(byte paramByte)
  {
    AppMethodBeat.i(91227);
    this.ihj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91227);
  }
  
  public static final class a
  {
    public String hAT;
    public int ihk = 0;
    public boolean ihl = false;
    public int ihm = 0;
    public Intent intent;
    public int result = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ade
 * JD-Core Version:    0.7.0.1
 */