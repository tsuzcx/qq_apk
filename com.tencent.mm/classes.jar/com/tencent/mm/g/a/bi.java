package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class bi
  extends IEvent
{
  public a dEx;
  public b dEy;
  
  public bi()
  {
    this((byte)0);
  }
  
  private bi(byte paramByte)
  {
    AppMethodBeat.i(104409);
    this.dEx = new a();
    this.dEy = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104409);
  }
  
  public static final class a
  {
    public String dEA;
    public EmojiInfo dEz;
    public int type;
  }
  
  public static final class b
  {
    public boolean result = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.bi
 * JD-Core Version:    0.7.0.1
 */