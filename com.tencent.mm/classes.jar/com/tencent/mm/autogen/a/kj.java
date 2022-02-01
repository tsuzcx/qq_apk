package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kj
  extends IEvent
{
  public a hLZ;
  
  public kj()
  {
    this((byte)0);
  }
  
  private kj(byte paramByte)
  {
    AppMethodBeat.i(116030);
    this.hLZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116030);
  }
  
  public static final class a
  {
    public int actionCode;
    public String appId;
    public Context context;
    public String extMsg;
    public String messageAction;
    public String messageExt;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.kj
 * JD-Core Version:    0.7.0.1
 */