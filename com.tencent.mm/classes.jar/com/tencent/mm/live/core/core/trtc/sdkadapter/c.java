package com.tencent.mm.live.core.core.trtc.sdkadapter;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCNetworkQosParam;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import java.io.File;
import org.json.JSONObject;

public final class c
{
  public static final String mSw;
  public int mAppScene;
  private int mBeautyLevel;
  private int mRuddyLevel;
  public int mSA;
  private int mSB;
  public a mSC;
  public i mSD;
  public TRTCCloud mSx;
  private boolean mSy;
  private int mSz;
  public TRTCCloudDef.TRTCParams mTRTCParams;
  private int mWhiteningLevel;
  
  static
  {
    AppMethodBeat.i(248326);
    mSw = Environment.getExternalStorageDirectory().getPath() + "/test/record/record.aac";
    AppMethodBeat.o(248326);
  }
  
  public c()
  {
    this.mSy = true;
    this.mSz = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.mSB = 0;
    this.mSD = null;
  }
  
  public c(TRTCCloud paramTRTCCloud, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(248281);
    this.mSy = true;
    this.mSz = 0;
    this.mBeautyLevel = 5;
    this.mWhiteningLevel = 3;
    this.mRuddyLevel = 2;
    this.mSB = 0;
    this.mSD = null;
    this.mSx = paramTRTCCloud;
    this.mTRTCParams = paramTRTCParams;
    this.mAppScene = 1;
    if (paramTRTCParams == null) {}
    for (int i = 21;; i = this.mTRTCParams.role)
    {
      this.mSA = i;
      AppMethodBeat.o(248281);
      return;
    }
  }
  
  private void bfs()
  {
    AppMethodBeat.i(248313);
    e locale = a.a.bfr().bfn();
    TRTCCloudDef.TRTCNetworkQosParam localTRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
    localTRTCNetworkQosParam.controlMode = locale.mQosMode;
    localTRTCNetworkQosParam.preference = locale.mQosPreference;
    this.mSx.setNetworkQosParam(localTRTCNetworkQosParam);
    AppMethodBeat.o(248313);
  }
  
  private void bft()
  {
    int j = 1;
    AppMethodBeat.i(248320);
    e locale = a.a.bfr().bfn();
    Object localObject = new TRTCCloudDef.TRTCVideoEncParam();
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolution = 100;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoFps = locale.mTa;
    ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoBitrate = 100;
    if (locale.mTf)
    {
      i = 1;
      ((TRTCCloudDef.TRTCVideoEncParam)localObject).videoResolutionMode = i;
      this.mSx.enableEncSmallVideoStream(locale.mTk, (TRTCCloudDef.TRTCVideoEncParam)localObject);
      localObject = this.mSx;
      if (!locale.mTl) {
        break label108;
      }
    }
    label108:
    for (int i = j;; i = 0)
    {
      ((TRTCCloud)localObject).setPriorRemoteVideoStreamType(i);
      AppMethodBeat.o(248320);
      return;
      i = 0;
      break;
    }
  }
  
  private void fM(boolean paramBoolean)
  {
    AppMethodBeat.i(248293);
    e locale = a.a.bfr().bfn();
    int j = locale.mTu;
    int k = locale.mTv;
    int i;
    TRTCCloudDef.TRTCVideoEncParam localTRTCVideoEncParam;
    if (Util.isEqual(this.mSD.mNM, this.mTRTCParams.userId))
    {
      i = 1;
      localTRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
      localTRTCVideoEncParam.videoResolution = locale.mSZ;
      if ((!paramBoolean) || (i == 0)) {
        break label277;
      }
      localTRTCVideoEncParam.videoFps = locale.mTs;
      localTRTCVideoEncParam.videoBitrate = locale.mTt;
      label95:
      localTRTCVideoEncParam.minVideoBitrate = locale.mMinVideoBitrate;
      if (locale.mTq)
      {
        localTRTCVideoEncParam.videoResolution = locale.mTb;
        localTRTCVideoEncParam.videoFps = locale.mTc;
        localTRTCVideoEncParam.videoBitrate = locale.mTd;
        localTRTCVideoEncParam.minVideoBitrate = locale.mTe;
      }
      if (!locale.mTf) {
        break label300;
      }
      i = 1;
      label163:
      localTRTCVideoEncParam.videoResolutionMode = i;
      if ((j != 0) && (k != 0)) {
        break label305;
      }
      this.mSx.setVideoEncoderParam(localTRTCVideoEncParam);
    }
    for (;;)
    {
      Log.i("MicroMsg.TRTCCloudManager", "setBigSteam isAudioMode:%s videoFps:%s videoBitrate:%s audioModeFps:%s audioModeBitrate:%s customWidth:%s customHeight:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(locale.mTa), Integer.valueOf(locale.mVideoBitrate), Integer.valueOf(locale.mTs), Integer.valueOf(locale.mTt), Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(248293);
      return;
      i = 0;
      break;
      label277:
      localTRTCVideoEncParam.videoFps = locale.mTa;
      localTRTCVideoEncParam.videoBitrate = locale.mVideoBitrate;
      break label95;
      label300:
      i = 0;
      break label163;
      label305:
      k(j, k, localTRTCVideoEncParam.videoFps, localTRTCVideoEncParam.videoBitrate, localTRTCVideoEncParam.minVideoBitrate);
    }
  }
  
  private void k(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(248306);
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
        this.mSx.callExperimentalAPI(localJSONObject2.toString());
        AppMethodBeat.o(248306);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.TRTCCloudManager", "setCustomVideoEncoderParam fail:%s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(248306);
  }
  
  public final int bfu()
  {
    int i = 20;
    AppMethodBeat.i(248347);
    if (this.mSA == 20) {
      i = 21;
    }
    if (this.mSx != null) {
      this.mSx.switchRole(i);
    }
    this.mSA = i;
    i = this.mSA;
    AppMethodBeat.o(248347);
    return i;
  }
  
  public final void fL(boolean paramBoolean)
  {
    AppMethodBeat.i(248334);
    fM(paramBoolean);
    bfs();
    bft();
    AppMethodBeat.o(248334);
  }
  
  public final void setSystemVolumeType(int paramInt)
  {
    AppMethodBeat.i(248340);
    this.mSx.setSystemVolumeType(paramInt);
    AppMethodBeat.o(248340);
  }
  
  public final void startLocalAudio()
  {
    AppMethodBeat.i(248353);
    com.tencent.mm.hellhoundlib.a.a.a(this.mSx, "com/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager", "startLocalAudio", "()V", "com/tencent/trtc/TRTCCloud", "startLocalAudio", "()V");
    AppMethodBeat.o(248353);
  }
  
  public static abstract interface a
  {
    public abstract void fH(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.c
 * JD-Core Version:    0.7.0.1
 */