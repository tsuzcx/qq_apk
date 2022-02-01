package com.tencent.mobileqq.pic;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.richmedia.dc.PhotoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class PicStatisticsManager
  implements Manager
{
  private static final String A = "PicStatisticsManagerPicDownloadSizeSmallGroup";
  private static final String B = "PicStatisticsManagerPicDownloadSizeMiddleGroup";
  private static final String C = "PicStatisticsManagerPicDownloadSizeLargeGroup";
  private static final String D = "PicStatisticsManagerPicDownloadSizeExtraLargeGroup";
  private static final String E = "PicStatisticsManagerPicDownloadSizeLongGroup";
  private static final String F = "PicStatisticsManagerPicPreviewSizeSmallGroup";
  private static final String G = "PicStatisticsManagerPicPreviewSizeMiddleGroup";
  private static final String H = "PicStatisticsManagerPicPreviewSizeLargeGroup";
  private static final String I = "PicStatisticsManagerPicPreivewSizeExtraLargeGroup";
  private static final String J = "PicStatisticsManagerPicPreviewSizeLongGroup";
  private static final String K = "PicStatisticsManagerPredownloadMissPriorityWifi";
  private static final String L = "PicStatisticsManagerMissPriorityHandlingWifi";
  private static final String M = "PicStatisticsManagerMissPriorityAIOWifi";
  private static final String N = "PicStatisticsManagerMissPriorityC2CWifi";
  private static final String O = "PicStatisticsManagerMissPriorityDiscussionWifi";
  private static final String P = "PicStatisticsManagerMissPriorityGroupWifi";
  private static final String Q = "PicStatisticsManagerMissPriorityWaitingWifi";
  private static final String R = "PicStatisticsManagerMissPriorityUnknownWifi";
  private static final String S = "PicStatisticsManagerPredownloadMissPriorityXG";
  private static final String T = "PicStatisticsManagerMissPriorityHandlingXG";
  private static final String U = "PicStatisticsManagerMissPriorityAIOXG";
  private static final String V = "PicStatisticsManagerMissPriorityC2CXG";
  private static final String W = "PicStatisticsManagerMissPriorityDiscussionXG";
  private static final String X = "PicStatisticsManagerMissPriorityGroupXG";
  private static final String Y = "PicStatisticsManagerMissPriorityWaitingXG";
  private static final String Z = "PicStatisticsManagerMissPriorityUnknownXG";
  public static final int a = 13057;
  public static final String a = "PicStatisticsManagerUploadPic";
  private static final List jdField_a_of_type_JavaUtilList;
  private static final String[][] jdField_a_of_type_Array2dOfJavaLangString;
  private static final String aa = "PicStatisticsManagerPredownloadDataWifi";
  private static final String ab = "PicStatisticsManagerPredownloadDataXg";
  private static final String ac = "PicStatisticsManagerPredownloadCountWifi";
  private static final String ad = "PicStatisticsManagerPredownloadCountXG";
  private static final String ae = "PicStatisticsManagerPreviewCountWifi";
  private static final String af = "PicStatisticsManagerPreviewCountXG";
  private static final String ag = "PicStatisticsManagerPredownloadThumbPic";
  private static final String ah = "PicStatisticsManagerPreDownloadThumbPicCount";
  private static final String ai = "PicStatisticsManagerPreDownloadThumbPicHitCount";
  private static final String aj = "PicStatisticsManagerPreDownloadThumbPicMissCount";
  private static final String ak = "PicStatisticsManagerPredownloadMissReasonGrayForWifi";
  private static final String al = "PicStatisticsManagerPredownloadMissReasonGrayForXG";
  private static final String am = "PredownloadMissReason";
  public static final int b = 13058;
  private static final String jdField_b_of_type_JavaLangString = PicStatisticsManager.class.getSimpleName();
  private static final List jdField_b_of_type_JavaUtilList;
  private static final String[][] jdField_b_of_type_Array2dOfJavaLangString;
  public static final int c = 13059;
  private static final String jdField_c_of_type_JavaLangString = "PicStatisticsManagerFirstUsed";
  private static final List jdField_c_of_type_JavaUtilList;
  private static final String[][] jdField_c_of_type_Array2dOfJavaLangString;
  public static final int d = 13060;
  private static final String jdField_d_of_type_JavaLangString = "PicStatisticsManagerSendPicTotalSize";
  private static final List jdField_d_of_type_JavaUtilList;
  private static final String[][] jdField_d_of_type_Array2dOfJavaLangString;
  private static final int jdField_e_of_type_Int;
  private static final String jdField_e_of_type_JavaLangString = "PicStatisticsManagerForwardPicTotalSize";
  private static final List jdField_e_of_type_JavaUtilList;
  private static final String jdField_f_of_type_JavaLangString = "PicStatisticsManagerSendPicCount";
  private static final List jdField_f_of_type_JavaUtilList;
  private static final String jdField_g_of_type_JavaLangString = "PicStatisticsManagerForwardPicCount";
  private static final List jdField_g_of_type_JavaUtilList;
  private static final String jdField_h_of_type_JavaLangString = "PicStatisticsManagerIsUploadPicActive";
  private static final List jdField_h_of_type_JavaUtilList;
  private static final String jdField_i_of_type_JavaLangString = "PicStatisticsManagerDownloadPic";
  private static final List jdField_i_of_type_JavaUtilList;
  private static final String j = "PicStatisticsManagerThumbPicTotalSize";
  private static final String k = "PicStatisticsManagerBigPicTotalSize";
  private static final String l = "PicStatisticsManagerDownloadThumbPicCount";
  private static final String m = "PicStatisticsManagerDownloadBigPicCount";
  private static final String n = "PicStatisticsManagerIsDownloadPicActive";
  private static final String o = "PicStatisticsManagerDiffSizePicPreviewC2C";
  private static final String p = "PicStatisticsManagerPicDownloadSizeSmallC2C";
  private static final String q = "PicStatisticsManagerPicDownloadSizeMiddleC2C";
  private static final String r = "PicStatisticsManagerPicDownloadSizeLargeC2C";
  private static final String s = "PicStatisticsManagerPicDownloadSizeExtraLargeC2C";
  private static final String t = "PicStatisticsManagerPicDownloadSizeLongC2C";
  private static final String u = "PicStatisticsManagerPicPreviewSizeSmallC2C";
  private static final String v = "PicStatisticsManagerPicPreviewSizeMiddleC2C";
  private static final String w = "PicStatisticsManagerPicPreviewSizeLargeC2C";
  private static final String x = "PicStatisticsManagerPicPreivewSizeExtraLargeC2C";
  private static final String y = "PicStatisticsManagerPicPreviewSizeLongC2C";
  private static final String z = "PicStatisticsManagerDiffSizePicPreviewGroup";
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Set jdField_a_of_type_JavaUtilSet;
  private Set jdField_b_of_type_JavaUtilSet;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerSendPicTotalSize");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerForwardPicTotalSize");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerSendPicCount");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerForwardPicCount");
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerThumbPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerBigPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerDownloadThumbPicCount");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerDownloadBigPicCount");
    jdField_c_of_type_JavaUtilList = new ArrayList();
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeSmallC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeMiddleC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLongC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeSmallC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeMiddleC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLongC2C");
    jdField_d_of_type_JavaUtilList = new ArrayList();
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeSmallGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeMiddleGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLongGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeSmallGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeMiddleGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLongGroup");
    jdField_e_of_type_JavaUtilList = new ArrayList();
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerMissPriorityHandlingWifi");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerMissPriorityAIOWifi");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerMissPriorityC2CWifi");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerMissPriorityDiscussionWifi");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerMissPriorityGroupWifi");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerMissPriorityWaitingWifi");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerMissPriorityUnknownWifi");
    f = new ArrayList();
    f.add("PicStatisticsManagerMissPriorityHandlingXG");
    f.add("PicStatisticsManagerMissPriorityAIOXG");
    f.add("PicStatisticsManagerMissPriorityC2CXG");
    f.add("PicStatisticsManagerMissPriorityDiscussionXG");
    f.add("PicStatisticsManagerMissPriorityGroupXG");
    f.add("PicStatisticsManagerMissPriorityWaitingXG");
    f.add("PicStatisticsManagerMissPriorityUnknownXG");
    String[] arrayOfString = { "XGC2CBigPicCount", "XGDiscussionBigPicCount", "XGGroupBigPicCount", "XGDigitalGroupBigPicCount" };
    jdField_a_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicCount", "WifiDiscussionBigPicCount", "WifiGroupBigPicCount", "WifiDigitalGroupBigPicCount" }, arrayOfString };
    arrayOfString = new String[] { "XGC2CBigPicHitCount", "XGDiscussionBigPicHitCount", "XGGroupBigPicHitCount", "XGDigitalGroupBigPicHitCount" };
    jdField_b_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicHitCount", "WifiDiscussionBigPicHitCount", "WifiGroupBigPicHitCount", "WifiDigitalGroupBigPicHitCount" }, arrayOfString };
    jdField_c_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicMissCount", "WifiDiscussionBigPicMissCount", "WifiGroupBigPicMissCount", "WifiDigitalGroupBigPicMissCount" }, { "XGC2CBigPicMissCount", "XGDiscussionBigPicMissCount", "XGGroupBigPicMissCount", "XGDigitalGroupBigPicMissCount" } };
    arrayOfString = new String[] { "XGC2CBigPicNotSupportCount", "XGDiscussionBigPicNotSupportCount", "XGGroupBigPicNotSupportCount", "XGDigitalGroupBigPicNotSupportCount" };
    jdField_d_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicNotSupportCount", "WifiDiscussionBigPicNotSupportCount", "WifiGroupBigPicNotSupportCount", "WifiDigitalGroupBigPicNotSupportCount" }, arrayOfString };
    jdField_e_of_type_Int = jdField_a_of_type_Array2dOfJavaLangString[0].length;
    g = new ArrayList();
    h = new ArrayList();
    int i1 = 0;
    while (i1 < jdField_e_of_type_Int)
    {
      g.add(jdField_a_of_type_Array2dOfJavaLangString[0][i1]);
      g.add(jdField_b_of_type_Array2dOfJavaLangString[0][i1]);
      g.add(jdField_c_of_type_Array2dOfJavaLangString[0][i1]);
      g.add(jdField_d_of_type_Array2dOfJavaLangString[0][i1]);
      h.add(jdField_a_of_type_Array2dOfJavaLangString[1][i1]);
      h.add(jdField_b_of_type_Array2dOfJavaLangString[1][i1]);
      h.add(jdField_c_of_type_Array2dOfJavaLangString[1][i1]);
      h.add(jdField_d_of_type_Array2dOfJavaLangString[1][i1]);
      i1 += 1;
    }
    i = new ArrayList();
    i.add("PicStatisticsManagerPreDownloadThumbPicCount");
    i.add("PicStatisticsManagerPreDownloadThumbPicHitCount");
    i.add("PicStatisticsManagerPreDownloadThumbPicMissCount");
  }
  
  @TargetApi(9)
  public PicStatisticsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "PicStatisticsManagerMissPriorityUnknownWifi";
    case 6: 
      return "PicStatisticsManagerMissPriorityHandlingWifi";
    case 5: 
      return "PicStatisticsManagerMissPriorityAIOWifi";
    case 4: 
      return "PicStatisticsManagerMissPriorityC2CWifi";
    case 3: 
      return "PicStatisticsManagerMissPriorityDiscussionWifi";
    }
    return "PicStatisticsManagerMissPriorityGroupWifi";
  }
  
  private HashMap a(List paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L);
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      localHashMap.put(str, String.valueOf(l1));
    }
    return localHashMap;
  }
  
  @TargetApi(9)
  private void a(int paramInt1, int paramInt2, String[][] paramArrayOfString, boolean paramBoolean)
  {
    long l1;
    String str1;
    String str2;
    if (paramInt1 == 0) {
      if (paramBoolean)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCountWifi", l1 + 1L);
        paramInt1 = 0;
        str1 = "WIFI";
        if (paramInt2 != 3) {
          break label275;
        }
        paramInt2 = 0;
        str2 = "C2C";
        label58:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "addCount(): networkType=" + str1 + " uin=" + str2);
        }
        paramArrayOfString = paramArrayOfString[paramInt1][paramInt2];
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramArrayOfString, 0L) + 1L;
        if (Build.VERSION.SDK_INT < 9) {
          break label336;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramArrayOfString, l1).apply();
      }
    }
    label275:
    do
    {
      return;
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountWifi", l1 + 1L);
      paramInt1 = 0;
      str1 = "WIFI";
      break;
      if (paramBoolean)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCountXG", l1 + 1L);
        paramInt1 = 1;
        str1 = "XG";
        break;
      }
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountXG", l1 + 1L);
      paramInt1 = 1;
      str1 = "XG";
      break;
      if (paramInt2 == 2)
      {
        paramInt2 = 1;
        str2 = "Discussion";
        break label58;
      }
      if (paramInt2 == 0)
      {
        paramInt2 = 2;
        str2 = "Group";
        break label58;
      }
      if (paramInt2 == 1)
      {
        paramInt2 = 3;
        str2 = "Digital Group";
        break label58;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_b_of_type_JavaLangString, 2, "addCount(): Error! Unknown uin type");
    return;
    label336:
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramArrayOfString, l1).commit();
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "PicStatisticsManagerMissPriorityUnknownXG";
    case 6: 
      return "PicStatisticsManagerMissPriorityHandlingXG";
    case 5: 
      return "PicStatisticsManagerMissPriorityAIOXG";
    case 4: 
      return "PicStatisticsManagerMissPriorityC2CXG";
    case 3: 
      return "PicStatisticsManagerMissPriorityDiscussionXG";
    }
    return "PicStatisticsManagerMissPriorityGroupXG";
  }
  
  @TargetApi(9)
  private void b()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = jdField_e_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = f.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = g.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = h.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = i.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  @TargetApi(9)
  public void a()
  {
    if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("PicStatisticsManagerFirstUsed", false))
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PicStatisticsManagerFirstUsed", true).apply();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "dataReport(): Not need to data report!");
        }
        return;
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PicStatisticsManagerFirstUsed", true).commit();
      }
    }
    String str;
    label111:
    long l1;
    long l2;
    HashMap localHashMap1;
    label165:
    HashMap localHashMap2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) > 0L) {
        break label272;
      }
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerSendPicCount", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerForwardPicCount", 0L);
      localHashMap1 = a(jdField_a_of_type_JavaUtilList);
      if (l1 + l2 > 0L) {
        break label553;
      }
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "FALSE");
      StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerUploadPic", false, 0L, 0L, localHashMap1, "");
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerDownloadThumbPicCount", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerDownloadBigPicCount", 0L);
      localHashMap2 = a(jdField_b_of_type_JavaUtilList);
      if (l1 + l2 > 0L) {
        break label567;
      }
      localHashMap1.put("PicStatisticsManagerIsDownloadPicActive", "FALSE");
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDownloadPic", false, 0L, 0L, localHashMap2, "");
      b();
      return;
      str = null;
      break;
      label272:
      StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadThumbPic", false, 0L, 0L, a(i), "");
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
      long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
      long l4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
      if (l1 + l3 > 0L) {
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadDataWifi", false, 0L, 0L, a(g), "");
      }
      if (l2 + l4 > 0L) {
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadDataXg", false, 0L, 0L, a(h), "");
      }
      if (l3 + l4 > 0L)
      {
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDiffSizePicPreviewC2C", false, 0L, 0L, a(jdField_c_of_type_JavaUtilList), "");
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDiffSizePicPreviewGroup", false, 0L, 0L, a(jdField_d_of_type_JavaUtilList), "");
      }
      if (l3 > 0L) {
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissPriorityWifi", false, 0L, 0L, a(jdField_e_of_type_JavaUtilList), "");
      }
      if (l4 <= 0L) {
        break label111;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissPriorityXG", false, 0L, 0L, a(f), "");
      break label111;
      label553:
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "TRUE");
      break label165;
      label567:
      localHashMap1.put("PicStatisticsManagerIsDownloadPicActive", "TRUE");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    HashMap localHashMap;
    for (String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();; str = null)
    {
      localHashMap = new HashMap();
      localHashMap.put("PredownloadMissReason", String.valueOf(paramInt2));
      if (paramInt1 != 0) {
        break;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissReasonGrayForWifi", false, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissReasonGrayForXG", false, 0L, 0L, localHashMap, "");
  }
  
  @TargetApi(9)
  public void a(int paramInt, long paramLong)
  {
    String str3;
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "addPicData(): Unknown picture type!");
      }
      return;
    case 13057: 
      str3 = "SendPic";
      str2 = "PicStatisticsManagerSendPicTotalSize";
      str1 = "PicStatisticsManagerSendPicCount";
    }
    long l1;
    long l2;
    for (;;)
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str2, 0L) + paramLong;
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str1, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "addPictureData(): type=" + str3 + " Adding Size=" + paramLong + " Total Size=" + l1 + " Count=" + l2);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l1).putLong(str1, l2).apply();
      return;
      str3 = "ForwardPic";
      str2 = "PicStatisticsManagerForwardPicTotalSize";
      str1 = "PicStatisticsManagerForwardPicCount";
      continue;
      str3 = "DownloadThumbPic";
      str2 = "PicStatisticsManagerThumbPicTotalSize";
      str1 = "PicStatisticsManagerDownloadThumbPicCount";
      continue;
      str3 = "DownloadBigPic";
      str2 = "PicStatisticsManagerBigPicTotalSize";
      str1 = "PicStatisticsManagerDownloadBigPicCount";
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l1).putLong(str1, l2).commit();
  }
  
  @TargetApi(9)
  public void a(MessageForPic paramMessageForPic)
  {
    for (;;)
    {
      try
      {
        String str = paramMessageForPic.md5;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadThumbPic(): Uniseq=" + paramMessageForPic.uniseq + " MD5=" + paramMessageForPic.md5);
        }
        boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(str);
        if (bool) {
          return;
        }
        this.jdField_a_of_type_JavaUtilSet.add(paramMessageForPic.md5);
        long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) + 1L;
        if (Build.VERSION.SDK_INT >= 9)
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l1).apply();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "addPreDownloadThumbPic(): PreDownloadThumbPicCount=" + l1);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l1).commit();
        }
      }
      finally {}
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDowonloadBigPicCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_a_of_type_Array2dOfJavaLangString, true);
  }
  
  @TargetApi(9)
  public void b(MessageForPic paramMessageForPic)
  {
    for (;;)
    {
      long l1;
      try
      {
        String str = paramMessageForPic.md5;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadBigPic(): Uniseq=" + paramMessageForPic.uniseq + " MD5=" + str);
        }
        boolean bool = this.jdField_b_of_type_JavaUtilSet.contains(str);
        if (bool) {
          return;
        }
        this.jdField_b_of_type_JavaUtilSet.add(str);
        if (this.jdField_a_of_type_JavaUtilSet.contains(str))
        {
          l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicHitCount", 0L);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicHitCount", l1 + 1L);
          if (Build.VERSION.SDK_INT < 9) {
            break label184;
          }
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
          continue;
        }
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicMissCount", 0L);
      }
      finally {}
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicMissCount", l1 + 1L);
      continue;
      label184:
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadBigPicHitCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_b_of_type_Array2dOfJavaLangString, false);
  }
  
  @TargetApi(9)
  public void c(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "addDownloadBigPicSize(): pic is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = paramMessageForPic.width;
      l2 = paramMessageForPic.height;
      if ((l1 > 0L) && (l2 > 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_b_of_type_JavaLangString, 2, "addDownloadBigPicSize(): Width=" + l1 + " Height=" + l2 + ", invalid!");
    return;
    int i1;
    int i2;
    if (PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3)
    {
      i1 = 1;
      i2 = PhotoUtils.a(l1, l2);
      if (i2 != 0) {
        break label257;
      }
      if (i1 == 0) {
        break label251;
      }
      paramMessageForPic = "PicStatisticsManagerPicDownloadSizeLongC2C";
    }
    long l3;
    for (;;)
    {
      l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramMessageForPic, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "addDownloadBigPicSize(): " + paramMessageForPic + ", Width=" + l1 + " Height=" + l2 + " Count=" + l3);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label336;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramMessageForPic, l3).apply();
      return;
      i1 = 0;
      break;
      label251:
      paramMessageForPic = "PicStatisticsManagerPicDownloadSizeLongGroup";
      continue;
      label257:
      if (i2 == 1)
      {
        if (i1 != 0) {
          paramMessageForPic = "PicStatisticsManagerPicDownloadSizeSmallC2C";
        } else {
          paramMessageForPic = "PicStatisticsManagerPicDownloadSizeSmallGroup";
        }
      }
      else if (i2 == 2)
      {
        if (i1 != 0) {
          paramMessageForPic = "PicStatisticsManagerPicDownloadSizeMiddleC2C";
        } else {
          paramMessageForPic = "PicStatisticsManagerPicDownloadSizeMiddleGroup";
        }
      }
      else if (i2 == 3)
      {
        if (i1 != 0) {
          paramMessageForPic = "PicStatisticsManagerPicDownloadSizeLargeC2C";
        } else {
          paramMessageForPic = "PicStatisticsManagerPicDownloadSizeLargeGroup";
        }
      }
      else if (i1 != 0) {
        paramMessageForPic = "PicStatisticsManagerPicDownloadSizeExtraLargeC2C";
      } else {
        paramMessageForPic = "PicStatisticsManagerPicDownloadSizeExtraLargeGroup";
      }
    }
    label336:
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramMessageForPic, l3).commit();
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadBigPicMissCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_c_of_type_Array2dOfJavaLangString, false);
  }
  
  @TargetApi(9)
  public void d(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "addPreviewBigPicSize(): pic is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = paramMessageForPic.width;
      l2 = paramMessageForPic.height;
      if ((l1 > 0L) && (l2 > 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreviewBigPicSize(): Width=" + l1 + " Height=" + l2 + ", invalid!");
    return;
    int i1;
    int i2;
    if (PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3)
    {
      i1 = 1;
      i2 = PhotoUtils.a(l1, l2);
      if (i2 != 0) {
        break label257;
      }
      if (i1 == 0) {
        break label251;
      }
      paramMessageForPic = "PicStatisticsManagerPicPreviewSizeLongC2C";
    }
    long l3;
    for (;;)
    {
      l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramMessageForPic, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreviewBigPicSize(): " + paramMessageForPic + ", Width=" + l1 + " Height=" + l2 + " Count=" + l3);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label336;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramMessageForPic, l3).apply();
      return;
      i1 = 0;
      break;
      label251:
      paramMessageForPic = "PicStatisticsManagerPicPreviewSizeLongGroup";
      continue;
      label257:
      if (i2 == 1)
      {
        if (i1 != 0) {
          paramMessageForPic = "PicStatisticsManagerPicPreviewSizeSmallC2C";
        } else {
          paramMessageForPic = "PicStatisticsManagerPicPreviewSizeSmallGroup";
        }
      }
      else if (i2 == 2)
      {
        if (i1 != 0) {
          paramMessageForPic = "PicStatisticsManagerPicPreviewSizeMiddleC2C";
        } else {
          paramMessageForPic = "PicStatisticsManagerPicPreviewSizeMiddleGroup";
        }
      }
      else if (i2 == 3)
      {
        if (i1 != 0) {
          paramMessageForPic = "PicStatisticsManagerPicPreviewSizeLargeC2C";
        } else {
          paramMessageForPic = "PicStatisticsManagerPicPreviewSizeLargeGroup";
        }
      }
      else if (i1 != 0) {
        paramMessageForPic = "PicStatisticsManagerPicPreivewSizeExtraLargeC2C";
      } else {
        paramMessageForPic = "PicStatisticsManagerPicPreivewSizeExtraLargeGroup";
      }
    }
    label336:
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramMessageForPic, l3).commit();
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadNotSupportCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_d_of_type_Array2dOfJavaLangString, false);
  }
  
  @TargetApi(9)
  public void f(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    long l1;
    for (String str = a(paramInt2);; str = b(paramInt2))
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "addPredownloadMissPriority(): " + str + ", Count=" + l1);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1).commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicStatisticsManager
 * JD-Core Version:    0.7.0.1
 */