package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class tn
  extends IEvent
{
  public a fST;
  
  public tn()
  {
    this((byte)0);
  }
  
  private tn(byte paramByte)
  {
    AppMethodBeat.i(125629);
    this.fST = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125629);
  }
  
  public static final class a
  {
    public ArrayList fSU;
    public String fSV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.tn
 * JD-Core Version:    0.7.0.1
 */