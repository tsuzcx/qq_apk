package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class bg
  extends b
{
  public a dni;
  public b dnj;
  
  public bg()
  {
    this((byte)0);
  }
  
  private bg(byte paramByte)
  {
    AppMethodBeat.i(104409);
    this.dni = new a();
    this.dnj = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(104409);
  }
  
  public static final class a
  {
    public EmojiInfo dnk;
    public String dnl;
    public int type;
  }
  
  public static final class b
  {
    public boolean result = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.bg
 * JD-Core Version:    0.7.0.1
 */