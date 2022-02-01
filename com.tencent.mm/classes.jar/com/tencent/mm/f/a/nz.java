package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class nz
  extends IEvent
{
  public a fMM;
  public b fMN;
  
  public nz()
  {
    this((byte)0);
  }
  
  private nz(byte paramByte)
  {
    AppMethodBeat.i(138164);
    this.fMM = new a();
    this.fMN = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(138164);
  }
  
  public static final class a
  {
    public String fKz;
    public boolean fMo = false;
  }
  
  public static final class b
  {
    public int fLk = 0;
    public LinkedList<cqk> fMA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.nz
 * JD-Core Version:    0.7.0.1
 */