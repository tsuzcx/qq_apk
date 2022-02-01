package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.HashMap;

public final class nj
  extends IEvent
{
  public a hPK;
  
  public nj()
  {
    this((byte)0);
  }
  
  private nj(byte paramByte)
  {
    AppMethodBeat.i(128846);
    this.hPK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(128846);
  }
  
  public static final class a
  {
    public HashMap hPL;
    public String key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.nj
 * JD-Core Version:    0.7.0.1
 */