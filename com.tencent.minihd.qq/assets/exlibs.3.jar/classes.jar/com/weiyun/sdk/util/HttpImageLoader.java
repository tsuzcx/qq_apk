package com.weiyun.sdk.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;

public class HttpImageLoader
{
  private static final String TAG = "HttpImageLoader";
  protected final HttpReader mHttpReader;
  protected final BitmapFactory.Options mOptions;
  
  public HttpImageLoader(HttpReader paramHttpReader)
  {
    this(paramHttpReader, null);
  }
  
  public HttpImageLoader(HttpReader paramHttpReader, BitmapFactory.Options paramOptions)
  {
    this.mHttpReader = paramHttpReader;
    this.mOptions = paramOptions;
  }
  
  public HttpImageLoader(String paramString)
    throws MalformedURLException
  {
    this(new HttpReader(paramString, null), null);
  }
  
  public HttpImageLoader(String paramString, BitmapFactory.Options paramOptions)
    throws MalformedURLException
  {
    this(new HttpReader(paramString, null), paramOptions);
  }
  
  public Bitmap decode()
  {
    return decode(this.mOptions);
  }
  
  public Bitmap decode(BitmapFactory.Options paramOptions)
  {
    try
    {
      paramOptions = BitmapFactory.decodeStream(this.mHttpReader.getStream(), null, paramOptions);
      return paramOptions;
    }
    catch (IOException paramOptions)
    {
      Log.w("HttpImageLoader", paramOptions);
      return null;
    }
    catch (OutOfMemoryError paramOptions)
    {
      Log.w("HttpImageLoader", paramOptions);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.HttpImageLoader
 * JD-Core Version:    0.7.0.1
 */