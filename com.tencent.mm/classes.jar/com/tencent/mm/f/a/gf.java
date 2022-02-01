package com.tencent.mm.f.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gf
  extends IEvent
{
  public a fCn;
  public b fCo;
  
  public gf()
  {
    this((byte)0);
  }
  
  private gf(byte paramByte)
  {
    AppMethodBeat.i(19807);
    this.fCn = new a();
    this.fCo = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19807);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public int fBK = 0;
    public String[] fuA;
    public String[] fuz;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor fBL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.gf
 * JD-Core Version:    0.7.0.1
 */