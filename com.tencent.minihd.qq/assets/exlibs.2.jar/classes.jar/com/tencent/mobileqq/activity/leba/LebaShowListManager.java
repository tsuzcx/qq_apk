package com.tencent.mobileqq.activity.leba;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.app.LebaUtil.LebaItemComparator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LebaShowListManager
{
  public static final int a = 1;
  private static volatile LebaShowListManager jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final int b = 2;
  public static final int c = 4;
  public static volatile int d = 0;
  public HashMap a;
  protected List a;
  public boolean a;
  
  private LebaShowListManager()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    d = 0;
  }
  
  public static LebaShowListManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager = new LebaShowListManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityLebaLebaShowListManager;
    }
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 886L) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 905L) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType != 1)) {
          localArrayList.add(localLebaViewItem);
        }
      }
    }
    return localList2;
  }
  
  public List a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "handleLocalList, [" + this.jdField_a_of_type_Boolean + "," + paramContext + "," + paramQQAppInterface + "]");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = paramQQAppInterface.b();
    ArrayList localArrayList3;
    Object localObject4;
    LebaViewItem localLebaViewItem;
    if (localObject1 != null)
    {
      localObject1 = new ArrayList((Collection)localObject1);
      localArrayList3 = new ArrayList();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject4 = (ResourcePluginInfo)localIterator.next();
        if ((localObject4 != null) && (((ResourcePluginInfo)localObject4).cLocalState != 0)) {
          localLebaViewItem = new LebaViewItem();
        }
      }
    }
    label805:
    label811:
    for (;;)
    {
      try
      {
        if (((ResourcePluginInfo)localObject4).cDataType == 1) {
          break label613;
        }
        File localFile = LebaUtil.a(paramContext, ((ResourcePluginInfo)localObject4).strPkgName, ((ResourcePluginInfo)localObject4).strResURL);
        URL localURL = new URL(((ResourcePluginInfo)localObject4).strResURL);
        if (BaseApplicationImpl.a == null) {
          break label805;
        }
        String str = "LebaIcon://" + localFile.getAbsolutePath();
        localObject3 = (Bitmap)BaseApplicationImpl.a.get(str);
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label811;
        }
        localObject1 = localObject3;
        if (!localFile.exists()) {
          break label811;
        }
        localObject3 = LebaUtil.a(localFile);
        localObject1 = localObject3;
        if (localObject3 == null) {
          break label811;
        }
        BaseApplicationImpl.a.put(str, localObject3);
        localObject1 = localObject3;
        break label811;
        if (localObject1 == null) {
          break label572;
        }
        localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
        if ((!localFile.exists()) || (localObject1 == null))
        {
          if ((localFile.exists()) && (localObject1 == null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.lebatab.", 2, "handleLocalList.delete file.");
            }
            localFile.delete();
          }
          localObject1 = new HashMap();
          ((Map)localObject1).put("KEY", ((ResourcePluginInfo)localObject4).strPkgName);
          ((Map)localObject1).put("URL", localURL);
          ((Map)localObject1).put("FILE", localFile);
          localArrayList2.add(localObject1);
        }
        localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject4);
        if (((ResourcePluginInfo)localObject4).cDataType != 1)
        {
          localObject3 = JumpParser.a(paramQQAppInterface, paramContext, ((ResourcePluginInfo)localObject4).strGotoUrl);
          if ((localObject3 != null) && ("app".equals(((JumpAction)localObject3).a())))
          {
            localObject1 = ((JumpAction)localObject3).a("cmp");
            localObject4 = ((JumpAction)localObject3).a("pkg");
            if ((localObject1 != null) && (localObject4 != null))
            {
              localObject3 = paramContext.getPackageManager();
              localObject1 = new ComponentName((String)localObject4, (String)localObject1);
            }
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          ((PackageManager)localObject3).getActivityInfo((ComponentName)localObject1, 32);
          if (!LebaUtil.a(localLebaViewItem)) {
            break label686;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName, localLebaViewItem);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          Object localObject3;
          int i;
          Drawable localDrawable;
          localNameNotFoundException.printStackTrace();
        }
        localException = localException;
      }
      if ((!QLog.isColorLevel()) || (localException == null)) {
        break;
      }
      QLog.d("Q.lebatab.mgr", 2, localException.toString());
      break;
      label572:
      localObject3 = paramContext.getResources().getDrawable(2130840354);
      if ((localObject3 != null) && ((localObject3 instanceof BitmapDrawable)))
      {
        localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)localObject3).getBitmap();
        continue;
        label613:
        i = paramContext.getResources().getIdentifier(((ResourcePluginInfo)localObject4).strResURL, "drawable", paramContext.getPackageName());
        if (i != 0)
        {
          localDrawable = paramContext.getResources().getDrawable(i);
          if ((localDrawable != null) && ((localDrawable instanceof BitmapDrawable)))
          {
            localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)localDrawable).getBitmap();
            continue;
            break;
            label686:
            if ((localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType == 0) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 826L)) {
              break;
            }
            localArrayList3.add(localLebaViewItem);
            break;
            Collections.sort(localArrayList3, new LebaUtil.LebaItemComparator());
            paramContext = (RedTouchManager)paramQQAppInterface.getManager(35);
            if (paramContext == null) {}
            for (paramContext = null;; paramContext = paramContext.d())
            {
              a(paramQQAppInterface, localArrayList3, paramContext);
              LebaUtil.a(localArrayList1, b());
              paramQQAppInterface.d();
              if (localArrayList2.size() > 0) {
                paramQQAppInterface.a.a(localArrayList2);
              }
              return localArrayList1;
            }
            Object localObject2 = null;
          }
        }
      }
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      d = 0;
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
        if (localLebaViewItem != null) {
          if (localLebaViewItem.jdField_a_of_type_Byte == 0)
          {
            if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) {
              ReportController.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), "", "");
            }
          }
          else if ((localLebaViewItem.jdField_a_of_type_Byte == 1) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)) {
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), "", "");
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    for (;;)
    {
      int j;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label268;
        }
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != paramLong1)) {
          continue;
        }
        if (paramBoolean)
        {
          i = 0;
          localLebaViewItem.jdField_a_of_type_Byte = ((byte)i);
          if (paramLong3 != -9223372036854775808L) {
            continue;
          }
          localLebaViewItem.jdField_a_of_type_Long = paramLong2;
          i = 1;
          j = i;
          if (paramQQAppInterface != null)
          {
            j = i;
            if (i != 1) {}
          }
        }
        try
        {
          paramQQAppInterface = (RedTouchManager)paramQQAppInterface.getManager(35);
          i = (int)paramLong1;
          if (paramLong3 != -9223372036854775808L) {
            break label229;
          }
          j = paramQQAppInterface.a(i, paramBoolean, paramLong2);
        }
        catch (Exception paramQQAppInterface)
        {
          i = -2;
          j = i;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.lebatab.mgr", 2, paramQQAppInterface.toString());
          j = i;
          continue;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, ret = " + j);
        }
        return;
        i = 1;
        continue;
        if (paramLong2 != localLebaViewItem.jdField_a_of_type_Long) {
          break label274;
        }
        localLebaViewItem.jdField_a_of_type_Long = paramLong3;
        i = 1;
      }
      label229:
      paramLong2 = paramLong3;
      continue;
      label268:
      int i = 1;
      continue;
      label274:
      i = -2147483648;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList1, List paramList2)
  {
    int i;
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder().append("setAllLebaList, ");
      if (paramList1 != null) {
        break label111;
      }
      i = 0;
    }
    for (;;)
    {
      QLog.i("Q.lebatab.mgr", 4, i);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        if (paramList1 != null) {
          this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
        }
        a(paramList2);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = (RedTouchHandler)paramQQAppInterface.a(33);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a(1, true, null);
          }
        }
        return;
        label111:
        i = paramList1.size();
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator1.next();
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
          continue;
        }
        long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
        if (l == 0L) {
          continue;
        }
        Iterator localIterator2 = paramList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator2.next();
        if ((localAppSetting == null) || (localAppSetting.appid.get() != l)) {
          continue;
        }
        if (localAppSetting.setting.get())
        {
          b1 = 0;
          localLebaViewItem.jdField_a_of_type_Byte = b1;
          localLebaViewItem.jdField_a_of_type_Long = localAppSetting.modify_ts.get();
        }
      }
      byte b1 = 1;
    }
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 905L)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 905L) && ((localLebaViewItem.jdField_a_of_type_Byte == 0) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 0L))) {
          localArrayList.add(localLebaViewItem);
        }
      }
    }
    return localList2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaShowListManager
 * JD-Core Version:    0.7.0.1
 */