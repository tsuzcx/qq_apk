package com.tencent.mobileqq.dating;

import android.os.Bundle;
import android.text.TextUtils;
import appoint.define.appoint_define.AddressInfo;
import appoint.define.appoint_define.AppointContent;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.Cell;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.LocaleInfo;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.ShopID;
import appoint.define.appoint_define.TravelInfo;
import appoint.define.appoint_define.Wifi;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.data.PublishDatingOption;
import com.tencent.mobileqq.data.PublishDatingOption.ShopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x5f9.cmd0x5f9.ReqBody;
import tencent.im.oidb.cmd0x5f9.cmd0x5f9.RspBody;
import tencent.im.oidb.cmd0x5fa.ReqBody;
import tencent.im.oidb.cmd0x5fa.RspBody;
import tencent.im.oidb.cmd0x5fc.ReqBody;
import tencent.im.oidb.cmd0x5fc.RspBody;
import tencent.im.oidb.cmd0x5fd.ReqBody;
import tencent.im.oidb.cmd0x5fd.RspBody;
import tencent.im.oidb.cmd0x5fe.ReqBody;
import tencent.im.oidb.cmd0x5fe.RspBody;
import tencent.im.oidb.cmd0x5ff.ReqBody;
import tencent.im.oidb.cmd0x5ff.RspBody;
import tencent.im.oidb.cmd0x7ca.ReqBody;
import tencent.im.oidb.cmd0x7ca.RspBody;
import tencent.im.oidb.cmd0x7cb.DateRequest;
import tencent.im.oidb.cmd0x7cb.ReqBody;
import tencent.im.oidb.cmd0x7cb.RspBody;
import tencent.im.oidb.cmd0x7cd.ReqBody;
import tencent.im.oidb.cmd0x7cd.RspBody;
import tencent.im.oidb.cmd0x7ce.AppintDetail;
import tencent.im.oidb.cmd0x7ce.ReqBody;
import tencent.im.oidb.cmd0x7ce.RspBody;
import tencent.im.oidb.cmd0x7cf.ReqBody;
import tencent.im.oidb.cmd0x7cf.RspBody;
import tencent.im.oidb.cmd0x7da.ReqBody;
import tencent.im.oidb.cmd0x7da.RspBody;
import tencent.im.oidb.cmd0x7db.ReqBody;
import tencent.im.oidb.cmd0x7db.RspBody;
import tencent.im.oidb.cmd0x7dc.ReqBody;
import tencent.im.oidb.cmd0x7dc.RspBody;
import tencent.im.oidb.cmd0x7de.BusiReqHead;
import tencent.im.oidb.cmd0x7de.BusiRespHead;
import tencent.im.oidb.cmd0x7de.ReqBody;
import tencent.im.oidb.cmd0x7de.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class DatingHandler
  extends BusinessHandler
{
  private static final int a = 40493;
  public static final String a = "appoint_id";
  private static final int b = 1;
  public static final String b = "appoint_ids";
  private static final int c = 2;
  public static final String c = "appoint_action";
  public static final String d = "open_id";
  public static final String e = "filter_time";
  public static final String f = "filter_subject";
  public static final String g = "filter_gender";
  public static final String h = "filter_lowage";
  public static final String i = "filter_upage";
  public static final String j = "filter_profession";
  public static final String k = "filter_dest";
  public static final String l = "public_subject";
  public static final String m = "public_type";
  public static final String n = "public_time";
  public static final String o = "public_gender";
  public static final String p = "public_introduce";
  public static final String q = "public_zone";
  public static final String r = "public_addr_name";
  public static final String s = "public_addr";
  public static final String t = "public_shop_pic_url";
  public static final String u = "public_shop_url";
  public static final String v = "download_type";
  public static final String w = "session_switch_value";
  public static final String x = "refer_idx";
  public static final String y = "date_comment_id";
  public static final String z = "last_from";
  
  public DatingHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  /* Error */
  public static int a(FromServiceMsg paramFromServiceMsg, Object paramObject, MessageMicro paramMessageMicro)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   7: istore_3
    //   8: invokestatic 107	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   11: ifeq +233 -> 244
    //   14: new 109	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   21: astore 4
    //   23: iload_3
    //   24: sipush 1000
    //   27: if_icmpne +190 -> 217
    //   30: aload_1
    //   31: ifnull +145 -> 176
    //   34: new 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   37: dup
    //   38: invokespecial 115	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   41: astore_0
    //   42: aload_0
    //   43: aload_1
    //   44: checkcast 117	[B
    //   47: checkcast 117	[B
    //   50: invokevirtual 121	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   53: checkcast 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: aload_0
    //   60: ifnull +181 -> 241
    //   63: aload_0
    //   64: getfield 125	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   67: invokevirtual 130	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   70: istore_3
    //   71: aload_0
    //   72: ifnull +42 -> 114
    //   75: aload_0
    //   76: getfield 134	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   79: invokevirtual 139	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   82: ifeq +32 -> 114
    //   85: aload_0
    //   86: getfield 134	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   89: invokevirtual 142	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   92: ifnull +22 -> 114
    //   95: aload_2
    //   96: ifnull +18 -> 114
    //   99: aload_2
    //   100: aload_0
    //   101: getfield 134	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   104: invokevirtual 142	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   107: invokevirtual 148	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   110: invokevirtual 151	com/tencent/mobileqq/pb/MessageMicro:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   113: pop
    //   114: aload 4
    //   116: ifnull +28 -> 144
    //   119: aload 4
    //   121: invokevirtual 154	java/lang/StringBuilder:length	()I
    //   124: ifle +20 -> 144
    //   127: invokestatic 107	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   130: ifeq +14 -> 144
    //   133: ldc 156
    //   135: iconst_4
    //   136: aload 4
    //   138: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: iload_3
    //   145: ireturn
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: aload 4
    //   151: ifnull +18 -> 169
    //   154: aload 4
    //   156: ldc 165
    //   158: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_1
    //   162: invokevirtual 170	java/lang/Exception:toString	()Ljava/lang/String;
    //   165: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   173: goto -114 -> 59
    //   176: aload 5
    //   178: astore_0
    //   179: aload 4
    //   181: ifnull -122 -> 59
    //   184: aload 4
    //   186: ldc 175
    //   188: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: astore_0
    //   195: goto -136 -> 59
    //   198: astore_0
    //   199: aload 4
    //   201: ifnull -87 -> 114
    //   204: aload 4
    //   206: aload_0
    //   207: invokevirtual 170	java/lang/Exception:toString	()Ljava/lang/String;
    //   210: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: goto -100 -> 114
    //   217: aload 4
    //   219: ifnull +15 -> 234
    //   222: aload 4
    //   224: ldc 177
    //   226: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload_3
    //   230: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: goto -120 -> 114
    //   237: astore_1
    //   238: goto -89 -> 149
    //   241: goto -170 -> 71
    //   244: aconst_null
    //   245: astore 4
    //   247: goto -224 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramFromServiceMsg	FromServiceMsg
    //   0	250	1	paramObject	Object
    //   0	250	2	paramMessageMicro	MessageMicro
    //   7	223	3	i1	int
    //   21	225	4	localStringBuilder	java.lang.StringBuilder
    //   1	192	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	42	146	java/lang/Exception
    //   99	114	198	java/lang/Exception
    //   42	57	237	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("appoint_id");
    int i2 = paramToServiceMsg.extraData.getInt("refer_idx");
    int i3 = paramToServiceMsg.extraData.getInt("appoint_action");
    cmd0x5fa.RspBody localRspBody = new cmd0x5fa.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool = false;
    paramFromServiceMsg = null;
    paramObject = null;
    paramToServiceMsg = null;
    int i4;
    int i5;
    if (i1 == 0)
    {
      paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
      if (paramToServiceMsg != null) {
        break label369;
      }
      paramToServiceMsg = null;
      paramFromServiceMsg = paramObject;
      if (localRspBody.rpt_msg_stranger_info.has())
      {
        List localList = localRspBody.rpt_msg_stranger_info.get();
        paramFromServiceMsg = paramObject;
        if (localList != null)
        {
          paramFromServiceMsg = paramObject;
          if (!localList.isEmpty()) {
            paramFromServiceMsg = DatingStranger.a(localList);
          }
        }
      }
      i4 = localRspBody.uint32_reach_start.get();
      i5 = localRspBody.uint32_reach_end.get();
      if (paramToServiceMsg != null)
      {
        if (!paramBoolean) {
          break label385;
        }
        i1 = 0;
        label173:
        if (i2 != -1) {
          break label403;
        }
        paramToServiceMsg.addStranger(paramBoolean, true, paramFromServiceMsg, true);
        if (i4 == 0) {
          break label391;
        }
        bool = true;
        label196:
        paramToServiceMsg.setReachOver(i1, true, bool);
        if (i5 == 0) {
          break label397;
        }
      }
    }
    label385:
    label391:
    label397:
    for (bool = true;; bool = false)
    {
      paramToServiceMsg.setReachOver(i1, false, bool);
      if (QLog.isColorLevel()) {
        QLog.e("Q.dating.detail", 2, "handle getStranger is visitor :" + paramBoolean + " over is: " + i4 + " " + i5);
      }
      bool = true;
      a(17, bool, new Object[] { Boolean.valueOf(paramBoolean), str, Integer.valueOf(i3), Integer.valueOf(i2), paramToServiceMsg });
      DatingUtil.a("handleGetDatingStrangers", new Object[] { Boolean.valueOf(paramBoolean), str, Integer.valueOf(i3), Integer.valueOf(i2), paramFromServiceMsg });
      return;
      label369:
      paramToServiceMsg = paramToServiceMsg.a().a(str, true, true, true);
      break;
      i1 = 2;
      break label173;
      bool = false;
      break label196;
    }
    label403:
    if (i3 == 1)
    {
      paramToServiceMsg.addStranger(paramBoolean, true, paramFromServiceMsg, false);
      if (i4 != 0) {}
      for (bool = true;; bool = false)
      {
        paramToServiceMsg.setReachOver(i1, true, bool);
        break;
      }
    }
    if (i3 == 2)
    {
      paramToServiceMsg.addStranger(paramBoolean, false, paramFromServiceMsg, false);
      if (i5 != 0) {}
      for (bool = true;; bool = false)
      {
        paramToServiceMsg.setReachOver(i1, false, bool);
        break;
      }
    }
    if (paramBoolean)
    {
      paramToServiceMsg.addStranger(paramBoolean, true, paramFromServiceMsg, true);
      if (i4 != 0)
      {
        bool = true;
        label507:
        paramToServiceMsg.setReachOver(i1, true, bool);
        if (i5 == 0) {
          break label542;
        }
      }
      label542:
      for (bool = true;; bool = false)
      {
        paramToServiceMsg.setReachOver(i1, false, bool);
        break;
        bool = false;
        break label507;
      }
    }
    if ((!paramToServiceMsg.isGetList) && (paramToServiceMsg.lastFrom == 2147483647)) {
      paramToServiceMsg.lastFrom = 1006;
    }
    if ((!paramToServiceMsg.isGetList) && (paramToServiceMsg.isInit) && (paramToServiceMsg.isCanMerge(i1, false, paramFromServiceMsg)))
    {
      paramToServiceMsg.addStranger(paramBoolean, false, paramFromServiceMsg, false);
      if (i5 != 0) {}
      for (bool = true;; bool = false)
      {
        paramToServiceMsg.setReachOver(i1, false, bool);
        paramToServiceMsg.isGetList = true;
        break;
      }
    }
    paramToServiceMsg.addStranger(paramBoolean, true, paramFromServiceMsg, true);
    if (i4 != 0)
    {
      bool = true;
      label654:
      paramToServiceMsg.setReachOver(i1, true, bool);
      if (i5 == 0) {
        break label689;
      }
    }
    label689:
    for (bool = true;; bool = false)
    {
      paramToServiceMsg.setReachOver(i1, false, bool);
      break;
      bool = false;
      break label654;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    Object localObject = new cmd0x7ce.RspBody();
    int i5 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool2;
    if (i5 == 0)
    {
      bool2 = true;
      paramFromServiceMsg = paramObject;
      bool1 = bool2;
      if (((cmd0x7ce.RspBody)localObject).rpt_msg_appoints_info.has())
      {
        paramFromServiceMsg = ((cmd0x7ce.RspBody)localObject).rpt_msg_appoints_info.get();
        bool1 = bool2;
      }
    }
    paramObject = paramToServiceMsg.extraData.getString("appoint_id");
    int i3 = paramToServiceMsg.extraData.getInt("last_from");
    cmd0x7ce.AppintDetail localAppintDetail = DatingUtil.a(paramFromServiceMsg, paramObject);
    int i2 = 0;
    localObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
    int i1 = i2;
    if (localAppintDetail != null)
    {
      i1 = i2;
      if (localAppintDetail.uint32_limited.has()) {
        i1 = localAppintDetail.uint32_limited.get();
      }
    }
    label318:
    label456:
    label477:
    int i4;
    if (localObject == null)
    {
      paramToServiceMsg = null;
      if ((!bool1) || (localAppintDetail == null) || (paramToServiceMsg == null)) {
        break label859;
      }
      paramFromServiceMsg = paramToServiceMsg.a(DatingUtil.a(localAppintDetail), true, true, true);
      DatingUtil.a(paramFromServiceMsg, localAppintDetail);
      paramToServiceMsg.a(paramFromServiceMsg, 3);
      if (paramFromServiceMsg != null)
      {
        paramToServiceMsg = null;
        if (localAppintDetail.rpt_msg_stranger_info.has()) {
          paramToServiceMsg = DatingStranger.a(localAppintDetail.rpt_msg_stranger_info.get());
        }
        if ((paramFromServiceMsg.isInit) || (!paramFromServiceMsg.isGetList) || (i3 != 1006)) {
          break label644;
        }
        if (paramFromServiceMsg.isCanMerge(2, true, paramToServiceMsg))
        {
          paramFromServiceMsg.addStranger(false, true, paramToServiceMsg, false);
          paramFromServiceMsg.setReachOver(2, true, true);
        }
        paramToServiceMsg = null;
        if (localAppintDetail.rpt_msg_vistor_info.has()) {
          paramToServiceMsg = DatingStranger.a(localAppintDetail.rpt_msg_vistor_info.get());
        }
        paramFromServiceMsg.addStranger(true, true, paramToServiceMsg, true);
        paramFromServiceMsg.setReachOver(0, true, true);
        if (localAppintDetail.uint32_view_over.get() == 0) {
          break label690;
        }
        bool2 = true;
        paramFromServiceMsg.setReachOver(0, false, bool2);
        paramToServiceMsg = null;
        if (localAppintDetail.rpt_msg_comment_list.has()) {
          paramToServiceMsg = DatingComment.a(localAppintDetail.rpt_msg_comment_list.get());
        }
        if ((paramFromServiceMsg.isInit) || (!paramFromServiceMsg.isGetList) || (i3 != 1007)) {
          break label696;
        }
        if (paramFromServiceMsg.isCanMerge(1, true, paramToServiceMsg))
        {
          paramFromServiceMsg.addDatingComment(true, paramToServiceMsg, false);
          paramFromServiceMsg.setReachOver(1, true, true);
        }
        paramFromServiceMsg.isInit = true;
        long l2 = NetConnInfoCenter.getServerTimeMillis();
        long l1 = l2;
        if (l2 == 0L) {
          l1 = System.currentTimeMillis();
        }
        paramFromServiceMsg.lastUpdateTime = l1;
      }
      if (QLog.isColorLevel())
      {
        if (!localAppintDetail.uint32_view_over.has()) {
          break label741;
        }
        i2 = localAppintDetail.uint32_view_over.get();
        if (!localAppintDetail.uint32_comment_over.has()) {
          break label747;
        }
        i3 = localAppintDetail.uint32_comment_over.get();
        if (!localAppintDetail.uint32_join_over.has()) {
          break label753;
        }
        i4 = localAppintDetail.uint32_join_over.get();
        label498:
        QLog.i("Q.dating.detail", 2, "handle_oidb_0x7ce_0 limit is: " + i1 + " over is: " + i2 + " " + i3 + " " + i4);
      }
    }
    label644:
    label690:
    label696:
    label856:
    label859:
    for (paramToServiceMsg = paramFromServiceMsg;; paramToServiceMsg = null)
    {
      if (i1 != 0) {}
      for (;;)
      {
        a(4, bool1, new Object[] { paramObject, paramToServiceMsg, Integer.valueOf(i1) });
        DatingUtil.a("handle_oidb_0x7ce_0", new Object[] { Integer.valueOf(i5), Boolean.valueOf(bool1), paramObject, paramToServiceMsg, Integer.valueOf(i1) });
        return;
        paramToServiceMsg = ((DatingManager)localObject).a();
        break;
        paramFromServiceMsg.addStranger(false, true, paramToServiceMsg, true);
        paramFromServiceMsg.setReachOver(2, true, true);
        if (localAppintDetail.uint32_join_over.get() != 0) {}
        for (bool2 = true;; bool2 = false)
        {
          paramFromServiceMsg.setReachOver(2, false, bool2);
          break;
        }
        bool2 = false;
        break label318;
        paramFromServiceMsg.addDatingComment(true, paramToServiceMsg, true);
        paramFromServiceMsg.setReachOver(1, true, true);
        if (localAppintDetail.uint32_comment_over.get() != 0) {}
        for (bool2 = true;; bool2 = false)
        {
          paramFromServiceMsg.setReachOver(1, false, bool2);
          break;
        }
        label741:
        i2 = -1;
        break label456;
        label747:
        i3 = -1;
        break label477;
        label753:
        i4 = -1;
        break label498;
        if (paramToServiceMsg == null)
        {
          if (((DatingManager)localObject).a().a(1, paramObject).booleanValue()) {
            i1 = 2;
          } else if (((DatingManager)localObject).a().a(2, paramObject).booleanValue()) {
            i1 = 2;
          }
        }
        else
        {
          if ((paramToServiceMsg != null) && (paramToServiceMsg.owner == 1)) {}
          for (i2 = 1;; i2 = 2)
          {
            if (!((DatingManager)localObject).a().a(i2, paramObject).booleanValue()) {
              break label856;
            }
            i1 = 2;
            paramToServiceMsg.nLimit = 2;
            break;
          }
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    cmd0x5f9.RspBody localRspBody = new cmd0x5f9.RspBody();
    if (a(paramFromServiceMsg, paramObject, localRspBody) == 0) {
      if (localRspBody.rpt_msg_district == null) {
        break label174;
      }
    }
    label174:
    for (paramToServiceMsg = localRspBody.rpt_msg_district.get();; paramToServiceMsg = null)
    {
      if (localRspBody.rpt_msg_poi != null) {}
      for (paramFromServiceMsg = localRspBody.rpt_msg_poi.get();; paramFromServiceMsg = null)
      {
        paramObject = localObject1;
        if (localRspBody.bytes_cookie != null) {
          paramObject = localRspBody.bytes_cookie.get();
        }
        boolean bool1;
        boolean bool2;
        if (localRspBody.uint32_ended != null) {
          if (localRspBody.uint32_ended.get() == 1)
          {
            bool1 = true;
            bool2 = true;
          }
        }
        for (;;)
        {
          a(22, bool2, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject, Boolean.valueOf(bool1) });
          return;
          bool1 = false;
          break;
          bool1 = false;
          paramFromServiceMsg = null;
          paramToServiceMsg = null;
          bool2 = false;
          paramObject = localObject2;
          continue;
          bool1 = false;
          bool2 = true;
        }
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    Object localObject1 = new cmd0x7da.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (i1 == 0)
    {
      bool = true;
      if (!((cmd0x7da.RspBody)localObject1).rpt_msg_appoint_info.has()) {
        break label346;
      }
      paramFromServiceMsg = ((cmd0x7da.RspBody)localObject1).rpt_msg_appoint_info.get();
      paramObject = null;
      bool = true;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("appoint_ids");
      localObject1 = null;
      DatingManager localDatingManager = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
      paramToServiceMsg = (ToServiceMsg)localObject1;
      if (localDatingManager != null)
      {
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (paramFromServiceMsg != null)
        {
          paramToServiceMsg = (ToServiceMsg)localObject1;
          if (paramFromServiceMsg.size() > 0)
          {
            paramToServiceMsg = new ArrayList(paramFromServiceMsg.size());
            localObject1 = paramFromServiceMsg.iterator();
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = (appoint_define.AppointInfo)((Iterator)localObject1).next();
                localObject2 = localDatingManager.a().a((appoint_define.AppointInfo)localObject2);
                if (localObject2 != null)
                {
                  paramToServiceMsg.add(localObject2);
                  continue;
                  if (!((cmd0x7da.RspBody)localObject1).str_wording.has()) {
                    break label346;
                  }
                  paramObject = ((cmd0x7da.RspBody)localObject1).str_wording.get();
                  bool = false;
                  paramFromServiceMsg = null;
                  break;
                }
              }
            }
          }
        }
      }
      if ((i2 == 0) && (bool) && (localDatingManager != null))
      {
        localObject1 = localDatingManager.d();
        if ((localArrayList != null) && (localArrayList.contains(localObject1))) {
          localDatingManager.a(null);
        }
      }
      a(6, bool, new Object[] { Integer.valueOf(i2), localArrayList, paramToServiceMsg, paramObject });
      DatingUtil.a("handle_0x7da_0", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), localArrayList, paramFromServiceMsg, paramObject });
      return;
      label346:
      paramObject = null;
      paramFromServiceMsg = null;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x7da.RspBody localRspBody = new cmd0x7da.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (i1 == 0)
    {
      paramFromServiceMsg = null;
      bool = true;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("appoint_ids");
      ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67)).a(1, false, paramToServiceMsg, bool);
      a(13, bool, new Object[] { Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      DatingUtil.a("handle_0x7da_1", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      return;
      if (localRspBody.str_wording.has())
      {
        paramFromServiceMsg = localRspBody.str_wording.get();
        bool = false;
      }
      else
      {
        paramFromServiceMsg = null;
        bool = false;
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x7da.RspBody localRspBody = new cmd0x7da.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (i1 == 0)
    {
      paramFromServiceMsg = null;
      bool = true;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("appoint_ids");
      paramObject = new ArrayList();
      paramObject.add(paramToServiceMsg);
      ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67)).a(1, true, paramObject, bool);
      a(14, bool, new Object[] { Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      DatingUtil.a("handle_0x7da_2", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      return;
      if (localRspBody.str_wording.has())
      {
        paramFromServiceMsg = localRspBody.str_wording.get();
        bool = false;
      }
      else
      {
        paramFromServiceMsg = null;
        bool = false;
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    cmd0x7db.RspBody localRspBody = new cmd0x7db.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    Object localObject3 = null;
    paramObject = null;
    paramFromServiceMsg = null;
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    int i2;
    if (i1 == 0)
    {
      bool2 = true;
      paramObject = paramFromServiceMsg;
      if (localRspBody.msg_appoint_info.has()) {
        paramObject = (appoint_define.AppointInfo)localRspBody.msg_appoint_info.get();
      }
      paramFromServiceMsg = paramObject;
      localObject1 = localObject4;
      localObject2 = localObject3;
      bool1 = bool2;
      if (localRspBody.bytes_SigC2C.has())
      {
        paramFromServiceMsg = paramObject;
        localObject1 = localObject4;
        localObject2 = localObject3;
        bool1 = bool2;
        if (localRspBody.bytes_SigC2C.get() != null)
        {
          localObject1 = localRspBody.bytes_SigC2C.get().toByteArray();
          bool1 = bool2;
          localObject2 = localObject3;
          paramFromServiceMsg = paramObject;
        }
      }
      i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      paramObject = paramToServiceMsg.extraData.getString("appoint_id");
      if (paramFromServiceMsg == null) {
        break label417;
      }
      paramToServiceMsg = DatingUtil.a(paramFromServiceMsg);
      if (Utils.a(paramToServiceMsg, paramObject)) {
        break label417;
      }
      DatingUtil.a("handle_oidb_0x7db_0", new Object[] { paramObject, paramToServiceMsg });
    }
    label417:
    for (paramToServiceMsg = null;; paramToServiceMsg = paramFromServiceMsg)
    {
      paramFromServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
      if ((bool1) && (paramFromServiceMsg != null)) {
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg = paramFromServiceMsg.a().a(paramToServiceMsg);
          label230:
          if ((localObject1 != null) && (paramToServiceMsg != null)) {
            paramToServiceMsg.detailSigC2C = ((byte[])localObject1);
          }
          if (i2 == 1) {
            paramFromServiceMsg.a().a(paramObject, 2);
          }
        }
      }
      for (;;)
      {
        a(7, bool1, new Object[] { Integer.valueOf(i2), paramObject, paramToServiceMsg, localObject1, localObject2 });
        DatingUtil.a("handle_oidb_0x7db_0", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool1), Integer.valueOf(i2), paramObject, localObject2 });
        return;
        paramFromServiceMsg = paramObject;
        localObject1 = localObject4;
        localObject2 = localObject3;
        bool1 = bool2;
        if (!localRspBody.str_wording.has()) {
          break;
        }
        localObject2 = localRspBody.str_wording.get();
        paramFromServiceMsg = paramObject;
        localObject1 = localObject4;
        bool1 = bool2;
        break;
        if (i2 == 0) {
          paramFromServiceMsg.a().a(paramToServiceMsg, 2);
        }
        continue;
        paramToServiceMsg = null;
        break label230;
        paramToServiceMsg = null;
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x7db.RspBody localRspBody = new cmd0x7db.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (i1 == 0)
    {
      paramFromServiceMsg = null;
      bool = true;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("appoint_id");
      ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67)).a(2, false, paramToServiceMsg, bool);
      a(15, bool, new Object[] { Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      DatingUtil.a("handle_oidb_0x7db_1", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      return;
      if (localRspBody.str_wording.has())
      {
        paramFromServiceMsg = localRspBody.str_wording.get();
        bool = false;
      }
      else
      {
        paramFromServiceMsg = null;
        bool = false;
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x7db.RspBody localRspBody = new cmd0x7db.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (i1 == 0)
    {
      bool = true;
      paramFromServiceMsg = null;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("appoint_id");
      paramObject = new ArrayList();
      paramObject.add(paramToServiceMsg);
      ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67)).a(2, true, paramObject, bool);
      a(16, bool, new Object[] { Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      DatingUtil.a("handle_oidb_0x7db_2", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), paramObject, paramFromServiceMsg });
      return;
      if (localRspBody.str_wording.has())
      {
        paramFromServiceMsg = localRspBody.str_wording.get();
        bool = false;
      }
      else
      {
        bool = false;
        paramFromServiceMsg = null;
      }
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    DatingManager localDatingManager = null;
    Object localObject = new cmd0x7ca.RspBody();
    int i2 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramObject = null;
    long l1 = 0L;
    int i1 = paramToServiceMsg.extraData.getInt("appoint_action");
    boolean bool;
    if (i2 == 0)
    {
      paramFromServiceMsg = localDatingManager;
      if (((cmd0x7ca.RspBody)localObject).bytes_SigC2C.has()) {
        paramFromServiceMsg = ((cmd0x7ca.RspBody)localObject).bytes_SigC2C.get().toByteArray();
      }
      if (((cmd0x7ca.RspBody)localObject).uint64_peer_uin.has()) {
        l1 = ((cmd0x7ca.RspBody)localObject).uint64_peer_uin.get();
      }
      if (!((cmd0x7ca.RspBody)localObject).uint32_op_type.has()) {
        break label368;
      }
      i1 = ((cmd0x7ca.RspBody)localObject).uint32_op_type.get();
      bool = true;
    }
    for (;;)
    {
      long l2 = paramToServiceMsg.extraData.getLong("open_id");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("appoint_id");
      localDatingManager = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
      if ((bool) && (localDatingManager != null))
      {
        if (i1 == 2)
        {
          localObject = localDatingManager.a().a(paramToServiceMsg, true, false, false);
          if ((localObject != null) && (((DatingInfo)localObject).updateJoinListData(l2, 1))) {
            localDatingManager.a().a((DatingInfo)localObject, 3);
          }
        }
        if (paramFromServiceMsg != null) {
          localDatingManager.a().a(paramToServiceMsg, l2, paramFromServiceMsg);
        }
      }
      a(1, bool, new Object[] { Integer.valueOf(i1), Long.valueOf(l2), Long.valueOf(l1), paramToServiceMsg, paramFromServiceMsg, paramObject });
      DatingUtil.a("handle_oidb_0x7ca_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(bool), Integer.valueOf(i1), Long.valueOf(l2), paramToServiceMsg, paramFromServiceMsg, paramObject });
      return;
      if (((cmd0x7ca.RspBody)localObject).str_error_wording.has())
      {
        paramObject = ((cmd0x7ca.RspBody)localObject).str_error_wording.get();
        bool = false;
        paramFromServiceMsg = null;
        l1 = 0L;
      }
      else
      {
        bool = false;
        paramFromServiceMsg = null;
        l1 = 0L;
        continue;
        label368:
        bool = true;
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    Object localObject1 = new cmd0x7dc.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    paramToServiceMsg = null;
    if (i1 == 0)
    {
      if (((cmd0x7dc.RspBody)localObject1).rpt_msg_appoint_info.has()) {
        paramToServiceMsg = ((cmd0x7dc.RspBody)localObject1).rpt_msg_appoint_info.get();
      }
      if (paramToServiceMsg == null) {
        break label401;
      }
      if (paramToServiceMsg.size() > 0)
      {
        bool = true;
        paramObject = "";
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
      }
    }
    for (;;)
    {
      label72:
      paramObject = "";
      if (bool)
      {
        Object localObject2 = (appoint_define.AppointInfo)paramFromServiceMsg.get(0);
        if (localObject2 != null)
        {
          if (((appoint_define.AppointInfo)localObject2).msg_appoint_id.has()) {
            paramObject = DatingUtil.a(((appoint_define.AppointInfo)localObject2).msg_appoint_id);
          }
          localObject1 = new DatingInfo();
          DatingUtil.a((DatingInfo)localObject1, (appoint_define.AppointInfo)localObject2);
          label134:
          localObject2 = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
          ((DatingManager)localObject2).a().a((DatingInfo)localObject1, 1);
          ((DatingManager)localObject2).a(paramObject);
          if ((paramFromServiceMsg.size() > 1) && (paramFromServiceMsg.get(1) != null))
          {
            localObject1 = (appoint_define.AppointInfo)paramFromServiceMsg.get(1);
            paramFromServiceMsg = DatingUtil.a(((appoint_define.AppointInfo)localObject1).msg_appoint_id);
            ((DatingManager)localObject2).a().a((appoint_define.AppointInfo)localObject1);
          }
        }
      }
      for (;;)
      {
        a(8, bool, new Object[] { paramObject, paramFromServiceMsg, paramToServiceMsg });
        if (QLog.isColorLevel()) {
          QLog.d("Q.dating", 2, "result:" + i1 + " isSuccess:" + bool + " new_id:" + paramObject + " old_id:" + paramFromServiceMsg + " errMsg:" + paramToServiceMsg);
        }
        return;
        bool = false;
        break;
        if (((cmd0x7dc.RspBody)localObject1).str_wording.has())
        {
          paramToServiceMsg = ((cmd0x7dc.RspBody)localObject1).str_wording.get();
          paramFromServiceMsg = null;
          break label72;
        }
        if (i1 != 1002) {
          break label392;
        }
        paramFromServiceMsg = null;
        paramToServiceMsg = "约会发布失败，请检查网络链接";
        break label72;
        paramFromServiceMsg = "";
        continue;
        paramObject = "";
        localObject1 = null;
        break label134;
        paramFromServiceMsg = "";
        paramObject = "";
      }
      label392:
      paramFromServiceMsg = null;
      paramToServiceMsg = "";
      continue;
      label401:
      paramObject = "";
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = paramObject;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x7cb.RspBody localRspBody = new cmd0x7cb.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = null;
    if ((i1 == 0) && (localRspBody.uint32_time_stamp.has()) && (localRspBody.uint32_time_gap.has()) && (localRspBody.rpt_comment_configs.has()) && (localRspBody.str_attend_tips_to_A.has()) && (localRspBody.str_first_msg_tips.has()) && (localRspBody.rpt_cancle_config.has()) && (localRspBody.msg_date_request.has()))
    {
      paramToServiceMsg = DatingConfig.createDatingConfig(localRspBody);
      ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67)).a(paramToServiceMsg);
    }
    for (boolean bool = true;; bool = false)
    {
      a(2, bool, new Object[] { paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.d("handle_oidb_0x7cb_0", 2, "result:" + i1 + " isSuccess:" + bool);
      }
      return;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = new cmd0x7de.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
    DatingUtil.a("handleGetDatingFeeds", new Object[] { Integer.valueOf(i1) });
    paramObject = null;
    Object localObject1 = null;
    boolean bool1;
    label118:
    int i2;
    label143:
    label164:
    int i3;
    if (i1 == 0) {
      if (((cmd0x7de.RspBody)localObject2).msg_head.has())
      {
        paramFromServiceMsg = (cmd0x7de.BusiRespHead)((cmd0x7de.RspBody)localObject2).msg_head.get();
        if (paramFromServiceMsg != null) {
          if (paramFromServiceMsg.int32_reply_code.has())
          {
            i1 = paramFromServiceMsg.int32_reply_code.get();
            if (i1 == 0)
            {
              bool1 = true;
              if (!paramFromServiceMsg.str_result.has()) {
                break label544;
              }
              paramFromServiceMsg = paramFromServiceMsg.str_result.get();
              if (!bool1) {
                break label530;
              }
              if (!((cmd0x7de.RspBody)localObject2).rpt_msg_user_list.has()) {
                break label525;
              }
              paramObject = ((cmd0x7de.RspBody)localObject2).rpt_msg_user_list.get();
              if (!((cmd0x7de.RspBody)localObject2).uint32_ended.has()) {
                break label519;
              }
              i2 = ((cmd0x7de.RspBody)localObject2).uint32_ended.get();
              if (!((cmd0x7de.RspBody)localObject2).bytes_cookie.has()) {
                break label496;
              }
              localObject2 = ((cmd0x7de.RspBody)localObject2).bytes_cookie.get().toByteArray();
              localObject1 = paramObject;
              i3 = i2;
              i2 = i1;
              paramObject = paramFromServiceMsg;
              paramFromServiceMsg = localObject1;
              i1 = i3;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      boolean bool2;
      if ((i1 & 0x1) == 0)
      {
        bool2 = true;
        label222:
        if ((i1 & 0x2) != 0) {
          break label377;
        }
      }
      boolean bool4;
      boolean bool5;
      label377:
      for (boolean bool3 = true;; bool3 = false)
      {
        bool4 = paramToServiceMsg.extraData.getBoolean("isMore", false);
        bool5 = paramToServiceMsg.extraData.getBoolean("isManual", false);
        boolean bool6 = paramToServiceMsg.extraData.getBoolean("isWebFilter", false);
        paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
        if (paramToServiceMsg == null) {
          break label491;
        }
        paramToServiceMsg = paramToServiceMsg.a().a(0, paramFromServiceMsg, bool4, bool6);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty())) {
          break label383;
        }
        localObject2 = paramToServiceMsg.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          DatingInfo localDatingInfo = (DatingInfo)((Iterator)localObject2).next();
          if (localDatingInfo != null) {
            localDatingInfo.lastUpdateTime = 0L;
          }
        }
        bool1 = false;
        break;
        bool1 = false;
        break;
        bool2 = false;
        break label222;
      }
      for (;;)
      {
        label383:
        a(9, bool1, new Object[] { paramToServiceMsg, Boolean.valueOf(bool2), Boolean.valueOf(bool3), localObject1, paramObject, Boolean.valueOf(bool4), Boolean.valueOf(bool5) });
        DatingUtil.a("handleGetDatingFeeds", new Object[] { Integer.valueOf(i2), Boolean.valueOf(bool1), paramFromServiceMsg, Integer.valueOf(i1), localObject1, paramObject });
        return;
        label491:
        paramToServiceMsg = null;
      }
      label496:
      i3 = i1;
      localObject2 = paramFromServiceMsg;
      paramFromServiceMsg = paramObject;
      i1 = i2;
      paramObject = localObject2;
      i2 = i3;
      continue;
      label519:
      i2 = -1;
      break label164;
      label525:
      paramObject = null;
      break label143;
      label530:
      i2 = i1;
      paramObject = paramFromServiceMsg;
      paramFromServiceMsg = null;
      i1 = -1;
      continue;
      label544:
      paramFromServiceMsg = paramObject;
      break label118;
      bool1 = false;
      paramFromServiceMsg = paramObject;
      break label118;
      paramFromServiceMsg = null;
      break;
      paramObject = null;
      i2 = i1;
      bool1 = false;
      paramFromServiceMsg = null;
      i1 = -1;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1;
    label200:
    int i3;
    int i2;
    int i4;
    int i6;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
        }
        if (5 > i5) {
          break label200;
        }
        i1 = paramToServiceMsg[4];
        if (7 > i5) {
          break label426;
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        i1 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating", 2, "handle_oidb_0x480_9 ret=" + i1);
        }
        if ((i1 == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          int i5 = paramToServiceMsg.length;
          if (4 <= i5)
          {
            paramFromServiceMsg = String.valueOf(PkgTools.a(paramToServiceMsg, 0));
            if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
            {
              if (QLog.isColorLevel()) {
                QLog.w("Q.dating", 2, "handle_oidb_0x480_9 uin error");
              }
              return;
            }
          }
          i1 = PkgTools.a(paramToServiceMsg, 5);
          i3 = 7;
          i2 = 0;
          if (i2 < i1)
          {
            i4 = i3;
            if (i3 + 4 <= i5)
            {
              i4 = PkgTools.a(paramToServiceMsg, i3);
              i6 = i3 + 2;
              i3 = PkgTools.a(paramToServiceMsg, i6);
              i6 += 2;
              if ((i4 & 0xFFFF) == 40493) {
                if (i3 == 0)
                {
                  i1 = 0;
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label291:
      if (bool1)
      {
        paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
        if (i1 == 0)
        {
          bool2 = true;
          label317:
          paramToServiceMsg.a(bool2);
        }
      }
      else
      {
        if (i1 != 0) {
          break label411;
        }
      }
      label411:
      for (boolean bool2 = true;; bool2 = false)
      {
        a(10, bool1, new Boolean[] { Boolean.valueOf(bool2) });
        DatingUtil.a("handle_oidb_0x480_9", new Object[] { Boolean.valueOf(bool1) });
        return;
        i1 = (byte)PkgTools.a(paramToServiceMsg, i6);
        bool1 = true;
        break label291;
        i4 = i6 + i3;
        i2 += 1;
        i3 = i4;
        break;
        bool2 = false;
        break label317;
      }
      i1 = 0;
      bool1 = true;
      continue;
      label426:
      i1 = 0;
      break;
      i1 = 0;
      bool1 = false;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          i1 = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.dating", 2, "handle_oidb_0x4ff_9 ret=" + i1);
          }
          if ((i1 == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            if (4 <= paramFromServiceMsg.length)
            {
              paramFromServiceMsg = String.valueOf(PkgTools.a(paramFromServiceMsg, 0));
              if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("Q.dating", 2, "handle_oidb_0x4ff_9 uin error");
                }
                return;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = paramObject;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      i1 = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
      if (bool1)
      {
        paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
        if (i1 != 0) {
          break label263;
        }
      }
      label263:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramToServiceMsg.a(bool2);
        a(11, bool1, null);
        DatingUtil.a("handle_oidb_0x4ff_9", new Object[] { Boolean.valueOf(bool1) });
        return;
      }
      bool1 = false;
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i5 = 0;
    int i2 = 0;
    int i4 = 0;
    int i3 = 0;
    cmd0x7cd.RspBody localRspBody = new cmd0x7cd.RspBody();
    int i6 = a(paramFromServiceMsg, paramObject, localRspBody);
    int i7 = paramToServiceMsg.extraData.getInt("download_type");
    int i1;
    label129:
    boolean bool;
    if (i6 == 0) {
      if (localRspBody.uint32_next.has())
      {
        i1 = localRspBody.uint32_next.get();
        if (localRspBody.uint32_over.has()) {
          i2 = localRspBody.uint32_over.get();
        }
        if (localRspBody.uint32_stamp.has()) {
          i3 = localRspBody.uint32_stamp.get();
        }
        if (localRspBody.rpt_msg_appoints_info.has())
        {
          paramToServiceMsg = localRspBody.rpt_msg_appoints_info.get();
          paramFromServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = paramFromServiceMsg.a();
            if (i7 == 4099) {}
            for (bool = true;; bool = false)
            {
              paramToServiceMsg = paramFromServiceMsg.a(2, paramToServiceMsg, bool, false);
              if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty())) {
                break;
              }
              paramFromServiceMsg = paramToServiceMsg.iterator();
              while (paramFromServiceMsg.hasNext())
              {
                paramObject = (DatingInfo)paramFromServiceMsg.next();
                if (paramObject != null) {
                  paramObject.lastUpdateTime = 0L;
                }
              }
            }
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      a(3, bool, new Object[] { paramToServiceMsg, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i7) });
      DatingUtil.a("handle_oidb_0x7cd_0", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i6), paramToServiceMsg, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) });
      return;
      paramToServiceMsg = null;
      bool = true;
      continue;
      paramToServiceMsg = null;
      break label129;
      i1 = 0;
      break;
      bool = false;
      i1 = 0;
      paramToServiceMsg = null;
      i2 = i5;
      i3 = i4;
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i4 = 0;
    int i3 = 0;
    int i5 = paramToServiceMsg.extraData.getInt("download_type");
    paramToServiceMsg = new cmd0x7cf.RspBody();
    int i6 = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int i1;
    int i2;
    label76:
    label113:
    boolean bool;
    if (i6 == 0) {
      if (paramToServiceMsg.uint32_next.has())
      {
        i1 = paramToServiceMsg.uint32_next.get();
        if (paramToServiceMsg.uint32_over.has())
        {
          i2 = paramToServiceMsg.uint32_over.get();
          if (paramToServiceMsg.uint32_stamp.has()) {
            i3 = paramToServiceMsg.uint32_stamp.get();
          }
          if (paramToServiceMsg.rpt_msg_appoints_info.has())
          {
            paramToServiceMsg = paramToServiceMsg.rpt_msg_appoints_info.get();
            DatingManager localDatingManager = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
            if (localDatingManager != null)
            {
              paramFromServiceMsg = localDatingManager.a();
              label186:
              DatingInfo localDatingInfo;
              if (i5 == 4099)
              {
                bool = true;
                paramObject = paramFromServiceMsg.a(1, paramToServiceMsg, bool, false);
                if ((paramObject == null) || (paramObject.isEmpty())) {
                  break label279;
                }
                paramToServiceMsg = localDatingManager.d();
                Iterator localIterator = paramObject.iterator();
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  localDatingInfo = (DatingInfo)localIterator.next();
                } while (localDatingInfo == null);
                if (localDatingInfo.datingStatus != 0) {
                  break label254;
                }
                localDatingManager.a(localDatingInfo.datingId);
                paramFromServiceMsg = localDatingInfo.datingId;
              }
              for (;;)
              {
                localDatingInfo.lastUpdateTime = 0L;
                paramToServiceMsg = paramFromServiceMsg;
                break label186;
                bool = false;
                break;
                label254:
                paramFromServiceMsg = paramToServiceMsg;
                if (Utils.a(localDatingInfo.datingId, paramToServiceMsg))
                {
                  localDatingManager.a(null);
                  paramFromServiceMsg = paramToServiceMsg;
                }
              }
              label279:
              paramToServiceMsg = paramObject;
              bool = true;
            }
          }
        }
      }
    }
    for (;;)
    {
      a(5, bool, new Object[] { paramToServiceMsg, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5) });
      if (paramToServiceMsg == null) {}
      for (paramToServiceMsg = null;; paramToServiceMsg = Integer.valueOf(paramToServiceMsg.size()))
      {
        DatingUtil.a("handle_oidb_0x7cf_0", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i6), paramToServiceMsg, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) });
        return;
      }
      paramToServiceMsg = null;
      bool = true;
      continue;
      paramToServiceMsg = null;
      break label113;
      i2 = 0;
      break label76;
      i1 = 0;
      break;
      i2 = 0;
      bool = false;
      i1 = 0;
      paramToServiceMsg = null;
      i3 = i4;
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("appoint_id");
    Object localObject = new cmd0x5fd.RspBody();
    int i3 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    int i1 = 0;
    int i2;
    if (i3 == 0)
    {
      paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = null;
        paramFromServiceMsg = null;
        if (((cmd0x5fd.RspBody)localObject).msg_comment.has()) {
          paramFromServiceMsg = DatingComment.a(((cmd0x5fd.RspBody)localObject).msg_comment.get());
        }
        i2 = ((cmd0x5fd.RspBody)localObject).uint32_clear_cache_flag.get();
        if (!((cmd0x5fd.RspBody)localObject).uint32_comment_num.has()) {
          break label328;
        }
        i1 = ((cmd0x5fd.RspBody)localObject).uint32_comment_num.get();
        label121:
        if (!((cmd0x5fd.RspBody)localObject).str_comment_wording.has()) {
          break label334;
        }
        paramObject = ((cmd0x5fd.RspBody)localObject).str_comment_wording.get();
        label141:
        if (paramToServiceMsg != null)
        {
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            if (i2 == 0) {
              break label341;
            }
            bool = true;
            label166:
            paramToServiceMsg.addDatingComment(true, paramFromServiceMsg, bool);
          }
          paramToServiceMsg.setReachOver(1, true, true);
          paramToServiceMsg.datingCommentNum = i1;
          paramToServiceMsg.datingCommentWording = paramObject;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating.detail", 2, "handlePubDatingComment commentNum is: " + i1);
        }
        paramFromServiceMsg = null;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      a(18, bool, new Object[] { str, paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i1) });
      DatingUtil.a("handlPubDateComment", new Object[] { Integer.valueOf(i3), str, Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i1) });
      return;
      paramToServiceMsg = paramToServiceMsg.a().a(str, true, true, true);
      break;
      label328:
      i1 = 0;
      break label121;
      label334:
      paramObject = "";
      break label141;
      label341:
      bool = false;
      break label166;
      paramFromServiceMsg = ((cmd0x5fd.RspBody)localObject).str_error_tips.get();
      paramObject = paramToServiceMsg.extraData.getString("beReplyedCommentId");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("commentContent");
      localObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
      if ((localObject != null) && (!TextUtils.isEmpty(paramToServiceMsg))) {
        ((DatingManager)localObject).a(str, paramObject, paramToServiceMsg);
      }
      paramToServiceMsg = null;
      i2 = 0;
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str1 = paramToServiceMsg.extraData.getString("appoint_id");
    String str2 = paramToServiceMsg.extraData.getString("date_comment_id");
    paramToServiceMsg = new cmd0x5ff.RspBody();
    if (a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = null;
        if (paramToServiceMsg != null) {
          paramToServiceMsg.delComment(str2);
        }
        paramToServiceMsg = null;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      a(19, bool, new Object[] { str1, str2, paramToServiceMsg });
      DatingUtil.a("handleDelDateComment", new Object[] { str1, str2, paramToServiceMsg });
      return;
      paramToServiceMsg = paramToServiceMsg.a().a(str1, true, true, true);
      break;
      paramToServiceMsg = paramToServiceMsg.str_error_tips.get();
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str1 = paramToServiceMsg.extraData.getString("appoint_id");
    String str2 = paramToServiceMsg.extraData.getString("date_comment_id");
    int i3 = paramToServiceMsg.extraData.getInt("appoint_action");
    cmd0x5fe.RspBody localRspBody = new cmd0x5fe.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool = false;
    if (i1 == 0) {
      if (!localRspBody.msg_comment.has()) {
        break label663;
      }
    }
    label663:
    for (paramFromServiceMsg = DatingComment.a(localRspBody.msg_comment.get());; paramFromServiceMsg = null)
    {
      i1 = localRspBody.uint32_fetch_old_over.get();
      int i2 = localRspBody.uint32_fetch_new_over.get();
      paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = null;
        if (paramToServiceMsg != null)
        {
          if (!"0".equals(str2)) {
            break label378;
          }
          paramToServiceMsg.addDatingComment(true, paramFromServiceMsg, true);
          if (i2 == 0) {
            break label366;
          }
          bool = true;
          label160:
          paramToServiceMsg.setReachOver(1, true, bool);
          if (i1 == 0) {
            break label372;
          }
          bool = true;
          label176:
          paramToServiceMsg.setReachOver(1, false, bool);
        }
        if (!localRspBody.uint32_fetch_new_over.has()) {
          break label593;
        }
        i1 = localRspBody.uint32_fetch_new_over.get();
        label205:
        if (!localRspBody.uint32_fetch_old_over.has()) {
          break label599;
        }
      }
      label554:
      label587:
      label593:
      label599:
      for (i2 = localRspBody.uint32_fetch_old_over.get();; i2 = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating.detail", 2, "handle getDatingComment over is: " + i1 + " " + i2);
        }
        paramFromServiceMsg = null;
        bool = true;
        a(20, bool, new Object[] { str1, Integer.valueOf(i3), str2, paramToServiceMsg, paramFromServiceMsg });
        DatingUtil.a("handleGetDateCommentList", new Object[] { str1, Integer.valueOf(i3), str2, paramToServiceMsg, paramFromServiceMsg });
        return;
        paramToServiceMsg = paramToServiceMsg.a().a(str1, true, true, true);
        break;
        label366:
        bool = false;
        break label160;
        label372:
        bool = false;
        break label176;
        label378:
        if (i3 == 1)
        {
          paramToServiceMsg.addDatingComment(true, paramFromServiceMsg, false);
          if (i2 != 0) {}
          for (bool = true;; bool = false)
          {
            paramToServiceMsg.setReachOver(1, true, bool);
            break;
          }
        }
        if (i3 == 2)
        {
          paramToServiceMsg.addDatingComment(false, paramFromServiceMsg, false);
          if (i1 != 0) {}
          for (bool = true;; bool = false)
          {
            paramToServiceMsg.setReachOver(1, false, bool);
            break;
          }
        }
        if ((!paramToServiceMsg.isGetList) && (paramToServiceMsg.lastFrom == 2147483647)) {
          paramToServiceMsg.lastFrom = 1006;
        }
        if ((!paramToServiceMsg.isGetList) && (paramToServiceMsg.isInit) && (paramToServiceMsg.isCanMerge(1, false, paramFromServiceMsg)))
        {
          paramToServiceMsg.addDatingComment(false, paramFromServiceMsg, false);
          if (i1 != 0) {}
          for (bool = true;; bool = false)
          {
            paramToServiceMsg.setReachOver(1, false, bool);
            paramToServiceMsg.isGetList = true;
            break;
          }
        }
        paramToServiceMsg.addDatingComment(true, paramFromServiceMsg, true);
        if (i2 != 0)
        {
          bool = true;
          paramToServiceMsg.setReachOver(1, true, bool);
          if (i1 == 0) {
            break label587;
          }
        }
        for (bool = true;; bool = false)
        {
          paramToServiceMsg.setReachOver(1, false, bool);
          break;
          bool = false;
          break label554;
        }
        i1 = -1;
        break label205;
      }
      if (i3 == 3)
      {
        paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
        if (paramToServiceMsg == null) {
          paramToServiceMsg = null;
        }
      }
      for (;;)
      {
        paramFromServiceMsg = localRspBody.str_error_tips.get();
        break;
        paramToServiceMsg = paramToServiceMsg.a().a(str1, false, false, false);
        continue;
        paramToServiceMsg = null;
      }
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    long l2 = paramToServiceMsg.extraData.getLong("last_event_id");
    long l3 = paramToServiceMsg.extraData.getLong("read_event_id");
    cmd0x5fc.RspBody localRspBody = new cmd0x5fc.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = null;
    paramObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
    if (i1 == 0) {
      if ((paramObject != null) && (localRspBody.rpt_act_appoint_ids.has()))
      {
        paramToServiceMsg = localRspBody.rpt_act_appoint_ids.get();
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
        {
          paramFromServiceMsg = paramToServiceMsg.iterator();
          while (paramFromServiceMsg.hasNext())
          {
            Object localObject = (appoint_define.AppointID)paramFromServiceMsg.next();
            if (localObject != null)
            {
              localObject = DatingUtil.a((appoint_define.AppointID)localObject);
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                paramObject.a((String)localObject);
              }
            }
          }
        }
        if (paramToServiceMsg == null)
        {
          paramToServiceMsg = "null";
          DatingUtil.a("handleGetDateEventList", new Object[] { paramToServiceMsg });
        }
      }
      else
      {
        if (!localRspBody.msg_event_list.has()) {
          break label358;
        }
      }
    }
    label315:
    label358:
    for (paramToServiceMsg = localRspBody.msg_event_list.get();; paramToServiceMsg = null)
    {
      long l1 = localRspBody.uint64_max_event_id.get();
      boolean bool = true;
      paramFromServiceMsg = null;
      for (;;)
      {
        if (paramObject == null) {
          break label315;
        }
        paramObject.a().a(bool, paramToServiceMsg, l2, l3, l1);
        DatingUtil.a("handleGetDateEventList", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), paramToServiceMsg, paramFromServiceMsg });
        return;
        paramToServiceMsg = Integer.valueOf(paramToServiceMsg.size());
        break;
        paramFromServiceMsg = localRspBody.str_error_tips.get();
        bool = false;
        l1 = 0L;
      }
      DatingUtil.b("handleGetDateEventList", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), paramToServiceMsg, paramFromServiceMsg });
      return;
    }
  }
  
  public appoint_define.LBSInfo a()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.a();
    if ((localSosoLbsInfo == null) || (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) || (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a == 0.0D) || (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b == 0.0D))
    {
      SosoInterface.a(60000L, getClass().getSimpleName());
      localSosoLbsInfo = SosoInterface.a();
    }
    for (;;)
    {
      appoint_define.LBSInfo localLBSInfo;
      if (localSosoLbsInfo != null)
      {
        localLBSInfo = new appoint_define.LBSInfo();
        Object localObject1;
        Object localObject2;
        Object localObject3;
        if (localSosoLbsInfo.b != null)
        {
          localObject1 = localSosoLbsInfo.b.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject3 = new appoint_define.Wifi();
              ((appoint_define.Wifi)localObject3).uint64_mac.set(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long);
              ((appoint_define.Wifi)localObject3).int32_rssi.set(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int);
              localLBSInfo.rpt_msg_wifis.add((MessageMicro)localObject3);
            }
          }
        }
        if (localSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject1 = localSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject3 = new appoint_define.Cell();
              ((appoint_define.Cell)localObject3).int32_cellid.set(((SosoInterface.SosoCell)localObject2).d);
              ((appoint_define.Cell)localObject3).int32_lac.set(((SosoInterface.SosoCell)localObject2).c);
              ((appoint_define.Cell)localObject3).int32_rssi.set(((SosoInterface.SosoCell)localObject2).e);
              ((appoint_define.Cell)localObject3).int32_mcc.set(((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int);
              ((appoint_define.Cell)localObject3).int32_mnc.set(((SosoInterface.SosoCell)localObject2).b);
              localLBSInfo.rpt_msg_cells.add((MessageMicro)localObject3);
            }
          }
        }
        if (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null)
        {
          localObject1 = new appoint_define.GPS();
          ((appoint_define.GPS)localObject1).int32_lon.set((int)(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b * 1000000.0D));
          ((appoint_define.GPS)localObject1).int32_lat.set((int)(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a * 1000000.0D));
          ((appoint_define.GPS)localObject1).int32_type.set(0);
          localLBSInfo.msg_gps.set((MessageMicro)localObject1);
          return localLBSInfo;
        }
      }
      else
      {
        DatingUtil.b("getLbsInfo", new Object[] { "lbs is null" });
        return null;
      }
      return localLBSInfo;
    }
  }
  
  public ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.str_client_version.set(AppSetting.d());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = a(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  protected Class a()
  {
    return DatingObserver.class;
  }
  
  public void a()
  {
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      Object localObject = new byte[9];
      PkgTools.a((byte[])localObject, 0, l1);
      localObject[4] = 0;
      PkgTools.a((byte[])localObject, 5, (short)1);
      PkgTools.a((byte[])localObject, 7, 40493);
      localObject = a("OidbSvc.0x480_9", 1152, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromDatingHandler", true);
      b((ToServiceMsg)localObject);
      DatingUtil.a("send_oidb_0x480_9", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.dating", 2, "send_oidb_0x480_9 error", localException);
    }
  }
  
  public void a(byte paramByte)
  {
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      Object localObject = new byte[13];
      PkgTools.a((byte[])localObject, 0, l1);
      localObject[4] = 0;
      PkgTools.a((byte[])localObject, 5, (short)1);
      PkgTools.a((byte[])localObject, 7, 40493);
      PkgTools.a((byte[])localObject, 9, (short)2);
      PkgTools.a((byte[])localObject, 11, (short)paramByte);
      localObject = a("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putByte("session_switch_value", paramByte);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromDatingHandler", true);
      b((ToServiceMsg)localObject);
      DatingUtil.a("send_oidb_0x4ff_9", new Object[] { Byte.valueOf(paramByte) });
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.dating", 2, "send_oidb_0x4ff_9 error", localException);
    }
  }
  
  public void a(int paramInt)
  {
    cmd0x7cb.ReqBody localReqBody = new cmd0x7cb.ReqBody();
    localReqBody.uint32_time_stamp.set(paramInt);
    b(a("OidbSvc.0x7cb_0", 1995, 0, localReqBody.toByteArray()));
    DatingUtil.a("send_oidb_0x7cb_0", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    cmd0x7cd.ReqBody localReqBody = new cmd0x7cd.ReqBody();
    Object localObject1 = a();
    if (localObject1 != null) {
      localReqBody.msg_lbs_info.set((MessageMicro)localObject1);
    }
    localReqBody.uint32_stamp.set(paramInt1);
    localReqBody.uint32_start.set(paramInt2);
    localReqBody.uint32_want.set(paramInt3);
    Object localObject2 = ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67)).a();
    if (((DatingCacheDel)localObject2).a(2, 1))
    {
      String str = ((DatingCacheDel)localObject2).a(2);
      localObject1 = new ArrayList();
      if (TextUtils.isEmpty(str))
      {
        localObject1 = ((DatingCacheDel)localObject2).a(2);
        localReqBody.uint32_appoint_operation.set(3);
      }
      for (;;)
      {
        int i1 = 0;
        while (i1 < ((ArrayList)localObject1).size())
        {
          localObject2 = DatingUtil.a((String)((ArrayList)localObject1).get(i1));
          if (localObject2 != null) {
            localReqBody.rpt_msg_appoint_ids.add((MessageMicro)localObject2);
          }
          i1 += 1;
        }
        ((ArrayList)localObject1).add(str);
        localReqBody.uint32_appoint_operation.set(4);
      }
    }
    localObject1 = a("OidbSvc.0x7cd_0", 1997, 0, localReqBody.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("download_type", paramInt4);
    b((ToServiceMsg)localObject1);
    DatingUtil.a("send_oidb_0x7cd_0", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), a() });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    cmd0x7cf.ReqBody localReqBody = new cmd0x7cf.ReqBody();
    localReqBody.uint32_stamp.set(paramInt1);
    localReqBody.uint32_start.set(paramInt2);
    localReqBody.uint32_want.set(paramInt3);
    localReqBody.uint32_req_valid_only.set(paramInt4);
    Object localObject2 = ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67)).a();
    if (((DatingCacheDel)localObject2).a(1, 1))
    {
      String str = ((DatingCacheDel)localObject2).a(1);
      localObject1 = new ArrayList();
      if (TextUtils.isEmpty(str))
      {
        localObject1 = ((DatingCacheDel)localObject2).a(1);
        localReqBody.uint32_appoint_operation.set(1);
      }
      for (;;)
      {
        paramInt4 = 0;
        while (paramInt4 < ((ArrayList)localObject1).size())
        {
          localObject2 = DatingUtil.a((String)((ArrayList)localObject1).get(paramInt4));
          if (localObject2 != null) {
            localReqBody.rpt_msg_appoint_ids.add((MessageMicro)localObject2);
          }
          paramInt4 += 1;
        }
        ((ArrayList)localObject1).add(str);
        localReqBody.uint32_appoint_operation.set(2);
      }
    }
    Object localObject1 = a("OidbSvc.0x7cf_0", 1999, 0, localReqBody.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("download_type", paramInt5);
    b((ToServiceMsg)localObject1);
    DatingUtil.a("send_oidb_0x7cf_0", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = new cmd0x5fc.ReqBody();
    ((cmd0x5fc.ReqBody)localObject).uint64_last_event_id.set(paramLong1);
    ((cmd0x5fc.ReqBody)localObject).uint64_read_event_id.set(paramLong2);
    ((cmd0x5fc.ReqBody)localObject).uint32_fetch_count.set(paramInt);
    localObject = a("OidbSvc.0x5fc_0", 1532, 0, ((cmd0x5fc.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("last_event_id", paramLong1);
    ((ToServiceMsg)localObject).extraData.putLong("read_event_id", paramLong2);
    b((ToServiceMsg)localObject);
    DatingUtil.a("getDateEventList", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
  }
  
  public void a(PublishDatingOption paramPublishDatingOption, int paramInt)
  {
    Object localObject1 = new cmd0x7dc.ReqBody();
    appoint_define.AppointContent localAppointContent = new appoint_define.AppointContent();
    localAppointContent.uint32_appoint_subject.set(paramPublishDatingOption.themeId);
    localAppointContent.uint32_pay_type.set(paramPublishDatingOption.payTypeId);
    localAppointContent.uint32_appoint_date.set((int)(paramPublishDatingOption.time / 1000L));
    localAppointContent.uint32_appoint_gender.set(paramPublishDatingOption.genderId);
    localAppointContent.str_appoint_introduce.set(paramPublishDatingOption.introduce);
    Object localObject2 = new appoint_define.AddressInfo();
    ((appoint_define.AddressInfo)localObject2).str_company_zone.set(paramPublishDatingOption.shopInfo.shopZone);
    ((appoint_define.AddressInfo)localObject2).str_company_name.set(paramPublishDatingOption.shopInfo.shopName);
    ((appoint_define.AddressInfo)localObject2).str_company_addr.set(paramPublishDatingOption.shopInfo.shopAddr);
    ((appoint_define.AddressInfo)localObject2).str_company_pic_url.set(paramPublishDatingOption.shopInfo.shopPicUrl);
    ((appoint_define.AddressInfo)localObject2).str_company_url.set(paramPublishDatingOption.shopInfo.shopUrl);
    appoint_define.ShopID localShopID = new appoint_define.ShopID();
    localShopID.str_shopid.set(paramPublishDatingOption.shopInfo.shopId);
    localShopID.uint32_sp.set(paramPublishDatingOption.shopInfo.shopSp);
    ((appoint_define.AddressInfo)localObject2).msg_company_id.set(localShopID);
    localAppointContent.msg_appoint_address.set((MessageMicro)localObject2);
    localObject2 = a();
    if (localObject2 != null) {
      ((cmd0x7dc.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    ((cmd0x7dc.ReqBody)localObject1).uint32_seq.set(0);
    ((cmd0x7dc.ReqBody)localObject1).msg_appointment.set(localAppointContent);
    ((cmd0x7dc.ReqBody)localObject1).uint32_overwrite.set(paramInt);
    localObject1 = a("OidbSvc.0x7dc_0", 2012, 0, ((cmd0x7dc.ReqBody)localObject1).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("public_subject", paramPublishDatingOption.themeId);
    ((ToServiceMsg)localObject1).extraData.putInt("public_type", paramPublishDatingOption.payTypeId);
    ((ToServiceMsg)localObject1).extraData.putInt("public_time", (int)paramPublishDatingOption.time);
    ((ToServiceMsg)localObject1).extraData.putInt("public_gender", paramPublishDatingOption.genderId);
    ((ToServiceMsg)localObject1).extraData.putString("public_introduce", paramPublishDatingOption.introduce);
    ((ToServiceMsg)localObject1).extraData.putString("public_zone", paramPublishDatingOption.shopInfo.shopZone);
    ((ToServiceMsg)localObject1).extraData.putString("public_addr_name", paramPublishDatingOption.shopInfo.shopName);
    ((ToServiceMsg)localObject1).extraData.putString("public_addr", paramPublishDatingOption.shopInfo.shopAddr);
    ((ToServiceMsg)localObject1).extraData.putString("public_shop_pic_url", paramPublishDatingOption.shopInfo.shopPicUrl);
    ((ToServiceMsg)localObject1).extraData.putString("public_shop_url", paramPublishDatingOption.shopInfo.shopUrl);
    b((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.dating", 2, "publishNorDating|dating option[" + paramPublishDatingOption.toString() + "]");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          str = paramFromServiceMsg.getServiceCmd();
          if ("OidbSvc.0x7ca_0".equals(str))
          {
            j(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x7cb_0".equals(str))
          {
            l(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x7cd_0".equals(str))
          {
            p(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x7ce_0".equals(str))
          {
            b(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x7cf_0".equals(str))
          {
            q(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x7da_0".equals(str))
          {
            d(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x7db_0".equals(str))
          {
            g(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x7dc_0".equals(str))
          {
            k(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x7de_0".equals(str))
          {
            m(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (!"OidbSvc.0x4ff_9".equals(str)) {
            break;
          }
        } while (!paramToServiceMsg.extraData.getBoolean("reqFromDatingHandler", false));
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
        if (!"OidbSvc.0x480_9".equals(str)) {
          break;
        }
      } while (!paramToServiceMsg.extraData.getBoolean("reqFromDatingHandler", false));
      n(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ("OidbSvc.0x7da_1".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7da_2".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7db_1".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7db_2".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x5fa_2".equals(str)) || ("OidbSvc.0x5fa_1".equals(str)))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject, "OidbSvc.0x5fa_2".equals(str));
        return;
      }
      if ("OidbSvc.0x5fd_0".equals(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ff_0".equals(str))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5fe_0".equals(str))
      {
        t(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5fc_0".equals(str))
      {
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x5f9_0".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    Object localObject1 = new cmd0x7ce.ReqBody();
    Object localObject2 = DatingUtil.a(paramString);
    ((cmd0x7ce.ReqBody)localObject1).rpt_appoint_ids.add((MessageMicro)localObject2);
    ((cmd0x7ce.ReqBody)localObject1).uint32_join_start.set(0);
    ((cmd0x7ce.ReqBody)localObject1).uint32_join_want.set(20);
    ((cmd0x7ce.ReqBody)localObject1).uint32_view_start.set(0);
    ((cmd0x7ce.ReqBody)localObject1).uint32_view_want.set(20);
    ((cmd0x7ce.ReqBody)localObject1).uint32_view_comment_count.set(20);
    localObject2 = a();
    if (localObject2 != null) {
      ((cmd0x7ce.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    localObject1 = a("OidbSvc.0x7ce_0", 1998, 4, ((cmd0x7ce.ReqBody)localObject1).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("appoint_id", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("last_from", paramInt);
    b((ToServiceMsg)localObject1);
    DatingUtil.a("getDatingDetail", new Object[] { paramString, localObject2 });
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = new cmd0x7da.ReqBody();
    Object localObject2 = DatingUtil.a(paramString);
    ((cmd0x7da.ReqBody)localObject1).rpt_msg_appoint_ids.add((MessageMicro)localObject2);
    ((cmd0x7da.ReqBody)localObject1).uint32_appoint_operation.set(paramInt1);
    ((cmd0x7da.ReqBody)localObject1).uint32_operation_reason.set(paramInt2);
    if (((cmd0x7da.ReqBody)localObject1).rpt_msg_appoint_ids.size() > 0)
    {
      localObject1 = a("OidbSvc.0x7da_0", 2010, 0, ((cmd0x7da.ReqBody)localObject1).toByteArray());
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramString);
      ((ToServiceMsg)localObject1).extraData.putStringArrayList("appoint_ids", (ArrayList)localObject2);
      ((ToServiceMsg)localObject1).extraData.putInt("appoint_action", paramInt1);
      b((ToServiceMsg)localObject1);
    }
    DatingUtil.a("send_oidb_0x7da_0", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    Object localObject = new cmd0x7ca.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString);
    ((cmd0x7ca.ReqBody)localObject).msg_appoint_id.set(localAppointID);
    ((cmd0x7ca.ReqBody)localObject).uint64_tinyid.set(paramLong);
    ((cmd0x7ca.ReqBody)localObject).uint32_op_type.set(paramInt);
    localObject = a("OidbSvc.0x7ca_0", 1994, 0, ((cmd0x7ca.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt);
    ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("open_id", paramLong);
    b((ToServiceMsg)localObject);
    DatingUtil.a("send_oidb_0x7ca_0", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
  
  public void a(String paramString1, appoint_define.DateComment paramDateComment, int paramInt, String paramString2)
  {
    if ((paramDateComment == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = new cmd0x5fd.ReqBody();
    ((cmd0x5fd.ReqBody)localObject).msg_comment.set(paramDateComment);
    ((cmd0x5fd.ReqBody)localObject).uint32_max_fetch_count.set(paramInt);
    ((cmd0x5fd.ReqBody)localObject).str_last_comment_id.set(paramString2);
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x5fd_0", 1533, 0, ((cmd0x5fd.ReqBody)localObject).toByteArray());
    localToServiceMsg.extraData.putString("appoint_id", paramString1);
    Bundle localBundle = localToServiceMsg.extraData;
    if (paramDateComment.msg_reply_info.has())
    {
      localObject = paramDateComment.msg_reply_info.str_comment_id.get();
      localBundle.putString("beReplyedCommentId", (String)localObject);
      localObject = localToServiceMsg.extraData;
      if (!paramDateComment.str_content.has()) {
        break label192;
      }
    }
    label192:
    for (paramDateComment = paramDateComment.str_content.get();; paramDateComment = "")
    {
      ((Bundle)localObject).putString("commentContent", paramDateComment);
      b(localToServiceMsg);
      DatingUtil.a("pubDateComment", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
      return;
      localObject = "";
      break;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = new cmd0x5ff.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString1);
    ((cmd0x5ff.ReqBody)localObject).msg_appoint_id.set(localAppointID);
    ((cmd0x5ff.ReqBody)localObject).str_comment_id.set(paramString2);
    localObject = a("OidbSvc.0x5ff_0", 1535, 0, ((cmd0x5ff.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("date_comment_id", paramString2);
    b((ToServiceMsg)localObject);
    DatingUtil.a("delDateComment", new Object[] { paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = new cmd0x5fe.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString1);
    ((cmd0x5fe.ReqBody)localObject).msg_appoint_id.set(localAppointID);
    ((cmd0x5fe.ReqBody)localObject).str_comment_id.set(paramString2);
    ((cmd0x5fe.ReqBody)localObject).uint32_fetch_old_count.set(paramInt1);
    ((cmd0x5fe.ReqBody)localObject).uint32_fetch_new_count.set(paramInt2);
    int i1 = DatingUtil.a(paramInt2, paramInt1);
    localObject = a("OidbSvc.0x5fe_0", 1534, 0, ((cmd0x5fe.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("date_comment_id", paramString2);
    ((ToServiceMsg)localObject).extraData.putInt("appoint_action", i1);
    b((ToServiceMsg)localObject);
    DatingUtil.a("getDateCommentList", new Object[] { paramString1, paramString2, Integer.valueOf(i1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(String paramString1, String paramString2, ByteStringMicro paramByteStringMicro)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "北京";
    }
    paramString2 = new cmd0x5f9.ReqBody();
    paramString2.str_keyword.set(paramString1);
    paramString2.str_srccity.set(str);
    if (paramByteStringMicro != null) {
      paramString2.bytes_cookie.set(paramByteStringMicro);
    }
    b(a("OidbSvc.0x5f9_0", 1529, 0, paramString2.toByteArray()));
    DatingUtil.a("send_oidb_0x5f9_0", new Object[] { paramString1 });
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    Object localObject = new cmd0x7db.ReqBody();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      appoint_define.AppointID localAppointID = DatingUtil.a((String)paramArrayList.get(i1));
      if (localAppointID != null) {
        ((cmd0x7db.ReqBody)localObject).rpt_msg_appoint_ids.add(localAppointID);
      }
      i1 += 1;
    }
    ((cmd0x7db.ReqBody)localObject).uint32_appoint_action.set(paramInt);
    ((cmd0x7db.ReqBody)localObject).uint32_overwrite.set(1);
    localObject = a("OidbSvc.0x7db_1", 2011, 1, ((cmd0x7db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putStringArrayList("appoint_id", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt);
    b((ToServiceMsg)localObject);
    DatingUtil.a("send_oidb_0x7db_1", new Object[] { paramArrayList, Integer.valueOf(paramInt) });
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x7da.ReqBody();
    if (paramArrayList == null) {}
    for (int i1 = 0;; i1 = paramArrayList.size())
    {
      int i2 = 0;
      while (i2 < i1)
      {
        appoint_define.AppointID localAppointID = DatingUtil.a((String)paramArrayList.get(i2));
        if (localAppointID != null) {
          ((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.add(localAppointID);
        }
        i2 += 1;
      }
    }
    ((cmd0x7da.ReqBody)localObject).uint32_appoint_operation.set(paramInt1);
    ((cmd0x7da.ReqBody)localObject).uint32_operation_reason.set(paramInt2);
    if (((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.size() > 0)
    {
      localObject = a("OidbSvc.0x7da_0", 2010, 0, ((cmd0x7da.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putStringArrayList("appoint_ids", paramArrayList);
      ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt1);
      b((ToServiceMsg)localObject);
    }
    DatingUtil.a("send_oidb_0x7da_0", new Object[] { paramArrayList, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt3 + paramInt4 < 0) || (paramInt3 + paramInt4 > 200))
    {
      DatingUtil.a("getDatingStrangers", new Object[] { "invalide params", paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    Object localObject = new cmd0x5fa.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString);
    ((cmd0x5fa.ReqBody)localObject).rpt_appoint_ids.set(localAppointID);
    ((cmd0x5fa.ReqBody)localObject).uint32_refer_idx.set(paramInt1);
    ((cmd0x5fa.ReqBody)localObject).uint32_get_refer_rec.set(paramInt2);
    ((cmd0x5fa.ReqBody)localObject).uint32_req_next_count.set(paramInt3);
    ((cmd0x5fa.ReqBody)localObject).uint32_req_prev_count.set(paramInt4);
    paramInt2 = DatingUtil.a(paramInt4, paramInt3);
    if (paramBoolean) {}
    for (localObject = a("OidbSvc.0x5fa_2", 1530, 2, ((cmd0x5fa.ReqBody)localObject).toByteArray());; localObject = a("OidbSvc.0x5fa_1", 1530, 1, ((cmd0x5fa.ReqBody)localObject).toByteArray()))
    {
      ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString);
      ((ToServiceMsg)localObject).extraData.putInt("refer_idx", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt2);
      b((ToServiceMsg)localObject);
      DatingUtil.a("getDatingStrangers", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, appoint_define.LocaleInfo paramLocaleInfo, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = a();
    DatingUtil.a("getDatingFeeds", new Object[] { localObject });
    if (localObject == null)
    {
      DatingUtil.b("getDatingFeeds", new Object[] { "lbs is null" });
      return false;
    }
    cmd0x7de.BusiReqHead localBusiReqHead = new cmd0x7de.BusiReqHead();
    localBusiReqHead.int32_version.set(1);
    localBusiReqHead.int32_seq.set(0);
    cmd0x7de.ReqBody localReqBody = new cmd0x7de.ReqBody();
    localReqBody.msg_head.set(localBusiReqHead);
    localReqBody.msg_lbs_info.set((MessageMicro)localObject);
    localReqBody.uint32_time.set(paramInt1);
    localReqBody.uint32_subject.set(paramInt2);
    localReqBody.uint32_gender.set(paramInt3);
    localReqBody.uint32_age_low.set(paramInt4);
    localReqBody.uint32_age_up.set(paramInt5);
    localReqBody.uint32_profession.set(paramInt6);
    localObject = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      localObject = new byte[0];
    }
    localReqBody.bytes_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
    if ((paramLocaleInfo != null) && (paramInt2 == 5)) {
      localReqBody.msg_destination.set(paramLocaleInfo);
    }
    paramLocaleInfo = a("OidbSvc.0x7de_0", 2014, 0, localReqBody.toByteArray());
    paramLocaleInfo.extraData.putInt("filter_time", paramInt1);
    paramLocaleInfo.extraData.putInt("filter_subject", paramInt2);
    paramLocaleInfo.extraData.putInt("filter_gender", paramInt3);
    paramLocaleInfo.extraData.putInt("filter_lowage", paramInt4);
    paramLocaleInfo.extraData.putInt("filter_upage", paramInt5);
    paramLocaleInfo.extraData.putInt("filter_profession", paramInt6);
    paramLocaleInfo.extraData.putBoolean("isMore", paramBoolean1);
    paramLocaleInfo.extraData.putBoolean("isManual", paramBoolean2);
    paramLocaleInfo.extraData.putBoolean("isWebFilter", paramBoolean3);
    b(paramLocaleInfo);
    return true;
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7ca_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7cb_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7cd_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7ce_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7cf_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7da_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7db_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7dc_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7de_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x480_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x4ff_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7da_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7da_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7db_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7db_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5f9_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5fa_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5fa_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5fd_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ff_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5fe_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5fc_0");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    a(21, true, null);
  }
  
  public void b(PublishDatingOption paramPublishDatingOption, int paramInt)
  {
    Object localObject1 = new cmd0x7dc.ReqBody();
    appoint_define.AppointContent localAppointContent = new appoint_define.AppointContent();
    localAppointContent.uint32_appoint_subject.set(paramPublishDatingOption.themeId);
    localAppointContent.uint32_appoint_date.set((int)(paramPublishDatingOption.time / 1000L));
    localAppointContent.uint32_appoint_gender.set(paramPublishDatingOption.genderId);
    localAppointContent.str_appoint_introduce.set(paramPublishDatingOption.introduce);
    Object localObject2 = new appoint_define.TravelInfo();
    if (paramPublishDatingOption.depLocal != null) {
      ((appoint_define.TravelInfo)localObject2).msg_depart_locale.set(paramPublishDatingOption.depLocal);
    }
    if (paramPublishDatingOption.desLocal != null) {
      ((appoint_define.TravelInfo)localObject2).msg_destination.set(paramPublishDatingOption.desLocal);
    }
    ((appoint_define.TravelInfo)localObject2).uint32_partner_count.set(paramPublishDatingOption.partCountId);
    ((appoint_define.TravelInfo)localObject2).uint32_vehicle.set(paramPublishDatingOption.vehicleId);
    localAppointContent.msg_travel_info.set((MessageMicro)localObject2);
    localObject2 = a();
    if (localObject2 != null) {
      ((cmd0x7dc.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    ((cmd0x7dc.ReqBody)localObject1).uint32_seq.set(0);
    ((cmd0x7dc.ReqBody)localObject1).msg_appointment.set(localAppointContent);
    ((cmd0x7dc.ReqBody)localObject1).uint32_overwrite.set(paramInt);
    localObject1 = a("OidbSvc.0x7dc_0", 2012, 0, ((cmd0x7dc.ReqBody)localObject1).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("public_subject", paramPublishDatingOption.themeId);
    ((ToServiceMsg)localObject1).extraData.putInt("public_time", (int)paramPublishDatingOption.time);
    ((ToServiceMsg)localObject1).extraData.putInt("public_gender", paramPublishDatingOption.genderId);
    ((ToServiceMsg)localObject1).extraData.putString("public_introduce", paramPublishDatingOption.introduce);
    b((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.dating", 2, "publishTraDating|dating option[" + paramPublishDatingOption.toString() + "]");
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    Object localObject = new cmd0x7db.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString);
    ((cmd0x7db.ReqBody)localObject).msg_appoint_id.set(localAppointID);
    ((cmd0x7db.ReqBody)localObject).uint32_appoint_action.set(paramInt);
    localObject = a("OidbSvc.0x7db_0", 2011, 0, ((cmd0x7db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt);
    b((ToServiceMsg)localObject);
    DatingUtil.a("send_oidb_0x7db_0", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x7da.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString);
    ((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.add(localAppointID);
    ((cmd0x7da.ReqBody)localObject).uint32_appoint_operation.set(paramInt1);
    ((cmd0x7da.ReqBody)localObject).uint32_operation_reason.set(paramInt2);
    ((cmd0x7da.ReqBody)localObject).uint32_overwrite.set(1);
    if (((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.size() > 0)
    {
      localObject = a("OidbSvc.0x7da_2", 2010, 2, ((cmd0x7da.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("appoint_ids", paramString);
      ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt1);
      b((ToServiceMsg)localObject);
    }
    DatingUtil.a("send_oidb_0x7da_2", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void b(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x7da.ReqBody();
    if (paramArrayList == null) {}
    for (int i1 = 0;; i1 = paramArrayList.size())
    {
      int i2 = 0;
      while (i2 < i1)
      {
        appoint_define.AppointID localAppointID = DatingUtil.a((String)paramArrayList.get(i2));
        if (localAppointID != null) {
          ((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.add(localAppointID);
        }
        i2 += 1;
      }
    }
    ((cmd0x7da.ReqBody)localObject).uint32_appoint_operation.set(paramInt1);
    ((cmd0x7da.ReqBody)localObject).uint32_operation_reason.set(paramInt2);
    ((cmd0x7da.ReqBody)localObject).uint32_overwrite.set(1);
    if (((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.size() > 0)
    {
      localObject = a("OidbSvc.0x7da_1", 2010, 1, ((cmd0x7da.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putStringArrayList("appoint_ids", paramArrayList);
      ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt1);
      b((ToServiceMsg)localObject);
    }
    DatingUtil.a("send_oidb_0x7da_1", new Object[] { paramArrayList, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void c(String paramString, int paramInt)
  {
    Object localObject = new cmd0x7db.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString);
    ((cmd0x7db.ReqBody)localObject).rpt_msg_appoint_ids.add(localAppointID);
    ((cmd0x7db.ReqBody)localObject).uint32_appoint_action.set(paramInt);
    ((cmd0x7db.ReqBody)localObject).uint32_overwrite.set(1);
    localObject = a("OidbSvc.0x7db_2", 2011, 2, ((cmd0x7db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt);
    b((ToServiceMsg)localObject);
    DatingUtil.a("send_oidb_0x7db_2", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingHandler
 * JD-Core Version:    0.7.0.1
 */