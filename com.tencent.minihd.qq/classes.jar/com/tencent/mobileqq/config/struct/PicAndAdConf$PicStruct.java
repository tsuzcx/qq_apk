package com.tencent.mobileqq.config.struct;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PicAndAdConf$PicStruct
{
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 1;
  protected byte a;
  protected int a;
  protected long a;
  protected String a;
  protected short a;
  protected boolean a;
  protected byte[] a;
  public String b = null;
  protected String c = null;
  protected String d = null;
  protected String e = "";
  protected String f = "";
  
  public PicAndAdConf$PicStruct(PicAndAdConf paramPicAndAdConf)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Byte = 3;
    this.jdField_a_of_type_Short = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(DataInputStream paramDataInputStream)
  {
    this.jdField_a_of_type_Long = paramDataInputStream.readLong();
    this.jdField_a_of_type_JavaLangString = paramDataInputStream.readUTF();
    this.b = paramDataInputStream.readUTF();
    this.d = paramDataInputStream.readUTF();
    this.jdField_a_of_type_Byte = paramDataInputStream.readByte();
    this.c = paramDataInputStream.readUTF();
    this.e = paramDataInputStream.readUTF();
    this.jdField_a_of_type_Short = paramDataInputStream.readShort();
  }
  
  public void a(DataOutputStream paramDataOutputStream)
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    if (this.b == null) {
      this.b = "";
    }
    if (this.d == null) {
      this.d = "";
    }
    if (this.c == null) {
      this.c = "";
    }
    paramDataOutputStream.writeLong(this.jdField_a_of_type_Long);
    paramDataOutputStream.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramDataOutputStream.writeUTF(this.b);
    paramDataOutputStream.writeUTF(this.d);
    paramDataOutputStream.writeByte(this.jdField_a_of_type_Byte);
    paramDataOutputStream.writeUTF(this.c);
    paramDataOutputStream.writeUTF(this.e);
    paramDataOutputStream.writeShort(this.jdField_a_of_type_Short);
  }
  
  public void b(DataInputStream paramDataInputStream)
  {
    a(paramDataInputStream);
    this.f = paramDataInputStream.readUTF();
  }
  
  public void b(DataOutputStream paramDataOutputStream)
  {
    a(paramDataOutputStream);
    if (this.f == null) {
      this.f = "";
    }
    paramDataOutputStream.writeUTF(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.PicAndAdConf.PicStruct
 * JD-Core Version:    0.7.0.1
 */