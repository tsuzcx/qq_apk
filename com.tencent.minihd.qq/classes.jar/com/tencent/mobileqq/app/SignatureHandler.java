package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pb.signature.SigActPb.Platform;
import com.tencent.pb.signature.SigActPb.ReqBody;
import com.tencent.pb.signature.SigActPb.RspBody;
import com.tencent.pb.signature.SigActPb.SigactReq;
import com.tencent.pb.signature.SigActPb.SigactRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x792.oidb_0x792.ReqBody;
import tencent.im.oidb.cmd0x792.oidb_0x792.RspBody;
import tencent.im.oidb.cmd0x793.oidb_0x793.ReqBody;
import tencent.im.oidb.cmd0x793.oidb_0x793.RspBody;
import tencent.im.oidb.cmd0x793.oidb_0x793.UinListInfo;
import tencent.im.oidb.cmd0x795.oidb_0x795.ReqBody;
import tencent.im.oidb.cmd0x795.oidb_0x795.RspBody;
import tencent.im.oidb.cmd0x796.oidb_0x796.ItemInfo;
import tencent.im.oidb.cmd0x796.oidb_0x796.ReqBody;
import tencent.im.oidb.cmd0x796.oidb_0x796.RspBody;
import tencent.im.oidb.cmd0x798.oidb_0x798.Info;
import tencent.im.oidb.cmd0x798.oidb_0x798.ReqBody;
import tencent.im.oidb.cmd0x798.oidb_0x798.RspBody;
import tencent.im.oidb.cmd0x799.oidb_0x799.LongNickInfo;
import tencent.im.oidb.cmd0x799.oidb_0x799.ReqBody;
import tencent.im.oidb.cmd0x799.oidb_0x799.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SignatureHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static final long a = 10000L;
  public static final String a = "SignatureHandler";
  public static final int b = 3;
  public static final long b = 30000L;
  public static final String b = "sigCommentUpdateTimeStamp_";
  public static final int c = 5;
  public static final String c = "sigNewCommentLastFetchTime";
  public static final int d = 6;
  public static final String d = "sigCommentDetailUin_";
  public static final int e = 7;
  public static final String e = "sigCommentDetailTime_";
  public static final int f = 100;
  public static final String f = "sigCommentDetailSeq_";
  public static final String g = "sigNewCommentLastUin_";
  public static final String h = "sigNewCommentLastFeedsId_";
  public static final String i = "sigNewCommentLastFeedsTime_";
  private static final String j = "OidbSvc.0x792_0";
  private static final String k = "OidbSvc.0x793_0";
  private static final String l = "OidbSvc.0x795_0";
  private static final String m = "OidbSvc.0x796_0";
  private static final String n = "OidbSvc.0x798_0";
  private static final String o = "OidbSvc.0x799_0";
  private static final String p = "Signature.act";
  private int g = 0;
  
  protected SignatureHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    oidb_0x798.RspBody localRspBody = new oidb_0x798.RspBody();
    localRspBody.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
    int i1 = localRspBody.uint32_result.get();
    String str;
    if (i1 == 0) {
      if ((localRspBody.stInfos.has()) && (localRspBody.stInfos.get().size() > 0))
      {
        paramOIDBSSOPkg = paramIntent.getStringExtra("uin");
        str = paramIntent.getStringExtra("feedsid");
        paramIntent = ((FriendsManager)this.a.getManager(49)).a(paramOIDBSSOPkg);
        if (paramIntent == null) {
          break label424;
        }
        paramIntent = paramIntent.getRichStatus();
        if (paramIntent != null) {}
      }
      else
      {
        return;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramIntent.f)) && (paramIntent.f.equals(str)) && (paramIntent.jdField_a_of_type_JavaUtilHashMap == null)) {
        paramIntent.jdField_a_of_type_JavaUtilHashMap = new HashMap(localRspBody.stInfos.get().size());
      }
      List localList = localRspBody.stInfos.get();
      i1 = 0;
      while (i1 < localList.size())
      {
        RichStatus.SigZanInfo localSigZanInfo = new RichStatus.SigZanInfo();
        oidb_0x798.Info localInfo = (oidb_0x798.Info)localList.get(i1);
        localSigZanInfo.jdField_a_of_type_JavaLangString = str;
        localSigZanInfo.b = localInfo.uint32_count.get();
        localSigZanInfo.jdField_a_of_type_Int = localInfo.uint32_type.get();
        localSigZanInfo.c = localInfo.uint32_flag.get();
        paramIntent.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localSigZanInfo.jdField_a_of_type_Int), localSigZanInfo);
        i1 += 1;
      }
      long l1 = localRspBody.uint64_sleeptime.get();
      long l2 = System.currentTimeMillis();
      this.a.getPreferences().edit().putLong("sigCommentUpdateTimeStamp_" + paramOIDBSSOPkg, l1 * 1000L + l2).commit();
      if (paramIntent.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(255)) == null) {
        break;
      }
      this.g = 93;
      a(this.g, true, paramIntent.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(255)));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SignatureHandler", 2, "handleGetSigZanInfo fail ret=" + i1);
      return;
      label424:
      paramIntent = null;
    }
  }
  
  private boolean a(String[] paramArrayOfString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfByte == null)) {
      return false;
    }
    Object localObject = new ArrayList(paramArrayOfString.length);
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      ((List)localObject).add(ByteStringMicro.copyFrom(paramArrayOfString[i1].getBytes()));
      i1 += 1;
    }
    paramArrayOfString = new oidb_0x799.ReqBody();
    paramArrayOfString.StrTopicIdList.set((List)localObject);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1945);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfString.toByteArray()));
    paramArrayOfString = new NewIntent(this.a.a(), SignatureServlet.class);
    if (paramArrayOfByte != null) {
      paramArrayOfString.putExtra("reqData", paramArrayOfByte);
    }
    paramArrayOfString.putExtra("cmd", "OidbSvc.0x799_0");
    paramArrayOfString.putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramArrayOfString.putExtra("timeout", 10000L);
    this.a.startServlet(paramArrayOfString);
    return true;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramIntent = new SigActPb.RspBody();
    paramIntent.mergeFrom(paramArrayOfByte);
    if (paramIntent.ret.get() == 0)
    {
      a(7, true, Integer.valueOf(((SigActPb.SigactRsp)paramIntent.rsp.get()).rank.get()));
      return;
    }
    a(7, false, Integer.valueOf(paramIntent.ret.get()));
  }
  
  private void b(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    oidb_0x795.RspBody localRspBody = new oidb_0x795.RspBody();
    localRspBody.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
    paramOIDBSSOPkg = paramIntent.getStringExtra("feedid");
    String str = paramIntent.getStringExtra("uin");
    int i1 = paramIntent.getIntExtra("action", 0);
    paramIntent = ((FriendsManager)this.a.getManager(49)).a(str);
    if ((paramIntent != null) && (paramOIDBSSOPkg.equals(paramIntent.getRichStatus().f)) && (paramIntent.getRichStatus().jdField_a_of_type_JavaUtilHashMap != null))
    {
      paramIntent = (RichStatus.SigZanInfo)paramIntent.getRichStatus().jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(255));
      if (localRspBody.uint32_result.get() == 0)
      {
        if (1 == i1)
        {
          paramIntent.b += 1;
          paramIntent.c = 1;
        }
      }
      else
      {
        this.g = 93;
        a(this.g, true, paramIntent);
      }
    }
    else
    {
      return;
    }
    i1 = paramIntent.b - 1;
    paramIntent.b = i1;
    if (i1 > 0) {}
    for (i1 = paramIntent.b;; i1 = 0)
    {
      paramIntent.b = i1;
      paramIntent.c = 0;
      break;
    }
  }
  
  private void c(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    Object localObject1 = new oidb_0x796.RspBody();
    ((oidb_0x796.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
    paramOIDBSSOPkg = paramIntent.getStringExtra("feedid");
    boolean bool2 = paramIntent.getBooleanExtra("firstFlag", true);
    int i1 = ((oidb_0x796.RspBody)localObject1).uint32_result.get();
    if (i1 == 0)
    {
      if (((oidb_0x796.RspBody)localObject1).uint32_flag.get() == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ((oidb_0x796.RspBody)localObject1).uint32_rsp_seq.get();
        ((oidb_0x796.RspBody)localObject1).uint32_need_update.get();
        paramIntent = (oidb_0x796.ItemInfo)((oidb_0x796.RspBody)localObject1).stPagePointItem.get();
        if (!bool1) {
          this.a.getPreferences().edit().putLong("sigCommentDetailUin_" + paramOIDBSSOPkg, paramIntent.uint64_uin.get()).putLong("sigCommentDetailTime_" + paramOIDBSSOPkg, paramIntent.uint64_time.get()).commit();
        }
        if ((((oidb_0x796.RspBody)localObject1).rpt_items == null) || (((oidb_0x796.RspBody)localObject1).rpt_items.size() <= 0)) {
          break label438;
        }
        paramIntent = new ArrayList(((oidb_0x796.RspBody)localObject1).rpt_items.get().size());
        localObject1 = ((oidb_0x796.RspBody)localObject1).rpt_items.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (oidb_0x796.ItemInfo)((Iterator)localObject1).next();
          localObject2 = ((oidb_0x796.ItemInfo)localObject2).uint64_uin.get() + "";
          if (!paramIntent.contains(localObject2)) {
            paramIntent.add(localObject2);
          }
        }
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("feedid", paramOIDBSSOPkg);
      ((Bundle)localObject1).putBoolean("overFlag", bool1);
      ((Bundle)localObject1).putBoolean("firstFlag", bool2);
      ((Bundle)localObject1).putStringArrayList("uins", paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("SignatureHandler", 2, "oidb796cmd feedid=" + paramOIDBSSOPkg + ", firstFlag=" + bool2 + ", overFlag=" + bool1 + ",num:" + paramIntent.size());
      }
      a(3, true, localObject1);
      label438:
      return;
    }
    a(3, false, Integer.valueOf(i1));
  }
  
  private void d(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    paramIntent = new oidb_0x792.RspBody();
    byte[] arrayOfByte = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    if (paramOIDBSSOPkg.uint32_result.get() == 0)
    {
      paramIntent.mergeFrom(arrayOfByte);
      if (paramIntent.uint32_result.get() != 0) {
        break label148;
      }
      i1 = paramIntent.uint32_newnum.get();
      i2 = paramIntent.uint32_sleeptime.get();
      l1 = paramIntent.uint64_lastuin.get();
      this.a.getPreferences().edit().putLong("sigNewCommentLastFetchTime", System.currentTimeMillis() + i2 * 1000);
      if ((i1 != 0) && (0L != l1))
      {
        paramIntent = new Bundle();
        paramIntent.putInt("unReadNum", i1);
        paramIntent.putLong("lastUin", l1);
        a(5, true, paramIntent);
      }
    }
    label148:
    while (!QLog.isColorLevel())
    {
      int i1;
      int i2;
      long l1;
      return;
    }
    QLog.d("SignatureHandler", 2, "handleGetNewCommentNum fial retcode:" + paramIntent.uint32_result.get());
  }
  
  private void e(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    oidb_0x793.RspBody localRspBody;
    if (paramOIDBSSOPkg.uint32_result.get() == 0)
    {
      localRspBody = new oidb_0x793.RspBody();
      byte[] arrayOfByte = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      localRspBody.mergeFrom(arrayOfByte);
      for (;;)
      {
        ArrayList localArrayList;
        try
        {
          if (localRspBody.uint32_result.get() != 0) {
            break;
          }
          SignatureManager localSignatureManager = (SignatureManager)this.a.getManager(56);
          paramIntent = null;
          localArrayList = new ArrayList();
          paramOIDBSSOPkg = new ArrayList();
          Iterator localIterator = localRspBody.rpt_uinlist.get().iterator();
          if (localIterator.hasNext())
          {
            Object localObject = (oidb_0x793.UinListInfo)localIterator.next();
            paramIntent = new SignatureManager.SigCommentInfo();
            paramIntent.feedsid = new String(((oidb_0x793.UinListInfo)localObject).feedsid.get().toByteArray());
            paramIntent.type = ((oidb_0x793.UinListInfo)localObject).uint32_type.get();
            paramIntent.time = ((oidb_0x793.UinListInfo)localObject).uint64_time.get();
            paramIntent.uin = ((oidb_0x793.UinListInfo)localObject).uint64_uin.get();
            if (localSignatureManager != null)
            {
              localObject = localSignatureManager.a(paramIntent.feedsid);
              if (localObject != null)
              {
                paramIntent.rs = ((RichStatus)localObject);
                paramOIDBSSOPkg.add(paramIntent);
                break label570;
              }
            }
            localArrayList.add(paramIntent.feedsid);
          }
        }
        catch (Exception paramIntent)
        {
          a(6, false, Integer.valueOf(-1));
          if (QLog.isColorLevel()) {
            QLog.d("SignatureHandler", 2, "handleGetNewComment fail retcode=" + localRspBody.uint32_result.get() + ",msg=" + paramIntent.getMessage());
          }
          return;
        }
        int i1 = localRspBody.uint32_flag.get();
        if ((i1 == 0) && (paramIntent != null)) {
          this.a.getPreferences().edit().putLong("sigNewCommentLastUin_", paramIntent.uin).putLong("sigNewCommentLastFetchTime", paramIntent.time).putString("sigNewCommentLastFeedsId_", paramIntent.feedsid).commit();
        }
        if (localArrayList.size() > 0)
        {
          if (!a((String[])localArrayList.toArray(new String[localArrayList.size()]), arrayOfByte)) {
            a(6, false, Integer.valueOf(-1000));
          }
        }
        else
        {
          paramIntent = new SignatureManager.SigComments();
          if (i1 != 1) {
            break label573;
          }
        }
      }
    }
    label570:
    label573:
    for (boolean bool = true;; bool = false)
    {
      paramIntent.isOver = bool;
      paramIntent.mlist = paramOIDBSSOPkg;
      paramOIDBSSOPkg = new Bundle();
      paramOIDBSSOPkg.putSerializable("data", paramIntent);
      a(6, true, paramOIDBSSOPkg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SignatureHandler", 2, "handleGetNewComment fail ret=" + localRspBody.uint32_result.get() + ",msg=" + localRspBody.errMsg.get());
      }
      a(6, false, Integer.valueOf(localRspBody.uint32_result.get()));
      return;
      a(6, false, Integer.valueOf(paramOIDBSSOPkg.uint32_result.get()));
      return;
      break;
    }
  }
  
  private void f(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramOIDBSSOPkg.uint32_result.get() == 0)
    {
      Object localObject1 = new oidb_0x799.RspBody();
      ((oidb_0x799.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      if (((oidb_0x799.RspBody)localObject1).uint32_result.get() == 0)
      {
        paramOIDBSSOPkg = ((oidb_0x799.RspBody)localObject1).astLongNickInfoList.get();
        localObject1 = new ArrayList(paramOIDBSSOPkg.size());
        paramOIDBSSOPkg = paramOIDBSSOPkg.iterator();
        Object localObject3;
        while (paramOIDBSSOPkg.hasNext())
        {
          localObject3 = (oidb_0x799.LongNickInfo)paramOIDBSSOPkg.next();
          localObject2 = ((oidb_0x799.LongNickInfo)localObject3).StrNick.get().toByteArray();
          localObject3 = new String(((oidb_0x799.LongNickInfo)localObject3).StrTopicId.get().toByteArray());
          localObject2 = RichStatus.a((byte[])localObject2);
          ((RichStatus)localObject2).f = ((String)localObject3);
          ((List)localObject1).add(localObject2);
        }
        paramOIDBSSOPkg = (SignatureManager)this.a.getManager(56);
        if (paramOIDBSSOPkg != null) {
          paramOIDBSSOPkg.a((List)localObject1);
        }
        localObject1 = paramIntent.getByteArrayExtra("reqData");
        paramIntent = new oidb_0x793.RspBody();
        paramIntent.mergeFrom((byte[])localObject1);
        localObject1 = new ArrayList(paramIntent.rpt_uinlist.size());
        Object localObject2 = paramIntent.rpt_uinlist.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (oidb_0x793.UinListInfo)((Iterator)localObject2).next();
          localObject3 = new SignatureManager.SigCommentInfo();
          ((SignatureManager.SigCommentInfo)localObject3).feedsid = new String(((oidb_0x793.UinListInfo)localObject4).feedsid.get().toByteArray());
          ((SignatureManager.SigCommentInfo)localObject3).type = ((oidb_0x793.UinListInfo)localObject4).uint32_type.get();
          ((SignatureManager.SigCommentInfo)localObject3).time = ((oidb_0x793.UinListInfo)localObject4).uint64_time.get();
          ((SignatureManager.SigCommentInfo)localObject3).uin = ((oidb_0x793.UinListInfo)localObject4).uint64_uin.get();
          if (paramOIDBSSOPkg != null)
          {
            localObject4 = paramOIDBSSOPkg.a(((SignatureManager.SigCommentInfo)localObject3).feedsid);
            if (localObject4 != null)
            {
              ((SignatureManager.SigCommentInfo)localObject3).rs = ((RichStatus)localObject4);
              ((List)localObject1).add(localObject3);
            }
          }
        }
        int i1 = paramIntent.uint32_flag.get();
        paramIntent = new SignatureManager.SigComments();
        if (i1 == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramIntent.isOver = bool;
          paramIntent.mlist = ((List)localObject1);
          paramOIDBSSOPkg = new Bundle();
          paramOIDBSSOPkg.putSerializable("data", paramIntent);
          a(6, true, paramOIDBSSOPkg);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SignatureHandler", 2, "handleGetRichStatusByFeedsId fail ret=" + ((oidb_0x799.RspBody)localObject1).uint32_result.get());
      }
      a(6, false, Integer.valueOf(((oidb_0x799.RspBody)localObject1).uint32_result.get()));
      return;
    }
    a(6, false, Integer.valueOf(paramOIDBSSOPkg.uint32_result.get()));
  }
  
  protected Class a()
  {
    if (this.g == 93) {
      return FriendListObserver.class;
    }
    return SignatureObserver.class;
  }
  
  public void a()
  {
    long l1 = this.a.getPreferences().getLong("sigNewCommentLastFetchTime", 0L);
    if (System.currentTimeMillis() < Long.valueOf(l1).longValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignatureHandler", 2, "getNewCommentNum freq limit");
      }
      return;
    }
    Object localObject = new oidb_0x792.ReqBody();
    ((oidb_0x792.ReqBody)localObject).uint64_uin.set(Long.valueOf(this.a.getAccount()).longValue());
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1938);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x792.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.a.a(), SignatureServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x792_0");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 30000);
    this.a.startServlet((NewIntent)localObject);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new SigActPb.Platform();
    ((SigActPb.Platform)localObject).implat.set(109L);
    ((SigActPb.Platform)localObject).mqqver.set("5.9.3");
    ((SigActPb.Platform)localObject).osver.set(DeviceInfoUtil.e());
    SigActPb.SigactReq localSigactReq = new SigActPb.SigactReq();
    localSigactReq.actid.set(paramInt1);
    localSigactReq.acttype.set(paramInt2);
    localSigactReq.uin.set(Long.valueOf(this.a.getAccount()).longValue());
    SigActPb.ReqBody localReqBody = new SigActPb.ReqBody();
    localReqBody.cmd.set(1);
    localReqBody.plf.set((MessageMicro)localObject);
    localReqBody.req.set(localSigactReq);
    localReqBody.seq.set(System.currentTimeMillis());
    localObject = new NewIntent(this.a.a(), SignatureServlet.class);
    ((NewIntent)localObject).putExtra("actId", paramInt1);
    ((NewIntent)localObject).putExtra("actType", paramInt2);
    ((NewIntent)localObject).putExtra("cmd", "Signature.act");
    ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 10000L);
    this.a.startServlet((NewIntent)localObject);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    for (;;)
    {
      try
      {
        this.g = 0;
        if ("Signature.act".equals(str))
        {
          b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
          return;
        }
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramArrayOfByte);
        i1 = paramFromServiceMsg.uint32_result.get();
        int i2 = paramFromServiceMsg.uint32_command.get();
        switch (i2)
        {
        case 1940: 
        case 1943: 
          throw new Exception("Unknow oidb cmd" + i2);
        }
      }
      catch (Exception paramIntent)
      {
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.e("SignatureHandler", 2, "sign handler onRecive fail err:" + paramIntent.getMessage());
          return;
          d(paramIntent, paramFromServiceMsg);
          if (QLog.isColorLevel())
          {
            QLog.d("SignatureHandler", 2, "oidb_0x792|OIDBSSOPkg.result " + i1);
            return;
            e(paramIntent, paramFromServiceMsg);
            continue;
            b(paramIntent, paramFromServiceMsg);
            continue;
            c(paramIntent, paramFromServiceMsg);
            continue;
            a(paramIntent, paramFromServiceMsg);
            continue;
            f(paramIntent, paramFromServiceMsg);
            continue;
          }
        }
        return;
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    long l1;
    do
    {
      return;
      l1 = this.a.getPreferences().getLong("sigCommentUpdateTimeStamp_" + paramString1, 0L);
      if (System.currentTimeMillis() >= l1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SignatureHandler", 2, "getSigZanInfo freq limit");
    return;
    Object localObject = new oidb_0x798.ReqBody();
    ((oidb_0x798.ReqBody)localObject).feedsid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    ((oidb_0x798.ReqBody)localObject).uint64_time.set(l1);
    ((oidb_0x798.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
    ((oidb_0x798.ReqBody)localObject).uint32_type.set(Arrays.asList(new Integer[] { Integer.valueOf(255) }));
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1944);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x798.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.a.a(), SignatureServlet.class);
    ((NewIntent)localObject).putExtra("uin", paramString1);
    ((NewIntent)localObject).putExtra("feedsid", paramString2);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x798_0");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 10000L);
    this.a.startServlet((NewIntent)localObject);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      localObject1 = ((FriendsManager)this.a.getManager(49)).a(paramString1);
    } while (localObject1 == null);
    Object localObject2 = ((ExtensionInfo)localObject1).getRichStatus();
    Object localObject1 = new oidb_0x795.ReqBody();
    ((oidb_0x795.ReqBody)localObject1).feedsid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    ((oidb_0x795.ReqBody)localObject1).uint64_time.set(((RichStatus)localObject2).jdField_a_of_type_Long);
    ((oidb_0x795.ReqBody)localObject1).uint64_uin.set(Long.valueOf(paramString1).longValue());
    ((oidb_0x795.ReqBody)localObject1).uint32_type.set(paramInt1);
    ((oidb_0x795.ReqBody)localObject1).uint32_action.set(paramInt2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1941);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x795.ReqBody)localObject1).toByteArray()));
    localObject1 = new NewIntent(this.a.a(), SignatureServlet.class);
    ((NewIntent)localObject1).putExtra("uin", paramString1);
    ((NewIntent)localObject1).putExtra("feedid", paramString2);
    ((NewIntent)localObject1).putExtra("type", paramInt1);
    ((NewIntent)localObject1).putExtra("action", paramInt2);
    ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x795_0");
    ((NewIntent)localObject1).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((NewIntent)localObject1).putExtra("timeout", 10000L);
    this.a.startServlet((NewIntent)localObject1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      localObject1 = ((FriendsManager)this.a.getManager(49)).a(paramString1);
    } while (localObject1 == null);
    Object localObject1 = ((ExtensionInfo)localObject1).getRichStatus();
    oidb_0x796.ReqBody localReqBody = new oidb_0x796.ReqBody();
    localReqBody.feedsid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localReqBody.uint64_time.set(((RichStatus)localObject1).jdField_a_of_type_Long);
    localReqBody.uint64_uin.set(Long.valueOf(paramString1).longValue());
    localReqBody.uint32_type.set(paramInt);
    Object localObject2 = Long.valueOf(0L);
    localObject1 = Long.valueOf(0L);
    if (!paramBoolean)
    {
      localObject1 = this.a.getPreferences();
      localObject2 = Long.valueOf(((SharedPreferences)localObject1).getLong("sigCommentDetailUin_" + paramString2, 0L));
      localObject1 = Long.valueOf(((SharedPreferences)localObject1).getLong("sigCommentDetailTime_" + paramString2, 0L));
    }
    oidb_0x796.ItemInfo localItemInfo = new oidb_0x796.ItemInfo();
    localItemInfo.uint64_time.set(((Long)localObject1).longValue());
    localItemInfo.uint64_uin.set(((Long)localObject2).longValue());
    localReqBody.stLastInfo.set(localItemInfo);
    localReqBody.uint32_seq.set(0);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1942);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localObject2 = new NewIntent(this.a.a(), SignatureServlet.class);
    ((NewIntent)localObject2).putExtra("uin", paramString1);
    ((NewIntent)localObject2).putExtra("feedid", paramString2);
    ((NewIntent)localObject2).putExtra("firstFlag", paramBoolean);
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x796_0");
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((NewIntent)localObject2).putExtra("timeout", 10000L);
    this.a.startServlet((NewIntent)localObject2);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject3 = "0";
    Object localObject2 = Long.valueOf(0L);
    Object localObject1 = Long.valueOf(0L);
    if (!paramBoolean)
    {
      localObject3 = this.a.getPreferences();
      localObject2 = Long.valueOf(((SharedPreferences)localObject3).getLong("sigNewCommentLastUin_", 0L));
      localObject1 = Long.valueOf(((SharedPreferences)localObject3).getLong("sigNewCommentLastFetchTime", 0L));
      localObject3 = ((SharedPreferences)localObject3).getString("sigNewCommentLastFeedsId_", "0");
    }
    oidb_0x793.ReqBody localReqBody = new oidb_0x793.ReqBody();
    localReqBody.feedsid.set(ByteStringMicro.copyFrom(((String)localObject3).getBytes()));
    localReqBody.uint64_uin.set(((Long)localObject2).longValue());
    localReqBody.uint64_time.set(((Long)localObject1).longValue());
    localReqBody.uint32_getnum.set(100);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1939);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localObject2 = new NewIntent(this.a.a(), SignatureServlet.class);
    ((NewIntent)localObject2).putExtra("feedsId", "OidbSvc.0x793_0");
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x793_0");
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((NewIntent)localObject2).putExtra("timeout", 10000L);
    this.a.startServlet((NewIntent)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureHandler
 * JD-Core Version:    0.7.0.1
 */