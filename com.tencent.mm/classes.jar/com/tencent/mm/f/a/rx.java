package com.tencent.mm.f.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.Set;

public final class rx
  extends IEvent
{
  public a fRg;
  
  public rx()
  {
    this((byte)0);
  }
  
  private rx(byte paramByte)
  {
    AppMethodBeat.i(116040);
    this.fRg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116040);
  }
  
  public static final class a
  {
    public Bitmap bitmap;
    public Set fRh;
    public boolean fRi;
    public int fRj;
    public String filePath;
    public long fwK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.rx
 * JD-Core Version:    0.7.0.1
 */