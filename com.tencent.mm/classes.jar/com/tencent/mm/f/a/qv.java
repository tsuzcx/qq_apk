package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qv
  extends IEvent
{
  public a fPE;
  public b fPF;
  
  public qv()
  {
    this((byte)0);
  }
  
  private qv(byte paramByte)
  {
    AppMethodBeat.i(117551);
    this.fPE = new a();
    this.fPF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117551);
  }
  
  public static final class a
  {
    public Context context;
    public String fPG;
    public int opType = 0;
  }
  
  public static final class b
  {
    public String fPH;
    public boolean fyl = false;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.qv
 * JD-Core Version:    0.7.0.1
 */