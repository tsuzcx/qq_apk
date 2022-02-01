package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class gc
  extends b
{
  public a dsL;
  public b dsM;
  
  public gc()
  {
    this((byte)0);
  }
  
  private gc(byte paramByte)
  {
    AppMethodBeat.i(116023);
    this.dsL = new a();
    this.dsM = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116023);
  }
  
  public static final class a
  {
    public String dsN;
    public int dsO = 0;
    public Runnable dsP;
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
 * Qualified Name:     com.tencent.mm.g.a.gc
 * JD-Core Version:    0.7.0.1
 */