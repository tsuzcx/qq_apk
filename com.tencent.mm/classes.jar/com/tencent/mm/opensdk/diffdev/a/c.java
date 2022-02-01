package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

class c
  extends AsyncTask<Void, Void, a>
{
  private String a;
  private String b;
  private OAuthListener c;
  private int d;
  
  public c(String paramString, OAuthListener paramOAuthListener)
  {
    AppMethodBeat.i(190422);
    this.a = paramString;
    this.c = paramOAuthListener;
    this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[] { paramString });
    AppMethodBeat.o(190422);
  }
  
  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(190424);
    Thread.currentThread().setName("OpenSdkNoopingTask");
    paramArrayOfObject = this.a;
    Object localObject;
    label86:
    String str;
    long l1;
    long l2;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length() != 0))
    {
      Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
      if (!isCancelled())
      {
        localObject = new StringBuilder().append(this.b);
        if (this.d == 0)
        {
          paramArrayOfObject = "";
          str = paramArrayOfObject;
          l1 = System.currentTimeMillis();
          paramArrayOfObject = a.a(str, 60000);
          l2 = System.currentTimeMillis();
          localObject = new a();
          Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
          if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
            break label483;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfObject = new String(paramArrayOfObject, "utf-8");
      }
      catch (Exception paramArrayOfObject)
      {
        int i;
        Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", new Object[] { paramArrayOfObject.getMessage() }));
        ((a)localObject).a = OAuthErrCode.WechatAuth_Err_NormalErr;
        continue;
      }
      try
      {
        paramArrayOfObject = new JSONObject(paramArrayOfObject);
        i = paramArrayOfObject.getInt("wx_errcode");
        ((a)localObject).c = i;
        Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[] { Integer.valueOf(i) }));
        i = ((a)localObject).c;
        if (i == 408) {
          continue;
        }
        if (i != 500) {}
        switch (i)
        {
        case 405: 
          paramArrayOfObject = OAuthErrCode.WechatAuth_Err_NormalErr;
        }
      }
      catch (Exception paramArrayOfObject)
      {
        Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", new Object[] { paramArrayOfObject.getMessage() }));
        ((a)localObject).a = OAuthErrCode.WechatAuth_Err_NormalErr;
        continue;
        paramArrayOfObject = OAuthErrCode.WechatAuth_Err_Cancel;
        continue;
        paramArrayOfObject = OAuthErrCode.WechatAuth_Err_Timeout;
        continue;
        paramArrayOfObject = OAuthErrCode.WechatAuth_Err_OK;
        continue;
      }
      ((a)localObject).a = paramArrayOfObject;
      Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[] { str, ((a)localObject).a.toString(), Integer.valueOf(((a)localObject).c), Long.valueOf(l2 - l1) }));
      paramArrayOfObject = ((a)localObject).a;
      if (paramArrayOfObject == OAuthErrCode.WechatAuth_Err_OK)
      {
        i = ((a)localObject).c;
        this.d = i;
        if (i == d.d.a())
        {
          this.c.onQrcodeScanned();
          break;
          paramArrayOfObject = "&last=" + this.d;
          break label86;
          ((a)localObject).a = OAuthErrCode.WechatAuth_Err_OK;
          ((a)localObject).b = paramArrayOfObject.getString("wx_code");
          continue;
          label483:
          Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
          ((a)localObject).a = OAuthErrCode.WechatAuth_Err_NetworkErr;
          continue;
        }
        if ((((a)localObject).c == d.f.a()) || (((a)localObject).c != d.e.a())) {
          break;
        }
        paramArrayOfObject = ((a)localObject).b;
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length() != 0)) {
          break label659;
        }
        Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
        ((a)localObject).a = OAuthErrCode.WechatAuth_Err_NormalErr;
        paramArrayOfObject = (Object[])localObject;
      }
      for (;;)
      {
        AppMethodBeat.o(190424);
        return paramArrayOfObject;
        Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[] { paramArrayOfObject.toString(), Integer.valueOf(((a)localObject).c) }));
        paramArrayOfObject = (Object[])localObject;
        continue;
        Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        paramArrayOfObject = new a();
        paramArrayOfObject.a = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        continue;
        Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
        paramArrayOfObject = new a();
        paramArrayOfObject.a = OAuthErrCode.WechatAuth_Err_NormalErr;
        continue;
        label659:
        paramArrayOfObject = (Object[])localObject;
      }
    }
  }
  
  protected void onPostExecute(Object paramObject)
  {
    AppMethodBeat.i(190423);
    paramObject = (a)paramObject;
    this.c.onAuthFinish(paramObject.a, paramObject.b);
    AppMethodBeat.o(190423);
  }
  
  static class a
  {
    public OAuthErrCode a;
    public String b;
    public int c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.c
 * JD-Core Version:    0.7.0.1
 */