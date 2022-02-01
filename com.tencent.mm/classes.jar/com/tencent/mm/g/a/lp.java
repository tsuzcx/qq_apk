package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.event.IEvent;

public final class lp
  extends IEvent
{
  public a dQT;
  public b dQU;
  
  public lp()
  {
    this((byte)0);
  }
  
  private lp(byte paramByte)
  {
    AppMethodBeat.i(149868);
    this.dQT = new a();
    this.dQU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149868);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public WXMediaMessage dCE;
    public int dDG;
    public Bundle dFP;
    public al dQV;
  }
  
  public static final class b
  {
    public boolean dQW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.lp
 * JD-Core Version:    0.7.0.1
 */