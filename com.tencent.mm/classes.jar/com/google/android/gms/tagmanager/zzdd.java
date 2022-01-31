package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class zzdd
{
  static void zza(SharedPreferences.Editor paramEditor)
  {
    int i = Build.VERSION.SDK_INT;
    paramEditor.apply();
  }
  
  @SuppressLint({"CommitPrefEdits"})
  static void zzd(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putString(paramString2, paramString3);
    zza(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdd
 * JD-Core Version:    0.7.0.1
 */