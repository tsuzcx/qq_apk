package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zj
  extends IEvent
{
  public a efx;
  public b efy;
  
  public zj()
  {
    this((byte)0);
  }
  
  private zj(byte paramByte)
  {
    AppMethodBeat.i(149895);
    this.efx = new a();
    this.efy = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149895);
  }
  
  public static final class a
  {
    public String content;
    public Context context;
    public int dKy = 0;
    public byte[] efs;
    public int eft = 0;
    public String talker;
  }
  
  public static final class b
  {
    public boolean calling = false;
    public boolean efz = false;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.zj
 * JD-Core Version:    0.7.0.1
 */