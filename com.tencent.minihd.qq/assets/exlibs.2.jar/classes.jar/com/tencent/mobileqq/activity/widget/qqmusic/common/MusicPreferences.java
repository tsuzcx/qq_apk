package com.tencent.mobileqq.activity.widget.qqmusic.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class MusicPreferences
{
  private static MusicPreferences jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicCommonMusicPreferences;
  private static final String jdField_a_of_type_JavaLangString = "qqmusic";
  private static final String b = "openudid2";
  private static final String c = "origchid";
  private static final String d = "currentchid";
  private static final String e = "lastalbum";
  private static final String f = "lastfoldertype";
  private static final String g = "lastfolderid";
  private static final String h = "lastfoldername";
  private static final String i = "lastfolderdisstid";
  private static final String j = "lastfolderqq";
  private static final String k = "lastfoldersongindex";
  private static final String l = "lastfolderplaymode";
  private static final String m = "ish5frominnerclickpause";
  private static final String n = "ish5frominnerclickplay";
  private Context jdField_a_of_type_AndroidContentContext;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  
  private int a(String paramString)
  {
    return a(paramString, 0);
  }
  
  private int a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qqmusic", 4).getInt(paramString, paramInt);
  }
  
  private long a(String paramString)
  {
    return a(paramString, 0L);
  }
  
  private long a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qqmusic", 4).getLong(paramString, paramLong);
  }
  
  public static MusicPreferences a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicCommonMusicPreferences == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicCommonMusicPreferences == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicCommonMusicPreferences = new MusicPreferences();
      }
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicCommonMusicPreferences.jdField_a_of_type_AndroidContentSharedPreferences == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicCommonMusicPreferences.a();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicCommonMusicPreferences;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    return a(paramString, "");
  }
  
  private String a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qqmusic", 4).getString(paramString1, paramString2);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.a();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qqmusic", 4);
  }
  
  private void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  private void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  private boolean a(String paramString)
  {
    return a(paramString, false);
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qqmusic", 4).getBoolean(paramString, paramBoolean);
  }
  
  public int a()
  {
    return a("lastfoldertype", 1);
  }
  
  public long a()
  {
    return a("lastfolderid", 201L);
  }
  
  public String a()
  {
    return a("openudid2");
  }
  
  public void a(int paramInt)
  {
    a("lastfoldertype", paramInt);
  }
  
  public void a(long paramLong)
  {
    a("lastfolderid", paramLong);
  }
  
  public void a(String paramString)
  {
    a("openudid2", paramString);
  }
  
  public int b()
  {
    return a("lastfoldersongindex");
  }
  
  public long b()
  {
    return a("lastfolderdisstid");
  }
  
  public String b()
  {
    return a("origchid");
  }
  
  public void b(int paramInt)
  {
    a("lastfoldersongindex", paramInt);
  }
  
  public void b(long paramLong)
  {
    a("lastfolderdisstid", paramLong);
  }
  
  public void b(String paramString)
  {
    a("origchid", paramString);
  }
  
  public int c()
  {
    return a("lastfolderplaymode");
  }
  
  public long c()
  {
    return a("lastfolderqq");
  }
  
  public String c()
  {
    return a("currentchid");
  }
  
  public void c(int paramInt)
  {
    a("lastfolderplaymode", paramInt);
  }
  
  public void c(long paramLong)
  {
    a("lastfolderqq", paramLong);
  }
  
  public void c(String paramString)
  {
    a("currentchid", paramString);
  }
  
  public int d()
  {
    return a("ish5frominnerclickpause", 0);
  }
  
  public String d()
  {
    return a("lastalbum");
  }
  
  public void d(int paramInt)
  {
    a("ish5frominnerclickpause", paramInt);
  }
  
  public void d(String paramString)
  {
    a("lastalbum", paramString);
  }
  
  public int e()
  {
    return a("ish5frominnerclickplay", 0);
  }
  
  public String e()
  {
    return a("lastfoldername");
  }
  
  public void e(int paramInt)
  {
    a("ish5frominnerclickplay", paramInt);
  }
  
  public void e(String paramString)
  {
    a("lastfoldername", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences
 * JD-Core Version:    0.7.0.1
 */