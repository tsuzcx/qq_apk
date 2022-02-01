package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class a
{
  public String info;
  public int kme;
  public final int nBH;
  public int oEL;
  public int pageType;
  public final int position;
  public h roS;
  public int rqA;
  public int rqB;
  public String rqC;
  public long rqD;
  public boolean rqE;
  public int rqF;
  public int rqG;
  public long rqH;
  public boolean rqI;
  public boolean rqy;
  public boolean rqz = true;
  
  public a(int paramInt1, int paramInt2)
  {
    this.nBH = paramInt1;
    this.position = paramInt2;
    ad.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs) {}
  
  public String aWt()
  {
    return "";
  }
  
  public int aWu()
  {
    return 0;
  }
  
  public abstract a.b acQ();
  
  public int cxv()
  {
    return 0;
  }
  
  public boolean cxw()
  {
    return false;
  }
  
  public int cxx()
  {
    return 0;
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    this.rqF = paramInt1;
    this.rqG = paramInt2;
    this.rqI = true;
  }
  
  public String getAppId()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */