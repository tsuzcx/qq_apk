package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class zx
  extends IEvent
{
  public a fZj;
  
  public zx()
  {
    this((byte)0);
  }
  
  private zx(byte paramByte)
  {
    AppMethodBeat.i(149893);
    this.fZj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149893);
  }
  
  public static final class a
  {
    public List<dhn> fZk;
    public int fyH = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.zx
 * JD-Core Version:    0.7.0.1
 */