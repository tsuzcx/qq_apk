package com.tencent.mm.plugin.fts.a.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract interface e
{
  public abstract List<c> GE(long paramLong);
  
  public abstract int Nn(int paramInt);
  
  public abstract a No(int paramInt);
  
  public abstract void a(String paramString, MMHandler paramMMHandler, HashSet<String> paramHashSet, long paramLong);
  
  public abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  public abstract void clearData();
  
  public abstract int dOF();
  
  public abstract void dOG();
  
  public abstract LinkedList<Integer> dOH();
  
  public abstract int dOI();
  
  public abstract long dOJ();
  
  public abstract int getType();
  
  public static final class a
  {
    public int businessType = 0;
    public List<m> mWl = null;
    public boolean tuG = false;
    public h wWd = null;
    public int wXD = 2147483647;
    public boolean wXE = true;
    public int wXF = 2147483647;
    public boolean wXG = true;
    public m wXH;
    public int wXI = 0;
    
    public final String toString()
    {
      int i = 0;
      AppMethodBeat.i(131734);
      int j = this.wXD;
      boolean bool1 = this.wXE;
      int k = this.wXF;
      boolean bool2 = this.tuG;
      int m = this.businessType;
      if (this.mWl == null) {}
      for (;;)
      {
        String str = String.format("{%d, %b, %d, %b, %d, %d, %d}", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(k), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.wXI) });
        AppMethodBeat.o(131734);
        return str;
        i = this.mWl.size();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e parame, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.e
 * JD-Core Version:    0.7.0.1
 */