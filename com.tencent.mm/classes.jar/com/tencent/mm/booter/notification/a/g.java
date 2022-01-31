package com.tencent.mm.booter.notification.a;

import android.content.Context;

public final class g
{
  public b dkg;
  public c dkh;
  public d dki;
  public h dkj;
  private f dkk;
  public a dkl;
  public int dkm;
  public int dkn;
  public int dko;
  public int dkp;
  public boolean dkq;
  private int dkr = -1;
  private int dks = -1;
  public boolean dkt;
  public boolean dku;
  public Context mContext;
  
  public g(Context paramContext)
  {
    this.mContext = paramContext;
    this.dkg = new b();
    this.dkh = new c();
    this.dki = new d();
    this.dkj = new h();
    this.dkl = new a();
    this.dkk = f.a.wJ();
  }
  
  public static String c(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      paramArrayOfLong = null;
    }
    String str;
    do
    {
      return paramArrayOfLong;
      str = "";
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = paramArrayOfLong[i];
        str = str + String.valueOf(l) + ",";
        i += 1;
      }
      paramArrayOfLong = str;
    } while (str.isEmpty());
    return str.substring(0, str.length() - 1);
  }
  
  public final void eE(String paramString)
  {
    this.dkk.eD(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.g
 * JD-Core Version:    0.7.0.1
 */