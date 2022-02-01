package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class qn
  extends b
{
  public a dwe;
  public b dwf;
  
  public qn()
  {
    this((byte)0);
  }
  
  private qn(byte paramByte)
  {
    AppMethodBeat.i(149883);
    this.dwe = new a();
    this.dwf = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(149883);
  }
  
  public static final class a
  {
    public Activity djj;
    public String dwg;
    public String dwh;
    public String packageName;
    public int requestCode;
    public int scene;
  }
  
  public static final class b
  {
    public boolean dwi;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qn
 * JD-Core Version:    0.7.0.1
 */