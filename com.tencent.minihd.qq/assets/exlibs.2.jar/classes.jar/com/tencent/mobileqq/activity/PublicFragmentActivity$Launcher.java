package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.common.app.BaseApplicationImpl;

public class PublicFragmentActivity$Launcher
{
  public static void a(Activity paramActivity, Intent paramIntent, Class paramClass1, Class paramClass2, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, paramClass1);
    localIntent.putExtra("public_fragment_class", paramClass2.getName());
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, Class paramClass1, Class paramClass2, int paramInt)
  {
    a(paramActivity, null, paramClass1, paramClass2, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, paramClass1);
    localIntent.putExtra("public_fragment_class", paramClass2.getName());
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, Class paramClass1, Class paramClass2)
  {
    a(paramContext, null, paramClass1, paramClass2);
  }
  
  public static void a(Intent paramIntent, Class paramClass1, Class paramClass2)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(BaseApplicationImpl.a(), paramClass1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_class", paramClass2.getName());
    BaseApplicationImpl.a().startActivity(localIntent);
  }
  
  public static void a(Fragment paramFragment, Intent paramIntent, Class paramClass1, Class paramClass2, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramFragment.getActivity(), paramClass1);
    localIntent.putExtra("public_fragment_class", paramClass2.getName());
    paramFragment.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Fragment paramFragment, Class paramClass1, Class paramClass2, int paramInt)
  {
    a(paramFragment, null, paramClass1, paramClass2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher
 * JD-Core Version:    0.7.0.1
 */