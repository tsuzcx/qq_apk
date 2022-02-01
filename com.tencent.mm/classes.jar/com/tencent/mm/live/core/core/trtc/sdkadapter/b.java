package com.tencent.mm.live.core.core.trtc.sdkadapter;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class b
  extends TRTCCloudListener
{
  private static final String TAG;
  private WeakReference<d> mSv;
  
  static
  {
    AppMethodBeat.i(248280);
    TAG = b.class.getName();
    AppMethodBeat.o(248280);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(248276);
    this.mSv = new WeakReference(paramd);
    AppMethodBeat.o(248276);
  }
  
  public void onAudioEffectFinished(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248380);
    this.mSv.get();
    AppMethodBeat.o(248380);
  }
  
  public void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(248368);
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onConnectOtherRoom(paramString1, paramInt, paramString2);
    }
    AppMethodBeat.o(248368);
  }
  
  public void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    AppMethodBeat.i(248372);
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onDisConnectOtherRoom(paramInt, paramString);
    }
    AppMethodBeat.o(248372);
  }
  
  public void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(248286);
    Log.i(TAG, "onEnterRoom: elapsed = ".concat(String.valueOf(paramLong)));
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onEnterRoom(paramLong);
    }
    AppMethodBeat.o(248286);
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(248299);
    Log.i(TAG, "onError: errCode = " + paramInt + " errMsg = " + paramString);
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onError(paramInt, paramString, paramBundle);
    }
    AppMethodBeat.o(248299);
  }
  
  public void onExitRoom(int paramInt)
  {
    AppMethodBeat.i(248291);
    Log.i(TAG, "onExitRoom: reason = ".concat(String.valueOf(paramInt)));
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onExitRoom(paramInt);
    }
    AppMethodBeat.o(248291);
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(248350);
    Log.i(TAG, "onFirstVideoFrame: userId = " + paramString + " streamType = " + paramInt1 + " width = " + paramInt2 + " height = " + paramInt3);
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(248350);
  }
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    AppMethodBeat.i(248378);
    paramArrayList = (d)this.mSv.get();
    if (paramArrayList != null) {
      paramArrayList.a(paramTRTCQuality);
    }
    AppMethodBeat.o(248378);
  }
  
  public void onRecvCustomCmdMsg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(248381);
    paramArrayOfByte = (d)this.mSv.get();
    if (paramArrayOfByte != null) {
      paramArrayOfByte.FP(paramString);
    }
    AppMethodBeat.o(248381);
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(248385);
    paramString = (d)this.mSv.get();
    if (paramString != null) {
      paramString.al(paramArrayOfByte);
    }
    AppMethodBeat.o(248385);
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    AppMethodBeat.i(248315);
    Log.i(TAG, "onRemoteUserEnterRoom: userId = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(248315);
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(248322);
    Log.i(TAG, "onRemoteUserLeaveRoom: userId = " + paramString + " reason = " + paramInt);
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onRemoteUserLeaveRoom(paramString, paramInt);
    }
    AppMethodBeat.o(248322);
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics)
  {
    AppMethodBeat.i(248361);
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onStatistics(paramTRTCStatistics);
    }
    AppMethodBeat.o(248361);
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(248343);
    Log.i(TAG, "onUserAudioAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onUserAudioAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(248343);
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(248337);
    Log.i(TAG, "onUserSubStreamAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onUserSubStreamAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(248337);
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(248330);
    Log.i(TAG, "onUserVideoAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onUserVideoAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(248330);
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(248357);
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onUserVoiceVolume(paramArrayList, paramInt);
    }
    AppMethodBeat.o(248357);
  }
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(248310);
    Log.i(TAG, "onWarning: %d, warningMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    d locald = (d)this.mSv.get();
    if (locald != null) {
      locald.onWarning(paramInt, paramString, paramBundle);
    }
    AppMethodBeat.o(248310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.b
 * JD-Core Version:    0.7.0.1
 */