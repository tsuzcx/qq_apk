package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IdToken
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<IdToken> CREATOR;
  private final String zzbx;
  private final String zzdf;
  
  static
  {
    AppMethodBeat.i(88248);
    CREATOR = new zzl();
    AppMethodBeat.o(88248);
  }
  
  public IdToken(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88246);
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "account type string cannot be null or empty");
      if (TextUtils.isEmpty(paramString2)) {
        break label64;
      }
    }
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "id token string cannot be null or empty");
      this.zzbx = paramString1;
      this.zzdf = paramString2;
      AppMethodBeat.o(88246);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final String getAccountType()
  {
    return this.zzbx;
  }
  
  public final String getIdToken()
  {
    return this.zzdf;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88247);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getAccountType(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getIdToken(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(88247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.IdToken
 * JD-Core Version:    0.7.0.1
 */