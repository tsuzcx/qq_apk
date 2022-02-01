package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ri
  extends b
{
  public a dGW;
  public b dGX;
  
  public ri()
  {
    this((byte)0);
  }
  
  private ri(byte paramByte)
  {
    AppMethodBeat.i(149883);
    this.dGW = new a();
    this.dGX = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(149883);
  }
  
  public static final class a
  {
    public String dGY;
    public String dGZ;
    public String dHa;
    public Activity dtg;
    public String packageName;
    public int requestCode;
    public int scene;
  }
  
  public static final class b
  {
    public boolean dHb;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ri
 * JD-Core Version:    0.7.0.1
 */