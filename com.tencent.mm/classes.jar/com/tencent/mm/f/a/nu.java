package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class nu
  extends IEvent
{
  public a fMm;
  
  public nu()
  {
    this((byte)0);
  }
  
  private nu(byte paramByte)
  {
    AppMethodBeat.i(101728);
    this.fMm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(101728);
  }
  
  public static final class a
  {
    public LinkedList<chv> fMn;
    public boolean fMo = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.nu
 * JD-Core Version:    0.7.0.1
 */