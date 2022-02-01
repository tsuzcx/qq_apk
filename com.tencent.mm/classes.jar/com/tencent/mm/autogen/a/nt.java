package com.tencent.mm.autogen.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.event.IEvent;

public final class nt
  extends IEvent
{
  public a hQk;
  public b hQl;
  
  public nt()
  {
    this((byte)0);
  }
  
  private nt(byte paramByte)
  {
    AppMethodBeat.i(127406);
    this.hQk = new a();
    this.hQl = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127406);
  }
  
  public static final class a
  {
    public String filename;
    public p hEi;
    public int hQm = 0;
    public String hQn;
    public float hQo = 0.0F;
    public int hQp = 0;
    public int height = 0;
    public float latitude = 0.0F;
    public View view;
    public int width = 0;
  }
  
  public static final class b
  {
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.nt
 * JD-Core Version:    0.7.0.1
 */