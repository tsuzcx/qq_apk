package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
{
  public j FWt;
  public boolean Huo;
  public boolean Hup = true;
  public int Huq;
  public int Hur;
  public String Hus;
  public long Hut;
  public boolean Huu;
  public int Huv;
  public int Huw;
  public long Hux;
  public boolean Huy;
  public String hZn;
  public int pageType;
  public final int position;
  public int syO;
  public final int viewType;
  public int xVf;
  
  public a(int paramInt1, int paramInt2)
  {
    this.viewType = paramInt1;
    this.position = paramInt2;
    Log.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(Context paramContext, a parama, Object... paramVarArgs) {}
  
  public abstract b aXA();
  
  public String coA()
  {
    return "";
  }
  
  public String coB()
  {
    return "";
  }
  
  public int coC()
  {
    return 0;
  }
  
  public String egv()
  {
    return "";
  }
  
  public int fxK()
  {
    return 0;
  }
  
  public boolean fxL()
  {
    return false;
  }
  
  public int fxM()
  {
    return 0;
  }
  
  public String getAppId()
  {
    return "";
  }
  
  public final void iW(int paramInt1, int paramInt2)
  {
    this.Huv = paramInt1;
    this.Huw = paramInt2;
    this.Huy = true;
  }
  
  public abstract class a
  {
    public a() {}
  }
  
  public abstract class b
  {
    public b() {}
    
    protected static void a(String paramString, o paramo)
    {
      ((n)h.az(n.class)).updateTopHitsRank(paramString, paramo, 0);
    }
    
    public abstract View a(Context paramContext, ViewGroup paramViewGroup);
    
    public abstract void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs);
    
    public abstract boolean a(Context paramContext, View paramView, a paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */