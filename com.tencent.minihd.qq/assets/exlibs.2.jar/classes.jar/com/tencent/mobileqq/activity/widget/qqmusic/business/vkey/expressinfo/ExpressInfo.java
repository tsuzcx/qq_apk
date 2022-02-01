package com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.expressinfo;

import java.util.ArrayList;

public class ExpressInfo
{
  public final String a;
  public final ArrayList a;
  public final String b;
  public final String c;
  public final String d;
  
  public ExpressInfo(String paramString1, String paramString2, String paramString3, String paramString4, ArrayList paramArrayList)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.jdField_a_of_type_JavaLangString = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.b = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this.c = paramString1;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    this.d = paramString1;
    paramString1 = paramArrayList;
    if (paramArrayList == null) {
      paramString1 = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.expressinfo.ExpressInfo
 * JD-Core Version:    0.7.0.1
 */