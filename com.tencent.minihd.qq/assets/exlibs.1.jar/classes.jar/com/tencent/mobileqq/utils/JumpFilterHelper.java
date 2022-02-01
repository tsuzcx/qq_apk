package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class JumpFilterHelper
  extends BaseConfigFileParser
{
  private static volatile JumpFilterHelper jdField_a_of_type_ComTencentMobileqqUtilsJumpFilterHelper;
  public static final String d = JumpFilterHelper.class.getSimpleName();
  public static final String e = "JumpWhiteList";
  public static final String f = "key_jump_whitelist_version";
  public static final String g = "Item";
  public static final String h = "cmp";
  public static final String i = "pkg";
  public static final String j = "qq_safe_jump_whitelist";
  public static final String k = "qq_safe_jump_whitelist.xml";
  public static final String l = "qq_safe_jump_whitelist.zip";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("qq_safe_jump_whitelist", 0);
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    Context localContext = BaseApplicationImpl.getContext();
    b = localContext.getFilesDir().getAbsoluteFile() + File.separator + "jumpConfig/";
    c = b + "qq_safe_jump_whitelist.xml";
  }
  
  public static JumpFilterHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsJumpFilterHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqUtilsJumpFilterHelper == null) {
        jdField_a_of_type_ComTencentMobileqqUtilsJumpFilterHelper = new JumpFilterHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqUtilsJumpFilterHelper;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "reportIllegalJump pkg=" + paramString1 + ";cmp=" + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    StatisticCollector.a(BaseApplicationImpl.a()).a(null, "JumpIllegal", true, 0L, 0L, localHashMap, null);
  }
  
  protected int a()
  {
    return 2131099657;
  }
  
  public long a()
  {
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_jump_whitelist_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "getConfigVersion version=" + l1);
    }
    return l1;
  }
  
  protected Object a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    for (int m = paramXmlPullParser.getEventType(); m != 1; m = paramXmlPullParser.next()) {
      if ((m == 2) && (paramXmlPullParser.getName().equalsIgnoreCase("Item")))
      {
        String str1 = paramXmlPullParser.getAttributeValue(null, "pkg");
        String str2 = paramXmlPullParser.getAttributeValue(null, "cmp");
        if ((str1 != null) && (str2 != null)) {
          localArrayList.add(new Pair(str1, str2));
        }
        if (QLog.isColorLevel()) {
          QLog.d(d, 2, "doParseRules pkg=" + str1 + ";cmp=" + str2);
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "doParseRules :  cost time:" + (l2 - l1) + "ms;size=" + localArrayList.size());
    }
    return localArrayList;
  }
  
  protected void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "updateConfigVersion version=" + paramLong);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_jump_whitelist_version", paramLong).commit();
  }
  
  protected void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilList = ((List)paramObject);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2)
  {
    Pair localPair = new Pair(paramString1, paramString2);
    if (!this.jdField_a_of_type_Boolean) {}
    synchronized (jdField_a_of_type_ComTencentMobileqqUtilsJumpFilterHelper)
    {
      if (!this.jdField_a_of_type_Boolean) {
        a(paramContext);
      }
      if (!this.jdField_a_of_type_JavaUtilList.contains(localPair))
      {
        a(paramString1, paramString2);
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "isIllegalJump pkg=" + paramString1 + ";cmp=" + paramString2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpFilterHelper
 * JD-Core Version:    0.7.0.1
 */