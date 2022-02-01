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
  public MidasActivityAbility.AbsShare shareInfo;
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(253492);
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
      this.shareInfo = MidasActivityAbility.AbsShare.createChild(paramBundle);
    }
    AppMethodBeat.o(253492);
  }
  
  public Bundle toBundle()
  {
    AppMethodBeat.i(253490);
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
    AppMethodBeat.o(253490);
    return localBundle;
  }
  
  public String toString()
  {
    AppMethodBeat.i(253493);
    String str = super.toString() + "|payItem=" + this.payItem + "|area=" + this.area + "|platId=" + this.platId + "|partition=" + this.partition + "|roleId=" + this.roleId + "|roleName=" + this.roleName + "|action=" + this.action + "|sceneInfo=" + this.sceneInfo + "|shareInfo=" + this.shareInfo;
    AppMethodBeat.o(253493);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.api.ability.MidasActivityAbility
 * JD-Core Version:    0.7.0.1
 */