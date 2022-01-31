package com.facebook.login.widget;

import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

class DeviceLoginButton$DeviceLoginClickListener
  extends LoginButton.LoginClickListener
{
  private DeviceLoginButton$DeviceLoginClickListener(DeviceLoginButton paramDeviceLoginButton)
  {
    super(paramDeviceLoginButton);
  }
  
  protected LoginManager getLoginManager()
  {
    AppMethodBeat.i(92629);
    DeviceLoginManager localDeviceLoginManager = DeviceLoginManager.getInstance();
    localDeviceLoginManager.setDefaultAudience(this.this$0.getDefaultAudience());
    localDeviceLoginManager.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
    localDeviceLoginManager.setDeviceRedirectUri(this.this$0.getDeviceRedirectUri());
    AppMethodBeat.o(92629);
    return localDeviceLoginManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.widget.DeviceLoginButton.DeviceLoginClickListener
 * JD-Core Version:    0.7.0.1
 */