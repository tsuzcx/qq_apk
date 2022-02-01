package com.qqreader;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import on;
import oo;
import op;

public class ReaderPluginReport
{
  private static final int jdField_a_of_type_Int = 1;
  private static String jdField_a_of_type_JavaLangString = "ReaderPluginReport";
  private static final int jdField_b_of_type_Int = 2;
  private static final int jdField_c_of_type_Int = 103;
  private static String jdField_c_of_type_JavaLangString;
  private static String d = "type=";
  private static String e = "&time=";
  private static String f = "&usid=";
  private static String g = "&ext=";
  private static String h = "&clicks=";
  private static String i = "&c_version=";
  private static final String j = "COM.QQREADER.SETTING";
  private static final String k = "COM.QQREADER.HASREPORT";
  private static final String l = "COM.QQREADER.HASBACK";
  private static final String m = "COM.QQREADER.CLICKTIMES";
  private Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    c = "https://allreader.3g.qq.com/mqqPluginUpdate?";
  }
  
  public ReaderPluginReport(String paramString, Context paramContext)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("COM.QQREADER.SETTING", 0).getInt("COM.QQREADER.HASREPORT", 0);
  }
  
  private int b(Context paramContext)
  {
    return paramContext.getSharedPreferences("COM.QQREADER.SETTING", 0).getInt("COM.QQREADER.CLICKTIMES", 0);
  }
  
  private static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences("COM.QQREADER.SETTING", 0).getString("COM.QQREADER.HASBACK", "");
  }
  
  private static void c(Context paramContext, int paramInt)
  {
    paramContext.getSharedPreferences("COM.QQREADER.SETTING", 0).edit().putInt("COM.QQREADER.HASREPORT", paramInt).commit();
  }
  
  private static void d(Context paramContext, int paramInt)
  {
    String str = b(paramContext);
    str = str + paramInt + "*" + System.currentTimeMillis() + "_";
    paramContext.getSharedPreferences("COM.QQREADER.SETTING", 0).edit().putString("COM.QQREADER.HASBACK", str).commit();
  }
  
  public void a()
  {
    ThreadManager.a(new on(this));
  }
  
  public void a(int paramInt)
  {
    d(this.jdField_a_of_type_AndroidContentContext, paramInt);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    paramContext.getSharedPreferences("COM.QQREADER.SETTING", 0).edit().putInt("COM.QQREADER.CLICKTIMES", paramInt).commit();
  }
  
  public void b()
  {
    if ((a(this.jdField_a_of_type_AndroidContentContext) >= 1) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    new Thread(new oo(this)).start();
  }
  
  public void c()
  {
    if ((a(this.jdField_a_of_type_AndroidContentContext) >= 2) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    new Thread(new op(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.ReaderPluginReport
 * JD-Core Version:    0.7.0.1
 */