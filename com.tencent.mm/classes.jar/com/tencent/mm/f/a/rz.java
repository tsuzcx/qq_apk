package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class rz
  extends IEvent
{
  public a fRl;
  
  public rz()
  {
    this((byte)0);
  }
  
  private rz(byte paramByte)
  {
    AppMethodBeat.i(116042);
    this.fRl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116042);
  }
  
  public static final class a
  {
    public int fRj;
    public ArrayList fRm;
    public ArrayList fRn;
    public ArrayList fRo;
    public ArrayList fRp;
    public ArrayList fRq;
    public int fRr;
    public int fRs;
    public ArrayList fRt;
    public ArrayList fRu;
    public String filePath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.rz
 * JD-Core Version:    0.7.0.1
 */