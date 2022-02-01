package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zk
  extends IEvent
{
  public a fYN;
  
  public zk()
  {
    this((byte)0);
  }
  
  private zk(byte paramByte)
  {
    AppMethodBeat.i(116055);
    this.fYN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116055);
  }
  
  public static final class a
  {
    public String fWy;
    public String fYF;
    public byte[] fYH;
    public String fYO;
    public int fYP = 0;
    public String id;
    public int ret;
    public String source;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.zk
 * JD-Core Version:    0.7.0.1
 */