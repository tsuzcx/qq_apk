package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class qw
  extends b
{
  public a dtR;
  public b dtS;
  
  public qw()
  {
    this((byte)0);
  }
  
  private qw(byte paramByte)
  {
    AppMethodBeat.i(149883);
    this.dtR = new a();
    this.dtS = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(149883);
  }
  
  public static final class a
  {
    public Activity dgE;
    public String dtT;
    public String dtU;
    public String packageName;
    public int requestCode;
    public int scene;
  }
  
  public static final class b
  {
    public boolean dtV;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qw
 * JD-Core Version:    0.7.0.1
 */