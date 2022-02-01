package com.tencent.mm.f.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.event.IEvent;

public final class hd
  extends IEvent
{
  public a fDG;
  public b fDH;
  
  public hd()
  {
    this((byte)0);
  }
  
  private hd(byte paramByte)
  {
    AppMethodBeat.i(127403);
    this.fDG = new a();
    this.fDH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127403);
  }
  
  public static final class a
  {
    public Context context;
    public anm fDI;
    public ImageView fDJ;
    public int fDK;
    public boolean fDL = false;
    public boolean fDM = false;
    public boolean fDN = true;
    public long fyE;
    public int height;
    public int maxWidth;
    public int opType = -1;
    public int width;
  }
  
  public static final class b
  {
    public Bitmap fDO;
    public int ret = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.hd
 * JD-Core Version:    0.7.0.1
 */