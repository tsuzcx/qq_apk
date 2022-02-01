package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
{
  public final ViewGroup fSZ;
  public final LinkedList<View> lRH;
  public a lRI;
  
  public e(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131473);
    this.lRH = new LinkedList();
    this.fSZ = paramViewGroup;
    AppMethodBeat.o(131473);
  }
  
  public static final class a
  {
    public final long jPn;
    public final long jPo;
    
    private a(long paramLong1, long paramLong2)
    {
      this.jPo = paramLong1;
      this.jPn = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.e
 * JD-Core Version:    0.7.0.1
 */