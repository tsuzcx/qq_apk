package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class rh
  extends b
{
  public a dFR;
  public b dFS;
  
  public rh()
  {
    this((byte)0);
  }
  
  private rh(byte paramByte)
  {
    AppMethodBeat.i(149883);
    this.dFR = new a();
    this.dFS = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(149883);
  }
  
  public static final class a
  {
    public String dFT;
    public String dFU;
    public Activity dsa;
    public String packageName;
    public int requestCode;
    public int scene;
  }
  
  public static final class b
  {
    public boolean dFV;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.rh
 * JD-Core Version:    0.7.0.1
 */