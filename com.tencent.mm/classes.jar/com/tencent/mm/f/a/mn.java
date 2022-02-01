package com.tencent.mm.f.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.sdk.event.IEvent;

public final class mn
  extends IEvent
{
  public a fKE;
  public b fKF;
  
  public mn()
  {
    this((byte)0);
  }
  
  private mn(byte paramByte)
  {
    AppMethodBeat.i(127406);
    this.fKE = new a();
    this.fKF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127406);
  }
  
  public static final class a
  {
    public int fKG = 0;
    public String fKH;
    public float fKI = 0.0F;
    public int fKJ = 0;
    public String filename;
    public q fzz;
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
 * Qualified Name:     com.tencent.mm.f.a.mn
 * JD-Core Version:    0.7.0.1
 */