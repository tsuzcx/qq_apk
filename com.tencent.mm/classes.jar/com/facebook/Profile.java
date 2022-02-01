package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile
  implements Parcelable
{
  public static final Parcelable.Creator<Profile> CREATOR;
  private static final String FIRST_NAME_KEY = "first_name";
  private static final String ID_KEY = "id";
  private static final String LAST_NAME_KEY = "last_name";
  private static final String LINK_URI_KEY = "link_uri";
  private static final String MIDDLE_NAME_KEY = "middle_name";
  private static final String NAME_KEY = "name";
  private static final String TAG;
  private final String firstName;
  private final String id;
  private final String lastName;
  private final Uri linkUri;
  private final String middleName;
  private final String name;
  
  static
  {
    AppMethodBeat.i(17256);
    TAG = Profile.class.getSimpleName();
    CREATOR = new Parcelable.Creator()
    {
      public final Profile createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(17242);
        paramAnonymousParcel = new Profile(paramAnonymousParcel, null);
        AppMethodBeat.o(17242);
        return paramAnonymousParcel;
      }
      
      public final Profile[] newArray(int paramAnonymousInt)
      {
        return new Profile[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(17256);
  }
  
  private Profile(Parcel paramParcel)
  {
    AppMethodBeat.i(17254);
    this.id = paramParcel.readString();
    this.firstName = paramParcel.readString();
    this.middleName = paramParcel.readString();
    this.lastName = paramParcel.readString();
    this.name = paramParcel.readString();
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {}
    for (paramParcel = null;; paramParcel = Uri.parse(paramParcel))
    {
      this.linkUri = paramParcel;
      AppMethodBeat.o(17254);
      return;
    }
  }
  
  public Profile(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Uri paramUri)
  {
    AppMethodBeat.i(17248);
    Validate.notNullOrEmpty(paramString1, "id");
    this.id = paramString1;
    this.firstName = paramString2;
    this.middleName = paramString3;
    this.lastName = paramString4;
    this.name = paramString5;
    this.linkUri = paramUri;
    AppMethodBeat.o(17248);
  }
  
  Profile(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(17253);
    this.id = paramJSONObject.optString("id", null);
    this.firstName = paramJSONObject.optString("first_name", null);
    this.middleName = paramJSONObject.optString("middle_name", null);
    this.lastName = paramJSONObject.optString("last_name", null);
    this.name = paramJSONObject.optString("name", null);
    paramJSONObject = paramJSONObject.optString("link_uri", null);
    if (paramJSONObject == null) {}
    for (paramJSONObject = localObject;; paramJSONObject = Uri.parse(paramJSONObject))
    {
      this.linkUri = paramJSONObject;
      AppMethodBeat.o(17253);
      return;
    }
  }
  
  public static void fetchProfileForCurrentAccessToken()
  {
    AppMethodBeat.i(17247);
    AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
    if (!AccessToken.isCurrentAccessTokenActive())
    {
      setCurrentProfile(null);
      AppMethodBeat.o(17247);
      return;
    }
    Utility.getGraphMeRequestWithCacheAsync(localAccessToken.getToken(), new Utility.GraphMeRequestWithCacheCallback()
    {
      public final void onFailure(FacebookException paramAnonymousFacebookException)
      {
        AppMethodBeat.i(17241);
        new StringBuilder("Got unexpected exception: ").append(paramAnonymousFacebookException);
        AppMethodBeat.o(17241);
      }
      
      public final void onSuccess(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(17240);
        String str1 = paramAnonymousJSONObject.optString("id");
        if (str1 == null)
        {
          AppMethodBeat.o(17240);
          return;
        }
        String str6 = paramAnonymousJSONObject.optString("link");
        String str2 = paramAnonymousJSONObject.optString("first_name");
        String str3 = paramAnonymousJSONObject.optString("middle_name");
        String str4 = paramAnonymousJSONObject.optString("last_name");
        String str5 = paramAnonymousJSONObject.optString("name");
        if (str6 != null) {}
        for (paramAnonymousJSONObject = Uri.parse(str6);; paramAnonymousJSONObject = null)
        {
          Profile.setCurrentProfile(new Profile(str1, str2, str3, str4, str5, paramAnonymousJSONObject));
          AppMethodBeat.o(17240);
          return;
        }
      }
    });
    AppMethodBeat.o(17247);
  }
  
  public static Profile getCurrentProfile()
  {
    AppMethodBeat.i(17245);
    Profile localProfile = ProfileManager.getInstance().getCurrentProfile();
    AppMethodBeat.o(17245);
    return localProfile;
  }
  
  public static void setCurrentProfile(Profile paramProfile)
  {
    AppMethodBeat.i(17246);
    ProfileManager.getInstance().setCurrentProfile(paramProfile);
    AppMethodBeat.o(17246);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(17250);
    if (this == paramObject)
    {
      AppMethodBeat.o(17250);
      return true;
    }
    if (!(paramObject instanceof Profile))
    {
      AppMethodBeat.o(17250);
      return false;
    }
    paramObject = (Profile)paramObject;
    if ((this.id.equals(paramObject.id)) && (this.firstName == null))
    {
      if (paramObject.firstName == null)
      {
        AppMethodBeat.o(17250);
        return true;
      }
      AppMethodBeat.o(17250);
      return false;
    }
    if ((this.firstName.equals(paramObject.firstName)) && (this.middleName == null))
    {
      if (paramObject.middleName == null)
      {
        AppMethodBeat.o(17250);
        return true;
      }
      AppMethodBeat.o(17250);
      return false;
    }
    if ((this.middleName.equals(paramObject.middleName)) && (this.lastName == null))
    {
      if (paramObject.lastName == null)
      {
        AppMethodBeat.o(17250);
        return true;
      }
      AppMethodBeat.o(17250);
      return false;
    }
    if ((this.lastName.equals(paramObject.lastName)) && (this.name == null))
    {
      if (paramObject.name == null)
      {
        AppMethodBeat.o(17250);
        return true;
      }
      AppMethodBeat.o(17250);
      return false;
    }
    if ((this.name.equals(paramObject.name)) && (this.linkUri == null))
    {
      if (paramObject.linkUri == null)
      {
        AppMethodBeat.o(17250);
        return true;
      }
      AppMethodBeat.o(17250);
      return false;
    }
    boolean bool = this.linkUri.equals(paramObject.linkUri);
    AppMethodBeat.o(17250);
    return bool;
  }
  
  public final String getFirstName()
  {
    return this.firstName;
  }
  
  public final String getId()
  {
    return this.id;
  }
  
  public final String getLastName()
  {
    return this.lastName;
  }
  
  public final Uri getLinkUri()
  {
    return this.linkUri;
  }
  
  public final String getMiddleName()
  {
    return this.middleName;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final Uri getProfilePictureUri(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(17249);
    Uri localUri = ImageRequest.getProfilePictureUri(this.id, paramInt1, paramInt2);
    AppMethodBeat.o(17249);
    return localUri;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(17251);
    int j = this.id.hashCode() + 527;
    int i = j;
    if (this.firstName != null) {
      i = j * 31 + this.firstName.hashCode();
    }
    j = i;
    if (this.middleName != null) {
      j = i * 31 + this.middleName.hashCode();
    }
    i = j;
    if (this.lastName != null) {
      i = j * 31 + this.lastName.hashCode();
    }
    j = i;
    if (this.name != null) {
      j = i * 31 + this.name.hashCode();
    }
    i = j;
    if (this.linkUri != null) {
      i = j * 31 + this.linkUri.hashCode();
    }
    AppMethodBeat.o(17251);
    return i;
  }
  
  final JSONObject toJSONObject()
  {
    AppMethodBeat.i(17252);
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("id", this.id);
      localJSONObject2.put("first_name", this.firstName);
      localJSONObject2.put("middle_name", this.middleName);
      localJSONObject2.put("last_name", this.lastName);
      localJSONObject2.put("name", this.name);
      localJSONObject1 = localJSONObject2;
      if (this.linkUri != null)
      {
        localJSONObject2.put("link_uri", this.linkUri.toString());
        localJSONObject1 = localJSONObject2;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject1;
        Object localObject = null;
      }
    }
    AppMethodBeat.o(17252);
    return localJSONObject1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(17255);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.firstName);
    paramParcel.writeString(this.middleName);
    paramParcel.writeString(this.lastName);
    paramParcel.writeString(this.name);
    if (this.linkUri == null) {}
    for (String str = null;; str = this.linkUri.toString())
    {
      paramParcel.writeString(str);
      AppMethodBeat.o(17255);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.Profile
 * JD-Core Version:    0.7.0.1
 */