package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class bg
  extends b
{
  public a dmg;
  public b dmh;
  
  public bg()
  {
    this((byte)0);
  }
  
  private bg(byte paramByte)
  {
    AppMethodBeat.i(104409);
    this.dmg = new a();
    this.dmh = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(104409);
  }
  
  public static final class a
  {
    public EmojiInfo dmi;
    public String dmj;
    public int type;
  }
  
  public static final class b
  {
    public boolean result = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.bg
 * JD-Core Version:    0.7.0.1
 */