package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gy
  extends IEvent
{
  public a fDw;
  public b fDx;
  
  public gy()
  {
    this((byte)0);
  }
  
  private gy(byte paramByte)
  {
    AppMethodBeat.i(104417);
    this.fDw = new a();
    this.fDx = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104417);
  }
  
  public static final class a
  {
    public String aeskey;
    public String fDy;
    public String fDz;
    public int fvK;
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
 * Qualified Name:     com.tencent.mm.f.a.gy
 * JD-Core Version:    0.7.0.1
 */