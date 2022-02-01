package com.tencent.mm.autogen.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qm
  extends IEvent
{
  public a hTJ;
  public b hTK;
  
  public qm()
  {
    this((byte)0);
  }
  
  private qm(byte paramByte)
  {
    AppMethodBeat.i(127408);
    this.hTJ = new a();
    this.hTK = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127408);
  }
  
  public static final class a
  {
    public Context context;
    public int hIY = 0;
    public int hIZ = 0;
    public String hTA;
    public Bundle hTF;
    public String hTL;
    public String hTM;
    public long hTN = 0L;
    public int itemType = 0;
    public int type = 0;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.qm
 * JD-Core Version:    0.7.0.1
 */