package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fs
  extends IEvent
{
  public a dIR;
  public b dIS;
  
  public fs()
  {
    this((byte)0);
  }
  
  private fs(byte paramByte)
  {
    AppMethodBeat.i(19804);
    this.dIR = new a();
    this.dIS = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19804);
  }
  
  public static final class a
  {
    public Context context;
    public String[] dBX;
    public int dIT = 0;
    public String[] selectionArgs;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor dIU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.fs
 * JD-Core Version:    0.7.0.1
 */