package com.tencent.qav.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.qav.log.AVLog;

public class QavAwakeActivity
  extends Activity
{
  private static final String a = "QavAwakeActivity";
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AVLog.d("QavAwakeActivity", "onCreate");
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.app.QavAwakeActivity
 * JD-Core Version:    0.7.0.1
 */