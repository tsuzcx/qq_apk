package com.tencent.mm.plugin.fts.a.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract interface e
{
  public abstract int Hn(int paramInt);
  
  public abstract a Ho(int paramInt);
  
  public abstract void a(String paramString, aq paramaq, HashSet<String> paramHashSet, long paramLong);
  
  public abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  public abstract long cVA();
  
  public abstract int cVw();
  
  public abstract void cVx();
  
  public abstract LinkedList<Integer> cVy();
  
  public abstract int cVz();
  
  public abstract void clearData();
  
  public abstract int getType();
  
  public abstract List<c> xU(long paramLong);
  
  public static final class a
  {
    public int businessType = 0;
    public List<m> lPc = null;
    public boolean rRg = false;
    public h tFe = null;
    public int tGE = 2147483647;
    public boolean tGF = true;
    public int tGG = 2147483647;
    public boolean tGH = true;
    public m tGI;
    public int tGJ = 0;
    
    public final String toString()
    {
      int i = 0;
      AppMethodBeat.i(131734);
      int j = this.tGE;
      boolean bool1 = this.tGF;
      int k = this.tGG;
      boolean bool2 = this.rRg;
      int m = this.businessType;
      if (this.lPc == null) {}
      for (;;)
      {
        String str = String.format("{%d, %b, %d, %b, %d, %d, %d}", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(k), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.tGJ) });
        AppMethodBeat.o(131734);
        return str;
        i = this.lPc.size();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e parame, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.e
 * JD-Core Version:    0.7.0.1
 */