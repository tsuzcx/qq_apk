package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class se
  extends IEvent
{
  public a dYI;
  public b dYJ;
  
  public se()
  {
    this((byte)0);
  }
  
  private se(byte paramByte)
  {
    AppMethodBeat.i(149883);
    this.dYI = new a();
    this.dYJ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149883);
  }
  
  public static final class a
  {
    public Activity dKq;
    public String dYK;
    public String dYL;
    public String dYM;
    public String packageName;
    public int requestCode;
    public int scene;
  }
  
  public static final class b
  {
    public boolean dYN;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.se
 * JD-Core Version:    0.7.0.1
 */