package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nb
  extends IEvent
{
  public a fLh;
  
  public nb()
  {
    this((byte)0);
  }
  
  private nb(byte paramByte)
  {
    AppMethodBeat.i(126679);
    this.fLh = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(126679);
  }
  
  public static final class a
  {
    public long endTime;
    public String fLi;
    public String fLj;
    public int fLk;
    public String[] fLl;
    public String fLm;
    public int fLn;
    public int fLo;
    public String fLp;
    public String fileId;
    public int netType;
    public String path;
    public long startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.nb
 * JD-Core Version:    0.7.0.1
 */