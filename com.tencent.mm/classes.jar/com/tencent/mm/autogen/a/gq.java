package com.tencent.mm.autogen.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gq
  extends IEvent
{
  public a hHc;
  public b hHd;
  
  public gq()
  {
    this((byte)0);
  }
  
  private gq(byte paramByte)
  {
    AppMethodBeat.i(19807);
    this.hHc = new a();
    this.hHd = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19807);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public int hGz = 0;
    public String[] hyR;
    public String[] hyS;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor hGA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gq
 * JD-Core Version:    0.7.0.1
 */