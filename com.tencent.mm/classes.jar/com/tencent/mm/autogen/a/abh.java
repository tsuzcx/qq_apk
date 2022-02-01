package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abh
  extends IEvent
{
  public a ieS;
  
  public abh()
  {
    this((byte)0);
  }
  
  private abh(byte paramByte)
  {
    AppMethodBeat.i(140991);
    this.ieS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140991);
  }
  
  public static final class a
  {
    public String desc;
    public int hAM = 0;
    public int hAN = 0;
    public int hAO = 0;
    public String hAP;
    public int hAQ = 0;
    public String hAR;
    public int position = 0;
    public String url;
    public boolean visible = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abh
 * JD-Core Version:    0.7.0.1
 */