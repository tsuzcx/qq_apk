package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class zzm<K, V>
{
  final zzm.zza<K, V> zzbEX = new zzm.zza()
  {
    public int sizeOf(K paramAnonymousK, V paramAnonymousV)
    {
      return 1;
    }
  };
  
  public zzl<K, V> zza(int paramInt, zzm.zza<K, V> paramzza)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    zzzz();
    return new zzbi(paramInt, paramzza);
  }
  
  int zzzz()
  {
    return Build.VERSION.SDK_INT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzm
 * JD-Core Version:    0.7.0.1
 */