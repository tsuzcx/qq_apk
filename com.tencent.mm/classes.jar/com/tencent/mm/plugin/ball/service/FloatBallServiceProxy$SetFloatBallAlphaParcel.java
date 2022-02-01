package com.tencent.mm.plugin.ball.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;

class FloatBallServiceProxy$SetFloatBallAlphaParcel
  implements Parcelable
{
  public static final Parcelable.Creator<SetFloatBallAlphaParcel> CREATOR;
  float alpha;
  BallInfo vjV;
  
  static
  {
    AppMethodBeat.i(106181);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(106181);
  }
  
  protected FloatBallServiceProxy$SetFloatBallAlphaParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(106179);
    this.alpha = paramParcel.readFloat();
    this.vjV = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
    AppMethodBeat.o(106179);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(106180);
    paramParcel.writeFloat(this.alpha);
    paramParcel.writeParcelable(this.vjV, paramInt);
    AppMethodBeat.o(106180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.SetFloatBallAlphaParcel
 * JD-Core Version:    0.7.0.1
 */