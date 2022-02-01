package com.pay.api;

public class MidasAbilityCode
{
  public static abstract interface CANCEL
  {
    public static final int PAY_CANCEL = 1;
  }
  
  public static abstract interface ERROR
  {
    public static abstract interface LIB
    {
      public static final int PARAM_NULL = -1;
      public static final int UNSUPPORT_FEATURE = -1;
    }
    
    public static abstract interface SDK
    {
      public static final int CREATE_ABILITY_FAIL = -6;
      public static final int FAST_CLICK = -999;
      public static final int LOGIN_INVALID = -5;
      public static final int NETWORK_FAIL = -3;
      public static final int PARAM_ERROR = -4;
      public static final int UNDEFINED_REQ = -1;
      public static final int WX_VERSION_LOW = -2;
    }
  }
  
  public static abstract interface SUCC
  {
    public static final int PAY_SUCC = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.api.MidasAbilityCode
 * JD-Core Version:    0.7.0.1
 */