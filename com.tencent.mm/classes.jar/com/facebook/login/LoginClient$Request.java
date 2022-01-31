package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LoginClient$Request
  implements Parcelable
{
  public static final Parcelable.Creator<Request> CREATOR;
  private final String applicationId;
  private final String authId;
  private String authType;
  private final DefaultAudience defaultAudience;
  private String deviceAuthTargetUserId;
  private String deviceRedirectUriString;
  private boolean isRerequest;
  private final LoginBehavior loginBehavior;
  private Set<String> permissions;
  
  static
  {
    AppMethodBeat.i(96800);
    CREATOR = new LoginClient.Request.1();
    AppMethodBeat.o(96800);
  }
  
  private LoginClient$Request(Parcel paramParcel)
  {
    AppMethodBeat.i(96798);
    this.isRerequest = false;
    Object localObject1 = paramParcel.readString();
    if (localObject1 != null)
    {
      localObject1 = LoginBehavior.valueOf((String)localObject1);
      this.loginBehavior = ((LoginBehavior)localObject1);
      localObject1 = new ArrayList();
      paramParcel.readStringList((List)localObject1);
      this.permissions = new HashSet((Collection)localObject1);
      String str = paramParcel.readString();
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = DefaultAudience.valueOf(str);
      }
      this.defaultAudience = ((DefaultAudience)localObject1);
      this.applicationId = paramParcel.readString();
      this.authId = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label151;
      }
    }
    label151:
    for (boolean bool = true;; bool = false)
    {
      this.isRerequest = bool;
      this.deviceRedirectUriString = paramParcel.readString();
      this.authType = paramParcel.readString();
      this.deviceAuthTargetUserId = paramParcel.readString();
      AppMethodBeat.o(96798);
      return;
      localObject1 = null;
      break;
    }
  }
  
  LoginClient$Request(LoginBehavior paramLoginBehavior, Set<String> paramSet, DefaultAudience paramDefaultAudience, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96795);
    this.isRerequest = false;
    this.loginBehavior = paramLoginBehavior;
    if (paramSet != null) {}
    for (;;)
    {
      this.permissions = paramSet;
      this.defaultAudience = paramDefaultAudience;
      this.authType = paramString1;
      this.applicationId = paramString2;
      this.authId = paramString3;
      AppMethodBeat.o(96795);
      return;
      paramSet = new HashSet();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getApplicationId()
  {
    return this.applicationId;
  }
  
  String getAuthId()
  {
    return this.authId;
  }
  
  String getAuthType()
  {
    return this.authType;
  }
  
  DefaultAudience getDefaultAudience()
  {
    return this.defaultAudience;
  }
  
  String getDeviceAuthTargetUserId()
  {
    return this.deviceAuthTargetUserId;
  }
  
  String getDeviceRedirectUriString()
  {
    return this.deviceRedirectUriString;
  }
  
  LoginBehavior getLoginBehavior()
  {
    return this.loginBehavior;
  }
  
  Set<String> getPermissions()
  {
    return this.permissions;
  }
  
  boolean hasPublishPermission()
  {
    AppMethodBeat.i(96797);
    Iterator localIterator = this.permissions.iterator();
    while (localIterator.hasNext()) {
      if (LoginManager.isPublishPermission((String)localIterator.next()))
      {
        AppMethodBeat.o(96797);
        return true;
      }
    }
    AppMethodBeat.o(96797);
    return false;
  }
  
  boolean isRerequest()
  {
    return this.isRerequest;
  }
  
  void setAuthType(String paramString)
  {
    this.authType = paramString;
  }
  
  void setDeviceAuthTargetUserId(String paramString)
  {
    this.deviceAuthTargetUserId = paramString;
  }
  
  void setDeviceRedirectUriString(String paramString)
  {
    this.deviceRedirectUriString = paramString;
  }
  
  void setPermissions(Set<String> paramSet)
  {
    AppMethodBeat.i(96796);
    Validate.notNull(paramSet, "permissions");
    this.permissions = paramSet;
    AppMethodBeat.o(96796);
  }
  
  void setRerequest(boolean paramBoolean)
  {
    this.isRerequest = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(96799);
    Object localObject1;
    if (this.loginBehavior != null)
    {
      localObject1 = this.loginBehavior.name();
      paramParcel.writeString((String)localObject1);
      paramParcel.writeStringList(new ArrayList(this.permissions));
      localObject1 = localObject2;
      if (this.defaultAudience != null) {
        localObject1 = this.defaultAudience.name();
      }
      paramParcel.writeString((String)localObject1);
      paramParcel.writeString(this.applicationId);
      paramParcel.writeString(this.authId);
      if (!this.isRerequest) {
        break label132;
      }
    }
    label132:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.deviceRedirectUriString);
      paramParcel.writeString(this.authType);
      paramParcel.writeString(this.deviceAuthTargetUserId);
      AppMethodBeat.o(96799);
      return;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.login.LoginClient.Request
 * JD-Core Version:    0.7.0.1
 */