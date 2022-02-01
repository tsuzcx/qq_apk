package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class HintRequest
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<HintRequest> CREATOR;
  private final String[] zzcv;
  private final boolean zzcy;
  private final String zzcz;
  private final String zzda;
  private final CredentialPickerConfig zzdc;
  private final boolean zzdd;
  private final boolean zzde;
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(88245);
    CREATOR = new zzk();
    AppMethodBeat.o(88245);
  }
  
  HintRequest(int paramInt, CredentialPickerConfig paramCredentialPickerConfig, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, boolean paramBoolean3, String paramString1, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.HintRequest
 * JD-Core Version:    0.7.0.1
 */