package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class gl
  extends b
{
  public a dtm;
  public b dtn;
  
  public gl()
  {
    this((byte)0);
  }
  
  private gl(byte paramByte)
  {
    AppMethodBeat.i(127288);
    this.dtm = new a();
    this.dtn = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(127288);
  }
  
  public static final class a
  {
    public int dto = 0;
    public int state = -1;
    public String talker;
  }
  
  public static final class b
  {
    public int state = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.gl
 * JD-Core Version:    0.7.0.1
 */