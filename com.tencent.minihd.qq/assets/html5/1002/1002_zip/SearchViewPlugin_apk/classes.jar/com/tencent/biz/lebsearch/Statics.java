package com.tencent.biz.lebsearch;

import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.net.MalformedURLException;
import java.net.URL;

public class Statics
{
  public static void setImage(ImageView paramImageView, final String paramString)
  {
    try
    {
      String str = "Dalvik/1.6.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + ")";
      new URL(paramString);
      paramString = URLDrawable.getDrawable(paramString);
      paramString.addHeader("User-Agent", str);
      paramString.setURLDrawableListener(new URLDrawable.URLDrawableListener()
      {
        public void onLoadCanceled(URLDrawable paramAnonymousURLDrawable)
        {
          Statics.this.setImageDrawable(null);
          Statics.this.setBackgroundColor(Color.parseColor("#e7e7e7"));
        }
        
        public void onLoadFialed(URLDrawable paramAnonymousURLDrawable, Throwable paramAnonymousThrowable)
        {
          Statics.this.setImageDrawable(null);
          Statics.this.setBackgroundColor(Color.parseColor("#e7e7e7"));
        }
        
        public void onLoadProgressed(URLDrawable paramAnonymousURLDrawable, int paramAnonymousInt) {}
        
        public void onLoadSuccessed(URLDrawable paramAnonymousURLDrawable)
        {
          Statics.this.setImageDrawable(null);
          Statics.this.setScaleType(ImageView.ScaleType.FIT_CENTER);
          Statics.this.setImageDrawable(paramString);
        }
      });
      paramImageView.setImageDrawable(paramString);
      paramImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramImageView.setImageDrawable(null);
      paramImageView.setBackgroundColor(Color.parseColor("#e7e7e7"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.Statics
 * JD-Core Version:    0.7.0.1
 */