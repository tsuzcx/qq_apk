package com.tencent.mm.live.core.core.trtc.sdkadapter;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCNetworkQosParam;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static final String koG;
  private TRTCCloud koH;
  private boolean koI;
  private int koJ;
  private int koK;
  private int koL;
  private a koM;
  private h koN;
  private int mAppScene;
  private int mBeautyLevel;
  private int mRuddyLevel;
  private TRTCCloudDef.TRTCParams mTRTCParams;
  private int mWhiteningLevel;
  
  static
  {
    AppMethodBeat.i(198437);
    koG = Environment.getExternalStorageDirectory().getPath() + "/test/record/record.aac";
    AppMethodBeat.o(198437);
  }
  
  public c()
  {
    this.koI = true;
    this.koJ = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.koL = 0;
    this.koN = null;
  }
  
  public c(TRTCCloud paramTRTCCloud, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(198366);
    this.koI = true;
    this.koJ = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.koL = 0;
    this.koN = null;
    this.koH = paramTRTCCloud;
    this.mTRTCParams = paramTRTCParams;
    this.mAppScene = 1;
    if (paramTRTCParams == null) {}
    for (int i = 21;; i = this.mTRTCParams.role)
    {
      this.koK = i;
      AppMethodBeat.o(198366);
      return;
    }
  }
  
  private void aLP()
  {
    AppMethodBeat.i(198411);
    e locale = a.a.aLN().aLJ();
    TRTCCloudDef.TRTCNetworkQosParam localTRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
    localTRTCNetworkQosParam.controlMode = locale.mQosMode;
    localTRTCNetworkQosParam.preference = locale.mQosPreference;
    this.koH.setNetworkQosParam(localTRTCNetworkQosParam);
    AppMethodBeat.o(198411);
  }
  
  private void aLQ()
  {
    int j = 1;
    AppMethodBeat.i(198416);
    e locale = a.a.aLN().aLJ();
    Object localObject = new TRTCCloudDef.TRTCVideoEncParam();
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolution = 100;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoFps = locale.kpj;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoBitrate = 100;
    if (locale.kpo)
    {
      i = 1;
      ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolutionMode = i;
      this.koH.enableEncSmallVideoStream(locale.kpt, (TRTCCloudDef.TRTCVideoEncParam)localObject);
      localObject = this.koH;
      if (!locale.kpu) {
        break label108;
      }
    }
    label108:
    for (int i = j;; i = 0)
    {
      ((TRTCCloud)localObject).setPriorRemoteVideoStreamType(i);
      AppMethodBeat.o(198416);
      return;
      i = 0;
      break;
    }
  }
  
  private void eZ(boolean paramBoolean)
  {
    AppMethodBeat.i(198399);
    e locale = a.a.aLN().aLJ();
    int j = locale.kpC;
    int k = locale.kpD;
    int i;
    TRTCCloudDef.TRTCVideoEncParam localTRTCVideoEncParam;
    if (Util.isEqual(this.koN.kmC, this.mTRTCParams.userId))
    {
      i = 1;
      localTRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
      localTRTCVideoEncParam.videoResolution = locale.kpi;
      if ((!paramBoolean) || (i == 0)) {
        break label277;
      }
      localTRTCVideoEncParam.videoFps = locale.kpA;
      localTRTCVideoEncParam.videoBitrate = locale.kpB;
      label95:
      localTRTCVideoEncParam.minVideoBitrate = locale.mMinVideoBitrate;
      if (locale.kpz)
      {
        localTRTCVideoEncParam.videoResolution = locale.kpk;
        localTRTCVideoEncParam.videoFps = locale.kpl;
        localTRTCVideoEncParam.videoBitrate = locale.kpm;
        localTRTCVideoEncParam.minVideoBitrate = locale.kpn;
      }
      if (!locale.kpo) {
        break label300;
      }
      i = 1;
      label163:
      localTRTCVideoEncParam.videoResolutionMode = i;
      if ((j != 0) && (k != 0)) {
        break label305;
      }
      this.koH.setVideoEncoderParam(localTRTCVideoEncParam);
    }
    for (;;)
    {
      Log.i("MicroMsg.TRTCCloudManager", "setBigSteam isAudioMode:%s videoFps:%s videoBitrate:%s audioModeFps:%s audioModeBitrate:%s customWidth:%s customHeight:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(locale.kpj), Integer.valueOf(locale.mVideoBitrate), Integer.valueOf(locale.kpA), Integer.valueOf(locale.kpB), Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(198399);
      return;
      i = 0;
      break;
      label277:
      localTRTCVideoEncParam.videoFps = locale.kpj;
      localTRTCVideoEncParam.videoBitrate = locale.mVideoBitrate;
      break label95;
      label300:
      i = 0;
      break label163;
      label305:
      j(j, k, localTRTCVideoEncParam.videoFps, localTRTCVideoEncParam.videoBitrate, localTRTCVideoEncParam.minVideoBitrate);
    }
  }
  
  private void j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(198408);
    Log.i("MicroMsg.TRTCCloudManager", "setCustomVideoEncoderParam type:%s width:%s height:%s fps:%s bitrate:%s minbitrate:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt3 > 0) && (paramInt4 > 0)) {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("streamType", 0);
        localJSONObject1.put("videoWidth", paramInt1);
        localJSONObject1.put("videoHeight", paramInt2);
        localJSONObject1.put("videoBitrate", paramInt4);
        localJSONObject1.put("minVideoBitrate", paramInt5);
        localJSONObject1.put("videoFps", paramInt3);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("api", "setVideoEncodeParamEx");
        localJSONObject2.put("params", localJSONObject1);
        Log.i("MicroMsg.TRTCCloudManager", "setCustomVideoEncoderParam %s", new Object[] { localJSONObject2.toString() });
        this.koH.callExperimentalAPI(localJSONObject2.toString());
        AppMethodBeat.o(198408);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.TRTCCloudManager", "setCustomVideoEncoderParam fail:%s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(198408);
  }
  
  private void setSystemVolumeType(int paramInt)
  {
    AppMethodBeat.i(198418);
    this.koH.setSystemVolumeType(paramInt);
    AppMethodBeat.o(198418);
  }
  
  public final void Nz(String paramString)
  {
    AppMethodBeat.i(198434);
    this.koH.sendSEIMsg(paramString.getBytes(), 1);
    AppMethodBeat.o(198434);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(198376);
    com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a locala = a.a.aLN().aLK();
    e locale = a.a.aLN().aLJ();
    this.koN = paramh;
    this.koH.enableCustomVideoCapture(true);
    this.koH.setDefaultStreamRecvMode(true, true);
    int i;
    if (locale.kpp)
    {
      this.koH.setLocalViewFillMode(0);
      i = locale.kpx;
      this.koH.setLocalViewRotation(i);
      if (!locala.koX) {
        break label166;
      }
      this.koH.setAudioRoute(0);
      label90:
      if (!locale.kpv) {
        break label177;
      }
      this.koH.setGSensorMode(2);
    }
    for (;;)
    {
      setSystemVolumeType(locala.koS);
      boolean bool = locale.cIZ;
      this.koH.setVideoEncoderMirror(bool);
      i = locale.kpq;
      this.koH.setLocalViewMirror(i);
      eY(false);
      AppMethodBeat.o(198376);
      return;
      this.koH.setLocalViewFillMode(1);
      break;
      label166:
      this.koH.setAudioRoute(1);
      break label90;
      label177:
      this.koH.setGSensorMode(0);
    }
  }
  
  public final void a(a parama)
  {
    this.koM = parama;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(198369);
    this.koH.setListener(new b(paramd));
    AppMethodBeat.o(198369);
  }
  
  public final void aLO()
  {
    int i = 0;
    AppMethodBeat.i(198381);
    int j = a.a.aLN().aLK().kpb;
    this.koH.setAudioQuality(j);
    setSystemVolumeType(a.a.aLN().aLK().koS);
    boolean bool = a.a.aLN().aLK().koY;
    if (bool) {
      this.koH.enableAudioVolumeEvaluation(300);
    }
    for (;;)
    {
      if (this.koM != null) {
        this.koM.eW(bool);
      }
      bool = a.a.aLN().aLJ().kpz;
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("api", "enableHevcEncode");
        JSONObject localJSONObject2 = new JSONObject();
        if (bool) {
          i = 1;
        }
        localJSONObject2.put("enable", i);
        localJSONObject1.put("params", localJSONObject2);
        this.koH.callExperimentalAPI(localJSONObject1.toString());
      }
      catch (JSONException localJSONException)
      {
        label159:
        break label159;
      }
      this.koH.enterRoom(this.mTRTCParams, this.mAppScene);
      AppMethodBeat.o(198381);
      return;
      this.koH.enableAudioVolumeEvaluation(0);
    }
  }
  
  public final int aLR()
  {
    int i = 20;
    AppMethodBeat.i(198423);
    if (this.koK == 20) {
      i = 21;
    }
    if (this.koH != null) {
      this.koH.switchRole(i);
    }
    this.koK = i;
    i = this.koK;
    AppMethodBeat.o(198423);
    return i;
  }
  
  public final int aLS()
  {
    return this.koK;
  }
  
  public final void aLT()
  {
    AppMethodBeat.i(198431);
    this.koH.DisconnectOtherRoom();
    AppMethodBeat.o(198431);
  }
  
  public final void eY(boolean paramBoolean)
  {
    AppMethodBeat.i(198384);
    eZ(paramBoolean);
    aLP();
    aLQ();
    AppMethodBeat.o(198384);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(198417);
    if (this.koH != null) {
      this.koH.exitRoom();
    }
    AppMethodBeat.o(198417);
  }
  
  public final void fa(boolean paramBoolean)
  {
    AppMethodBeat.i(198433);
    this.koH.enableAudioEarMonitoring(paramBoolean);
    AppMethodBeat.o(198433);
  }
  
  public final void n(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(198429);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("roomId", Long.parseLong(paramString1));
      localJSONObject.put("userId", paramString2);
      localJSONObject.put("sign", paramString3);
      this.koH.ConnectOtherRoom(localJSONObject.toString());
      AppMethodBeat.o(198429);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(198429);
    }
  }
  
  public final void startLocalAudio()
  {
    AppMethodBeat.i(198425);
    this.koH.startLocalAudio();
    AppMethodBeat.o(198425);
  }
  
  public final void stopLocalAudio()
  {
    AppMethodBeat.i(198426);
    this.koH.stopLocalAudio();
    AppMethodBeat.o(198426);
  }
  
  public static abstract interface a
  {
    public abstract void eW(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.c
 * JD-Core Version:    0.7.0.1
 */