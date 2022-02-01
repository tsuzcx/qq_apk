package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ip
  extends b
{
  public a dwm;
  public b dwn;
  
  public ip()
  {
    this((byte)0);
  }
  
  private ip(byte paramByte)
  {
    AppMethodBeat.i(117546);
    this.dwm = new a();
    this.dwn = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(117546);
  }
  
  public static final class a
  {
    public int actionCode;
    public Context context;
    public Bundle dwo;
    public String result;
    public String username;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ip
 * JD-Core Version:    0.7.0.1
 */