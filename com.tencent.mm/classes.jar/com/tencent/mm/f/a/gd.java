package com.tencent.mm.f.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gd
  extends IEvent
{
  public a fCf;
  public b fCg;
  
  public gd()
  {
    this((byte)0);
  }
  
  private gd(byte paramByte)
  {
    AppMethodBeat.i(19806);
    this.fCf = new a();
    this.fCg = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19806);
  }
  
  public static final class a
  {
    public String[] fCh;
  }
  
  public static final class b
  {
    public int fBO = 0;
    public MatrixCursor fCi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.gd
 * JD-Core Version:    0.7.0.1
 */