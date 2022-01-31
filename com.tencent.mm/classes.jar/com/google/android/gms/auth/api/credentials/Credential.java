package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzuz;
import java.util.Collections;
import java.util.List;

public class Credential
  extends com.google.android.gms.common.internal.safeparcel.zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Credential> CREATOR = new zza();
  public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
  private final String mName;
  private final String zzGV;
  final int zzaiI;
  private final Uri zzajf;
  private final List<IdToken> zzajg;
  private final String zzajh;
  private final String zzaji;
  private final String zzajj;
  private final String zzajk;
  private final String zzajl;
  private final String zzajm;
  
  Credential(int paramInt, String paramString1, String paramString2, Uri paramUri, List<IdToken> paramList, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.zzaiI = paramInt;
    paramString1 = ((String)zzac.zzb(paramString1, "credential identifier cannot be null")).trim();
    zzac.zzh(paramString1, "credential identifier cannot be empty");
    this.zzGV = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2.trim())) {
        paramString1 = null;
      }
    }
    this.mName = paramString1;
    this.zzajf = paramUri;
    if (paramList == null) {}
    for (paramString1 = Collections.emptyList();; paramString1 = Collections.unmodifiableList(paramList))
    {
      this.zzajg = paramString1;
      this.zzajh = paramString3;
      if ((paramString3 == null) || (!paramString3.isEmpty())) {
        break;
      }
      throw new IllegalArgumentException("password cannot be empty");
    }
    if (!TextUtils.isEmpty(paramString4)) {
      zzuz.zzct(paramString4);
    }
    this.zzaji = paramString4;
    this.zzajj = paramString5;
    this.zzajk = paramString6;
    this.zzajl = paramString7;
    this.zzajm = paramString8;
    if ((!TextUtils.isEmpty(this.zzajh)) && (!TextUtils.isEmpty(this.zzaji))) {
      throw new IllegalStateException("password and accountType cannot both be set");
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Credential)) {
        return false;
      }
      paramObject = (Credential)paramObject;
    } while ((TextUtils.equals(this.zzGV, paramObject.zzGV)) && (TextUtils.equals(this.mName, paramObject.mName)) && (zzaa.equal(this.zzajf, paramObject.zzajf)) && (TextUtils.equals(this.zzajh, paramObject.zzajh)) && (TextUtils.equals(this.zzaji, paramObject.zzaji)) && (TextUtils.equals(this.zzajj, paramObject.zzajj)));
    return false;
  }
  
  public String getAccountType()
  {
    return this.zzaji;
  }
  
  public String getFamilyName()
  {
    return this.zzajm;
  }
  
  public String getGeneratedPassword()
  {
    return this.zzajj;
  }
  
  public String getGivenName()
  {
    return this.zzajl;
  }
  
  public String getId()
  {
    return this.zzGV;
  }
  
  public List<IdToken> getIdTokens()
  {
    return this.zzajg;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPassword()
  {
    return this.zzajh;
  }
  
  public Uri getProfilePictureUri()
  {
    return this.zzajf;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.zzGV, this.mName, this.zzajf, this.zzajh, this.zzaji, this.zzajj });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzqV()
  {
    return this.zzajk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credential
 * JD-Core Version:    0.7.0.1
 */