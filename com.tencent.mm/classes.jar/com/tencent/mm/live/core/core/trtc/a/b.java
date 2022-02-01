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
  private WeakReference<d> qED;
  
  static
  {
    AppMethodBeat.i(205492);
    TAG = b.class.getName();
    AppMethodBeat.o(205492);
  }
  
  public b(d paramd)
  {
    AppMethodBeat.i(205475);
    this.qED = new WeakReference(paramd);
    AppMethodBeat.o(205475);
  }
  
  public void onAudioEffectFinished(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205488);
    this.qED.get();
    AppMethodBeat.o(205488);
  }
  
  public void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(205485);
    d locald = (d)this.qED.get();
    if (locald != null) {
      locald.onConnectOtherRoom(paramString1, paramInt, paramString2);
    }
    AppMethodBeat.o(205485);
  }
  
  public void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    AppMethodBeat.i(205486);
    d locald = (d)this.qED.get();
    if (locald != null) {
      locald.onDisConnectOtherRoom(paramInt, paramString);
    }
    AppMethodBeat.o(205486);
  }
  
  public void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(205476);
    ad.i(TAG, "onEnterRoom: elapsed = ".concat(String.valueOf(paramLong)));
    d locald = (d)this.qED.get();
    if (locald != null) {
      locald.onEnterRoom(paramLong);
    }
    AppMethodBeat.o(205476);
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(205477);
    ad.i(TAG, "onError: errCode = " + paramInt + " errMsg = " + paramString);
    d locald = (d)this.qED.get();
    if (locald != null) {
      locald.onError(paramInt, paramString, paramBundle);
    }
    AppMethodBeat.o(205477);
  }
  
  public void onExitRoom(int paramInt)
  {
    AppMethodBeat.i(205491);
    d locald = (d)this.qED.get();
    if (locald != null) {
      locald.onExitRoom(paramInt);
    }
    AppMethodBeat.o(205491);
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(205483);
    ad.i(TAG, "onFirstVideoFrame: userId = " + paramString + " streamType = " + paramInt1 + " width = " + paramInt2 + " height = " + paramInt3);
    d locald = (d)this.qED.get();
    if (locald != null) {
      locald.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(205483);
  }
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    AppMethodBeat.i(205487);
    paramArrayList = (d)this.qED.get();
    if (paramArrayList != null) {
      paramArrayList.a(paramTRTCQuality);
    }
    AppMethodBeat.o(205487);
  }
  
  public void onRecvCustomCmdMsg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(205489);
    this.qED.get();
    AppMethodBeat.o(205489);
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(205490);
    this.qED.get();
    AppMethodBeat.o(205490);
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics) {}
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205482);
    ad.i(TAG, "onUserAudioAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.qED.get();
    if (locald != null) {
      locald.onUserAudioAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(205482);
  }
  
  public void onUserEnter(String paramString)
  {
    AppMethodBeat.i(205478);
    ad.i(TAG, "onRemoteUserEnterRoom: userId = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(205478);
  }
  
  public void onUserExit(String paramString, int paramInt)
  {
    AppMethodBeat.i(205479);
    ad.i(TAG, "onRemoteUserLeaveRoom: userId = " + paramString + " reason = " + paramInt);
    d locald = (d)this.qED.get();
    if (locald != null) {
      locald.onUserExit(paramString, paramInt);
    }
    AppMethodBeat.o(205479);
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205481);
    ad.i(TAG, "onUserSubStreamAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.qED.get();
    if (locald != null) {
      locald.onUserSubStreamAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(205481);
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205480);
    ad.i(TAG, "onUserVideoAvailable: userId = " + paramString + " available = " + paramBoolean);
    d locald = (d)this.qED.get();
    if (locald != null) {
      locald.onUserVideoAvailable(paramString, paramBoolean);
    }
    AppMethodBeat.o(205480);
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(205484);
    this.qED.get();
    AppMethodBeat.o(205484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b
 * JD-Core Version:    0.7.0.1
 */