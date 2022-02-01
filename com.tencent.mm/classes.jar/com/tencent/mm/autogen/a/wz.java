package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class wz
  extends IEvent
{
  public a iax;
  
  public wz()
  {
    this((byte)0);
  }
  
  private wz(byte paramByte)
  {
    AppMethodBeat.i(121036);
    this.iax = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121036);
  }
  
  public static final class a
  {
    public String hMi;
    public Boolean iat;
    public long iav;
    public List iay;
    public Boolean iaz;
    public int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.wz
 * JD-Core Version:    0.7.0.1
 */