package com.tencent.mm.model;

import android.database.Cursor;
import junit.framework.Assert;

public final class bj
{
  public int bcw = -1;
  public String dTD = "";
  public String dTF = "";
  public String dXd = "";
  public String dXe = "";
  public String dXf = "";
  public long dXg = 0L;
  public String dXh = "";
  public String dXi = "";
  public int dXj = 0;
  public int dXk = 0;
  public long dXl = 0L;
  public String dXm = "";
  public String dXn = "";
  public String name = "";
  public long time = 0L;
  public String title = "";
  public int type = 0;
  public String url = "";
  
  public static String hS(int paramInt)
  {
    if (paramInt == 20) {
      return "newsapp";
    }
    if (paramInt == 11) {
      return "blogapp";
    }
    Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
    return null;
  }
  
  public final boolean HV()
  {
    return this.dXk == 1;
  }
  
  public final String HW()
  {
    if (this.dXd == null) {
      return "";
    }
    return this.dXd;
  }
  
  public final String HX()
  {
    if (this.dXe == null) {
      return "";
    }
    return this.dXe;
  }
  
  public final String HY()
  {
    if (this.dXh == null) {
      return "";
    }
    return this.dXh;
  }
  
  public final String HZ()
  {
    if (this.dXi == null) {
      return "";
    }
    return this.dXi;
  }
  
  public final String Ia()
  {
    if (this.dTD != null)
    {
      String[] arrayOfString = this.dTD.split("\\|");
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        return arrayOfString[0];
      }
      return "";
    }
    return "";
  }
  
  public final void d(Cursor paramCursor)
  {
    this.dXd = paramCursor.getString(0);
    this.time = paramCursor.getLong(1);
    this.type = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.title = paramCursor.getString(4);
    this.url = paramCursor.getString(5);
    this.dXe = paramCursor.getString(6);
    this.dXf = paramCursor.getString(7);
    this.dXg = paramCursor.getLong(8);
    this.dXh = paramCursor.getString(9);
    this.dXi = paramCursor.getString(10);
    this.dXj = paramCursor.getInt(11);
    this.dTD = paramCursor.getString(12);
    this.dTF = paramCursor.getString(13);
    this.dXk = paramCursor.getInt(14);
    this.dXl = paramCursor.getLong(15);
    this.dXm = paramCursor.getString(16);
    this.dXn = paramCursor.getString(17);
  }
  
  public final String getDigest()
  {
    if (this.dTF == null) {
      return "";
    }
    return this.dTF;
  }
  
  public final String getName()
  {
    if (this.name == null) {
      return "";
    }
    return this.name;
  }
  
  public final String getTitle()
  {
    if (this.title == null) {
      return "";
    }
    return this.title;
  }
  
  public final String getUrl()
  {
    if (this.url == null) {
      return "";
    }
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bj
 * JD-Core Version:    0.7.0.1
 */