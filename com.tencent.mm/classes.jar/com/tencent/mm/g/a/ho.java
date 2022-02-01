package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ho
  extends IEvent
{
  public a dMd;
  
  public ho()
  {
    this((byte)0);
  }
  
  private ho(byte paramByte)
  {
    AppMethodBeat.i(136974);
    this.dMd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(136974);
  }
  
  public static final class a
  {
    public String appId;
    public String appUserName;
    public String brandName;
    public int dMe;
    public String dMf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ho
 * JD-Core Version:    0.7.0.1
 */