package com.tencent.mobileqq.activity.widget.qqmusic.utils;

public class CharStack
{
  final StringBuilder a = new StringBuilder();
  
  public char a()
  {
    int i = this.a.length() - 1;
    char c = this.a.charAt(i);
    this.a.setLength(i);
    return c;
  }
  
  public int a()
  {
    return this.a.length();
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return this.a.substring(paramInt1, paramInt2);
  }
  
  public void a(char paramChar)
  {
    this.a.append(paramChar);
  }
  
  public void a(String paramString)
  {
    this.a.append(paramString);
  }
  
  public char b()
  {
    int i = this.a.length();
    return this.a.charAt(i - 1);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.CharStack
 * JD-Core Version:    0.7.0.1
 */