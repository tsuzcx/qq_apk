package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CredentialPickerConfig
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzb();
  private final boolean mShowCancelButton;
  final int zzaiI;
  private final boolean zzajn;
  @Deprecated
  private final boolean zzajo;
  private final int zzajp;
  
  CredentialPickerConfig(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.zzaiI = paramInt1;
    this.zzajn = paramBoolean1;
    this.mShowCancelButton = paramBoolean2;
    if (paramInt1 < 2)
    {
      this.zzajo = paramBoolean3;
      if (paramBoolean3) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        this.zzajp = paramInt1;
        return;
      }
    }
    if (paramInt2 == 3) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      this.zzajo = paramBoolean1;
      this.zzajp = paramInt2;
      return;
    }
  }
  
  private CredentialPickerConfig(Builder paramBuilder)
  {
    this(2, Builder.zza(paramBuilder), Builder.zzb(paramBuilder), false, Builder.zzc(paramBuilder));
  }
  
  @Deprecated
  public final boolean isForNewAccount()
  {
    return this.zzajp == 3;
  }
  
  public final boolean shouldShowAddAccountButton()
  {
    return this.zzajn;
  }
  
  public final boolean shouldShowCancelButton()
  {
    return this.mShowCancelButton;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  final int zzqW()
  {
    return this.zzajp;
  }
  
  public static class Builder
  {
    private boolean mShowCancelButton = true;
    private boolean zzajn = false;
    private int zzajq = 1;
    
    public CredentialPickerConfig build()
    {
      return new CredentialPickerConfig(this, null);
    }
    
    @Deprecated
    public Builder setForNewAccount(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 3;; i = 1)
      {
        this.zzajq = i;
        return this;
      }
    }
    
    public Builder setPrompt(int paramInt)
    {
      this.zzajq = paramInt;
      return this;
    }
    
    public Builder setShowAddAccountButton(boolean paramBoolean)
    {
      this.zzajn = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialPickerConfig
 * JD-Core Version:    0.7.0.1
 */