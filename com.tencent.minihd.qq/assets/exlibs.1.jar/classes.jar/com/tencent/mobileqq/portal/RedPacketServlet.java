package com.tencent.mobileqq.portal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageReqInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageRespInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;
import tencent.im.new_year_2014.PackData.Pack;
import tencent.im.new_year_2014.PackServer.GetNewPackReq;
import tencent.im.new_year_2014.PackServer.GetNewPackResp;
import tencent.im.new_year_2014.PackServer.PkgReq;
import tencent.im.new_year_2014.PackServer.PkgResp;
import tencent.im.new_year_2014.PackServer.QueryLuckyUsersReq;
import tencent.im.new_year_2014.PackServer.QueryLuckyUsersResp;
import tencent.im.new_year_2014.PackServer.QueryUserHistoryReq;
import tencent.im.new_year_2014.Unisso.UniSsoServerReq;
import tencent.im.new_year_2014.Unisso.UniSsoServerRsp;

public class RedPacketServlet
  extends ProtoServlet
{
  private static final String A = "ConfigurationService.ReqReportConfig";
  private static final String B = "NewYear2014.get_new_pack";
  private static final String C = "NewYear2014.query_user_history";
  private static final String D = "ConfigurationService.ReqGetConfigByPage";
  private static final String E = "NewYear2014.query_lucky_users";
  protected static final int a = 1;
  protected static final int b = 2;
  public static final String b = "PortalManager.Servlet";
  protected static final int c = 3;
  public static final String c = "key_seq";
  protected static final int d = 6;
  protected static final String d = "k_id";
  public static final int e = 0;
  protected static final String e = "k_g_uin";
  public static final int f = 1;
  protected static final String f = "k_g_type";
  public static final int g = 2;
  public static final String g = "k_result";
  public static final int h = 3;
  protected static final String h = "k_query_by_web";
  public static final int i = 4;
  protected static final String i = "k_url";
  public static final int j = 2;
  protected static final String j = "k_code";
  public static final int k = 0;
  protected static final String k = "k_msg";
  public static final int l = 1;
  protected static final String l = "k_type";
  public static final int m = 5;
  protected static final String m = "k_cache";
  private static final int jdField_n_of_type_Int = 2;
  private static final String jdField_n_of_type_JavaLangString = "k_cmd";
  private static final int jdField_o_of_type_Int = -1;
  private static final String jdField_o_of_type_JavaLangString = "k_retry";
  private static final int jdField_p_of_type_Int = 4;
  private static final String jdField_p_of_type_JavaLangString = "k_sso_id";
  private static final int jdField_q_of_type_Int = 1;
  private static final String jdField_q_of_type_JavaLangString = "k_sso_data";
  private static final int jdField_r_of_type_Int = 0;
  private static final String jdField_r_of_type_JavaLangString = "k_new_page";
  private static final int jdField_s_of_type_Int = 1;
  private static final String jdField_s_of_type_JavaLangString = "k_uin";
  private static final int jdField_t_of_type_Int = 2;
  private static final String jdField_t_of_type_JavaLangString = "k_busi";
  private static final int jdField_u_of_type_Int = 3;
  private static final String jdField_u_of_type_JavaLangString = "k_id";
  private static final int jdField_v_of_type_Int = 4;
  private static final String jdField_v_of_type_JavaLangString = "k_offset";
  private static final int jdField_w_of_type_Int = 5;
  private static final String jdField_w_of_type_JavaLangString = "k_version";
  private static final int jdField_x_of_type_Int = 6;
  private static final String jdField_x_of_type_JavaLangString = "k_cookie";
  private static int jdField_y_of_type_Int = 0;
  private static final String jdField_y_of_type_JavaLangString = "k_buff";
  private static final String z = "k_opt";
  
  static
  {
    y = 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt6 < 2) || (!NetworkUtil.f(BaseApplicationImpl.a))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "reportConfig, " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramInt5);
    }
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("k_type", paramInt1);
    localNewIntent.putExtra("k_version", paramInt2);
    localNewIntent.putExtra("k_id", paramInt3);
    localNewIntent.putExtra("k_opt", paramInt4);
    localNewIntent.putExtra("k_code", paramInt5);
    getAppRuntime().startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, paramInt, 0, 0, null, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "checkUsed, " + paramInt1 + ", " + paramInt2);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 3);
    localNewIntent.putExtra("k_id", paramInt1);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    localNewIntent.putExtra("key_seq", paramInt2);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "getConfig, " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramArrayOfByte1 + ", " + paramArrayOfByte2);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 2);
    localNewIntent.putExtra("k_offset", paramInt2);
    localNewIntent.putExtra("k_id", paramInt3);
    localNewIntent.putExtra("k_version", paramInt1);
    localNewIntent.putExtra("k_cookie", paramArrayOfByte1);
    localNewIntent.putExtra("k_buff", paramArrayOfByte2);
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localNewIntent.putExtra("k_new_page", bool);
      paramAppRuntime.startServlet(localNewIntent);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "requestResult, " + paramInt1);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 1);
    localNewIntent.putExtra("k_id", paramInt1);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    localNewIntent.putExtra("k_g_uin", paramString);
    localNewIntent.putExtra("k_g_type", paramInt3);
    localNewIntent.putExtra("k_query_by_web", paramBoolean);
    localNewIntent.putExtra("key_seq", paramInt2);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public static void b(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "requestPackList, " + paramInt1 + ", " + paramInt2);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 6);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    localNewIntent.putExtra("key_seq", paramInt1);
    localNewIntent.putExtra("bc_type", paramInt2);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i1 = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i1);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    return paramArrayOfByte;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i2 = paramIntent.getIntExtra("k_cmd", -1);
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "onReceive, cmd = " + i2);
    }
    int i3 = paramIntent.getIntExtra("k_retry", 0);
    boolean bool2 = paramFromServiceMsg.isSuccess();
    Object localObject4;
    if (bool2)
    {
      localObject4 = b(paramFromServiceMsg.getWupBuffer());
      switch (i2)
      {
      case 5: 
      default: 
        paramFromServiceMsg = null;
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if ((!bool1) && (i3 < 2))
      {
        paramIntent.putExtra("k_retry", i3 + 1);
        getAppRuntime().startServlet((NewIntent)paramIntent);
        return;
      }
      for (;;)
      {
        try
        {
          paramFromServiceMsg = new Bundle();
        }
        catch (Throwable localThrowable5)
        {
          Object localObject1;
          boolean bool3;
          int i4;
          long l1;
          int i5;
          label540:
          int i1;
          PortalManager localPortalManager;
          ConfigurationService.RespGetConfigByPage localRespGetConfigByPage;
          paramFromServiceMsg = null;
          continue;
        }
        try
        {
          paramFromServiceMsg.putInt("key_seq", paramIntent.getIntExtra("key_seq", -1));
          paramFromServiceMsg.putInt("k_id", paramIntent.getIntExtra("k_id", -1));
          localObject1 = new Unisso.UniSsoServerRsp();
          ((Unisso.UniSsoServerRsp)localObject1).mergeFrom((byte[])localObject4);
          if (((Unisso.UniSsoServerRsp)localObject1).ret.get() == 0L)
          {
            localObject4 = new PackServer.PkgResp();
            ((PackServer.PkgResp)localObject4).mergeFrom(((Unisso.UniSsoServerRsp)localObject1).rspdata.get().toByteArray());
            paramFromServiceMsg.putInt("k_code", ((PackServer.PkgResp)localObject4).errcode.get());
            bool1 = bool2;
            break;
          }
          bool1 = false;
          continue;
          bool3 = paramIntent.getBooleanExtra("k_query_by_web", false);
          localObject1 = new Bundle();
        }
        catch (Throwable localThrowable3) {}
      }
    }
    try
    {
      ((Bundle)localObject1).putBoolean("k_query_by_web", bool3);
      ((Bundle)localObject1).putInt("key_seq", paramIntent.getIntExtra("key_seq", -1));
      ((Bundle)localObject1).putInt("k_g_type", paramIntent.getIntExtra("k_g_type", 0));
      ((Bundle)localObject1).putString("k_g_uin", paramIntent.getStringExtra("k_g_uin"));
      i4 = paramIntent.getIntExtra("k_id", -1);
      paramFromServiceMsg = new Unisso.UniSsoServerRsp();
      paramFromServiceMsg.mergeFrom((byte[])localObject4);
      l1 = paramFromServiceMsg.ret.get();
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.Servlet", 2, "onReceive, result = " + l1);
      }
      if (l1 != 0L) {
        break label709;
      }
      localObject4 = new PackServer.PkgResp();
      ((PackServer.PkgResp)localObject4).mergeFrom(paramFromServiceMsg.rspdata.get().toByteArray());
      i5 = ((PackServer.PkgResp)localObject4).errcode.get();
      ((Bundle)localObject1).putInt("k_code", i5);
      ((Bundle)localObject1).putInt("k_id", i4);
      paramFromServiceMsg = (PackServer.GetNewPackResp)((PackServer.PkgResp)localObject4).get_new_pack.get();
      localObject4 = (PackData.Pack)paramFromServiceMsg.data.get();
      ((Bundle)localObject1).putInt("k_busi", ((PackData.Pack)localObject4).business.get());
      ((Bundle)localObject1).putInt("k_type", ((PackData.Pack)localObject4).type.get());
      switch (i5)
      {
      }
    }
    catch (Throwable localThrowable6)
    {
      paramFromServiceMsg = localThrowable3;
      localThrowable4 = localThrowable6;
      break label1201;
      break label1158;
      paramFromServiceMsg = null;
      break label540;
      paramFromServiceMsg = localThrowable4;
    }
    if (!TextUtils.isEmpty(paramFromServiceMsg))
    {
      localObject4 = ((PortalManager)((QQAppInterface)getAppRuntime()).getManager(74)).a(i4);
      if (localObject4 != null) {
        PortalManager.a(((PortalManager.PortalConfig)localObject4).logoMd5, "hb_packet_path");
      }
      ((Bundle)localObject1).putString("k_url", paramFromServiceMsg);
    }
    boolean bool1 = bool2;
    if (bool3)
    {
      localObject4 = new JSONObject();
      if (bool2) {}
      for (i1 = 0;; i1 = 1)
      {
        ((JSONObject)localObject4).put("time_out", i1);
        ((JSONObject)localObject4).put("activity_id", i4);
        ((JSONObject)localObject4).put("err_code", i5);
        ((JSONObject)localObject4).put("pack_url", paramFromServiceMsg);
        ((Bundle)localObject1).putString("k_msg", ((JSONObject)localObject4).toString());
        bool1 = bool2;
        break label1868;
        paramFromServiceMsg = ((PackData.Pack)localObject4).url.get();
        break;
        paramFromServiceMsg = paramFromServiceMsg.empty_url.get();
        break;
      }
      label709:
      bool1 = false;
      break label1868;
      localPortalManager = (PortalManager)((QQAppInterface)getAppRuntime()).getManager(74);
      localRespGetConfigByPage = new ConfigurationService.RespGetConfigByPage();
      localRespGetConfigByPage.mergeFrom((byte[])localObject4);
      i1 = localRespGetConfigByPage.result.get();
      paramFromServiceMsg = new Bundle();
      if (i1 != 0) {
        bool1 = false;
      }
      try
      {
        localPortalManager.a();
        paramFromServiceMsg.putInt("k_code", 3);
        a(1001, 0, 0, 1, i1, i3);
      }
      catch (Throwable localThrowable1) {}
      if (localRespGetConfigByPage.type.get() != 1001)
      {
        a(1001, 0, 0, 1, 3, i3);
        bool1 = false;
        break label1874;
      }
      i1 = paramIntent.getIntExtra("k_version", -1);
      i4 = ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).version.get();
      i5 = paramIntent.getIntExtra("k_offset", 0);
      if (!QLog.isColorLevel()) {
        break label1877;
      }
      QLog.d("PortalManager.Servlet", 1, "onReceive, " + i5 + ", " + i1 + ", " + i4);
      break label1877;
    }
    label925:
    label1201:
    label1229:
    label1494:
    label1902:
    label1906:
    for (;;)
    {
      localPortalManager.a();
      paramFromServiceMsg.putInt("k_code", 3);
      localObject4 = (ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get();
      localObject1 = paramIntent.getByteArrayExtra("k_buff");
      Object localObject5 = localRespGetConfigByPage.content.get().toByteArray();
      if (localObject1 != null) {}
      for (i1 = localObject1.length;; i1 = 0)
      {
        Object localObject6 = new ByteArrayBuffer(i1 + localObject5.length);
        if (localObject1 != null) {
          ((ByteArrayBuffer)localObject6).append((byte[])localObject1, 0, localObject1.length);
        }
        ((ByteArrayBuffer)localObject6).append((byte[])localObject5, 0, localObject5.length);
        localObject1 = ((ByteArrayBuffer)localObject6).buffer();
        i1 = ((ConfigurationService.PageRespInfo)localObject4).next_offset.get();
        if (i1 != -1) {
          break label1494;
        }
        localObject5 = ((ConfigurationService.PageRespInfo)localObject4).md5.get();
        localObject6 = PortalUtils.a((byte[])localObject1);
        i1 = ((ConfigurationService.PageRespInfo)localObject4).total_size.get();
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager.Servlet", 1, "onReceive, " + i1 + ", " + (String)localObject5 + ", " + (String)localObject6);
        }
        bool1 = bool2;
        if (i1 == 0) {
          break label1874;
        }
        if (!TextUtils.equals((CharSequence)localObject6, (CharSequence)localObject5)) {
          break label1457;
        }
        if (((ConfigurationService.PageRespInfo)localObject4).compress.get() != 1) {
          break label1860;
        }
        localObject1 = c((byte[])localObject1);
        if (localObject1 != null) {
          break label1229;
        }
        a(1001, i4, ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).task_id.get(), 1, 4, 2);
        bool1 = bool2;
        break label1874;
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager.Servlet", 2, "", localThrowable1);
        }
        bool1 = false;
        break;
      }
      localObject4 = null;
      if (localRespGetConfigByPage.delay_time.has()) {
        localObject4 = (ArrayList)localRespGetConfigByPage.delay_time.get();
      }
      localObject5 = null;
      if (localRespGetConfigByPage.seed_ids.has()) {
        localObject5 = (ArrayList)localRespGetConfigByPage.seed_ids.get();
      }
      l1 = localRespGetConfigByPage.show_time.get() & 0xFFFFFFFF;
      i1 = 0;
      if (localRespGetConfigByPage.wording_no.has()) {
        i1 = localRespGetConfigByPage.wording_no.get();
      }
      i5 = localRespGetConfigByPage.show_strategy.get();
      Object localObject2 = PortalManager.a(new String(localThrowable1, "utf-8"), i4, (ArrayList)localObject4, i1, (ArrayList)localObject5, l1, i5);
      if (localObject2 == null)
      {
        a(1001, i4, ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).task_id.get(), 1, 5, i3);
        bool1 = false;
      }
      else
      {
        a(1001, i4, ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).task_id.get(), 1, 0, 2);
        localObject2 = localPortalManager.a((PortalManager.RedPacketConfig)localObject2);
        paramFromServiceMsg.putInt("k_code", 4);
        paramFromServiceMsg.putSerializable("k_cache", (Serializable)localObject2);
        bool1 = bool2;
        break label1874;
        bool1 = false;
        a(1001, i4, ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).task_id.get(), 1, 6, i3);
        break label1874;
        if (i1 == 0) {
          break label1902;
        }
        a(getAppRuntime(), i4, ((ConfigurationService.PageRespInfo)localObject4).next_offset.get(), ((ConfigurationService.PageRespInfo)localObject4).task_id.get(), ((ConfigurationService.PageRespInfo)localObject4).cookies.get().toByteArray(), (byte[])localObject2);
        return;
        localPortalManager.a(null);
        paramFromServiceMsg.putInt("k_code", 2);
        bool1 = bool2;
        break label1874;
        bool1 = true;
        paramFromServiceMsg = new Bundle();
        break;
        localObject2 = new Unisso.UniSsoServerRsp();
        ((Unisso.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject4);
        l1 = ((Unisso.UniSsoServerRsp)localObject2).ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager.Servlet", 2, "onReceive, " + l1);
        }
        paramFromServiceMsg = new Bundle();
        if (l1 == 0L) {}
        for (;;)
        {
          try
          {
            localObject4 = new PackServer.PkgResp();
            ((PackServer.PkgResp)localObject4).mergeFrom(((Unisso.UniSsoServerRsp)localObject2).rspdata.get().toByteArray());
            i1 = ((PackServer.PkgResp)localObject4).errcode.get();
            paramFromServiceMsg.putInt("k_code", i1);
            if (i1 == 0)
            {
              paramFromServiceMsg.putString("k_result", ((PackServer.QueryLuckyUsersResp)((PackServer.PkgResp)localObject4).query_lucky_users.get()).list.get().toStringUtf8());
              bool1 = bool2;
              paramFromServiceMsg.putInt("key_seq", paramIntent.getIntExtra("key_seq", -1));
              paramFromServiceMsg.putInt("bc_type", paramIntent.getIntExtra("bc_type", -1));
              break;
            }
            paramFromServiceMsg.putString("k_result", ((PackServer.PkgResp)localObject4).errmsg.get());
            bool1 = bool2;
            continue;
          }
          catch (Throwable localThrowable2) {}
          bool1 = false;
        }
        if (i2 == 2) {
          a(1001, 0, 0, 1, 1, i3);
        }
        paramFromServiceMsg = null;
        bool1 = bool2;
        break;
        Object localObject3 = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          localObject3 = new Bundle();
        }
        notifyObserver(paramIntent, i2, bool1, (Bundle)localObject3, PortalManager.class);
        return;
        Throwable localThrowable4;
        break;
      }
      for (;;)
      {
        break;
        if ((i5 == 0) && (i1 != i4)) {
          break label1906;
        }
        if ((i5 == 0) || (i1 != i4)) {
          break label1537;
        }
        break label925;
        bool1 = false;
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i1 = paramIntent.getIntExtra("k_cmd", -1);
    int i2 = paramIntent.getIntExtra("k_retry", 0);
    boolean bool = paramIntent.getBooleanExtra("k_new_page", false);
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    if ((i2 == 0) || (bool))
    {
      localObject1 = localObject4;
      localObject2 = localObject3;
      switch (i1)
      {
      default: 
        localObject2 = localObject3;
        localObject1 = localObject4;
      case 5: 
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject2 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (!bool)
          {
            paramIntent.putExtra("k_sso_id", (String)localObject2);
            paramIntent.putExtra("k_sso_data", (byte[])localObject1);
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager.Servlet", 2, "onSend, " + i1 + ", " + i2 + ", " + bool + ", " + (String)localObject4 + ", " + localObject3);
        }
        if ((localObject4 != null) && (localObject3 != null))
        {
          paramPacket.setSSOCommand((String)localObject4);
          paramPacket.putSendData((byte[])localObject3);
        }
        return;
        localObject1 = new Unisso.UniSsoServerReq();
        localObject2 = new PackServer.PkgReq();
        ((PackServer.PkgReq)localObject2).cmdtype.set(6);
        localObject3 = paramIntent.getStringExtra("k_uin");
        i3 = paramIntent.getIntExtra("k_id", -1);
        ((PackServer.PkgReq)localObject2).uin.set(Long.parseLong((String)localObject3));
        ((PackServer.PkgReq)localObject2).from_id.set(1);
        localObject3 = new PackServer.QueryUserHistoryReq();
        ((PackServer.QueryUserHistoryReq)localObject3).promotion_id.set(i3);
        ((PackServer.PkgReq)localObject2).query_user_history.set((MessageMicro)localObject3);
        ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackServer.PkgReq)localObject2).toByteArray()));
        localObject1 = a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
        localObject2 = "NewYear2014.query_user_history";
        break;
        localObject1 = new Unisso.UniSsoServerReq();
        localObject2 = new PackServer.PkgReq();
        ((PackServer.PkgReq)localObject2).cmdtype.set(1);
        ((PackServer.PkgReq)localObject2).net_type.set(NetworkUtil.a(BaseApplicationImpl.a));
        localObject4 = paramIntent.getStringExtra("k_uin");
        i3 = y + 1;
        y = i3;
        i4 = paramIntent.getIntExtra("k_id", -1);
        ((PackServer.PkgReq)localObject2).uin.set(Long.parseLong((String)localObject4));
        ((PackServer.PkgReq)localObject2).from_id.set(1);
        localObject3 = new PackServer.GetNewPackReq();
        ((PackServer.GetNewPackReq)localObject3).promotion_id.set(i4);
        ((PackServer.GetNewPackReq)localObject3).seq.set(i3);
        ((PackServer.GetNewPackReq)localObject3).signature.set(ByteStringMicro.copyFrom(((String)localObject4 + i4 + i3).getBytes()));
        localObject4 = paramIntent.getStringExtra("k_g_uin");
        long l1 = 0L;
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {}
        try
        {
          l1 = Long.valueOf((String)localObject4).longValue();
          ((PackServer.GetNewPackReq)localObject3).group_id.set((int)l1);
          ((PackServer.GetNewPackReq)localObject3).group_type.set(paramIntent.getIntExtra("k_g_type", -1));
          ((PackServer.PkgReq)localObject2).get_new_pack.set((MessageMicro)localObject3);
          ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackServer.PkgReq)localObject2).toByteArray()));
          localObject1 = a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
          localObject2 = "NewYear2014.get_new_pack";
          paramIntent.putExtra("k_retry", 2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            l1 = 0L;
          }
        }
      }
      int i3 = paramIntent.getIntExtra("k_id", 0);
      int i4 = paramIntent.getIntExtra("k_offset", 0);
      int i5 = paramIntent.getIntExtra("k_version", 0);
      localObject2 = paramIntent.getByteArrayExtra("k_cookie");
      localObject1 = new ConfigurationService.ReqGetConfigByPage();
      localObject3 = new ConfigurationService.PageReqInfo();
      ((ConfigurationService.PageReqInfo)localObject3).task_id.set(i3);
      ((ConfigurationService.PageReqInfo)localObject3).offset.set(i4);
      ((ConfigurationService.PageReqInfo)localObject3).version.set(i5);
      if (localObject2 != null) {
        ((ConfigurationService.PageReqInfo)localObject3).cookies.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      ((ConfigurationService.ReqGetConfigByPage)localObject1).page_info.set((MessageMicro)localObject3);
      localObject2 = new ConfigurationService.DeviceInfo();
      localObject3 = new ConfigurationService.Screen();
      ((ConfigurationService.Screen)localObject3).setHasFlag(true);
      ((ConfigurationService.Screen)localObject3).model.set("");
      ((ConfigurationService.Screen)localObject3).width.set((int)DeviceInfoUtil.f());
      ((ConfigurationService.Screen)localObject3).height.set((int)DeviceInfoUtil.g());
      ((ConfigurationService.Screen)localObject3).dpi.set(DeviceInfoUtil.e());
      ((ConfigurationService.Screen)localObject3).multi_touch.set(DeviceInfoUtil.c());
      ((ConfigurationService.DeviceInfo)localObject2).setHasFlag(true);
      ((ConfigurationService.DeviceInfo)localObject2).screen = ((ConfigurationService.Screen)localObject3);
      ((ConfigurationService.ReqGetConfigByPage)localObject1).device_info.set((MessageMicro)localObject2);
      ((ConfigurationService.ReqGetConfigByPage)localObject1).type.set(1001);
      localObject1 = a(((ConfigurationService.ReqGetConfigByPage)localObject1).toByteArray());
      localObject2 = "ConfigurationService.ReqGetConfigByPage";
      break;
      localObject1 = new ConfigurationService.ReqReportConfig();
      localObject2 = new ConfigurationService.ReportConfig();
      ((ConfigurationService.ReportConfig)localObject2).type.set(paramIntent.getIntExtra("k_type", -1));
      ((ConfigurationService.ReportConfig)localObject2).task_id.set(paramIntent.getIntExtra("k_id", -1));
      ((ConfigurationService.ReportConfig)localObject2).version.set(paramIntent.getIntExtra("k_version", -1));
      ((ConfigurationService.ReportConfig)localObject2).report_type.set(paramIntent.getIntExtra("k_opt", -1));
      ((ConfigurationService.ReportConfig)localObject2).result.set(paramIntent.getIntExtra("k_code", -1));
      ((ConfigurationService.ReqReportConfig)localObject1).config_list.add((MessageMicro)localObject2);
      localObject2 = "ConfigurationService.ReqReportConfig";
      localObject1 = a(((ConfigurationService.ReqReportConfig)localObject1).toByteArray());
      paramIntent.putExtra("k_retry", 2);
      break;
      localObject1 = new Unisso.UniSsoServerReq();
      localObject2 = new PackServer.PkgReq();
      ((PackServer.PkgReq)localObject2).cmdtype.set(7);
      localObject3 = paramIntent.getStringExtra("k_uin");
      ((PackServer.PkgReq)localObject2).uin.set(Long.parseLong((String)localObject3));
      ((PackServer.PkgReq)localObject2).from_id.set(1);
      localObject3 = new PackServer.QueryLuckyUsersReq();
      ((PackServer.QueryLuckyUsersReq)localObject3).count.set(50);
      ((PackServer.PkgReq)localObject2).query_lucky_users.set((MessageMicro)localObject3);
      ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackServer.PkgReq)localObject2).toByteArray()));
      localObject1 = a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
      localObject2 = "NewYear2014.query_lucky_users";
      break;
      String str = paramIntent.getStringExtra("k_sso_id");
      localObject3 = paramIntent.getByteArrayExtra("k_sso_data");
      paramIntent.putExtra("k_new_page", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketServlet
 * JD-Core Version:    0.7.0.1
 */