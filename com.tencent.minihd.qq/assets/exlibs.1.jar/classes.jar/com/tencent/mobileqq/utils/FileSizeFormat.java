package com.tencent.mobileqq.utils;

public class FileSizeFormat
{
  private static final long jdField_a_of_type_Long = 1024L;
  private static char[] jdField_a_of_type_ArrayOfChar;
  private static final long jdField_b_of_type_Long = 1048576L;
  private static final char[] jdField_b_of_type_ArrayOfChar;
  private static final long c = 1073741824L;
  
  static
  {
    a = new char[32];
    b = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  }
  
  public static String a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    double d = l;
    int i;
    int k;
    int j;
    label62:
    int m;
    label90:
    char[] arrayOfChar;
    if (l < 1048576L) {
      if (l < 1024L)
      {
        i = 66;
        k = (int)(0.005D + d);
        if (k >= 100) {
          break label303;
        }
        if (k >= 10) {
          break label297;
        }
        j = 1;
        if (i == 66) {
          break label337;
        }
        k = (int)(d * 100.0D + 0.5D);
        m = j + 5;
        j = k;
        if (m <= a.length) {
          break label350;
        }
        arrayOfChar = new char[m];
        label105:
        k = m - 1;
        arrayOfChar[k] = 'B';
        if (i == 66) {
          break label358;
        }
        k -= 1;
        arrayOfChar[k] = i;
        k -= 1;
        arrayOfChar[k] = b[(j % 10)];
        j /= 10;
        k -= 1;
        arrayOfChar[k] = b[(j % 10)];
        j /= 10;
        k -= 1;
        arrayOfChar[k] = '.';
      }
    }
    label297:
    label303:
    label337:
    label350:
    label358:
    for (;;)
    {
      k -= 1;
      arrayOfChar[k] = b[(j % 10)];
      int n = j / 10;
      j = n;
      if (n <= 0)
      {
        return new String(arrayOfChar, 0, m);
        d /= 1024.0D;
        i = 75;
        break;
        if (l < 1073741824L)
        {
          d /= 1048576.0D;
          i = 77;
          break;
        }
        d /= 1073741824.0D;
        i = 71;
        break;
        j = 2;
        break label62;
        if (k < 1000)
        {
          j = 3;
          break label62;
        }
        if (k < 10000)
        {
          j = 4;
          break label62;
        }
        j = 5;
        break label62;
        m = j + 1;
        j = k;
        break label90;
        arrayOfChar = a;
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileSizeFormat
 * JD-Core Version:    0.7.0.1
 */