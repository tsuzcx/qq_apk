package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Environment;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

public final class d
  extends AsyncTask<Void, Void, d.a>
{
  private static final String h = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png";
  private static String i = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
  private String appId;
  private String j;
  private String k;
  private OAuthListener l;
  private f m;
  private String scope;
  private String signature;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    this.appId = paramString1;
    this.scope = paramString2;
    this.j = paramString3;
    this.k = paramString4;
    this.signature = paramString5;
    this.l = paramOAuthListener;
  }
  
  public final boolean a()
  {
    Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
    if (this.m == null) {
      return cancel(true);
    }
    return this.m.cancel(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.d
 * JD-Core Version:    0.7.0.1
 */