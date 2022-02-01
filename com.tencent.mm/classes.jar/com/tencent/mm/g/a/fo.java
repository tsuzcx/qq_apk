package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fo
  extends b
{
  public a dqA;
  public b dqB;
  
  public fo()
  {
    this((byte)0);
  }
  
  private fo(byte paramByte)
  {
    AppMethodBeat.i(19804);
    this.dqA = new a();
    this.dqB = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(19804);
  }
  
  public static final class a
  {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fo
 * JD-Core Version:    0.7.0.1
 */