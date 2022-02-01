package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class od
  extends IEvent
{
  public a dUq;
  public b dUr;
  
  public od()
  {
    this((byte)0);
  }
  
  private od(byte paramByte)
  {
    AppMethodBeat.i(127408);
    this.dUq = new a();
    this.dUr = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127408);
  }
  
  public static final class a
  {
    public Context context;
    public int dLt = 0;
    public int dLu = 0;
    public String dUg;
    public Bundle dUl;
    public int dUm = 0;
    public String dUs;
    public long dUt = 0L;
    public String jsonString;
    public int type = 0;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.od
 * JD-Core Version:    0.7.0.1
 */