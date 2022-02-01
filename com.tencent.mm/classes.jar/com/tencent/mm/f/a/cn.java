package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cn
  extends IEvent
{
  public a fyi;
  public b fyj;
  
  public cn()
  {
    this((byte)0);
  }
  
  private cn(byte paramByte)
  {
    AppMethodBeat.i(149859);
    this.fyi = new a();
    this.fyj = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149859);
  }
  
  public static final class a
  {
    public Context context;
    public String fyk;
    public String username;
  }
  
  public static final class b
  {
    public boolean fyl = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.cn
 * JD-Core Version:    0.7.0.1
 */