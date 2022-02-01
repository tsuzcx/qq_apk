package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceLoginButton
  extends LoginButton
{
  private Uri deviceRedirectUri;
  
  public DeviceLoginButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public DeviceLoginButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DeviceLoginButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Uri getDeviceRedirectUri()
  {
    return this.deviceRedirectUri;
  }
  
  protected LoginButton.LoginClickListener getNewLoginClickListener()
  {
    AppMethodBeat.i(40397);
    DeviceLoginClickListener localDeviceLoginClickListener = new DeviceLoginClickListener(null);
    AppMethodBeat.o(40397);
    return localDeviceLoginClickListener;
  }
  
  public void setDeviceRedirectUri(Uri paramUri)
  {
    this.deviceRedirectUri = paramUri;
  }
  
  class DeviceLoginClickListener
    extends LoginButton.LoginClickListener
  {
    private DeviceLoginClickListener()
    {
      super();
    }
    
    protected LoginManager getLoginManager()
    {
      AppMethodBeat.i(40396);
      DeviceLoginManager localDeviceLoginManager = DeviceLoginManager.getInstance();
      localDeviceLoginManager.setDefaultAudience(DeviceLoginButton.this.getDefaultAudience());
      localDeviceLoginManager.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
      localDeviceLoginManager.setDeviceRedirectUri(DeviceLoginButton.this.getDeviceRedirectUri());
      AppMethodBeat.o(40396);
      return localDeviceLoginManager;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.widget.DeviceLoginButton
 * JD-Core Version:    0.7.0.1
 */