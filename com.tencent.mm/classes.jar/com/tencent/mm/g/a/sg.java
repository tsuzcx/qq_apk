package com.tencent.mm.g.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.sdk.event.IEvent;

public final class sg
  extends IEvent
{
  public a dYR;
  
  public sg()
  {
    this((byte)0);
  }
  
  private sg(byte paramByte)
  {
    AppMethodBeat.i(103547);
    this.dYR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(103547);
  }
  
  public static final class a
  {
    public Rect dYS;
    public int dYT = 90;
    public r dYU;
    public int height = -1;
    public int width = -1;
    public byte[] yuvData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.sg
 * JD-Core Version:    0.7.0.1
 */