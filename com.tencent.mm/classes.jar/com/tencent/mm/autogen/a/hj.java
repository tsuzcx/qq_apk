package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hj
  extends IEvent
{
  public a hIm;
  public b hIn;
  
  public hj()
  {
    this((byte)0);
  }
  
  private hj(byte paramByte)
  {
    AppMethodBeat.i(104417);
    this.hIm = new a();
    this.hIn = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104417);
  }
  
  public static final class a
  {
    public String aeskey;
    public int hAf;
    public String hIo;
    public String hIp;
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
 * Qualified Name:     com.tencent.mm.autogen.a.hj
 * JD-Core Version:    0.7.0.1
 */