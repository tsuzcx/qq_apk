package com.tencent.mm.g.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.IEvent;

public final class gw
  extends IEvent
{
  public a dKR;
  public b dKS;
  
  public gw()
  {
    this((byte)0);
  }
  
  private gw(byte paramByte)
  {
    AppMethodBeat.i(127403);
    this.dKR = new a();
    this.dKS = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127403);
  }
  
  public static final class a
  {
    public Context context;
    public long dFW;
    public aml dKT;
    public ImageView dKU;
    public int dKV;
    public boolean dKW = false;
    public boolean dKX = false;
    public boolean dKY = true;
    public int height;
    public int maxWidth;
    public int opType = -1;
    public int width;
  }
  
  public static final class b
  {
    public Bitmap dKZ;
    public int ret = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.gw
 * JD-Core Version:    0.7.0.1
 */