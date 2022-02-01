package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.event.IEvent;

public final class xg
  extends IEvent
{
  public a fWk;
  public b fWl;
  
  public xg()
  {
    this((byte)0);
  }
  
  private xg(byte paramByte)
  {
    AppMethodBeat.i(148772);
    this.fWk = new a();
    this.fWl = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(148772);
  }
  
  public static final class a
  {
    public String fVR;
    public cuv fWm;
    public Runnable fWn;
    public e fWo;
    public int scene;
  }
  
  public static final class b
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.xg
 * JD-Core Version:    0.7.0.1
 */