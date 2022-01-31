package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;

@TargetApi(12)
class zzbi<K, V>
  implements zzl<K, V>
{
  private LruCache<K, V> zzbGJ;
  
  zzbi(int paramInt, zzm.zza<K, V> paramzza)
  {
    this.zzbGJ = new zzbi.1(this, paramInt, paramzza);
  }
  
  public V get(K paramK)
  {
    return this.zzbGJ.get(paramK);
  }
  
  public void zzh(K paramK, V paramV)
  {
    this.zzbGJ.put(paramK, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzbi
 * JD-Core Version:    0.7.0.1
 */