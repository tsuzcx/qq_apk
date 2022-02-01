package com.tencent.mobileqq.app;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class CircleObserver
  implements BusinessObserver
{
  public static final int a = 0;
  public static final String a = "is_searchable";
  public static final int b = -1;
  public static final String b = "result_code";
  public static final int c = -10;
  public static final int d = 67;
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 181: 
      a(paramBoolean, paramBundle.getBoolean("is_searchable"));
      return;
    case 182: 
      b(paramBoolean, paramBundle.getBoolean("is_searchable", false));
      return;
    }
    a(paramBoolean, paramBundle.getInt("result_code"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CircleObserver
 * JD-Core Version:    0.7.0.1
 */