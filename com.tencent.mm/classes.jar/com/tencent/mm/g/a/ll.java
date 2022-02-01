package com.tencent.mm.g.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ll
  extends IEvent
{
  public a dQJ;
  public b dQK;
  
  public ll()
  {
    this((byte)0);
  }
  
  private ll(byte paramByte)
  {
    AppMethodBeat.i(190310);
    this.dQJ = new a();
    this.dQK = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(190310);
  }
  
  public static final class a
  {
    public Bundle dQL;
    public String dQM;
    public Runnable dQN;
    public int type = 0;
  }
  
  public static final class b
  {
    public Bundle result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.ll
 * JD-Core Version:    0.7.0.1
 */