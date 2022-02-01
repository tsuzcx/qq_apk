package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebImageCreator
  implements Parcelable.Creator<WebImage>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public WebImage createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(11747);
    int m = SafeParcelReader.validateObjectHeader(paramParcel);
    Uri localUri = null;
    int k = 0;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(n))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, n);
        break;
      case 1: 
        i = SafeParcelReader.readInt(paramParcel, n);
        break;
      case 2: 
        localUri = (Uri)SafeParcelReader.createParcelable(paramParcel, n, Uri.CREATOR);
        break;
      case 3: 
        j = SafeParcelReader.readInt(paramParcel, n);
        break;
      case 4: 
        k = SafeParcelReader.readInt(paramParcel, n);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, m);
    paramParcel = new WebImage(i, localUri, j, k);
    AppMethodBeat.o(11747);
    return paramParcel;
  }
  
  public WebImage[] newArray(int paramInt)
  {
    return new WebImage[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.images.WebImageCreator
 * JD-Core Version:    0.7.0.1
 */