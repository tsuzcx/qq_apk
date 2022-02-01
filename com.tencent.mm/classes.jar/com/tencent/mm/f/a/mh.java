package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class mh
  extends IEvent
{
  public a fKn;
  public b fKo;
  
  public mh()
  {
    this((byte)0);
  }
  
  private mh(byte paramByte)
  {
    AppMethodBeat.i(63290);
    this.fKn = new a();
    this.fKo = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63290);
  }
  
  public static final class a
  {
    public Context context;
    public ArrayList fKp;
    public String fKq;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.mh
 * JD-Core Version:    0.7.0.1
 */