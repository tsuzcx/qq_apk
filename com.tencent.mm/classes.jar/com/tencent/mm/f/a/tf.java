package com.tencent.mm.f.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tf
  extends IEvent
{
  public a fSA;
  public b fSB;
  
  public tf()
  {
    this((byte)0);
  }
  
  private tf(byte paramByte)
  {
    AppMethodBeat.i(149883);
    this.fSA = new a();
    this.fSB = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149883);
  }
  
  public static final class a
  {
    public Activity fDf;
    public String fSC;
    public String fSD;
    public String fSE;
    public String fSF;
    public String packageName;
    public int requestCode;
    public int scene;
  }
  
  public static final class b
  {
    public Bundle extras;
    public boolean fSG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.tf
 * JD-Core Version:    0.7.0.1
 */