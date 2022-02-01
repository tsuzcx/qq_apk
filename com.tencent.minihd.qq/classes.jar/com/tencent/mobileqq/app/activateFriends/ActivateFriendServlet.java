package com.tencent.mobileqq.app.activateFriends;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.reminder.im_reminder.PkgHead;
import tencent.im.reminder.im_reminder.Reminder;
import tencent.im.reminder.im_reminder.Reminder.User;
import tencent.im.reminder.im_reminder.ReminderPackage;
import tencent.im.reminder.im_reminder.Request;
import tencent.im.reminder.im_reminder.Request.Add;
import tencent.im.reminder.im_reminder.Response;

public class ActivateFriendServlet
  extends MSFServlet
{
  public static final int a = 113;
  public static final String a = "ReminderSvc.Reminder";
  private static final boolean a = true;
  public static final int b = 114;
  public static final String b = "p_uin_list";
  public static final String c = "p_time_list";
  public static final String d = "p_msg";
  public static final String e = "OidbSvc.0x7c9_2";
  private static final String f = "ActivateFriends.Servlet";
  private static final String g = "param_req_type";
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long[] arrayOfLong = paramIntent.getExtras().getLongArray("p_uin_list");
    ArrayList localArrayList = new ArrayList();
    ActivateFriendsManager localActivateFriendsManager = (ActivateFriendsManager)getAppRuntime().getManager(80);
    Bundle localBundle = new Bundle();
    im_reminder.ReminderPackage localReminderPackage;
    if (paramFromServiceMsg.isSuccess()) {
      localReminderPackage = new im_reminder.ReminderPackage();
    }
    for (;;)
    {
      int i;
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get(arrayOfByte);
        localReminderPackage.mergeFrom(arrayOfByte);
        if (localReminderPackage.head.result.get() != 0) {
          break label389;
        }
        i = 0;
        if (i < localReminderPackage.response.get().size())
        {
          paramFromServiceMsg = (im_reminder.Response)localReminderPackage.response.get().get(i);
          if (paramFromServiceMsg.result.get() != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.Servlet", 2, "respSendTiming | " + localActivateFriendsManager.a(String.valueOf(arrayOfLong[i])) + " ret = " + paramFromServiceMsg.result.get());
            }
          }
          else {
            localArrayList.add(Long.valueOf(((im_reminder.Reminder)paramFromServiceMsg.reminder.get().get(0)).to_user.uin.get()));
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.Servlet", 2, "respSendTimingMsg erro ", paramFromServiceMsg);
        }
      }
      if (localArrayList.size() == arrayOfLong.length) {
        i = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.Servlet", 2, "respSendMsg | send count = " + arrayOfLong.length + " | suc count = " + localArrayList.size());
        }
        if (i == 2) {
          break label497;
        }
        paramFromServiceMsg = new long[localArrayList.size()];
        int j = 0;
        while (j < localArrayList.size())
        {
          paramFromServiceMsg[j] = ((Long)localArrayList.get(j)).longValue();
          j += 1;
        }
        label389:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ActivateFriends.Servlet", 2, "respSendMsg | package.result = " + localReminderPackage.head.result.get());
        break;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ActivateFriends.Servlet", 2, "respSendMsg | response.result = " + paramFromServiceMsg.getResultCode());
        break;
        if (localArrayList.size() > 0) {
          i = 1;
        } else {
          i = 2;
        }
      }
      localActivateFriendsManager.a(paramFromServiceMsg, 2);
      label497:
      localBundle.putInt("key_rt_type", i);
      notifyObserver(paramIntent, 113, true, localBundle, ActivateFriendsObserver.class);
      return;
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ActivateFriendServlet.class);
    localNewIntent.putExtra("param_req_type", 114);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1.length == 0) || (paramArrayOfLong1.length != paramArrayOfLong2.length)) {
      return false;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ActivateFriendServlet.class);
    localNewIntent.putExtra("param_req_type", 113);
    localNewIntent.putExtra("p_msg", paramString);
    localNewIntent.putExtra("p_uin_list", paramArrayOfLong1);
    localNewIntent.putExtra("p_time_list", paramArrayOfLong2);
    paramQQAppInterface.startServlet(localNewIntent);
    return true;
  }
  
  /* Error */
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_2
    //   7: invokevirtual 214	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   10: sipush 1000
    //   13: if_icmpne +294 -> 307
    //   16: new 260	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   19: dup
    //   20: invokespecial 261	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 80	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   28: invokestatic 86	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 90	java/nio/ByteBuffer:getInt	()I
    //   36: iconst_4
    //   37: isub
    //   38: newarray byte
    //   40: astore 7
    //   42: aload_2
    //   43: aload 7
    //   45: invokevirtual 93	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   48: pop
    //   49: aload_1
    //   50: aload 7
    //   52: invokevirtual 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   55: pop
    //   56: aload_1
    //   57: astore 7
    //   59: iload 5
    //   61: istore_3
    //   62: aload 7
    //   64: ifnull +156 -> 220
    //   67: aload 7
    //   69: getfield 265	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   75: istore 6
    //   77: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +30 -> 110
    //   83: ldc 28
    //   85: iconst_2
    //   86: new 138	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 267
    //   96: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload 6
    //   101: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: iload 5
    //   112: istore_3
    //   113: iload 6
    //   115: ifne +105 -> 220
    //   118: iload 5
    //   120: istore_3
    //   121: aload 7
    //   123: getfield 271	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   126: invokevirtual 276	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   129: ifeq +91 -> 220
    //   132: iload 5
    //   134: istore_3
    //   135: aload 7
    //   137: getfield 271	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   140: invokevirtual 279	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   143: ifnull +77 -> 220
    //   146: aload 7
    //   148: getfield 271	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   151: invokevirtual 279	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   154: invokevirtual 284	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   157: astore_1
    //   158: new 286	tencent/im/oidb/cmd0x7c9/cmd0x7c9$RspBody
    //   161: dup
    //   162: invokespecial 287	tencent/im/oidb/cmd0x7c9/cmd0x7c9$RspBody:<init>	()V
    //   165: astore_2
    //   166: aload_2
    //   167: aload_1
    //   168: invokevirtual 288	tencent/im/oidb/cmd0x7c9/cmd0x7c9$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   171: pop
    //   172: iload 5
    //   174: istore_3
    //   175: aload_2
    //   176: getfield 291	tencent/im/oidb/cmd0x7c9/cmd0x7c9$RspBody:uint32_next_time_gap	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 292	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   182: ifeq +38 -> 220
    //   185: aload_2
    //   186: getfield 291	tencent/im/oidb/cmd0x7c9/cmd0x7c9$RspBody:uint32_next_time_gap	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   192: istore_3
    //   193: aload_0
    //   194: invokevirtual 58	com/tencent/mobileqq/app/activateFriends/ActivateFriendServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   197: bipush 80
    //   199: invokevirtual 64	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   202: checkcast 66	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager
    //   205: astore_1
    //   206: aload_1
    //   207: ifnull +13 -> 220
    //   210: aload_1
    //   211: iload_3
    //   212: sipush 1000
    //   215: imul
    //   216: i2l
    //   217: invokevirtual 295	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(J)V
    //   220: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +29 -> 252
    //   226: ldc 28
    //   228: iconst_2
    //   229: new 138	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 297
    //   239: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: iload_3
    //   243: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: return
    //   253: astore_2
    //   254: aconst_null
    //   255: astore_1
    //   256: aload_1
    //   257: astore 7
    //   259: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq -203 -> 59
    //   265: ldc 28
    //   267: iconst_2
    //   268: ldc_w 299
    //   271: aload_2
    //   272: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: aload_1
    //   276: astore 7
    //   278: goto -219 -> 59
    //   281: astore_1
    //   282: iload 4
    //   284: istore_3
    //   285: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq -68 -> 220
    //   291: ldc 28
    //   293: iconst_2
    //   294: ldc_w 299
    //   297: aload_1
    //   298: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: iload 4
    //   303: istore_3
    //   304: goto -84 -> 220
    //   307: iload 5
    //   309: istore_3
    //   310: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq -93 -> 220
    //   316: ldc 28
    //   318: iconst_2
    //   319: new 138	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 301
    //   329: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_2
    //   333: invokevirtual 214	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   336: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: iload 5
    //   347: istore_3
    //   348: goto -128 -> 220
    //   351: astore_1
    //   352: iload_3
    //   353: istore 4
    //   355: goto -73 -> 282
    //   358: astore_2
    //   359: goto -103 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	ActivateFriendServlet
    //   0	362	1	paramIntent	Intent
    //   0	362	2	paramFromServiceMsg	FromServiceMsg
    //   61	292	3	i	int
    //   1	353	4	j	int
    //   4	342	5	k	int
    //   75	39	6	m	int
    //   40	237	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	24	253	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   158	172	281	java/lang/Exception
    //   175	193	281	java/lang/Exception
    //   193	206	351	java/lang/Exception
    //   210	220	351	java/lang/Exception
    //   24	56	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Servlet", 2, "req send get birthday message");
    }
    paramIntent = new cmd0x7c9.ReqBody();
    paramIntent.uint32_req_type.set(1);
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1993);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramPacket.setSSOCommand("OidbSvc.0x7c9_2");
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {}
    label97:
    do
    {
      return;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
        if (!bool) {
          break label97;
        }
      }
      for (String str1 = "";; str1 = "not")
      {
        QLog.d("ActivateFriends.Servlet", 2, str1 + " success");
        if (!str2.equals("OidbSvc.0x7c9_2")) {
          break;
        }
        b(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str2.equals("ReminderSvc.Reminder"));
    a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {
      return;
    }
    switch (((Bundle)localObject1).getInt("param_req_type", 0))
    {
    default: 
      return;
    case 113: 
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Servlet", 2, "req send timing message");
      }
      localObject1 = new im_reminder.ReminderPackage();
      Object localObject2 = new im_reminder.PkgHead();
      ((im_reminder.PkgHead)localObject2).bussi_type.set(5);
      ((im_reminder.PkgHead)localObject2).password.set("BIRTH_06b904887f6437d0c8b9fc37971f4014");
      ((im_reminder.PkgHead)localObject2).uin.set(getAppRuntime().getLongAccountUin());
      ((im_reminder.ReminderPackage)localObject1).head.set((MessageMicro)localObject2);
      localObject2 = new im_reminder.Request.Add();
      Object localObject3 = new im_reminder.Reminder();
      Object localObject4 = new im_reminder.Reminder.User();
      ((im_reminder.Reminder)localObject3).to_user.set((MessageMicro)localObject4);
      ((im_reminder.Reminder.User)localObject4).uin.set(((QQAppInterface)getAppRuntime()).getLongAccountUin());
      ((im_reminder.Reminder)localObject3).from_user.set((MessageMicro)localObject4);
      localObject4 = new im_msg_body.MsgBody();
      ((im_msg_body.MsgBody)localObject4).rich_text.set(MessageProtoCodec.a(paramIntent.getStringExtra("p_msg"), null));
      ((im_reminder.Reminder)localObject3).msg_body.set((MessageMicro)localObject4);
      ((im_reminder.Request.Add)localObject2).reminder.set((MessageMicro)localObject3);
      localObject3 = paramIntent.getLongArrayExtra("p_uin_list");
      paramIntent = paramIntent.getLongArrayExtra("p_time_list");
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Servlet", 2, "onSendTiming | uin = " + Arrays.toString((long[])localObject3) + " | time = " + Arrays.toString(paramIntent));
      }
      int i = 0;
      while (i < localObject3.length)
      {
        localObject4 = new im_reminder.Request();
        ((im_reminder.Request.Add)localObject2).reminder.to_user.uin.set(localObject3[i]);
        ((im_reminder.Request.Add)localObject2).reminder.at_time.set(paramIntent[i]);
        ((im_reminder.Request)localObject4).add.set((MessageMicro)localObject2);
        ((im_reminder.ReminderPackage)localObject1).request.add((MessageMicro)localObject4);
        i += 1;
      }
      paramPacket.setSSOCommand("ReminderSvc.Reminder");
      paramIntent = ((im_reminder.ReminderPackage)localObject1).toByteArray();
      localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
      ((ByteBuffer)localObject1).put(paramIntent);
      paramPacket.putSendData(((ByteBuffer)localObject1).array());
      return;
    }
    a(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet
 * JD-Core Version:    0.7.0.1
 */