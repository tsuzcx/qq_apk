package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ic
  extends IEvent
{
  public a hJy;
  
  public ic()
  {
    this((byte)0);
  }
  
  private ic(byte paramByte)
  {
    AppMethodBeat.i(168879);
    this.hJy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168879);
  }
  
  public static final class a
  {
    public long localId;
    public int progress;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ic
 * JD-Core Version:    0.7.0.1
 */