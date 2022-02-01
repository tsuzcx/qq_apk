package com.tencent.mm.live.core.core.trtc.a;

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
  private WeakReference<d> hAW;
  
  static
  {
    AppMethodBeat.i(196262);
    TAG = b.class.getName();
    AppMethodBeat.o(196262);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(196244);
    this.hAW = new WeakReference(paramd);
    AppMethodBeat.o(196244);
  }
  
  public void onAudioEffectFinished(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196259);
    this.hAW.get();
    AppMethodBeat.o(196259);
  }
  
  public void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(196256);
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onConnectOtherRoom(paramString1, paramInt, paramString2);
    }
    AppMethodBeat.o(196256);
  }
  
  public void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    AppMethodBeat.i(196257);
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onDisConnectOtherRoom(paramInt, paramString);
    }
    AppMethodBeat.o(196257);
  }
  
  public void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(196245);
    Log.i(TAG, "onEnterRoom: elapsed = ".concat(String.valueOf(paramLong)));
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onEnterRoom(paramLong);
    }
    AppMethodBeat.o(196245);
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(196247);
    Log.i(TAG, "onError: errCode = " + paramInt + " errMsg = " + paramString);
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onError(paramInt, paramString, paramBundle);
    }
    AppMethodBeat.o(196247);
  }
  
  public void onExitRoom(int paramInt)
  {
    AppMethodBeat.i(196246);
    Log.i(TAG, "onExitRoom: reason = ".concat(String.valueOf(paramInt)));
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onExitRoom(paramInt);
    }
    AppMethodBeat.o(196246);
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(196253);
    Log.i(TAG, "onFirstVideoFrame: userId = " + paramString + " streamType = " + paramInt1 + " width = " + paramInt2 + " height = " + paramInt3);
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(196253);
  }
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    AppMethodBeat.i(196258);
    paramArrayList = (d)this.hAW.get();
    if (paramArrayList != null) {
      paramArrayList.a(paramTRTCQuality);
    }
    AppMethodBeat.o(196258);
  }
  
  public void onRecvCustomCmdMsg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196260);
    this.hAW.get();
    AppMethodBeat.o(196260);
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196261);
    this.hAW.get();
    AppMethodBeat.o(196261);
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    AppMethodBeat.i(196248);
    Log.i(TAG, "onRemoteUserEnterRoom: userId = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(196248);
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(196249);
    Log.i(TAG, "onRemoteUserLeaveRoom: userId = " + paramString + " reason = " + paramInt);
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onRemoteUserLeaveRoom(paramString, paramInt);
    }
    AppMethodBeat.o(196249);
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics)
  {
    AppMethodBeat.i(196255);
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onStatistics(paramTRTCStatistics);
    }
    AppMethodBeat.o(196255);
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196252);
    Log.i(TAG, "onUserAudioAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onUserAudioAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(196252);
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196251);
    Log.i(TAG, "onUserSubStreamAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onUserSubStreamAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(196251);
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196250);
    Log.i(TAG, "onUserVideoAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.hAW.get();
    if (locald != null) {
      locald.onUserVideoAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(196250);
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(196254);
    this.hAW.get();
    AppMethodBeat.o(196254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b
 * JD-Core Version:    0.7.0.1
 */