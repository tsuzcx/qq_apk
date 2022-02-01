package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class nv
  extends IEvent
{
  public a fMp;
  public b fMq;
  
  public nv()
  {
    this((byte)0);
  }
  
  private nv(byte paramByte)
  {
    AppMethodBeat.i(116459);
    this.fMp = new a();
    this.fMq = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116459);
  }
  
  public static final class a
  {
    public boolean fMo = false;
    public List<String> fMr;
    public String topic;
  }
  
  public static final class b
  {
    public int fMs;
    public List<String> fMt;
    public List<String> fMu;
    public List<String> fMv;
    public List<String> fMw;
    public List<String> fMx;
    public String fwY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.nv
 * JD-Core Version:    0.7.0.1
 */