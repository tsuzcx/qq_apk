package com.tencent.smtt.sdk;

public abstract interface ValueCallback<T>
  extends android.webkit.ValueCallback<T>
{
  public abstract void onReceiveValue(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.ValueCallback
 * JD-Core Version:    0.7.0.1
 */