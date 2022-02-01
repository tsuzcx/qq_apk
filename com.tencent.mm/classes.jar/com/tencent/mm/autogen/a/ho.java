package com.tencent.mm.autogen.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.event.IEvent;

public final class ho
  extends IEvent
{
  public a hIw;
  public b hIx;
  
  public ho()
  {
    this((byte)0);
  }
  
  private ho(byte paramByte)
  {
    AppMethodBeat.i(127403);
    this.hIw = new a();
    this.hIx = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127403);
  }
  
  public static final class a
  {
    public Context context;
    public long hDn;
    public int hIA;
    public boolean hIB = false;
    public boolean hIC = false;
    public boolean hID = true;
    public arf hIy;
    public ImageView hIz;
    public int height;
    public int maxWidth;
    public int opType = -1;
    public int width;
  }
  
  public static final class b
  {
    public Bitmap hIE;
    public int ret = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ho
 * JD-Core Version:    0.7.0.1
 */