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
  public static final String qEE;
  private int mAppScene;
  private int mBeautyLevel;
  private int mBeautyStyle;
  private int mRuddyLevel;
  private TRTCCloudDef.TRTCParams mTRTCParams;
  private int mWhiteningLevel;
  private TRTCCloud qEF;
  private boolean qEG;
  private int qEH;
  private int qEI;
  private a qEJ;
  
  static
  {
    AppMethodBeat.i(205506);
    qEE = Environment.getExternalStorageDirectory().getPath() + "/test/record/record.aac";
    AppMethodBeat.o(205506);
  }
  
  public c()
  {
    this.qEG = true;
    this.qEH = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.mBeautyStyle = 0;
  }
  
  public c(TRTCCloud paramTRTCCloud, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(205493);
    this.qEG = true;
    this.qEH = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.mBeautyStyle = 0;
    this.qEF = paramTRTCCloud;
    this.mTRTCParams = paramTRTCParams;
    this.mAppScene = 1;
    if (paramTRTCParams == null) {}
    for (int i = 21;; i = this.mTRTCParams.role)
    {
      this.qEI = i;
      AppMethodBeat.o(205493);
      return;
    }
  }
  
  private void cqL()
  {
    AppMethodBeat.i(205498);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.cpW().cpF();
    TRTCCloudDef.TRTCVideoEncParam localTRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
    localTRTCVideoEncParam.videoResolution = locald.mVideoResolution;
    localTRTCVideoEncParam.videoFps = locald.qGp;
    localTRTCVideoEncParam.videoBitrate = locald.mVideoBitrate;
    if (locald.qGq) {}
    for (int i = 1;; i = 0)
    {
      localTRTCVideoEncParam.videoResolutionMode = i;
      this.qEF.setVideoEncoderParam(localTRTCVideoEncParam);
      AppMethodBeat.o(205498);
      return;
    }
  }
  
  private void cqM()
  {
    AppMethodBeat.i(205499);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.cpW().cpF();
    TRTCCloudDef.TRTCNetworkQosParam localTRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
    localTRTCNetworkQosParam.controlMode = locald.mQosMode;
    localTRTCNetworkQosParam.preference = locald.mQosPreference;
    this.qEF.setNetworkQosParam(localTRTCNetworkQosParam);
    AppMethodBeat.o(205499);
  }
  
  private void crm()
  {
    int j = 1;
    AppMethodBeat.i(205500);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.cpW().cpF();
    Object localObject = new TRTCCloudDef.TRTCVideoEncParam();
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolution = 100;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoFps = locald.qGp;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoBitrate = 100;
    if (locald.qGq)
    {
      i = 1;
      ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolutionMode = i;
      this.qEF.enableEncSmallVideoStream(locald.qGZ, (TRTCCloudDef.TRTCVideoEncParam)localObject);
      localObject = this.qEF;
      if (!locald.qHJ) {
        break label108;
      }
    }
    label108:
    for (int i = j;; i = 0)
    {
      ((TRTCCloud)localObject).setPriorRemoteVideoStreamType(i);
      AppMethodBeat.o(205500);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(a parama)
  {
    this.qEJ = parama;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(205494);
    this.qEF.setListener(new b(paramd));
    AppMethodBeat.o(205494);
  }
  
  public final void cpY()
  {
    AppMethodBeat.i(205495);
    com.tencent.mm.live.core.core.trtc.a.a.a locala = a.a.cpW().cpP();
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.cpW().cpF();
    this.qEF.enableCustomVideoCapture(true);
    this.qEF.setDefaultStreamRecvMode(true, true);
    int i;
    if (locald.qGs)
    {
      this.qEF.setLocalViewFillMode(0);
      i = locald.qHY;
      this.qEF.setLocalViewRotation(i);
      if (!locala.qGh) {
        break label160;
      }
      this.qEF.setAudioRoute(0);
      label82:
      if (!locald.qHK) {
        break label171;
      }
      this.qEF.setGSensorMode(2);
    }
    for (;;)
    {
      i = locala.qFi;
      this.qEF.setSystemVolumeType(i);
      boolean bool = locald.cmI;
      this.qEF.setVideoEncoderMirror(bool);
      i = locald.qGt;
      this.qEF.setLocalViewMirror(i);
      cqG();
      AppMethodBeat.o(205495);
      return;
      this.qEF.setLocalViewFillMode(1);
      break;
      label160:
      this.qEF.setAudioRoute(1);
      break label82;
      label171:
      this.qEF.setGSensorMode(0);
    }
  }
  
  public final void cqG()
  {
    AppMethodBeat.i(205497);
    cqL();
    cqM();
    crm();
    AppMethodBeat.o(205497);
  }
  
  public final void cqb()
  {
    AppMethodBeat.i(205496);
    boolean bool = a.a.cpW().cpP().qGi;
    if (bool) {
      this.qEF.enableAudioVolumeEvaluation(300);
    }
    for (;;)
    {
      if (this.qEJ != null) {
        this.qEJ.hB(bool);
      }
      this.qEF.enterRoom(this.mTRTCParams, this.mAppScene);
      AppMethodBeat.o(205496);
      return;
      this.qEF.enableAudioVolumeEvaluation(0);
    }
  }
  
  public final int crn()
  {
    int i = 20;
    AppMethodBeat.i(205502);
    if (this.qEI == 20) {
      i = 21;
    }
    if (this.qEF != null) {
      this.qEF.switchRole(i);
    }
    this.qEI = i;
    i = this.qEI;
    AppMethodBeat.o(205502);
    return i;
  }
  
  public final int cro()
  {
    return this.qEI;
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(205501);
    if (this.qEF != null) {
      this.qEF.exitRoom();
    }
    AppMethodBeat.o(205501);
  }
  
  public final void hC(boolean paramBoolean)
  {
    AppMethodBeat.i(205505);
    this.qEF.enableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(205505);
  }
  
  public final void startLocalAudio()
  {
    AppMethodBeat.i(205503);
    this.qEF.startLocalAudio();
    AppMethodBeat.o(205503);
  }
  
  public final void stopLocalAudio()
  {
    AppMethodBeat.i(205504);
    this.qEF.stopLocalAudio();
    AppMethodBeat.o(205504);
  }
  
  public static abstract interface a
  {
    public abstract void hB(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.c
 * JD-Core Version:    0.7.0.1
 */