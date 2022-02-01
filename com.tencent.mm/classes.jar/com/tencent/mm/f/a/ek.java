package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class ek
  extends IEvent
{
  public a fAe;
  public b fAf;
  
  public ek()
  {
    this((byte)0);
  }
  
  private ek(byte paramByte)
  {
    AppMethodBeat.i(115987);
    this.fAe = new a();
    this.fAf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115987);
  }
  
  public static final class a
  {
    public String fAg;
    public String fAh;
    public String fAi;
    public long msgId;
  }
  
  public static final class b
  {
    public List fAj;
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.ek
 * JD-Core Version:    0.7.0.1
 */