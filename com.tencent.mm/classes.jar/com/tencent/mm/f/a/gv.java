package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gv
  extends IEvent
{
  public a fDl;
  public b fDm;
  
  public gv()
  {
    this((byte)0);
  }
  
  private gv(byte paramByte)
  {
    AppMethodBeat.i(127288);
    this.fDl = new a();
    this.fDm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127288);
  }
  
  public static final class a
  {
    public int fDn = 0;
    public int state = -1;
    public String talker;
  }
  
  public static final class b
  {
    public int state = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.gv
 * JD-Core Version:    0.7.0.1
 */