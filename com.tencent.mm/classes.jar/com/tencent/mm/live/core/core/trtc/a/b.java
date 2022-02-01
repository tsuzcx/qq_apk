package com.tencent.mm.live.core.core.trtc.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
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
  private WeakReference<d> gph;
  
  static
  {
    AppMethodBeat.i(209022);
    TAG = b.class.getName();
    AppMethodBeat.o(209022);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(209005);
    this.gph = new WeakReference(paramd);
    AppMethodBeat.o(209005);
  }
  
  public void onAudioEffectFinished(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209019);
    this.gph.get();
    AppMethodBeat.o(209019);
  }
  
  public void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(209016);
    d locald = (d)this.gph.get();
    if (locald != null) {
      locald.onConnectOtherRoom(paramString1, paramInt, paramString2);
    }
    AppMethodBeat.o(209016);
  }
  
  public void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    AppMethodBeat.i(209017);
    d locald = (d)this.gph.get();
    if (locald != null) {
      locald.onDisConnectOtherRoom(paramInt, paramString);
    }
    AppMethodBeat.o(209017);
  }
  
  public void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(209006);
    ac.i(TAG, "onEnterRoom: elapsed = ".concat(String.valueOf(paramLong)));
    d locald = (d)this.gph.get();
    if (locald != null) {
      locald.onEnterRoom(paramLong);
    }
    AppMethodBeat.o(209006);
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(209008);
    ac.i(TAG, "onError: errCode = " + paramInt + " errMsg = " + paramString);
    d locald = (d)this.gph.get();
    if (locald != null) {
      locald.onError(paramInt, paramString, paramBundle);
    }
    AppMethodBeat.o(209008);
  }
  
  public void onExitRoom(int paramInt)
  {
    AppMethodBeat.i(209007);
    ac.i(TAG, "onExitRoom: reason = ".concat(String.valueOf(paramInt)));
    d locald = (d)this.gph.get();
    if (locald != null) {
      locald.onExitRoom(paramInt);
    }
    AppMethodBeat.o(209007);
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209014);
    ac.i(TAG, "onFirstVideoFrame: userId = " + paramString + " streamType = " + paramInt1 + " width = " + paramInt2 + " height = " + paramInt3);
    d locald = (d)this.gph.get();
    if (locald != null) {
      locald.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(209014);
  }
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    AppMethodBeat.i(209018);
    paramArrayList = (d)this.gph.get();
    if (paramArrayList != null) {
      paramArrayList.a(paramTRTCQuality);
    }
    AppMethodBeat.o(209018);
  }
  
  public void onRecvCustomCmdMsg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209020);
    this.gph.get();
    AppMethodBeat.o(209020);
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209021);
    this.gph.get();
    AppMethodBeat.o(209021);
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    AppMethodBeat.i(209009);
    ac.i(TAG, "onRemoteUserEnterRoom: userId = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(209009);
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(209010);
    ac.i(TAG, "onRemoteUserLeaveRoom: userId = " + paramString + " reason = " + paramInt);
    d locald = (d)this.gph.get();
    if (locald != null) {
      locald.onRemoteUserLeaveRoom(paramString, paramInt);
    }
    AppMethodBeat.o(209010);
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics) {}
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(209013);
    ac.i(TAG, "onUserAudioAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.gph.get();
    if (locald != null) {
      locald.onUserAudioAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(209013);
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(209012);
    ac.i(TAG, "onUserSubStreamAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.gph.get();
    if (locald != null) {
      locald.onUserSubStreamAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(209012);
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(209011);
    ac.i(TAG, "onUserVideoAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.gph.get();
    if (locald != null) {
      locald.onUserVideoAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(209011);
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(209015);
    this.gph.get();
    AppMethodBeat.o(209015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b
 * JD-Core Version:    0.7.0.1
 */