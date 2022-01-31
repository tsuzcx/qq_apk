package com.facebook.internal;

class NativeProtocol$KatanaAppInfo
  extends NativeProtocol.NativeAppInfo
{
  static final String KATANA_PACKAGE = "com.facebook.katana";
  
  private NativeProtocol$KatanaAppInfo()
  {
    super(null);
  }
  
  protected String getLoginActivity()
  {
    return "com.facebook.katana.ProxyAuth";
  }
  
  protected String getPackage()
  {
    return "com.facebook.katana";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.internal.NativeProtocol.KatanaAppInfo
 * JD-Core Version:    0.7.0.1
 */