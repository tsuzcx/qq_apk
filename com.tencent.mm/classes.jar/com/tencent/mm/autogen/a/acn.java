package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class acn
  extends IEvent
{
  public a ifU;
  public b ifV;
  
  public acn()
  {
    this((byte)0);
  }
  
  private acn(byte paramByte)
  {
    AppMethodBeat.i(149895);
    this.ifU = new a();
    this.ifV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149895);
  }
  
  public static final class a
  {
    public String content;
    public Context context;
    public int hId = 0;
    public byte[] ifP;
    public int ifQ = 0;
    public String talker;
  }
  
  public static final class b
  {
    public boolean calling = false;
    public boolean ifW = false;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.acn
 * JD-Core Version:    0.7.0.1
 */