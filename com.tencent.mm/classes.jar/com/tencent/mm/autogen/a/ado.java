package com.tencent.mm.autogen.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ado
  extends IEvent
{
  public a ihJ;
  public b ihK;
  
  public ado()
  {
    this((byte)0);
  }
  
  private ado(byte paramByte)
  {
    AppMethodBeat.i(19848);
    this.ihJ = new a();
    this.ihK = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19848);
  }
  
  public static final class a
  {
    public Context context;
    public int hGz = 0;
    public String ihL;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor hGA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ado
 * JD-Core Version:    0.7.0.1
 */