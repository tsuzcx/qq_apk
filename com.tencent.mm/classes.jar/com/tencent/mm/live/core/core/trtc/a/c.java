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
  public static final String gIQ;
  private TRTCCloud gIR;
  private boolean gIS;
  private int gIT;
  private int gIU;
  private int gIV;
  private a gIW;
  private int mAppScene;
  private int mBeautyLevel;
  private int mRuddyLevel;
  private TRTCCloudDef.TRTCParams mTRTCParams;
  private int mWhiteningLevel;
  
  static
  {
    AppMethodBeat.i(216690);
    gIQ = Environment.getExternalStorageDirectory().getPath() + "/test/record/record.aac";
    AppMethodBeat.o(216690);
  }
  
  public c()
  {
    this.gIS = true;
    this.gIT = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.gIV = 0;
  }
  
  public c(TRTCCloud paramTRTCCloud, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(216677);
    this.gIS = true;
    this.gIT = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.gIV = 0;
    this.gIR = paramTRTCCloud;
    this.mTRTCParams = paramTRTCParams;
    this.mAppScene = 1;
    if (paramTRTCParams == null) {}
    for (int i = 21;; i = this.mTRTCParams.role)
    {
      this.gIU = i;
      AppMethodBeat.o(216677);
      return;
    }
  }
  
  private void alS()
  {
    AppMethodBeat.i(216682);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.alO().alK();
    TRTCCloudDef.TRTCVideoEncParam localTRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
    localTRTCVideoEncParam.videoResolution = locald.gJl;
    localTRTCVideoEncParam.videoFps = locald.gJm;
    localTRTCVideoEncParam.videoBitrate = locald.mVideoBitrate;
    if (locald.gJn) {}
    for (int i = 1;; i = 0)
    {
      localTRTCVideoEncParam.videoResolutionMode = i;
      this.gIR.setVideoEncoderParam(localTRTCVideoEncParam);
      AppMethodBeat.o(216682);
      return;
    }
  }
  
  private void alT()
  {
    AppMethodBeat.i(216683);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.alO().alK();
    TRTCCloudDef.TRTCNetworkQosParam localTRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
    localTRTCNetworkQosParam.controlMode = locald.mQosMode;
    localTRTCNetworkQosParam.preference = locald.mQosPreference;
    this.gIR.setNetworkQosParam(localTRTCNetworkQosParam);
    AppMethodBeat.o(216683);
  }
  
  private void alU()
  {
    int j = 1;
    AppMethodBeat.i(216684);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.alO().alK();
    Object localObject = new TRTCCloudDef.TRTCVideoEncParam();
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolution = 100;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoFps = locald.gJm;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoBitrate = 100;
    if (locald.gJn)
    {
      i = 1;
      ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolutionMode = i;
      this.gIR.enableEncSmallVideoStream(locald.gJs, (TRTCCloudDef.TRTCVideoEncParam)localObject);
      localObject = this.gIR;
      if (!locald.gJt) {
        break label108;
      }
    }
    label108:
    for (int i = j;; i = 0)
    {
      ((TRTCCloud)localObject).setPriorRemoteVideoStreamType(i);
      AppMethodBeat.o(216684);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(a parama)
  {
    this.gIW = parama;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(216678);
    this.gIR.setListener(new b(paramd));
    AppMethodBeat.o(216678);
  }
  
  public final void alP()
  {
    AppMethodBeat.i(216679);
    com.tencent.mm.live.core.core.trtc.a.a.a locala = a.a.alO().alL();
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.alO().alK();
    this.gIR.enableCustomVideoCapture(true);
    this.gIR.setDefaultStreamRecvMode(true, true);
    int i;
    if (locald.gJo)
    {
      this.gIR.setLocalViewFillMode(0);
      i = locald.gJw;
      this.gIR.setLocalViewRotation(i);
      if (!locala.gJd) {
        break label160;
      }
      this.gIR.setAudioRoute(0);
      label82:
      if (!locald.gJu) {
        break label171;
      }
      this.gIR.setGSensorMode(2);
    }
    for (;;)
    {
      i = locala.gIY;
      this.gIR.setSystemVolumeType(i);
      boolean bool = locald.cua;
      this.gIR.setVideoEncoderMirror(bool);
      i = locald.gJp;
      this.gIR.setLocalViewMirror(i);
      alR();
      AppMethodBeat.o(216679);
      return;
      this.gIR.setLocalViewFillMode(1);
      break;
      label160:
      this.gIR.setAudioRoute(1);
      break label82;
      label171:
      this.gIR.setGSensorMode(0);
    }
  }
  
  public final void alQ()
  {
    AppMethodBeat.i(216680);
    boolean bool = a.a.alO().alL().gJe;
    if (bool) {
      this.gIR.enableAudioVolumeEvaluation(300);
    }
    for (;;)
    {
      if (this.gIW != null) {
        this.gIW.dE(bool);
      }
      this.gIR.enterRoom(this.mTRTCParams, this.mAppScene);
      AppMethodBeat.o(216680);
      return;
      this.gIR.enableAudioVolumeEvaluation(0);
    }
  }
  
  public final void alR()
  {
    AppMethodBeat.i(216681);
    alS();
    alT();
    alU();
    AppMethodBeat.o(216681);
  }
  
  public final int alV()
  {
    int i = 20;
    AppMethodBeat.i(216686);
    if (this.gIU == 20) {
      i = 21;
    }
    if (this.gIR != null) {
      this.gIR.switchRole(i);
    }
    this.gIU = i;
    i = this.gIU;
    AppMethodBeat.o(216686);
    return i;
  }
  
  public final int alW()
  {
    return this.gIU;
  }
  
  public final void dF(boolean paramBoolean)
  {
    AppMethodBeat.i(216689);
    this.gIR.enableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(216689);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(216685);
    if (this.gIR != null) {
      this.gIR.exitRoom();
    }
    AppMethodBeat.o(216685);
  }
  
  public final void startLocalAudio()
  {
    AppMethodBeat.i(216687);
    this.gIR.startLocalAudio();
    AppMethodBeat.o(216687);
  }
  
  public final void stopLocalAudio()
  {
    AppMethodBeat.i(216688);
    this.gIR.stopLocalAudio();
    AppMethodBeat.o(216688);
  }
  
  public static abstract interface a
  {
    public abstract void dE(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.c
 * JD-Core Version:    0.7.0.1
 */