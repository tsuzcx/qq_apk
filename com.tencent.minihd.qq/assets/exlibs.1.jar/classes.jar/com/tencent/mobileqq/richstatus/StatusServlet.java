package com.tencent.mobileqq.richstatus;

import PersonalState.BusiReqHead;
import PersonalState.ReqGetHotState;
import PersonalState.ReqGetSameStateList;
import PersonalState.stRishState;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.signature.SigActPb.Platform;
import com.tencent.pb.signature.SigActPb.ReqBody;
import com.tencent.pb.signature.SigActPb.SigauthReq;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class StatusServlet
  extends MSFServlet
{
  private static final String A = "Signature.auth";
  private static final String B = "k_uin";
  private static final String C = "k_cookie";
  static final int a = 1;
  public static final String a = "PersonalStateSvc.ReqGetHotState";
  static final int b = 2;
  public static final String b = "k_cmd";
  static final int jdField_c_of_type_Int = 3;
  static final String jdField_c_of_type_JavaLangString = "k_sync_ss";
  static final int jdField_d_of_type_Int = 4;
  static final String jdField_d_of_type_JavaLangString = "k_resp_mate";
  static final int jdField_e_of_type_Int = 5;
  static final String jdField_e_of_type_JavaLangString = "k_fetch_sex";
  static final int jdField_f_of_type_Int = 6;
  static final String jdField_f_of_type_JavaLangString = "k_is_first";
  static final int jdField_g_of_type_Int = 7;
  static final String jdField_g_of_type_JavaLangString = "k_action";
  static final int jdField_h_of_type_Int = 8;
  static final String jdField_h_of_type_JavaLangString = "k_data";
  static final int jdField_i_of_type_Int = 9;
  static final String jdField_i_of_type_JavaLangString = "k_end_time";
  private static final int jdField_j_of_type_Int = 50;
  static final String jdField_j_of_type_JavaLangString = "k_start_time";
  static final String k = "k_status_key";
  static final String l = "k_status_flag";
  static final String m = "k_error_code";
  static final String n = "k_resp_hot_status";
  static final String o = "k_source";
  static final String p = "k_rspbody";
  static final String q = "k_auth_code";
  static final String r = "k_tpl_id";
  static final String s = "k_sign_data";
  static final String t = "k_sign_len";
  private static final String u = "OidbSvc.0x515_2";
  private static final String v = "OidbSvc.0x53f_2";
  private static final String w = "OidbSvc.0x54f_0";
  private static final String x = "PersonalStateSvc.ReqGetSameStateList";
  private static final String y = "OidbSvc.0x50f_29";
  private static final String z = "OidbSvc.0x510_0";
  
  static PersonalState.LBSInfo a(QQAppInterface paramQQAppInterface)
  {
    SosoInterface.a(60000L, StatusServlet.class.getSimpleName());
    Object localObject1 = SosoInterface.a();
    paramQQAppInterface = null;
    if (localObject1 != null)
    {
      paramQQAppInterface = ((NearbyGroup.LBSInfo)localObject1).stGps;
      paramQQAppInterface = new PersonalState.GPS(paramQQAppInterface.iLat, paramQQAppInterface.iLon, paramQQAppInterface.iAlt, paramQQAppInterface.eType);
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = ((NearbyGroup.LBSInfo)localObject1).vWifis.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NearbyGroup.Wifi)((Iterator)localObject2).next();
        localArrayList.add(new PersonalState.Wifi(((NearbyGroup.Wifi)localObject3).lMac, ((NearbyGroup.Wifi)localObject3).shRssi));
      }
      localObject2 = new ArrayList();
      localObject1 = ((NearbyGroup.LBSInfo)localObject1).vCells.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (NearbyGroup.Cell)((Iterator)localObject1).next();
        ((ArrayList)localObject2).add(new PersonalState.Cell(((NearbyGroup.Cell)localObject3).shMcc, ((NearbyGroup.Cell)localObject3).shMnc, ((NearbyGroup.Cell)localObject3).iLac, ((NearbyGroup.Cell)localObject3).iCellId, ((NearbyGroup.Cell)localObject3).shRssi));
      }
      paramQQAppInterface = new PersonalState.LBSInfo(paramQQAppInterface, localArrayList, (ArrayList)localObject2);
    }
    return paramQQAppInterface;
  }
  
  static void a(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 1);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.a());
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("k_start_time", paramInt1);
    localNewIntent.putExtra("k_end_time", paramInt2);
    localNewIntent.putExtra("k_uin", paramString);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 2);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.a());
    localNewIntent.putExtra("k_sync_ss", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 3);
    localNewIntent.putExtra("k_is_first", paramBoolean);
    localNewIntent.putExtra("k_cookie", paramArrayOfByte);
    localNewIntent.putExtra("k_fetch_sex", paramInt1);
    localNewIntent.putExtra("k_action", paramInt2);
    localNewIntent.putExtra("k_data", paramInt3);
    localNewIntent.putExtra("k_uin", paramString);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 7);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.a());
    localNewIntent.putExtra("k_data", paramArrayOfByte);
    localNewIntent.putExtra("k_source", paramInt);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private byte[] a(List paramList, byte paramByte)
  {
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1359);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    Object localObject2 = paramList.iterator();
    int i1 = 7;
    byte[] arrayOfByte;
    if (((Iterator)localObject2).hasNext())
    {
      arrayOfByte = (byte[])((Iterator)localObject2).next();
      if (arrayOfByte == null) {
        break label227;
      }
      i1 = arrayOfByte.length + (i1 + 2) + 4;
    }
    label227:
    for (;;)
    {
      break;
      localObject2 = ByteBuffer.allocate(i1);
      ((ByteBuffer)localObject2).putInt(0);
      ((ByteBuffer)localObject2).put(paramByte);
      ((ByteBuffer)localObject2).putShort((short)paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        arrayOfByte = (byte[])paramList.next();
        if (arrayOfByte != null)
        {
          ((ByteBuffer)localObject2).putShort((short)arrayOfByte.length);
          ((ByteBuffer)localObject2).put(arrayOfByte);
          ((ByteBuffer)localObject2).putInt(0);
        }
      }
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
      paramList = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
      localObject1 = ByteBuffer.allocate(paramList.length + 4);
      ((ByteBuffer)localObject1).putInt(paramList.length + 4);
      ((ByteBuffer)localObject1).put(paramList);
      return ((ByteBuffer)localObject1).array();
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1295);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(29);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length + 2);
    localByteBuffer.put((byte)0).put((byte)paramArrayOfByte.length).put(paramArrayOfByte);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramArrayOfByte = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).putInt(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    return ((ByteBuffer)localObject).array();
  }
  
  static void b(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 6);
    if (QLog.isColorLevel()) {
      QLog.d("get_hot_rich_status", 2, "StatusServlet.getHotRichStatus()");
    }
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  byte[] a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1343);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(27);
    localByteBuffer.putLong(paramLong).put((byte)2).putInt(paramInt1).putInt(paramInt2).putInt(0).putInt(0).putShort((short)6);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localByteBuffer = ByteBuffer.allocate(localObject.length + 4);
    localByteBuffer.putInt(localObject.length + 4);
    localByteBuffer.put((byte[])localObject);
    return localByteBuffer.array();
  }
  
  byte[] a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    int i2 = 1;
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1301);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(11);
    ByteBuffer localByteBuffer2 = localByteBuffer1.put((byte)2).putInt(293615363);
    if (paramBoolean1)
    {
      i1 = 1;
      localByteBuffer2.put((byte)i1);
      if (!paramBoolean2) {
        break label155;
      }
    }
    label155:
    for (int i1 = i2;; i1 = 0)
    {
      localByteBuffer1.put((byte)i1).putInt((int)paramLong);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer1.array()));
      localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
      localByteBuffer1 = ByteBuffer.allocate(localObject.length + 4);
      localByteBuffer1.putInt(localObject.length + 4);
      localByteBuffer1.put((byte[])localObject);
      return localByteBuffer1.array();
      i1 = 0;
      break;
    }
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 23
    //   3: iconst_0
    //   4: invokevirtual 352	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   7: istore 5
    //   9: aload_2
    //   10: invokevirtual 357	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: istore 8
    //   15: aload_0
    //   16: invokevirtual 361	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   19: bipush 14
    //   21: invokevirtual 367	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   24: checkcast 369	com/tencent/mobileqq/richstatus/StatusManager
    //   27: astore 13
    //   29: aload 13
    //   31: ifnonnull +4 -> 35
    //   34: return
    //   35: new 371	android/os/Bundle
    //   38: dup
    //   39: invokespecial 372	android/os/Bundle:<init>	()V
    //   42: astore 14
    //   44: iload 5
    //   46: tableswitch	default:+50 -> 96, 1:+65->111, 2:+65->111, 3:+787->833, 4:+218->264, 5:+895->941, 6:+1254->1300, 7:+1730->1776, 8:+2070->2116, 9:+1904->1950
    //   97: aload_1
    //   98: iload 5
    //   100: iload 8
    //   102: aload 14
    //   104: ldc_w 374
    //   107: invokevirtual 378	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   110: return
    //   111: aload_2
    //   112: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   115: invokestatic 384	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 387	java/nio/ByteBuffer:getInt	()I
    //   123: iconst_4
    //   124: isub
    //   125: newarray byte
    //   127: astore 13
    //   129: aload_2
    //   130: aload 13
    //   132: invokevirtual 390	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   135: pop
    //   136: new 255	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   139: dup
    //   140: invokespecial 256	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   143: aload 13
    //   145: invokevirtual 394	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   148: checkcast 255	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   151: getfield 302	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   154: invokevirtual 397	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   157: invokevirtual 398	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   160: invokestatic 384	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   163: astore_2
    //   164: aload_2
    //   165: invokevirtual 401	java/nio/ByteBuffer:get	()B
    //   168: istore_3
    //   169: aload_2
    //   170: invokevirtual 387	java/nio/ByteBuffer:getInt	()I
    //   173: i2l
    //   174: lstore 11
    //   176: aload_2
    //   177: invokevirtual 401	java/nio/ByteBuffer:get	()B
    //   180: iconst_1
    //   181: if_icmpne +2105 -> 2286
    //   184: iconst_1
    //   185: istore 9
    //   187: goto +2081 -> 2268
    //   190: aload 14
    //   192: ldc 27
    //   194: iload 10
    //   196: invokevirtual 405	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   199: iload 9
    //   201: istore 8
    //   203: goto -107 -> 96
    //   206: iload 9
    //   208: istore 10
    //   210: iload 8
    //   212: istore 9
    //   214: iload 5
    //   216: iconst_2
    //   217: if_icmpne -27 -> 190
    //   220: aload_1
    //   221: ldc 27
    //   223: iconst_0
    //   224: invokevirtual 409	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   227: istore 10
    //   229: iload 8
    //   231: istore 9
    //   233: goto -43 -> 190
    //   236: astore_2
    //   237: aload_2
    //   238: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   241: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +14 -> 258
    //   247: ldc_w 414
    //   250: iconst_2
    //   251: aload_2
    //   252: invokevirtual 417	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   255: invokestatic 419	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: iconst_0
    //   259: istore 8
    //   261: goto -165 -> 96
    //   264: new 421	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   267: dup
    //   268: invokespecial 422	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   271: astore 13
    //   273: aload 13
    //   275: aload_1
    //   276: ldc 55
    //   278: iconst_0
    //   279: invokevirtual 352	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   282: putfield 425	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   285: aload 13
    //   287: aload_1
    //   288: ldc 51
    //   290: ldc_w 426
    //   293: invokevirtual 352	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   296: putfield 429	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   299: aload 13
    //   301: iconst_0
    //   302: putfield 433	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   305: aload 14
    //   307: ldc 47
    //   309: aload 13
    //   311: invokevirtual 437	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   314: aload_2
    //   315: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   318: invokestatic 384	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   321: astore_2
    //   322: aload_2
    //   323: invokevirtual 387	java/nio/ByteBuffer:getInt	()I
    //   326: iconst_4
    //   327: isub
    //   328: newarray byte
    //   330: astore 15
    //   332: aload_2
    //   333: aload 15
    //   335: invokevirtual 390	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   338: pop
    //   339: new 255	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   342: dup
    //   343: invokespecial 256	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   346: aload 15
    //   348: invokevirtual 394	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   351: checkcast 255	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   354: getfield 302	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   357: invokevirtual 397	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   360: invokevirtual 398	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   363: invokestatic 384	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   366: astore 15
    //   368: aload 15
    //   370: invokevirtual 401	java/nio/ByteBuffer:get	()B
    //   373: pop
    //   374: aload 15
    //   376: invokevirtual 441	java/nio/ByteBuffer:getLong	()J
    //   379: lstore 11
    //   381: aload 15
    //   383: invokevirtual 401	java/nio/ByteBuffer:get	()B
    //   386: pop
    //   387: aload 15
    //   389: invokevirtual 387	java/nio/ByteBuffer:getInt	()I
    //   392: pop
    //   393: aload 15
    //   395: invokevirtual 387	java/nio/ByteBuffer:getInt	()I
    //   398: istore 4
    //   400: aload 15
    //   402: invokevirtual 387	java/nio/ByteBuffer:getInt	()I
    //   405: pop
    //   406: aload 15
    //   408: invokevirtual 401	java/nio/ByteBuffer:get	()B
    //   411: ifeq +1888 -> 2299
    //   414: iconst_1
    //   415: istore 9
    //   417: aload 15
    //   419: invokevirtual 445	java/nio/ByteBuffer:getShort	()S
    //   422: istore 6
    //   424: aload 13
    //   426: new 152	java/util/ArrayList
    //   429: dup
    //   430: iload 6
    //   432: invokespecial 447	java/util/ArrayList:<init>	(I)V
    //   435: putfield 450	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   438: aload_0
    //   439: invokevirtual 361	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   442: checkcast 223	com/tencent/mobileqq/app/QQAppInterface
    //   445: astore_2
    //   446: iconst_0
    //   447: istore_3
    //   448: iload_3
    //   449: iload 6
    //   451: if_icmpge +163 -> 614
    //   454: aload 15
    //   456: invokevirtual 445	java/nio/ByteBuffer:getShort	()S
    //   459: newarray byte
    //   461: astore 16
    //   463: aload 15
    //   465: aload 16
    //   467: invokevirtual 390	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   470: pop
    //   471: aload 15
    //   473: invokevirtual 445	java/nio/ByteBuffer:getShort	()S
    //   476: newarray byte
    //   478: astore 17
    //   480: aload 15
    //   482: aload 17
    //   484: invokevirtual 390	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   487: pop
    //   488: aload 15
    //   490: invokevirtual 387	java/nio/ByteBuffer:getInt	()I
    //   493: pop
    //   494: aload 15
    //   496: invokevirtual 387	java/nio/ByteBuffer:getInt	()I
    //   499: istore 7
    //   501: aload 15
    //   503: aload 15
    //   505: invokevirtual 453	java/nio/ByteBuffer:position	()I
    //   508: bipush 8
    //   510: iadd
    //   511: invokevirtual 456	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   514: pop
    //   515: iload 7
    //   517: iload 4
    //   519: if_icmple +6 -> 525
    //   522: goto +1770 -> 2292
    //   525: aload 17
    //   527: invokestatic 461	com/tencent/mobileqq/richstatus/RichStatus:a	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   530: astore 17
    //   532: aload 17
    //   534: iload 7
    //   536: i2l
    //   537: putfield 463	com/tencent/mobileqq/richstatus/RichStatus:jdField_a_of_type_Long	J
    //   540: aload 17
    //   542: aload 16
    //   544: putfield 465	com/tencent/mobileqq/richstatus/RichStatus:jdField_a_of_type_ArrayOfByte	[B
    //   547: aload 17
    //   549: getfield 465	com/tencent/mobileqq/richstatus/RichStatus:jdField_a_of_type_ArrayOfByte	[B
    //   552: ifnull +20 -> 572
    //   555: aload 17
    //   557: new 467	java/lang/String
    //   560: dup
    //   561: aload 17
    //   563: getfield 465	com/tencent/mobileqq/richstatus/RichStatus:jdField_a_of_type_ArrayOfByte	[B
    //   566: invokespecial 470	java/lang/String:<init>	([B)V
    //   569: putfield 472	com/tencent/mobileqq/richstatus/RichStatus:f	Ljava/lang/String;
    //   572: aload 13
    //   574: getfield 450	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   577: aload 17
    //   579: invokevirtual 190	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   582: pop
    //   583: goto +1709 -> 2292
    //   586: astore_2
    //   587: aload_2
    //   588: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   591: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   594: ifeq +14 -> 608
    //   597: ldc_w 414
    //   600: iconst_2
    //   601: aload_2
    //   602: invokevirtual 417	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   605: invokestatic 419	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: iconst_0
    //   609: istore 8
    //   611: goto -515 -> 96
    //   614: aload 13
    //   616: getfield 450	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   619: invokevirtual 475	java/util/ArrayList:isEmpty	()Z
    //   622: ifeq +90 -> 712
    //   625: aload 13
    //   627: getfield 425	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   630: ifne +82 -> 712
    //   633: aload 13
    //   635: getfield 429	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   638: ldc_w 426
    //   641: if_icmpne +71 -> 712
    //   644: aload_0
    //   645: invokevirtual 361	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   648: bipush 8
    //   650: invokevirtual 367	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   653: checkcast 477	com/tencent/mobileqq/model/FriendManager
    //   656: lload 11
    //   658: invokestatic 481	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   661: invokeinterface 484 2 0
    //   666: astore 15
    //   668: aload 15
    //   670: ifnull +42 -> 712
    //   673: aload 15
    //   675: invokevirtual 490	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   678: ifnull +34 -> 712
    //   681: aload 15
    //   683: invokevirtual 490	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   686: invokevirtual 492	com/tencent/mobileqq/richstatus/RichStatus:a	()Z
    //   689: ifne +23 -> 712
    //   692: aload 13
    //   694: getfield 450	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   697: aload 15
    //   699: invokevirtual 490	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   702: invokevirtual 190	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   705: pop
    //   706: aload 13
    //   708: iconst_1
    //   709: putfield 433	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   712: aload_2
    //   713: bipush 43
    //   715: invokevirtual 495	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   718: checkcast 497	com/tencent/mobileqq/app/SignatureHandler
    //   721: astore 15
    //   723: aload 13
    //   725: getfield 450	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   728: invokevirtual 161	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   731: astore 16
    //   733: aload 16
    //   735: invokeinterface 167 1 0
    //   740: ifeq +42 -> 782
    //   743: aload 16
    //   745: invokeinterface 171 1 0
    //   750: checkcast 458	com/tencent/mobileqq/richstatus/RichStatus
    //   753: astore 17
    //   755: aload 15
    //   757: ifnull -24 -> 733
    //   760: aload 15
    //   762: lload 11
    //   764: invokestatic 481	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   767: aload 17
    //   769: getfield 472	com/tencent/mobileqq/richstatus/RichStatus:f	Ljava/lang/String;
    //   772: sipush 255
    //   775: iconst_1
    //   776: invokevirtual 500	com/tencent/mobileqq/app/SignatureHandler:a	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   779: goto -46 -> 733
    //   782: aload 13
    //   784: iload 9
    //   786: putfield 503	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   789: aload_2
    //   790: bipush 56
    //   792: invokevirtual 504	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   795: checkcast 506	com/tencent/mobileqq/app/SignatureManager
    //   798: astore 15
    //   800: aload 15
    //   802: ifnull +28 -> 830
    //   805: aload_2
    //   806: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   809: lload 11
    //   811: invokestatic 511	java/lang/Long:toString	(J)Ljava/lang/String;
    //   814: invokevirtual 514	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   817: ifeq +13 -> 830
    //   820: aload 15
    //   822: aload 13
    //   824: getfield 450	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   827: invokevirtual 517	com/tencent/mobileqq/app/SignatureManager:a	(Ljava/util/List;)V
    //   830: goto -734 -> 96
    //   833: aload 14
    //   835: ldc 39
    //   837: aload_1
    //   838: ldc 39
    //   840: iconst_1
    //   841: invokevirtual 409	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   844: invokevirtual 405	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   847: aload 14
    //   849: ldc 35
    //   851: aload_1
    //   852: ldc 35
    //   854: iconst_m1
    //   855: invokevirtual 352	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   858: invokevirtual 520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   861: new 522	com/qq/jce/wup/UniPacket
    //   864: dup
    //   865: iconst_1
    //   866: invokespecial 525	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   869: astore 13
    //   871: aload 13
    //   873: ldc_w 527
    //   876: invokevirtual 531	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   879: aload 13
    //   881: aload_2
    //   882: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   885: invokevirtual 534	com/qq/jce/wup/UniPacket:decode	([B)V
    //   888: aload 13
    //   890: ldc_w 536
    //   893: new 538	PersonalState/RespGetSameStateList
    //   896: dup
    //   897: invokespecial 539	PersonalState/RespGetSameStateList:<init>	()V
    //   900: invokevirtual 543	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   903: checkcast 538	PersonalState/RespGetSameStateList
    //   906: astore_2
    //   907: aload_2
    //   908: getfield 547	PersonalState/RespGetSameStateList:oHead	LPersonalState/BusiRespHead;
    //   911: getfield 552	PersonalState/BusiRespHead:iReplyCode	I
    //   914: ifne +14 -> 928
    //   917: aload 14
    //   919: ldc 31
    //   921: aload_2
    //   922: invokevirtual 437	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   925: goto -829 -> 96
    //   928: iconst_0
    //   929: istore 8
    //   931: goto -6 -> 925
    //   934: astore_2
    //   935: iconst_0
    //   936: istore 8
    //   938: goto -842 -> 96
    //   941: iload 8
    //   943: ifeq -847 -> 96
    //   946: new 255	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   949: dup
    //   950: invokespecial 256	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   953: astore 13
    //   955: aload 13
    //   957: aload_2
    //   958: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   961: invokestatic 556	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   964: invokevirtual 394	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   967: checkcast 255	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   970: astore_2
    //   971: aload_2
    //   972: ifnull +312 -> 1284
    //   975: aload_2
    //   976: getfield 559	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   979: invokevirtual 562	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   982: ifeq +302 -> 1284
    //   985: aload_2
    //   986: getfield 559	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   989: invokevirtual 564	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   992: istore_3
    //   993: iload_3
    //   994: ifne +276 -> 1270
    //   997: aload_2
    //   998: getfield 302	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1001: invokevirtual 397	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1004: invokevirtual 398	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1007: invokestatic 384	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1010: astore 15
    //   1012: aload 15
    //   1014: invokevirtual 401	java/nio/ByteBuffer:get	()B
    //   1017: istore_3
    //   1018: iload_3
    //   1019: ifne +184 -> 1203
    //   1022: aload 15
    //   1024: invokevirtual 445	java/nio/ByteBuffer:getShort	()S
    //   1027: istore 6
    //   1029: iconst_0
    //   1030: istore_3
    //   1031: aconst_null
    //   1032: astore_2
    //   1033: iload_3
    //   1034: iload 6
    //   1036: if_icmpge +75 -> 1111
    //   1039: aload 15
    //   1041: invokevirtual 445	java/nio/ByteBuffer:getShort	()S
    //   1044: newarray byte
    //   1046: astore_2
    //   1047: aload 15
    //   1049: aload_2
    //   1050: invokevirtual 390	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1053: pop
    //   1054: iload_3
    //   1055: iconst_1
    //   1056: iadd
    //   1057: istore_3
    //   1058: goto -25 -> 1033
    //   1061: astore_2
    //   1062: aload_2
    //   1063: invokevirtual 565	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1066: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1069: ifeq +33 -> 1102
    //   1072: ldc_w 414
    //   1075: iconst_2
    //   1076: new 567	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 568	java/lang/StringBuilder:<init>	()V
    //   1083: ldc_w 570
    //   1086: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: aload_2
    //   1090: invokevirtual 575	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   1093: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1099: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1102: iconst_0
    //   1103: istore 8
    //   1105: aload 13
    //   1107: astore_2
    //   1108: goto -137 -> 971
    //   1111: aload 15
    //   1113: invokevirtual 445	java/nio/ByteBuffer:getShort	()S
    //   1116: istore 7
    //   1118: aconst_null
    //   1119: astore 13
    //   1121: iconst_0
    //   1122: istore 4
    //   1124: iconst_0
    //   1125: istore_3
    //   1126: iload_3
    //   1127: iload 7
    //   1129: if_icmpge +34 -> 1163
    //   1132: aload 15
    //   1134: invokevirtual 445	java/nio/ByteBuffer:getShort	()S
    //   1137: newarray byte
    //   1139: astore 13
    //   1141: aload 15
    //   1143: aload 13
    //   1145: invokevirtual 390	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1148: pop
    //   1149: aload 15
    //   1151: invokevirtual 387	java/nio/ByteBuffer:getInt	()I
    //   1154: istore 4
    //   1156: iload_3
    //   1157: iconst_1
    //   1158: iadd
    //   1159: istore_3
    //   1160: goto -34 -> 1126
    //   1163: iload 6
    //   1165: ifle +14 -> 1179
    //   1168: aload 14
    //   1170: ldc 58
    //   1172: aload_2
    //   1173: invokevirtual 581	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1176: goto +1129 -> 2305
    //   1179: aload 14
    //   1181: ldc 58
    //   1183: aload 13
    //   1185: invokevirtual 581	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1188: aload 14
    //   1190: ldc 64
    //   1192: iload 4
    //   1194: invokevirtual 520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1197: iconst_0
    //   1198: istore 8
    //   1200: goto +1105 -> 2305
    //   1203: iconst_0
    //   1204: istore 8
    //   1206: aload 14
    //   1208: ldc 64
    //   1210: iload_3
    //   1211: invokevirtual 520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1214: goto +1091 -> 2305
    //   1217: astore_2
    //   1218: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1221: ifeq +33 -> 1254
    //   1224: ldc_w 414
    //   1227: iconst_2
    //   1228: new 567	java/lang/StringBuilder
    //   1231: dup
    //   1232: invokespecial 568	java/lang/StringBuilder:<init>	()V
    //   1235: ldc_w 583
    //   1238: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: aload_2
    //   1242: invokevirtual 417	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1245: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: invokestatic 419	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1254: iconst_0
    //   1255: istore 8
    //   1257: aload 14
    //   1259: ldc 64
    //   1261: sipush -1002
    //   1264: invokevirtual 520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1267: goto +1038 -> 2305
    //   1270: iconst_0
    //   1271: istore 8
    //   1273: aload 14
    //   1275: ldc 64
    //   1277: iload_3
    //   1278: invokevirtual 520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1281: goto +1024 -> 2305
    //   1284: iconst_0
    //   1285: istore 8
    //   1287: aload 14
    //   1289: ldc 64
    //   1291: sipush -1001
    //   1294: invokevirtual 520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1297: goto +1008 -> 2305
    //   1300: new 522	com/qq/jce/wup/UniPacket
    //   1303: dup
    //   1304: iconst_1
    //   1305: invokespecial 525	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   1308: astore 15
    //   1310: aload 15
    //   1312: ldc_w 527
    //   1315: invokevirtual 531	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   1318: aload 15
    //   1320: aload_2
    //   1321: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1324: invokevirtual 534	com/qq/jce/wup/UniPacket:decode	([B)V
    //   1327: aload 15
    //   1329: ldc_w 585
    //   1332: new 587	PersonalState/RespGetHotState
    //   1335: dup
    //   1336: invokespecial 588	PersonalState/RespGetHotState:<init>	()V
    //   1339: invokevirtual 543	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1342: checkcast 587	PersonalState/RespGetHotState
    //   1345: astore 15
    //   1347: aload 15
    //   1349: getfield 589	PersonalState/RespGetHotState:oHead	LPersonalState/BusiRespHead;
    //   1352: getfield 552	PersonalState/BusiRespHead:iReplyCode	I
    //   1355: ifne +399 -> 1754
    //   1358: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1361: ifeq +159 -> 1520
    //   1364: new 567	java/lang/StringBuilder
    //   1367: dup
    //   1368: ldc_w 591
    //   1371: invokespecial 593	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1374: astore 16
    //   1376: aload 16
    //   1378: ldc_w 595
    //   1381: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: astore 17
    //   1386: aload 15
    //   1388: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1391: ifnonnull +102 -> 1493
    //   1394: ldc_w 600
    //   1397: astore_2
    //   1398: aload 17
    //   1400: aload_2
    //   1401: invokevirtual 603	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1404: ldc_w 605
    //   1407: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: pop
    //   1411: aload 15
    //   1413: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1416: ifnull +92 -> 1508
    //   1419: aload 15
    //   1421: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1424: invokevirtual 606	java/util/ArrayList:size	()I
    //   1427: ifle +81 -> 1508
    //   1430: aload 15
    //   1432: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1435: invokevirtual 161	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1438: astore_2
    //   1439: aload_2
    //   1440: invokeinterface 167 1 0
    //   1445: ifeq +63 -> 1508
    //   1448: aload_2
    //   1449: invokeinterface 171 1 0
    //   1454: checkcast 608	PersonalState/HotRishState
    //   1457: astore 17
    //   1459: aload 16
    //   1461: ldc_w 610
    //   1464: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: aload 17
    //   1469: getfield 613	PersonalState/HotRishState:iActId	I
    //   1472: invokevirtual 616	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1475: ldc_w 618
    //   1478: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: aload 17
    //   1483: getfield 621	PersonalState/HotRishState:iDataId	I
    //   1486: invokevirtual 616	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1489: pop
    //   1490: goto -51 -> 1439
    //   1493: aload 15
    //   1495: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1498: invokevirtual 606	java/util/ArrayList:size	()I
    //   1501: invokestatic 626	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1504: astore_2
    //   1505: goto -107 -> 1398
    //   1508: ldc_w 328
    //   1511: iconst_2
    //   1512: aload 16
    //   1514: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1517: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1520: new 152	java/util/ArrayList
    //   1523: dup
    //   1524: bipush 6
    //   1526: invokespecial 447	java/util/ArrayList:<init>	(I)V
    //   1529: astore_2
    //   1530: aload 15
    //   1532: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1535: ifnull +208 -> 1743
    //   1538: aload 15
    //   1540: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1543: invokevirtual 606	java/util/ArrayList:size	()I
    //   1546: ifle +197 -> 1743
    //   1549: aload 13
    //   1551: ifnull +82 -> 1633
    //   1554: aload 13
    //   1556: invokevirtual 628	com/tencent/mobileqq/richstatus/StatusManager:a	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1559: astore 16
    //   1561: aload 15
    //   1563: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1566: invokevirtual 606	java/util/ArrayList:size	()I
    //   1569: iconst_1
    //   1570: isub
    //   1571: istore_3
    //   1572: iload_3
    //   1573: iflt +60 -> 1633
    //   1576: aload 15
    //   1578: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1581: iload_3
    //   1582: invokevirtual 631	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1585: checkcast 608	PersonalState/HotRishState
    //   1588: astore 17
    //   1590: aload 17
    //   1592: getfield 613	PersonalState/HotRishState:iActId	I
    //   1595: aload 16
    //   1597: getfield 633	com/tencent/mobileqq/richstatus/RichStatus:b	I
    //   1600: if_icmpne +26 -> 1626
    //   1603: aload 17
    //   1605: getfield 621	PersonalState/HotRishState:iDataId	I
    //   1608: aload 16
    //   1610: getfield 635	com/tencent/mobileqq/richstatus/RichStatus:jdField_c_of_type_Int	I
    //   1613: if_icmpne +13 -> 1626
    //   1616: aload 15
    //   1618: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1621: iload_3
    //   1622: invokevirtual 638	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   1625: pop
    //   1626: iload_3
    //   1627: iconst_1
    //   1628: isub
    //   1629: istore_3
    //   1630: goto -58 -> 1572
    //   1633: iconst_0
    //   1634: istore_3
    //   1635: iload_3
    //   1636: bipush 6
    //   1638: if_icmpge +24 -> 1662
    //   1641: aload_2
    //   1642: aload 15
    //   1644: getfield 598	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1647: iload_3
    //   1648: invokevirtual 631	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1651: invokevirtual 190	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1654: pop
    //   1655: iload_3
    //   1656: iconst_1
    //   1657: iadd
    //   1658: istore_3
    //   1659: goto -24 -> 1635
    //   1662: new 567	java/lang/StringBuilder
    //   1665: dup
    //   1666: invokespecial 568	java/lang/StringBuilder:<init>	()V
    //   1669: astore 15
    //   1671: aload_2
    //   1672: invokevirtual 161	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1675: astore 16
    //   1677: aload 16
    //   1679: invokeinterface 167 1 0
    //   1684: ifeq +49 -> 1733
    //   1687: aload 16
    //   1689: invokeinterface 171 1 0
    //   1694: checkcast 608	PersonalState/HotRishState
    //   1697: astore 17
    //   1699: aload 15
    //   1701: aload 17
    //   1703: getfield 613	PersonalState/HotRishState:iActId	I
    //   1706: invokevirtual 616	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1709: ldc_w 618
    //   1712: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: aload 17
    //   1717: getfield 621	PersonalState/HotRishState:iDataId	I
    //   1720: invokevirtual 616	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1723: ldc_w 640
    //   1726: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: pop
    //   1730: goto -53 -> 1677
    //   1733: aload 13
    //   1735: aload 15
    //   1737: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1740: invokevirtual 642	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;)V
    //   1743: aload 14
    //   1745: ldc 67
    //   1747: aload_2
    //   1748: invokevirtual 437	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1751: goto -1655 -> 96
    //   1754: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1757: ifeq +13 -> 1770
    //   1760: ldc_w 328
    //   1763: iconst_2
    //   1764: ldc_w 644
    //   1767: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1770: iconst_0
    //   1771: istore 8
    //   1773: goto -1677 -> 96
    //   1776: iload 8
    //   1778: ifeq -1682 -> 96
    //   1781: new 255	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1784: dup
    //   1785: invokespecial 256	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1788: astore 13
    //   1790: aload 13
    //   1792: aload_2
    //   1793: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1796: invokestatic 556	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   1799: invokevirtual 394	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1802: checkcast 255	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1805: astore_2
    //   1806: iload 8
    //   1808: istore 9
    //   1810: aload_2
    //   1811: ifnull +77 -> 1888
    //   1814: iload 8
    //   1816: istore 9
    //   1818: aload_2
    //   1819: getfield 559	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1822: invokevirtual 562	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1825: ifeq +63 -> 1888
    //   1828: aload_2
    //   1829: getfield 559	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1832: invokevirtual 564	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1835: ifne +66 -> 1901
    //   1838: aload_2
    //   1839: getfield 302	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1842: invokevirtual 397	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1845: invokevirtual 398	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1848: invokestatic 384	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1851: astore_2
    //   1852: aload_2
    //   1853: invokevirtual 401	java/nio/ByteBuffer:get	()B
    //   1856: ifne +39 -> 1895
    //   1859: aload 14
    //   1861: ldc 73
    //   1863: aload_2
    //   1864: invokevirtual 306	java/nio/ByteBuffer:array	()[B
    //   1867: invokevirtual 581	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1870: aload 14
    //   1872: ldc 70
    //   1874: aload_1
    //   1875: ldc 70
    //   1877: iconst_0
    //   1878: invokevirtual 352	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1881: invokevirtual 520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1884: iload 8
    //   1886: istore 9
    //   1888: iload 9
    //   1890: istore 8
    //   1892: goto -1796 -> 96
    //   1895: iconst_0
    //   1896: istore 9
    //   1898: goto -10 -> 1888
    //   1901: iconst_0
    //   1902: istore 9
    //   1904: goto -16 -> 1888
    //   1907: astore_2
    //   1908: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1911: ifeq +33 -> 1944
    //   1914: ldc_w 414
    //   1917: iconst_2
    //   1918: new 567	java/lang/StringBuilder
    //   1921: dup
    //   1922: invokespecial 568	java/lang/StringBuilder:<init>	()V
    //   1925: ldc_w 570
    //   1928: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: aload_2
    //   1932: invokevirtual 575	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   1935: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1938: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1941: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1944: iconst_0
    //   1945: istore 9
    //   1947: goto -59 -> 1888
    //   1950: iload 8
    //   1952: ifeq -1856 -> 96
    //   1955: aload_2
    //   1956: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1959: arraylength
    //   1960: iconst_4
    //   1961: isub
    //   1962: istore_3
    //   1963: iload_3
    //   1964: newarray byte
    //   1966: astore 13
    //   1968: aload 13
    //   1970: iconst_0
    //   1971: aload_2
    //   1972: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1975: iconst_4
    //   1976: iload_3
    //   1977: invokestatic 649	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   1980: new 651	com/tencent/pb/signature/SigActPb$RspBody
    //   1983: dup
    //   1984: invokespecial 652	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   1987: astore_2
    //   1988: aload_2
    //   1989: aload 13
    //   1991: invokevirtual 653	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1994: pop
    //   1995: aload_2
    //   1996: getfield 657	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1999: invokevirtual 660	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2002: istore_3
    //   2003: iload_3
    //   2004: ifne +55 -> 2059
    //   2007: aload_2
    //   2008: getfield 664	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   2011: getfield 669	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2014: invokevirtual 397	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2017: invokevirtual 398	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2020: invokestatic 384	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2023: astore_2
    //   2024: aload_2
    //   2025: invokevirtual 401	java/nio/ByteBuffer:get	()B
    //   2028: ifne +283 -> 2311
    //   2031: aload 14
    //   2033: ldc 73
    //   2035: aload_2
    //   2036: invokevirtual 306	java/nio/ByteBuffer:array	()[B
    //   2039: invokevirtual 581	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   2042: aload 14
    //   2044: ldc 70
    //   2046: aload_1
    //   2047: ldc 70
    //   2049: iconst_0
    //   2050: invokevirtual 352	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2053: invokevirtual 520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2056: goto +252 -> 2308
    //   2059: iconst_0
    //   2060: istore 8
    //   2062: aload 14
    //   2064: ldc 76
    //   2066: iload_3
    //   2067: invokevirtual 520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2070: goto +238 -> 2308
    //   2073: astore_2
    //   2074: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2077: ifeq +33 -> 2110
    //   2080: ldc_w 414
    //   2083: iconst_2
    //   2084: new 567	java/lang/StringBuilder
    //   2087: dup
    //   2088: invokespecial 568	java/lang/StringBuilder:<init>	()V
    //   2091: ldc_w 570
    //   2094: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2097: aload_2
    //   2098: invokevirtual 417	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2101: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2107: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2110: iconst_0
    //   2111: istore 8
    //   2113: goto -2017 -> 96
    //   2116: iload 8
    //   2118: ifeq -2022 -> 96
    //   2121: new 255	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2124: dup
    //   2125: invokespecial 256	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2128: astore 13
    //   2130: aload 13
    //   2132: aload_2
    //   2133: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2136: invokestatic 556	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   2139: invokevirtual 394	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2142: checkcast 255	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2145: astore_2
    //   2146: iload 8
    //   2148: istore 9
    //   2150: aload_2
    //   2151: ifnull +55 -> 2206
    //   2154: iload 8
    //   2156: istore 9
    //   2158: aload_2
    //   2159: getfield 559	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2162: invokevirtual 562	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2165: ifeq +41 -> 2206
    //   2168: aload_2
    //   2169: getfield 559	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2172: invokevirtual 564	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2175: ifne +44 -> 2219
    //   2178: aload_2
    //   2179: getfield 302	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2182: invokevirtual 397	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2185: invokevirtual 398	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2188: invokestatic 384	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2191: invokevirtual 401	java/nio/ByteBuffer:get	()B
    //   2194: istore_3
    //   2195: iload_3
    //   2196: ifne +17 -> 2213
    //   2199: iconst_1
    //   2200: istore 8
    //   2202: iload 8
    //   2204: istore 9
    //   2206: iload 9
    //   2208: istore 8
    //   2210: goto -2114 -> 96
    //   2213: iconst_0
    //   2214: istore 8
    //   2216: goto -14 -> 2202
    //   2219: iconst_0
    //   2220: istore 9
    //   2222: goto -16 -> 2206
    //   2225: astore_2
    //   2226: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2229: ifeq +33 -> 2262
    //   2232: ldc_w 414
    //   2235: iconst_2
    //   2236: new 567	java/lang/StringBuilder
    //   2239: dup
    //   2240: invokespecial 568	java/lang/StringBuilder:<init>	()V
    //   2243: ldc_w 570
    //   2246: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: aload_2
    //   2250: invokevirtual 575	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   2253: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2259: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2262: iconst_0
    //   2263: istore 9
    //   2265: goto -59 -> 2206
    //   2268: iload_3
    //   2269: ifeq -2063 -> 206
    //   2272: iconst_0
    //   2273: istore 8
    //   2275: iload 9
    //   2277: istore 10
    //   2279: iload 8
    //   2281: istore 9
    //   2283: goto -2093 -> 190
    //   2286: iconst_0
    //   2287: istore 9
    //   2289: goto -21 -> 2268
    //   2292: iload_3
    //   2293: iconst_1
    //   2294: iadd
    //   2295: istore_3
    //   2296: goto -1848 -> 448
    //   2299: iconst_0
    //   2300: istore 9
    //   2302: goto -1885 -> 417
    //   2305: goto -2209 -> 96
    //   2308: goto -2212 -> 96
    //   2311: iconst_0
    //   2312: istore 8
    //   2314: goto -6 -> 2308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2317	0	this	StatusServlet
    //   0	2317	1	paramIntent	Intent
    //   0	2317	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   168	2128	3	i1	int
    //   398	795	4	i2	int
    //   7	211	5	i3	int
    //   422	742	6	i4	int
    //   499	631	7	i5	int
    //   13	2300	8	bool1	boolean
    //   185	2116	9	bool2	boolean
    //   194	2084	10	bool3	boolean
    //   174	636	11	l1	long
    //   27	2104	13	localObject1	Object
    //   42	2021	14	localBundle	android.os.Bundle
    //   330	1406	15	localObject2	Object
    //   461	1227	16	localObject3	Object
    //   478	1238	17	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   111	184	236	java/lang/Exception
    //   190	199	236	java/lang/Exception
    //   220	229	236	java/lang/Exception
    //   264	414	586	java/lang/Exception
    //   417	446	586	java/lang/Exception
    //   454	515	586	java/lang/Exception
    //   525	572	586	java/lang/Exception
    //   572	583	586	java/lang/Exception
    //   614	668	586	java/lang/Exception
    //   673	712	586	java/lang/Exception
    //   712	733	586	java/lang/Exception
    //   733	755	586	java/lang/Exception
    //   760	779	586	java/lang/Exception
    //   782	800	586	java/lang/Exception
    //   805	830	586	java/lang/Exception
    //   833	925	934	java/lang/Exception
    //   955	971	1061	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   997	1018	1217	java/lang/Exception
    //   1022	1029	1217	java/lang/Exception
    //   1039	1054	1217	java/lang/Exception
    //   1111	1118	1217	java/lang/Exception
    //   1132	1156	1217	java/lang/Exception
    //   1168	1176	1217	java/lang/Exception
    //   1179	1197	1217	java/lang/Exception
    //   1206	1214	1217	java/lang/Exception
    //   1790	1806	1907	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1818	1884	1907	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1955	2003	2073	java/lang/Exception
    //   2007	2056	2073	java/lang/Exception
    //   2062	2070	2073	java/lang/Exception
    //   2130	2146	2225	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2158	2195	2225	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i1 = 0;
    Object localObject1 = (QQAppInterface)getAppRuntime();
    int i2 = paramIntent.getIntExtra("k_cmd", 0);
    Object localObject2;
    Object localObject3;
    switch (i2)
    {
    default: 
      paramIntent = null;
    case 2: 
    case 1: 
    case 4: 
      for (;;)
      {
        if (paramIntent != null) {
          paramPacket.setSSOCommand(paramIntent);
        }
        return;
        paramPacket.setTimeout(10000L);
        localObject1 = paramIntent.getStringExtra("k_uin");
        if (i2 == 2) {}
        for (boolean bool = true;; bool = false)
        {
          paramPacket.putSendData(a(bool, paramIntent.getBooleanExtra("k_sync_ss", false), Long.parseLong((String)localObject1)));
          paramIntent = "OidbSvc.0x515_2";
          break;
        }
        localObject1 = "OidbSvc.0x53f_2";
        localObject2 = paramIntent.getStringExtra("k_uin");
        i1 = paramIntent.getIntExtra("k_end_time", 2147483647);
        i2 = paramIntent.getIntExtra("k_start_time", 0);
        paramPacket.putSendData(a(Long.parseLong((String)localObject2), Integer.valueOf(i2).intValue(), Integer.valueOf(i1).intValue()));
        paramIntent = (Intent)localObject1;
      }
    case 3: 
      localObject2 = new ReqGetSameStateList();
      ((ReqGetSameStateList)localObject2).oHead = new BusiReqHead();
      ((ReqGetSameStateList)localObject2).vCookie = paramIntent.getByteArrayExtra("k_cookie");
      if (((ReqGetSameStateList)localObject2).vCookie == null) {
        ((ReqGetSameStateList)localObject2).vCookie = new byte[0];
      }
      localObject3 = new RichStatus("");
      ((RichStatus)localObject3).jdField_c_of_type_JavaLangString = "foo";
      ((RichStatus)localObject3).b = paramIntent.getIntExtra("k_action", 0);
      ((RichStatus)localObject3).d = "foo";
      ((RichStatus)localObject3).jdField_c_of_type_Int = paramIntent.getIntExtra("k_data", 0);
      ((ReqGetSameStateList)localObject2).oSelfRishState = new stRishState(((RichStatus)localObject3).a(), 0L);
      localObject3 = ((FriendsManager)((QQAppInterface)localObject1).getManager(49)).a(((QQAppInterface)localObject1).a());
      if (localObject3 != null) {
        if (((Card)localObject3).shGender != 0) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        ((ReqGetSameStateList)localObject2).eSelfSex = i1;
        ((ReqGetSameStateList)localObject2).iPageSize = 50;
        ((ReqGetSameStateList)localObject2).oLbsInfo = a((QQAppInterface)localObject1);
        ((ReqGetSameStateList)localObject2).eFetchSex = paramIntent.getIntExtra("k_fetch_sex", -1);
        paramIntent = paramIntent.getStringExtra("k_uin");
        if (!TextUtils.isEmpty(paramIntent)) {}
        try
        {
          ((ReqGetSameStateList)localObject2).lFriendUin = Long.parseLong(paramIntent);
          paramPacket.setServantName("PersonalStateSvc");
          paramPacket.setFuncName("ReqGetSameStateList");
          paramPacket.addRequestPacket("ReqGetSameStateList", (JceStruct)localObject2);
          paramIntent = "PersonalStateSvc.ReqGetSameStateList";
          break;
          if (((Card)localObject3).shGender != 1) {
            break label939;
          }
          i1 = 1;
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
        }
      }
      localObject1 = "OidbSvc.0x54f_0";
      localObject2 = paramIntent.getByteArrayExtra("k_status_key");
      i1 = paramIntent.getIntExtra("k_status_flag", 1);
      paramIntent = new ArrayList();
      paramIntent.add(localObject2);
      paramPacket.putSendData(a(paramIntent, (byte)i1));
      paramIntent = (Intent)localObject1;
      break;
      localObject1 = "PersonalStateSvc.ReqGetHotState";
      paramIntent = new ReqGetHotState();
      paramIntent.oHead = new BusiReqHead();
      paramPacket.setServantName("PersonalStateSvc");
      paramPacket.setFuncName("ReqGetHotState");
      paramPacket.addRequestPacket("ReqGetHotState", paramIntent);
      paramIntent = (Intent)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("get_hot_rich_status", 2, "StatusServlet.onSend()");
      paramIntent = (Intent)localObject1;
      break;
      localObject1 = "OidbSvc.0x50f_29";
      paramPacket.putSendData(a(paramIntent.getByteArrayExtra("k_data")));
      paramIntent = (Intent)localObject1;
      break;
      paramIntent = "OidbSvc.0x510_0";
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1296);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.EMPTY);
      localObject1 = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
      localObject2 = ByteBuffer.allocate(localObject1.length + 4);
      ((ByteBuffer)localObject2).putInt(localObject1.length + 4);
      ((ByteBuffer)localObject2).put((byte[])localObject1);
      paramPacket.putSendData(((ByteBuffer)localObject2).array());
      break;
      i1 = paramIntent.getIntExtra("k_tpl_id", 0);
      i2 = paramIntent.getIntExtra("k_sign_len", 2);
      localObject3 = paramIntent.getByteArrayExtra("k_sign_data");
      paramIntent = new SigActPb.Platform();
      paramIntent.implat.set(109L);
      paramIntent.mqqver.set("5.9.3");
      paramIntent.osver.set(DeviceInfoUtil.e());
      localObject2 = new SigActPb.SigauthReq();
      ((SigActPb.SigauthReq)localObject2).uin.set(Long.parseLong(((QQAppInterface)localObject1).a()));
      ((SigActPb.SigauthReq)localObject2).itemid.set(i1);
      ((SigActPb.SigauthReq)localObject2).data.set(ByteStringMicro.copyFrom((byte[])localObject3));
      ((SigActPb.SigauthReq)localObject2).len.set(i2);
      localObject1 = new SigActPb.ReqBody();
      ((SigActPb.ReqBody)localObject1).cmd.set(2);
      ((SigActPb.ReqBody)localObject1).plf.set(paramIntent);
      ((SigActPb.ReqBody)localObject1).auth_req.set((MessageMicro)localObject2);
      ((SigActPb.ReqBody)localObject1).seq.set(System.currentTimeMillis());
      paramIntent = ((SigActPb.ReqBody)localObject1).toByteArray();
      localObject1 = new byte[paramIntent.length + 4];
      PkgTools.a((byte[])localObject1, 0, paramIntent.length + 4);
      PkgTools.a((byte[])localObject1, 4, paramIntent, paramIntent.length);
      paramPacket.putSendData((byte[])localObject1);
      if (QLog.isColorLevel())
      {
        QLog.d("StatusServlet", 2, "Signature.auth");
        paramIntent = "Signature.auth";
        break;
      }
      paramIntent = "Signature.auth";
      break;
      label939:
      i1 = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusServlet
 * JD-Core Version:    0.7.0.1
 */