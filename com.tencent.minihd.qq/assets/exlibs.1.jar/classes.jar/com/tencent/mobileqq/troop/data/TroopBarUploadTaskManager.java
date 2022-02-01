package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kjt;
import kjv;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarUploadTaskManager
{
  public static final int a = 3;
  private static TroopBarUploadTaskManager jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager = new TroopBarUploadTaskManager();
  public static final String a = "entity_id";
  public static final int b = 0;
  public static final String b = "entity_progress";
  public static final int c = 1;
  public static final String c = "op_type";
  public static final int d = 2;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static final TroopBarUploadTaskManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, float paramFloat, int paramInt2)
  {
    ThreadManager.a(new kjt(paramInt1, paramQQAppInterface, paramString, paramFloat, paramInt2, new Handler(Looper.getMainLooper())));
  }
  
  private static final float b(long paramLong1, long paramLong2)
  {
    return (float)paramLong1 / (float)paramLong2;
  }
  
  private static final String b()
  {
    int i = NetworkUtil.a(BaseApplicationImpl.getContext());
    String str = "-1";
    if (i == 1) {
      str = "0";
    }
    do
    {
      return str;
      if (i == 2) {
        return "1";
      }
      if (i == 3) {
        return "2";
      }
    } while (i != 4);
    return "3";
  }
  
  public int a()
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (!((VideoUploadTask)localIterator.next()).a()) {
            i += 1;
          }
        }
        else {
          return i;
        }
      }
    }
  }
  
  public VideoUploadTask a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        VideoUploadTask localVideoUploadTask = (VideoUploadTask)localIterator.next();
        if (paramString.equals(localVideoUploadTask.a.mId)) {
          return localVideoUploadTask;
        }
      }
      return null;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((VideoUploadTask)localIterator.next()).a();
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("*.qq.com");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("status", paramInt);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("pid", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("cid", paramString2);
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, QLog.getStackTraceString(paramString1));
        }
      }
    }
    EventApiPlugin.a("kTribeUploadStatusChangeNotifcation", localJSONObject, localArrayList, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, float paramFloat)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return;
    }
    Object localObject = a(paramString);
    StringBuilder localStringBuilder;
    if (localObject != null)
    {
      ((VideoUploadTask)localObject).a();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("removeTask: id = ");
        if (((VideoUploadTask)localObject).a == null) {
          break label89;
        }
      }
    }
    label89:
    for (localObject = ((VideoUploadTask)localObject).a.mId;; localObject = "0")
    {
      QLog.d("TroopBar", 2, (String)localObject);
      a(paramQQAppInterface, 1, paramString, paramFloat, 3);
      return;
    }
  }
  
  public void a(QQAppInterface arg1, String paramString1, String paramString2, TroopBarUploadItemEntity paramTroopBarUploadItemEntity)
  {
    if ((paramTroopBarUploadItemEntity == null) || (paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      return;
      paramString1 = new VideoUploadTask(paramString1, paramString2, paramTroopBarUploadItemEntity, new kjv(this, paramTroopBarUploadItemEntity, ???));
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, paramString1);
        if (a() >= 3) {
          continue;
        }
        b(paramString1);
        return;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (paramString3 == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    a(paramString3);
    a(paramQQAppInterface, 2, paramString3, -1.0F, 0);
  }
  
  public boolean a(VideoUploadTask paramVideoUploadTask)
  {
    if (paramVideoUploadTask != null) {
      paramVideoUploadTask.a();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("removeTask: id = ");
          if (paramVideoUploadTask.a == null) {
            break label89;
          }
          str = paramVideoUploadTask.a.mId;
          QLog.d("TroopBar", 2, str);
        }
        boolean bool = this.jdField_a_of_type_JavaUtilArrayList.remove(paramVideoUploadTask);
        return bool;
      }
      return false;
      label89:
      String str = "0";
    }
  }
  
  public boolean a(String paramString)
  {
    return a(a(paramString));
  }
  
  public void b()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject1 = (VideoUploadTask)((Iterator)localObject3).next();
          if (!b((VideoUploadTask)localObject1)) {
            continue;
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("runNextTask: id = ");
            if (((VideoUploadTask)localObject1).a == null) {
              break label101;
            }
            localObject1 = ((VideoUploadTask)localObject1).a.mId;
            QLog.d("TroopBar", 2, (String)localObject1);
          }
        }
        else
        {
          return;
        }
      }
      label101:
      String str = "0";
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, TroopBarUploadItemEntity paramTroopBarUploadItemEntity)
  {
    if ((paramQQAppInterface == null) || (paramTroopBarUploadItemEntity == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    a(paramQQAppInterface, paramString1, paramString2, paramTroopBarUploadItemEntity);
    a(paramQQAppInterface, 1, paramTroopBarUploadItemEntity.mId, paramTroopBarUploadItemEntity.mProgress, 0);
  }
  
  public boolean b(VideoUploadTask paramVideoUploadTask)
  {
    if ((paramVideoUploadTask == null) || (!paramVideoUploadTask.a())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "runTask: id = " + paramVideoUploadTask.a.mId);
    }
    ThreadManager.a(paramVideoUploadTask);
    return true;
  }
  
  public boolean b(String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          VideoUploadTask localVideoUploadTask = (VideoUploadTask)localIterator.next();
          if ((localVideoUploadTask == null) || (localVideoUploadTask.a == null) || (paramString == null) || (!paramString.equals(localVideoUploadTask.a.mId))) {
            continue;
          }
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarUploadTaskManager
 * JD-Core Version:    0.7.0.1
 */