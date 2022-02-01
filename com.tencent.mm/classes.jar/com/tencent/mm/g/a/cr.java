package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cr
  extends IEvent
{
  public a dFK;
  
  public cr()
  {
    this((byte)0);
  }
  
  private cr(byte paramByte)
  {
    AppMethodBeat.i(115973);
    this.dFK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115973);
  }
  
  public static final class a
  {
    public Activity activity;
    public String dDX;
    public int dFL;
    public int dFM;
    public String dFN;
    public String dFO;
    public Bundle dFP;
    public int from = -1;
    public String imagePath;
    public int scene = -1;
    public String source;
    public int sourceType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.cr
 * JD-Core Version:    0.7.0.1
 */