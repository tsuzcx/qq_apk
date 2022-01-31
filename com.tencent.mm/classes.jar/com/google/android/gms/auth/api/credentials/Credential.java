package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

@SafeParcelable.Class(creator="CredentialCreator")
@SafeParcelable.Reserved({1000})
public class Credential
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Credential> CREATOR;
  public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
  @SafeParcelable.Field(getter="getName", id=2)
  private final String mName;
  @SafeParcelable.Field(getter="getAccountType", id=6)
  private final String zzbx;
  @Nonnull
  @SafeParcelable.Field(getter="getId", id=1)
  private final String zzci;
  @SafeParcelable.Field(getter="getProfilePictureUri", id=3)
  private final Uri zzcj;
  @Nonnull
  @SafeParcelable.Field(getter="getIdTokens", id=4)
  private final List<IdToken> zzck;
  @SafeParcelable.Field(getter="getPassword", id=5)
  private final String zzcl;
  @SafeParcelable.Field(getter="getGeneratedPassword", id=7)
  private final String zzcm;
  @SafeParcelable.Field(getter="getGeneratedHintId", id=8)
  private final String zzcn;
  @SafeParcelable.Field(getter="getGivenName", id=9)
  private final String zzco;
  @SafeParcelable.Field(getter="getFamilyName", id=10)
  private final String zzcp;
  
  static
  {
    AppMethodBeat.i(50314);
    CREATOR = new zzd();
    AppMethodBeat.o(50314);
  }
  
  @SafeParcelable.Constructor
  Credential(@SafeParcelable.Param(id=1) String paramString1, @SafeParcelable.Param(id=2) String paramString2, @SafeParcelable.Param(id=3) Uri paramUri, @SafeParcelable.Param(id=4) List<IdToken> paramList, @SafeParcelable.Param(id=5) String paramString3, @SafeParcelable.Param(id=6) String paramString4, @SafeParcelable.Param(id=7) String paramString5, @SafeParcelable.Param(id=8) String paramString6, @SafeParcelable.Param(id=9) String paramString7, @SafeParcelable.Param(id=10) String paramString8)
  {
    AppMethodBeat.i(50310);
    String str = ((String)Preconditions.checkNotNull(paramString1, "credential identifier cannot be null")).trim();
    Preconditions.checkNotEmpty(str, "credential identifier cannot be empty");
    if ((paramString3 != null) && (TextUtils.isEmpty(paramString3)))
    {
      paramString1 = new IllegalArgumentException("Password must not be empty if set");
      AppMethodBeat.o(50310);
      throw paramString1;
    }
    if (paramString4 != null)
    {
      int i;
      if (!TextUtils.isEmpty(paramString4))
      {
        paramString1 = Uri.parse(paramString4);
        if ((!paramString1.isAbsolute()) || (!paramString1.isHierarchical()) || (TextUtils.isEmpty(paramString1.getScheme())) || (TextUtils.isEmpty(paramString1.getAuthority()))) {
          i = 0;
        }
      }
      while (i == 0)
      {
        paramString1 = new IllegalArgumentException("Account type must be a valid Http/Https URI");
        AppMethodBeat.o(50310);
        throw paramString1;
        if (("http".equalsIgnoreCase(paramString1.getScheme())) || ("https".equalsIgnoreCase(paramString1.getScheme()))) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString1 = new IllegalArgumentException("Password and AccountType are mutually exclusive");
      AppMethodBeat.o(50310);
      throw paramString1;
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2.trim())) {
        paramString1 = null;
      }
    }
    this.mName = paramString1;
    this.zzcj = paramUri;
    if (paramList == null) {}
    for (paramString1 = Collections.emptyList();; paramString1 = Collections.unmodifiableList(paramList))
    {
      this.zzck = paramString1;
      this.zzci = str;
      this.zzcl = paramString3;
      this.zzbx = paramString4;
      this.zzcm = paramString5;
      this.zzcn = paramString6;
      this.zzco = paramString7;
      this.zzcp = paramString8;
      AppMethodBeat.o(50310);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(50312);
    if (this == paramObject)
    {
      AppMethodBeat.o(50312);
      return true;
    }
    if (!(paramObject instanceof Credential))
    {
      AppMethodBeat.o(50312);
      return false;
    }
    paramObject = (Credential)paramObject;
    if ((TextUtils.equals(this.zzci, paramObject.zzci)) && (TextUtils.equals(this.mName, paramObject.mName)) && (Objects.equal(this.zzcj, paramObject.zzcj)) && (TextUtils.equals(this.zzcl, paramObject.zzcl)) && (TextUtils.equals(this.zzbx, paramObject.zzbx)) && (TextUtils.equals(this.zzcm, paramObject.zzcm)))
    {
      AppMethodBeat.o(50312);
      return true;
    }
    AppMethodBeat.o(50312);
    return false;
  }
  
  public String getAccountType()
  {
    return this.zzbx;
  }
  
  public String getFamilyName()
  {
    return this.zzcp;
  }
  
  public String getGeneratedPassword()
  {
    return this.zzcm;
  }
  
  public String getGivenName()
  {
    return this.zzco;
  }
  
  @Nonnull
  public String getId()
  {
    return this.zzci;
  }
  
  @Nonnull
  public List<IdToken> getIdTokens()
  {
    return this.zzck;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPassword()
  {
    return this.zzcl;
  }
  
  public Uri getProfilePictureUri()
  {
    return this.zzcj;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(50313);
    int i = Objects.hashCode(new Object[] { this.zzci, this.mName, this.zzcj, this.zzcl, this.zzbx, this.zzcm });
    AppMethodBeat.o(50313);
    return i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50311);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getName(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getProfilePictureUri(), paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 4, getIdTokens(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getPassword(), false);
    SafeParcelWriter.writeString(paramParcel, 6, getAccountType(), false);
    SafeParcelWriter.writeString(paramParcel, 7, getGeneratedPassword(), false);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzcn, false);
    SafeParcelWriter.writeString(paramParcel, 9, getGivenName(), false);
    SafeParcelWriter.writeString(paramParcel, 10, getFamilyName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(50311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credential
 * JD-Core Version:    0.7.0.1
 */