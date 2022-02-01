package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class vj
  extends IEvent
{
  public a fUA;
  
  public vj()
  {
    this((byte)0);
  }
  
  private vj(byte paramByte)
  {
    AppMethodBeat.i(121036);
    this.fUA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121036);
  }
  
  public static final class a
  {
    public String fGM;
    public List fUB;
    public Boolean fUC;
    public Boolean fUw;
    public long fUy;
    public int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.vj
 * JD-Core Version:    0.7.0.1
 */