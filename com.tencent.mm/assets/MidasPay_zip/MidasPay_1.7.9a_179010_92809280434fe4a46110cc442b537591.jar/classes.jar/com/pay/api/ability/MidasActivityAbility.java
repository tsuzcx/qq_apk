package com.pay.api.ability;

import android.os.Bundle;

public class MidasActivityAbility
  extends MidasBaseAbility
{
  public String action;
  public String area;
  public String partition;
  public String payItem;
  public String platId;
  public String roleId;
  public String roleName;
  public String sceneInfo;
  public AbsShare shareInfo;
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.payItem = paramBundle.getString("__midas_ability_activity__payItem");
    this.area = paramBundle.getString("__midas_ability_activity__area");
    this.platId = paramBundle.getString("__midas_ability_activity__platId");
    this.partition = paramBundle.getString("__midas_ability_activity__partition");
    this.roleId = paramBundle.getString("__midas_ability_activity__roleId");
    this.roleName = paramBundle.getString("__midas_ability_activity__roleName");
    this.action = paramBundle.getString("__midas_ability_activity__action");
    this.sceneInfo = paramBundle.getString("__midas_ability_activity__sceneInfo");
    paramBundle = paramBundle.getBundle("__midas_ability_activity__shareInfo");
    if (paramBundle != null) {
      this.shareInfo = AbsShare.createChild(paramBundle);
    }
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = super.toBundle();
    localBundle.putString("__midas_ability_activity__payItem", this.payItem);
    localBundle.putString("__midas_ability_activity__area", this.area);
    localBundle.putString("__midas_ability_activity__platId", this.platId);
    localBundle.putString("__midas_ability_activity__partition", this.partition);
    localBundle.putString("__midas_ability_activity__roleId", this.roleId);
    localBundle.putString("__midas_ability_activity__roleName", this.roleName);
    localBundle.putString("__midas_ability_activity__action", this.action);
    localBundle.putString("__midas_ability_activity__sceneInfo", this.sceneInfo);
    AbsShare localAbsShare = this.shareInfo;
    if (localAbsShare != null) {
      localBundle.putBundle("__midas_ability_activity__shareInfo", localAbsShare.toBundle());
    }
    return localBundle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("|payItem=");
    localStringBuilder.append(this.payItem);
    localStringBuilder.append("|area=");
    localStringBuilder.append(this.area);
    localStringBuilder.append("|platId=");
    localStringBuilder.append(this.platId);
    localStringBuilder.append("|partition=");
    localStringBuilder.append(this.partition);
    localStringBuilder.append("|roleId=");
    localStringBuilder.append(this.roleId);
    localStringBuilder.append("|roleName=");
    localStringBuilder.append(this.roleName);
    localStringBuilder.append("|action=");
    localStringBuilder.append(this.action);
    localStringBuilder.append("|sceneInfo=");
    localStringBuilder.append(this.sceneInfo);
    localStringBuilder.append("|shareInfo=");
    localStringBuilder.append(this.shareInfo);
    return localStringBuilder.toString();
  }
  
  public static abstract class AbsQQShare
    extends MidasActivityAbility.AbsShare
  {
    public String arkJson = "";
    public boolean hideQzone = false;
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsQQShare.class.getSimpleName());
      localStringBuilder.append("_hideQzone");
      this.hideQzone = paramBundle.getBoolean(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsQQShare.class.getSimpleName());
      localStringBuilder.append("_arkJson");
      this.arkJson = paramBundle.getString(localStringBuilder.toString());
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = super.toBundle();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsQQShare.class.getSimpleName());
      localStringBuilder.append("_hideQzone");
      localBundle.putBoolean(localStringBuilder.toString(), this.hideQzone);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsQQShare.class.getSimpleName());
      localStringBuilder.append("_arkJson");
      localBundle.putString(localStringBuilder.toString(), this.arkJson);
      return localBundle;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("|hideQzone=");
      localStringBuilder.append(this.hideQzone);
      localStringBuilder.append("|arkJson=");
      localStringBuilder.append(this.arkJson);
      return localStringBuilder.toString();
    }
  }
  
  public static abstract class AbsShare
    implements IMidasAbility
  {
    public static AbsShare createChild(Bundle paramBundle)
    {
      int i = paramBundle.getInt("__midas_ability_activity__shareType");
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return null;
            }
            localObject = new MidasActivityAbility.WXMiniProgramShare();
            ((MidasActivityAbility.WXMiniProgramShare)localObject).fromBundle(paramBundle);
            return localObject;
          }
          localObject = new MidasActivityAbility.WXWebShare();
          ((MidasActivityAbility.WXWebShare)localObject).fromBundle(paramBundle);
          return localObject;
        }
        localObject = new MidasActivityAbility.QQMiniProgramShare();
        ((MidasActivityAbility.QQMiniProgramShare)localObject).fromBundle(paramBundle);
        return localObject;
      }
      Object localObject = new MidasActivityAbility.QQWebShare();
      ((MidasActivityAbility.QQWebShare)localObject).fromBundle(paramBundle);
      return localObject;
    }
    
    public void fromBundle(Bundle paramBundle) {}
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("__midas_ability_activity__shareType", type());
      return localBundle;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareType=");
      localStringBuilder.append(type());
      return localStringBuilder.toString();
    }
    
    public abstract int type();
  }
  
  public static abstract class AbsWXShare
    extends MidasActivityAbility.AbsShare
  {
    public String description = "";
    public int scene = 0;
    public byte[] thumbData = null;
    public String title = "";
    public String transaction = "";
    public String userOpenId = "";
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_title");
      this.title = paramBundle.getString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_description");
      this.description = paramBundle.getString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_thumbData");
      this.thumbData = paramBundle.getByteArray(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_scene");
      this.scene = paramBundle.getInt(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_transaction");
      this.transaction = paramBundle.getString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_userOpenId");
      this.userOpenId = paramBundle.getString(localStringBuilder.toString());
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = super.toBundle();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_title");
      localBundle.putString(localStringBuilder.toString(), this.title);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_description");
      localBundle.putString(localStringBuilder.toString(), this.description);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_thumbData");
      localBundle.putByteArray(localStringBuilder.toString(), this.thumbData);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_scene");
      localBundle.putInt(localStringBuilder.toString(), this.scene);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_transaction");
      localBundle.putString(localStringBuilder.toString(), this.transaction);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(AbsWXShare.class.getSimpleName());
      localStringBuilder.append("_userOpenId");
      localBundle.putString(localStringBuilder.toString(), this.userOpenId);
      return localBundle;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("|title=");
      localStringBuilder.append(this.title);
      localStringBuilder.append("|description=");
      localStringBuilder.append(this.description);
      localStringBuilder.append("|thumbData=");
      localStringBuilder.append(this.thumbData);
      localStringBuilder.append("|scene=");
      localStringBuilder.append(this.scene);
      localStringBuilder.append("|transaction=");
      localStringBuilder.append(this.transaction);
      localStringBuilder.append("|userOpenId=");
      localStringBuilder.append(this.userOpenId);
      return localStringBuilder.toString();
    }
  }
  
  public static class QQMiniProgramShare
    extends MidasActivityAbility.AbsQQShare
  {
    public String imageUrl;
    public String miniProgramType;
    public String summary;
    public String title;
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_title");
      this.title = paramBundle.getString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_summary");
      this.summary = paramBundle.getString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_imageUrl");
      this.imageUrl = paramBundle.getString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_miniProgramType");
      this.miniProgramType = paramBundle.getString(localStringBuilder.toString());
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = super.toBundle();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_title");
      localBundle.putString(localStringBuilder.toString(), this.title);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_summary");
      localBundle.putString(localStringBuilder.toString(), this.summary);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_imageUrl");
      localBundle.putString(localStringBuilder.toString(), this.imageUrl);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_miniProgramType");
      localBundle.putString(localStringBuilder.toString(), this.miniProgramType);
      return localBundle;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("|title=");
      localStringBuilder.append(this.title);
      localStringBuilder.append("|summary=");
      localStringBuilder.append(this.summary);
      localStringBuilder.append("|imageUrl=");
      localStringBuilder.append(this.imageUrl);
      localStringBuilder.append("|miniProgramType=");
      localStringBuilder.append(this.miniProgramType);
      return localStringBuilder.toString();
    }
    
    public int type()
    {
      return 2;
    }
  }
  
  public static class QQWebShare
    extends MidasActivityAbility.AbsQQShare
  {
    public String appName;
    public String imageUrl;
    public String summary;
    public String title;
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQWebShare.class.getSimpleName());
      localStringBuilder.append("_title");
      this.title = paramBundle.getString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQWebShare.class.getSimpleName());
      localStringBuilder.append("_summary");
      this.summary = paramBundle.getString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQWebShare.class.getSimpleName());
      localStringBuilder.append("_imageUrl");
      this.imageUrl = paramBundle.getString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQWebShare.class.getSimpleName());
      localStringBuilder.append("_appName");
      this.appName = paramBundle.getString(localStringBuilder.toString());
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = super.toBundle();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQWebShare.class.getSimpleName());
      localStringBuilder.append("_title");
      localBundle.putString(localStringBuilder.toString(), this.title);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQWebShare.class.getSimpleName());
      localStringBuilder.append("_summary");
      localBundle.putString(localStringBuilder.toString(), this.summary);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQWebShare.class.getSimpleName());
      localStringBuilder.append("_imageUrl");
      localBundle.putString(localStringBuilder.toString(), this.imageUrl);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(QQWebShare.class.getSimpleName());
      localStringBuilder.append("_appName");
      localBundle.putString(localStringBuilder.toString(), this.appName);
      return localBundle;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("|title=");
      localStringBuilder.append(this.title);
      localStringBuilder.append("|summary=");
      localStringBuilder.append(this.summary);
      localStringBuilder.append("|imageUrl=");
      localStringBuilder.append(this.imageUrl);
      localStringBuilder.append("|appName=");
      localStringBuilder.append(this.appName);
      return localStringBuilder.toString();
    }
    
    public int type()
    {
      return 1;
    }
  }
  
  public static class WXMiniProgramShare
    extends MidasActivityAbility.AbsWXShare
  {
    public int miniprogramType;
    public boolean withShareTicket;
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(WXMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_withShareTicket");
      this.withShareTicket = paramBundle.getBoolean(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(WXMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_miniprogramType");
      this.miniprogramType = paramBundle.getInt(localStringBuilder.toString());
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = super.toBundle();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(WXMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_withShareTicket");
      localBundle.putBoolean(localStringBuilder.toString(), this.withShareTicket);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("__midas_ability_activity__");
      localStringBuilder.append(WXMiniProgramShare.class.getSimpleName());
      localStringBuilder.append("_miniprogramType");
      localBundle.putInt(localStringBuilder.toString(), this.miniprogramType);
      return localBundle;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append("|withShareTicket=");
      localStringBuilder.append(this.withShareTicket);
      localStringBuilder.append("|miniprogramType=");
      localStringBuilder.append(this.miniprogramType);
      return localStringBuilder.toString();
    }
    
    public int type()
    {
      return 4;
    }
  }
  
  public static class WXWebShare
    extends MidasActivityAbility.AbsWXShare
  {
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
    }
    
    public Bundle toBundle()
    {
      return super.toBundle();
    }
    
    public String toString()
    {
      return super.toString();
    }
    
    public int type()
    {
      return 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.api.ability.MidasActivityAbility
 * JD-Core Version:    0.7.0.1
 */