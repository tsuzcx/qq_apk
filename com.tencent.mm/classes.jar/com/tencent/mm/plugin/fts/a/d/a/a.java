package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
{
  public h BHY;
  public boolean BJF;
  public boolean BJG = true;
  public int BJH;
  public int BJI;
  public String BJJ;
  public long BJK;
  public boolean BJL;
  public int BJM;
  public int BJN;
  public long BJO;
  public boolean BJP;
  public String fTp;
  public int pageType;
  public final int position;
  public int ptD;
  public int uMD;
  public final int viewType;
  
  public a(int paramInt1, int paramInt2)
  {
    this.viewType = paramInt1;
    this.position = paramInt2;
    Log.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs) {}
  
  public abstract a.b aEw();
  
  public String bOm()
  {
    return "";
  }
  
  public int bOn()
  {
    return 0;
  }
  
  public int erd()
  {
    return 0;
  }
  
  public boolean ere()
  {
    return false;
  }
  
  public int erf()
  {
    return 0;
  }
  
  public String getAppId()
  {
    return "";
  }
  
  public final void hx(int paramInt1, int paramInt2)
  {
    this.BJM = paramInt1;
    this.BJN = paramInt2;
    this.BJP = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */