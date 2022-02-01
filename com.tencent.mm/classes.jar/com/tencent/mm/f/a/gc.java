package com.tencent.mm.f.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class gc
  extends IEvent
{
  public a fBT;
  public b fBU;
  
  public gc()
  {
    this((byte)0);
  }
  
  private gc(byte paramByte)
  {
    AppMethodBeat.i(116017);
    this.fBT = new a();
    this.fBU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116017);
  }
  
  public static final class a
  {
    public Cursor fBV;
  }
  
  public static final class b
  {
    public String fBW;
    public int fBX;
    public String fBY;
    public long fBZ;
    public int fCa;
    public List fCb;
    public List fCc;
    public int fCd;
    public int fCe;
    public int mediaType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.gc
 * JD-Core Version:    0.7.0.1
 */