package com.tencent.mm.f.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class k
  extends IEvent
{
  public a fuF;
  public b fuG;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte)
  {
    AppMethodBeat.i(149847);
    this.fuF = new a();
    this.fuG = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149847);
  }
  
  public static final class a
  {
    public int actionCode;
    public Context context;
    public String fuH;
    public boolean fuI;
    public boolean fuJ;
  }
  
  public static final class b
  {
    public Bundle fuK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.k
 * JD-Core Version:    0.7.0.1
 */