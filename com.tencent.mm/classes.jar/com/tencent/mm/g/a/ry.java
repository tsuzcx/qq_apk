package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ry
  extends IEvent
{
  public a dYw;
  
  public ry()
  {
    this((byte)0);
  }
  
  private ry(byte paramByte)
  {
    AppMethodBeat.i(116044);
    this.dYw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116044);
  }
  
  public static final class a
  {
    public Context context;
    public String dCw;
    public String dNI;
    public String dRL;
    public long dTS;
    public int dYx;
    public String dYy;
    public int dYz;
    public String mediaTagName;
    public int msgType;
    public String packageName;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ry
 * JD-Core Version:    0.7.0.1
 */