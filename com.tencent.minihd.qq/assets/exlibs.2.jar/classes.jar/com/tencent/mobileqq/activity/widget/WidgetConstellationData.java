package com.tencent.mobileqq.activity.widget;

import com.tencent.mobileqq.util.Utils;

public class WidgetConstellationData
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
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f = "";
  public String g = "";
  public String h = "";
  public int m;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public int q = 0;
  public int r = 0;
  public int s = 0;
  public int t = 0;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof WidgetConstellationData))) {}
    do
    {
      return false;
      paramObject = (WidgetConstellationData)paramObject;
    } while ((paramObject.m != this.m) || (paramObject.r != this.r) || (!Utils.a(paramObject.a, this.a)) || (!Utils.a(paramObject.c, this.c)) || (!Utils.a(paramObject.d, this.d)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.WidgetConstellationData
 * JD-Core Version:    0.7.0.1
 */