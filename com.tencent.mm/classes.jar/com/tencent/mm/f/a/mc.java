package com.tencent.mm.f.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mc
  extends IEvent
{
  public a fJZ;
  public b fKa;
  
  public mc()
  {
    this((byte)0);
  }
  
  private mc(byte paramByte)
  {
    AppMethodBeat.i(210791);
    this.fJZ = new a();
    this.fKa = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(210791);
  }
  
  public static final class a
  {
    public Bundle fKb;
    public String fKc;
    public Runnable fKd;
    public int type = 0;
  }
  
  public static final class b
  {
    public Bundle result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.f.a.mc
 * JD-Core Version:    0.7.0.1
 */