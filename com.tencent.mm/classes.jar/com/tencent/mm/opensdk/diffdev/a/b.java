package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

public class b
  extends AsyncTask<Void, Void, a>
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private OAuthListener f;
  private c g;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    AppMethodBeat.i(196931);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramOAuthListener;
    AppMethodBeat.o(196931);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(196932);
    Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
    c localc = this.g;
    if (localc == null)
    {
      bool = cancel(true);
      AppMethodBeat.o(196932);
      return bool;
    }
    boolean bool = localc.cancel(true);
    AppMethodBeat.o(196932);
    return bool;
  }
  
  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(196934);
    Thread.currentThread().setName("OpenSdkGetQRCodeTask");
    Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
    paramArrayOfObject = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", new Object[] { this.a, this.c, this.d, this.b, this.e });
    long l = System.currentTimeMillis();
    byte[] arrayOfByte = a.a(paramArrayOfObject, 60000);
    Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", new Object[] { paramArrayOfObject, Long.valueOf(System.currentTimeMillis() - l) }));
    paramArrayOfObject = a.a(arrayOfByte);
    AppMethodBeat.o(196934);
    return paramArrayOfObject;
  }
  
  protected void onPostExecute(Object paramObject)
  {
    AppMethodBeat.i(196933);
    paramObject = (a)paramObject;
    OAuthErrCode localOAuthErrCode = paramObject.a;
    if (localOAuthErrCode == OAuthErrCode.WechatAuth_Err_OK)
    {
      Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + paramObject.e.length);
      this.f.onAuthGotQrcode(paramObject.d, paramObject.e);
      paramObject = new c(paramObject.b, this.f);
      this.g = paramObject;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramObject.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        AppMethodBeat.o(196933);
        return;
      }
      paramObject.execute(new Void[0]);
      AppMethodBeat.o(196933);
      return;
    }
    Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", new Object[] { localOAuthErrCode }));
    this.f.onAuthFinish(paramObject.a, null);
    AppMethodBeat.o(196933);
  }
  
  static class a
  {
    public OAuthErrCode a;
    public String b;
    public String c;
    public String d;
    public byte[] e;
    
    public static a a(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(196994);
      a locala = new a();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
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
              locala.a = OAuthErrCode.WechatAuth_Err_NormalErr;
              paramArrayOfByte.optString("errmsg");
              AppMethodBeat.o(196994);
              return locala;
            }
            Object localObject = paramArrayOfByte.getJSONObject("qrcode").getString("qrcodebase64");
            if ((localObject != null) && (((String)localObject).length() != 0))
            {
              localObject = Base64.decode((String)localObject, 0);
              if ((localObject != null) && (localObject.length != 0))
              {
                locala.a = OAuthErrCode.WechatAuth_Err_OK;
                locala.e = ((byte[])localObject);
                locala.b = paramArrayOfByte.getString("uuid");
                paramArrayOfByte = paramArrayOfByte.getString("appname");
                locala.c = paramArrayOfByte;
                Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[] { locala.b, paramArrayOfByte, Integer.valueOf(locala.e.length) }));
                AppMethodBeat.o(196994);
                return locala;
              }
              Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
              locala.a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
              AppMethodBeat.o(196994);
              return locala;
            }
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
            locala.a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
            AppMethodBeat.o(196994);
            return locala;
          }
          catch (Exception paramArrayOfByte)
          {
            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
            locala.a = OAuthErrCode.WechatAuth_Err_NormalErr;
            AppMethodBeat.o(196994);
            return locala;
          }
          Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
        }
        catch (Exception paramArrayOfByte)
        {
          Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfByte.getMessage() }));
          locala.a = OAuthErrCode.WechatAuth_Err_NormalErr;
          AppMethodBeat.o(196994);
          return locala;
        }
      }
      locala.a = OAuthErrCode.WechatAuth_Err_NetworkErr;
      AppMethodBeat.o(196994);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.b
 * JD-Core Version:    0.7.0.1
 */