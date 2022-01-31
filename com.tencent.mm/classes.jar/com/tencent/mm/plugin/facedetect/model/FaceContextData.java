package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import junit.framework.Assert;

public class FaceContextData
  implements Parcelable
{
  public static final Parcelable.Creator<FaceContextData> CREATOR = new FaceContextData.1();
  private static volatile FaceContextData jNH = null;
  public long jNI = -1L;
  
  public FaceContextData() {}
  
  protected FaceContextData(Parcel paramParcel)
  {
    this.jNI = paramParcel.readLong();
  }
  
  public static void a(FaceContextData paramFaceContextData)
  {
    if (paramFaceContextData == null)
    {
      jNH = null;
      return;
    }
    if (jNH != null)
    {
      b(paramFaceContextData);
      return;
    }
    try
    {
      if (jNH != null)
      {
        b(paramFaceContextData);
        return;
      }
    }
    finally {}
    jNH = paramFaceContextData;
  }
  
  public static FaceContextData aOh()
  {
    try
    {
      FaceContextData localFaceContextData = jNH;
      return localFaceContextData;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void b(FaceContextData paramFaceContextData)
  {
    if ((jNH != null) && (paramFaceContextData != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      jNH.jNI = paramFaceContextData.jNI;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jNI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceContextData
 * JD-Core Version:    0.7.0.1
 */