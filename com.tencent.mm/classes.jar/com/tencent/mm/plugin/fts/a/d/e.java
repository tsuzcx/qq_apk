package com.tencent.mm.plugin.fts.a.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract interface e
{
  public abstract int Wi(int paramInt);
  
  public abstract a Wj(int paramInt);
  
  public abstract void a(String paramString, MMHandler paramMMHandler, HashSet<String> paramHashSet);
  
  public abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  public abstract void clearData();
  
  public abstract void fxG();
  
  public abstract LinkedList<Integer> fxH();
  
  public abstract int fxI();
  
  public abstract long fxJ();
  
  public abstract int getType();
  
  public abstract List<com.tencent.mm.plugin.fts.a.a.e> rs(long paramLong);
  
  public static class a
  {
    public boolean ABD = false;
    public j FWt = null;
    public int Huj = 2147483647;
    public boolean Huk = true;
    public int Hul = 2147483647;
    public o Hum;
    public int Hun = 0;
    public int businessType = 0;
    public List<o> tbH = null;
    public boolean vpw = true;
    
    public String toString()
    {
      int i = 0;
      AppMethodBeat.i(131734);
      int j = this.Huj;
      boolean bool1 = this.Huk;
      int k = this.Hul;
      boolean bool2 = this.ABD;
      int m = this.businessType;
      if (this.tbH == null) {}
      for (;;)
      {
        String str = String.format("{%d, %b, %d, %b, %d, %d, %d}", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(k), Boolean.valueOf(bool2), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.Hun) });
        AppMethodBeat.o(131734);
        return str;
        i = this.tbH.size();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e parame, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.e
 * JD-Core Version:    0.7.0.1
 */