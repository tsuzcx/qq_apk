package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a
{
  public int ibk;
  public String info;
  public final int kwo;
  public int lox;
  public g mRX;
  public boolean mTG;
  public boolean mTH = true;
  public int mTI;
  public int mTJ;
  public String mTK;
  public long mTL;
  public boolean mTM;
  public int mTN;
  public int mTO;
  public boolean mTP;
  public int pageType;
  public final int position;
  
  public a(int paramInt1, int paramInt2)
  {
    this.kwo = paramInt1;
    this.position = paramInt2;
    ab.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public abstract a.b Pr();
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs) {}
  
  public String aAo()
  {
    return "";
  }
  
  public int aAp()
  {
    return 0;
  }
  
  public int bCh()
  {
    return 0;
  }
  
  public boolean bCi()
  {
    return false;
  }
  
  public int bCj()
  {
    return 0;
  }
  
  public final void es(int paramInt1, int paramInt2)
  {
    this.mTN = paramInt1;
    this.mTO = paramInt2;
    this.mTP = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */