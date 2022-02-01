package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.b.b;
import java.util.List;

public final class mf
  extends b
{
  public a dAH;
  public b dAI;
  
  public mf()
  {
    this((byte)0);
  }
  
  private mf(byte paramByte)
  {
    AppMethodBeat.i(136975);
    this.dAH = new a();
    this.dAI = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(136975);
  }
  
  public static final class a
  {
    public int action;
    public f dAJ;
    public int dAK;
    public boolean dAL;
    public d dAM;
    public List dup;
    public int position;
    public String songAlbumUrl;
  }
  
  public static final class b
  {
    public f dAJ;
    public c dAN;
    public String dAO;
    public List dup;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.mf
 * JD-Core Version:    0.7.0.1
 */