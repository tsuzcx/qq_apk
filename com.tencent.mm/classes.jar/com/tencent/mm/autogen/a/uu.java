package com.tencent.mm.autogen.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uu
  extends IEvent
{
  public a hYx;
  public b hYy;
  
  public uu()
  {
    this((byte)0);
  }
  
  private uu(byte paramByte)
  {
    AppMethodBeat.i(149883);
    this.hYx = new a();
    this.hYy = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149883);
  }
  
  public static final class a
  {
    public Activity hHU;
    public int hPm;
    public String hYA;
    public String hYB;
    public String hYC;
    public String hYD;
    public String hYz;
    public String packageName;
    public int scene;
  }
  
  public static final class b
  {
    public Bundle extras;
    public boolean hYE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.uu
 * JD-Core Version:    0.7.0.1
 */