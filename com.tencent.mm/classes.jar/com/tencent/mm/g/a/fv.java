package com.tencent.mm.g.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class fv
  extends IEvent
{
  public a dJe;
  public b dJf;
  
  public fv()
  {
    this((byte)0);
  }
  
  private fv(byte paramByte)
  {
    AppMethodBeat.i(116017);
    this.dJe = new a();
    this.dJf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116017);
  }
  
  public static final class a
  {
    public Cursor dJg;
  }
  
  public static final class b
  {
    public String dJh;
    public int dJi;
    public String dJj;
    public long dJk;
    public int dJl;
    public List dJm;
    public List dJn;
    public int dJo;
    public int dJp;
    public int mediaType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fv
 * JD-Core Version:    0.7.0.1
 */