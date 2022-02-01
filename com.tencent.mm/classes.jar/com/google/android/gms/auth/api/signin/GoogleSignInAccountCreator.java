package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class GoogleSignInAccountCreator
  implements Parcelable.Creator<GoogleSignInAccount>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public GoogleSignInAccount createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(10838);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    Uri localUri = null;
    String str4 = null;
    long l = 0L;
    String str3 = null;
    ArrayList localArrayList = null;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(k))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, k);
        break;
      case 1: 
        i = SafeParcelReader.readInt(paramParcel, k);
        break;
      case 2: 
        str8 = SafeParcelReader.createString(paramParcel, k);
        break;
      case 3: 
        str7 = SafeParcelReader.createString(paramParcel, k);
        break;
      case 4: 
        str6 = SafeParcelReader.createString(paramParcel, k);
        break;
      case 5: 
        str5 = SafeParcelReader.createString(paramParcel, k);
        break;
      case 6: 
        localUri = (Uri)SafeParcelReader.createParcelable(paramParcel, k, Uri.CREATOR);
        break;
      case 7: 
        str4 = SafeParcelReader.createString(paramParcel, k);
        break;
      case 8: 
        l = SafeParcelReader.readLong(paramParcel, k);
        break;
      case 9: 
        str3 = SafeParcelReader.createString(paramParcel, k);
        break;
      case 10: 
        localArrayList = SafeParcelReader.createTypedList(paramParcel, k, Scope.CREATOR);
        break;
      case 11: 
        str2 = SafeParcelReader.createString(paramParcel, k);
        break;
      case 12: 
        str1 = SafeParcelReader.createString(paramParcel, k);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new GoogleSignInAccount(i, str8, str7, str6, str5, localUri, str4, l, str3, localArrayList, str2, str1);
    AppMethodBeat.o(10838);
    return paramParcel;
  }
  
  public GoogleSignInAccount[] newArray(int paramInt)
  {
    return new GoogleSignInAccount[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInAccountCreator
 * JD-Core Version:    0.7.0.1
 */