package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.b.b;

public final class kp
  extends b
{
  public a dmn;
  public b dmo;
  
  public kp()
  {
    this((byte)0);
  }
  
  private kp(byte paramByte)
  {
    AppMethodBeat.i(149868);
    this.dmn = new a();
    this.dmo = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(149868);
  }
  
  public static final class a
  {
    public String appId;
    public int cZX;
    public Context context;
    public Bundle dcb;
    public WXMediaMessage dis;
    public am dmp;
  }
  
  public static final class b
  {
    public boolean dmq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.kp
 * JD-Core Version:    0.7.0.1
 */