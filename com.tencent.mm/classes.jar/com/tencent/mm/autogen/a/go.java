package com.tencent.mm.autogen.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class go
  extends IEvent
{
  public a hGU;
  public b hGV;
  
  public go()
  {
    this((byte)0);
  }
  
  private go(byte paramByte)
  {
    AppMethodBeat.i(19806);
    this.hGU = new a();
    this.hGV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19806);
  }
  
  public static final class a
  {
    public String[] hGW;
  }
  
  public static final class b
  {
    public int hGD = 0;
    public MatrixCursor hGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.go
 * JD-Core Version:    0.7.0.1
 */