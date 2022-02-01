package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class gb
  extends b
{
  public a drF;
  public b drG;
  
  public gb()
  {
    this((byte)0);
  }
  
  private gb(byte paramByte)
  {
    AppMethodBeat.i(116023);
    this.drF = new a();
    this.drG = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(116023);
  }
  
  public static final class a
  {
    public String drH;
    public int drI = 0;
    public Runnable drJ;
    public String fileName;
    public int from = 0;
    public int scene;
  }
  
  public static final class b
  {
    public boolean bsb;
    public String content;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.gb
 * JD-Core Version:    0.7.0.1
 */