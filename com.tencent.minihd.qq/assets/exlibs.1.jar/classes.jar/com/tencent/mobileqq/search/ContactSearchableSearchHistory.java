package com.tencent.mobileqq.search;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;

public class ContactSearchableSearchHistory
  extends IContactSearchable
{
  private SearchHistory a;
  
  public ContactSearchableSearchHistory(QQAppInterface paramQQAppInterface, SearchHistory paramSearchHistory)
  {
    this.a = paramSearchHistory;
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public SearchHistory a()
  {
    return this.a;
  }
  
  public String a()
  {
    return this.a.displayName;
  }
  
  public void a(String paramString) {}
  
  public int b()
  {
    switch (this.a.type)
    {
    default: 
      return 1;
    case 3000: 
      return 101;
    case 1: 
      return 4;
    }
    return 11;
  }
  
  public String b()
  {
    return this.a.extralInfo;
  }
  
  public String c()
  {
    return null;
  }
  
  public String d()
  {
    return this.a.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableSearchHistory
 * JD-Core Version:    0.7.0.1
 */