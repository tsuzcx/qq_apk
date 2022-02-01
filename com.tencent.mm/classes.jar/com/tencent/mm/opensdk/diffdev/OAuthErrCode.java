package com.tencent.mm.opensdk.diffdev;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum OAuthErrCode
{
  private int code;
  
  static
  {
    AppMethodBeat.i(3748);
    WechatAuth_Err_OK = new OAuthErrCode("WechatAuth_Err_OK", 0, 0);
    WechatAuth_Err_NormalErr = new OAuthErrCode("WechatAuth_Err_NormalErr", 1, -1);
    WechatAuth_Err_NetworkErr = new OAuthErrCode("WechatAuth_Err_NetworkErr", 2, -2);
    WechatAuth_Err_JsonDecodeErr = new OAuthErrCode("WechatAuth_Err_JsonDecodeErr", 3, -3);
    WechatAuth_Err_Cancel = new OAuthErrCode("WechatAuth_Err_Cancel", 4, -4);
    WechatAuth_Err_Timeout = new OAuthErrCode("WechatAuth_Err_Timeout", 5, -5);
    OAuthErrCode localOAuthErrCode = new OAuthErrCode("WechatAuth_Err_Auth_Stopped", 6, -6);
    WechatAuth_Err_Auth_Stopped = localOAuthErrCode;
    $VALUES = new OAuthErrCode[] { WechatAuth_Err_OK, WechatAuth_Err_NormalErr, WechatAuth_Err_NetworkErr, WechatAuth_Err_JsonDecodeErr, WechatAuth_Err_Cancel, WechatAuth_Err_Timeout, localOAuthErrCode };
    AppMethodBeat.o(3748);
  }
  
  private OAuthErrCode(int paramInt)
  {
    AppMethodBeat.i(190398);
    this.code = paramInt;
    AppMethodBeat.o(190398);
  }
  
  public final int getCode()
  {
    return this.code;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(3747);
    String str = "OAuthErrCode:" + this.code;
    AppMethodBeat.o(3747);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.OAuthErrCode
 * JD-Core Version:    0.7.0.1
 */