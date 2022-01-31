package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData
  implements Parcelable, Comparator<DrmInitData.SchemeData>
{
  public static final Parcelable.Creator<DrmInitData> CREATOR;
  public final DrmInitData.SchemeData[] aBf;
  public final int aBg;
  private int axc;
  
  static
  {
    AppMethodBeat.i(94770);
    CREATOR = new DrmInitData.1();
    AppMethodBeat.o(94770);
  }
  
  DrmInitData(Parcel paramParcel)
  {
    AppMethodBeat.i(94764);
    this.aBf = ((DrmInitData.SchemeData[])paramParcel.createTypedArray(DrmInitData.SchemeData.CREATOR));
    this.aBg = this.aBf.length;
    AppMethodBeat.o(94764);
  }
  
  public DrmInitData(List<DrmInitData.SchemeData> paramList)
  {
    this(false, (DrmInitData.SchemeData[])paramList.toArray(new DrmInitData.SchemeData[paramList.size()]));
    AppMethodBeat.i(94762);
    AppMethodBeat.o(94762);
  }
  
  private DrmInitData(boolean paramBoolean, DrmInitData.SchemeData... paramVarArgs)
  {
    AppMethodBeat.i(94763);
    if (paramBoolean) {
      paramVarArgs = (DrmInitData.SchemeData[])paramVarArgs.clone();
    }
    for (;;)
    {
      Arrays.sort(paramVarArgs, this);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        if (DrmInitData.SchemeData.a(paramVarArgs[(i - 1)]).equals(DrmInitData.SchemeData.a(paramVarArgs[i])))
        {
          paramVarArgs = new IllegalArgumentException("Duplicate data for uuid: " + DrmInitData.SchemeData.a(paramVarArgs[i]));
          AppMethodBeat.o(94763);
          throw paramVarArgs;
        }
        i += 1;
      }
      this.aBf = paramVarArgs;
      this.aBg = paramVarArgs.length;
      AppMethodBeat.o(94763);
      return;
    }
  }
  
  public DrmInitData(DrmInitData.SchemeData... paramVarArgs)
  {
    this(true, paramVarArgs);
  }
  
  public final DrmInitData ap(String paramString)
  {
    AppMethodBeat.i(94765);
    Object localObject = this.aBf;
    int j = localObject.length;
    int i = 0;
    if (i < j) {
      if (x.e(localObject[i].type, paramString)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        DrmInitData.SchemeData[] arrayOfSchemeData = new DrmInitData.SchemeData[this.aBf.length];
        i = 0;
        label54:
        if (i < arrayOfSchemeData.length)
        {
          localObject = this.aBf[i];
          if (x.e(((DrmInitData.SchemeData)localObject).type, paramString)) {}
          for (;;)
          {
            arrayOfSchemeData[i] = localObject;
            i += 1;
            break label54;
            i += 1;
            break;
            localObject = new DrmInitData.SchemeData(((DrmInitData.SchemeData)localObject).uuid, paramString, ((DrmInitData.SchemeData)localObject).mimeType, ((DrmInitData.SchemeData)localObject).data, ((DrmInitData.SchemeData)localObject).aBh);
          }
        }
        paramString = new DrmInitData(arrayOfSchemeData);
        AppMethodBeat.o(94765);
        return paramString;
      }
      AppMethodBeat.o(94765);
      return this;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94767);
    if (this == paramObject)
    {
      AppMethodBeat.o(94767);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(94767);
      return false;
    }
    boolean bool = Arrays.equals(this.aBf, ((DrmInitData)paramObject).aBf);
    AppMethodBeat.o(94767);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(94766);
    if (this.axc == 0) {
      this.axc = Arrays.hashCode(this.aBf);
    }
    int i = this.axc;
    AppMethodBeat.o(94766);
    return i;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(94768);
    paramParcel.writeTypedArray(this.aBf, 0);
    AppMethodBeat.o(94768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData
 * JD-Core Version:    0.7.0.1
 */