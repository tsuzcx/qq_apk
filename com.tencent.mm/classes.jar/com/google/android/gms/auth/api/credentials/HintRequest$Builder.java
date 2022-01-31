package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.internal.zzac;

public final class HintRequest$Builder
{
  private boolean zzajA;
  private String[] zzajs;
  private boolean zzajv = false;
  private String zzajw;
  private String zzajx;
  private CredentialPickerConfig zzajy = new CredentialPickerConfig.Builder().build();
  private boolean zzajz;
  
  public final HintRequest build()
  {
    if (this.zzajs == null) {
      this.zzajs = new String[0];
    }
    if ((!this.zzajz) && (!this.zzajA) && (this.zzajs.length == 0)) {
      throw new IllegalStateException("At least one authentication method must be specified");
    }
    return new HintRequest(this, null);
  }
  
  public final Builder setAccountTypes(String... paramVarArgs)
  {
    String[] arrayOfString = paramVarArgs;
    if (paramVarArgs == null) {
      arrayOfString = new String[0];
    }
    this.zzajs = arrayOfString;
    return this;
  }
  
  public final Builder setEmailAddressIdentifierSupported(boolean paramBoolean)
  {
    this.zzajz = paramBoolean;
    return this;
  }
  
  public final Builder setHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
  {
    this.zzajy = ((CredentialPickerConfig)zzac.zzw(paramCredentialPickerConfig));
    return this;
  }
  
  public final Builder setIdTokenNonce(String paramString)
  {
    this.zzajx = paramString;
    return this;
  }
  
  public final Builder setIdTokenRequested(boolean paramBoolean)
  {
    this.zzajv = paramBoolean;
    return this;
  }
  
  public final Builder setPhoneNumberIdentifierSupported(boolean paramBoolean)
  {
    this.zzajA = paramBoolean;
    return this;
  }
  
  public final Builder setServerClientId(String paramString)
  {
    this.zzajw = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.HintRequest.Builder
 * JD-Core Version:    0.7.0.1
 */