package com.rookery.translate;

import com.rookery.asyncHttpClient.AsyncHttpClient;

public abstract class TranslateClient
{
  private static AsyncHttpClient a = null;
  
  public static AsyncHttpClient a()
  {
    try
    {
      if (a == null) {
        a = new AsyncHttpClient();
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.rookery.translate.TranslateClient
 * JD-Core Version:    0.7.0.1
 */