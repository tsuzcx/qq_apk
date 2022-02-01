package RegisterProxySvcPack;

import java.io.Serializable;

public final class eRoamFlagType
  implements Serializable
{
  public static final eRoamFlagType QQ_24HOURS_ROAM;
  public static final eRoamFlagType QQ_7DAYS_ROAM;
  public static final eRoamFlagType QQ_VIP_1MONTH_ROAM;
  public static final eRoamFlagType SUPPER_QQ_1MONTH_ROAM;
  public static final eRoamFlagType SUPPER_VIP_2YEARS_ROAM;
  public static final eRoamFlagType SUPPER_VIP_FOREVER_ROAM;
  public static final int _QQ_24HOURS_ROAM = 32;
  public static final int _QQ_7DAYS_ROAM = 16;
  public static final int _QQ_VIP_1MONTH_ROAM = 8;
  public static final int _SUPPER_QQ_1MONTH_ROAM = 4;
  public static final int _SUPPER_VIP_2YEARS_ROAM = 2;
  public static final int _SUPPER_VIP_FOREVER_ROAM = 1;
  private static eRoamFlagType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eRoamFlagType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new eRoamFlagType[6];
      SUPPER_VIP_FOREVER_ROAM = new eRoamFlagType(0, 1, "SUPPER_VIP_FOREVER_ROAM");
      SUPPER_VIP_2YEARS_ROAM = new eRoamFlagType(1, 2, "SUPPER_VIP_2YEARS_ROAM");
      SUPPER_QQ_1MONTH_ROAM = new eRoamFlagType(2, 4, "SUPPER_QQ_1MONTH_ROAM");
      QQ_VIP_1MONTH_ROAM = new eRoamFlagType(3, 8, "QQ_VIP_1MONTH_ROAM");
      QQ_7DAYS_ROAM = new eRoamFlagType(4, 16, "QQ_7DAYS_ROAM");
      QQ_24HOURS_ROAM = new eRoamFlagType(5, 32, "QQ_24HOURS_ROAM");
      return;
    }
  }
  
  private eRoamFlagType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static eRoamFlagType convert(int paramInt)
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
  
  public static eRoamFlagType convert(String paramString)
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
 * Qualified Name:     RegisterProxySvcPack.eRoamFlagType
 * JD-Core Version:    0.7.0.1
 */