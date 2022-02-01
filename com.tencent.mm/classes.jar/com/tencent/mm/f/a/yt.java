package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yt
  extends IEvent
{
  public a fXU;
  public b fXV;
  
  public yt()
  {
    this((byte)0);
  }
  
  private yt(byte paramByte)
  {
    AppMethodBeat.i(116051);
    this.fXU = new a();
    this.fXV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116051);
  }
  
  public static final class a
  {
    public Context context;
    public String fXW;
    public int opType = 0;
  }
  
  public static final class b
  {
    public String fPH;
    public boolean fyl = false;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.yt
 * JD-Core Version:    0.7.0.1
 */