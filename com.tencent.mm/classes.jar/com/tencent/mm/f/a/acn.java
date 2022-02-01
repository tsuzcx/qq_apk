package com.tencent.mm.f.a;

import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class acn
  extends IEvent
{
  public a gcN;
  
  public acn()
  {
    this((byte)0);
  }
  
  private acn(byte paramByte)
  {
    AppMethodBeat.i(206580);
    this.gcN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(206580);
  }
  
  public static final class a
  {
    public int event = 0;
    public CdnLogic.C2CDownloadResult gcO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.a.acn
 * JD-Core Version:    0.7.0.1
 */