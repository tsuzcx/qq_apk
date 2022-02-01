package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaa
  extends IEvent
{
  public a egJ;
  
  public aaa()
  {
    this((byte)0);
  }
  
  private aaa(byte paramByte)
  {
    AppMethodBeat.i(91227);
    this.egJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91227);
  }
  
  public static final class a
  {
    public String dDL;
    public int egK = 0;
    public boolean egL = false;
    public int egM = 0;
    public Intent intent;
    public int result = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.aaa
 * JD-Core Version:    0.7.0.1
 */