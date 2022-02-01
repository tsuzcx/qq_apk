package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class di
  extends IEvent
{
  public a dGs;
  
  public di()
  {
    this((byte)0);
  }
  
  private di(byte paramByte)
  {
    AppMethodBeat.i(104411);
    this.dGs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104411);
  }
  
  public static final class a
  {
    public EmojiInfo dGt;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.di
 * JD-Core Version:    0.7.0.1
 */