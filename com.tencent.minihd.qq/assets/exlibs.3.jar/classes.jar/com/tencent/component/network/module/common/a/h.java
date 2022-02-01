package com.tencent.component.network.module.common.a;

public class h
{
  private static byte[] jdField_a_of_type_ArrayOfByte = { 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 };
  private static byte[] b = { 0, 0, 1, 0, 1 };
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public h(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = b.a().a();
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte[0] = ((byte)(this.jdField_a_of_type_Int >>> 8 & 0xFF));
    paramArrayOfByte[1] = ((byte)(this.jdField_a_of_type_Int & 0xFF));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public byte[] a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    do
    {
      return null;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.trim().toLowerCase();
    } while (this.jdField_a_of_type_JavaLangString.length() == 0);
    byte[] arrayOfByte1 = new byte[jdField_a_of_type_ArrayOfByte.length + b.length + this.jdField_a_of_type_JavaLangString.length() + 1];
    String[] arrayOfString = this.jdField_a_of_type_JavaLangString.split("\\.");
    int j = jdField_a_of_type_ArrayOfByte.length;
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfByte1[j] = ((byte)arrayOfString[i].length());
      j += 1;
      byte[] arrayOfByte2 = arrayOfString[i].getBytes();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
    System.arraycopy(jdField_a_of_type_ArrayOfByte, 0, arrayOfByte1, 0, jdField_a_of_type_ArrayOfByte.length);
    System.arraycopy(b, 0, arrayOfByte1, j, b.length);
    a(arrayOfByte1);
    return arrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.h
 * JD-Core Version:    0.7.0.1
 */