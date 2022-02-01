package com.tencent.qav.controller.c2c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.SDKConfigInfo;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.SoLoadUtil;
import com.tencent.qav.app.AppSetting;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.reporter.DeviceMonitor;
import com.tencent.qav.utils.DeviceInfoUtil;

public class C2COperatorBase
  implements IVideoEventListener
{
  private static final String TAG = "C2COperatorBase";
  protected Context mContext;
  protected long mSelfUin;
  protected VcControllerImpl mVcCtrl;
  protected VideoChannelInterface mVideoChannel;
  
  public C2COperatorBase(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    this.mContext = paramContext;
    this.mSelfUin = paramLong;
    this.mVideoChannel = paramVideoChannelInterface;
    loadLibrary();
    initVcCtrl();
  }
  
  private void initVcCtrl()
  {
    AVLog.d("C2COperatorBase", "initVcCtrl");
    try
    {
      if (this.mVcCtrl == null)
      {
        Object localObject = new DisplayMetrics();
        ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        int i = ((DisplayMetrics)localObject).widthPixels;
        int j = ((DisplayMetrics)localObject).heightPixels;
        localObject = new VcControllerImpl(this.mContext, this.mVideoChannel, this, i, j);
        i = AppSetting.getAppId();
        String str1 = this.mContext.getPackageName();
        j = DeviceMonitor.getInstance().getApnType(this.mContext);
        String str2 = DeviceInfoUtil.getIMSI();
        str2 = str2 + "," + "";
        SDKConfigInfo localSDKConfigInfo = new SDKConfigInfo(this.mContext);
        AVLog.d("C2COperatorBase", String.format("initVcCtrl result=%s", new Object[] { Integer.valueOf(((VcControllerImpl)localObject).init(this.mContext, this.mSelfUin, "8.0.5", Build.MODEL, String.valueOf(i), str1, AppSetting.getLC(), DeviceInfoUtil.getIMEI(), VcSystemInfo.getDeviceName(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, VcSystemInfo.getCPUName(), j, str2, localSDKConfigInfo)) }));
        this.mVcCtrl = ((VcControllerImpl)localObject);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AVLog.e("C2COperatorBase", "initVcCtrl  fail.", localThrowable);
      this.mVcCtrl = null;
    }
  }
  
  private void loadLibrary()
  {
    try
    {
      SoLoadUtil.loadNativeLibrary(this.mContext, "c++_shared");
      SoLoadUtil.loadNativeLibrary(this.mContext, "xplatform");
      SoLoadUtil.loadNativeLibrary(this.mContext, "stlport_shared");
      SoLoadUtil.loadNativeLibrary(this.mContext, "SDKCommon");
      SoLoadUtil.loadNativeLibrary(this.mContext, "VideoCtrl");
      return;
    }
    catch (Exception localException)
    {
      Log.e("C2COperatorBase", "loadLibrary failed.", localException);
    }
  }
  
  private void unInitVcCtrl()
  {
    AVLog.d("C2COperatorBase", "unInitVcCtrl");
    try
    {
      if (this.mVcCtrl != null)
      {
        this.mVcCtrl.uninit();
        this.mVcCtrl = null;
      }
      return;
    }
    catch (Exception localException)
    {
      AVLog.e("C2COperatorBase", "unInitVcCtrl  fail.", localException);
    }
  }
  
  public int IsOfflineSession(String paramString)
  {
    return 0;
  }
  
  public void checkNetStatus() {}
  
  public void dataTransfered(int paramInt, long paramLong) {}
  
  public void destroy()
  {
    this.mContext = null;
    this.mSelfUin = 0L;
    this.mVideoChannel = null;
    unInitVcCtrl();
  }
  
  public int getAPAndGateWayIP()
  {
    return 0;
  }
  
  public long getMsfInviteTimeStamp(long paramLong)
  {
    return 0L;
  }
  
  public VcControllerImpl getVcCtrl()
  {
    return this.mVcCtrl;
  }
  
  public void onAVShiftEvent(int paramInt, String paramString) {}
  
  public void onAcceptVideoMode(String paramString) {}
  
  public void onAcceptedVideo(String paramString) {}
  
  public void onAnotherHaveAccept(String paramString) {}
  
  public void onAnotherHaveReject(String paramString) {}
  
  public void onAnotherIsRing(String paramString, boolean paramBoolean) {}
  
  public void onApptypeNotSuit(String paramString) {}
  
  public void onCancelRequest(String paramString) {}
  
  public void onCancelVideoMode(String paramString) {}
  
  public void onChangePreviewSize(int paramInt1, int paramInt2) {}
  
  public void onChannelReady(String paramString) {}
  
  public void onCloseVideo(String paramString, int paramInt, long paramLong) {}
  
  public void onConfigSysDealDone(String paramString) {}
  
  public void onDetectAudioDataIssue(int paramInt) {}
  
  public void onFpsChange(int paramInt) {}
  
  public void onGroundGlassSwitch(String paramString, int paramInt) {}
  
  public void onGroundGlassWaitTimeChange(String paramString, int paramInt) {}
  
  public void onInviteReached(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte) {}
  
  public void onMediaCameraNotify(byte[] paramArrayOfByte, long paramLong) {}
  
  public void onNetLevel_S2C(String paramString, long paramLong, byte[] paramArrayOfByte) {}
  
  public void onNetworkDisconnect(String paramString) {}
  
  public void onNetworkInfo_S2C(String paramString, byte[] paramArrayOfByte, long paramLong) {}
  
  public void onNetworkMonitorInfo(String paramString, byte[] paramArrayOfByte1, long paramLong, byte[] paramArrayOfByte2) {}
  
  public void onNotRecvAudioData(boolean paramBoolean) {}
  
  public void onOtherTerminalChatingStatus(String paramString, long paramLong, int paramInt) {}
  
  public void onPauseAudio(String paramString) {}
  
  public void onPauseVideo(String paramString) {}
  
  public void onPeerSwitchTerminalFail(String paramString, int paramInt) {}
  
  public void onPeerSwitchTerninal(String paramString) {}
  
  public void onPstnCallConnected(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte) {}
  
  public void onReceiveC2CMsg(String paramString, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onReceiveDoodle(byte[] paramArrayOfByte) {}
  
  public void onReceiveFirstVideoFrame(String paramString) {}
  
  public void onReceiveFucMultiFaceExp(String paramString) {}
  
  public void onReceiveFucMultiMode(String paramString) {}
  
  public void onReceiveFucMultiVolumeExp(String paramString) {}
  
  public void onReceiveMagicface(int paramInt, String paramString) {}
  
  public void onReceiveRecordMsg(String paramString1, String paramString2) {}
  
  public void onReceiveSubtitleChanged(int paramInt, String paramString) {}
  
  public void onRecordAudio(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void onRecvFirstAudioData(boolean paramBoolean) {}
  
  public void onRejectVideo(String paramString) {}
  
  public void onRejectVideoMode(String paramString) {}
  
  public void onRequestVideo(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3) {}
  
  public void onRequestVideoMode(String paramString) {}
  
  public void onResumeAudio(String paramString) {}
  
  public void onResumeVideo(String paramString) {}
  
  public void onSDKCustomCommand(String paramString, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onSendC2CMsg(String paramString) {}
  
  public void onSwitchGroup(String paramString, byte[] paramArrayOfByte, long paramLong) {}
  
  public void onSwitchTerminalSuccess(String paramString, int paramInt) {}
  
  public void onSyncOtherTerminalChatStatus(String paramString, int paramInt) {}
  
  public void receiveTransferMsg(String paramString, int paramInt, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.c2c.C2COperatorBase
 * JD-Core Version:    0.7.0.1
 */