package com.tencent.midas.api.ability;

import android.os.Bundle;

public abstract class MidasActivityAbility$AbsQQShare
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility.AbsQQShare
 * JD-Core Version:    0.7.0.1
 */