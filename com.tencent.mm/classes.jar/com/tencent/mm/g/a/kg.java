package com.tencent.mm.g.a;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class kg
  extends IEvent
{
  public a dPi;
  public b dPj;
  
  public kg()
  {
    this((byte)0);
  }
  
  private kg(byte paramByte)
  {
    AppMethodBeat.i(55663);
    this.dPi = new a();
    this.dPj = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55663);
  }
  
  public static final class a
  {
    public ca dCM;
    public ImageView dPk;
    public ImageView dPl;
    public ProgressBar dPm;
    public int dPn;
    public int h;
    public int w;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.kg
 * JD-Core Version:    0.7.0.1
 */