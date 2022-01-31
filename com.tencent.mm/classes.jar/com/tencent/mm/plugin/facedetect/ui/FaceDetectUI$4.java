package com.tencent.mm.plugin.facedetect.ui;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class FaceDetectUI$4
  implements ServiceConnection
{
  FaceDetectUI$4(FaceDetectUI paramFaceDetectUI) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(461);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", new Object[] { paramComponentName });
    FaceDetectUI.a(this.mmb, true);
    paramComponentName = (FaceDetectProcessService.a)paramIBinder;
    FaceDetectUI.a(this.mmb, paramComponentName.mki);
    paramComponentName = f.mhY;
    paramIBinder = FaceDetectUI.d(this.mmb);
    ab.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", new Object[] { bo.az(ah.getContext(), Process.myPid()), Integer.valueOf(paramComponentName.hashCode()) });
    paramComponentName.mhZ = paramIBinder;
    ab.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", new Object[] { Integer.valueOf(FaceDetectUI.d(this.mmb).hashCode()) });
    FaceDetectUI.e(this.mmb);
    AppMethodBeat.o(461);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(462);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", new Object[] { paramComponentName.toString() });
    FaceDetectUI.a(this.mmb, false);
    AppMethodBeat.o(462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.4
 * JD-Core Version:    0.7.0.1
 */