package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingSubjectItem;
import com.tencent.mobileqq.pb.PBStringField;
import ibt;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class DatingFilters
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ibt();
  public static final int a = 0;
  public static final String a = "key_filter_value";
  private static List a;
  public static final int[] a;
  public static final String[] a;
  public static final int b = 1;
  private static final String b = "key_gender";
  public static final int[] b;
  public static final String[] b;
  public static final int c = 2;
  private static final String c = "key_dating_time";
  public static String[] c;
  private static final String d = "key_dating_content";
  private static final String e = "key_age";
  private static final String f = "key_career";
  private static final String g = "key_dest";
  private static final String h = "key_dest_type";
  public appoint_define.LocaleInfo a;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i = 0;
  public int j;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "不限", "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 22, 26, 35, 120 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 18, 23, 27, 36 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "不限", "今天", "明天", "一周内", "一个月内" };
    c = new String[] { "不限", "吃饭", "看电影", "唱歌", "出行", "运动" };
  }
  
  public DatingFilters(Context paramContext)
  {
    this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    jdField_a_of_type_JavaUtilList = ((DatingManager)((BaseActivity)paramContext).app.getManager(67)).a();
    if (jdField_a_of_type_JavaUtilList != null)
    {
      c = new String[jdField_a_of_type_JavaUtilList.size() + 1];
      c[0] = "不限";
      while (k < jdField_a_of_type_JavaUtilList.size())
      {
        c[(k + 1)] = ((DatingSubjectItem)jdField_a_of_type_JavaUtilList.get(k)).name;
        k += 1;
      }
    }
  }
  
  private DatingFilters(Parcel paramParcel)
  {
    this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    paramParcel = paramParcel.readString();
    if ((paramParcel == null) || (paramParcel.equals("")))
    {
      this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
      return;
    }
    try
    {
      appoint_define.LocaleInfo localLocaleInfo = new appoint_define.LocaleInfo();
      localLocaleInfo.mergeFrom(paramParcel.getBytes("ISO-8859-1"));
      this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = localLocaleInfo;
      return;
    }
    catch (Exception paramParcel)
    {
      this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    }
  }
  
  public static DatingFilters a(Context paramContext, String paramString)
  {
    DatingFilters localDatingFilters = new DatingFilters(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return localDatingFilters;
      paramContext = paramContext.getSharedPreferences("dating_pref" + paramString, 0);
    } while (paramContext == null);
    localDatingFilters.d = paramContext.getInt("key_gender", 0);
    localDatingFilters.h = paramContext.getInt("key_age", 0);
    localDatingFilters.e = paramContext.getInt("key_dating_time", 0);
    localDatingFilters.g = paramContext.getInt("key_dating_content", 0);
    localDatingFilters.f = localDatingFilters.b(localDatingFilters.g);
    localDatingFilters.i = paramContext.getInt("key_career", 0);
    localDatingFilters.j = paramContext.getInt("key_dest_type", 0);
    paramContext = paramContext.getString("key_dest", "");
    if ((paramContext == null) || (paramContext.equals("")))
    {
      localDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
      return localDatingFilters;
    }
    try
    {
      paramString = new appoint_define.LocaleInfo();
      paramString.mergeFrom(paramContext.getBytes("ISO-8859-1"));
      localDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = paramString;
      return localDatingFilters;
    }
    catch (Exception paramContext)
    {
      localDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    }
    return localDatingFilters;
  }
  
  public static void a(Context paramContext, String paramString, DatingFilters paramDatingFilters)
  {
    if ((paramDatingFilters == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramContext = paramContext.getSharedPreferences("dating_pref" + paramString, 0);
    } while (paramContext == null);
    paramString = paramContext.edit();
    paramString.putInt("key_gender", paramDatingFilters.d).putInt("key_dating_time", paramDatingFilters.e).putInt("key_dating_content", paramDatingFilters.g).putInt("key_age", paramDatingFilters.h).putInt("key_career", paramDatingFilters.i).putInt("key_dest_type", paramDatingFilters.j);
    for (;;)
    {
      try
      {
        if (paramDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) {
          continue;
        }
        paramContext = "";
        paramString.putString("key_dest", paramContext);
      }
      catch (UnsupportedEncodingException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      paramString.commit();
      return;
      paramContext = new String(paramDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.toByteArray(), "ISO-8859-1");
    }
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return ((DatingSubjectItem)jdField_a_of_type_JavaUtilList.get(paramInt - 1)).id;
  }
  
  public boolean a()
  {
    return (this.d == 0) && (this.e == 0) && (this.f == 0) && (this.h == 0) && (this.i == 0);
  }
  
  public int b(int paramInt)
  {
    int n = 0;
    int k = 0;
    for (;;)
    {
      int m = n;
      if (k < jdField_a_of_type_JavaUtilList.size())
      {
        if (paramInt == ((DatingSubjectItem)jdField_a_of_type_JavaUtilList.get(k)).id) {
          m = k + 1;
        }
      }
      else {
        return m;
      }
      k += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DatingFilters)paramObject;
      if (this.h != paramObject.h) {
        return false;
      }
      if (this.i != paramObject.i) {
        return false;
      }
      if (this.f != paramObject.f) {
        return false;
      }
      if (this.e != paramObject.e) {
        return false;
      }
      if (this.d != paramObject.d) {
        return false;
      }
    } while ((this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == paramObject.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo) || ((this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) && (paramObject.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) && (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_name.get().equals(paramObject.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_name.get()))));
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DatingFilters [gender=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", datingTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", datingContent=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", age=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", career=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", dest=");
    if (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_name.get())
    {
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    try
    {
      if (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == null) {}
      for (String str = "";; str = new String(this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.toByteArray(), "ISO-8859-1"))
      {
        paramParcel.writeString(str);
        return;
      }
      return;
    }
    catch (UnsupportedEncodingException paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingFilters
 * JD-Core Version:    0.7.0.1
 */