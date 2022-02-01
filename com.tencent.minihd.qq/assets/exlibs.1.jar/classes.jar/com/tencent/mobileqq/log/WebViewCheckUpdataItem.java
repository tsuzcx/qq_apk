package com.tencent.mobileqq.log;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.PreloadInfoCheckUpdateItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlReqHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlRspHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebViewConfigReq;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebViewConfigRsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewCheckUpdataItem
  implements CheckUpdateItemInterface
{
  public static long a = 0L;
  public static final String a;
  public static Set a;
  public static boolean a = false;
  private static final String b = "nextCheckWebviewTime";
  public static boolean b;
  private int jdField_a_of_type_Int = 0;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaLangString = WebViewCheckUpdataItem.class.getSimpleName();
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_Boolean = false;
    b = false;
    jdField_a_of_type_Long = 0L;
  }
  
  public WebViewCheckUpdataItem(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("js_report", jdField_a_of_type_Boolean);
      localJSONObject.put("url_check", b);
      Object localObject2;
      if (jdField_a_of_type_JavaUtilSet.size() > 0)
      {
        localObject2 = new JSONArray();
        Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
        while (localIterator.hasNext()) {
          ((JSONArray)localObject2).put(localIterator.next());
        }
      }
      Object localObject1;
      long l;
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      do
      {
        do
        {
          return;
          localJSONException.put("url_list", localObject2);
          localObject2 = new File(VipWebViewReportLog.c);
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdir();
          }
          localObject2 = new File(VipWebViewReportLog.c + "config.json");
          if (!((File)localObject2).exists()) {
            ((File)localObject2).createNewFile();
          }
          localObject2 = new FileOutputStream((File)localObject2);
          ((FileOutputStream)localObject2).write(localJSONException.toString().getBytes());
          ((FileOutputStream)localObject2).close();
        } while (this.jdField_a_of_type_Int <= 0);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        l = System.currentTimeMillis() + this.jdField_a_of_type_Int * 1000;
        ((SharedPreferences)localObject1).edit().putLong("nextCheckWebviewTime", l).commit();
      } while (!QLog.isColorLevel());
      localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l));
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData nextCheckUpdateTime" + (String)localObject1);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 126;
    Object localObject1 = new PreloadInfoCheckUpdate.WebViewConfigReq();
    Object localObject2 = new PreloadInfoCheckUpdate.ControlReqHead();
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).protocol_ver.set(1);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).client_plat_id.set(109);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).client_ver.set("5.9.3.3468");
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).os_ver.set("2cb8ec");
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).uin.set(jdField_a_of_type_Long);
    ((PreloadInfoCheckUpdate.WebViewConfigReq)localObject1).head.set((MessageMicro)localObject2);
    localObject1 = ((PreloadInfoCheckUpdate.WebViewConfigReq)localObject1).toByteArray();
    int i = localObject1.length;
    int j = i + 4;
    localObject2 = new byte[j];
    System.arraycopy(PreloadInfoCheckUpdateItem.a(j), 0, localObject2, 0, 4);
    System.arraycopy(localObject1, 0, localObject2, 4, i);
    localReqItem.vecParam = ((byte[])localObject2);
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem.eServiceID != 126) {}
    while (paramRespItem == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData respitem.cResult:" + paramRespItem.cResult);
    }
    jdField_a_of_type_Boolean = false;
    b = false;
    jdField_a_of_type_JavaUtilSet.clear();
    int i = paramRespItem.cResult;
    Object localObject = paramRespItem.vecUpdate;
    if ((i == 2) && (localObject.length > 4))
    {
      i = (int)PkgTools.a((byte[])localObject, 0);
      paramRespItem = new byte[i - 4];
      PkgTools.a(paramRespItem, 0, (byte[])localObject, 4, i - 4);
    }
    try
    {
      localObject = new PreloadInfoCheckUpdate.WebViewConfigRsp();
      ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).mergeFrom(paramRespItem);
      if (((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).head.code.get() == 0)
      {
        jdField_a_of_type_Boolean = ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).js_report.get();
        b = ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).url_check.get();
        jdField_a_of_type_JavaUtilSet.addAll(((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).url_list.get());
        this.jdField_a_of_type_Int = ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).interval.get();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData IsReportLog" + jdField_a_of_type_Boolean + ", Url_Check=" + b + ", interval=" + this.jdField_a_of_type_Int);
        }
      }
      a();
      return;
    }
    catch (Exception paramRespItem)
    {
      for (;;)
      {
        paramRespItem.printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_Long = Long.parseLong(paramString);
  }
  
  public boolean a()
  {
    try
    {
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("nextCheckWebviewTime", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      String str1;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        str1 = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder().append("isSendTemplateCheckUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str2).append(",isSend=");
        if (l2 <= l1) {
          break label151;
        }
      }
      label151:
      for (boolean bool = true;; bool = false)
      {
        QLog.d(str1, 2, bool);
        if (l2 <= l1) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.log.WebViewCheckUpdataItem
 * JD-Core Version:    0.7.0.1
 */