package com.pay.http;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class APPluginErrorCode
{
  public static final int ERROR_APP_REGETKEYERROR = 5001;
  public static final int ERROR_APP_SYSTEM = 2000;
  public static final int ERROR_APP_SYSTEM_KEYNULL = 2001;
  public static final int ERROR_APP_TENPAY = 3000;
  public static final int ERROR_APP_TENPAY_RET3 = 3003;
  public static final int ERROR_APP_TENPAY_RET4 = 3004;
  public static final int ERROR_APP_TENPAY_RET5 = 3005;
  public static final int ERROR_APP_WECHAT = 4000;
  public static final int ERROR_APP_WECHAT_RET = 4001;
  public static final int ERROR_NETWORK_CONTENTNULL = 1004;
  public static final int ERROR_NETWORK_CONTIMEOUT = 1001;
  public static final int ERROR_NETWORK_HTTPSTIMES = 1100;
  public static final int ERROR_NETWORK_JOSNFORMT = 1003;
  public static final int ERROR_NETWORK_READTIMEOUT = 1002;
  public static final int ERROR_NETWORK_SYSTEM = 1000;
  
  public static String getErrorCode(int paramInt)
  {
    AppMethodBeat.i(253695);
    String str = "(100-100-" + paramInt + ")";
    AppMethodBeat.o(253695);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.pay.http.APPluginErrorCode
 * JD-Core Version:    0.7.0.1
 */