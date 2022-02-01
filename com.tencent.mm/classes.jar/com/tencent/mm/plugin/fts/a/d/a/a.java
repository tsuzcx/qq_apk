package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
{
  public String info;
  public int mve;
  public int pageType;
  public final int position;
  public final int qcr;
  public int rjr;
  public h wWd;
  public boolean wXJ;
  public boolean wXK = true;
  public int wXL;
  public int wXM;
  public String wXN;
  public long wXO;
  public boolean wXP;
  public int wXQ;
  public int wXR;
  public long wXS;
  public boolean wXT;
  
  public a(int paramInt1, int paramInt2)
  {
    this.qcr = paramInt1;
    this.position = paramInt2;
    Log.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(Context paramContext, a parama, Object... paramVarArgs) {}
  
  public abstract b axc();
  
  public String bCR()
  {
    return "";
  }
  
  public int bCS()
  {
    return 0;
  }
  
  public int dOK()
  {
    return 0;
  }
  
  public boolean dOL()
  {
    return false;
  }
  
  public int dOM()
  {
    return 0;
  }
  
  public final void gE(int paramInt1, int paramInt2)
  {
    this.wXQ = paramInt1;
    this.wXR = paramInt2;
    this.wXT = true;
  }
  
  public String getAppId()
  {
    return "";
  }
  
  public abstract class a
  {
    public a() {}
  }
  
  public abstract class b
  {
    public b() {}
    
    protected static void a(String paramString, m paramm)
    {
      ((n)g.ah(n.class)).updateTopHitsRank(paramString, paramm, 0);
    }
    
    public abstract View a(Context paramContext, ViewGroup paramViewGroup);
    
    public abstract void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs);
    
    public abstract boolean a(Context paramContext, View paramView, a paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */