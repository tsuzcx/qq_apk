package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.d;
import com.tencent.mm.aw.f;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class ov
  extends IEvent
{
  public a hRE;
  public b hRF;
  
  public ov()
  {
    this((byte)0);
  }
  
  private ov(byte paramByte)
  {
    AppMethodBeat.i(136975);
    this.hRE = new a();
    this.hRF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(136975);
  }
  
  public static final class a
  {
    public int action;
    public List hJf;
    public f hRG;
    public int hRH;
    public boolean hRI;
    public d hRJ;
    public int position;
    public String songAlbumUrl;
  }
  
  public static final class b
  {
    public List hJf;
    public f hRG;
    public c hRK;
    public String hRL;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ov
 * JD-Core Version:    0.7.0.1
 */