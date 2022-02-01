package com.tencent.mm.plugin.facedetect.ui;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

final class FaceDetectUI$4
  implements ServiceConnection
{
  FaceDetectUI$4(FaceDetectUI paramFaceDetectUI) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(103980);
    ae.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", new Object[] { paramComponentName });
    FaceDetectUI.a(this.rtn, true);
    paramComponentName = (FaceDetectProcessService.a)paramIBinder;
    FaceDetectUI.a(this.rtn, paramComponentName.rru);
    paramComponentName = f.rpo;
    paramIBinder = FaceDetectUI.d(this.rtn);
    ae.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", new Object[] { bu.getProcessNameByPid(ak.getContext(), Process.myPid()), Integer.valueOf(paramComponentName.hashCode()) });
    paramComponentName.rpp = paramIBinder;
    ae.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", new Object[] { Integer.valueOf(FaceDetectUI.d(this.rtn).hashCode()) });
    FaceDetectUI.e(this.rtn);
    AppMethodBeat.o(103980);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(103981);
    ae.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", new Object[] { paramComponentName.toString() });
    FaceDetectUI.a(this.rtn, false);
    AppMethodBeat.o(103981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.4
 * JD-Core Version:    0.7.0.1
 */