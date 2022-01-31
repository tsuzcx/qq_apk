package com.facebook.login.widget;

import com.facebook.internal.LoginAuthorizationType;
import com.facebook.internal.Utility;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

class LoginButton$LoginButtonProperties
{
  private String authType;
  private LoginAuthorizationType authorizationType;
  private DefaultAudience defaultAudience;
  private LoginBehavior loginBehavior;
  private List<String> permissions;
  
  LoginButton$LoginButtonProperties()
  {
    AppMethodBeat.i(92635);
    this.defaultAudience = DefaultAudience.FRIENDS;
    this.permissions = Collections.emptyList();
    this.authorizationType = null;
    this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    this.authType = "rerequest";
    AppMethodBeat.o(92635);
  }
  
  public void clearPermissions()
  {
    this.permissions = null;
    this.authorizationType = null;
  }
  
  public String getAuthType()
  {
    return this.authType;
  }
  
  public DefaultAudience getDefaultAudience()
  {
    return this.defaultAudience;
  }
  
  public LoginBehavior getLoginBehavior()
  {
    return this.loginBehavior;
  }
  
  List<String> getPermissions()
  {
    return this.permissions;
  }
  
  public void setAuthType(String paramString)
  {
    this.authType = paramString;
  }
  
  public void setDefaultAudience(DefaultAudience paramDefaultAudience)
  {
    this.defaultAudience = paramDefaultAudience;
  }
  
  public void setLoginBehavior(LoginBehavior paramLoginBehavior)
  {
    this.loginBehavior = paramLoginBehavior;
  }
  
  public void setPublishPermissions(List<String> paramList)
  {
    AppMethodBeat.i(92637);
    if (LoginAuthorizationType.READ.equals(this.authorizationType))
    {
      paramList = new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
      AppMethodBeat.o(92637);
      throw paramList;
    }
    if (Utility.isNullOrEmpty(paramList))
    {
      paramList = new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
      AppMethodBeat.o(92637);
      throw paramList;
    }
    this.permissions = paramList;
    this.authorizationType = LoginAuthorizationType.PUBLISH;
    AppMethodBeat.o(92637);
  }
  
  public void setReadPermissions(List<String> paramList)
  {
    AppMethodBeat.i(92636);
    if (LoginAuthorizationType.PUBLISH.equals(this.authorizationType))
    {
      paramList = new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
      AppMethodBeat.o(92636);
      throw paramList;
    }
    this.permissions = paramList;
    this.authorizationType = LoginAuthorizationType.READ;
    AppMethodBeat.o(92636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.login.widget.LoginButton.LoginButtonProperties
 * JD-Core Version:    0.7.0.1
 */