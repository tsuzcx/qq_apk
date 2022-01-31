package com.facebook.login;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoginBehavior
{
  private final boolean allowsCustomTabAuth;
  private final boolean allowsDeviceAuth;
  private final boolean allowsFacebookLiteAuth;
  private final boolean allowsGetTokenAuth;
  private final boolean allowsKatanaAuth;
  private final boolean allowsWebViewAuth;
  
  static
  {
    AppMethodBeat.i(96788);
    NATIVE_WITH_FALLBACK = new LoginBehavior("NATIVE_WITH_FALLBACK", 0, true, true, true, false, true, true);
    NATIVE_ONLY = new LoginBehavior("NATIVE_ONLY", 1, true, true, false, false, false, true);
    KATANA_ONLY = new LoginBehavior("KATANA_ONLY", 2, false, true, false, false, false, false);
    WEB_ONLY = new LoginBehavior("WEB_ONLY", 3, false, false, true, false, true, false);
    WEB_VIEW_ONLY = new LoginBehavior("WEB_VIEW_ONLY", 4, false, false, true, false, false, false);
    DIALOG_ONLY = new LoginBehavior("DIALOG_ONLY", 5, false, true, true, false, true, true);
    DEVICE_AUTH = new LoginBehavior("DEVICE_AUTH", 6, false, false, false, true, false, false);
    $VALUES = new LoginBehavior[] { NATIVE_WITH_FALLBACK, NATIVE_ONLY, KATANA_ONLY, WEB_ONLY, WEB_VIEW_ONLY, DIALOG_ONLY, DEVICE_AUTH };
    AppMethodBeat.o(96788);
  }
  
  private LoginBehavior(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.allowsGetTokenAuth = paramBoolean1;
    this.allowsKatanaAuth = paramBoolean2;
    this.allowsWebViewAuth = paramBoolean3;
    this.allowsDeviceAuth = paramBoolean4;
    this.allowsCustomTabAuth = paramBoolean5;
    this.allowsFacebookLiteAuth = paramBoolean6;
  }
  
  final boolean allowsCustomTabAuth()
  {
    return this.allowsCustomTabAuth;
  }
  
  final boolean allowsDeviceAuth()
  {
    return this.allowsDeviceAuth;
  }
  
  final boolean allowsFacebookLiteAuth()
  {
    return this.allowsFacebookLiteAuth;
  }
  
  final boolean allowsGetTokenAuth()
  {
    return this.allowsGetTokenAuth;
  }
  
  final boolean allowsKatanaAuth()
  {
    return this.allowsKatanaAuth;
  }
  
  final boolean allowsWebViewAuth()
  {
    return this.allowsWebViewAuth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.login.LoginBehavior
 * JD-Core Version:    0.7.0.1
 */