package com.google.android.gms.tagmanager;

import android.content.Context;

public class zzaa
  implements zzat
{
  private static final Object zzbEM = new Object();
  private static zzaa zzbGa;
  private zzcl zzbFo;
  private zzau zzbGb;
  
  private zzaa(Context paramContext)
  {
    this(zzav.zzca(paramContext), new zzda());
  }
  
  zzaa(zzau paramzzau, zzcl paramzzcl)
  {
    this.zzbGb = paramzzau;
    this.zzbFo = paramzzcl;
  }
  
  public static zzat zzbT(Context paramContext)
  {
    synchronized (zzbEM)
    {
      if (zzbGa == null) {
        zzbGa = new zzaa(paramContext);
      }
      paramContext = zzbGa;
      return paramContext;
    }
  }
  
  public boolean zzhf(String paramString)
  {
    if (!this.zzbFo.zzpV())
    {
      zzbo.zzbh("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
      return false;
    }
    this.zzbGb.zzhj(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzaa
 * JD-Core Version:    0.7.0.1
 */