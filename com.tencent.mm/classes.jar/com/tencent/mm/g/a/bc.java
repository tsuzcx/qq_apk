package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class bc
  extends b
{
  public a ddo;
  public b ddp;
  
  public bc()
  {
    this((byte)0);
  }
  
  private bc(byte paramByte)
  {
    AppMethodBeat.i(104409);
    this.ddo = new a();
    this.ddp = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(104409);
  }
  
  public static final class a
  {
    public EmojiInfo ddq;
    public String ddr;
    public int type;
  }
  
  public static final class b
  {
    public boolean result = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.bc
 * JD-Core Version:    0.7.0.1
 */