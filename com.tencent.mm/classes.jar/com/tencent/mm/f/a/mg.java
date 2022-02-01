package com.tencent.mm.f.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.event.IEvent;

public final class mg
  extends IEvent
{
  public a fKj;
  public b fKk;
  
  public mg()
  {
    this((byte)0);
  }
  
  private mg(byte paramByte)
  {
    AppMethodBeat.i(149868);
    this.fKj = new a();
    this.fKk = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149868);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public al fKl;
    public WXMediaMessage fvl;
    public int fwp;
    public Bundle fyw;
  }
  
  public static final class b
  {
    public boolean fKm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.mg
 * JD-Core Version:    0.7.0.1
 */