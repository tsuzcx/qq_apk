package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.c;
import com.tencent.mm.bb.d;
import com.tencent.mm.bb.f;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class nn
  extends IEvent
{
  public a fLT;
  public b fLU;
  
  public nn()
  {
    this((byte)0);
  }
  
  private nn(byte paramByte)
  {
    AppMethodBeat.i(136975);
    this.fLT = new a();
    this.fLU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(136975);
  }
  
  public static final class a
  {
    public int action;
    public List fEp;
    public f fLV;
    public int fLW;
    public boolean fLX;
    public d fLY;
    public int position;
    public String songAlbumUrl;
  }
  
  public static final class b
  {
    public List fEp;
    public f fLV;
    public c fLZ;
    public String fMa;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.nn
 * JD-Core Version:    0.7.0.1
 */