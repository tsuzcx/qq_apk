package com.tencent.component.network;

import android.content.Context;
import com.tencent.component.network.module.common.NetworkState;

public class Global
{
  private static Context a;
  public static final String a = "1.0.0.6";
  
  public static Context a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    a = paramContext;
    NetworkManager.a(a());
    NetworkState.a().a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.Global
 * JD-Core Version:    0.7.0.1
 */