package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class HintRequest$Builder
{
  private String[] zzcv;
  private boolean zzcy;
  private String zzcz;
  private String zzda;
  private CredentialPickerConfig zzdc;
  private boolean zzdd;
  private boolean zzde;
  
  public HintRequest$Builder()
  {
    AppMethodBeat.i(50344);
    this.zzdc = new CredentialPickerConfig.Builder().build();
    this.zzcy = false;
    AppMethodBeat.o(50344);
  }
  
  public final HintRequest build()
  {
    AppMethodBeat.i(50346);
    if (this.zzcv == null) {
      this.zzcv = new String[0];
    }
    if ((!this.zzdd) && (!this.zzde) && (this.zzcv.length == 0))
    {
      localObject = new IllegalStateException("At least one authentication method must be specified");
      AppMethodBeat.o(50346);
      throw ((Throwable)localObject);
    }
    Object localObject = new HintRequest(this, null);
    AppMethodBeat.o(50346);
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
    AppMethodBeat.i(50345);
    this.zzdc = ((CredentialPickerConfig)Preconditions.checkNotNull(paramCredentialPickerConfig));
    AppMethodBeat.o(50345);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.HintRequest.Builder
 * JD-Core Version:    0.7.0.1
 */