package com.google.android.gms.tagmanager;

import android.util.LruCache;

class zzbi$1
  extends LruCache<K, V>
{
  zzbi$1(zzbi paramzzbi, int paramInt, zzm.zza paramzza)
  {
    super(paramInt);
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return this.zzbGK.sizeOf(paramK, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzbi.1
 * JD-Core Version:    0.7.0.1
 */