package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.widget.QQProgressDialog;

class MQPSecJsPlugin$3
  implements Runnable
{
  MQPSecJsPlugin$3(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    try
    {
      if ((MQPSecJsPlugin.access$100(this.this$0) != null) && (MQPSecJsPlugin.access$100(this.this$0).isShowing()))
      {
        MQPSecJsPlugin.access$100(this.this$0).dismiss();
        MQPSecJsPlugin.access$100(this.this$0).cancel();
      }
      MQPSecJsPlugin.access$102(this.this$0, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */