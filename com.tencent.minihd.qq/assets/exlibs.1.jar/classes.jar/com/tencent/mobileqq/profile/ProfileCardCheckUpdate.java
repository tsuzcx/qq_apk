package com.tencent.mobileqq.profile;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vipav.VipFunCallConstants;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReq;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReqBatch;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRsp;
import com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRspBatch;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jmn;
import jmo;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileCardCheckUpdate
  implements CheckUpdateItemInterface
{
  public static final int a = 1000277;
  public static final String a = "ProfileCard.ProfileCardCheckUpdate";
  public static final String b = "profileFuncallVersion";
  private static final int jdField_c_of_type_Int = 1;
  private static final String jdField_c_of_type_JavaLangString = "nextCheckUpdateTimeMillis";
  private static final int jdField_d_of_type_Int = 2;
  private static final String jdField_d_of_type_JavaLangString = "cardTemplateVersion";
  private static final int jdField_e_of_type_Int = 4;
  private static final String jdField_e_of_type_JavaLangString = "nextCheckLabelUpdateTimeMillis";
  private static final String f = "profileLabelVersion";
  private static final String g = "nextCheckFuncallUpdateTimeMillis";
  public QQAppInterface a;
  int b = 0;
  
  public ProfileCardCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private SummaryCardUpdate.SUpdateReq a(int paramInt, String paramString)
  {
    SummaryCardUpdate.SUpdateReq localSUpdateReq = new SummaryCardUpdate.SUpdateReq();
    localSUpdateReq.cmd.set(paramInt);
    localSUpdateReq.uin.set(this.a.getLongAccountUin());
    localSUpdateReq.version.set(paramString);
    localSUpdateReq.client_version.set("5.9.3");
    localSUpdateReq.platform.set(109);
    if (paramInt == 5) {
      localSUpdateReq.appname.set("fun_call");
    }
    return localSUpdateReq;
  }
  
  private List a(String paramString)
  {
    Object localObject1 = null;
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson labelConfigJsonData length is :" + paramString.length());
      }
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONArray(paramString);
      int k = paramString.length();
      int i = 0;
      while (i < k)
      {
        Object localObject2 = paramString.optJSONObject(i);
        localObject1 = new ProfileLabelTypeInfo();
        ((ProfileLabelTypeInfo)localObject1).typeId = ((JSONObject)localObject2).optString("id");
        ((ProfileLabelTypeInfo)localObject1).typeName = ((JSONObject)localObject2).optString("name");
        ((ProfileLabelTypeInfo)localObject1).typeInfo = ((JSONObject)localObject2).optString("classinfo");
        localObject2 = ((JSONObject)localObject2).optJSONArray("taglist");
        int m = ((JSONArray)localObject2).length();
        int j = 0;
        while (j < m)
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
          ProfileLabelInfo localProfileLabelInfo = new ProfileLabelInfo();
          localProfileLabelInfo.labelId = Long.valueOf(localJSONObject.optLong("id"));
          localProfileLabelInfo.labelName = localJSONObject.optString("name");
          localProfileLabelInfo.typeId = ((ProfileLabelTypeInfo)localObject1).typeId;
          ((ProfileLabelTypeInfo)localObject1).labels.add(localProfileLabelInfo);
          j += 1;
        }
        localArrayList.add(localObject1);
        i += 1;
      }
      localObject1 = localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "downloadLabelConfigJson the new typeList size =" + localArrayList.size());
        localObject1 = localArrayList;
      }
    }
    return localObject1;
  }
  
  private void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson labelConfigTempFile is exist :" + paramFile.exists());
    }
    if (paramFile.exists())
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte, 0, 4096);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramFile.delete();
      paramFile = new String(localByteArrayOutputStream.toByteArray(), "utf-8");
      if ((paramFile != null) && (paramFile.length() > 0)) {
        a(paramFile);
      }
    }
  }
  
  private void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramString);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      FileUtils.a(new File(BaseApplicationImpl.a().getFilesDir(), "labelList").getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
    }
  }
  
  public static byte[] a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)((0xFF00 & paramInt) >> 8);
    int k = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), k, j, i };
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    try
    {
      long l1 = this.a.getPreferences().getLong("nextCheckFuncallUpdateTimeMillis", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendFuncallUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label178;
        }
      }
      label178:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool1);
        if (l2 <= l1)
        {
          boolean bool3 = new File(VipFunCallConstants.b).exists();
          bool1 = bool2;
          if (bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    try
    {
      long l1 = this.a.getPreferences().getLong("nextCheckUpdateTimeMillis", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendTemplateCheckUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label189;
        }
      }
      label189:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool1);
        localObject = new File(ProfileCardUtil.b(this.a.a()));
        if (l2 <= l1)
        {
          boolean bool3 = ((File)localObject).exists();
          bool1 = bool2;
          if (bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    try
    {
      long l1 = this.a.getPreferences().getLong("nextCheckLabelUpdateTimeMillis", 0L);
      long l2 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
        localObject = new StringBuilder().append("isSendCheckLabelUpdate nextCheckUpdateTime=").append((String)localObject).append(",systemTimestamp=").append(str).append(",isSend=");
        if (l2 <= l1) {
          break label189;
        }
      }
      label189:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, bool1);
        localObject = new File(ProfileCardUtil.a(this.a.getApplication()));
        if (l2 <= l1)
        {
          boolean bool3 = ((File)localObject).exists();
          bool1 = bool2;
          if (bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public ReqItem a()
  {
    Object localObject1 = this.a.getPreferences();
    long l = System.currentTimeMillis();
    ((SharedPreferences)localObject1).edit().putLong("nextCheckUpdateTimeMillis", l + 3600000L).commit();
    String str1 = ((SharedPreferences)localObject1).getString("cardTemplateVersion", "0");
    String str2 = ((SharedPreferences)localObject1).getString("profileLabelVersion", "0");
    Object localObject3 = ((SharedPreferences)localObject1).getString("profileFuncallVersion", "0");
    localObject1 = new ReqItem();
    ((ReqItem)localObject1).eServiceID = 122;
    Object localObject2 = new SummaryCardUpdate.SUpdateReqBatch();
    SummaryCardUpdate.SUpdateReq localSUpdateReq;
    if ((this.b & 0x1) != 0)
    {
      localSUpdateReq = a(3, str1);
      ((SummaryCardUpdate.SUpdateReqBatch)localObject2).reqs.add(localSUpdateReq);
    }
    if ((this.b & 0x2) != 0)
    {
      localSUpdateReq = a(4, str2);
      ((SummaryCardUpdate.SUpdateReqBatch)localObject2).reqs.add(localSUpdateReq);
    }
    if ((this.b & 0x4) != 0)
    {
      localObject3 = a(5, (String)localObject3);
      ((SummaryCardUpdate.SUpdateReqBatch)localObject2).reqs.add((MessageMicro)localObject3);
    }
    localObject2 = ((SummaryCardUpdate.SUpdateReqBatch)localObject2).toByteArray();
    int i = localObject2.length;
    int j = i + 4;
    localObject3 = new byte[j];
    System.arraycopy(a(j), 0, localObject3, 0, 4);
    System.arraycopy(localObject2, 0, localObject3, 4, i);
    ((ReqItem)localObject1).vecParam = ((byte[])localObject3);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "getCheckUpdateItemData uin=" + this.a.getLongAccountUin() + ",cardVersion=" + str1 + "labelVersion=" + str2 + ",client_version=" + "5.9.3" + ",dataLen=" + j);
    }
    return localObject1;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      int i = paramRespItem.cResult;
      Object localObject = paramRespItem.vecUpdate;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "handleCheckUpdateItemData result=" + i + ",dataLen=" + localObject.length);
      }
      if (i == 2) {
        for (;;)
        {
          try
          {
            if (localObject.length <= 4) {
              break;
            }
            i = (int)PkgTools.a((byte[])localObject, 0);
            paramRespItem = new byte[i - 4];
            PkgTools.a(paramRespItem, 0, (byte[])localObject, 4, i - 4);
            localObject = new SummaryCardUpdate.SUpdateRspBatch();
            ((SummaryCardUpdate.SUpdateRspBatch)localObject).mergeFrom(paramRespItem);
            if (((SummaryCardUpdate.SUpdateRspBatch)localObject).rsps.size() < 0)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate SUpdateRspBatch have no rsp");
              return;
            }
            paramRespItem = ((SummaryCardUpdate.SUpdateRspBatch)localObject).rsps.get().iterator();
            if (!paramRespItem.hasNext()) {
              break;
            }
            localObject = (SummaryCardUpdate.SUpdateRsp)paramRespItem.next();
            if (localObject == null) {
              continue;
            }
            i = ((SummaryCardUpdate.SUpdateRsp)localObject).cmd.get();
            if (i == 3)
            {
              c((SummaryCardUpdate.SUpdateRsp)localObject);
              continue;
            }
            if (i != 4) {
              break label242;
            }
          }
          catch (Exception paramRespItem)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate Exception msg=" + paramRespItem.getMessage());
            }
            paramRespItem.printStackTrace();
            return;
          }
          b((SummaryCardUpdate.SUpdateRsp)localObject);
          continue;
          label242:
          if (i == 5) {
            a((SummaryCardUpdate.SUpdateRsp)localObject);
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleCheckUpdateItemData respitem is null");
    }
  }
  
  public void a(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str = paramSUpdateRsp.version.get();
    Object localObject = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    paramSUpdateRsp = paramSUpdateRsp.buff.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleFunCallRsp data code=" + i + ",version=" + str + ",url=" + (String)localObject + ",interval=" + j);
    }
    if (i == 0)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("fun_call_sp_file", 4);
      localSharedPreferences.edit().putString("key_fun_call_conf_url", (String)localObject).commit();
      localSharedPreferences.edit().putString("key_fun_call_buff", paramSUpdateRsp).commit();
      if (j >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = j * 1000;
        localSharedPreferences.edit().putLong("nextCheckFuncallUpdateTimeMillis", l1 + l2).commit();
      }
      if (((!localSharedPreferences.getString("profileFuncallVersion", "0").equals(str)) || (!new File(VipFunCallConstants.b).exists())) && (localObject != null))
      {
        localObject = (VipFunCallManager)this.a.getManager(79);
        if (localObject != null) {
          ((VipFunCallManager)localObject).a(VipFunCallManager.a(paramSUpdateRsp), str);
        }
      }
      return;
    }
    ReportCenter.a().a("SummaryCardUpdate.EM_RT_FUN_CALL", 100, i, this.a.a(), 1000277, "[资料卡]趣味来电增量更新失败", true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ThreadManager.a(new jmn(this, paramString1, paramString2));
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool3 = c();
    boolean bool4 = d();
    boolean bool2 = b();
    int j = this.b;
    if (bool3)
    {
      i = 1;
      this.b = (i | j);
      j = this.b;
      if (!bool4) {
        break label101;
      }
      i = 2;
      label51:
      this.b = (i | j);
      j = this.b;
      if (!bool2) {
        break label106;
      }
    }
    label101:
    label106:
    for (int i = 4;; i = 0)
    {
      this.b = (i | j);
      if ((bool3) || (bool4) || (bool2)) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
      i = 0;
      break label51;
    }
  }
  
  public void b(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSummaryLabelRsp data code=" + i + ",version=" + str1 + ",url=" + str2 + ",interval=" + j);
    }
    if (i == 0)
    {
      paramSUpdateRsp = this.a.getPreferences();
      if (j >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = j * 1000;
        paramSUpdateRsp.edit().putLong("nextCheckLabelUpdateTimeMillis", l1 + l2).commit();
      }
      if ((!paramSUpdateRsp.getString("profileLabelVersion", "0").equals(str1)) && (str2 != null)) {
        a(str2, str1);
      }
      return;
    }
    ReportCenter.a().a("SummaryCardUpdate.EM_RT_SUMMARY_LABEL", 100, i, this.a.a(), 1000277, "[资料卡]资料卡标签增量更新失败", true);
  }
  
  public void b(String paramString1, String paramString2)
  {
    ThreadManager.a(new jmo(this, paramString1, paramString2));
  }
  
  public void c(SummaryCardUpdate.SUpdateRsp paramSUpdateRsp)
  {
    int i = paramSUpdateRsp.code.get();
    String str1 = paramSUpdateRsp.version.get();
    String str2 = paramSUpdateRsp.url.get();
    int j = paramSUpdateRsp.interv.get();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate handleSummaryUpdateRsp data code=" + i + ",version=" + str1 + ",url=" + str2 + ",interval=" + j);
    }
    if (i == 0)
    {
      paramSUpdateRsp = this.a.getPreferences();
      if (j >= 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = j * 1000;
        paramSUpdateRsp.edit().putLong("nextCheckUpdateTimeMillis", l1 + l2).commit();
      }
      if ((!paramSUpdateRsp.getString("cardTemplateVersion", "0").equals(str1)) && (str2 != null)) {
        b(str2, str1);
      }
      return;
    }
    ReportCenter.a().a("SummaryCardUpdate.EM_RT_SUMMARY_UPDATE", 100, i, this.a.a(), 1000277, "[资料卡]资料卡增量更新失败", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardCheckUpdate
 * JD-Core Version:    0.7.0.1
 */