package com.tencent.matrix.resource.analyzer.model;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class DestroyedActivityInfo
{
  public final String mActivityName;
  public final WeakReference<Activity> mActivityRef;
  public int mDetectedCount = 0;
  public final String mKey;
  public final long mLastCreatedActivityCount;
  
  public DestroyedActivityInfo(String paramString1, Activity paramActivity, String paramString2, long paramLong)
  {
    this.mKey = paramString1;
    this.mActivityName = paramString2;
    this.mActivityRef = new WeakReference(paramActivity);
    this.mLastCreatedActivityCount = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo
 * JD-Core Version:    0.7.0.1
 */