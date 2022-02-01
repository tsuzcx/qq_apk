package com.tencent.component.network.module.report;

import android.util.SparseArray;

public class ExtendData
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  private SparseArray a = new SparseArray(12);
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)this.a.get(0, ""));
    int m = 1;
    while (m < 12)
    {
      localStringBuilder.append("|");
      localStringBuilder.append((String)this.a.get(m, ""));
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.put(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.report.ExtendData
 * JD-Core Version:    0.7.0.1
 */