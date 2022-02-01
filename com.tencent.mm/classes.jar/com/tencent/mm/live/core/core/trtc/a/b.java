package com.tencent.mm.live.core.core.trtc.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
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
  private WeakReference<d> gLy;
  
  static
  {
    AppMethodBeat.i(197075);
    TAG = b.class.getName();
    AppMethodBeat.o(197075);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(197058);
    this.gLy = new WeakReference(paramd);
    AppMethodBeat.o(197058);
  }
  
  public void onAudioEffectFinished(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197072);
    this.gLy.get();
    AppMethodBeat.o(197072);
  }
  
  public void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(197069);
    d locald = (d)this.gLy.get();
    if (locald != null) {
      locald.onConnectOtherRoom(paramString1, paramInt, paramString2);
    }
    AppMethodBeat.o(197069);
  }
  
  public void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    AppMethodBeat.i(197070);
    d locald = (d)this.gLy.get();
    if (locald != null) {
      locald.onDisConnectOtherRoom(paramInt, paramString);
    }
    AppMethodBeat.o(197070);
  }
  
  public void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(197059);
    ae.i(TAG, "onEnterRoom: elapsed = ".concat(String.valueOf(paramLong)));
    d locald = (d)this.gLy.get();
    if (locald != null) {
      locald.onEnterRoom(paramLong);
    }
    AppMethodBeat.o(197059);
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(197061);
    ae.i(TAG, "onError: errCode = " + paramInt + " errMsg = " + paramString);
    d locald = (d)this.gLy.get();
    if (locald != null) {
      locald.onError(paramInt, paramString, paramBundle);
    }
    AppMethodBeat.o(197061);
  }
  
  public void onExitRoom(int paramInt)
  {
    AppMethodBeat.i(197060);
    ae.i(TAG, "onExitRoom: reason = ".concat(String.valueOf(paramInt)));
    d locald = (d)this.gLy.get();
    if (locald != null) {
      locald.onExitRoom(paramInt);
    }
    AppMethodBeat.o(197060);
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197067);
    ae.i(TAG, "onFirstVideoFrame: userId = " + paramString + " streamType = " + paramInt1 + " width = " + paramInt2 + " height = " + paramInt3);
    d locald = (d)this.gLy.get();
    if (locald != null) {
      locald.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(197067);
  }
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    AppMethodBeat.i(197071);
    paramArrayList = (d)this.gLy.get();
    if (paramArrayList != null) {
      paramArrayList.a(paramTRTCQuality);
    }
    AppMethodBeat.o(197071);
  }
  
  public void onRecvCustomCmdMsg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197073);
    this.gLy.get();
    AppMethodBeat.o(197073);
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197074);
    this.gLy.get();
    AppMethodBeat.o(197074);
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    AppMethodBeat.i(197062);
    ae.i(TAG, "onRemoteUserEnterRoom: userId = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(197062);
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(197063);
    ae.i(TAG, "onRemoteUserLeaveRoom: userId = " + paramString + " reason = " + paramInt);
    d locald = (d)this.gLy.get();
    if (locald != null) {
      locald.onRemoteUserLeaveRoom(paramString, paramInt);
    }
    AppMethodBeat.o(197063);
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics) {}
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197066);
    ae.i(TAG, "onUserAudioAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.gLy.get();
    if (locald != null) {
      locald.onUserAudioAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(197066);
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197065);
    ae.i(TAG, "onUserSubStreamAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.gLy.get();
    if (locald != null) {
      locald.onUserSubStreamAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(197065);
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197064);
    ae.i(TAG, "onUserVideoAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.gLy.get();
    if (locald != null) {
      locald.onUserVideoAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(197064);
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(197068);
    this.gLy.get();
    AppMethodBeat.o(197068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b
 * JD-Core Version:    0.7.0.1
 */