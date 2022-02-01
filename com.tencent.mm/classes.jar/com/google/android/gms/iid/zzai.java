package com.google.android.gms.iid;

import javax.annotation.concurrent.GuardedBy;

abstract class zzai
{
  @GuardedBy("SdkFlagFactory.class")
  private static zzai zzcy;
  
  static zzai zzw()
  {
    try
    {
      if (zzcy == null) {
        zzcy = new zzac();
      }
      zzai localzzai = zzcy;
      return localzzai;
    }
    finally {}
  }
  
  abstract zzaj<Boolean> zzd(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.iid.zzai
 * JD-Core Version:    0.7.0.1
 */