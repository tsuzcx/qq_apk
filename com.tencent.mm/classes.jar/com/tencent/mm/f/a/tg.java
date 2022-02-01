package com.tencent.mm.f.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tg
  extends IEvent
{
  public a fSH;
  public b fSI;
  
  public tg()
  {
    this((byte)0);
  }
  
  private tg(byte paramByte)
  {
    AppMethodBeat.i(149884);
    this.fSH = new a();
    this.fSI = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149884);
  }
  
  public static final class a
  {
    public Context context;
    public Bundle extras;
    public int fSJ;
  }
  
  public static final class b
  {
    public Bundle extras;
    public boolean fSG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.tg
 * JD-Core Version:    0.7.0.1
 */