package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fu
  extends b
{
  public a drh;
  public b dri;
  
  public fu()
  {
    this((byte)0);
  }
  
  private fu(byte paramByte)
  {
    AppMethodBeat.i(19807);
    this.drh = new a();
    this.dri = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(19807);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public String[] djJ;
    public int dqC = 0;
    public String[] selectionArgs;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor dqD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.fu
 * JD-Core Version:    0.7.0.1
 */