package com.tencent.mm.f.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gb
  extends IEvent
{
  public a fBQ;
  public b fBR;
  
  public gb()
  {
    this((byte)0);
  }
  
  private gb(byte paramByte)
  {
    AppMethodBeat.i(116016);
    this.fBQ = new a();
    this.fBR = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116016);
  }
  
  public static final class a
  {
    public String fBS;
  }
  
  public static final class b
  {
    public Cursor fBL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.gb
 * JD-Core Version:    0.7.0.1
 */