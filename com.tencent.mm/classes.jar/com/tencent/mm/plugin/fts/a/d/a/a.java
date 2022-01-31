package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
{
  public String info;
  public final int ivk;
  public g kwi;
  public int kxJ;
  public boolean kxS;
  public boolean kxT = true;
  public int kxU;
  public int kxV;
  public int kxW;
  public String kxX;
  public long kxY;
  public boolean kxZ;
  public int kya;
  public int kyb;
  public boolean kyc;
  public int pageType;
  public final int position;
  
  public a(int paramInt1, int paramInt2)
  {
    this.ivk = paramInt1;
    this.position = paramInt2;
    y.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public abstract a.b BD();
  
  public abstract void a(Context paramContext, a.a parama, Object... paramVarArgs);
  
  public int aVF()
  {
    return 0;
  }
  
  public boolean aVG()
  {
    return false;
  }
  
  public int aVH()
  {
    return 0;
  }
  
  public abstract a.a afK();
  
  public String afL()
  {
    return "";
  }
  
  public int afM()
  {
    return 0;
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    this.kya = paramInt1;
    this.kyb = paramInt2;
    this.kyc = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */