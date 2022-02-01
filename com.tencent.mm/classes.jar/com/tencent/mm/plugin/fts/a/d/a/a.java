package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class a
{
  public String info;
  public int kNw;
  public final int oeH;
  public int pageType;
  public int pil;
  public final int position;
  public h sxM;
  public int szA;
  public long szB;
  public boolean szC;
  public boolean szs;
  public boolean szt = true;
  public int szu;
  public int szv;
  public String szw;
  public long szx;
  public boolean szy;
  public int szz;
  
  public a(int paramInt1, int paramInt2)
  {
    this.oeH = paramInt1;
    this.position = paramInt2;
    ac.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs) {}
  
  public abstract a.b adW();
  
  public String bdr()
  {
    return "";
  }
  
  public int bds()
  {
    return 0;
  }
  
  public int cKH()
  {
    return 0;
  }
  
  public boolean cKI()
  {
    return false;
  }
  
  public int cKJ()
  {
    return 0;
  }
  
  public final void fP(int paramInt1, int paramInt2)
  {
    this.szz = paramInt1;
    this.szA = paramInt2;
    this.szC = true;
  }
  
  public String getAppId()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */