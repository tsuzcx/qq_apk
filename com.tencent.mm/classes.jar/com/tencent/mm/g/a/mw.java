package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class mw
  extends IEvent
{
  public a dSw;
  public b dSx;
  
  public mw()
  {
    this((byte)0);
  }
  
  private mw(byte paramByte)
  {
    AppMethodBeat.i(136975);
    this.dSw = new a();
    this.dSx = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(136975);
  }
  
  public static final class a
  {
    public int action;
    public List dLA;
    public boolean dSA;
    public d dSB;
    public f dSy;
    public int dSz;
    public int position;
    public String songAlbumUrl;
  }
  
  public static final class b
  {
    public List dLA;
    public c dSC;
    public String dSD;
    public f dSy;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.mw
 * JD-Core Version:    0.7.0.1
 */