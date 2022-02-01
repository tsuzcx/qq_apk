package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SignInConfiguration
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<SignInConfiguration> CREATOR;
  private final String zzfe;
  private GoogleSignInOptions zzff;
  
  static
  {
    AppMethodBeat.i(88301);
    CREATOR = new zzy();
    AppMethodBeat.o(88301);
  }
  
  public SignInConfiguration(String paramString, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(88297);
    this.zzfe = Preconditions.checkNotEmpty(paramString);
    this.zzff = paramGoogleSignInOptions;
    AppMethodBeat.o(88297);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(88299);
    if (paramObject == null)
    {
      AppMethodBeat.o(88299);
      return false;
    }
    try
    {
      paramObject = (SignInConfiguration)paramObject;
      if (this.zzfe.equals(paramObject.zzfe)) {
        if (this.zzff == null)
        {
          if (paramObject.zzff != null) {}
        }
        else
        {
          boolean bool;
          do
          {
            AppMethodBeat.o(88299);
            return true;
            bool = this.zzff.equals(paramObject.zzff);
          } while (bool);
        }
      }
      AppMethodBeat.o(88299);
      return false;
    }
    catch (ClassCastException paramObject)
    {
      AppMethodBeat.o(88299);
    }
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(88300);
    int i = new HashAccumulator().addObject(this.zzfe).addObject(this.zzff).hash();
    AppMethodBeat.o(88300);
    return i;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88298);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzfe, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, this.zzff, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(88298);
  }
  
  public final GoogleSignInOptions zzt()
  {
    return this.zzff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInConfiguration
 * JD-Core Version:    0.7.0.1
 */