package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.Executor;

public abstract class HttpAsyncTask
  extends AsyncTask
{
  protected static final String h = "https://openmobile.qq.com/";
  protected String i = null;
  protected String j = null;
  
  public HttpAsyncTask(String paramString1, String paramString2)
  {
    this.i = paramString1;
    if (!paramString1.toLowerCase().startsWith("http")) {
      this.i = ("https://openmobile.qq.com/" + paramString1);
    }
    this.j = paramString2;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  public Executor a()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return ThreadManager.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.base.http.HttpAsyncTask
 * JD-Core Version:    0.7.0.1
 */