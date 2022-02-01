package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abe
  extends IEvent
{
  public a eiw;
  
  public abe()
  {
    this((byte)0);
  }
  
  private abe(byte paramByte)
  {
    AppMethodBeat.i(194334);
    this.eiw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(194334);
  }
  
  public static final class a
  {
    public String appId;
    public int eix;
    public String filePath;
    public String md5;
    public int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.abe
 * JD-Core Version:    0.7.0.1
 */