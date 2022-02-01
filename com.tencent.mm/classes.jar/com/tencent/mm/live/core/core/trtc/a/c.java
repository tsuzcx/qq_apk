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
  public static final String gLz;
  private TRTCCloud gLA;
  private boolean gLB;
  private int gLC;
  private int gLD;
  private int gLE;
  private a gLF;
  private int mAppScene;
  private int mBeautyLevel;
  private int mRuddyLevel;
  private TRTCCloudDef.TRTCParams mTRTCParams;
  private int mWhiteningLevel;
  
  static
  {
    AppMethodBeat.i(197089);
    gLz = Environment.getExternalStorageDirectory().getPath() + "/test/record/record.aac";
    AppMethodBeat.o(197089);
  }
  
  public c()
  {
    this.gLB = true;
    this.gLC = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.gLE = 0;
  }
  
  public c(TRTCCloud paramTRTCCloud, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(197076);
    this.gLB = true;
    this.gLC = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.gLE = 0;
    this.gLA = paramTRTCCloud;
    this.mTRTCParams = paramTRTCParams;
    this.mAppScene = 1;
    if (paramTRTCParams == null) {}
    for (int i = 21;; i = this.mTRTCParams.role)
    {
      this.gLD = i;
      AppMethodBeat.o(197076);
      return;
    }
  }
  
  private void amh()
  {
    AppMethodBeat.i(197081);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.amd().alZ();
    TRTCCloudDef.TRTCVideoEncParam localTRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
    localTRTCVideoEncParam.videoResolution = locald.gLU;
    localTRTCVideoEncParam.videoFps = locald.gLV;
    localTRTCVideoEncParam.videoBitrate = locald.mVideoBitrate;
    if (locald.gLW) {}
    for (int i = 1;; i = 0)
    {
      localTRTCVideoEncParam.videoResolutionMode = i;
      this.gLA.setVideoEncoderParam(localTRTCVideoEncParam);
      AppMethodBeat.o(197081);
      return;
    }
  }
  
  private void ami()
  {
    AppMethodBeat.i(197082);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.amd().alZ();
    TRTCCloudDef.TRTCNetworkQosParam localTRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
    localTRTCNetworkQosParam.controlMode = locald.mQosMode;
    localTRTCNetworkQosParam.preference = locald.mQosPreference;
    this.gLA.setNetworkQosParam(localTRTCNetworkQosParam);
    AppMethodBeat.o(197082);
  }
  
  private void amj()
  {
    int j = 1;
    AppMethodBeat.i(197083);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.amd().alZ();
    Object localObject = new TRTCCloudDef.TRTCVideoEncParam();
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolution = 100;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoFps = locald.gLV;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoBitrate = 100;
    if (locald.gLW)
    {
      i = 1;
      ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolutionMode = i;
      this.gLA.enableEncSmallVideoStream(locald.gMb, (TRTCCloudDef.TRTCVideoEncParam)localObject);
      localObject = this.gLA;
      if (!locald.gMc) {
        break label108;
      }
    }
    label108:
    for (int i = j;; i = 0)
    {
      ((TRTCCloud)localObject).setPriorRemoteVideoStreamType(i);
      AppMethodBeat.o(197083);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(a parama)
  {
    this.gLF = parama;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(197077);
    this.gLA.setListener(new b(paramd));
    AppMethodBeat.o(197077);
  }
  
  public final void ame()
  {
    AppMethodBeat.i(197078);
    com.tencent.mm.live.core.core.trtc.a.a.a locala = a.a.amd().ama();
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.amd().alZ();
    this.gLA.enableCustomVideoCapture(true);
    this.gLA.setDefaultStreamRecvMode(true, true);
    int i;
    if (locald.gLX)
    {
      this.gLA.setLocalViewFillMode(0);
      i = locald.gMf;
      this.gLA.setLocalViewRotation(i);
      if (!locala.gLM) {
        break label160;
      }
      this.gLA.setAudioRoute(0);
      label82:
      if (!locald.gMd) {
        break label171;
      }
      this.gLA.setGSensorMode(2);
    }
    for (;;)
    {
      i = locala.gLH;
      this.gLA.setSystemVolumeType(i);
      boolean bool = locald.cuD;
      this.gLA.setVideoEncoderMirror(bool);
      i = locald.gLY;
      this.gLA.setLocalViewMirror(i);
      amg();
      AppMethodBeat.o(197078);
      return;
      this.gLA.setLocalViewFillMode(1);
      break;
      label160:
      this.gLA.setAudioRoute(1);
      break label82;
      label171:
      this.gLA.setGSensorMode(0);
    }
  }
  
  public final void amf()
  {
    AppMethodBeat.i(197079);
    boolean bool = a.a.amd().ama().gLN;
    if (bool) {
      this.gLA.enableAudioVolumeEvaluation(300);
    }
    for (;;)
    {
      if (this.gLF != null) {
        this.gLF.dF(bool);
      }
      this.gLA.enterRoom(this.mTRTCParams, this.mAppScene);
      AppMethodBeat.o(197079);
      return;
      this.gLA.enableAudioVolumeEvaluation(0);
    }
  }
  
  public final void amg()
  {
    AppMethodBeat.i(197080);
    amh();
    ami();
    amj();
    AppMethodBeat.o(197080);
  }
  
  public final int amk()
  {
    int i = 20;
    AppMethodBeat.i(197085);
    if (this.gLD == 20) {
      i = 21;
    }
    if (this.gLA != null) {
      this.gLA.switchRole(i);
    }
    this.gLD = i;
    i = this.gLD;
    AppMethodBeat.o(197085);
    return i;
  }
  
  public final int aml()
  {
    return this.gLD;
  }
  
  public final void dG(boolean paramBoolean)
  {
    AppMethodBeat.i(197088);
    this.gLA.enableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(197088);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(197084);
    if (this.gLA != null) {
      this.gLA.exitRoom();
    }
    AppMethodBeat.o(197084);
  }
  
  public final void startLocalAudio()
  {
    AppMethodBeat.i(197086);
    this.gLA.startLocalAudio();
    AppMethodBeat.o(197086);
  }
  
  public final void stopLocalAudio()
  {
    AppMethodBeat.i(197087);
    this.gLA.stopLocalAudio();
    AppMethodBeat.o(197087);
  }
  
  public static abstract interface a
  {
    public abstract void dF(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.c
 * JD-Core Version:    0.7.0.1
 */