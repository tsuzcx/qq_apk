package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public class FaceContextData
  implements Parcelable
{
  public static final Parcelable.Creator<FaceContextData> CREATOR;
  private static volatile FaceContextData zSJ;
  public long zSK;
  
  static
  {
    AppMethodBeat.i(103712);
    zSJ = null;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103712);
  }
  
  public FaceContextData()
  {
    this.zSK = -1L;
  }
  
  protected FaceContextData(Parcel paramParcel)
  {
    AppMethodBeat.i(103710);
    this.zSK = -1L;
    this.zSK = paramParcel.readLong();
    AppMethodBeat.o(103710);
  }
  
  public static void a(FaceContextData paramFaceContextData)
  {
    AppMethodBeat.i(103708);
    if (paramFaceContextData == null)
    {
      zSJ = null;
      AppMethodBeat.o(103708);
      return;
    }
    if (zSJ != null)
    {
      b(paramFaceContextData);
      AppMethodBeat.o(103708);
      return;
    }
    try
    {
      if (zSJ != null)
      {
        b(paramFaceContextData);
        return;
      }
      zSJ = paramFaceContextData;
      return;
    }
    finally
    {
      AppMethodBeat.o(103708);
    }
  }
  
  private static void b(FaceContextData paramFaceContextData)
  {
    AppMethodBeat.i(103709);
    if ((zSJ != null) && (paramFaceContextData != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      zSJ.zSK = paramFaceContextData.zSK;
      AppMethodBeat.o(103709);
      return;
    }
  }
  
  public static FaceContextData dOI()
  {
    try
    {
      FaceContextData localFaceContextData = zSJ;
      return localFaceContextData;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103711);
    paramParcel.writeLong(this.zSK);
    AppMethodBeat.o(103711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceContextData
 * JD-Core Version:    0.7.0.1
 */