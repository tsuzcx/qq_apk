package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.theme.ThemeAuth.ReqBody;
import com.tencent.pb.theme.ThemeAuth.RspBody;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1ReqAuth;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1RspAuth;
import com.tencent.pb.theme.ThemeAuth.ThemeFileInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import hqa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import mqq.app.MobileQQ;

public class ThemeHandler
  extends BusinessHandler
{
  public static final String a = "Theme.ThemeHandler";
  
  ThemeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private HashMap a(String paramString)
  {
    paramString = FileUtils.a(paramString);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while ((i < 3) && (i < paramString.size()))
    {
      String str1 = (String)paramString.get(new Random().nextInt(paramString.size() - 1));
      String str2 = str1.substring(str1.substring(0, str1.lastIndexOf(47)).lastIndexOf('/') + 1);
      if ((str2 != null) && (str2.length() > 0) && (!localHashMap.containsKey(str2)))
      {
        String str3 = FileUtils.a(str1, "MD5");
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "Theme getRandomFileMd5 file=" + str1 + ",key=" + str2 + ",md5=" + str3);
        }
        if ((str3 != null) && (str3.length() > 0)) {
          localHashMap.put(str2, str3);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("AuthSvr.ThemeAuth".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      localObject1 = ThemeUtil.getUserCurrentThemeId(this.a);
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = ThemeUtil.getUserCurrentThemeVersion(this.a);
    }
    Object localObject2 = ThemeUtil.getThemeResourcePath(this.a.getApplication().getApplicationContext(), (String)localObject1, paramString1);
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeHandler", 2, "Theme Auth themeId=" + (String)localObject1 + ",version=" + paramString1 + ",currentThemeResPath=" + (String)localObject2);
    }
    if ((localObject1 != null) && (!((String)localObject1).equals("1000")) && (paramString1 != null) && (paramString1.length() > 0) && (localObject2 != null)) {
      try
      {
        paramString2 = new ThemeAuth.SubCmd0x1ReqAuth();
        paramString2.uint32_op_type.set(1);
        paramString2.uint32_theme_id.set(Integer.parseInt((String)localObject1));
        paramString2.str_theme_version.set(paramString1);
        paramString2.str_theme_density_type.set(ThemeUtil.getThemeDensity(BaseApplication.getContext()));
        if ("1000".equals(localObject1)) {
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "Theme Auth themeId=" + (String)localObject1 + ",version=" + paramString1 + ",currentThemeResPath=" + (String)localObject2);
          }
        }
        for (;;)
        {
          paramString1 = new ThemeAuth.ReqBody();
          paramString1.uint32_sub_cmd.set(1);
          paramString1.int32_plat_id.set(109);
          paramString1.str_qq_version.set("5.9.3.3468");
          paramString1.uint32_qq_version.set(Integer.parseInt("3468"));
          paramString1.msg_subcmd0x1_req_auth.set(paramString2);
          paramString1.setHasFlag(true);
          paramString2 = new ToServiceMsg("mobileqq.service", this.a.a(), "AuthSvr.ThemeAuth");
          paramString2.putWupBuffer(paramString1.toByteArray());
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "Theme Auth send request");
          }
          super.b(paramString2);
          return;
          paramString1 = a((String)localObject2).entrySet().iterator();
          while (paramString1.hasNext())
          {
            localObject1 = (Map.Entry)paramString1.next();
            if (QLog.isColorLevel()) {
              QLog.i("Theme.ThemeHandler", 2, "Theme file Info,Filepath=" + (String)((Map.Entry)localObject1).getKey() + ",FileMd5=" + (String)((Map.Entry)localObject1).getValue());
            }
            localObject2 = new ThemeAuth.ThemeFileInfo();
            ((ThemeAuth.ThemeFileInfo)localObject2).str_file_path.set((String)((Map.Entry)localObject1).getKey());
            ((ThemeAuth.ThemeFileInfo)localObject2).str_file_md5.set((String)((Map.Entry)localObject1).getValue());
            paramString2.rpt_msg_topic_file_info.add((MessageMicro)localObject2);
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "Theme Auth send Exception:" + paramString1.getMessage());
        }
        paramString1.printStackTrace();
      }
    }
  }
  
  @TargetApi(9)
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth res.isSuccess=" + paramFromServiceMsg.isSuccess() + ",data=" + PkgTools.b((byte[])paramObject));
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        try
        {
          paramFromServiceMsg = new ThemeAuth.RspBody();
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if ((paramFromServiceMsg.uint32_sub_cmd.has()) && (paramFromServiceMsg.uint32_sub_cmd.get() == 1))
          {
            i = ((ThemeAuth.SubCmd0x1RspAuth)paramFromServiceMsg.msg_subcmd0x1_rsp_auth.get()).int32_result.get();
            if (QLog.isColorLevel()) {
              QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth, authResult=" + i);
            }
            if ((i < 1) || (i > 4)) {
              break label528;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Theme.ThemeHandler", 2, "");
            }
            if (Build.VERSION.SDK_INT > 8) {
              this.a.getPreferences().edit().putInt("themeAuthResult", i).apply();
            }
            for (;;)
            {
              ThemeUtil.setCurrentThemeIdVersion(this.a, "1000", "0");
              if (3 != i) {
                break;
              }
              paramFromServiceMsg = new ThemeAuth.ReqBody();
              paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
              paramToServiceMsg = String.valueOf(((ThemeAuth.SubCmd0x1ReqAuth)paramFromServiceMsg.msg_subcmd0x1_req_auth.get()).uint32_theme_id.get());
              ThemeUtil.setErrorThemeId(this.a.getApplication().getApplicationContext(), paramToServiceMsg, false);
              paramFromServiceMsg = ThemeUtil.getUserCurrentThemeVersion(this.a);
              ThemeUtil.getThemeResourcePath(this.a.getApplication().getApplicationContext(), paramToServiceMsg, paramFromServiceMsg);
              if ((this.a != null) && (SkinEngine.getInstances().setSkinRootPath(this.a.getApplication().getApplicationContext(), null) == true)) {
                ThreadManager.c().post(new hqa(this));
              }
              paramToServiceMsg = ThemeUtil.getThemeInfo(this.a.getApplication().getApplicationContext(), paramToServiceMsg);
              if (!"5".equals(paramToServiceMsg.status)) {
                break;
              }
              paramToServiceMsg.status = "3";
              ThemeUtil.setThemeInfo(this.a.getApplication().getApplicationContext(), paramToServiceMsg);
              return;
              this.a.getPreferences().edit().putInt("themeAuthResult", i).commit();
            }
          }
          if (!QLog.isColorLevel()) {
            break label528;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth Exception=" + paramToServiceMsg.getMessage());
          }
          paramToServiceMsg.printStackTrace();
          return;
        }
        QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth error, rspBody=" + paramFromServiceMsg);
      }
      label528:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler
 * JD-Core Version:    0.7.0.1
 */