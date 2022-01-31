package com.google.android.gms.auth.api.credentials;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CredentialPickerConfig$Builder
{
  private boolean mShowCancelButton = true;
  private boolean zzcq = false;
  private int zzct = 1;
  
  public CredentialPickerConfig build()
  {
    AppMethodBeat.i(50315);
    CredentialPickerConfig localCredentialPickerConfig = new CredentialPickerConfig(this, null);
    AppMethodBeat.o(50315);
    return localCredentialPickerConfig;
  }
  
  @Deprecated
  public Builder setForNewAccount(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 3;; i = 1)
    {
      this.zzct = i;
      return this;
    }
  }
  
  public Builder setPrompt(int paramInt)
  {
    this.zzct = paramInt;
    return this;
  }
  
  public Builder setShowAddAccountButton(boolean paramBoolean)
  {
    this.zzcq = paramBoolean;
    return this;
  }
  
  public Builder setShowCancelButton(boolean paramBoolean)
  {
    this.mShowCancelButton = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder
 * JD-Core Version:    0.7.0.1
 */