package com.tencent.faceBeauty;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public class FaceParam
  implements Parcelable
{
  public static final Parcelable.Creator<FaceParam> CREATOR;
  private static final String TAG;
  public Rect bsP;
  public Rect bsQ;
  public Rect bsR;
  public Point bsS;
  public Point bsT;
  public Rect bsU;
  public Rect bsV;
  public int[][] bsW;
  public int height;
  public int width;
  
  static
  {
    AppMethodBeat.i(86279);
    TAG = FaceParam.class.getSimpleName();
    CREATOR = new FaceParam.1();
    AppMethodBeat.o(86279);
  }
  
  public FaceParam()
  {
    this.width = 0;
    this.height = 0;
    this.bsP = null;
    this.bsQ = null;
    this.bsR = null;
    this.bsS = null;
    this.bsT = null;
    this.bsU = null;
    this.bsV = null;
    this.bsW = null;
  }
  
  private FaceParam(Parcel paramParcel)
  {
    AppMethodBeat.i(86278);
    this.width = 0;
    this.height = 0;
    this.bsP = null;
    this.bsQ = null;
    this.bsR = null;
    this.bsS = null;
    this.bsT = null;
    this.bsU = null;
    this.bsV = null;
    this.bsW = null;
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.bsS = new Point(paramParcel.readInt(), paramParcel.readInt());
    this.bsT = new Point(paramParcel.readInt(), paramParcel.readInt());
    ClassLoader localClassLoader = Rect.class.getClassLoader();
    this.bsP = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.bsQ = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.bsR = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.bsU = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.bsV = ((Rect)paramParcel.readParcelable(localClassLoader));
    if (paramParcel.readInt() == 1)
    {
      paramParcel = paramParcel.createIntArray();
      if ((paramParcel != null) && (paramParcel.length >= 2))
      {
        int i = paramParcel.length / 2;
        this.bsW = ((int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 }));
        i = 0;
        while (i < paramParcel.length / 2)
        {
          this.bsW[i][0] = paramParcel[(i * 2)];
          this.bsW[i][1] = paramParcel[(i * 2 + 1)];
          i += 1;
        }
      }
    }
    AppMethodBeat.o(86278);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(86277);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.bsS.x);
    paramParcel.writeInt(this.bsS.y);
    paramParcel.writeInt(this.bsT.x);
    paramParcel.writeInt(this.bsT.y);
    paramParcel.writeParcelable(this.bsP, 1);
    paramParcel.writeParcelable(this.bsQ, 1);
    paramParcel.writeParcelable(this.bsR, 1);
    paramParcel.writeParcelable(this.bsU, 1);
    paramParcel.writeParcelable(this.bsV, 1);
    if (this.bsW != null)
    {
      paramParcel.writeInt(1);
      int[] arrayOfInt = new int[this.bsW.length * 2];
      paramInt = 0;
      while (paramInt < this.bsW.length)
      {
        arrayOfInt[(paramInt * 2)] = this.bsW[paramInt][0];
        arrayOfInt[(paramInt * 2 + 1)] = this.bsW[paramInt][1];
        paramInt += 1;
      }
      paramParcel.writeIntArray(arrayOfInt);
      AppMethodBeat.o(86277);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(86277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.faceBeauty.FaceParam
 * JD-Core Version:    0.7.0.1
 */