package com.tencent.qav.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

public class QavAwakeReceiver
  extends BroadcastReceiver
{
  private static final String a = "QavAwakeReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QLog.d("QavAwakeReceiver", 1, String.format("onReceive action=%s", new Object[] { paramContext }));
    if (paramContext.equals("com.tencent.av.ui.VChatActivity")) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.app.QavAwakeReceiver
 * JD-Core Version:    0.7.0.1
 */