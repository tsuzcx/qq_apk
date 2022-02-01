package com.tencent.mobileqq.activity.widget.qqmusic.data;

import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import org.json.JSONObject;

public class FolderInfo
{
  public static final int a = 1;
  public static final int b = 2;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramJSONObject.optLong("id");
    this.jdField_b_of_type_Long = paramJSONObject.optLong("dv");
    this.jdField_a_of_type_JavaLangString = MusicUtil.b(paramJSONObject.optString("n"));
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("url");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("bigpic");
    this.jdField_c_of_type_Int = paramJSONObject.optInt("dirtype");
    this.jdField_c_of_type_Long = paramJSONObject.optLong("disstid");
    this.jdField_d_of_type_Long = paramJSONObject.optLong("qq");
    this.jdField_d_of_type_JavaLangString = MusicUtil.b(paramJSONObject.optString("nickname"));
  }
  
  public long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public long c()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public void c(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public String toString()
  {
    return "FolderInfo{id=" + this.jdField_a_of_type_Long + ", name=" + this.jdField_a_of_type_JavaLangString + ", qq=" + this.jdField_d_of_type_Long + ", dirtype=" + this.jdField_c_of_type_Int + ", url=" + this.jdField_b_of_type_JavaLangString + ", nickname" + this.jdField_d_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.data.FolderInfo
 * JD-Core Version:    0.7.0.1
 */