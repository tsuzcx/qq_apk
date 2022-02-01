package com.tencent.mobileqq.activity.widget.qqmusic.data;

import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;

public class ID3
{
  public static final String a = "";
  public static final String b = "unknown";
  public static final String c = "<unknown>";
  public static final String d = "未知歌手";
  public static final String e = "未知专辑";
  private boolean a = true;
  private boolean b = true;
  private boolean c = true;
  private String f = "";
  private String g = "未知歌手";
  private String h = "未知专辑";
  
  public String a()
  {
    if (this.a) {
      return "";
    }
    return this.f;
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.trim().equals("unknown")) || (paramString.trim().equals("<unknown>"))) {}
    for (this.a = true;; this.a = false)
    {
      this.f = MusicUtil.d(paramString);
      return;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean a(ID3 paramID3)
  {
    if (paramID3 != null)
    {
      this.h = paramID3.h;
      this.g = paramID3.g;
      this.f = paramID3.f;
      this.c = paramID3.c;
      this.b = paramID3.b;
      this.a = paramID3.a;
      return true;
    }
    return false;
  }
  
  public String b()
  {
    if (this.b) {
      return "未知歌手";
    }
    return this.g;
  }
  
  public void b(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.trim().equals("unknown")) || (paramString.trim().equals("<unknown>"))) {}
    for (this.b = true;; this.b = false)
    {
      this.g = MusicUtil.d(paramString);
      if (this.g != null) {
        this.g = this.g.trim();
      }
      return;
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public String c()
  {
    if (this.c) {
      return "未知专辑";
    }
    return this.h;
  }
  
  public void c(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.trim().equals("unknown")) || (paramString.trim().equals("<unknown>"))) {}
    for (this.c = true;; this.c = false)
    {
      this.h = paramString;
      if (this.h != null) {
        this.h = this.h.trim();
      }
      return;
    }
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof ID3))
      {
        paramObject = (ID3)paramObject;
        bool1 = bool2;
        if (MusicUtil.a(paramObject.f, this.f))
        {
          bool1 = bool2;
          if (MusicUtil.a(paramObject.g, this.g))
          {
            bool1 = bool2;
            if (MusicUtil.a(paramObject.h, this.h)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    return "ID3{title='" + this.f + '\'' + ", artist='" + this.g + '\'' + ", album='" + this.h + '\'' + ", titleEmpty=" + this.a + ", artistEmpty=" + this.b + ", albumEmpty=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.data.ID3
 * JD-Core Version:    0.7.0.1
 */