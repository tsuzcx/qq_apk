package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import kqa;

public class NearbyProfileUtil
{
  public static final int a = -1;
  public static final int[] a;
  public static final String[] a;
  public static final String[] b;
  public static final String[] c;
  public static final String[] d;
  public static final String[] e;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "男", "女" };
    b = new String[] { "保密", "单身", "恋爱中", "已婚" };
    c = new String[] { "", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
    d = new String[] { "不限", "计算机/互联网/通信", "生产/工艺/制造", "医疗/护理/制药", "金融/银行/投资/保险", "商业/服务业/个体经营", "文化/广告/传媒", "娱乐/艺术/表演", "律师/法务", "教育/培训", "公务员/行政/事业单位", "模特", "空姐", "学生", "其他职业" };
    e = new String[] { "", "IT", "制造", "医疗", "金融", "商业", "文化", "艺术", "法律", "教育", "行政", "模特", "空姐", "学生", "" };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130840545, 2130840076, 2130840076, 2130840076, 2130840452, 2130840452, 2130840552, 2130840552, 2130840332, 2130840332, 2130840332, 2130840545, 2130840545, 2130840459, 2130840545 };
  }
  
  public static final int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 14)) {
      return jdField_a_of_type_ArrayOfInt[paramInt];
    }
    return 0;
  }
  
  public static final String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b.length)) {
      return b[paramInt];
    }
    return "";
  }
  
  public static final void a(CardHandler paramCardHandler, QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    paramQQAppInterface.a(new kqa(paramQQAppInterface, paramLong, paramString, paramCardHandler));
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -1) || ((paramInt >= 0) && (paramInt < d.length));
  }
  
  private static final long b()
  {
    return 0L | 0x4 | 0x800 | 0x1000;
  }
  
  public static final String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return "";
  }
  
  public static final String c(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 12)) {
      return c[paramInt];
    }
    return "";
  }
  
  public static final String d(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 14)) {
      return e[paramInt];
    }
    return "";
  }
  
  public static final String e(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 14)) {
      return d[paramInt];
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.NearbyProfileUtil
 * JD-Core Version:    0.7.0.1
 */