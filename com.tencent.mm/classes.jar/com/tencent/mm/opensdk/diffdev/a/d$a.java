package com.tencent.mm.opensdk.diffdev.a;

import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

final class d$a
{
  public OAuthErrCode n;
  public String o;
  public String p;
  public String q;
  public int r;
  public String s;
  public byte[] t;
  
  public static a a(byte[] paramArrayOfByte)
  {
    a locala = new a();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
      locala.n = OAuthErrCode.WechatAuth_Err_NetworkErr;
      return locala;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte);
        int i = paramArrayOfByte.getInt("errcode");
        if (i != 0)
        {
          Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[] { Integer.valueOf(i) }));
          locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
          locala.r = i;
          locala.s = paramArrayOfByte.optString("errmsg");
          return locala;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
        locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
        return locala;
      }
      localObject = paramArrayOfByte.getJSONObject("qrcode").getString("qrcodebase64");
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
      locala.n = OAuthErrCode.WechatAuth_Err_NormalErr;
      return locala;
    }
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
      locala.n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
      return locala;
    }
    Object localObject = Base64.decode((String)localObject, 0);
    if ((localObject == null) || (localObject.length == 0))
    {
      Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
      locala.n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
      return locala;
    }
    locala.n = OAuthErrCode.WechatAuth_Err_OK;
    locala.t = ((byte[])localObject);
    locala.o = paramArrayOfByte.getString("uuid");
    locala.p = paramArrayOfByte.getString("appname");
    Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[] { locala.o, locala.p, Integer.valueOf(locala.t.length) }));
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.d.a
 * JD-Core Version:    0.7.0.1
 */