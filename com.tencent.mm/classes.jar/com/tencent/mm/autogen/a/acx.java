package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.sdk.event.IEvent;

public final class acx
  extends IEvent
{
  public a igk;
  public b igl;
  
  public acx()
  {
    this((byte)0);
  }
  
  private acx(byte paramByte)
  {
    AppMethodBeat.i(91223);
    this.igk = new a();
    this.igl = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91223);
  }
  
  public static final class a
  {
    public Runnable callback;
    public String scene;
  }
  
  public static final class b
  {
    public String content;
    public String igm;
    public dus ign;
    public int type;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.acx
 * JD-Core Version:    0.7.0.1
 */