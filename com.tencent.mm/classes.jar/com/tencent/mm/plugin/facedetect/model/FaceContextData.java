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
  private static volatile FaceContextData mhT;
  public long mhU;
  
  static
  {
    AppMethodBeat.i(187);
    mhT = null;
    CREATOR = new FaceContextData.1();
    AppMethodBeat.o(187);
  }
  
  public FaceContextData()
  {
    this.mhU = -1L;
  }
  
  protected FaceContextData(Parcel paramParcel)
  {
    AppMethodBeat.i(185);
    this.mhU = -1L;
    this.mhU = paramParcel.readLong();
    AppMethodBeat.o(185);
  }
  
  public static void a(FaceContextData paramFaceContextData)
  {
    AppMethodBeat.i(183);
    if (paramFaceContextData == null)
    {
      mhT = null;
      AppMethodBeat.o(183);
      return;
    }
    if (mhT != null)
    {
      b(paramFaceContextData);
      AppMethodBeat.o(183);
      return;
    }
    try
    {
      if (mhT != null)
      {
        b(paramFaceContextData);
        return;
      }
      mhT = paramFaceContextData;
      return;
    }
    finally
    {
      AppMethodBeat.o(183);
    }
  }
  
  private static void b(FaceContextData paramFaceContextData)
  {
    AppMethodBeat.i(184);
    if ((mhT != null) && (paramFaceContextData != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      mhT.mhU = paramFaceContextData.mhU;
      AppMethodBeat.o(184);
      return;
    }
  }
  
  public static FaceContextData buk()
  {
    try
    {
      FaceContextData localFaceContextData = mhT;
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
    AppMethodBeat.i(186);
    paramParcel.writeLong(this.mhU);
    AppMethodBeat.o(186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceContextData
 * JD-Core Version:    0.7.0.1
 */