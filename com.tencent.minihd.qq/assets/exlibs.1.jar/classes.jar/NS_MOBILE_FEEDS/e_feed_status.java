package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class e_feed_status
  implements Serializable
{
  public static final int _enum_feed_delete = 3;
  public static final int _enum_feed_new = 0;
  public static final int _enum_feed_same = 2;
  public static final int _enum_feed_update = 1;
  private static e_feed_status[] a;
  public static final e_feed_status enum_feed_delete;
  public static final e_feed_status enum_feed_new;
  public static final e_feed_status enum_feed_same;
  public static final e_feed_status enum_feed_update;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!e_feed_status.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new e_feed_status[4];
      enum_feed_new = new e_feed_status(0, 0, "enum_feed_new");
      enum_feed_update = new e_feed_status(1, 1, "enum_feed_update");
      enum_feed_same = new e_feed_status(2, 2, "enum_feed_same");
      enum_feed_delete = new e_feed_status(3, 3, "enum_feed_delete");
      return;
    }
  }
  
  private e_feed_status(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static e_feed_status convert(int paramInt)
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
  
  public static e_feed_status convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_FEEDS.e_feed_status
 * JD-Core Version:    0.7.0.1
 */