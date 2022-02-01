package com.weiyun.sdk.impl;

import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyCommand;

public class WyCommandImpl<T>
  implements IWyFileSystem.WyCommand
{
  protected volatile IWyFileSystem.IWyCallback<T> mCallback;
  protected volatile boolean mCanceled = false;
  
  public WyCommandImpl(IWyFileSystem.IWyCallback<T> paramIWyCallback)
  {
    this.mCallback = paramIWyCallback;
  }
  
  public void cancel()
  {
    this.mCanceled = true;
    try
    {
      this.mCallback = null;
      return;
    }
    finally {}
  }
  
  public IWyFileSystem.IWyCallback<T> getCallback()
  {
    try
    {
      IWyFileSystem.IWyCallback localIWyCallback = this.mCallback;
      return localIWyCallback;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.impl.WyCommandImpl
 * JD-Core Version:    0.7.0.1
 */