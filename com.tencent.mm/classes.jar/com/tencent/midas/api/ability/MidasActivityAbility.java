package com.tencent.midas.api.ability;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MidasActivityAbility
  extends MidasBaseAbility
{
  private static final String BUNDLE_PREFIX = "__midas_ability_activity__";
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
    AppMethodBeat.i(192877);
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
    AppMethodBeat.o(192877);
  }
  
  public Bundle toBundle()
  {
    AppMethodBeat.i(192876);
    Bundle localBundle = super.toBundle();
    localBundle.putString("__midas_ability_activity__payItem", this.payItem);
    localBundle.putString("__midas_ability_activity__area", this.area);
    localBundle.putString("__midas_ability_activity__platId", this.platId);
    localBundle.putString("__midas_ability_activity__partition", this.partition);
    localBundle.putString("__midas_ability_activity__roleId", this.roleId);
    localBundle.putString("__midas_ability_activity__roleName", this.roleName);
    localBundle.putString("__midas_ability_activity__action", this.action);
    localBundle.putString("__midas_ability_activity__sceneInfo", this.sceneInfo);
    if (this.shareInfo != null) {
      localBundle.putBundle("__midas_ability_activity__shareInfo", this.shareInfo.toBundle());
    }
    AppMethodBeat.o(192876);
    return localBundle;
  }
  
  public String toString()
  {
    AppMethodBeat.i(192878);
    String str = super.toString() + "|payItem=" + this.payItem + "|area=" + this.area + "|platId=" + this.platId + "|partition=" + this.partition + "|roleId=" + this.roleId + "|roleName=" + this.roleName + "|action=" + this.action + "|sceneInfo=" + this.sceneInfo + "|shareInfo=" + this.shareInfo;
    AppMethodBeat.o(192878);
    return str;
  }
  
  public static abstract class AbsQQShare
    extends MidasActivityAbility.AbsShare
  {
    public String arkJson = "";
    public boolean hideQzone = false;
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.hideQzone = paramBundle.getBoolean("__midas_ability_activity__" + AbsQQShare.class.getSimpleName() + "_hideQzone");
      this.arkJson = paramBundle.getString("__midas_ability_activity__" + AbsQQShare.class.getSimpleName() + "_arkJson");
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = super.toBundle();
      localBundle.putBoolean("__midas_ability_activity__" + AbsQQShare.class.getSimpleName() + "_hideQzone", this.hideQzone);
      localBundle.putString("__midas_ability_activity__" + AbsQQShare.class.getSimpleName() + "_arkJson", this.arkJson);
      return localBundle;
    }
    
    public String toString()
    {
      return super.toString() + "|hideQzone=" + this.hideQzone + "|arkJson=" + this.arkJson;
    }
  }
  
  public static abstract class AbsShare
    implements IMidasAbility
  {
    protected static final String TYPE_KEY = "shareType";
    protected static final int TYPE_QQ_MINIPROGRAM = 2;
    protected static final int TYPE_QQ_WEB = 1;
    protected static final int TYPE_WX_MINIPROGRAM = 4;
    protected static final int TYPE_WX_WEB = 3;
    
    public static AbsShare createChild(Bundle paramBundle)
    {
      switch (paramBundle.getInt("__midas_ability_activity__shareType"))
      {
      default: 
        return null;
      case 1: 
        localObject = new MidasActivityAbility.QQWebShare();
        ((MidasActivityAbility.QQWebShare)localObject).fromBundle(paramBundle);
        return localObject;
      case 2: 
        localObject = new MidasActivityAbility.QQMiniProgramShare();
        ((MidasActivityAbility.QQMiniProgramShare)localObject).fromBundle(paramBundle);
        return localObject;
      case 3: 
        localObject = new MidasActivityAbility.WXWebShare();
        ((MidasActivityAbility.WXWebShare)localObject).fromBundle(paramBundle);
        return localObject;
      }
      Object localObject = new MidasActivityAbility.WXMiniProgramShare();
      ((MidasActivityAbility.WXMiniProgramShare)localObject).fromBundle(paramBundle);
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
      return "shareType=" + type();
    }
    
    abstract int type();
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
      this.title = paramBundle.getString("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_title");
      this.description = paramBundle.getString("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_description");
      this.thumbData = paramBundle.getByteArray("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_thumbData");
      this.scene = paramBundle.getInt("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_scene");
      this.transaction = paramBundle.getString("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_transaction");
      this.userOpenId = paramBundle.getString("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_userOpenId");
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = super.toBundle();
      localBundle.putString("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_title", this.title);
      localBundle.putString("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_description", this.description);
      localBundle.putByteArray("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_thumbData", this.thumbData);
      localBundle.putInt("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_scene", this.scene);
      localBundle.putString("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_transaction", this.transaction);
      localBundle.putString("__midas_ability_activity__" + AbsWXShare.class.getSimpleName() + "_userOpenId", this.userOpenId);
      return localBundle;
    }
    
    public String toString()
    {
      return super.toString() + "|title=" + this.title + "|description=" + this.description + "|thumbData=" + this.thumbData + "|scene=" + this.scene + "|transaction=" + this.transaction + "|userOpenId=" + this.userOpenId;
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
      AppMethodBeat.i(192880);
      super.fromBundle(paramBundle);
      this.title = paramBundle.getString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_title");
      this.summary = paramBundle.getString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_summary");
      this.imageUrl = paramBundle.getString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_imageUrl");
      this.miniProgramType = paramBundle.getString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_miniProgramType");
      AppMethodBeat.o(192880);
    }
    
    public Bundle toBundle()
    {
      AppMethodBeat.i(192879);
      Bundle localBundle = super.toBundle();
      localBundle.putString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_title", this.title);
      localBundle.putString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_summary", this.summary);
      localBundle.putString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_imageUrl", this.imageUrl);
      localBundle.putString("__midas_ability_activity__" + QQMiniProgramShare.class.getSimpleName() + "_miniProgramType", this.miniProgramType);
      AppMethodBeat.o(192879);
      return localBundle;
    }
    
    public String toString()
    {
      AppMethodBeat.i(192881);
      String str = super.toString() + "|title=" + this.title + "|summary=" + this.summary + "|imageUrl=" + this.imageUrl + "|miniProgramType=" + this.miniProgramType;
      AppMethodBeat.o(192881);
      return str;
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
      AppMethodBeat.i(192883);
      super.fromBundle(paramBundle);
      this.title = paramBundle.getString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_title");
      this.summary = paramBundle.getString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_summary");
      this.imageUrl = paramBundle.getString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_imageUrl");
      this.appName = paramBundle.getString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_appName");
      AppMethodBeat.o(192883);
    }
    
    public Bundle toBundle()
    {
      AppMethodBeat.i(192882);
      Bundle localBundle = super.toBundle();
      localBundle.putString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_title", this.title);
      localBundle.putString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_summary", this.summary);
      localBundle.putString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_imageUrl", this.imageUrl);
      localBundle.putString("__midas_ability_activity__" + QQWebShare.class.getSimpleName() + "_appName", this.appName);
      AppMethodBeat.o(192882);
      return localBundle;
    }
    
    public String toString()
    {
      AppMethodBeat.i(192884);
      String str = super.toString() + "|title=" + this.title + "|summary=" + this.summary + "|imageUrl=" + this.imageUrl + "|appName=" + this.appName;
      AppMethodBeat.o(192884);
      return str;
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
      AppMethodBeat.i(192886);
      super.fromBundle(paramBundle);
      this.withShareTicket = paramBundle.getBoolean("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_withShareTicket");
      this.miniprogramType = paramBundle.getInt("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_miniprogramType");
      AppMethodBeat.o(192886);
    }
    
    public Bundle toBundle()
    {
      AppMethodBeat.i(192885);
      Bundle localBundle = super.toBundle();
      localBundle.putBoolean("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_withShareTicket", this.withShareTicket);
      localBundle.putInt("__midas_ability_activity__" + WXMiniProgramShare.class.getSimpleName() + "_miniprogramType", this.miniprogramType);
      AppMethodBeat.o(192885);
      return localBundle;
    }
    
    public String toString()
    {
      AppMethodBeat.i(192887);
      String str = super.toString() + "|withShareTicket=" + this.withShareTicket + "|miniprogramType=" + this.miniprogramType;
      AppMethodBeat.o(192887);
      return str;
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
      AppMethodBeat.i(192889);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(192889);
    }
    
    public Bundle toBundle()
    {
      AppMethodBeat.i(192888);
      Bundle localBundle = super.toBundle();
      AppMethodBeat.o(192888);
      return localBundle;
    }
    
    public String toString()
    {
      AppMethodBeat.i(192890);
      String str = super.toString();
      AppMethodBeat.o(192890);
      return str;
    }
    
    public int type()
    {
      return 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility
 * JD-Core Version:    0.7.0.1
 */