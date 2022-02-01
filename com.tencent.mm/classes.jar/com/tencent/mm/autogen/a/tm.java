package com.tencent.mm.autogen.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.Set;

public final class tm
  extends IEvent
{
  public a hXd;
  
  public tm()
  {
    this((byte)0);
  }
  
  private tm(byte paramByte)
  {
    AppMethodBeat.i(116040);
    this.hXd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116040);
  }
  
  public static final class a
  {
    public Bitmap bitmap;
    public String filePath;
    public long hBk;
    public Set hXe;
    public boolean hXf;
    public int hXg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.tm
 * JD-Core Version:    0.7.0.1
 */