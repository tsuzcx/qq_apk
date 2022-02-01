package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class bn
  extends IEvent
{
  public a fxl;
  public b fxm;
  
  public bn()
  {
    this((byte)0);
  }
  
  private bn(byte paramByte)
  {
    AppMethodBeat.i(104409);
    this.fxl = new a();
    this.fxm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104409);
  }
  
  public static final class a
  {
    public EmojiInfo fxn;
    public String fxo;
    public int type;
  }
  
  public static final class b
  {
    public boolean result = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.bn
 * JD-Core Version:    0.7.0.1
 */