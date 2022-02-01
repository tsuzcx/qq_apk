package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.b.b;
import java.util.List;

public final class lv
  extends b
{
  public a dnO;
  public b dnP;
  
  public lv()
  {
    this((byte)0);
  }
  
  private lv(byte paramByte)
  {
    AppMethodBeat.i(136975);
    this.dnO = new a();
    this.dnP = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(136975);
  }
  
  public static final class a
  {
    public int action;
    public List dhL;
    public f dnQ;
    public int dnR;
    public boolean dnS;
    public d dnT;
    public int position;
    public String songAlbumUrl;
  }
  
  public static final class b
  {
    public List dhL;
    public f dnQ;
    public c dnU;
    public String dnV;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.lv
 * JD-Core Version:    0.7.0.1
 */