package com.tencent.mm.g.a;

import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abf
  extends IEvent
{
  public a eiy;
  
  public abf()
  {
    this((byte)0);
  }
  
  private abf(byte paramByte)
  {
    AppMethodBeat.i(230552);
    this.eiy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(230552);
  }
  
  public static final class a
  {
    public CdnLogic.C2CDownloadResult eiz;
    public int event = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.abf
 * JD-Core Version:    0.7.0.1
 */