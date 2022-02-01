package com.tencent.mm.autogen.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.event.IEvent;

public final class nm
  extends IEvent
{
  public a hPP;
  public b hPQ;
  
  public nm()
  {
    this((byte)0);
  }
  
  private nm(byte paramByte)
  {
    AppMethodBeat.i(149868);
    this.hPP = new a();
    this.hPQ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149868);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public int hAN;
    public Bundle hDf;
    public ap hPR;
    public WXMediaMessage hzF;
  }
  
  public static final class b
  {
    public boolean hPS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.nm
 * JD-Core Version:    0.7.0.1
 */