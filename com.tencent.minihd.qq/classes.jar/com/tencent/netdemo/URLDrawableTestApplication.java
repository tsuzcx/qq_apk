package com.tencent.netdemo;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableParams;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDrawableTestApplication
  extends Application
  implements LayoutInflater.Factory
{
  private static final String dateFormat = "yyyy-MM-dd kk:mm:ss.";
  private static PrintStream ps;
  
  public static final void log(String paramString)
  {
    long l = System.currentTimeMillis();
    ps.println(DateFormat.format("yyyy-MM-dd kk:mm:ss.", l) + l % 1000L + " " + paramString);
  }
  
  public void onCreate()
  {
    super.onCreate();
    URLDrawable.DEBUG = true;
    QLog.isColorLevel();
    Object localObject = new TypedValue();
    getResources().getValue(2130837507, (TypedValue)localObject, true);
    ((BitmapDrawable)getResources().getDrawable(2130837508)).getBitmap().getConfig();
    LayoutInflater.from(this).setFactory(this);
    try
    {
      new URL("http://www.baidu.com").toString();
      URLDrawable.init(this, new URLDrawableParams(this)
      {
        protected ProtocolDownloader doGetDownloader(String paramAnonymousString)
        {
          return null;
        }
        
        protected String doGetLocalFilePath(String paramAnonymousString)
        {
          return null;
        }
        
        protected Drawable getDefaultLoadingDrawable()
        {
          return URLDrawableTestApplication.this.getResources().getDrawable(2130837510);
        }
        
        protected Drawable getDefualtFailedDrawable()
        {
          return URLDrawableTestApplication.this.getResources().getDrawable(2130837509);
        }
      });
      localObject = Utils.getExternalCacheDir(this);
      if (localObject != null)
      {
        if (((File)localObject).isDirectory())
        {
          arrayOfFile = ((File)localObject).listFiles();
          int j = arrayOfFile.length;
          i = 0;
          if (i < j) {
            break label279;
          }
        }
        localObject = new File((File)localObject, "log.txt");
      }
      try
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        ps = new PrintStream((File)localObject);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          long l1;
          long l2;
          File localFile;
          localIOException.printStackTrace();
        }
      }
      l1 = AnimationUtils.currentAnimationTimeMillis();
      BitmapFactory.decodeResource(getResources(), 2130837508);
      l2 = AnimationUtils.currentAnimationTimeMillis();
      Log.d("URLDrawable", "load bitmap from res, cost:" + (l2 - l1));
      l1 = AnimationUtils.currentAnimationTimeMillis();
      BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/sample2.jpg");
      l2 = AnimationUtils.currentAnimationTimeMillis();
      Log.d("URLDrawable", "load bitmap from sdcard, cost:" + (l2 - l1));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        File[] arrayOfFile;
        int i;
        localMalformedURLException.printStackTrace();
        continue;
        label279:
        localFile = arrayOfFile[i];
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.netdemo.URLDrawableTestApplication
 * JD-Core Version:    0.7.0.1
 */