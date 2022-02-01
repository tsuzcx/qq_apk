package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
{
  public final ViewGroup parent;
  public final LinkedList<View> uzo;
  public a uzp;
  
  public e(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131473);
    this.uzo = new LinkedList();
    this.parent = paramViewGroup;
    AppMethodBeat.o(131473);
  }
  
  public static final class a
  {
    public final long mWR;
    public final long rTI;
    
    private a(long paramLong1, long paramLong2)
    {
      this.mWR = paramLong1;
      this.rTI = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.e
 * JD-Core Version:    0.7.0.1
 */