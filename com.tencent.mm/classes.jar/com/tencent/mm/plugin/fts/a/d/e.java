package com.tencent.mm.plugin.fts.a.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract interface e
{
  public abstract int GQ(int paramInt);
  
  public abstract a GR(int paramInt);
  
  public abstract void a(String paramString, ap paramap, HashSet<String> paramHashSet, long paramLong);
  
  public abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  public abstract int cSR();
  
  public abstract void cSS();
  
  public abstract LinkedList<Integer> cST();
  
  public abstract int cSU();
  
  public abstract long cSV();
  
  public abstract void clearData();
  
  public abstract int getType();
  
  public abstract List<c> xA(long paramLong);
  
  public static final class a
  {
    public int businessType = 0;
    public List<m> lKC = null;
    public boolean rKf = false;
    public h tun = null;
    public int tvN = 2147483647;
    public boolean tvO = true;
    public int tvP = 2147483647;
    public boolean tvQ = true;
    public m tvR;
    public int tvS = 0;
    
    public final String toString()
    {
      int i = 0;
      AppMethodBeat.i(131734);
      int j = this.tvN;
      boolean bool1 = this.tvO;
      int k = this.tvP;
      boolean bool2 = this.rKf;
      int m = this.businessType;
      if (this.lKC == null) {}
      for (;;)
      {
        String str = String.format("{%d, %b, %d, %b, %d, %d, %d}", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(k), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.tvS) });
        AppMethodBeat.o(131734);
        return str;
        i = this.lKC.size();
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