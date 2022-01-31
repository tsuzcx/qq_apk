package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator="CredentialPickerConfigCreator")
public final class CredentialPickerConfig
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<CredentialPickerConfig> CREATOR;
  @SafeParcelable.Field(getter="shouldShowCancelButton", id=2)
  private final boolean mShowCancelButton;
  @SafeParcelable.Field(getter="shouldShowAddAccountButton", id=1)
  private final boolean zzcq;
  @Deprecated
  @SafeParcelable.Field(getter="isForNewAccount", id=3)
  private final boolean zzcr;
  @SafeParcelable.Field(getter="getPromptInternalId", id=4)
  private final int zzcs;
  @SafeParcelable.Field(id=1000)
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(50319);
    CREATOR = new zzf();
    AppMethodBeat.o(50319);
  }
  
  @SafeParcelable.Constructor
  CredentialPickerConfig(@SafeParcelable.Param(id=1000) int paramInt1, @SafeParcelable.Param(id=1) boolean paramBoolean1, @SafeParcelable.Param(id=2) boolean paramBoolean2, @SafeParcelable.Param(id=3) boolean paramBoolean3, @SafeParcelable.Param(id=4) int paramInt2)
  {
    AppMethodBeat.i(50316);
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
        AppMethodBeat.o(50316);
        return;
      }
    }
    if (paramInt2 == 3) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      this.zzcr = paramBoolean1;
      this.zzcs = paramInt2;
      AppMethodBeat.o(50316);
      return;
    }
  }
  
  private CredentialPickerConfig(CredentialPickerConfig.Builder paramBuilder)
  {
    this(2, CredentialPickerConfig.Builder.zzd(paramBuilder), CredentialPickerConfig.Builder.zze(paramBuilder), false, CredentialPickerConfig.Builder.zzf(paramBuilder));
    AppMethodBeat.i(50317);
    AppMethodBeat.o(50317);
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
    AppMethodBeat.i(50318);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, shouldShowAddAccountButton());
    SafeParcelWriter.writeBoolean(paramParcel, 2, shouldShowCancelButton());
    SafeParcelWriter.writeBoolean(paramParcel, 3, isForNewAccount());
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzcs);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzy);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(50318);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Prompt
  {
    public static final int CONTINUE = 1;
    public static final int SIGN_IN = 2;
    public static final int SIGN_UP = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialPickerConfig
 * JD-Core Version:    0.7.0.1
 */