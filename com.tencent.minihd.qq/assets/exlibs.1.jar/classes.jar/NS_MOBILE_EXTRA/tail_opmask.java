package NS_MOBILE_EXTRA;

import java.io.Serializable;

public final class tail_opmask
  implements Serializable
{
  public static final tail_opmask ENUM_FOR_ALL;
  public static final tail_opmask ENUM_FOR_TIP;
  public static final tail_opmask ENUM_FOR_VIP;
  public static final int _ENUM_FOR_ALL = 1;
  public static final int _ENUM_FOR_TIP = 3;
  public static final int _ENUM_FOR_VIP = 2;
  private static tail_opmask[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!tail_opmask.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new tail_opmask[3];
      ENUM_FOR_ALL = new tail_opmask(0, 1, "ENUM_FOR_ALL");
      ENUM_FOR_VIP = new tail_opmask(1, 2, "ENUM_FOR_VIP");
      ENUM_FOR_TIP = new tail_opmask(2, 3, "ENUM_FOR_TIP");
      return;
    }
  }
  
  private tail_opmask(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static tail_opmask convert(int paramInt)
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
  
  public static tail_opmask convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_EXTRA.tail_opmask
 * JD-Core Version:    0.7.0.1
 */