package com.tencent.mm.f.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wj
  extends IEvent
{
  public a fVC;
  
  public wj()
  {
    this((byte)0);
  }
  
  private wj(byte paramByte)
  {
    AppMethodBeat.i(268008);
    this.fVC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(268008);
  }
  
  public static final class a
  {
    public int Vh;
    public Intent fJJ;
    public int requestCode;
    public int resultCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.wj
 * JD-Core Version:    0.7.0.1
 */