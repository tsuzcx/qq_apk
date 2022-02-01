package com.tencent.mm.plugin.fts.a.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract interface e
{
  public abstract int FB(int paramInt);
  
  public abstract a FC(int paramInt);
  
  public abstract void a(String paramString, ao paramao, HashSet<String> paramHashSet, long paramLong);
  
  public abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  public abstract int cKC();
  
  public abstract void cKD();
  
  public abstract LinkedList<Integer> cKE();
  
  public abstract int cKF();
  
  public abstract long cKG();
  
  public abstract void clearData();
  
  public abstract int getType();
  
  public abstract List<c> vu(long paramLong);
  
  public static final class a
  {
    public int businessType = 0;
    public List<m> lnk = null;
    public boolean qYO = false;
    public h sxM = null;
    public int szm = 2147483647;
    public boolean szn = true;
    public int szo = 2147483647;
    public boolean szp = true;
    public m szq;
    public int szr = 0;
    
    public final String toString()
    {
      int i = 0;
      AppMethodBeat.i(131734);
      int j = this.szm;
      boolean bool1 = this.szn;
      int k = this.szo;
      boolean bool2 = this.qYO;
      int m = this.businessType;
      if (this.lnk == null) {}
      for (;;)
      {
        String str = String.format("{%d, %b, %d, %b, %d, %d, %d}", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(k), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.szr) });
        AppMethodBeat.o(131734);
        return str;
        i = this.lnk.size();
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