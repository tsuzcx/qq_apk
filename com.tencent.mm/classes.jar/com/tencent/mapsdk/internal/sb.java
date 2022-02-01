package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;

public final class sb
  extends Handler
{
  static final int a = 0;
  static final int b = 1;
  static final int c = 2;
  private final sj d;
  
  public sb(sj paramsj, Looper paramLooper)
  {
    super(paramLooper);
    AppMethodBeat.i(223507);
    this.d = paramsj;
    kl.b("MV_FIRST_STABLE");
    AppMethodBeat.o(223507);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(223517);
    super.handleMessage(paramMessage);
    sj localsj = this.d;
    if ((localsj == null) || (localsj.e_ == null) || (!((VectorMap)localsj.e_).a()))
    {
      AppMethodBeat.o(223517);
      return;
    }
    CameraPosition localCameraPosition = localsj.a();
    if (localCameraPosition == null)
    {
      AppMethodBeat.o(223517);
      return;
    }
    if (paramMessage.what == 2)
    {
      localsj.aa();
      kl.d("MV_FIRST_STABLE");
    }
    if (paramMessage.what == 0) {
      localsj.onCameraChange(localCameraPosition);
    }
    for (;;)
    {
      localsj.V();
      AppMethodBeat.o(223517);
      return;
      if (paramMessage.what == 1)
      {
        localsj.ay = true;
        if ((localsj.av != null) && (localsj.aw)) {
          localsj.av.onMapStable();
        }
        localsj.onCameraChangeFinished(localCameraPosition);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sb
 * JD-Core Version:    0.7.0.1
 */