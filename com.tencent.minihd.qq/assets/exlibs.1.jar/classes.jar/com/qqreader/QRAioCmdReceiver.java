package com.qqreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class QRAioCmdReceiver
  extends BroadcastReceiver
{
  public static final String a = "com.qqreader.aioback2reader";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.qqreader.aioback2reader".equals(paramIntent.getAction()))
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("readtype", "15");
      localIntent.setClassName(paramContext, "com.qqreader.QRBridgeActivity");
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.QRAioCmdReceiver
 * JD-Core Version:    0.7.0.1
 */