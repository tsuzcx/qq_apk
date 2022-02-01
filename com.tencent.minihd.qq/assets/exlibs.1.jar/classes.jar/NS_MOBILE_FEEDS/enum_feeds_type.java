package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class enum_feeds_type
  implements Serializable
{
  public static final int _enum_active_feeds = 0;
  public static final int _enum_passive_feeds = 1;
  public static final int _enum_profile_feeds = 2;
  private static enum_feeds_type[] a;
  public static final enum_feeds_type enum_active_feeds;
  public static final enum_feeds_type enum_passive_feeds;
  public static final enum_feeds_type enum_profile_feeds;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!enum_feeds_type.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new enum_feeds_type[3];
      enum_active_feeds = new enum_feeds_type(0, 0, "enum_active_feeds");
      enum_passive_feeds = new enum_feeds_type(1, 1, "enum_passive_feeds");
      enum_profile_feeds = new enum_feeds_type(2, 2, "enum_profile_feeds");
      return;
    }
  }
  
  private enum_feeds_type(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static enum_feeds_type convert(int paramInt)
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
  
  public static enum_feeds_type convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_FEEDS.enum_feeds_type
 * JD-Core Version:    0.7.0.1
 */