package com.tencent.mm.g.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class rm
  extends b
{
  public a dwZ;
  
  public rm()
  {
    this((byte)0);
  }
  
  private rm(byte paramByte)
  {
    AppMethodBeat.i(146075);
    this.dwZ = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(146075);
  }
  
  public static final class a
  {
    public int action = 0;
    public String cardNum;
    public Bitmap dxa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.rm
 * JD-Core Version:    0.7.0.1
 */