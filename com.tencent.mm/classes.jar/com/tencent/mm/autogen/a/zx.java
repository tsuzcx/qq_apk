package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zx
  extends IEvent
{
  public a idv;
  
  public zx()
  {
    this((byte)0);
  }
  
  private zx(byte paramByte)
  {
    AppMethodBeat.i(369435);
    this.idv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369435);
  }
  
  public static final class a
  {
    public Long idw;
    public Long idy;
    
    public a()
    {
      AppMethodBeat.i(369350);
      this.idw = Long.valueOf(0L);
      this.idy = Long.valueOf(0L);
      AppMethodBeat.o(369350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.zx
 * JD-Core Version:    0.7.0.1
 */