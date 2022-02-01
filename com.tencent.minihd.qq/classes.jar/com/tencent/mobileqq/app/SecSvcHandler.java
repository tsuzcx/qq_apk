package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.device_lock_query_status.ReqBody;
import com.tencent.ims.device_lock_query_status.RspBody;
import com.tencent.ims.get_config.ReqBody;
import com.tencent.ims.get_config.RspBody;
import com.tencent.ims.wx_msg_opt.ReqBody;
import com.tencent.ims.wx_msg_opt.RspBody;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x614.Oidb_0x614.DeviceManageHead;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReNameDeviceNameReqBody;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SecSvcHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static final String a = "SecSvcHandler";
  public static final int b = 1;
  public static final String b = "SecuritySvc.GetConfig";
  public static final int c = 2;
  public static final String c = "DevLockAuthSvc.WxMsgOpt";
  public static final int d = 3;
  public static final String d = "DevLockSecSvc.DevLockQuery";
  public static final int e = 4;
  public static final String e = "OidbSvc.0x614_1";
  public static final int f = 1;
  public static final String f = "proto_version";
  public static final String g = "config_name";
  public static final String h = "config_version";
  public static final String i = "effect_time";
  public static final String j = "md5";
  public static final String k = "download_url";
  public static final String l = "cmd";
  public static final String m = "ret";
  public static final String n = "opt";
  public static final String o = "wording";
  public static final String p = "status";
  public static final String q = "wording";
  private int g = 1;
  
  SecSvcHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2 = 0;
    int i1 = 1;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(1, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new get_config.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = new Bundle();
        if (paramFromServiceMsg.u32_proto_version.has()) {
          i1 = paramFromServiceMsg.u32_proto_version.get();
        }
        paramObject.putInt("proto_version", i1);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_config_name.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_config_name.get();
        }
        paramObject.putString("config_name", paramToServiceMsg);
        if (!paramFromServiceMsg.u32_config_version.has()) {
          break label266;
        }
        i1 = paramFromServiceMsg.u32_config_version.get();
        paramObject.putInt("config_version", i1);
        i1 = i2;
        if (paramFromServiceMsg.u32_effect_time.has()) {
          i1 = paramFromServiceMsg.u32_effect_time.get();
        }
        paramObject.putInt("effect_time", i1);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_md5.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_md5.get();
        }
        paramObject.putString("md5", paramToServiceMsg);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_download_link.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_download_link.get();
        }
        paramObject.putString("download_url", paramToServiceMsg);
        a(1, true, paramObject);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onGetAntiFraudConfig error:" + paramToServiceMsg.getMessage());
      return;
      label266:
      i1 = 0;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 1;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(2, false, null);
      return;
    }
    paramObject = new wx_msg_opt.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        if (paramObject.uint32_cmd.has()) {
          i1 = paramObject.uint32_cmd.get();
        }
        paramFromServiceMsg.putInt("cmd", i1);
        i1 = -1;
        if (paramObject.uint32_ret.has()) {
          i1 = paramObject.uint32_ret.get();
        }
        paramFromServiceMsg.putInt("ret", i1);
        if (!paramObject.uint32_opt.has()) {
          break label203;
        }
        i1 = paramObject.uint32_opt.get();
        paramFromServiceMsg.putInt("opt", i1);
        paramToServiceMsg = "";
        if (paramObject.str_wording.has()) {
          paramToServiceMsg = paramObject.str_wording.get();
        }
        paramFromServiceMsg.putString("wording", paramToServiceMsg);
        a(2, true, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onWXSyncQQMsgOption error:" + paramToServiceMsg.getMessage());
      return;
      label203:
      i1 = 2;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(3, false, null);
      return;
    }
    paramObject = new device_lock_query_status.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        if (!paramObject.u32_status.has()) {
          break label178;
        }
        i1 = paramObject.u32_status.get();
        paramFromServiceMsg.putInt("status", i1);
        paramToServiceMsg = "";
        if (paramObject.str_wording.has()) {
          paramToServiceMsg = paramObject.str_wording.get();
        }
        paramFromServiceMsg.putString("wording", paramToServiceMsg);
        boolean bool1 = bool2;
        if (paramObject.u32_ret.has())
        {
          bool1 = bool2;
          if (paramObject.u32_ret.get() == 0) {
            bool1 = true;
          }
        }
        a(3, bool1, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onQueryDevLockStatus error:" + paramToServiceMsg.getMessage());
      return;
      label178:
      int i1 = 0;
    }
  }
  
  /* Error */
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +252 -> 253
    //   4: aload_2
    //   5: invokevirtual 76	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifeq +245 -> 253
    //   11: new 198	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   14: dup
    //   15: invokespecial 199	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_2
    //   21: invokevirtual 168	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   24: invokevirtual 200	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: pop
    //   28: aload_3
    //   29: getfield 204	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   32: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   35: ifeq +218 -> 253
    //   38: new 209	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody
    //   41: dup
    //   42: invokespecial 210	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:<init>	()V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_3
    //   48: getfield 204	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 213	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: invokevirtual 218	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   57: invokevirtual 219	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: aload_2
    //   62: getfield 223	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:msg_dm_head	Ltencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead;
    //   65: invokevirtual 226	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:has	()Z
    //   68: ifeq +185 -> 253
    //   71: aload_2
    //   72: getfield 223	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:msg_dm_head	Ltencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead;
    //   75: astore_2
    //   76: aload_2
    //   77: getfield 229	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   80: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   83: ifeq +170 -> 253
    //   86: aload_2
    //   87: getfield 229	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   90: invokevirtual 106	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   93: istore 4
    //   95: iload 4
    //   97: ifne +156 -> 253
    //   100: new 92	android/os/Bundle
    //   103: dup
    //   104: invokespecial 93	android/os/Bundle:<init>	()V
    //   107: astore_3
    //   108: aload_1
    //   109: getfield 235	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   112: getstatic 239	com/tencent/mobileqq/activity/AuthDevRenameActivity:i	Ljava/lang/String;
    //   115: invokevirtual 243	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   118: istore 4
    //   120: aload_3
    //   121: getstatic 239	com/tencent/mobileqq/activity/AuthDevRenameActivity:i	Ljava/lang/String;
    //   124: iload 4
    //   126: invokevirtual 110	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   129: aload_1
    //   130: getfield 235	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   133: getstatic 245	com/tencent/mobileqq/activity/AuthDevRenameActivity:f	Ljava/lang/String;
    //   136: invokevirtual 249	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_2
    //   140: aload_3
    //   141: getstatic 245	com/tencent/mobileqq/activity/AuthDevRenameActivity:f	Ljava/lang/String;
    //   144: aload_2
    //   145: invokevirtual 126	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_1
    //   149: getfield 235	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   152: getstatic 251	com/tencent/mobileqq/activity/AuthDevRenameActivity:h	Ljava/lang/String;
    //   155: invokevirtual 255	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   158: astore_1
    //   159: aload_3
    //   160: getstatic 251	com/tencent/mobileqq/activity/AuthDevRenameActivity:h	Ljava/lang/String;
    //   163: aload_1
    //   164: invokevirtual 259	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   167: iconst_1
    //   168: istore 6
    //   170: aload_0
    //   171: iconst_4
    //   172: iload 6
    //   174: aload_3
    //   175: invokevirtual 79	com/tencent/mobileqq/app/SecSvcHandler:a	(IZLjava/lang/Object;)V
    //   178: return
    //   179: astore_2
    //   180: iconst_0
    //   181: istore 5
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: astore_3
    //   187: iload 5
    //   189: istore 6
    //   191: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq -24 -> 170
    //   197: ldc 10
    //   199: iconst_2
    //   200: new 145	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 261
    //   210: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_2
    //   214: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload_1
    //   227: astore_3
    //   228: iload 5
    //   230: istore 6
    //   232: goto -62 -> 170
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_1
    //   238: iconst_1
    //   239: istore 5
    //   241: goto -56 -> 185
    //   244: astore_2
    //   245: iconst_1
    //   246: istore 5
    //   248: aload_3
    //   249: astore_1
    //   250: goto -65 -> 185
    //   253: iconst_0
    //   254: istore 6
    //   256: aconst_null
    //   257: astore_3
    //   258: goto -88 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	SecSvcHandler
    //   0	261	1	paramToServiceMsg	ToServiceMsg
    //   0	261	2	paramFromServiceMsg	FromServiceMsg
    //   0	261	3	paramObject	Object
    //   93	32	4	i1	int
    //   181	66	5	bool1	boolean
    //   168	87	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	95	179	java/lang/Exception
    //   100	108	235	java/lang/Exception
    //   108	167	244	java/lang/Exception
  }
  
  protected Class a()
  {
    return SecSvcObserver.class;
  }
  
  public void a()
  {
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.a.getLongAccountUin());
    localReqBody.uint32_cmd.set(1);
    Object localObject = localReqBody.uint32_seq;
    int i1 = this.g;
    this.g = (i1 + 1);
    ((PBUInt32Field)localObject).set(i1);
    localReqBody.uint32_opt.set(1);
    localObject = a("DevLockAuthSvc.WxMsgOpt");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    Object localObject1 = paramBundle.getString(AuthDevRenameActivity.a);
    Object localObject2 = paramBundle.getString(AuthDevRenameActivity.b);
    long l3 = paramBundle.getLong(AuthDevRenameActivity.c);
    long l4 = paramBundle.getLong(AuthDevRenameActivity.d);
    byte[] arrayOfByte2 = paramBundle.getByteArray(AuthDevRenameActivity.e);
    String str = paramBundle.getString(AuthDevRenameActivity.f);
    byte[] arrayOfByte1 = paramBundle.getByteArray(AuthDevRenameActivity.h);
    int i1 = paramBundle.getInt(AuthDevRenameActivity.i);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong((String)localObject1);
      l1 = l2;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        Oidb_0x614.ReNameDeviceNameReqBody localReNameDeviceNameReqBody;
        paramBundle.printStackTrace();
      }
    }
    paramBundle = new Oidb_0x614.DeviceManageHead();
    paramBundle.uint32_cmd.set(0);
    paramBundle.uint32_result.set(0);
    paramBundle.uint64_uin.set(l1);
    paramBundle.bytes_guid.set(ByteStringMicro.copyFrom(arrayOfByte2));
    paramBundle.uint32_appid.set((int)l3);
    paramBundle.uint32_subappid.set((int)l4);
    paramBundle.bytes_appname.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localReNameDeviceNameReqBody = new Oidb_0x614.ReNameDeviceNameReqBody();
    localReNameDeviceNameReqBody.bytes_guid.set(ByteStringMicro.copyFrom(arrayOfByte2));
    localReNameDeviceNameReqBody.uint32_appid.set((int)l3);
    localReNameDeviceNameReqBody.uint32_subappid.set((int)l4);
    localReNameDeviceNameReqBody.bytes_appname.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localReNameDeviceNameReqBody.bytes_device_des.set(ByteStringMicro.copyFrom(arrayOfByte1));
    localReNameDeviceNameReqBody.bytes_rename_device_name.set(ByteStringMicro.copyFromUtf8(str));
    localObject2 = new Oidb_0x614.ReqBody();
    ((Oidb_0x614.ReqBody)localObject2).msg_dm_head.set(paramBundle);
    ((Oidb_0x614.ReqBody)localObject2).msg_mdn_req_body.set(localReNameDeviceNameReqBody);
    paramBundle = new oidb_sso.OIDBSSOPkg();
    paramBundle.uint32_command.set(1556);
    paramBundle.uint32_service_type.set(1);
    paramBundle.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x614.ReqBody)localObject2).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "OidbSvc.0x614_1");
    ((ToServiceMsg)localObject1).putWupBuffer(paramBundle.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong(AuthDevRenameActivity.a, l1);
    ((ToServiceMsg)localObject1).extraData.putString(AuthDevRenameActivity.f, str);
    ((ToServiceMsg)localObject1).extraData.putByteArray(AuthDevRenameActivity.h, arrayOfByte1);
    ((ToServiceMsg)localObject1).extraData.putInt(AuthDevRenameActivity.i, i1);
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str.equalsIgnoreCase("SecuritySvc.GetConfig")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (str.equalsIgnoreCase("DevLockAuthSvc.WxMsgOpt"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("DevLockSecSvc.DevLockQuery"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!str.equalsIgnoreCase("OidbSvc.0x614_1"));
    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "getAntiFraudConfig");
    }
    get_config.ReqBody localReqBody = new get_config.ReqBody();
    localReqBody.u64_uin.set(this.a.getLongAccountUin());
    localReqBody.u32_appid.set(AppSetting.a);
    localReqBody.u32_proto_version.set(1);
    PBUInt32Field localPBUInt32Field = localReqBody.u32_seq;
    int i1 = this.g;
    this.g = (i1 + 1);
    localPBUInt32Field.set(i1);
    localReqBody.str_config_name.set(paramString);
    paramString = AntiFraudConfigFileUtil.a().a(paramString, "Version");
    int i2 = 0;
    i1 = i2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i1 = Integer.parseInt(paramString);
      localReqBody.u32_config_version.set(i1);
      paramString = a("SecuritySvc.GetConfig");
      paramString.putWupBuffer(localReqBody.toByteArray());
      b(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i1 = i2;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "setWXSyncQQMsgOption");
    }
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.a.getLongAccountUin());
    localReqBody.uint32_cmd.set(2);
    Object localObject = localReqBody.uint32_seq;
    int i2 = this.g;
    this.g = (i2 + 1);
    ((PBUInt32Field)localObject).set(i2);
    localObject = localReqBody.uint32_opt;
    if (paramBoolean) {
      i1 = 1;
    }
    ((PBUInt32Field)localObject).set(i1);
    localObject = a("DevLockAuthSvc.WxMsgOpt");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b()
  {
    device_lock_query_status.ReqBody localReqBody = new device_lock_query_status.ReqBody();
    Object localObject = localReqBody.u32_seq;
    int i1 = this.g;
    this.g = (i1 + 1);
    ((PBUInt32Field)localObject).set(i1);
    localReqBody.u32_sys_type.set(1);
    localReqBody.u32_app_id.set(AppSetting.a);
    localObject = a("DevLockSecSvc.DevLockQuery");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcHandler
 * JD-Core Version:    0.7.0.1
 */