package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaq
  extends IEvent
{
  public a fZM;
  public b fZN;
  
  public aaq()
  {
    this((byte)0);
  }
  
  private aaq(byte paramByte)
  {
    AppMethodBeat.i(149895);
    this.fZM = new a();
    this.fZN = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149895);
  }
  
  public static final class a
  {
    public String content;
    public Context context;
    public int fDn = 0;
    public byte[] fZH;
    public int fZI = 0;
    public String talker;
  }
  
  public static final class b
  {
    public boolean calling = false;
    public boolean fZO = false;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.aaq
 * JD-Core Version:    0.7.0.1
 */