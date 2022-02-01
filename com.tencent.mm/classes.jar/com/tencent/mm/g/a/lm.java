package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.c;
import com.tencent.mm.az.d;
import com.tencent.mm.az.f;
import com.tencent.mm.sdk.b.b;
import java.util.List;

public final class lm
  extends b
{
  public a dqd;
  public b dqe;
  
  public lm()
  {
    this((byte)0);
  }
  
  private lm(byte paramByte)
  {
    AppMethodBeat.i(136975);
    this.dqd = new a();
    this.dqe = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(136975);
  }
  
  public static final class a
  {
    public int action;
    public List dkq;
    public f dqf;
    public int dqg;
    public boolean dqh;
    public d dqi;
    public int position;
    public String songAlbumUrl;
  }
  
  public static final class b
  {
    public List dkq;
    public f dqf;
    public c dqj;
    public String dqk;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.lm
 * JD-Core Version:    0.7.0.1
 */