package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CredentialPickerConfig
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<CredentialPickerConfig> CREATOR;
  private final boolean mShowCancelButton;
  private final boolean zzcq;
  @Deprecated
  private final boolean zzcr;
  private final int zzcs;
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(88214);
    CREATOR = new zzf();
    AppMethodBeat.o(88214);
  }
  
  CredentialPickerConfig(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    AppMethodBeat.i(88211);
    this.zzy = paramInt1;
    this.zzcq = paramBoolean1;
    this.mShowCancelButton = paramBoolean2;
    if (paramInt1 < 2)
    {
      this.zzcr = paramBoolean3;
      if (paramBoolean3) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        this.zzcs = paramInt1;
        AppMethodBeat.o(88211);
        return;
      }
    }
    if (paramInt2 == 3) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      this.zzcr = paramBoolean1;
      this.zzcs = paramInt2;
      AppMethodBeat.o(88211);
      return;
    }
  }
  
  private CredentialPickerConfig(Builder paramBuilder)
  {
    this(2, Builder.zzd(paramBuilder), Builder.zze(paramBuilder), false, Builder.zzf(paramBuilder));
    AppMethodBeat.i(88212);
    AppMethodBeat.o(88212);
  }
  
  @Deprecated
  public final boolean isForNewAccount()
  {
    return this.zzcs == 3;
  }
  
  public final boolean shouldShowAddAccountButton()
  {
    return this.zzcq;
  }
  
  public final boolean shouldShowCancelButton()
  {
    return this.mShowCancelButton;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88213);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, shouldShowAddAccountButton());
    SafeParcelWriter.writeBoolean(paramParcel, 2, shouldShowCancelButton());
    SafeParcelWriter.writeBoolean(paramParcel, 3, isForNewAccount());
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzcs);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzy);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(88213);
  }
  
  public static class Builder
  {
    private boolean mShowCancelButton = true;
    private boolean zzcq = false;
    private int zzct = 1;
    
    public CredentialPickerConfig build()
    {
      AppMethodBeat.i(88210);
      CredentialPickerConfig localCredentialPickerConfig = new CredentialPickerConfig(this, null);
      AppMethodBeat.o(88210);
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
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Prompt
  {
    public static final int CONTINUE = 1;
    public static final int SIGN_IN = 2;
    public static final int SIGN_UP = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialPickerConfig
 * JD-Core Version:    0.7.0.1
 */