package com.tencent.qav.controller.multi;

import android.content.Context;
import com.tencent.av.gaudio.AVInviteAccount;
import com.tencent.av.gaudio.AVUserInfo;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.gaudio.QQGAudioCtrlCallback;
import com.tencent.av.utils.SoLoadUtil;
import com.tencent.qav.app.AppSetting;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.reporter.DeviceMonitor;
import java.util.ArrayList;

public class MultiOperatorBase
  implements QQGAudioCtrlCallback
{
  private static final String TAG = "MultiOperatorBase";
  protected Context mContext;
  protected QQGAudioCtrl mGAudioCtrl;
  protected long mSelfUin;
  protected VideoChannelInterface mVideoChannel;
  
  public MultiOperatorBase(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    this.mContext = paramContext;
    this.mSelfUin = paramLong;
    this.mVideoChannel = paramVideoChannelInterface;
    loadLibrary();
    initGAudioCtrl();
  }
  
  private void initGAudioCtrl()
  {
    AVLog.d("MultiOperatorBase", "initGAudioCtrl");
    try
    {
      if (this.mGAudioCtrl == null)
      {
        this.mGAudioCtrl = new QQGAudioCtrl(this.mContext);
        int i = DeviceMonitor.getInstance().getApnType(this.mContext);
        this.mGAudioCtrl.SetVideoController(this);
        this.mGAudioCtrl.setAppid(AppSetting.getAppId());
        this.mGAudioCtrl.setApType(i);
        this.mGAudioCtrl.init(this.mContext, this.mSelfUin, 1, "8.0.5");
      }
      return;
    }
    catch (Exception localException)
    {
      AVLog.e("MultiOperatorBase", "initGAudioCtrl  fail.", localException);
      this.mGAudioCtrl = null;
    }
  }
  
  private boolean loadLibrary()
  {
    AVLog.d("MultiOperatorBase", "loadLibrary");
    try
    {
      SoLoadUtil.loadNativeLibrary(this.mContext, "c++_shared");
      SoLoadUtil.loadNativeLibrary(this.mContext, "xplatform");
      SoLoadUtil.loadNativeLibrary(this.mContext, "stlport_shared");
      SoLoadUtil.loadNativeLibrary(this.mContext, "SDKCommon");
      SoLoadUtil.loadNativeLibrary(this.mContext, "VideoCtrl");
      SoLoadUtil.loadNativeLibrary(this.mContext, "qav_media_engine");
      SoLoadUtil.loadNativeLibrary(this.mContext, "qav_gaudio_engine");
      return true;
    }
    catch (Throwable localThrowable)
    {
      AVLog.e("MultiOperatorBase", "loadLibrary fail.", localThrowable);
    }
    return false;
  }
  
  private void unInitGAudioCtrl()
  {
    AVLog.d("MultiOperatorBase", "unInitGAudioCtrl");
    try
    {
      if (this.mGAudioCtrl != null)
      {
        this.mGAudioCtrl.uninit();
        this.mGAudioCtrl = null;
      }
      return;
    }
    catch (Exception localException)
    {
      AVLog.e("MultiOperatorBase", "unInitGAudioCtrl  fail.", localException);
    }
  }
  
  public void dealInviteMemberRsp(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList) {}
  
  public void destroy()
  {
    this.mContext = null;
    this.mSelfUin = 0L;
    this.mVideoChannel = null;
    unInitGAudioCtrl();
  }
  
  public QQGAudioCtrl getGAudioCtrl()
  {
    return this.mGAudioCtrl;
  }
  
  public long getGAudioRoomId(int paramInt1, int paramInt2, long paramLong)
  {
    return 0L;
  }
  
  public void onCreateRoomSuc(int paramInt1, long paramLong, int paramInt2) {}
  
  public void onDetectAudioDataIssue(int paramInt) {}
  
  public void onDoubleVideoMeetingInvite(long paramLong) {}
  
  public void onEnterSuc(long paramLong, int paramInt1, int paramInt2) {}
  
  public void onFpsChange(int paramInt) {}
  
  public void onGAudioInvite(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3) {}
  
  public void onGAudioInviteResp(ArrayList<AVInviteAccount> paramArrayList) {}
  
  public void onGAudioInviteRespFail(long paramLong1, long paramLong2, String paramString) {}
  
  public void onGAudioKickOut(long paramLong, int paramInt1, int paramInt2) {}
  
  public void onGAudioMemAllUpdate(long paramLong, ArrayList<AVUserInfo> paramArrayList, int paramInt1, int paramInt2) {}
  
  public void onGAudioMemAllUpdate(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2) {}
  
  public void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void onGAudioMicSetByAdmin(long paramLong, boolean paramBoolean) {}
  
  public void onGAudioRoomDistroy(int paramInt, long paramLong) {}
  
  public void onGAudioRoomMicModeChanged(long paramLong, boolean paramBoolean) {}
  
  public void onGAudioSDKError(int paramInt1, long paramLong, int paramInt2, int paramInt3) {}
  
  public void onGAudioSetMicFailed(int paramInt, ArrayList<AVUserInfo> paramArrayList) {}
  
  public void onGAudioTerminalEnterRoom(int paramInt, long paramLong, int... paramVarArgs) {}
  
  public void onGAudioUserAudioSuspectNoisy(long paramLong1, boolean paramBoolean, long paramLong2) {}
  
  public void onGVideoDownloadChannelCtlChanged(byte[] paramArrayOfByte) {}
  
  public void onGaGoOffStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void onGaGoOnStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void onGaSwitchVideoResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void onGroupChatModeChange(long paramLong, int paramInt1, int paramInt2) {}
  
  public void onGroupSecurityLimit(long paramLong1, long paramLong2, String paramString) {}
  
  public void onGroupVideoClosed(int paramInt1, long paramLong, int paramInt2, int paramInt3) {}
  
  public void onHowling() {}
  
  public void onKickOutFail(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onKickOutSuc(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs) {}
  
  public void onMemberPosChanged(long paramLong, ArrayList<AVUserInfo> paramArrayList) {}
  
  public void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3) {}
  
  public void onOpenMicFail() {}
  
  public void onPPTInOrOut(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
  
  public void onRemoteVideoDataComeIn(int paramInt1, long paramLong, int paramInt2) {}
  
  public void onSetMicBySelf(long paramLong) {}
  
  public void onVideoSrcChange(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void sendMultiVideoCMD(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.mVideoChannel != null) {
      this.mVideoChannel.sendMultiVideoMsg(paramLong1, paramLong2, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.multi.MultiOperatorBase
 * JD-Core Version:    0.7.0.1
 */