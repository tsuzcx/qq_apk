package com.tencent.mobileqq.portal;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PortalManager$PortalConfig
  extends PortalManager.TimerConfig
{
  public long UiTime;
  public String actionUrl;
  public String awardOverWording;
  public String awardWording;
  public String hitWording;
  public String iconMd5;
  public String iconUrl;
  public int id;
  public String logoMd5;
  public String logoUrl;
  public long realBegin;
  public long realEnd;
  public String running;
  public String summary;
  public String timeWording;
  public String tipsIconMd5;
  public String tipsIconUrl;
  public String title;
  public int useFlag;
  public String webAwardOver;
  public String webComName;
  public String webGreetings;
  public String webLogo;
  public String webLogoJump;
  public String wording;
  
  public PortalManager$PortalConfig()
  {
    super(null);
  }
  
  public String createJsonObj()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Id", this.id).put("Begin", this.uiBegin).put("End", this.uiEnd).put("IconImg", this.iconUrl).put("IconMd5", this.iconMd5).put("Wording", this.wording).put("PortalJumpH5", this.actionUrl).put("HitWording", this.hitWording).put("TipsImg", this.tipsIconUrl).put("Running", this.running).put("TipsMd5", this.tipsIconMd5).put("LogoImg", this.logoUrl).put("LogoMd5", this.logoMd5).put("AwardWording", this.awardWording).put("AwardOverWording", this.awardOverWording).put("Title", this.title).put("Summary", this.summary).put("TimeWording", this.timeWording).put("HasNext", "$last$").put("WebLogo", this.webLogo).put("WebComName", this.webComName).put("WebLogoJump", this.webLogoJump).put("WebGreetings", this.webGreetings).put("WebAwardOver", this.webAwardOver);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PortalManager", 2, "", localJSONException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.PortalConfig
 * JD-Core Version:    0.7.0.1
 */