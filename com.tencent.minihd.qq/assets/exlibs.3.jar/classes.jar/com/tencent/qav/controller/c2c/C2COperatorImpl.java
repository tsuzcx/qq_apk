package com.tencent.qav.controller.c2c;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.ui.GLVideoView;
import com.tencent.qav.QavDef.VideoFrame;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.QavCtrl;
import com.tencent.qav.controller.nodereport.NodeReportOperator;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.observer.ObserverDispatcher;
import com.tencent.qav.reporter.DebugInfoObserver;
import com.tencent.qav.session.SessionInfo;
import com.tencent.qav.session.SessionMgr;

public class C2COperatorImpl
  extends C2COperatorBase
  implements IC2COperator
{
  private static final String TAG = "C2COperatorImpl";
  private AudioManager mAudioManager = (AudioManager)this.mContext.getSystemService("audio");
  private int mAudioRoute;
  private CameraUtils mCameraUtils = CameraUtils.getInstance(this.mContext);
  private boolean mCustomVideoCaptureEnable;
  private GraphicRenderMgr mGraphicRenderMgr = GraphicRenderMgr.getInstance();
  private boolean mLocalAudioEnable;
  private NodeReportOperator mNodeReportOperator;
  private boolean mRemoteAudioEnable;
  private SessionMgr mSessionMgr = SessionMgr.getInstanse();
  
  public C2COperatorImpl(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    super(paramContext, paramLong, paramVideoChannelInterface);
  }
  
  private int enableLocalVideoSend(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mVcCtrl.startVideoSend();
    }
    return this.mVcCtrl.stopVideoSend();
  }
  
  private void setEncodeDecodePtr(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    int i = 0;
    if (this.mVcCtrl != null)
    {
      if (!paramBoolean2) {
        break label40;
      }
      if (!paramBoolean1) {
        break label29;
      }
    }
    for (;;)
    {
      this.mVcCtrl.setProcessDecoderFrameFunctionptr(i);
      return;
      label29:
      i = this.mGraphicRenderMgr.getRecvDecoderFrameFunctionptr();
    }
    label40:
    if (paramBoolean1) {}
    for (i = j;; i = this.mVcCtrl.getEncodeFrameFunctionPtrFunPtr())
    {
      this.mGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(i);
      return;
    }
  }
  
  private int setLocalAudioEnable(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mVcCtrl.startAudioSend();
    }
    return this.mVcCtrl.stopAudioSend();
  }
  
  private int setRemoteAudioEnable(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mVcCtrl.startAudioRecv();
    }
    return this.mVcCtrl.stopAudioRecv();
  }
  
  public void acceptCall(String paramString, boolean paramBoolean)
  {
    int i = 2;
    if (paramBoolean) {
      i = 0;
    }
    SessionInfo localSessionInfo = this.mSessionMgr.createSession(paramString + "_id", true);
    localSessionInfo.mPeerUin = paramString;
    localSessionInfo.mSessionType = 2;
    AVLog.d("C2COperatorImpl", String.format("acceptCall peerUin=%s appType=%s relationType=%s result=%s", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(this.mVcCtrl.acceptVideo(paramString, 0L, 0, i, 1)) }));
  }
  
  public void closeCall(String paramString, int paramInt)
  {
    this.mSessionMgr.clearSession();
    AVLog.d("C2COperatorImpl", String.format("closeCall peerUin=%s closeReason=%s result=%s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(this.mVcCtrl.closeVideo(paramString, paramInt)) }));
  }
  
  public void destroy()
  {
    super.destroy();
    this.mNodeReportOperator = null;
  }
  
  public void enableCustomVideoCapture(boolean paramBoolean)
  {
    this.mCustomVideoCaptureEnable = paramBoolean;
  }
  
  public void enableLocalAudio(boolean paramBoolean)
  {
    setLocalAudioEnable(paramBoolean);
    this.mLocalAudioEnable = paramBoolean;
  }
  
  public void enableLocalVideo(boolean paramBoolean)
  {
    enableLocalVideoSend(paramBoolean);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setEncodeDecodePtr(paramBoolean, false);
      return;
    }
  }
  
  public void enableRemoteAudio(boolean paramBoolean)
  {
    setRemoteAudioEnable(paramBoolean);
    this.mRemoteAudioEnable = paramBoolean;
  }
  
  public int getAudioRoute()
  {
    return this.mAudioRoute;
  }
  
  public int getFrameRenderEndFunctionPtr()
  {
    if (this.mVcCtrl != null) {
      return this.mVcCtrl.getOnPeerFrameRenderEndFunctionPtr();
    }
    return 0;
  }
  
  public long getMsfInviteTimeStamp(long paramLong)
  {
    if (this.mNodeReportOperator != null) {
      return this.mNodeReportOperator.getMsfInviteTimestamp(paramLong);
    }
    return 0L;
  }
  
  public boolean isLocalAudioEnable()
  {
    return this.mLocalAudioEnable;
  }
  
  public boolean isRemoteAudioEnable()
  {
    return this.mRemoteAudioEnable;
  }
  
  public void onAcceptedVideo(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onAcceptedVideo fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 2, new Object[] { paramString });
  }
  
  public void onAnotherHaveAccept(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onAnotherHaveAccept fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 13, new Object[] { paramString });
  }
  
  public void onAnotherHaveReject(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onAnotherHaveReject fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 14, new Object[] { paramString });
  }
  
  public void onCancelRequest(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onCancelRequest fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 12, new Object[] { paramString });
  }
  
  public void onChannelReady(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onChannelReady fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 21, new Object[] { paramString });
  }
  
  public void onCloseVideo(String paramString, int paramInt, long paramLong)
  {
    AVLog.d("C2COperatorImpl", String.format("onCloseVideo fromUin=%s reason=%s extraParam=%s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 27, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
  
  public void onInviteReached(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    AVLog.d("C2COperatorImpl", String.format("onInviteReached peerUin=%s friendState=%s extraParam=%s detail=%s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), paramArrayOfByte }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 1, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), paramArrayOfByte });
  }
  
  public void onNetLevel_S2C(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    int i = (int)(0x3 & paramLong);
    int j = (int)(paramLong >> 4 & 0x7);
    int k = (int)(paramLong >> 7 & 0x7);
    paramString = null;
    if (paramArrayOfByte != null) {
      paramString = new String(paramArrayOfByte);
    }
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 28, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramString });
  }
  
  public void onNetworkMonitorInfo(String paramString, byte[] paramArrayOfByte1, long paramLong, byte[] paramArrayOfByte2)
  {
    ObserverDispatcher.instance().notifyObservers(DebugInfoObserver.class, 1, new Object[] { paramString, paramArrayOfByte1, Long.valueOf(paramLong), paramArrayOfByte2 });
  }
  
  public void onPauseAudio(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onPauseAudio fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 26, new Object[] { paramString });
  }
  
  public void onPauseVideo(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onPauseVideo fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 24, new Object[] { paramString });
  }
  
  public void onReceiveFirstVideoFrame(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onReceiveFirstVideoFrame fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 23, new Object[] { paramString });
  }
  
  public void onRejectVideo(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onRejectVideo fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 3, new Object[] { paramString });
  }
  
  public void onRequestVideo(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    AVLog.d("C2COperatorImpl", String.format("onRequestVideo uinType=%s fromUin=%s extraUin=%s sig=%s onlyAudio=%s, bindID=%s, bindType=%s, subServiceType=%s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramArrayOfByte, Boolean.valueOf(paramBoolean), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    QavCtrl.updateGateway(this.mVideoChannel);
    QavCtrl.updateVideoConfig(this.mVideoChannel, this.mContext, this.mSelfUin);
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 11, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramArrayOfByte, Boolean.valueOf(paramBoolean), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void onResumeAudio(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onResumeAudio fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 25, new Object[] { paramString });
  }
  
  public void onResumeVideo(String paramString)
  {
    AVLog.d("C2COperatorImpl", String.format("onResumeVideo fromUin=%s", new Object[] { paramString }));
    ObserverDispatcher.instance().notifyObservers(QavC2CObserver.class, 22, new Object[] { paramString });
  }
  
  public void rejectCall(String paramString, int paramInt)
  {
    AVLog.d("C2COperatorImpl", String.format("rejectCall peerUin=%s rejectReason=%s result=%s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(this.mVcCtrl.rejectVideo(paramString, 0, paramInt)) }));
  }
  
  public void sendCustomVideoData(QavDef.VideoFrame paramVideoFrame)
  {
    if (this.mCustomVideoCaptureEnable) {
      GraphicRenderMgr.getInstance().sendCameraFrame(paramVideoFrame.data, paramVideoFrame.pixelFormat, paramVideoFrame.width, paramVideoFrame.height, paramVideoFrame.angle, paramVideoFrame.rotation, paramVideoFrame.timestamp, paramVideoFrame.frontCamera, null, null, 0, 0);
    }
  }
  
  public void setAudioRoute(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mAudioManager.setSpeakerphoneOn(true);
      this.mAudioManager.setMode(0);
      this.mAudioRoute = paramInt;
    }
    while (paramInt != 0) {
      return;
    }
    this.mAudioManager.setSpeakerphoneOn(false);
    if (Build.VERSION.SDK_INT >= 21) {
      this.mAudioManager.setMode(3);
    }
    for (;;)
    {
      this.mAudioRoute = paramInt;
      return;
      this.mAudioManager.setMode(2);
    }
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if (paramInt == 0) {
      this.mGraphicRenderMgr.setBeautyFlag(0);
    }
    for (;;)
    {
      this.mGraphicRenderMgr.setBeautyOrFaceConfig(paramInt, 0);
      return;
      this.mGraphicRenderMgr.setBeautyFlag(1);
    }
  }
  
  public void setNodeReportOperator(NodeReportOperator paramNodeReportOperator)
  {
    this.mNodeReportOperator = paramNodeReportOperator;
  }
  
  public void startCall(String paramString, boolean paramBoolean)
  {
    SessionInfo localSessionInfo = this.mSessionMgr.createSession(paramString + "_id", true);
    localSessionInfo.mPeerUin = paramString;
    localSessionInfo.mSessionType = 2;
    QavCtrl.updateGateway(this.mVideoChannel);
    QavCtrl.updateVideoConfig(this.mVideoChannel, this.mContext, this.mSelfUin);
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      AVLog.d("C2COperatorImpl", String.format("startCall peerUin=%s isOnlyAudio=%s result=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(this.mVcCtrl.requestVideo(paramString, 0L, 0, i, 1, null, null, null, 0, "", "", 0L, null, "", "", "", 0, 0, "")) }));
      return;
    }
  }
  
  public void startLocalPreview(boolean paramBoolean, GLVideoView paramGLVideoView)
  {
    if (paramGLVideoView != null)
    {
      String str = QavCtrl.getUserKey(String.valueOf(this.mSelfUin), 1);
      this.mGraphicRenderMgr.setAccountUin(String.valueOf(this.mSelfUin));
      this.mGraphicRenderMgr.setGlRender(str, paramGLVideoView.getYuvTexture());
    }
    if (!this.mCustomVideoCaptureEnable) {
      this.mCameraUtils.openCamera(0L);
    }
  }
  
  public void startRemotePreview(String paramString, GLVideoView paramGLVideoView)
  {
    if (paramGLVideoView != null)
    {
      this.mGraphicRenderMgr.setAccountUin(String.valueOf(this.mSelfUin));
      this.mGraphicRenderMgr.setGlRender(paramString, paramGLVideoView.getYuvTexture());
      setEncodeDecodePtr(false, true);
    }
  }
  
  public void stopLocalPreview()
  {
    String str = QavCtrl.getUserKey(String.valueOf(this.mSelfUin), 1);
    this.mGraphicRenderMgr.clearCameraFrames();
    this.mGraphicRenderMgr.flushGlRender(str);
    this.mGraphicRenderMgr.setGlRender(str, null);
    if (!this.mCustomVideoCaptureEnable) {
      this.mCameraUtils.closeCamera(0L, false);
    }
  }
  
  public void stopRemotePreview(String paramString)
  {
    this.mGraphicRenderMgr.flushGlRender(paramString);
    this.mGraphicRenderMgr.setGlRender(paramString, null);
    setEncodeDecodePtr(true, true);
  }
  
  public void switchCamera()
  {
    if (!this.mCustomVideoCaptureEnable) {
      this.mCameraUtils.switchCamera(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.c2c.C2COperatorImpl
 * JD-Core Version:    0.7.0.1
 */