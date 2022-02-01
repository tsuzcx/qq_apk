package com.tencent.mm.live.core.core.trtc.a;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCNetworkQosParam;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import java.io.File;

public final class c
{
  public static final String gpi;
  private TRTCCloud gpj;
  private boolean gpk;
  private int gpl;
  private int gpm;
  private a gpn;
  private int mAppScene;
  private int mBeautyLevel;
  private int mBeautyStyle;
  private int mRuddyLevel;
  private TRTCCloudDef.TRTCParams mTRTCParams;
  private int mWhiteningLevel;
  
  static
  {
    AppMethodBeat.i(209036);
    gpi = Environment.getExternalStorageDirectory().getPath() + "/test/record/record.aac";
    AppMethodBeat.o(209036);
  }
  
  public c()
  {
    this.gpk = true;
    this.gpl = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.mBeautyStyle = 0;
  }
  
  public c(TRTCCloud paramTRTCCloud, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(209023);
    this.gpk = true;
    this.gpl = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.mBeautyStyle = 0;
    this.gpj = paramTRTCCloud;
    this.mTRTCParams = paramTRTCParams;
    this.mAppScene = 1;
    if (paramTRTCParams == null) {}
    for (int i = 21;; i = this.mTRTCParams.role)
    {
      this.gpm = i;
      AppMethodBeat.o(209023);
      return;
    }
  }
  
  private void ajg()
  {
    AppMethodBeat.i(209028);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.ajc().aiY();
    TRTCCloudDef.TRTCVideoEncParam localTRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
    localTRTCVideoEncParam.videoResolution = locald.mVideoResolution;
    localTRTCVideoEncParam.videoFps = locald.gpC;
    localTRTCVideoEncParam.videoBitrate = locald.mVideoBitrate;
    if (locald.gpD) {}
    for (int i = 1;; i = 0)
    {
      localTRTCVideoEncParam.videoResolutionMode = i;
      this.gpj.setVideoEncoderParam(localTRTCVideoEncParam);
      AppMethodBeat.o(209028);
      return;
    }
  }
  
  private void ajh()
  {
    AppMethodBeat.i(209029);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.ajc().aiY();
    TRTCCloudDef.TRTCNetworkQosParam localTRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
    localTRTCNetworkQosParam.controlMode = locald.mQosMode;
    localTRTCNetworkQosParam.preference = locald.mQosPreference;
    this.gpj.setNetworkQosParam(localTRTCNetworkQosParam);
    AppMethodBeat.o(209029);
  }
  
  private void aji()
  {
    int j = 1;
    AppMethodBeat.i(209030);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.ajc().aiY();
    Object localObject = new TRTCCloudDef.TRTCVideoEncParam();
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolution = 100;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoFps = locald.gpC;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoBitrate = 100;
    if (locald.gpD)
    {
      i = 1;
      ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolutionMode = i;
      this.gpj.enableEncSmallVideoStream(locald.gpI, (TRTCCloudDef.TRTCVideoEncParam)localObject);
      localObject = this.gpj;
      if (!locald.gpJ) {
        break label108;
      }
    }
    label108:
    for (int i = j;; i = 0)
    {
      ((TRTCCloud)localObject).setPriorRemoteVideoStreamType(i);
      AppMethodBeat.o(209030);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(a parama)
  {
    this.gpn = parama;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(209024);
    this.gpj.setListener(new b(paramd));
    AppMethodBeat.o(209024);
  }
  
  public final void ajd()
  {
    AppMethodBeat.i(209025);
    com.tencent.mm.live.core.core.trtc.a.a.a locala = a.a.ajc().aiZ();
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.ajc().aiY();
    this.gpj.enableCustomVideoCapture(true);
    this.gpj.setDefaultStreamRecvMode(true, true);
    int i;
    if (locald.gpE)
    {
      this.gpj.setLocalViewFillMode(0);
      i = locald.gpM;
      this.gpj.setLocalViewRotation(i);
      if (!locala.gpu) {
        break label160;
      }
      this.gpj.setAudioRoute(0);
      label82:
      if (!locald.gpK) {
        break label171;
      }
      this.gpj.setGSensorMode(2);
    }
    for (;;)
    {
      i = locala.gpp;
      this.gpj.setSystemVolumeType(i);
      boolean bool = locald.cjK;
      this.gpj.setVideoEncoderMirror(bool);
      i = locald.gpF;
      this.gpj.setLocalViewMirror(i);
      ajf();
      AppMethodBeat.o(209025);
      return;
      this.gpj.setLocalViewFillMode(1);
      break;
      label160:
      this.gpj.setAudioRoute(1);
      break label82;
      label171:
      this.gpj.setGSensorMode(0);
    }
  }
  
  public final void aje()
  {
    AppMethodBeat.i(209026);
    boolean bool = a.a.ajc().aiZ().gpv;
    if (bool) {
      this.gpj.enableAudioVolumeEvaluation(300);
    }
    for (;;)
    {
      if (this.gpn != null) {
        this.gpn.dC(bool);
      }
      this.gpj.enterRoom(this.mTRTCParams, this.mAppScene);
      AppMethodBeat.o(209026);
      return;
      this.gpj.enableAudioVolumeEvaluation(0);
    }
  }
  
  public final void ajf()
  {
    AppMethodBeat.i(209027);
    ajg();
    ajh();
    aji();
    AppMethodBeat.o(209027);
  }
  
  public final int ajj()
  {
    int i = 20;
    AppMethodBeat.i(209032);
    if (this.gpm == 20) {
      i = 21;
    }
    if (this.gpj != null) {
      this.gpj.switchRole(i);
    }
    this.gpm = i;
    i = this.gpm;
    AppMethodBeat.o(209032);
    return i;
  }
  
  public final int ajk()
  {
    return this.gpm;
  }
  
  public final void dD(boolean paramBoolean)
  {
    AppMethodBeat.i(209035);
    this.gpj.enableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(209035);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(209031);
    if (this.gpj != null) {
      this.gpj.exitRoom();
    }
    AppMethodBeat.o(209031);
  }
  
  public final void startLocalAudio()
  {
    AppMethodBeat.i(209033);
    this.gpj.startLocalAudio();
    AppMethodBeat.o(209033);
  }
  
  public final void stopLocalAudio()
  {
    AppMethodBeat.i(209034);
    this.gpj.stopLocalAudio();
    AppMethodBeat.o(209034);
  }
  
  public static abstract interface a
  {
    public abstract void dC(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.c
 * JD-Core Version:    0.7.0.1
 */