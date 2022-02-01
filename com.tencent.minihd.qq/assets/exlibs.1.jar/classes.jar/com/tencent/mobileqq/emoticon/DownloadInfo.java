package com.tencent.mobileqq.emoticon;

import java.io.File;

public class DownloadInfo
{
  public final int a;
  public final File a;
  public final String a;
  public boolean a;
  public byte[] a;
  public int b;
  public String b;
  public boolean b;
  public int c = -1;
  public String c;
  public int d;
  public String d = null;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public DownloadInfo(String paramString, File paramFile, int paramInt)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + ".tmp";
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = false;
    this.d = null;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = null;
    this.c = -1;
    this.jdField_e_of_type_Int = 0;
    this.h = null;
    this.i = null;
    this.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */