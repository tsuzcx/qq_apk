package com.tencent.mobileqq.profile;

public class ProfileBusiEntry
{
  public static final int b = 1024;
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      bool1 = bool2;
      if (this.b.trim().length() > 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.jdField_a_of_type_Int).append(",").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.b).append(",").append(this.c).append(",").append(this.d).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileBusiEntry
 * JD-Core Version:    0.7.0.1
 */