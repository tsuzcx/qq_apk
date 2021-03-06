package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public abstract interface GoogleSignInOptionsExtension
{
  public static final int FALLBACK_SIGN_IN = 2;
  public static final int FITNESS = 3;
  public static final int GAMES = 1;
  
  public abstract int getExtensionType();
  
  public abstract List<Scope> getImpliedScopes();
  
  public abstract Bundle toBundle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
 * JD-Core Version:    0.7.0.1
 */