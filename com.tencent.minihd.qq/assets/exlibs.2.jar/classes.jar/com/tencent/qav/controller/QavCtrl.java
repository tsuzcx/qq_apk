package com.tencent.qav.controller;

import android.content.Context;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.qav.app.AppSetting;
import com.tencent.qav.channel.VideoChannelCallback;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.c2c.C2COperatorImpl;
import com.tencent.qav.controller.c2c.IC2COperator;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.controller.multi.MultiOperatorImpl;
import com.tencent.qav.controller.nodereport.NodeReportOperator;

public class QavCtrl
  implements VideoChannelCallback
{
  private static final int EM_PROTO_CHANNEL_GA_ACK = 2;
  private static final int EM_PROTO_CHANNEL_GA_MSG = 1;
  private static final int EM_PROTO_CHANNEL_GA_OFFLINE = 3;
  private static final String TAG = "QavCtrl";
  private C2COperatorImpl mC2COperator;
  private Context mContext;
  private QQGAudioCtrl mGAudioCtrl;
  private MultiOperatorImpl mMultiOperator;
  private NodeReportOperator mNodeReportOperator;
  private long mSelfUin;
  private VcControllerImpl mVcCtrl;
  private VideoChannelInterface mVideoChannel;
  
  public QavCtrl(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    this.mContext = paramContext;
    this.mSelfUin = paramLong;
    this.mVideoChannel = paramVideoChannelInterface;
    this.mVideoChannel.setVideoChannelCallback(this);
    this.mC2COperator = new C2COperatorImpl(this.mContext, this.mSelfUin, this.mVideoChannel);
    this.mVcCtrl = this.mC2COperator.getVcCtrl();
    this.mMultiOperator = new MultiOperatorImpl(this.mContext, this.mSelfUin, this.mVideoChannel);
    this.mGAudioCtrl = this.mMultiOperator.getGAudioCtrl();
    this.mNodeReportOperator = new NodeReportOperator(this.mContext, this.mSelfUin, this.mVcCtrl);
    this.mC2COperator.setNodeReportOperator(this.mNodeReportOperator);
    ClientLogReport.instance();
    ClientLogReport.instance().setVideoChannel(paramVideoChannelInterface);
    GAClientLogReport.instance();
  }
  
  public static String getUserKey(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  public static void updateGateway(VideoChannelInterface paramVideoChannelInterface)
  {
    if (paramVideoChannelInterface != null) {
      paramVideoChannelInterface.sendGetGatewayMsg();
    }
  }
  
  public static void updateVideoConfig(VideoChannelInterface paramVideoChannelInterface, Context paramContext, long paramLong)
  {
    if (paramVideoChannelInterface != null) {
      paramVideoChannelInterface.sendGetVideoConfig(ConfigSystemImpl.getConfigRequestPackage(paramContext, String.valueOf(AppSetting.getAppId()), paramLong));
    }
  }
  
  public void destroy()
  {
    if (this.mMultiOperator != null)
    {
      this.mMultiOperator.destroy();
      this.mMultiOperator = null;
    }
    this.mGAudioCtrl = null;
    if (this.mC2COperator != null)
    {
      this.mC2COperator.destroy();
      this.mC2COperator = null;
    }
    this.mVcCtrl = null;
    if (this.mNodeReportOperator != null)
    {
      this.mNodeReportOperator.destroy();
      this.mNodeReportOperator = null;
    }
    this.mContext = null;
    this.mSelfUin = 0L;
    this.mVideoChannel = null;
  }
  
  public IC2COperator getC2COperator()
  {
    return this.mC2COperator;
  }
  
  public IMultiOperator getMultiOperator()
  {
    return this.mMultiOperator;
  }
  
  public NodeReportOperator getNodeReportOperator()
  {
    return this.mNodeReportOperator;
  }
  
  public void receiveGatewayMsg(String paramString, int paramInt)
  {
    if (this.mVcCtrl != null) {
      this.mVcCtrl.SetNetIPAndPort(paramString, paramInt);
    }
    if (this.mGAudioCtrl != null) {
      this.mGAudioCtrl.setNetIPAndPort(paramString, paramInt);
    }
  }
  
  public void receiveMultiVideoAck(byte[] paramArrayOfByte)
  {
    if (this.mGAudioCtrl != null) {
      this.mGAudioCtrl.onRecvGAudioCMD(2, paramArrayOfByte);
    }
  }
  
  public void receiveMultiVideoMsg(byte[] paramArrayOfByte)
  {
    if (this.mGAudioCtrl != null) {
      this.mGAudioCtrl.onRecvGAudioCMD(1, paramArrayOfByte);
    }
  }
  
  public void receiveMultiVideoOfflineMsg(byte[] paramArrayOfByte)
  {
    if (this.mGAudioCtrl != null) {
      this.mGAudioCtrl.onRecvGAudioCMD(3, paramArrayOfByte);
    }
  }
  
  public void receiveSharpVideoAck(byte[] paramArrayOfByte)
  {
    if (this.mVcCtrl != null) {
      this.mVcCtrl.onRecvVideoCallBytesForSharpC2SACK(paramArrayOfByte);
    }
  }
  
  public void receiveSharpVideoMsg(byte[] paramArrayOfByte)
  {
    if (this.mVcCtrl != null) {
      this.mVcCtrl.onRecvVideoCallBytesForSharp(paramArrayOfByte);
    }
  }
  
  public void receiveSharpVideoOfflineMsg(byte[] paramArrayOfByte)
  {
    if (this.mVcCtrl != null) {
      this.mVcCtrl.onRecvVideoCallBytesForSharp(paramArrayOfByte);
    }
  }
  
  public void receiveVideoConfig(byte[] paramArrayOfByte)
  {
    int i = AppSetting.getAppId();
    ConfigSystemImpl.receiveConfigResponsePackage(this.mContext, String.valueOf(i), paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.QavCtrl
 * JD-Core Version:    0.7.0.1
 */