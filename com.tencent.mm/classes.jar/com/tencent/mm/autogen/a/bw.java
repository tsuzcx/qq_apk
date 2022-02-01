package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class bw
  extends IEvent
{
  public a hBQ;
  public b hBR;
  
  public bw()
  {
    this((byte)0);
  }
  
  private bw(byte paramByte)
  {
    AppMethodBeat.i(104409);
    this.hBQ = new a();
    this.hBR = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104409);
  }
  
  public static final class a
  {
    public EmojiInfo hBS;
    public String hBT;
    public int type;
  }
  
  public static final class b
  {
    public boolean result = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.bw
 * JD-Core Version:    0.7.0.1
 */