package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

public class zzdi
{
  private Context mContext;
  private Tracker zzabD;
  private GoogleAnalytics zzabF;
  
  public zzdi(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void zzhu(String paramString)
  {
    try
    {
      if (this.zzabF == null)
      {
        this.zzabF = GoogleAnalytics.getInstance(this.mContext);
        this.zzabF.setLogger(new zzdi.zza());
        this.zzabD = this.zzabF.newTracker(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Tracker zzht(String paramString)
  {
    zzhu(paramString);
    return this.zzabD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdi
 * JD-Core Version:    0.7.0.1
 */