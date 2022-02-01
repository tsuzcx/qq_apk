package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class a
{
  public String info;
  public int ljZ;
  public final int oIb;
  public int pLM;
  public int pageType;
  public final int position;
  public h tun;
  public boolean tvT;
  public boolean tvU = true;
  public int tvV;
  public int tvW;
  public String tvX;
  public long tvY;
  public boolean tvZ;
  public int twa;
  public int twb;
  public long twc;
  public boolean twd;
  
  public a(int paramInt1, int paramInt2)
  {
    this.oIb = paramInt1;
    this.position = paramInt2;
    ad.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs) {}
  
  public abstract a.b agC();
  
  public String bgV()
  {
    return "";
  }
  
  public int bgW()
  {
    return 0;
  }
  
  public int cSW()
  {
    return 0;
  }
  
  public boolean cSX()
  {
    return false;
  }
  
  public int cSY()
  {
    return 0;
  }
  
  public String getAppId()
  {
    return "";
  }
  
  public final void gf(int paramInt1, int paramInt2)
  {
    this.twa = paramInt1;
    this.twb = paramInt2;
    this.twd = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */