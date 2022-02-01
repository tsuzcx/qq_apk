package com.tencent.midas.api.ability;

import android.os.Bundle;

public abstract class MidasActivityAbility$AbsWXShare
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility.AbsWXShare
 * JD-Core Version:    0.7.0.1
 */