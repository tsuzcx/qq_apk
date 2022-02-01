package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.b.b;

public final class ky
  extends b
{
  public a dyb;
  public b dyc;
  
  public ky()
  {
    this((byte)0);
  }
  
  private ky(byte paramByte)
  {
    AppMethodBeat.i(149868);
    this.dyb = new a();
    this.dyc = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(149868);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public int dlp;
    public Bundle dnx;
    public WXMediaMessage dtZ;
    public al dyd;
  }
  
  public static final class b
  {
    public boolean dye;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ky
 * JD-Core Version:    0.7.0.1
 */