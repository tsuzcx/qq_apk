package com.tencent.mm.autogen.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class m
  extends IEvent
{
  public a hyZ;
  public b hza;
  
  public m()
  {
    this((byte)0);
  }
  
  private m(byte paramByte)
  {
    AppMethodBeat.i(149847);
    this.hyZ = new a();
    this.hza = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149847);
  }
  
  public static final class a
  {
    public int actionCode;
    public Context context;
    public String hzb;
    public boolean hzc;
    public boolean hzd;
  }
  
  public static final class b
  {
    public Bundle hze;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.m
 * JD-Core Version:    0.7.0.1
 */