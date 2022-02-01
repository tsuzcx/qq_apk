package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ael
  extends IEvent
{
  public a ijc;
  
  public ael()
  {
    this((byte)0);
  }
  
  private ael(byte paramByte)
  {
    AppMethodBeat.i(369457);
    this.ijc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369457);
  }
  
  public static final class a
  {
    public String appId;
    public int eul;
    public String filePath;
    public String md5;
    public int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ael
 * JD-Core Version:    0.7.0.1
 */