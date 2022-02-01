package com.tencent.map.sdk.utilities.visualization.datamodels;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TrailLatLng
{
  private TimeLatLng[] trailData;
  
  public TrailLatLng(TimeLatLng[] paramArrayOfTimeLatLng)
  {
    AppMethodBeat.i(211126);
    if ((paramArrayOfTimeLatLng != null) && (paramArrayOfTimeLatLng.length >= 2))
    {
      i = 0;
      if (i >= paramArrayOfTimeLatLng.length - 1) {
        break label98;
      }
      if (paramArrayOfTimeLatLng[i].getTime() < paramArrayOfTimeLatLng[(i + 1)].getTime()) {}
    }
    label98:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        this.trailData = paramArrayOfTimeLatLng;
        AppMethodBeat.o(211126);
        return;
        i += 1;
        break;
      }
      this.trailData = new TimeLatLng[0];
      AppMethodBeat.o(211126);
      return;
      this.trailData = new TimeLatLng[0];
      AppMethodBeat.o(211126);
      return;
    }
  }
  
  public TimeLatLng[] getTrailData()
  {
    return this.trailData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.datamodels.TrailLatLng
 * JD-Core Version:    0.7.0.1
 */