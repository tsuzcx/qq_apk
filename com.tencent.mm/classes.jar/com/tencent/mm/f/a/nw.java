package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class nw
  extends IEvent
{
  public a fMy;
  public b fMz;
  
  public nw()
  {
    this((byte)0);
  }
  
  private nw(byte paramByte)
  {
    AppMethodBeat.i(116460);
    this.fMy = new a();
    this.fMz = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116460);
  }
  
  public static final class a
  {
    public String chatroomName;
    public LinkedList<String> fMA;
    public boolean fMo = false;
    public int scene = 0;
  }
  
  public static final class b
  {
    public int errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.nw
 * JD-Core Version:    0.7.0.1
 */