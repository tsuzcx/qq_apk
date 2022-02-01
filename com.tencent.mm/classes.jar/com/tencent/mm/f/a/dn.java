package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class dn
  extends IEvent
{
  public a fzd;
  
  public dn()
  {
    this((byte)0);
  }
  
  private dn(byte paramByte)
  {
    AppMethodBeat.i(104411);
    this.fzd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104411);
  }
  
  public static final class a
  {
    public EmojiInfo fze;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.dn
 * JD-Core Version:    0.7.0.1
 */