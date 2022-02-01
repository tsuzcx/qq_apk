package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import hra;
import java.io.File;
import java.io.IOException;

public class CleanCache
  extends AsyncStep
{
  private static final int j = 3000;
  private static final int k = 2500;
  
  protected int a()
  {
    this.a.a.a().getSharedPreferences("HEAD", 0).edit().clear().commit();
    c();
    new Thread(new hra(this)).start();
    return 7;
  }
  
  public String a()
  {
    if ((this.a.a.getAccount() != null) && (this.a.a.isLogin())) {
      return this.a.a.getAccount();
    }
    return "0";
  }
  
  void c()
  {
    CardHandler.c();
    File localFile = new File(AppConstants.aG + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      FileManagerUtil.a();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache
 * JD-Core Version:    0.7.0.1
 */