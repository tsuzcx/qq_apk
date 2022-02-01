package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.qphone.base.util.QLog;
import hth;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader;

public class VideoMessageProcessor
  extends BaseMessageProcessor
{
  public VideoMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    label71:
    long l1;
    long l2;
    do
    {
      do
      {
        for (;;)
        {
          return;
          C2CType0x211_SubC2CType0xb.MsgBody localMsgBody = new C2CType0x211_SubC2CType0xb.MsgBody();
          try
          {
            paramArrayOfByte = (C2CType0x211_SubC2CType0xb.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
            paramArrayOfByte = (C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader)paramArrayOfByte.msg_msg_header.get();
            if (paramArrayOfByte != null) {
              break label71;
            }
            if (QLog.isColorLevel())
            {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "<VideoMessageProcessor><---handle0x2110xbMsg : subMsgType[0xb] MsgHeader failed");
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<VideoMessageProcessor><---handle0x2110xbMsg : subMsgType[0xb] MsgBody failed", paramArrayOfByte);
      return;
      l1 = paramArrayOfByte.uint64_to_uin.get();
      l2 = paramArrayOfByte.uint64_room_id.get();
    } while (!QLog.isColorLevel());
    QLog.d("svenxu", 2, "Send video c2c broadcast: selfUin = " + l1 + " roomid = " + l2);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramArrayOfByte);
  }
  
  public hth a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new hth(null, true);
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null))
      {
        a(paramSvcReqPushMsg.lUin, paramMsgInfo.vMsg, paramMsgInfo.lFromUin, (int)paramMsgInfo.uMsgTime);
      }
      else
      {
        a(getClass().getName(), paramInt);
        continue;
        if ((paramMsgInfo == null) || (paramSvcReqPushMsg == null)) {
          a(getClass().getName(), paramInt);
        }
      }
    }
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((byte[])paramVarArgs[2], 11);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.VideoMessageProcessor
 * JD-Core Version:    0.7.0.1
 */