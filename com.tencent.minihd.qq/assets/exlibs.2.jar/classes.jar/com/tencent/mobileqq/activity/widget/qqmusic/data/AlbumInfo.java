package com.tencent.mobileqq.activity.widget.qqmusic.data;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.parser.AlbumXmlResponse;

public class AlbumInfo
  extends BaseInfo
{
  private static final String jdField_a_of_type_JavaLangString = "liwei";
  private long jdField_a_of_type_Long;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public long a()
  {
    return this.a;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    AlbumXmlResponse localAlbumXmlResponse = new AlbumXmlResponse();
    localAlbumXmlResponse.a(paramString);
    this.a = localAlbumXmlResponse.a();
    this.b = localAlbumXmlResponse.a();
    this.c = localAlbumXmlResponse.b();
    this.d = localAlbumXmlResponse.c();
    this.e = localAlbumXmlResponse.d();
    this.f = localAlbumXmlResponse.e();
    this.g = localAlbumXmlResponse.f();
    this.h = localAlbumXmlResponse.g();
    this.i = localAlbumXmlResponse.h();
    MLog.b("liwei", "album pic : " + this.b);
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public String h()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.data.AlbumInfo
 * JD-Core Version:    0.7.0.1
 */