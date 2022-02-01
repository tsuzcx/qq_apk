package com.tencent.mm.autogen.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class gn
  extends IEvent
{
  public a hGI;
  public b hGJ;
  
  public gn()
  {
    this((byte)0);
  }
  
  private gn(byte paramByte)
  {
    AppMethodBeat.i(116017);
    this.hGI = new a();
    this.hGJ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116017);
  }
  
  public static final class a
  {
    public Cursor hGK;
  }
  
  public static final class b
  {
    public String hGL;
    public int hGM;
    public String hGN;
    public long hGO;
    public int hGP;
    public List hGQ;
    public List hGR;
    public int hGS;
    public int hGT;
    public int mediaType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gn
 * JD-Core Version:    0.7.0.1
 */