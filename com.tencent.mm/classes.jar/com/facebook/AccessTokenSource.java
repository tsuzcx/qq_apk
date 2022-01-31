package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AccessTokenSource
{
  private final boolean canExtendToken;
  
  static
  {
    AppMethodBeat.i(71571);
    NONE = new AccessTokenSource("NONE", 0, false);
    FACEBOOK_APPLICATION_WEB = new AccessTokenSource("FACEBOOK_APPLICATION_WEB", 1, true);
    FACEBOOK_APPLICATION_NATIVE = new AccessTokenSource("FACEBOOK_APPLICATION_NATIVE", 2, true);
    FACEBOOK_APPLICATION_SERVICE = new AccessTokenSource("FACEBOOK_APPLICATION_SERVICE", 3, true);
    WEB_VIEW = new AccessTokenSource("WEB_VIEW", 4, true);
    CHROME_CUSTOM_TAB = new AccessTokenSource("CHROME_CUSTOM_TAB", 5, true);
    TEST_USER = new AccessTokenSource("TEST_USER", 6, true);
    CLIENT_TOKEN = new AccessTokenSource("CLIENT_TOKEN", 7, true);
    DEVICE_AUTH = new AccessTokenSource("DEVICE_AUTH", 8, true);
    $VALUES = new AccessTokenSource[] { NONE, FACEBOOK_APPLICATION_WEB, FACEBOOK_APPLICATION_NATIVE, FACEBOOK_APPLICATION_SERVICE, WEB_VIEW, CHROME_CUSTOM_TAB, TEST_USER, CLIENT_TOKEN, DEVICE_AUTH };
    AppMethodBeat.o(71571);
  }
  
  private AccessTokenSource(boolean paramBoolean)
  {
    this.canExtendToken = paramBoolean;
  }
  
  final boolean canExtendToken()
  {
    return this.canExtendToken;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.AccessTokenSource
 * JD-Core Version:    0.7.0.1
 */