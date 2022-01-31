package com.tencent.mm.plugin.facedetect.ui;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectUI$4
  implements ServiceConnection
{
  FaceDetectUI$4(FaceDetectUI paramFaceDetectUI) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    y.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", new Object[] { paramComponentName });
    FaceDetectUI.a(this.jRF, true);
    paramComponentName = (FaceDetectProcessService.a)paramIBinder;
    FaceDetectUI.a(this.jRF, paramComponentName.jPS);
    paramComponentName = f.jNM;
    paramIBinder = FaceDetectUI.d(this.jRF);
    y.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", new Object[] { bk.am(ae.getContext(), Process.myPid()), Integer.valueOf(paramComponentName.hashCode()) });
    paramComponentName.jNN = paramIBinder;
    y.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", new Object[] { Integer.valueOf(FaceDetectUI.d(this.jRF).hashCode()) });
    FaceDetectUI.e(this.jRF);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", new Object[] { paramComponentName.toString() });
    FaceDetectUI.a(this.jRF, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.4
 * JD-Core Version:    0.7.0.1
 */