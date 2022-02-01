package com.tencent.mobileqq.memoryleak;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract interface LeakInspector$InspectorListener
{
  public abstract List a(String paramString);
  
  public abstract void a(String paramString, WeakReference paramWeakReference);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract boolean a(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.memoryleak.LeakInspector.InspectorListener
 * JD-Core Version:    0.7.0.1
 */