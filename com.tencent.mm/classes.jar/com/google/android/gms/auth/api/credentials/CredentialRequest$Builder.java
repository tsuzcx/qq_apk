package com.google.android.gms.auth.api.credentials;

public final class CredentialRequest$Builder
{
  private boolean zzajr;
  private String[] zzajs;
  private CredentialPickerConfig zzajt;
  private CredentialPickerConfig zzaju;
  private boolean zzajv = false;
  private String zzajw = null;
  private String zzajx;
  
  public final CredentialRequest build()
  {
    if (this.zzajs == null) {
      this.zzajs = new String[0];
    }
    if ((!this.zzajr) && (this.zzajs.length == 0)) {
      throw new IllegalStateException("At least one authentication method must be specified");
    }
    return new CredentialRequest(this, null);
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
  
  public final Builder setCredentialHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
  {
    this.zzaju = paramCredentialPickerConfig;
    return this;
  }
  
  public final Builder setCredentialPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
  {
    this.zzajt = paramCredentialPickerConfig;
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
  
  public final Builder setPasswordLoginSupported(boolean paramBoolean)
  {
    this.zzajr = paramBoolean;
    return this;
  }
  
  public final Builder setServerClientId(String paramString)
  {
    this.zzajw = paramString;
    return this;
  }
  
  @Deprecated
  public final Builder setSupportsPasswordLogin(boolean paramBoolean)
  {
    return setPasswordLoginSupported(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequest.Builder
 * JD-Core Version:    0.7.0.1
 */