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
  private WeakReference<d> koF;
  
  static
  {
    AppMethodBeat.i(198272);
    TAG = b.class.getName();
    AppMethodBeat.o(198272);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(198233);
    this.koF = new WeakReference(paramd);
    AppMethodBeat.o(198233);
  }
  
  public void onAudioEffectFinished(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198268);
    this.koF.get();
    AppMethodBeat.o(198268);
  }
  
  public void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(198262);
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onConnectOtherRoom(paramString1, paramInt, paramString2);
    }
    AppMethodBeat.o(198262);
  }
  
  public void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    AppMethodBeat.i(198264);
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onDisConnectOtherRoom(paramInt, paramString);
    }
    AppMethodBeat.o(198264);
  }
  
  public void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(198235);
    Log.i(TAG, "onEnterRoom: elapsed = ".concat(String.valueOf(paramLong)));
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onEnterRoom(paramLong);
    }
    AppMethodBeat.o(198235);
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(198237);
    Log.i(TAG, "onError: errCode = " + paramInt + " errMsg = " + paramString);
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onError(paramInt, paramString, paramBundle);
    }
    AppMethodBeat.o(198237);
  }
  
  public void onExitRoom(int paramInt)
  {
    AppMethodBeat.i(198236);
    Log.i(TAG, "onExitRoom: reason = ".concat(String.valueOf(paramInt)));
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onExitRoom(paramInt);
    }
    AppMethodBeat.o(198236);
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(198256);
    Log.i(TAG, "onFirstVideoFrame: userId = " + paramString + " streamType = " + paramInt1 + " width = " + paramInt2 + " height = " + paramInt3);
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(198256);
  }
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    AppMethodBeat.i(198266);
    paramArrayList = (d)this.koF.get();
    if (paramArrayList != null) {
      paramArrayList.a(paramTRTCQuality);
    }
    AppMethodBeat.o(198266);
  }
  
  public void onRecvCustomCmdMsg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198269);
    paramArrayOfByte = (d)this.koF.get();
    if (paramArrayOfByte != null) {
      paramArrayOfByte.Nw(paramString);
    }
    AppMethodBeat.o(198269);
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198271);
    paramString = (d)this.koF.get();
    if (paramString != null) {
      paramString.al(paramArrayOfByte);
    }
    AppMethodBeat.o(198271);
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    AppMethodBeat.i(198240);
    Log.i(TAG, "onRemoteUserEnterRoom: userId = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(198240);
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(198243);
    Log.i(TAG, "onRemoteUserLeaveRoom: userId = " + paramString + " reason = " + paramInt);
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onRemoteUserLeaveRoom(paramString, paramInt);
    }
    AppMethodBeat.o(198243);
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics)
  {
    AppMethodBeat.i(198259);
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onStatistics(paramTRTCStatistics);
    }
    AppMethodBeat.o(198259);
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(198253);
    Log.i(TAG, "onUserAudioAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onUserAudioAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(198253);
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(198252);
    Log.i(TAG, "onUserSubStreamAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onUserSubStreamAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(198252);
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(198247);
    Log.i(TAG, "onUserVideoAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onUserVideoAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(198247);
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(198258);
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onUserVoiceVolume(paramArrayList, paramInt);
    }
    AppMethodBeat.o(198258);
  }
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(198238);
    Log.i(TAG, "onWarning: %d, warningMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    d locald = (d)this.koF.get();
    if (locald != null) {
      locald.onWarning(paramInt, paramString, paramBundle);
    }
    AppMethodBeat.o(198238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.b
 * JD-Core Version:    0.7.0.1
 */