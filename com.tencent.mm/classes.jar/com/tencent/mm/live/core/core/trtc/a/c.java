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
  public static final String hAX;
  private TRTCCloud hAY;
  private boolean hAZ;
  private int hBa;
  private int hBb;
  private int hBc;
  private a hBd;
  private int mAppScene;
  private int mBeautyLevel;
  private int mRuddyLevel;
  private TRTCCloudDef.TRTCParams mTRTCParams;
  private int mWhiteningLevel;
  
  static
  {
    AppMethodBeat.i(196277);
    hAX = Environment.getExternalStorageDirectory().getPath() + "/test/record/record.aac";
    AppMethodBeat.o(196277);
  }
  
  public c()
  {
    this.hAZ = true;
    this.hBa = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.hBc = 0;
  }
  
  public c(TRTCCloud paramTRTCCloud, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(196263);
    this.hAZ = true;
    this.hBa = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.hBc = 0;
    this.hAY = paramTRTCCloud;
    this.mTRTCParams = paramTRTCParams;
    this.mAppScene = 1;
    if (paramTRTCParams == null) {}
    for (int i = 21;; i = this.mTRTCParams.role)
    {
      this.hBb = i;
      AppMethodBeat.o(196263);
      return;
    }
  }
  
  private void aDL()
  {
    AppMethodBeat.i(196268);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.aDH().aDD();
    TRTCCloudDef.TRTCVideoEncParam localTRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
    localTRTCVideoEncParam.videoResolution = locald.hBu;
    localTRTCVideoEncParam.videoFps = locald.hBv;
    localTRTCVideoEncParam.videoBitrate = locald.mVideoBitrate;
    if (locald.hBw) {}
    for (int i = 1;; i = 0)
    {
      localTRTCVideoEncParam.videoResolutionMode = i;
      this.hAY.setVideoEncoderParam(localTRTCVideoEncParam);
      AppMethodBeat.o(196268);
      return;
    }
  }
  
  private void aDM()
  {
    AppMethodBeat.i(196269);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.aDH().aDD();
    TRTCCloudDef.TRTCNetworkQosParam localTRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
    localTRTCNetworkQosParam.controlMode = locald.mQosMode;
    localTRTCNetworkQosParam.preference = locald.mQosPreference;
    this.hAY.setNetworkQosParam(localTRTCNetworkQosParam);
    AppMethodBeat.o(196269);
  }
  
  private void aDN()
  {
    int j = 1;
    AppMethodBeat.i(196270);
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.aDH().aDD();
    Object localObject = new TRTCCloudDef.TRTCVideoEncParam();
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolution = 100;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoFps = locald.hBv;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoBitrate = 100;
    if (locald.hBw)
    {
      i = 1;
      ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolutionMode = i;
      this.hAY.enableEncSmallVideoStream(locald.hBB, (TRTCCloudDef.TRTCVideoEncParam)localObject);
      localObject = this.hAY;
      if (!locald.hBC) {
        break label108;
      }
    }
    label108:
    for (int i = j;; i = 0)
    {
      ((TRTCCloud)localObject).setPriorRemoteVideoStreamType(i);
      AppMethodBeat.o(196270);
      return;
      i = 0;
      break;
    }
  }
  
  private void setSystemVolumeType(int paramInt)
  {
    AppMethodBeat.i(196272);
    this.hAY.setSystemVolumeType(paramInt);
    AppMethodBeat.o(196272);
  }
  
  public final void a(a parama)
  {
    this.hBd = parama;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(196264);
    this.hAY.setListener(new b(paramd));
    AppMethodBeat.o(196264);
  }
  
  public final void aDI()
  {
    AppMethodBeat.i(196265);
    com.tencent.mm.live.core.core.trtc.a.a.a locala = a.a.aDH().aDE();
    com.tencent.mm.live.core.core.trtc.a.a.d locald = a.a.aDH().aDD();
    this.hAY.enableCustomVideoCapture(true);
    this.hAY.setDefaultStreamRecvMode(true, true);
    int i;
    if (locald.hBx)
    {
      this.hAY.setLocalViewFillMode(0);
      i = locald.hBF;
      this.hAY.setLocalViewRotation(i);
      if (!locala.hBk) {
        break label155;
      }
      this.hAY.setAudioRoute(0);
      label82:
      if (!locald.hBD) {
        break label166;
      }
      this.hAY.setGSensorMode(2);
    }
    for (;;)
    {
      setSystemVolumeType(locala.hBf);
      boolean bool = locald.cIw;
      this.hAY.setVideoEncoderMirror(bool);
      i = locald.hBy;
      this.hAY.setLocalViewMirror(i);
      aDK();
      AppMethodBeat.o(196265);
      return;
      this.hAY.setLocalViewFillMode(1);
      break;
      label155:
      this.hAY.setAudioRoute(1);
      break label82;
      label166:
      this.hAY.setGSensorMode(0);
    }
  }
  
  public final void aDJ()
  {
    AppMethodBeat.i(196266);
    int i = a.a.aDH().aDE().hBo;
    this.hAY.setAudioQuality(i);
    setSystemVolumeType(a.a.aDH().aDE().hBf);
    boolean bool = a.a.aDH().aDE().hBl;
    if (bool) {
      this.hAY.enableAudioVolumeEvaluation(300);
    }
    for (;;)
    {
      if (this.hBd != null) {
        this.hBd.ex(bool);
      }
      this.hAY.enterRoom(this.mTRTCParams, this.mAppScene);
      AppMethodBeat.o(196266);
      return;
      this.hAY.enableAudioVolumeEvaluation(0);
    }
  }
  
  public final void aDK()
  {
    AppMethodBeat.i(196267);
    aDL();
    aDM();
    aDN();
    AppMethodBeat.o(196267);
  }
  
  public final int aDO()
  {
    int i = 20;
    AppMethodBeat.i(196273);
    if (this.hBb == 20) {
      i = 21;
    }
    if (this.hAY != null) {
      this.hAY.switchRole(i);
    }
    this.hBb = i;
    i = this.hBb;
    AppMethodBeat.o(196273);
    return i;
  }
  
  public final int aDP()
  {
    return this.hBb;
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(196271);
    if (this.hAY != null) {
      this.hAY.exitRoom();
    }
    AppMethodBeat.o(196271);
  }
  
  public final void ey(boolean paramBoolean)
  {
    AppMethodBeat.i(196276);
    this.hAY.enableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(196276);
  }
  
  public final void startLocalAudio()
  {
    AppMethodBeat.i(196274);
    this.hAY.startLocalAudio();
    AppMethodBeat.o(196274);
  }
  
  public final void stopLocalAudio()
  {
    AppMethodBeat.i(196275);
    this.hAY.stopLocalAudio();
    AppMethodBeat.o(196275);
  }
  
  public static abstract interface a
  {
    public abstract void ex(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.c
 * JD-Core Version:    0.7.0.1
 */