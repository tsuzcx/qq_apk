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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public class Credential
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Credential> CREATOR;
  public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
  private final String mName;
  private final String zzbx;
  private final String zzci;
  private final Uri zzcj;
  private final List<IdToken> zzck;
  private final String zzcl;
  private final String zzcm;
  private final String zzcn;
  private final String zzco;
  private final String zzcp;
  
  static
  {
    AppMethodBeat.i(88209);
    CREATOR = new zzd();
    AppMethodBeat.o(88209);
  }
  
  Credential(String paramString1, String paramString2, Uri paramUri, List<IdToken> paramList, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(88205);
    String str = ((String)Preconditions.checkNotNull(paramString1, "credential identifier cannot be null")).trim();
    Preconditions.checkNotEmpty(str, "credential identifier cannot be empty");
    if ((paramString3 != null) && (TextUtils.isEmpty(paramString3)))
    {
      paramString1 = new IllegalArgumentException("Password must not be empty if set");
      AppMethodBeat.o(88205);
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
        AppMethodBeat.o(88205);
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
      AppMethodBeat.o(88205);
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
      AppMethodBeat.o(88205);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(88207);
    if (this == paramObject)
    {
      AppMethodBeat.o(88207);
      return true;
    }
    if (!(paramObject instanceof Credential))
    {
      AppMethodBeat.o(88207);
      return false;
    }
    paramObject = (Credential)paramObject;
    if ((TextUtils.equals(this.zzci, paramObject.zzci)) && (TextUtils.equals(this.mName, paramObject.mName)) && (Objects.equal(this.zzcj, paramObject.zzcj)) && (TextUtils.equals(this.zzcl, paramObject.zzcl)) && (TextUtils.equals(this.zzbx, paramObject.zzbx)) && (TextUtils.equals(this.zzcm, paramObject.zzcm)))
    {
      AppMethodBeat.o(88207);
      return true;
    }
    AppMethodBeat.o(88207);
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
  
  public String getId()
  {
    return this.zzci;
  }
  
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
    AppMethodBeat.i(88208);
    int i = Objects.hashCode(new Object[] { this.zzci, this.mName, this.zzcj, this.zzcl, this.zzbx, this.zzcm });
    AppMethodBeat.o(88208);
    return i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88206);
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
    AppMethodBeat.o(88206);
  }
  
  public static class Builder
  {
    private String mName;
    private String zzbx;
    private final String zzci;
    private Uri zzcj;
    private List<IdToken> zzck;
    private String zzcl;
    private String zzcm;
    private String zzcn;
    private String zzco;
    private String zzcp;
    
    public Builder(Credential paramCredential)
    {
      AppMethodBeat.i(88203);
      this.zzci = Credential.zzd(paramCredential);
      this.mName = Credential.zze(paramCredential);
      this.zzcj = Credential.zzf(paramCredential);
      this.zzck = Credential.zzg(paramCredential);
      this.zzcl = Credential.zzh(paramCredential);
      this.zzbx = Credential.zzi(paramCredential);
      this.zzcm = Credential.zzj(paramCredential);
      this.zzcn = Credential.zzk(paramCredential);
      this.zzco = Credential.zzl(paramCredential);
      this.zzcp = Credential.zzm(paramCredential);
      AppMethodBeat.o(88203);
    }
    
    public Builder(String paramString)
    {
      this.zzci = paramString;
    }
    
    public Credential build()
    {
      AppMethodBeat.i(88204);
      Credential localCredential = new Credential(this.zzci, this.mName, this.zzcj, this.zzck, this.zzcl, this.zzbx, this.zzcm, this.zzcn, this.zzco, this.zzcp);
      AppMethodBeat.o(88204);
      return localCredential;
    }
    
    public Builder setAccountType(String paramString)
    {
      this.zzbx = paramString;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public Builder setPassword(String paramString)
    {
      this.zzcl = paramString;
      return this;
    }
    
    public Builder setProfilePictureUri(Uri paramUri)
    {
      this.zzcj = paramUri;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credential
 * JD-Core Version:    0.7.0.1
 */