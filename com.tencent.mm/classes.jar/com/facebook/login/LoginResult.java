package com.facebook.login;

import com.facebook.AccessToken;
import java.util.Set;

public class LoginResult
{
  private final AccessToken accessToken;
  private final Set<String> recentlyDeniedPermissions;
  private final Set<String> recentlyGrantedPermissions;
  
  public LoginResult(AccessToken paramAccessToken, Set<String> paramSet1, Set<String> paramSet2)
  {
    this.accessToken = paramAccessToken;
    this.recentlyGrantedPermissions = paramSet1;
    this.recentlyDeniedPermissions = paramSet2;
  }
  
  public AccessToken getAccessToken()
  {
    return this.accessToken;
  }
  
  public Set<String> getRecentlyDeniedPermissions()
  {
    return this.recentlyDeniedPermissions;
  }
  
  public Set<String> getRecentlyGrantedPermissions()
  {
    return this.recentlyGrantedPermissions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.login.LoginResult
 * JD-Core Version:    0.7.0.1
 */