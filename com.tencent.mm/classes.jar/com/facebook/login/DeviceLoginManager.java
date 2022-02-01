package com.facebook.login;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public class DeviceLoginManager
  extends LoginManager
{
  private static volatile DeviceLoginManager instance;
  private String deviceAuthTargetUserId;
  private Uri deviceRedirectUri;
  
  public static DeviceLoginManager getInstance()
  {
    AppMethodBeat.i(40394);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new DeviceLoginManager();
      }
      DeviceLoginManager localDeviceLoginManager = instance;
      AppMethodBeat.o(40394);
      return localDeviceLoginManager;
    }
    finally
    {
      AppMethodBeat.o(40394);
    }
  }
  
  protected LoginClient.Request createLoginRequest(Collection<String> paramCollection)
  {
    AppMethodBeat.i(40395);
    paramCollection = super.createLoginRequest(paramCollection);
    Object localObject = getDeviceRedirectUri();
    if (localObject != null) {
      paramCollection.setDeviceRedirectUriString(((Uri)localObject).toString());
    }
    localObject = getDeviceAuthTargetUserId();
    if (localObject != null) {
      paramCollection.setDeviceAuthTargetUserId((String)localObject);
    }
    AppMethodBeat.o(40395);
    return paramCollection;
  }
  
  public String getDeviceAuthTargetUserId()
  {
    return this.deviceAuthTargetUserId;
  }
  
  public Uri getDeviceRedirectUri()
  {
    return this.deviceRedirectUri;
  }
  
  public void setDeviceAuthTargetUserId(String paramString)
  {
    this.deviceAuthTargetUserId = paramString;
  }
  
  public void setDeviceRedirectUri(Uri paramUri)
  {
    this.deviceRedirectUri = paramUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.DeviceLoginManager
 * JD-Core Version:    0.7.0.1
 */