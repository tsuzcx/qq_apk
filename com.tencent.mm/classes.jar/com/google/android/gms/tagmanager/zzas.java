package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class zzas
{
  private final long zzagi;
  private final long zzbGq;
  private final long zzbGr;
  private String zzbGs;
  
  zzas(long paramLong1, long paramLong2, long paramLong3)
  {
    this.zzbGq = paramLong1;
    this.zzagi = paramLong2;
    this.zzbGr = paramLong3;
  }
  
  long zzQM()
  {
    return this.zzbGq;
  }
  
  long zzQN()
  {
    return this.zzbGr;
  }
  
  String zzQO()
  {
    return this.zzbGs;
  }
  
  void zzhi(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {
      return;
    }
    this.zzbGs = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzas
 * JD-Core Version:    0.7.0.1
 */