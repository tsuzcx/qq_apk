package com.tencent.mm.live.core.core.trtc.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
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
  private WeakReference<d> gIP;
  
  static
  {
    AppMethodBeat.i(216676);
    TAG = b.class.getName();
    AppMethodBeat.o(216676);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(216659);
    this.gIP = new WeakReference(paramd);
    AppMethodBeat.o(216659);
  }
  
  public void onAudioEffectFinished(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216673);
    this.gIP.get();
    AppMethodBeat.o(216673);
  }
  
  public void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(216670);
    d locald = (d)this.gIP.get();
    if (locald != null) {
      locald.onConnectOtherRoom(paramString1, paramInt, paramString2);
    }
    AppMethodBeat.o(216670);
  }
  
  public void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    AppMethodBeat.i(216671);
    d locald = (d)this.gIP.get();
    if (locald != null) {
      locald.onDisConnectOtherRoom(paramInt, paramString);
    }
    AppMethodBeat.o(216671);
  }
  
  public void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(216660);
    ad.i(TAG, "onEnterRoom: elapsed = ".concat(String.valueOf(paramLong)));
    d locald = (d)this.gIP.get();
    if (locald != null) {
      locald.onEnterRoom(paramLong);
    }
    AppMethodBeat.o(216660);
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(216662);
    ad.i(TAG, "onError: errCode = " + paramInt + " errMsg = " + paramString);
    d locald = (d)this.gIP.get();
    if (locald != null) {
      locald.onError(paramInt, paramString, paramBundle);
    }
    AppMethodBeat.o(216662);
  }
  
  public void onExitRoom(int paramInt)
  {
    AppMethodBeat.i(216661);
    ad.i(TAG, "onExitRoom: reason = ".concat(String.valueOf(paramInt)));
    d locald = (d)this.gIP.get();
    if (locald != null) {
      locald.onExitRoom(paramInt);
    }
    AppMethodBeat.o(216661);
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(216668);
    ad.i(TAG, "onFirstVideoFrame: userId = " + paramString + " streamType = " + paramInt1 + " width = " + paramInt2 + " height = " + paramInt3);
    d locald = (d)this.gIP.get();
    if (locald != null) {
      locald.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(216668);
  }
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    AppMethodBeat.i(216672);
    paramArrayList = (d)this.gIP.get();
    if (paramArrayList != null) {
      paramArrayList.a(paramTRTCQuality);
    }
    AppMethodBeat.o(216672);
  }
  
  public void onRecvCustomCmdMsg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216674);
    this.gIP.get();
    AppMethodBeat.o(216674);
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216675);
    this.gIP.get();
    AppMethodBeat.o(216675);
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    AppMethodBeat.i(216663);
    ad.i(TAG, "onRemoteUserEnterRoom: userId = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(216663);
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(216664);
    ad.i(TAG, "onRemoteUserLeaveRoom: userId = " + paramString + " reason = " + paramInt);
    d locald = (d)this.gIP.get();
    if (locald != null) {
      locald.onRemoteUserLeaveRoom(paramString, paramInt);
    }
    AppMethodBeat.o(216664);
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics) {}
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(216667);
    ad.i(TAG, "onUserAudioAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.gIP.get();
    if (locald != null) {
      locald.onUserAudioAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(216667);
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(216666);
    ad.i(TAG, "onUserSubStreamAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.gIP.get();
    if (locald != null) {
      locald.onUserSubStreamAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(216666);
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(216665);
    ad.i(TAG, "onUserVideoAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.gIP.get();
    if (locald != null) {
      locald.onUserVideoAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(216665);
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(216669);
    this.gIP.get();
    AppMethodBeat.o(216669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b
 * JD-Core Version:    0.7.0.1
 */