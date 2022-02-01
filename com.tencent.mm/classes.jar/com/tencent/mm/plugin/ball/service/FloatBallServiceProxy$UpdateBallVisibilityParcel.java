package com.tencent.mm.plugin.ball.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;

class FloatBallServiceProxy$UpdateBallVisibilityParcel
  implements Parcelable
{
  public static final Parcelable.Creator<UpdateBallVisibilityParcel> CREATOR;
  BallInfo oWE;
  boolean visible;
  
  static
  {
    AppMethodBeat.i(106188);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(106188);
  }
  
  protected FloatBallServiceProxy$UpdateBallVisibilityParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(106186);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.visible = bool;
      this.oWE = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
      AppMethodBeat.o(106186);
      return;
    }
  }
  
  public FloatBallServiceProxy$UpdateBallVisibilityParcel(boolean paramBoolean, BallInfo paramBallInfo)
  {
    this.visible = paramBoolean;
    this.oWE = paramBallInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(106187);
    if (this.visible) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.oWE, paramInt);
      AppMethodBeat.o(106187);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.UpdateBallVisibilityParcel
 * JD-Core Version:    0.7.0.1
 */