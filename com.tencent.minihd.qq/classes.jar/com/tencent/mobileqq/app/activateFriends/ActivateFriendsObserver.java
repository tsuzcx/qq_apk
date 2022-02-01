package com.tencent.mobileqq.app.activateFriends;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class ActivateFriendsObserver
  implements BusinessObserver
{
  public static final int a = 0;
  public static final String a = "key_rt_type";
  public static final int b = 1;
  public static final int c = 2;
  
  public void a(int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBundle.getInt("key_rt_type"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver
 * JD-Core Version:    0.7.0.1
 */