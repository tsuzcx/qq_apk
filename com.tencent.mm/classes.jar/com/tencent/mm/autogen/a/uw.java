package com.tencent.mm.autogen.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.sdk.event.IEvent;

public final class uw
  extends IEvent
{
  public a hYI;
  
  public uw()
  {
    this((byte)0);
  }
  
  private uw(byte paramByte)
  {
    AppMethodBeat.i(103547);
    this.hYI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(103547);
  }
  
  public static final class a
  {
    public Rect hYJ;
    public int hYK = 90;
    public m hYL;
    public int height = -1;
    public int width = -1;
    public byte[] yuvData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.uw
 * JD-Core Version:    0.7.0.1
 */