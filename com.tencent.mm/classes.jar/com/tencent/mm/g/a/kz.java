package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.b.b;

public final class kz
  extends b
{
  public a dzg;
  public b dzh;
  
  public kz()
  {
    this((byte)0);
  }
  
  private kz(byte paramByte)
  {
    AppMethodBeat.i(149868);
    this.dzg = new a();
    this.dzh = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(149868);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public int dmr;
    public Bundle doz;
    public WXMediaMessage dve;
    public al dzi;
  }
  
  public static final class b
  {
    public boolean dzj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.kz
 * JD-Core Version:    0.7.0.1
 */