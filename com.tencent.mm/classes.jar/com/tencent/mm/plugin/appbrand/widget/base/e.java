package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
{
  public final ViewGroup parent;
  public final LinkedList<View> rpd;
  public a rpe;
  
  public e(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131473);
    this.rpd = new LinkedList();
    this.parent = paramViewGroup;
    AppMethodBeat.o(131473);
  }
  
  public static final class a
  {
    public final long ksY;
    public final long oPU;
    
    private a(long paramLong1, long paramLong2)
    {
      this.ksY = paramLong1;
      this.oPU = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.e
 * JD-Core Version:    0.7.0.1
 */