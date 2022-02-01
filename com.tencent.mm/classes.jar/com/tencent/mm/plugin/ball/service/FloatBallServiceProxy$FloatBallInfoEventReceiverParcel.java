package com.tencent.mm.plugin.ball.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;

final class FloatBallServiceProxy$FloatBallInfoEventReceiverParcel
  implements Parcelable
{
  public static final Parcelable.Creator<FloatBallInfoEventReceiverParcel> CREATOR;
  ResultReceiver cBu;
  BallInfo oWE;
  
  static
  {
    AppMethodBeat.i(106160);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(106160);
  }
  
  protected FloatBallServiceProxy$FloatBallInfoEventReceiverParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(106158);
    this.oWE = ((BallInfo)paramParcel.readParcelable(BallInfo.class.getClassLoader()));
    this.cBu = ((ResultReceiver)paramParcel.readParcelable(ResultReceiver.class.getClassLoader()));
    AppMethodBeat.o(106158);
  }
  
  public FloatBallServiceProxy$FloatBallInfoEventReceiverParcel(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    this.oWE = paramBallInfo;
    this.cBu = paramResultReceiver;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(106159);
    paramParcel.writeParcelable(this.oWE, paramInt);
    paramParcel.writeParcelable(this.cBu, paramInt);
    AppMethodBeat.o(106159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.FloatBallInfoEventReceiverParcel
 * JD-Core Version:    0.7.0.1
 */