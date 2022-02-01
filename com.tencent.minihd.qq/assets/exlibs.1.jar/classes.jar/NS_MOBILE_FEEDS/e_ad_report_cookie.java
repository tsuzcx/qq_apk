package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class e_ad_report_cookie
  implements Serializable
{
  public static final e_ad_report_cookie AD_FEED_PAGEUIN;
  public static final e_ad_report_cookie AD_FEED_QUERYSTRING;
  public static final e_ad_report_cookie AD_FEED_TRACEID;
  public static final e_ad_report_cookie AD_FEED_TYPE;
  public static final e_ad_report_cookie AD_FEED_VIEWID;
  public static final int _AD_FEED_PAGEUIN = 4;
  public static final int _AD_FEED_QUERYSTRING = 2;
  public static final int _AD_FEED_TRACEID = 3;
  public static final int _AD_FEED_TYPE = 0;
  public static final int _AD_FEED_VIEWID = 1;
  private static e_ad_report_cookie[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!e_ad_report_cookie.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new e_ad_report_cookie[5];
      AD_FEED_TYPE = new e_ad_report_cookie(0, 0, "AD_FEED_TYPE");
      AD_FEED_VIEWID = new e_ad_report_cookie(1, 1, "AD_FEED_VIEWID");
      AD_FEED_QUERYSTRING = new e_ad_report_cookie(2, 2, "AD_FEED_QUERYSTRING");
      AD_FEED_TRACEID = new e_ad_report_cookie(3, 3, "AD_FEED_TRACEID");
      AD_FEED_PAGEUIN = new e_ad_report_cookie(4, 4, "AD_FEED_PAGEUIN");
      return;
    }
  }
  
  private e_ad_report_cookie(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static e_ad_report_cookie convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static e_ad_report_cookie convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.e_ad_report_cookie
 * JD-Core Version:    0.7.0.1
 */