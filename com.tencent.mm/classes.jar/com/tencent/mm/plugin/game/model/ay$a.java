package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

public final class ay$a
{
  public String SNGAppId;
  public String actionFlag;
  public String kRD;
  public String taskApkId;
  public String taskAppId;
  public String taskPackageName;
  public int taskVersion;
  public String uin;
  public String uinType;
  public String via;
  
  public final TMQQDownloaderOpenSDKParam EN(String paramString)
  {
    y.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", new Object[] { paramString });
    if (bk.bl(paramString)) {
      y.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
    }
    for (;;)
    {
      return new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.kRD, this.actionFlag);
      try
      {
        paramString = new JSONObject(paramString);
        this.taskApkId = paramString.optString("taskApkId");
        this.via = paramString.optString("via");
        this.taskVersion = paramString.optInt("taskVersion");
        this.kRD = paramString.optString("channelID");
        this.uin = paramString.optString("uin");
        this.SNGAppId = paramString.optString("SNGAppId");
        this.taskAppId = paramString.optString("taskAppId");
        this.uinType = paramString.optString("uinType");
        this.taskPackageName = paramString.optString("taskPackageName");
        this.actionFlag = paramString.optString("actionFlag");
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", new Object[] { paramString.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ay.a
 * JD-Core Version:    0.7.0.1
 */