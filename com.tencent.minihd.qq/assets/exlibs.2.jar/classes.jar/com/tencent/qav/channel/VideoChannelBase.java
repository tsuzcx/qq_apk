package com.tencent.qav.channel;

import SharpSvrPack.MultiVideoMsg;
import SharpSvrPack.SharpVideoMsg;
import VideoSvrPack.VideoCallMsg;
import com.qq.jce.wup.UniPacket;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.utils.VideoPackageUtil;
import com.tencent.qav.utils.VideoPackageUtil.VideoPacket;
import java.util.ArrayList;

public abstract class VideoChannelBase
  implements VideoChannelInterface
{
  private static final String TAG = "VideoChannelBase";
  private VideoChannelCallback mCallback;
  private VideoChannelSupportCallback mSupportCallback;
  
  private boolean isMultiVideoMsgSupport(int paramInt)
  {
    boolean bool = true;
    if (this.mSupportCallback != null) {
      bool = this.mSupportCallback.isMultiVideoMsgSupport(paramInt);
    }
    return bool;
  }
  
  private boolean isSharpVideoMsgSupport(int paramInt)
  {
    boolean bool = true;
    if (this.mSupportCallback != null) {
      bool = this.mSupportCallback.isSharpVideoMsgSupport(paramInt);
    }
    return bool;
  }
  
  private void sendMultiVideoAck(MultiVideoMsg paramMultiVideoMsg)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("MultiVideo");
    localUniPacket.setFuncName("MultiVideos2cack");
    localUniPacket.put("MultiVideoMsg", paramMultiVideoMsg);
    sendMultiVideoAckInternal(localUniPacket.encode());
  }
  
  private void sendSharpVideoAck(SharpVideoMsg paramSharpVideoMsg)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("SharpSvr");
    localUniPacket.setFuncName("s2cack");
    localUniPacket.put("SharpVideoMsg", paramSharpVideoMsg);
    sendSharpVideoAckInternal(localUniPacket.encode());
  }
  
  protected abstract long getSelfUin();
  
  public void receiveGatewayMsg(String paramString, int paramInt)
  {
    if (this.mCallback != null) {
      this.mCallback.receiveGatewayMsg(paramString, paramInt);
    }
  }
  
  public void receiveMultiVideoAck(byte[] paramArrayOfByte)
  {
    if (this.mCallback != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (MultiVideoMsg)localUniPacket.getByClass("MultiVideoMsg", new MultiVideoMsg());
      AVLog.d("VideoChannelBase", String.format("receiveMultiVideoAck type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramArrayOfByte.type), Short.valueOf(paramArrayOfByte.csCmd) }));
      if (isMultiVideoMsgSupport(paramArrayOfByte.type)) {
        this.mCallback.receiveMultiVideoAck(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void receiveMultiVideoMsg(byte[] paramArrayOfByte)
  {
    if (this.mCallback != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (MultiVideoMsg)localUniPacket.getByClass("MultiVideoMsg", new MultiVideoMsg());
      AVLog.d("VideoChannelBase", String.format("receiveMultiVideoMsg type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramArrayOfByte.type), Short.valueOf(paramArrayOfByte.csCmd) }));
      if (isMultiVideoMsgSupport(paramArrayOfByte.type))
      {
        sendMultiVideoAck(paramArrayOfByte);
        this.mCallback.receiveMultiVideoMsg(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void receiveSharpVideoAck(byte[] paramArrayOfByte)
  {
    if (this.mCallback != null)
    {
      Object localObject = new UniPacket(true);
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramArrayOfByte);
      paramArrayOfByte = (SharpVideoMsg)((UniPacket)localObject).getByClass("SharpVideoMsg", new SharpVideoMsg());
      if (isSharpVideoMsgSupport(paramArrayOfByte.type))
      {
        localObject = VideoPackageUtil.parse(paramArrayOfByte.video_buff);
        if (localObject != null) {
          AVLog.d("VideoChannelBase", String.format("receiveSharpVideoAck uin=%s bodyType=%s roomId=%s", new Object[] { Long.valueOf(((VideoPackageUtil.VideoPacket)localObject).uin), Integer.valueOf(((VideoPackageUtil.VideoPacket)localObject).bodyType), Long.valueOf(((VideoPackageUtil.VideoPacket)localObject).roomId) }));
        }
        this.mCallback.receiveSharpVideoAck(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void receiveSharpVideoMsg(byte[] paramArrayOfByte)
  {
    if (this.mCallback != null)
    {
      Object localObject = new UniPacket(true);
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramArrayOfByte);
      paramArrayOfByte = (SharpVideoMsg)((UniPacket)localObject).getByClass("SharpVideoMsg", new SharpVideoMsg());
      if (isSharpVideoMsgSupport(paramArrayOfByte.type))
      {
        localObject = VideoPackageUtil.parse(paramArrayOfByte.video_buff);
        if (localObject != null) {
          AVLog.d("VideoChannelBase", String.format("receiveSharpVideoMsg uin=%s bodyType=%s roomId=%s", new Object[] { Long.valueOf(((VideoPackageUtil.VideoPacket)localObject).uin), Integer.valueOf(((VideoPackageUtil.VideoPacket)localObject).bodyType), Long.valueOf(((VideoPackageUtil.VideoPacket)localObject).roomId) }));
        }
        sendSharpVideoAck(paramArrayOfByte);
        this.mCallback.receiveSharpVideoMsg(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void receiveVideoConfig(byte[] paramArrayOfByte)
  {
    if (this.mCallback != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (VideoCallMsg)localUniPacket.getByClass("VideoCallMsg", new VideoCallMsg());
      this.mCallback.receiveVideoConfig(paramArrayOfByte.vMsg);
    }
  }
  
  public void sendGetGatewayMsg()
  {
    sendGetGatewayMsgInternal();
  }
  
  protected abstract void sendGetGatewayMsgInternal();
  
  public void sendGetVideoConfig(byte[] paramArrayOfByte)
  {
    long l = getSelfUin();
    VideoCallMsg localVideoCallMsg = new VideoCallMsg();
    localVideoCallMsg.ver = 1;
    localVideoCallMsg.type = 1;
    localVideoCallMsg.lUin = l;
    localVideoCallMsg.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
    localVideoCallMsg.vMsg = paramArrayOfByte;
    paramArrayOfByte = new UniPacket();
    paramArrayOfByte.setServantName("VideoSvc");
    paramArrayOfByte.setFuncName("SendVideoMsg");
    paramArrayOfByte.put("VideoCallMsg", localVideoCallMsg);
    sendGetVideoConfigInternal(paramArrayOfByte.encode());
  }
  
  protected abstract void sendGetVideoConfigInternal(byte[] paramArrayOfByte);
  
  public void sendLogReportMsg(long paramLong, byte[] paramArrayOfByte)
  {
    sendLogReportMsgInternal(paramLong, paramArrayOfByte);
  }
  
  protected abstract void sendLogReportMsgInternal(long paramLong, byte[] paramArrayOfByte);
  
  protected abstract void sendMultiVideoAckInternal(byte[] paramArrayOfByte);
  
  public void sendMultiVideoMsg(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    long l = getSelfUin();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong1));
    MultiVideoMsg localMultiVideoMsg = new MultiVideoMsg();
    localMultiVideoMsg.ver = 0;
    localMultiVideoMsg.type = 1;
    localMultiVideoMsg.csCmd = ((short)(int)paramLong2);
    localMultiVideoMsg.from_uin = l;
    localMultiVideoMsg.to_uin = localArrayList;
    localMultiVideoMsg.video_buff = paramArrayOfByte;
    paramArrayOfByte = new UniPacket();
    paramArrayOfByte.setServantName("MultiVideo");
    paramArrayOfByte.setFuncName("MultiVideoMsg");
    paramArrayOfByte.put("MultiVideoMsg", localMultiVideoMsg);
    sendMultiVideoMsgInternal(paramArrayOfByte.encode());
  }
  
  protected abstract void sendMultiVideoMsgInternal(byte[] paramArrayOfByte);
  
  protected abstract void sendSharpVideoAckInternal(byte[] paramArrayOfByte);
  
  public void sendSharpVideoMsg(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject = VideoPackageUtil.parse(paramArrayOfByte);
    if (localObject != null) {
      AVLog.d("VideoChannelBase", String.format("sendSharpVideoMsg uin=%s bodyType=%s roomId=%s", new Object[] { Long.valueOf(((VideoPackageUtil.VideoPacket)localObject).uin), Integer.valueOf(((VideoPackageUtil.VideoPacket)localObject).bodyType), Long.valueOf(((VideoPackageUtil.VideoPacket)localObject).roomId) }));
    }
    long l = getSelfUin();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    localObject = new SharpVideoMsg();
    ((SharpVideoMsg)localObject).ver = 1;
    ((SharpVideoMsg)localObject).type = 1;
    ((SharpVideoMsg)localObject).from_uin = l;
    ((SharpVideoMsg)localObject).to_uin = localArrayList;
    ((SharpVideoMsg)localObject).video_buff = paramArrayOfByte;
    paramArrayOfByte = new UniPacket();
    paramArrayOfByte.setServantName("SharpSvr");
    paramArrayOfByte.setFuncName("c2s");
    paramArrayOfByte.put("SharpVideoMsg", localObject);
    sendSharpVideoMsgInternal(paramArrayOfByte.encode());
  }
  
  protected abstract void sendSharpVideoMsgInternal(byte[] paramArrayOfByte);
  
  public void setVideoChannelCallback(VideoChannelCallback paramVideoChannelCallback)
  {
    this.mCallback = paramVideoChannelCallback;
  }
  
  public void setVideoChannelSupportCallback(VideoChannelSupportCallback paramVideoChannelSupportCallback)
  {
    this.mSupportCallback = paramVideoChannelSupportCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.qav.channel.VideoChannelBase
 * JD-Core Version:    0.7.0.1
 */