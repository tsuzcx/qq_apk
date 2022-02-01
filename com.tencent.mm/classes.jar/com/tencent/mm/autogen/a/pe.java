package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class pe
  extends IEvent
{
  public a hSi;
  public b hSj;
  
  public pe()
  {
    this((byte)0);
  }
  
  private pe(byte paramByte)
  {
    AppMethodBeat.i(116460);
    this.hSi = new a();
    this.hSj = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116460);
  }
  
  public static final class a
  {
    public String chatroomName;
    public boolean hRY = false;
    public LinkedList<String> hSk;
    public int scene = 0;
  }
  
  public static final class b
  {
    public int errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pe
 * JD-Core Version:    0.7.0.1
 */