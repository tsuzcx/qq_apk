package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class a
{
  public String info;
  public int lox;
  public final int oOD;
  public int pSr;
  public int pageType;
  public final int position;
  public h tFe;
  public boolean tGK;
  public boolean tGL = true;
  public int tGM;
  public int tGN;
  public String tGO;
  public long tGP;
  public boolean tGQ;
  public int tGR;
  public int tGS;
  public long tGT;
  public boolean tGU;
  
  public a(int paramInt1, int paramInt2)
  {
    this.oOD = paramInt1;
    this.position = paramInt2;
    ae.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs) {}
  
  public abstract a.b agQ();
  
  public String bhD()
  {
    return "";
  }
  
  public int bhE()
  {
    return 0;
  }
  
  public int cVB()
  {
    return 0;
  }
  
  public boolean cVC()
  {
    return false;
  }
  
  public int cVD()
  {
    return 0;
  }
  
  public String getAppId()
  {
    return "";
  }
  
  public final void gf(int paramInt1, int paramInt2)
  {
    this.tGR = paramInt1;
    this.tGS = paramInt2;
    this.tGU = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */