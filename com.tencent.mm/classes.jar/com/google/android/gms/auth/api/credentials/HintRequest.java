package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="HintRequestCreator")
public final class HintRequest
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<HintRequest> CREATOR;
  @SafeParcelable.Field(getter="getAccountTypes", id=4)
  private final String[] zzcv;
  @SafeParcelable.Field(getter="isIdTokenRequested", id=5)
  private final boolean zzcy;
  @SafeParcelable.Field(getter="getServerClientId", id=6)
  private final String zzcz;
  @SafeParcelable.Field(getter="getIdTokenNonce", id=7)
  private final String zzda;
  @SafeParcelable.Field(getter="getHintPickerConfig", id=1)
  private final CredentialPickerConfig zzdc;
  @SafeParcelable.Field(getter="isEmailAddressIdentifierSupported", id=2)
  private final boolean zzdd;
  @SafeParcelable.Field(getter="isPhoneNumberIdentifierSupported", id=3)
  private final boolean zzde;
  @SafeParcelable.Field(id=1000)
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(88245);
    CREATOR = new zzk();
    AppMethodBeat.o(88245);
  }
  
  @SafeParcelable.Constructor
  HintRequest(@SafeParcelable.Param(id=1000) int paramInt, @SafeParcelable.Param(id=1) CredentialPickerConfig paramCredentialPickerConfig, @SafeParcelable.Param(id=2) boolean paramBoolean1, @SafeParcelable.Param(id=3) boolean paramBoolean2, @SafeParcelable.Param(id=4) String[] paramArrayOfString, @SafeParcelable.Param(id=5) boolean paramBoolean3, @SafeParcelable.Param(id=6) String paramString1, @SafeParcelable.Param(id=7) String paramString2)
  {
    AppMethodBeat.i(88242);
    this.zzy = paramInt;
    this.zzdc = ((CredentialPickerConfig)Preconditions.checkNotNull(paramCredentialPickerConfig));
    this.zzdd = paramBoolean1;
    this.zzde = paramBoolean2;
    this.zzcv = ((String[])Preconditions.checkNotNull(paramArrayOfString));
    if (this.zzy < 2)
    {
      this.zzcy = true;
      this.zzcz = null;
      this.zzda = null;
      AppMethodBeat.o(88242);
      return;
    }
    this.zzcy = paramBoolean3;
    this.zzcz = paramString1;
    this.zzda = paramString2;
    AppMethodBeat.o(88242);
  }
  
  private HintRequest(Builder paramBuilder)
  {
    this(2, Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder), Builder.zzi(paramBuilder), Builder.zzj(paramBuilder));
    AppMethodBeat.i(88243);
    AppMethodBeat.o(88243);
  }
  
  public final String[] getAccountTypes()
  {
    return this.zzcv;
  }
  
  public final CredentialPickerConfig getHintPickerConfig()
  {
    return this.zzdc;
  }
  
  public final String getIdTokenNonce()
  {
    return this.zzda;
  }
  
  public final String getServerClientId()
  {
    return this.zzcz;
  }
  
  public final boolean isEmailAddressIdentifierSupported()
  {
    return this.zzdd;
  }
  
  public final boolean isIdTokenRequested()
  {
    return this.zzcy;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88244);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getHintPickerConfig(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, isEmailAddressIdentifierSupported());
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzde);
    SafeParcelWriter.writeStringArray(paramParcel, 4, getAccountTypes(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, isIdTokenRequested());
    SafeParcelWriter.writeString(paramParcel, 6, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 7, getIdTokenNonce(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzy);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(88244);
  }
  
  public static final class Builder
  {
    private String[] zzcv;
    private boolean zzcy;
    private String zzcz;
    private String zzda;
    private CredentialPickerConfig zzdc;
    private boolean zzdd;
    private boolean zzde;
    
    public Builder()
    {
      AppMethodBeat.i(88239);
      this.zzdc = new CredentialPickerConfig.Builder().build();
      this.zzcy = false;
      AppMethodBeat.o(88239);
    }
    
    public final HintRequest build()
    {
      AppMethodBeat.i(88241);
      if (this.zzcv == null) {
        this.zzcv = new String[0];
      }
      if ((!this.zzdd) && (!this.zzde) && (this.zzcv.length == 0))
      {
        localObject = new IllegalStateException("At least one authentication method must be specified");
        AppMethodBeat.o(88241);
        throw ((Throwable)localObject);
      }
      Object localObject = new HintRequest(this, null);
      AppMethodBeat.o(88241);
      return localObject;
    }
    
    public final Builder setAccountTypes(String... paramVarArgs)
    {
      String[] arrayOfString = paramVarArgs;
      if (paramVarArgs == null) {
        arrayOfString = new String[0];
      }
      this.zzcv = arrayOfString;
      return this;
    }
    
    public final Builder setEmailAddressIdentifierSupported(boolean paramBoolean)
    {
      this.zzdd = paramBoolean;
      return this;
    }
    
    public final Builder setHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      AppMethodBeat.i(88240);
      this.zzdc = ((CredentialPickerConfig)Preconditions.checkNotNull(paramCredentialPickerConfig));
      AppMethodBeat.o(88240);
      return this;
    }
    
    public final Builder setIdTokenNonce(String paramString)
    {
      this.zzda = paramString;
      return this;
    }
    
    public final Builder setIdTokenRequested(boolean paramBoolean)
    {
      this.zzcy = paramBoolean;
      return this;
    }
    
    public final Builder setPhoneNumberIdentifierSupported(boolean paramBoolean)
    {
      this.zzde = paramBoolean;
      return this;
    }
    
    public final Builder setServerClientId(String paramString)
    {
      this.zzcz = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.HintRequest
 * JD-Core Version:    0.7.0.1
 */