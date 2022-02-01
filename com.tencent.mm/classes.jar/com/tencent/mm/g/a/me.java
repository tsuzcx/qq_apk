package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.c;
import com.tencent.mm.az.d;
import com.tencent.mm.az.f;
import com.tencent.mm.sdk.b.b;
import java.util.List;

public final class me
  extends b
{
  public a dzC;
  public b dzD;
  
  public me()
  {
    this((byte)0);
  }
  
  private me(byte paramByte)
  {
    AppMethodBeat.i(136975);
    this.dzC = new a();
    this.dzD = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(136975);
  }
  
  public static final class a
  {
    public int action;
    public List dtj;
    public f dzE;
    public int dzF;
    public boolean dzG;
    public d dzH;
    public int position;
    public String songAlbumUrl;
  }
  
  public static final class b
  {
    public List dtj;
    public f dzE;
    public c dzI;
    public String dzJ;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.me
 * JD-Core Version:    0.7.0.1
 */