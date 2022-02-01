package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class NearbyActivityView
  extends NearbyTroopsBaseView
{
  public NearbyActivityView(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean a(Intent paramIntent)
  {
    a(2130903130);
    paramIntent = paramIntent.getStringExtra("config_res_plugin_item_name");
    if (!TextUtils.isEmpty(paramIntent)) {
      this.a.a(paramIntent);
    }
    for (;;)
    {
      return true;
      this.a.a(2131365804, -1);
    }
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(Intent paramIntent, NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext)
  {
    super.a(paramIntent, paramINearbyTroopContext);
    a(paramIntent);
  }
  
  public void b()
  {
    super.b();
  }
  
  protected void c()
  {
    super.c();
    invalidate();
  }
  
  protected void d() {}
  
  protected void e()
  {
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyActivityView
 * JD-Core Version:    0.7.0.1
 */