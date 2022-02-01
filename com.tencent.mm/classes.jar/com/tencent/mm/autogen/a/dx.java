package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class dx
  extends IEvent
{
  public a hDM;
  
  public dx()
  {
    this((byte)0);
  }
  
  private dx(byte paramByte)
  {
    AppMethodBeat.i(104411);
    this.hDM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104411);
  }
  
  public static final class a
  {
    public EmojiInfo hDN;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.dx
 * JD-Core Version:    0.7.0.1
 */