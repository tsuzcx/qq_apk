package com.tencent.mm.plugin.ball.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import java.util.List;

class FloatBallServiceProxy$BallInfoListParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BallInfoListParcel> CREATOR;
  List<BallInfo> nFa;
  
  static
  {
    AppMethodBeat.i(106149);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(106149);
  }
  
  protected FloatBallServiceProxy$BallInfoListParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(106147);
    this.nFa = paramParcel.createTypedArrayList(BallInfo.CREATOR);
    AppMethodBeat.o(106147);
  }
  
  public FloatBallServiceProxy$BallInfoListParcel(List<BallInfo> paramList)
  {
    this.nFa = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(106148);
    paramParcel.writeTypedList(this.nFa);
    AppMethodBeat.o(106148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.BallInfoListParcel
 * JD-Core Version:    0.7.0.1
 */