package com.google.android.gms.common.internal;

public final class ServiceSpecificExtraArgs
{
  public static abstract interface CastExtraArgs
  {
    public static final String LISTENER = "listener";
  }
  
  public static abstract interface GamesExtraArgs
  {
    public static final String DESIRED_LOCALE = "com.google.android.gms.games.key.desiredLocale";
    public static final String GAME_PACKAGE_NAME = "com.google.android.gms.games.key.gamePackageName";
    public static final String SIGNIN_OPTIONS = "com.google.android.gms.games.key.signInOptions";
    public static final String WINDOW_TOKEN = "com.google.android.gms.games.key.popupWindowToken";
  }
  
  public static abstract interface PlusExtraArgs
  {
    public static final String PLUS_AUTH_PACKAGE = "auth_package";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ServiceSpecificExtraArgs
 * JD-Core Version:    0.7.0.1
 */