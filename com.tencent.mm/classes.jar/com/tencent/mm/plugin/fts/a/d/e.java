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
  public abstract int DF(int paramInt);
  
  public abstract a DG(int paramInt);
  
  public abstract void a(String paramString, ap paramap, HashSet<String> paramHashSet, long paramLong);
  
  public abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  public abstract void clearData();
  
  public abstract int cxq();
  
  public abstract void cxr();
  
  public abstract LinkedList<Integer> cxs();
  
  public abstract int cxt();
  
  public abstract long cxu();
  
  public abstract int getType();
  
  public abstract List<c> qR(long paramLong);
  
  public static final class a
  {
    public int businessType = 0;
    public List<m> kLN = null;
    public boolean qpI = false;
    public h roS = null;
    public int rqs = 2147483647;
    public boolean rqt = true;
    public int rqu = 2147483647;
    public boolean rqv = true;
    public m rqw;
    public int rqx = 0;
    
    public final String toString()
    {
      int i = 0;
      AppMethodBeat.i(131734);
      int j = this.rqs;
      boolean bool1 = this.rqt;
      int k = this.rqu;
      boolean bool2 = this.qpI;
      int m = this.businessType;
      if (this.kLN == null) {}
      for (;;)
      {
        String str = String.format("{%d, %b, %d, %b, %d, %d, %d}", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(k), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.rqx) });
        AppMethodBeat.o(131734);
        return str;
        i = this.kLN.size();
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