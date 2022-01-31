package com.facebook.internal;

class NativeProtocol$WakizashiAppInfo
  extends NativeProtocol.NativeAppInfo
{
  static final String WAKIZASHI_PACKAGE = "com.facebook.wakizashi";
  
  private NativeProtocol$WakizashiAppInfo()
  {
    super(null);
  }
  
  protected String getLoginActivity()
  {
    return "com.facebook.katana.ProxyAuth";
  }
  
  protected String getPackage()
  {
    return "com.facebook.wakizashi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.NativeProtocol.WakizashiAppInfo
 * JD-Core Version:    0.7.0.1
 */