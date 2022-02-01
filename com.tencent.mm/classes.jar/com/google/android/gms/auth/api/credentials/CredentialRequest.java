package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CredentialRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<CredentialRequest> CREATOR;
  private final boolean zzcu;
  private final String[] zzcv;
  private final CredentialPickerConfig zzcw;
  private final CredentialPickerConfig zzcx;
  private final boolean zzcy;
  private final String zzcz;
  private final String zzda;
  private final boolean zzdb;
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(88222);
    CREATOR = new zzh();
    AppMethodBeat.o(88222);
  }
  
  CredentialRequest(int paramInt, boolean paramBoolean1, String[] paramArrayOfString, CredentialPickerConfig paramCredentialPickerConfig1, CredentialPickerConfig paramCredentialPickerConfig2, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3)
  {
    AppMethodBeat.i(88217);
    this.zzy = paramInt;
    this.zzcu = paramBoolean1;
    this.zzcv = ((String[])Preconditions.checkNotNull(paramArrayOfString));
    paramArrayOfString = paramCredentialPickerConfig1;
    if (paramCredentialPickerConfig1 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    this.zzcw = paramArrayOfString;
    paramArrayOfString = paramCredentialPickerConfig2;
    if (paramCredentialPickerConfig2 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    this.zzcx = paramArrayOfString;
    if (paramInt < 3)
    {
      this.zzcy = true;
      this.zzcz = null;
    }
    for (this.zzda = null;; this.zzda = paramString2)
    {
      this.zzdb = paramBoolean3;
      AppMethodBeat.o(88217);
      return;
      this.zzcy = paramBoolean2;
      this.zzcz = paramString1;
    }
  }
  
  private CredentialRequest(Builder paramBuilder)
  {
    this(4, Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder), Builder.zzi(paramBuilder), Builder.zzj(paramBuilder), false);
    AppMethodBeat.i(88218);
    AppMethodBeat.o(88218);
  }
  
  public final String[] getAccountTypes()
  {
    return this.zzcv;
  }
  
  public final Set<String> getAccountTypesSet()
  {
    AppMethodBeat.i(88220);
    HashSet localHashSet = new HashSet(Arrays.asList(this.zzcv));
    AppMethodBeat.o(88220);
    return localHashSet;
  }
  
  public final CredentialPickerConfig getCredentialHintPickerConfig()
  {
    return this.zzcx;
  }
  
  public final CredentialPickerConfig getCredentialPickerConfig()
  {
    return this.zzcw;
  }
  
  public final String getIdTokenNonce()
  {
    return this.zzda;
  }
  
  public final String getServerClientId()
  {
    return this.zzcz;
  }
  
  @Deprecated
  public final boolean getSupportsPasswordLogin()
  {
    AppMethodBeat.i(88219);
    boolean bool = isPasswordLoginSupported();
    AppMethodBeat.o(88219);
    return bool;
  }
  
  public final boolean isIdTokenRequested()
  {
    return this.zzcy;
  }
  
  public final boolean isPasswordLoginSupported()
  {
    return this.zzcu;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88221);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, isPasswordLoginSupported());
    SafeParcelWriter.writeStringArray(paramParcel, 2, getAccountTypes(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getCredentialPickerConfig(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, getCredentialHintPickerConfig(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, isIdTokenRequested());
    SafeParcelWriter.writeString(paramParcel, 6, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 7, getIdTokenNonce(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzy);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzdb);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(88221);
  }
  
  public static final class Builder
  {
    private boolean zzcu;
    private String[] zzcv;
    private CredentialPickerConfig zzcw;
    private CredentialPickerConfig zzcx;
    private boolean zzcy = false;
    private String zzcz = null;
    private String zzda;
    private boolean zzdb = false;
    
    public final CredentialRequest build()
    {
      AppMethodBeat.i(88216);
      if (this.zzcv == null) {
        this.zzcv = new String[0];
      }
      if ((!this.zzcu) && (this.zzcv.length == 0))
      {
        localObject = new IllegalStateException("At least one authentication method must be specified");
        AppMethodBeat.o(88216);
        throw ((Throwable)localObject);
      }
      Object localObject = new CredentialRequest(this, null);
      AppMethodBeat.o(88216);
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
    
    public final Builder setCredentialHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      this.zzcx = paramCredentialPickerConfig;
      return this;
    }
    
    public final Builder setCredentialPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      this.zzcw = paramCredentialPickerConfig;
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
    
    public final Builder setPasswordLoginSupported(boolean paramBoolean)
    {
      this.zzcu = paramBoolean;
      return this;
    }
    
    public final Builder setServerClientId(String paramString)
    {
      this.zzcz = paramString;
      return this;
    }
    
    @Deprecated
    public final Builder setSupportsPasswordLogin(boolean paramBoolean)
    {
      AppMethodBeat.i(88215);
      Builder localBuilder = setPasswordLoginSupported(paramBoolean);
      AppMethodBeat.o(88215);
      return localBuilder;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequest
 * JD-Core Version:    0.7.0.1
 */