package QQService;

import java.io.Serializable;

public final class CARDSETTYPE
  implements Serializable
{
  public static final CARDSETTYPE TYPE_SET_BACKGROUND;
  public static final CARDSETTYPE TYPE_SET_DEFAUT;
  public static final CARDSETTYPE TYPE_SET_SINGLE;
  public static final CARDSETTYPE TYPE_SET_TAGS;
  public static final CARDSETTYPE TYPE_SET_TEMPLATE;
  public static final int _TYPE_SET_BACKGROUND = 2;
  public static final int _TYPE_SET_DEFAUT = -1;
  public static final int _TYPE_SET_SINGLE = 0;
  public static final int _TYPE_SET_TAGS = 1;
  public static final int _TYPE_SET_TEMPLATE = 3;
  private static CARDSETTYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!CARDSETTYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new CARDSETTYPE[5];
      TYPE_SET_DEFAUT = new CARDSETTYPE(0, -1, "TYPE_SET_DEFAUT");
      TYPE_SET_SINGLE = new CARDSETTYPE(1, 0, "TYPE_SET_SINGLE");
      TYPE_SET_TAGS = new CARDSETTYPE(2, 1, "TYPE_SET_TAGS");
      TYPE_SET_BACKGROUND = new CARDSETTYPE(3, 2, "TYPE_SET_BACKGROUND");
      TYPE_SET_TEMPLATE = new CARDSETTYPE(4, 3, "TYPE_SET_TEMPLATE");
      return;
    }
  }
  
  private CARDSETTYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static CARDSETTYPE convert(int paramInt)
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
  
  public static CARDSETTYPE convert(String paramString)
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
 * Qualified Name:     QQService.CARDSETTYPE
 * JD-Core Version:    0.7.0.1
 */