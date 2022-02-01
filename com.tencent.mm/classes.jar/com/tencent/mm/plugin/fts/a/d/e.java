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
  public abstract List<c> NG(long paramLong);
  
  public abstract int SB(int paramInt);
  
  public abstract a SC(int paramInt);
  
  public abstract void a(String paramString, MMHandler paramMMHandler, HashSet<String> paramHashSet, long paramLong);
  
  public abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  public abstract void clearData();
  
  public abstract int eqW();
  
  public abstract void eqZ();
  
  public abstract LinkedList<Integer> era();
  
  public abstract int erb();
  
  public abstract long erc();
  
  public abstract int getType();
  
  public static final class a
  {
    public h BHY = null;
    public boolean BJA = true;
    public int BJB = 2147483647;
    public boolean BJC = true;
    public m BJD;
    public int BJE = 0;
    public int BJz = 2147483647;
    public int businessType = 0;
    public List<m> pWR = null;
    public boolean xcp = false;
    
    public final String toString()
    {
      int i = 0;
      AppMethodBeat.i(131734);
      int j = this.BJz;
      boolean bool1 = this.BJA;
      int k = this.BJB;
      boolean bool2 = this.xcp;
      int m = this.businessType;
      if (this.pWR == null) {}
      for (;;)
      {
        String str = String.format("{%d, %b, %d, %b, %d, %d, %d}", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(k), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.BJE) });
        AppMethodBeat.o(131734);
        return str;
        i = this.pWR.size();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e parame, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.e
 * JD-Core Version:    0.7.0.1
 */