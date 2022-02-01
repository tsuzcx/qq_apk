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
  BallInfo oWE;
  
  static
  {
    AppMethodBeat.i(106181);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(106181);
  }
  
  public FloatBallServiceProxy$SetFloatBallAlphaParcel(float paramFloat, BallInfo paramBallInfo)
  {
    this.alpha = paramFloat;
    this.oWE = paramBallInfo;
  }
  
  protected FloatBallServiceProxy$SetFloatBallAlphaParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(106179);
    this.alpha = paramParcel.readFloat();
    this.oWE = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
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
    paramParcel.writeParcelable(this.oWE, paramInt);
    AppMethodBeat.o(106180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.SetFloatBallAlphaParcel
 * JD-Core Version:    0.7.0.1
 */