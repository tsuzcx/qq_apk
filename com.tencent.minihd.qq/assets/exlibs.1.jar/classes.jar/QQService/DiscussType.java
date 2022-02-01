package QQService;

import java.io.Serializable;

public final class DiscussType
  implements Serializable
{
  public static final DiscussType CONTACTS;
  public static final DiscussType DISCUSSADD_AnyToGroup;
  public static final int _CONTACTS = 4;
  public static final int _DISCUSSADD = 2;
  public static final int _DISCUSSADD_AnyToGroup = 3;
  public static final int _DISCUSSCREATE = 0;
  public static final int _DISCUSSCREATE_AnyToGroup = 1;
  private static DiscussType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!DiscussType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new DiscussType[5];
      DISCUSSADD_AnyToGroup = new DiscussType(3, 3, "DISCUSSADD_AnyToGroup");
      CONTACTS = new DiscussType(4, 4, "CONTACTS");
      return;
    }
  }
  
  private DiscussType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static DiscussType convert(int paramInt)
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
  
  public static DiscussType convert(String paramString)
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
 * Qualified Name:     QQService.DiscussType
 * JD-Core Version:    0.7.0.1
 */