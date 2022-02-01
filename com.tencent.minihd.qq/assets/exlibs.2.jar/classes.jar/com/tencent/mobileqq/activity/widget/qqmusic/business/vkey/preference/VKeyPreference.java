package com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import java.util.Vector;

public class VKeyPreference
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static final String b = "@;";
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public final String a;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  
  public VKeyPreference(String paramString, Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences(this.jdField_a_of_type_JavaLangString, 0);
    this.c = (this.jdField_a_of_type_JavaLangString + "birthtime");
    this.d = (this.jdField_a_of_type_JavaLangString + "vkey");
    this.e = (this.jdField_a_of_type_JavaLangString + "servercheck");
    this.f = (this.jdField_a_of_type_JavaLangString + "baseurls");
    this.g = (this.jdField_a_of_type_JavaLangString + "urls");
    this.h = (this.jdField_a_of_type_JavaLangString + "results");
    this.i = (this.jdField_a_of_type_JavaLangString + "hqvkey");
    this.j = (this.jdField_a_of_type_JavaLangString + "hqqq");
    this.k = (this.jdField_a_of_type_JavaLangString + "vkeypair");
  }
  
  private static String a(Vector paramVector)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    int m = 0;
    while (m < paramVector.size())
    {
      localStringBuffer.append((String)paramVector.get(m)).append("@;");
      m += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static String a(long[] paramArrayOfLong)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    int m = 0;
    while (m < paramArrayOfLong.length)
    {
      localStringBuffer.append(paramArrayOfLong[m]).append("@;");
      m += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static Vector a(String paramString)
  {
    Vector localVector = new Vector();
    if (paramString != null)
    {
      for (int m = paramString.indexOf("@;"); m != -1; m = paramString.indexOf("@;"))
      {
        String str = paramString.substring(0, m);
        if (str.length() > 0) {
          localVector.add(str);
        }
        paramString = paramString.substring(m + "@;".length());
      }
      if (paramString.length() > 0) {
        localVector.add(paramString);
      }
    }
    return localVector;
  }
  
  private static long[] a(String paramString)
  {
    Vector localVector = new Vector();
    if (paramString != null)
    {
      for (m = paramString.indexOf("@;"); m != -1; m = paramString.indexOf("@;"))
      {
        String str = paramString.substring(0, m);
        if (str.length() > 0) {
          localVector.add(str);
        }
        paramString = paramString.substring(m + "@;".length());
      }
      if (paramString.length() > 0) {
        localVector.add(paramString);
      }
    }
    paramString = new long[localVector.size()];
    int m = 0;
    for (;;)
    {
      if (m < localVector.size()) {}
      try
      {
        paramString[m] = Long.parseLong((String)localVector.elementAt(m));
        label110:
        m += 1;
        continue;
        return paramString;
      }
      catch (Exception localException)
      {
        break label110;
      }
    }
  }
  
  public long a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(this.c, 0L);
        return l;
      }
      return 0L;
    }
  }
  
  public String a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.d, "");
        return str;
      }
      return "";
    }
  }
  
  public String a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((!MusicUtil.a(paramString)) && (this.jdField_a_of_type_AndroidContentSharedPreferences != null))
      {
        String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.j, "");
        if ((!MusicUtil.a(str)) && (paramString.equals(str)))
        {
          paramString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.i, "");
          return paramString;
        }
      }
      return "";
    }
  }
  
  public Vector a()
  {
    Object localObject3 = this.jdField_a_of_type_JavaLangObject;
    Object localObject1 = "";
    try
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.f, "");
      }
      localObject1 = a((String)localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putLong(this.c, -1L);
        localEditor.commit();
      }
      return;
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, Vector paramVector1, Vector paramVector2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramString1 != null) && (paramString2 != null) && (paramVector1 != null) && (paramVector2 != null))
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putLong(this.c, paramLong);
        localEditor.putString(this.d, paramString1);
        localEditor.putString(this.e, paramString2);
        localEditor.putString(this.f, a(paramVector1));
        localEditor.putString(this.g, a(paramVector2));
        localEditor.putString(this.h, "");
        localEditor.putString(this.i, "");
        localEditor.putString(this.j, "");
        localEditor.commit();
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramString != null))
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putString(this.k, paramString);
        localEditor.commit();
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramString1 != null))
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putString(this.i, paramString1);
        localEditor.putString(this.j, paramString2);
        localEditor.commit();
      }
      return;
    }
  }
  
  public void a(long[] paramArrayOfLong)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramArrayOfLong != null))
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putString(this.h, a(paramArrayOfLong));
        localEditor.commit();
      }
      return;
    }
  }
  
  public long[] a()
  {
    Object localObject3 = this.jdField_a_of_type_JavaLangObject;
    Object localObject1 = "";
    try
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.h, "");
      }
      localObject1 = a((String)localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public String b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.k, "");
        return str;
      }
      return "";
    }
  }
  
  public String b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((!MusicUtil.a(paramString)) && (this.jdField_a_of_type_AndroidContentSharedPreferences != null))
      {
        paramString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, "");
        return paramString;
      }
      return "";
    }
  }
  
  public Vector b()
  {
    Object localObject3 = this.jdField_a_of_type_JavaLangObject;
    Object localObject1 = "";
    try
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.g, "");
      }
      localObject1 = a((String)localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public void b(String paramString1, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramString1 != null))
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putString(paramString2, paramString1);
        localEditor.commit();
      }
      return;
    }
  }
  
  public String c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.e, "");
        return str;
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.preference.VKeyPreference
 * JD-Core Version:    0.7.0.1
 */