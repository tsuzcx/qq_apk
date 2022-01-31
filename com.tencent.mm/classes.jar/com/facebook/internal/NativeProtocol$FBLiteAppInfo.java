package com.facebook.internal;

class NativeProtocol$FBLiteAppInfo
  extends NativeProtocol.NativeAppInfo
{
  static final String FACEBOOK_LITE_ACTIVITY = "com.facebook.lite.platform.LoginGDPDialogActivity";
  static final String FBLITE_PACKAGE = "com.facebook.lite";
  
  private NativeProtocol$FBLiteAppInfo()
  {
    super(null);
  }
  
  protected String getLoginActivity()
  {
    return "com.facebook.lite.platform.LoginGDPDialogActivity";
  }
  
  protected String getPackage()
  {
    return "com.facebook.lite";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.NativeProtocol.FBLiteAppInfo
 * JD-Core Version:    0.7.0.1
 */