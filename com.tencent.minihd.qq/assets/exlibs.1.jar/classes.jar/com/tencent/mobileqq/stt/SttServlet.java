package com.tencent.mobileqq.stt;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.cs.cmd0x355.Stt.ReqBody;
import tencent.im.cs.cmd0x355.Stt.RspBody;
import tencent.im.cs.cmd0x355.Stt.TransC2CPttReq;
import tencent.im.cs.cmd0x355.Stt.TransC2CPttResp;
import tencent.im.cs.cmd0x355.Stt.TransGroupPttReq;
import tencent.im.cs.cmd0x355.Stt.TransGroupPttResp;

public class SttServlet
  extends MSFServlet
{
  private static final int a = 1;
  public static final String a = "k_session";
  private static final int b = 2;
  public static final String b = "k_time_out";
  private static final int jdField_c_of_type_Int = 3;
  private static final String jdField_c_of_type_JavaLangString = "k_cmd";
  private static final String d = "k_sneder";
  private static final String e = "k_receiver";
  private static final String f = "k_file";
  private static final String g = "k_md5";
  private static final String h = "k_retry";
  private static final String i = "k_sso_id";
  private static final String j = "k_sso_data";
  private static final String k = "k_size";
  private static final String l = "k_ptt_time";
  private static final String m = "pttTrans.TransC2CPttReq";
  private static final String n = "pttTrans.TransGroupPttReq";
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, Long paramLong)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), SttServlet.class);
    int i2 = paramMessageForPtt.timeLength;
    int i1 = i2;
    if (i2 == 0) {
      i1 = QQRecorder.a(paramMessageForPtt.url);
    }
    localNewIntent.putExtra("k_session", paramLong);
    localNewIntent.putExtra("k_sneder", Long.parseLong(paramMessageForPtt.senderuin));
    localNewIntent.putExtra("k_receiver", Long.parseLong(paramMessageForPtt.frienduin));
    localNewIntent.putExtra("k_size", paramMessageForPtt.fileSize);
    localNewIntent.putExtra("k_ptt_time", i1);
    if (paramMessageForPtt.istroop == 0)
    {
      localNewIntent.putExtra("k_file", paramMessageForPtt.urlAtServer);
      localNewIntent.putExtra("k_cmd", 1);
    }
    for (;;)
    {
      localNewIntent.putExtra("k_retry", 0);
      paramQQAppInterface.startServlet(localNewIntent);
      return;
      localNewIntent.putExtra("k_cmd", 2);
      localNewIntent.putExtra("k_file", paramMessageForPtt.groupFileID);
      localNewIntent.putExtra("k_md5", paramMessageForPtt.md5);
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i1 = paramIntent.getIntExtra("k_cmd", 0);
    Object localObject;
    long l1;
    label124:
    int i2;
    if (bool)
    {
      try
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new Stt.RspBody();
        ((Stt.RspBody)localObject).mergeFrom(paramFromServiceMsg);
        switch (i1)
        {
        case 1: 
          throw new RuntimeException("unknow cmd: " + i1);
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        l1 = 30000L;
        bool = false;
      }
      if (!bool)
      {
        i2 = paramIntent.getIntExtra("k_retry", 0) + 1;
        if (i2 < 3)
        {
          paramIntent.putExtra("k_retry", i2);
          getAppRuntime().startServlet((NewIntent)paramIntent);
          return;
          if (((Stt.RspBody)localObject).msg_c2c_ptt_resp.uint32_error_code.get() != 0) {
            break label297;
          }
        }
      }
    }
    label297:
    for (bool = true;; bool = false)
    {
      l1 = ((Stt.RspBody)localObject).msg_c2c_ptt_resp.uint32_waittime.get();
      break label124;
      if (((Stt.RspBody)localObject).msg_group_ptt_resp.uint32_error_code.get() == 0) {}
      for (bool = true;; bool = false)
      {
        i2 = ((Stt.RspBody)localObject).msg_group_ptt_resp.uint32_waittime.get();
        l1 = i2;
        break;
      }
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putLong("k_session", paramIntent.getLongExtra("k_session", 0L));
      paramFromServiceMsg.putLong("k_time_out", l1);
      notifyObserver(paramIntent, i1, bool, paramFromServiceMsg, SttManager.class);
      return;
      l1 = 30000L;
      break label124;
      break;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i1 = paramIntent.getIntExtra("k_retry", 0);
    byte[] arrayOfByte = null;
    Stt.ReqBody localReqBody;
    String str;
    Object localObject;
    if (i1 == 0)
    {
      i1 = paramIntent.getIntExtra("k_cmd", 0);
      localReqBody = new Stt.ReqBody();
      switch (i1)
      {
      default: 
        throw new RuntimeException("unknow cmd: " + i1);
      case 1: 
        str = "pttTrans.TransC2CPttReq";
        localObject = new Stt.TransC2CPttReq();
        ((Stt.TransC2CPttReq)localObject).uint64_sessionid.set(paramIntent.getLongExtra("k_session", 0L));
        ((Stt.TransC2CPttReq)localObject).uint64_sender_uin.set(paramIntent.getLongExtra("k_sneder", 0L));
        ((Stt.TransC2CPttReq)localObject).uint64_receiver_uin.set(paramIntent.getLongExtra("k_receiver", 0L));
        ((Stt.TransC2CPttReq)localObject).str_file_path.set(paramIntent.getStringExtra("k_file"));
        ((Stt.TransC2CPttReq)localObject).uint32_ptt_time.set(paramIntent.getIntExtra("k_ptt_time", 0));
        ((Stt.TransC2CPttReq)localObject).uint32_filesize.set((int)paramIntent.getLongExtra("k_size", 0L));
        localReqBody.uint32_sub_cmd.set(2);
        localReqBody.msg_c2c_ptt_req.set((MessageMicro)localObject);
        localObject = str;
        if (str != null)
        {
          paramIntent.putExtra("k_sso_id", str);
          arrayOfByte = localReqBody.toByteArray();
          localObject = ByteBuffer.allocate(arrayOfByte.length + 4);
          ((ByteBuffer)localObject).putInt(arrayOfByte.length + 4).put(arrayOfByte);
          arrayOfByte = ((ByteBuffer)localObject).array();
          paramIntent.putExtra("k_sso_data", arrayOfByte);
          localObject = str;
        }
        break;
      }
    }
    for (;;)
    {
      paramPacket.setSSOCommand((String)localObject);
      paramPacket.putSendData(arrayOfByte);
      return;
      str = "pttTrans.TransGroupPttReq";
      localObject = new Stt.TransGroupPttReq();
      ((Stt.TransGroupPttReq)localObject).uint64_sessionid.set(paramIntent.getLongExtra("k_session", 0L));
      ((Stt.TransGroupPttReq)localObject).uint64_sender_uin.set(paramIntent.getLongExtra("k_sneder", 0L));
      ((Stt.TransGroupPttReq)localObject).uint64_group_uin.set(paramIntent.getLongExtra("k_receiver", 0L));
      ((Stt.TransGroupPttReq)localObject).uint32_fileid.set((int)paramIntent.getLongExtra("k_file", 0L));
      ((Stt.TransGroupPttReq)localObject).str_filemd5.set(paramIntent.getStringExtra("k_md5"));
      ((Stt.TransGroupPttReq)localObject).uint32_ptt_time.set(paramIntent.getIntExtra("k_ptt_time", 0));
      ((Stt.TransGroupPttReq)localObject).uint32_filesize.set((int)paramIntent.getLongExtra("k_size", 0L));
      localReqBody.uint32_sub_cmd.set(1);
      localReqBody.msg_group_ptt_req.set((MessageMicro)localObject);
      break;
      localObject = paramIntent.getStringExtra("k_sso_id");
      arrayOfByte = paramIntent.getByteArrayExtra("k_sso_data");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttServlet
 * JD-Core Version:    0.7.0.1
 */