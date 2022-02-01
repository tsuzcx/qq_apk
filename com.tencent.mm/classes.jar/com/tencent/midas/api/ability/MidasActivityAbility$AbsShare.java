package com.tencent.midas.api.ability;

import android.os.Bundle;

public abstract class MidasActivityAbility$AbsShare
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility.AbsShare
 * JD-Core Version:    0.7.0.1
 */