package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData
  implements Parcelable, Comparator<DrmInitData.SchemeData>
{
  public static final Parcelable.Creator<DrmInitData> CREATOR = new DrmInitData.1();
  private int auK;
  public final DrmInitData.SchemeData[] ayQ;
  public final int ayR;
  
  DrmInitData(Parcel paramParcel)
  {
    this.ayQ = ((DrmInitData.SchemeData[])paramParcel.createTypedArray(DrmInitData.SchemeData.CREATOR));
    this.ayR = this.ayQ.length;
  }
  
  public DrmInitData(List<DrmInitData.SchemeData> paramList)
  {
    this(false, (DrmInitData.SchemeData[])paramList.toArray(new DrmInitData.SchemeData[paramList.size()]));
  }
  
  private DrmInitData(boolean paramBoolean, DrmInitData.SchemeData... paramVarArgs)
  {
    if (paramBoolean) {
      paramVarArgs = (DrmInitData.SchemeData[])paramVarArgs.clone();
    }
    for (;;)
    {
      Arrays.sort(paramVarArgs, this);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        if (DrmInitData.SchemeData.a(paramVarArgs[(i - 1)]).equals(DrmInitData.SchemeData.a(paramVarArgs[i]))) {
          throw new IllegalArgumentException("Duplicate data for uuid: " + DrmInitData.SchemeData.a(paramVarArgs[i]));
        }
        i += 1;
      }
      this.ayQ = paramVarArgs;
      this.ayR = paramVarArgs.length;
      return;
    }
  }
  
  private DrmInitData(DrmInitData.SchemeData... paramVarArgs)
  {
    this(true, paramVarArgs);
  }
  
  public final DrmInitData ak(String paramString)
  {
    Object localObject = this.ayQ;
    int j = localObject.length;
    int i = 0;
    if (i < j) {
      if (t.e(localObject[i].type, paramString)) {}
    }
    for (i = 1;; i = 0)
    {
      localObject = this;
      if (i != 0)
      {
        DrmInitData.SchemeData[] arrayOfSchemeData = new DrmInitData.SchemeData[this.ayQ.length];
        i = 0;
        label52:
        if (i < arrayOfSchemeData.length)
        {
          localObject = this.ayQ[i];
          if (t.e(((DrmInitData.SchemeData)localObject).type, paramString)) {}
          for (;;)
          {
            arrayOfSchemeData[i] = localObject;
            i += 1;
            break label52;
            i += 1;
            break;
            localObject = new DrmInitData.SchemeData(((DrmInitData.SchemeData)localObject).uuid, paramString, ((DrmInitData.SchemeData)localObject).mimeType, ((DrmInitData.SchemeData)localObject).data, ((DrmInitData.SchemeData)localObject).ayS);
          }
        }
        localObject = new DrmInitData(arrayOfSchemeData);
      }
      return localObject;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    return Arrays.equals(this.ayQ, ((DrmInitData)paramObject).ayQ);
  }
  
  public final int hashCode()
  {
    if (this.auK == 0) {
      this.auK = Arrays.hashCode(this.ayQ);
    }
    return this.auK;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.ayQ, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData
 * JD-Core Version:    0.7.0.1
 */