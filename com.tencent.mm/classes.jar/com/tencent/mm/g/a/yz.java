package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class yz
  extends b
{
  public a dNV;
  public b dNW;
  
  public yz()
  {
    this((byte)0);
  }
  
  private yz(byte paramByte)
  {
    AppMethodBeat.i(19848);
    this.dNV = new a();
    this.dNW = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(19848);
  }
  
  public static final class a
  {
    public String callingPackage;
    public Context context;
    public int dqC = 0;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor dqD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.yz
 * JD-Core Version:    0.7.0.1
 */