package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gr
  extends IEvent
{
  public a dKH;
  public b dKI;
  
  public gr()
  {
    this((byte)0);
  }
  
  private gr(byte paramByte)
  {
    AppMethodBeat.i(104417);
    this.dKH = new a();
    this.dKI = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104417);
  }
  
  public static final class a
  {
    public String aeskey;
    public int dDe;
    public String dKJ;
    public String dKK;
    public String md5;
    public String name;
    public String productId;
    public String thumbUrl;
  }
  
  public static final class b
  {
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.gr
 * JD-Core Version:    0.7.0.1
 */