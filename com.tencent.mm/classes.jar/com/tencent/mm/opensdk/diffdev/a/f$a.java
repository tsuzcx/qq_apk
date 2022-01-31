package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(128046);
    a locala = new a();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
      locala.n = OAuthErrCode.WechatAuth_Err_NetworkErr;
      AppMethodBeat.o(128046);
      return locala;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        locala.n = OAuthErrCode.WechatAuth_Err_OK;
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          paramArrayOfByte = new JSONObject(paramArrayOfByte);
          locala.w = paramArrayOfByte.getInt("wx_errcode");
          Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[] { Integer.valueOf(locala.w) }));
          switch (locala.w)
          {
          case 405: 
            locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
            AppMethodBeat.o(128046);
            return locala;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
          locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
          AppMethodBeat.o(128046);
          return locala;
        }
        paramArrayOfByte = paramArrayOfByte;
        Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
        locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
        AppMethodBeat.o(128046);
        return locala;
      }
      locala.v = paramArrayOfByte.getString("wx_code");
      continue;
      locala.n = OAuthErrCode.WechatAuth_Err_OK;
      continue;
      locala.n = OAuthErrCode.WechatAuth_Err_OK;
      continue;
      locala.n = OAuthErrCode.WechatAuth_Err_Timeout;
      continue;
      locala.n = OAuthErrCode.WechatAuth_Err_Cancel;
      continue;
      locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.f.a
 * JD-Core Version:    0.7.0.1
 */