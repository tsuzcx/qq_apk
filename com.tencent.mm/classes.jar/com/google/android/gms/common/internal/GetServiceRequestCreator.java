package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GetServiceRequestCreator
  implements Parcelable.Creator<GetServiceRequest>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public GetServiceRequest createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(4633);
    int m = SafeParcelReader.validateObjectHeader(paramParcel);
    int k = 0;
    int j = 0;
    int i = 0;
    String str = null;
    IBinder localIBinder = null;
    Scope[] arrayOfScope = null;
    Bundle localBundle = null;
    Account localAccount = null;
    Feature[] arrayOfFeature2 = null;
    Feature[] arrayOfFeature1 = null;
    boolean bool = false;
    while (paramParcel.dataPosition() < m)
    {
      int n = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(n))
      {
      case 9: 
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, n);
        break;
      case 1: 
        k = SafeParcelReader.readInt(paramParcel, n);
        break;
      case 2: 
        j = SafeParcelReader.readInt(paramParcel, n);
        break;
      case 3: 
        i = SafeParcelReader.readInt(paramParcel, n);
        break;
      case 4: 
        str = SafeParcelReader.createString(paramParcel, n);
        break;
      case 5: 
        localIBinder = SafeParcelReader.readIBinder(paramParcel, n);
        break;
      case 6: 
        arrayOfScope = (Scope[])SafeParcelReader.createTypedArray(paramParcel, n, Scope.CREATOR);
        break;
      case 7: 
        localBundle = SafeParcelReader.createBundle(paramParcel, n);
        break;
      case 8: 
        localAccount = (Account)SafeParcelReader.createParcelable(paramParcel, n, Account.CREATOR);
        break;
      case 10: 
        arrayOfFeature2 = (Feature[])SafeParcelReader.createTypedArray(paramParcel, n, Feature.CREATOR);
        break;
      case 11: 
        arrayOfFeature1 = (Feature[])SafeParcelReader.createTypedArray(paramParcel, n, Feature.CREATOR);
        break;
      case 12: 
        bool = SafeParcelReader.readBoolean(paramParcel, n);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, m);
    paramParcel = new GetServiceRequest(k, j, i, str, localIBinder, arrayOfScope, localBundle, localAccount, arrayOfFeature2, arrayOfFeature1, bool);
    AppMethodBeat.o(4633);
    return paramParcel;
  }
  
  public GetServiceRequest[] newArray(int paramInt)
  {
    return new GetServiceRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.GetServiceRequestCreator
 * JD-Core Version:    0.7.0.1
 */