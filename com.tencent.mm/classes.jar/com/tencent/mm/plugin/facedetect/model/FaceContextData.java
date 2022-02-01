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
  private static volatile FaceContextData sQH;
  public long sQI;
  
  static
  {
    AppMethodBeat.i(103712);
    sQH = null;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103712);
  }
  
  public FaceContextData()
  {
    this.sQI = -1L;
  }
  
  protected FaceContextData(Parcel paramParcel)
  {
    AppMethodBeat.i(103710);
    this.sQI = -1L;
    this.sQI = paramParcel.readLong();
    AppMethodBeat.o(103710);
  }
  
  public static void a(FaceContextData paramFaceContextData)
  {
    AppMethodBeat.i(103708);
    if (paramFaceContextData == null)
    {
      sQH = null;
      AppMethodBeat.o(103708);
      return;
    }
    if (sQH != null)
    {
      b(paramFaceContextData);
      AppMethodBeat.o(103708);
      return;
    }
    try
    {
      if (sQH != null)
      {
        b(paramFaceContextData);
        return;
      }
      sQH = paramFaceContextData;
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
    if ((sQH != null) && (paramFaceContextData != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      sQH.sQI = paramFaceContextData.sQI;
      AppMethodBeat.o(103709);
      return;
    }
  }
  
  public static FaceContextData cST()
  {
    try
    {
      FaceContextData localFaceContextData = sQH;
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
    paramParcel.writeLong(this.sQI);
    AppMethodBeat.o(103711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceContextData
 * JD-Core Version:    0.7.0.1
 */