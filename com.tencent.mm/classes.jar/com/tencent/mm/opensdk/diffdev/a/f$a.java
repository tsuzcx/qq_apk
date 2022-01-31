package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

final class f$a
{
  public OAuthErrCode n;
  public String v;
  public int w;
  
  public static a b(byte[] paramArrayOfByte)
  {
    a locala = new a();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
      locala.n = OAuthErrCode.WechatAuth_Err_NetworkErr;
      return locala;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        try
        {
          paramArrayOfByte = new JSONObject(paramArrayOfByte);
          locala.w = paramArrayOfByte.getInt("wx_errcode");
          Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[] { Integer.valueOf(locala.w) }));
          switch (locala.w)
          {
          case 405: 
            locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
            return locala;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
          locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
          return locala;
        }
        locala.n = OAuthErrCode.WechatAuth_Err_OK;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
        locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
        return locala;
      }
      locala.v = paramArrayOfByte.getString("wx_code");
      return locala;
      locala.n = OAuthErrCode.WechatAuth_Err_OK;
      return locala;
      locala.n = OAuthErrCode.WechatAuth_Err_OK;
      return locala;
      locala.n = OAuthErrCode.WechatAuth_Err_Timeout;
      return locala;
      locala.n = OAuthErrCode.WechatAuth_Err_Cancel;
      return locala;
      locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.f.a
 * JD-Core Version:    0.7.0.1
 */